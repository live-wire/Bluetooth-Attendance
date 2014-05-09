package com.example.android.BluetoothChat;
  import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
  public class GenerateCSVFile extends Activity
  {
	  DataBaseHelper databaseHelper;
		Context contextBs=this;
		 SQLiteDatabase database;
TextView empidtxt,empnametxt,empsaltxt;
EditText empidet,empnameet,empsalet;
Button insetbt,viewbt;
SQLiteDatabase myDatabase=null;
String DataBase_Name="employeedata";
String Table_Name="employeedetails";
Cursor c1,c2;

@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.generatecsv_file);
    databaseHelper=new DataBaseHelper(contextBs);
    
    viewbt=(Button)findViewById(R.id.bt2);



    try

    {
       

        
        viewbt.setOnClickListener(new View.OnClickListener()
        {               
            @Override
            public void onClick(View v) 
            {
                  try
                  {
                      new ExportDatabaseCSVTask().execute("");

                  }
                  catch(Exception ex)
                  {
                      Log.e("Error in MainActivity",ex.toString());
                  }
            }
        });


    }
    catch(SQLException ex)
    {
        ex.printStackTrace();
    }
//    /*  finally
//      {
//          if(myDB!=null)
//              myDB.close();
//
//      }*/
    
}
public void open() {
	database = databaseHelper.getWritableDatabase();
}
public void close() {
	databaseHelper.close();
}
@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class ExportDatabaseCSVTask extends AsyncTask<String, Void, Boolean>

{
    private final ProgressDialog dialog = new ProgressDialog(GenerateCSVFile.this);

     @Override

    protected void onPreExecute()

    {

        this.dialog.setMessage("Exporting database...");

        this.dialog.show();

    }



    @SuppressLint("NewApi")
	protected Boolean doInBackground(final String... args)

    {
open();
        File dbFile=getDatabasePath("database.db");

        System.out.println(dbFile);  // displays the data base path in your logcat 


        File exportDir = new File(Environment.getExternalStorageDirectory(), "");

        if (!exportDir.exists())

        {

            exportDir.mkdirs();

        }

        File file = new File(exportDir, "myfile.csv");

        try

        {

            file.createNewFile();

            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));

            Cursor curCSV=database.rawQuery("select * from " + DataBaseHelper.TABLE_ATTENDENCE,null);

            csvWrite.writeNext(curCSV.getColumnNames());

            while(curCSV.moveToNext())

            {

                String arrStr[] ={curCSV.getString(0),curCSV.getString(1),curCSV.getString(2),curCSV.getString(3),curCSV.getString(4),curCSV.getString(5),curCSV.getString(6),curCSV.getString(7),curCSV.getString(8),curCSV.getString(9)};

                csvWrite.writeNext(arrStr);

            }

            csvWrite.close();

            curCSV.close();

         close();


            return true;

        }

        catch(SQLException sqlEx)

        {

            Log.e("GenerateCSVFile", sqlEx.getMessage(), sqlEx);

            return false;

        }

        catch (IOException e)

        {

            Log.e("GenerateCSVFile", e.getMessage(), e);

            return false;

        }   
        }

    protected void onPostExecute(final Boolean success)

    {

        if (this.dialog.isShowing())

        {

            this.dialog.dismiss();

        }

        if (success)

        {

            Toast.makeText(GenerateCSVFile.this, "Export successful!", Toast.LENGTH_SHORT).show();

        }

        else

        {

            Toast.makeText(GenerateCSVFile.this, "Export failed", Toast.LENGTH_SHORT).show();

        }

    }

}
 }