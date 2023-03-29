package com.example.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQL_Import {

	//���ݿ�洢·��
	String filepath = "/data/data/com.example.reciteapp/recitewords.db";
	//���ݿ��ŵ��ļ���
	String pathStr = "data/data/com.example.reciteapp";
	SQLiteDatabase database;
	public SQLiteDatabase openDatabase(Context context) {
		System.out.println("filePath:" + filepath);
		File sqlite_db = new File(filepath);
		if(sqlite_db.exists()) {
			Log.i("test", "�������ݿ�");
			//������ֱ�ӷ��ش򿪵����ݿ�
			return SQLiteDatabase.openOrCreateDatabase(sqlite_db, null);
		}else {
			//�������ȴ����ļ���
			File path = new File(pathStr);
			Log.i("test", "pathStr="+ path);
			if(path.mkdir()) {
				Log.i("test","�����ɹ�");
			}else {
				Log.i("test","����ʧ��");
			}
			
			try {
				AssetManager am = context.getAssets();
				//�õ����ݿ��������
				InputStream is = am.open("recitewords.db");
				Log.i("test", is + "test.db");
				//�������д��SDcard����
				FileOutputStream fos = new FileOutputStream(sqlite_db);
				Log.i("test", "fos=" + fos);
				Log.i("test", "sqlite_db=" + sqlite_db);
				//����byte���飬����1kbдһ��
				byte[] buffer = new byte[1024];
				int count = 0;
				while((count = is.read(buffer))>0) {
					Log.i("test", "�õ�");
					fos.write(buffer, 0, count);
				}
				fos.flush();
				fos.close();
				is.close();
				
			}catch(IOException e) {
				e.printStackTrace();
				return null;
				
			}
			return openDatabase(context);
		}
	}
}
