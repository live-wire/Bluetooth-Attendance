package com.example.android.BluetoothChat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportHome extends Activity{
Button btnfindAtte,btnblacklist,btnstudentList,btnnewStudent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_home);
		btnfindAtte=(Button)findViewById(R.id.btnAttOfStd);
		btnfindAtte.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent jsgh=new Intent(getApplicationContext(),FindStdAtten.class);
				startActivity(jsgh);
			}
		});
		btnblacklist=(Button)findViewById(R.id.btnBlackList);
		btnblacklist.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent hih=new Intent(getApplicationContext(),BlackListedStd.class);
				startActivity(hih);
			}
		});
//		btnstudentList=(Button)findViewById(R.id.btnStdList);
//		btnstudentList.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent hih=new Intent(getApplicationContext(),StudentList.class);
//				startActivity(hih);
//				
//			}
//		});
//		btnnewStudent=(Button)findViewById(R.id.btnNewStd);
//		btnnewStudent.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent hih=new Intent(getApplicationContext(),NewStudent.class);
//				startActivity(hih);
//			}
//		});
	}

}
