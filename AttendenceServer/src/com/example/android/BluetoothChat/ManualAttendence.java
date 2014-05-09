package com.example.android.BluetoothChat;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ManualAttendence extends Activity{
EditText edtStdId,edtAttendence;
Button btnSetAtten;
SQLiteDatabase database;
DataBaseHelper databaseHelper;
Context contextM=this;
Spinner spinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manual_attendece);
	       databaseHelper=new DataBaseHelper(contextM);
	       spinner=(Spinner)findViewById(R.id.spinnerAttendence);
		edtStdId=(EditText)findViewById(R.id.edtStdIdMa);
		//edtAttendence=(EditText)findViewById(R.id.edtAttendenceMa);
		btnSetAtten=(Button)findViewById(R.id.btnSetAttendence);
		btnSetAtten.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
			    	open();
			    
			    	String date=HomeForServer.datess;//"12";
			    	String month=HomeForServer.monthss;//"jan";
		    //	String student_id=attendence.substring(0, 3);//"100";
//			    	attendence=attendence.substring(3, attendence.length());
			    	String manualA="Manually";

					ContentValues values=new ContentValues();
					
					//values.put(DataBaseHelper.ATTENDENCE, edtAttendence.getText().toString());
					values.put(DataBaseHelper.ATTENDENCE, String.valueOf(spinner.getSelectedItem()));
					values.put(DataBaseHelper.DATE, date);
					values.put(DataBaseHelper.MONTH, month);
					values.put(DataBaseHelper.STD_BRANCH, HomeForServer.branch);
					values.put(DataBaseHelper.STD_SEM, HomeForServer.semestar);
					values.put(DataBaseHelper.STD_SUBJECT, HomeForServer.subject);
					values.put(DataBaseHelper.STD_ID, edtStdId.getText().toString());
					
					values.put(DataBaseHelper.MOBILE_NAME, manualA);
					
					long insertId=database.insert(DataBaseHelper.TABLE_ATTENDENCE, null, values);
					//System.out.println("Check");
					Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_LONG).show();
					close();
					edtAttendence.setText("");
					edtStdId.setText("");
			    	}
			    	catch (Exception e){
			    		
			    		
			    	}
			}
		});
		
	}
	 public void open() {
			database = databaseHelper.getWritableDatabase();
		}
		public void close() {
			databaseHelper.close();
		}
	
}
