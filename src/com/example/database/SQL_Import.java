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

	//数据库存储路径
	String filepath = "/data/data/com.example.reciteapp/recitewords.db";
	//数据库存放的文件夹
	String pathStr = "data/data/com.example.reciteapp";
	SQLiteDatabase database;
	public SQLiteDatabase openDatabase(Context context) {
		System.out.println("filePath:" + filepath);
		File sqlite_db = new File(filepath);
		if(sqlite_db.exists()) {
			Log.i("test", "存在数据库");
			//存在则直接返回打开的数据库
			return SQLiteDatabase.openOrCreateDatabase(sqlite_db, null);
		}else {
			//不存在先创建文件夹
			File path = new File(pathStr);
			Log.i("test", "pathStr="+ path);
			if(path.mkdir()) {
				Log.i("test","创建成功");
			}else {
				Log.i("test","创建失败");
			}
			
			try {
				AssetManager am = context.getAssets();
				//得到数据库的输入流
				InputStream is = am.open("recitewords.db");
				Log.i("test", is + "test.db");
				//用输出流写到SDcard上面
				FileOutputStream fos = new FileOutputStream(sqlite_db);
				Log.i("test", "fos=" + fos);
				Log.i("test", "sqlite_db=" + sqlite_db);
				//创建byte数组，用于1kb写一次
				byte[] buffer = new byte[1024];
				int count = 0;
				while((count = is.read(buffer))>0) {
					Log.i("test", "得到");
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
