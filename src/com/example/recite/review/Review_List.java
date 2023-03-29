package com.example.recite.review;

import java.util.ArrayList;
import java.util.List;

import com.example.database.Dao;
import com.example.entity.Rec_Element;
import com.example.recite.adapter.Review_Adapter;
import com.example.reciteapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Review_List extends ActionBarActivity {
	
	

	private List<Integer> nums ;
	private ListView listView;
	private List<Rec_Element> rec = new ArrayList<Rec_Element>();
	public void getData() {
		Dao dao = new Dao(getApplicationContext());
		nums = dao.query_dis();
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar acb = getSupportActionBar();
		
		if(acb != null) {
			acb.setHomeButtonEnabled(true);
			acb.setDisplayHomeAsUpEnabled(true);
		}
		
		setContentView(R.layout.activity_review__list);
		
		init();
		
		listView = (ListView) findViewById(R.id.review_list);
		Review_Adapter adapter = new Review_Adapter(getApplicationContext(), R.id.review_list, rec);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			/**
			 * parent 发生点击动作的adapterview
			 * view在adapterview中被点击的视图
			 * position 视图在adapter中的位置
			 * id 被点击元素的id
			 */
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO 自动生成的方法存根
				Log.i("test", "position:"+position+";id:"+id);
				Intent tt = getIntent();
				if(tt.getIntExtra("key", 0)==1) {
					Intent i = new Intent(Review_List.this, Review_Word.class);
					i.putExtra("For_Num", rec.get(position).getNum());
					startActivity(i);
					}
				else if(tt.getIntExtra("key", 0)==2) {
					Intent ii = new Intent(Review_List.this, Review_Test.class);
					ii.putExtra("For_Num", rec.get(position).getNum());
					startActivity(ii);
				}
			}
		});
	}

	public void init() {
		getData();
		for(int i =0 ; i < nums.size(); i++) {
			rec.add(new Rec_Element(nums.get(i)) );
			System.out.println(rec.get(i));
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.review__list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		
		}
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
