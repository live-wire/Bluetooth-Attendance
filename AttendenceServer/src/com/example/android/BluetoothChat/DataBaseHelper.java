package com.example.android.BluetoothChat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
	public static final String DATABASE_NAME = "settingss";
	public static final int DATABASE_VERSION = 1;
	public static final String TABLE_ATTENDENCE="table_attendence";
	//public static final String TABLE_GENERIC="table_generic";
//	public static final String TABLE_FIRST="table_first";
//	public static final String TABLE_SEC="table_second";
//	public static final String TABLE_THERD="table_third";
//	public static final String TABLE_FOURTH="table_fourth";
//	public static final String TABLE_FIVE="table_five";
//	public static final String TABLE_SIX="table_six";
	public static final String ROW_ID="_id";
	public static final String STD_ID="std_id";
	public static final String STD_BRANCH="std_branch";
	public static final String STD_SEM="std_sem";
	public static final String STD_SUBJECT="std_subject";
	public static final String STD_NAME="std_name";
	public static final String UNIT_NAME="unit";
	public static final String ATTENDENCE="attendence";
	public static final String DATE="date";
	
	public static final String MOBILE_NAME="mobile_name";
	public static final String MONTH="month";
//	public static final String FIRST_BRAND="first_brnd";
//	public static final String SEC_BRAND="sec_brand";
//	public static final String THIRD_BRAND="third_brand";
//	public static final String FOURTH_BRAND="fourth_brand";
//	public static final String FIVE_BRAND="five_brand";
//	public static final String SIX_BRAND="six_brand";
//	public static final String MOBILE_F="mobile_f";
//	public static final String MOBILE_S="mobile_s";
//	public static final String MOBILE_TH="mobile_th";
//	public static final String MESSAGE="message";
    //tables for attendence
	public static final String CREATE_ATTENDENCE="create table " + TABLE_ATTENDENCE + " ( " + ROW_ID + " integer primary key, " 
			+ STD_ID + " text, "
			+ STD_NAME + " text, "
			+ ATTENDENCE + " text, "
			+ DATE + " text, "
			+ MONTH + " text, "
			+ STD_BRANCH + " text, "
			+ STD_SEM + " text, "
			+ STD_SUBJECT + " text, "
			+ MOBILE_NAME + " text ); ";
//tables for generic product
//	public static final String CREATE_GENERIC="create table " + TABLE_GENERIC + " ( " + ROW_ID + " integer primary key, " 
//			+ GENERIC_NAME + " text, "
//			+ TOTAL_BRAND + " text, "
//			+ FIRST_BRAND + " text, "
//			+ SEC_BRAND + " text, "
//			+ THIRD_BRAND + " text, "
//			+ FOURTH_BRAND + " text, "
//			+ FIVE_BRAND + " text, "
//			+ SIX_BRAND + " text ); ";
//	public static final String CREATE_FIRST="create table " + TABLE_FIRST + " ( " + ROW_ID + " integer primary key, " 
//			+ BRAND_NAME + " text, "
//			+ MANU_NAME + " text, "
//			+ TYPE_NAME + " text, "
//			+ UNIT_NAME + " text, "
//			+ PRICE_NAME + " text ); ";
//	public static final String CREATE_SEC="create table " + TABLE_SEC + " ( " + ROW_ID + " integer primary key, " 
//			+ BRAND_NAME + " text, "
//			+ MANU_NAME + " text, "
//			+ TYPE_NAME + " text, "
//			+ UNIT_NAME + " text, "
//			+ PRICE_NAME + " text ); ";
//	public static final String CREATE_THIRD="create table " + TABLE_THERD + " ( " + ROW_ID + " integer primary key, " 
//			+ BRAND_NAME + " text, "
//			+ MANU_NAME + " text, "
//			+ TYPE_NAME + " text, "
//			+ UNIT_NAME + " text, "
//			+ PRICE_NAME + " text ); ";
//	public static final String CREATE_FOURTH="create table " + TABLE_FOURTH + " ( " + ROW_ID + " integer primary key, " 
//			+ BRAND_NAME + " text, "
//			+ MANU_NAME + " text, "
//			+ TYPE_NAME + " text, "
//			+ UNIT_NAME + " text, "
//			+ PRICE_NAME + " text ); ";
//	public static final String CREATE_FIVE="create table " + TABLE_FIVE + " ( " + ROW_ID + " integer primary key, " 
//			+ BRAND_NAME + " text, "
//			+ MANU_NAME + " text, "
//			+ TYPE_NAME + " text, "
//			+ UNIT_NAME + " text, "
//			+ PRICE_NAME + " text ); ";
//	public static final String CREATE_SIX="create table " + TABLE_SIX + " ( " + ROW_ID + " integer primary key, " 
//			+ BRAND_NAME + " text, "
//			+ MANU_NAME + " text, "
//			+ TYPE_NAME + " text, "
//			+ UNIT_NAME + " text, "
//			+ PRICE_NAME + " text ); ";
	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_ATTENDENCE);
//		db.execSQL(CREATE_GENERIC);
//		db.execSQL(CREATE_FIRST);
//		db.execSQL(CREATE_SEC);
//		db.execSQL(CREATE_THIRD);
//		db.execSQL(CREATE_FOURTH);
//		db.execSQL(CREATE_FIVE);
//		db.execSQL(CREATE_SIX);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " +TABLE_ATTENDENCE);
////		db.execSQL("DROP TABLE IF EXISTS " +TABLE_GENERIC);
//		db.execSQL("DROP TABLE IF EXISTS " +TABLE_FIRST);
//		db.execSQL("DROP TABLE IF EXISTS " +TABLE_SEC);
//		db.execSQL("DROP TABLE IF EXISTS " +TABLE_THERD);
//		db.execSQL("DROP TABLE IF EXISTS " +TABLE_FOURTH);
//		db.execSQL("DROP TABLE IF EXISTS " +TABLE_FIVE);
//		db.execSQL("DROP TABLE IF EXISTS " +TABLE_SIX);
	}

	
}
