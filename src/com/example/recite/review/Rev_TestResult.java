package com.example.recite.review;

import com.example.database.Dao;
import com.example.entity.Event;
import com.example.eventcollection.EventDao;
import com.example.reciteapp.MainActivity;
import com.example.reciteapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Rev_TestResult extends ActionBarActivity {

	private EventDao ed;
	private TextView Rev_test_result;
	private Button Rev_return_main;
	private Dao dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rev__test_result);
		setContentView(R.layout.activity_test__result);
		dao = new Dao(getApplicationContext());
		Intent tr = getIntent();
		Bundle bd = tr.getBundleExtra("bd");
		int i = bd.getInt("grade");
		System.out.println(i+"iiiiiiii");
		Event e = (Event)bd.getParcelable("event");
		System.out.println("传输后"+e.getDate());
		System.out.println("传输后"+e.getB_time());
		ed = new EventDao((Event) bd.getParcelable("event"));
		System.out.println(ed+"ededede");
		ed.getEvent().setScore(i);
		ed.End("review_test", ed.getEvent().getList(), ed.getEvent().getScore(), ed.getEvent().getNum(), dao);
		
		Rev_return_main = (Button)findViewById(R.id.return_main);
		Rev_test_result = (TextView)findViewById(R.id.test_result);
		
		Rev_test_result.setText(i+"");
		
		Rev_return_main.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent rtn = new Intent(Rev_TestResult.this, MainActivity.class);
				startActivity(rtn);
			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rev__test_result, menu);
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
