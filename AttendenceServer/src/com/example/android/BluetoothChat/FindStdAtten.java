package com.example.android.BluetoothChat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FindStdAtten extends Activity{
  EditText edtdateF,edtMonthF,edtStdId;
  SQLiteDatabase database;
	DataBaseHelper databaseHelper;
	Spinner spnrBranchF,spnrSemF,spnrSubjectF;
	//SimpleCursorAdapter adaptor;
	Context contextV=this;
  Button btnSearch;
  TextView txtCountAtte,txtPresntDates;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find_std_list);
		txtCountAtte=(TextView)findViewById(R.id.txtStdAttens);
		txtPresntDates=(TextView)findViewById(R.id.txtDate);
		databaseHelper=new DataBaseHelper(contextV);
		edtdateF=(EditText)findViewById(R.id.edtDateF);
		edtMonthF=(EditText)findViewById(R.id.edtMonthF);
		edtStdId=(EditText)findViewById(R.id.edtStdIdF);
		btnSearch=(Button)findViewById(R.id.btnSearch);
		spnrBranchF=(Spinner)findViewById(R.id.spnrBranchF);
		spnrSemF=(Spinner)findViewById(R.id.spnrSemF);
		spnrSubjectF=(Spinner)findViewById(R.id.spnrSubjectF);
		
		btnSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					open();
					 Cursor cursors=null;
					 if(edtdateF.getText().toString().length() >0 && edtMonthF.getText().toString().length()>0 && edtStdId.getText().toString().length() > 0 && String.valueOf(spnrSubjectF.getSelectedItem()).length()> 0 && String.valueOf(spnrSemF.getSelectedItem()).length()> 0 && String.valueOf(spnrBranchF.getSelectedItem()).length() > 0){
							
						 
							//cursors=database.query(DataBaseHelper.TABLE_ATTENDENCE, null, "date LIKE ? AND month like ? std_id like ?", new String[]{edtdateF.getText().toString(),edtMonthF.getText().toString(),edtStdId.getText().toString()}, null, null, null);
							cursors=database.rawQuery("SELECT * FROM "+DataBaseHelper.TABLE_ATTENDENCE+" WHERE date LIKE ? AND month LIKE ? AND std_id LIKE ? AND std_branch LIKE ? AND std_sem LIKE ? AND std_subject LIKE ?", new String[]{edtdateF.getText().toString().trim(),edtMonthF.getText().toString().trim(),edtStdId.getText().toString().trim(),String.valueOf(spnrBranchF.getSelectedItem()).trim(),String.valueOf(spnrSemF.getSelectedItem()),String.valueOf(spnrSubjectF.getSelectedItem())});//query(DatabaseHelper.TABLE_GENERIC, null, selection, selectionArgs, null, null, null, null);
							cursors.moveToFirst();
							String presentDates="";
							while(!cursors.isAfterLast()){
								presentDates=presentDates+" , " +cursors.getString(cursors.getColumnIndex(DataBaseHelper.DATE));
								cursors.moveToNext();
							}
							//txtPresntDates.setText("Present Dates "+presentDates);
							//Toast.makeText(getApplicationContext(), "3"+cursors.getCount(), Toast.LENGTH_LONG).show();
							String counts="Total Present "+cursors.getCount();
							if(cursors.getCount()>0){
							//txtCountAtte.setText(counts);
								 showResult(presentDates,counts);
						}
							else
							{
								String absent="Total Present 0";
								txtCountAtte.setText(absent);
							}
						}	
					 else if( edtMonthF.getText().toString().length()>0 && edtStdId.getText().toString().length() > 0 && String.valueOf(spnrSubjectF.getSelectedItem()).length()> 0 && String.valueOf(spnrSemF.getSelectedItem()).length()> 0 && String.valueOf(spnrBranchF.getSelectedItem()).length() > 0){
							
						 
							//cursors=database.query(DataBaseHelper.TABLE_ATTENDENCE, null, "date LIKE ? AND month like ? std_id like ?", new String[]{edtdateF.getText().toString(),edtMonthF.getText().toString(),edtStdId.getText().toString()}, null, null, null);
							cursors=database.rawQuery("SELECT * FROM "+DataBaseHelper.TABLE_ATTENDENCE+" WHERE month LIKE ? AND std_id LIKE ? AND std_branch LIKE ? AND std_sem LIKE ? AND std_subject LIKE ?", new String[]{edtMonthF.getText().toString().trim(),edtStdId.getText().toString().trim(),String.valueOf(spnrBranchF.getSelectedItem()).trim(),String.valueOf(spnrSemF.getSelectedItem()),String.valueOf(spnrSubjectF.getSelectedItem())});//query(DatabaseHelper.TABLE_GENERIC, null, selection, selectionArgs, null, null, null, null);
							cursors.moveToFirst();
							String presentDates="";
							while(!cursors.isAfterLast()){
								presentDates=presentDates+" , " +cursors.getString(cursors.getColumnIndex(DataBaseHelper.DATE));
								cursors.moveToNext();
							}
							txtPresntDates.setText("Present Dates "+presentDates);
							//Toast.makeText(getApplicationContext(), "3"+cursors.getCount(), Toast.LENGTH_LONG).show();
							String counts="Total Present "+cursors.getCount();
							if(cursors.getCount()>0){
							txtCountAtte.setText(counts);
						}
							else
							{
								String absent="Total Present 0";
								txtCountAtte.setText(absent);
							}
						}	
					 else if(edtdateF.getText().toString().length() >0 && edtMonthF.getText().toString().length()>0 && edtStdId.getText().toString().length() > 0){
					
				 
					//cursors=database.query(DataBaseHelper.TABLE_ATTENDENCE, null, "date LIKE ? AND month like ? std_id like ?", new String[]{edtdateF.getText().toString(),edtMonthF.getText().toString(),edtStdId.getText().toString()}, null, null, null);
					cursors=database.rawQuery("SELECT * FROM "+DataBaseHelper.TABLE_ATTENDENCE+" WHERE date LIKE ? AND month LIKE ? AND std_id LIKE ?", new String[]{edtdateF.getText().toString().trim(),edtMonthF.getText().toString().trim(),edtStdId.getText().toString().trim()});//query(DatabaseHelper.TABLE_GENERIC, null, selection, selectionArgs, null, null, null, null);
					cursors.moveToFirst();
					String presentDates="";
					while(!cursors.isAfterLast()){
						presentDates=presentDates+" , " +cursors.getString(cursors.getColumnIndex(DataBaseHelper.DATE));
						cursors.moveToNext();
					}
					txtPresntDates.setText("Present Dates "+presentDates);
					//Toast.makeText(getApplicationContext(), "3"+cursors.getCount(), Toast.LENGTH_LONG).show();
					String counts="Total Present "+cursors.getCount();
					if(cursors.getCount()>0){
					txtCountAtte.setText(counts);
				}
					else
					{
						String absent="Total Present 0";
						txtCountAtte.setText(absent);
					}
				}	
				else if(edtdateF.getText().toString().length() >0 && edtStdId.getText().toString().length() > 0){
					cursors=database.rawQuery("SELECT * FROM "+DataBaseHelper.TABLE_ATTENDENCE+" WHERE date LIKE ? AND std_id LIKE ?", new String[]{edtdateF.getText().toString().trim(),edtStdId.getText().toString().trim()});//query(DatabaseHelper.TABLE_GENERIC, null, selection, selectionArgs, null, null, null, null);
					cursors.moveToFirst();
					String presentDatess="";
					while(!cursors.isAfterLast()){
						presentDatess=presentDatess+" , " +cursors.getString(cursors.getColumnIndex(DataBaseHelper.DATE));
						cursors.moveToNext();
					}
					txtPresntDates.setText("Present Dates "+presentDatess);
					String counts="Total Present "+cursors.getCount();
					
					//Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_LONG).show();
					if(cursors.getCount()>0){
					txtCountAtte.setText(counts);
					}
					else
					{
						String absent="Total Present 0";
						txtCountAtte.setText(absent);
					}
				}
				else if(edtMonthF.getText().toString().length()>0 && edtStdId.getText().toString().length() > 0){
					//Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_LONG).show();
					cursors=database.rawQuery("SELECT * FROM "+DataBaseHelper.TABLE_ATTENDENCE+" WHERE month LIKE ? AND std_id LIKE ?", new String[]{edtMonthF.getText().toString().trim(),edtStdId.getText().toString().trim()});//query(DatabaseHelper.TABLE_GENERIC, null, selection, selectionArgs, null, null, null, null);
					cursors.moveToFirst();
					String presentDatesss="";
					while(!cursors.isAfterLast()){
						presentDatesss=presentDatesss+" , " +cursors.getString(cursors.getColumnIndex(DataBaseHelper.DATE));
						cursors.moveToNext();
					}
					txtPresntDates.setText("Present Dates "+presentDatesss);
					String counts="Total Present "+cursors.getCount();
					if(cursors.getCount()>0){
					txtCountAtte.setText(counts);
					}
					else
					{
						String absent="Total Present 0";
						txtCountAtte.setText(absent);
					}
					
				}
				else{
					Toast.makeText(getApplicationContext(), "Please Enter Atleast Two Field", Toast.LENGTH_LONG).show();
				}
				}
				catch (Exception e){
					Toast.makeText(getApplicationContext(), "Please Enter Above Any Two Field", Toast.LENGTH_LONG).show();
				}
				edtdateF.setText("");
				edtMonthF.setText("");
				edtStdId.setText("");
				close();
			}
		});
	}
	public void open() {
		database = databaseHelper.getWritableDatabase();
	}
	public void close() {
		databaseHelper.close();
	}
	public void showResult(String dates , String counts){
		// custom dialog
					final Dialog dialog = new Dialog(contextV);
					dialog.setContentView(R.layout.alertresultbox);
					dialog.setTitle("Student Attendence");
		 
					// set the custom dialog components - text, image and button
					TextView textCount = (TextView) dialog.findViewById(R.id.txtNoDatesA);
					TextView text = (TextView) dialog.findViewById(R.id.txtDatesA);
					textCount.setText(counts);
					text.setText("Present Dates"+ dates);
					//ImageView image = (ImageView) dialog.findViewById(R.id.image);
					//image.setImageResource(R.drawable.ic_launcher);
		 
					Button dialogButton = (Button) dialog.findViewById(R.id.btnOk);
					// if button is clicked, close the custom dialog
					dialogButton.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
		 
					dialog.show();
				  }
		
		
	}

