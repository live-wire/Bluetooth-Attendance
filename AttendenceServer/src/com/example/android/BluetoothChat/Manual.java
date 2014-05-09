package com.example.android.BluetoothChat;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Manual extends Activity{
	SQLiteDatabase database;
	DataBaseHelper databaseHelper;
	SimpleCursorAdapter adaptor;
	Context contextGE=this;
	Cursor c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manual);
		databaseHelper=new DataBaseHelper(contextGE);
		try{
			open();
			c=database.rawQuery("SELECT * FROM table_attendence", null);
		    c.moveToFirst();
		   // String s=c.getString(1);
		   // Toast.makeText(getApplicationContext(), "Cooming Soon"+c.getCount()+s, Toast.LENGTH_LONG).show();
		}
		catch(Exception e){
		}
		ListView listView=(ListView)findViewById(R.id.lstattendence);
		String[] from=new String[]{DataBaseHelper.STD_ID,DataBaseHelper.ATTENDENCE,DataBaseHelper.MOBILE_NAME,DataBaseHelper.DATE,DataBaseHelper.MONTH,DataBaseHelper.STD_BRANCH,DataBaseHelper.STD_SEM,DataBaseHelper.STD_SUBJECT};
		adaptor=new SimpleCursorAdapter(Manual.this, R.layout.title_of_mamual, c, from, new int[]{R.id.txtStdId,R.id.txtPresent,R.id.txtMobile,R.id.txtDate,R.id.txtMonth,R.id.branchT,R.id.semT,R.id.subjectT});
		listView.setAdapter(adaptor);
	}
	public void open() {
		database = databaseHelper.getWritableDatabase();
	}
	public void close() {
		databaseHelper.close();
	}

}
