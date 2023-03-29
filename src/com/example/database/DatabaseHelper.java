package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.database.Constants;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final String TAG = "DatabaseHelper";
	/**
	 * context 上下文
	 * name 数据库名称
	 * factory 游标工厂
	 * version 版本号
	 */
	public DatabaseHelper(Context context) {
		super(context, Constants.DATABASE_NAME, null, Constants.VERSION_CODE);
		// TODO 自动生成的构造函数存根
	}

	/**
	 * 第一次创建数据库才调用
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自动生成的方法存根
		//创建时的回调
		Log.d(TAG, "创建数据库.....");
		//创建字段
		//sql create table table_name(_id integer, name varchar(长度), age integer, salary integer);
		String sql = "create table "+ Constants.table_name +"( id INTEGER PRIMARY KEY, Eng VARCHAR, Chi VARCHAR, List_Num INTEGER, Forget_Num INTEGER)";
		//CREATE TABLE "WordList" ()
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自动生成的方法存根
		//升级数据库时的回调
		//数据库版本必须升级之后才能调用这个方法 
		Log.d(TAG, "升级数据库.....");
		String sql = "alter table "  + Constants.table_name +" add instruct varchar";
		db.execSQL(sql);
		
		switch(oldVersion) {
			//通过判断 老版本来确定 转变为新版本的 sql方法
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			
		}
	}

}
