package com.example.android.BluetoothChat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeForServer extends Activity{
	Context contextH=this;
	EditText dates,months,edtBranch,edtSem,edtSubject,edtMonthA;
	Spinner spnrSem,spnrSubject,spnrBranch;
	public static String datess,monthss,branch,semestar,subject; 
@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		menu.add(1, 100, 1, "Setting");
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
super.onOptionsItemSelected(item);
alertBox();
return true;
	}
private void alertBox() {
		// TODO Auto-generated method stub
	
		LayoutInflater li = LayoutInflater.from(contextH);
		View promptsView = li.inflate(R.layout.alertbox, null);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				contextH);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);
         spnrSem=(Spinner) promptsView.findViewById(R.id.spnrSem);
		 dates = (EditText) promptsView
				.findViewById(R.id.edtDate);
		 edtMonthA= (EditText) promptsView
				.findViewById(R.id.edtMonthA);
		spnrBranch = (Spinner) promptsView
					.findViewById(R.id.spnrBranch);
		spnrSubject= (Spinner) promptsView
					.findViewById(R.id.spnrSubject);
//		sp = (EditText) promptsView
//					.findViewById(R.id.edtSubject);

		// set dialog message
		alertDialogBuilder
			.setCancelable(false)
			.setPositiveButton("OK",
			  new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog,int id) {
				// get user input and set it to result
				// edit text
				//result.setText(userInput.getText());
			    	datess= dates.getText().toString();
			    	monthss=edtMonthA.getText().toString();//months.getText().toString();
			    //	monthss="4";
			    	branch=String.valueOf(spnrBranch.getSelectedItem());
			    	semestar=String.valueOf(spnrSem.getSelectedItem());
			    	subject=String.valueOf(spnrSubject.getSelectedItem());
			    	Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_LONG).show();
			    }
			  })
			.setNegativeButton("Cancel",
			  new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog,int id) {
				dialog.cancel();
			    }
			  });

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
		
	}

		

ImageButton btnForStudent,btnForStaff,btnManual,btnManualAtte,btnReportHome,btnQuiz;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homeforserver);
		btnForStudent=(ImageButton)findViewById(R.id.btnAttendence);
		btnForStudent.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
				if(dates.getText().toString().length() > 0){
			Intent has=new Intent(HomeForServer.this, BluetoothChat.class);
			startActivity(has);
				}
				else
				{
					
					Toast.makeText(getApplicationContext(), "Please Set Date and Month By Option Menu", Toast.LENGTH_LONG).show();
				}
				}
				catch(Exception e){
					Toast.makeText(getApplicationContext(), "Please Set Date and Month By Option Menu", Toast.LENGTH_LONG).show();
				}
			}
		});
		btnManual=(ImageButton)findViewById(R.id.btnManual);
		btnManual.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent hassds=new Intent(HomeForServer.this, QueryOfStudent.class);
				startActivity(hassds);
			}
		});
		btnManualAtte=(ImageButton)findViewById(R.id.btnDebard);
		btnManualAtte.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
				if(dates.getText().toString().length() > 0){
			Intent sigf=new Intent(HomeForServer.this,ManualAttendence.class);
			startActivity(sigf);
				}
				else
				{
					
					Toast.makeText(getApplicationContext(), "Please Set Date and Month By Option Menu", Toast.LENGTH_LONG).show();
				}
				}
				catch(Exception e){
					Toast.makeText(getApplicationContext(), "Please Set Date and Month By Option Menu", Toast.LENGTH_LONG).show();
					
				}
			}
		});
		btnReportHome=(ImageButton)findViewById(R.id.btnGood);
		btnReportHome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent uu=new Intent(getApplicationContext(),ReportHome.class);
			startActivity(uu);
			}
		});
		btnQuiz=(ImageButton)findViewById(R.id.btnQuiz);
		btnQuiz.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent uu=new Intent(getApplicationContext(),QuizActivity.class);
				startActivity(uu);
			}
		});
		Button btnCSV=(Button)findViewById(R.id.btnCSV);
		btnCSV.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent uu=new Intent(getApplicationContext(),GenerateCSVFile.class);
				startActivity(uu);
			}
		});
		
	}

}
