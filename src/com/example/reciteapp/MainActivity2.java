package com.example.reciteapp;

import com.example.recite.review.Review_List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity2 extends ActionBarActivity {

	private Button m_page_btn1;
	private Button m_page_btn2;
	private Button m_page_btn3;
	private Button edit_b;
	private Button test_for_b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_activity2);



		m_page_btn1 = (Button)findViewById(R.id.m_page_btn1);
		m_page_btn2 = (Button)findViewById(R.id.m_page_btn2);
		m_page_btn3 = (Button)findViewById(R.id.m_page_btn3);
		edit_b = (Button)findViewById(R.id.edit_b);
		test_for_b = (Button)findViewById(R.id.test_for_b);
		
		m_page_btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity2.this, MainActivity.class);
				startActivity(intent);
				overridePendingTransition( R.anim.in_to_left,R.anim.out_to_right);
			}
			
		});
		m_page_btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
				startActivity(intent);
			}
			
		});
		m_page_btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
				startActivity(intent);
				overridePendingTransition( R.anim.in_to_right,R.anim.out_to_left);
			}
			
		});
		edit_b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity2.this, Review_List.class);
				intent.putExtra("key", 1);
				startActivity(intent);
			}
			
		});
		test_for_b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity2.this, Review_List.class);
				intent.putExtra("key", 2);
				startActivity(intent);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity2, menu);
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
