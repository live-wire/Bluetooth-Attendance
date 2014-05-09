package com.example.android.BluetoothChat;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class BlackListedStd extends Activity{
	SQLiteDatabase database;
	DataBaseHelper databaseHelper;
	Context contextM=this;
	SimpleCursorAdapter adapter;
	private Cursor cursor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blackliststudent);
		 databaseHelper=new DataBaseHelper(contextM);
		 try{
			 
			 open(); 
			 cursor=database.rawQuery("SELECT * FROM table_attendence WHERE "+DataBaseHelper.STD_ID+" < 10 ", null);
			    cursor.moveToFirst();
			   Toast.makeText(getApplicationContext(), ""+cursor.getCount(),Toast.LENGTH_SHORT).show();
 }catch(Exception e ){
			 
		 }
		 
			 ListView listViews=(ListView)findViewById(R.id.lstB);
				String[] froms=new String[]{DataBaseHelper.STD_ID,DataBaseHelper.ATTENDENCE,DataBaseHelper.STD_BRANCH,DataBaseHelper.STD_SEM};
				adapter=new SimpleCursorAdapter(BlackListedStd.this, R.layout.tittle_of_blacklist, cursor, froms, new int[]{R.id.txtIdBn,R.id.txtAttenBn,R.id.txtSemBn,R.id.txtBRanchBn});
				listViews.setAdapter(adapter);
				close();
		
		
	}
	public void open() {
		database = databaseHelper.getWritableDatabase();
	}
	public void close() {
		databaseHelper.close();
	}
}
