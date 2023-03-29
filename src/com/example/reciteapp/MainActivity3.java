package com.example.reciteapp;

import com.example.database.Dao;
import com.example.eventcollection.Event_Analyze;
import com.example.reciteapp.view.RadarView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity3 extends ActionBarActivity {

	private Button m_page_btn1;
	private Button m_page_btn2;
	private Button m_page_btn3;
	private Event_Analyze eva;
	private Dao dao;
	private RadarView rv;
	private double[] data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_activity3);
		//初始化数据库操作对象
		dao = new Dao(getApplicationContext());
		
		data = new double[8];
		
		rv = (RadarView)findViewById(R.id.radarView);
		
		//下方导航栏三个按钮
		m_page_btn1 = (Button)findViewById(R.id.m_page_btn1);
		m_page_btn2 = (Button)findViewById(R.id.m_page_btn2);
		m_page_btn3 = (Button)findViewById(R.id.m_page_btn3);
		
		//雷达图构建
		eva = new Event_Analyze();
		
		data[0] = eva.Velocity(dao, "recite") * 100;
		data[1] = eva.Velocity(dao, "review") * 100;
		data[2] = eva.Velocity(dao, "test") * 100;
		data[3] = eva.Proportion(dao, "recite") * 100;
		data[4] = eva.Proportion(dao, "review") * 100;
		data[5] = eva.Proportion(dao, "test") * 100;
		
		for(int i = 0; i <6; i++) {
			if(data[i]>100)
				data[i] = 100;
		}
		
		rv.setData(data);
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data[3]);
		System.out.println(data[4]);
		System.out.println(data[5]);
		
		m_page_btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity3.this, MainActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_to_left, R.anim.out_to_right);
			}
			
		});
		m_page_btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_to_left, R.anim.out_to_right);
			}
			
		});
		m_page_btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
				startActivity(intent);
			}
			
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity3, menu);
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
