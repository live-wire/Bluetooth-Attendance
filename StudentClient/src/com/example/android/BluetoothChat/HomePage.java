package com.example.android.BluetoothChat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends Activity{
Button btnAttendence,btnQuery,btnQuiz;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
		btnAttendence=(Button)findViewById(R.id.btnBlethAtte);
		btnAttendence.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
 				// TODO Auto-generated method stub
        Intent dsh=new Intent(getApplicationContext(), BluetoothChat.class);
        startActivity(dsh);
			}
		});
		btnQuery=(Button)findViewById(R.id.btnGetQue);
		btnQuery.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				   Intent dshs=new Intent(getApplicationContext(), GetAttendence.class);
			        startActivity(dshs);
			}
		});
		btnQuiz=(Button)findViewById(R.id.btnQuiz);
		btnQuiz.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent dshs=new Intent(getApplicationContext(), QuizActivity.class);
		        startActivity(dshs);
			}
		});
	}

}
