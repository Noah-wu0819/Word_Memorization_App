package com.example.database;

import android.support.v7.app.ActionBarActivity;

import com.example.reciteapp.R;
import com.example.reciteapp.R.id;
import com.example.reciteapp.R.layout;
import com.example.reciteapp.R.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Database extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database);
		
		DatabaseHelper helper = new DatabaseHelper(this);
		//写一个类继承sqliteopenhelper 2. 实现里面的方法，创建构造方法 3. 创建子类对象，再调用 getreadabledatabase() /getwriteabledatabase(), 即可创建数据库
		//SQL: 创建数据库，create database 数据库名称[编码]
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.database, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
