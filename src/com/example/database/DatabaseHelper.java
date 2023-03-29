package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.database.Constants;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final String TAG = "DatabaseHelper";
	/**
	 * context ������
	 * name ���ݿ�����
	 * factory �α깤��
	 * version �汾��
	 */
	public DatabaseHelper(Context context) {
		super(context, Constants.DATABASE_NAME, null, Constants.VERSION_CODE);
		// TODO �Զ����ɵĹ��캯�����
	}

	/**
	 * ��һ�δ������ݿ�ŵ���
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �Զ����ɵķ������
		//����ʱ�Ļص�
		Log.d(TAG, "�������ݿ�.....");
		//�����ֶ�
		//sql create table table_name(_id integer, name varchar(����), age integer, salary integer);
		String sql = "create table "+ Constants.table_name +"( id INTEGER PRIMARY KEY, Eng VARCHAR, Chi VARCHAR, List_Num INTEGER, Forget_Num INTEGER)";
		//CREATE TABLE "WordList" ()
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO �Զ����ɵķ������
		//�������ݿ�ʱ�Ļص�
		//���ݿ�汾��������֮����ܵ���������� 
		Log.d(TAG, "�������ݿ�.....");
		String sql = "alter table "  + Constants.table_name +" add instruct varchar";
		db.execSQL(sql);
		
		switch(oldVersion) {
			//ͨ���ж� �ϰ汾��ȷ�� ת��Ϊ�°汾�� sql����
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			
		}
	}

}
