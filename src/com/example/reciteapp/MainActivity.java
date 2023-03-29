package com.example.reciteapp;

import com.example.database.DatabaseHelper;
import com.example.database.SQL_Import;
import com.example.reciteapp.Recite.List_Choose;
import com.example.reciteapp.Test.List_Choose1;
import com.example.reciteapp.view.TitleLayout;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button recite_b;
	private Button test_b;
	private Button search_b;
	private Button m_page_btn1;
	private Button m_page_btn2;
	private Button m_page_btn3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		SQL_Import im = new SQL_Import();
		SQLiteDatabase db = im.openDatabase(getApplicationContext());
		
		//Intent ii = new Intent(getApplicationContext(),Example_Activity.class);
		//startActivity(ii);
		DatabaseHelper helper = new DatabaseHelper(this);
		//创建数据库
		helper.getWritableDatabase();
		
		recite_b = (Button)findViewById(R.id.recite_b);
		test_b = (Button)findViewById(R.id.test_b);

		search_b = (Button)findViewById(R.id.search_b);
		m_page_btn1 = (Button)findViewById(R.id.m_page_btn1);
		m_page_btn2 = (Button)findViewById(R.id.m_page_btn2);
		m_page_btn3 = (Button)findViewById(R.id.m_page_btn3);
		
		
		recite_b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this, List_Choose.class);
				startActivity(intent);
			}
			
		});
		test_b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this, List_Choose1.class);
				startActivity(intent);
			}
			
		});
		
		search_b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this, SearchActivity.class);
				startActivity(intent);
			}
			
		});
		m_page_btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this, MainActivity.class);
				startActivity(intent);
				
			}
			
		});
		m_page_btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this, MainActivity2.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_to_right,R.anim.out_to_left);
			}
			
		});
		m_page_btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this, MainActivity3.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_to_right,R.anim.out_to_left);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
