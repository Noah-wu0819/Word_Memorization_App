package com.example.reciteapp.Recite;

import java.util.ArrayList;
import java.util.List;

import com.example.database.Dao;
import com.example.entity.Rec_Element;
import com.example.entity.Word;
import com.example.entity.Word_Count;
import com.example.eventcollection.EventDao;
import com.example.recite.adapter.MyPageAdapter;
import com.example.recite.fragment.MyFragment;
import com.example.reciteapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Page_Activity extends ActionBarActivity {
	
	
	private TextView Chi_Show;
	private TextView Eng_Show;
	private TextView For_Show;
	private TextView List_Show;
	private ListView list_v;
	private Dao dao;
	
	EventDao ed = new EventDao();
	Rec_Element re = new Rec_Element(-1);
	ViewPager viewPager;
	//为数据采集提供单词个数
	private Word_Count wc = new Word_Count();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_);
		
		 android.support.v7.app.ActionBar actionBar = getSupportActionBar();
	        if(actionBar != null){
	            actionBar.setHomeButtonEnabled(true);
	            actionBar.setDisplayHomeAsUpEnabled(true);
	        }
		
		dao = new Dao(getApplicationContext());

		Chi_Show = (TextView)findViewById(R.id.Chi_Show);
		Eng_Show = (TextView)findViewById(R.id.Eng_Show);
		For_Show = (TextView)findViewById(R.id.For_Show);
		List_Show = (TextView)findViewById(R.id.List_Show);
		
		ArrayList<MyFragment> fragments;
		MyPageAdapter pageadapter;
		final Dao dao = new Dao(getApplicationContext());
		Intent i2 = getIntent();
		Bundle bd = i2.getBundleExtra("List");
		int List = bd.getInt("List");
		setTitle("List"+List);
		Log.i("test","List="+List);
		//为数据采集提供List
		re.setNum(List);
		
		//获取数据库对象数据存储
		List<Word> words = new ArrayList<Word>();
		words = dao.query_Spc(List);
		//供给内部类使用的变量
		final List<Word> inner_words = words;
		
		//设置布局大框架
		viewPager = (ViewPager) findViewById(R.id.viewPager1);
		Log.i("test", "1111111");
		
		fragments = new ArrayList<MyFragment>();
		//创建子视图
		for(int i = 0; i < words.size(); i++) {
			if(words.get(i)!=null)
				fragments.add(new MyFragment(words.get(i)));
			else
				continue;
		}
		Log.i("test", "222222222222");
		System.out.println(fragments);
		//设置设配器，将视图绘制fragment
		pageadapter = new MyPageAdapter(getSupportFragmentManager(),fragments);
		System.out.println(pageadapter);
		viewPager.setAdapter(pageadapter);
		//开始数据采集
		ed.Start();
		
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO 自动生成的方法存根
				wc.setIndex(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
		
			
	}
		
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		
		Dao dao = new Dao(getApplicationContext());
		Intent i2 = getIntent();
		Bundle bd = i2.getBundleExtra("List");
		int List = bd.getInt("List");
		Log.i("test","List="+List);
		
		//获取数据库对象数据存储
		List<Word> words = new ArrayList<Word>();
		words = dao.query_Spc(List);
		
		if(requestCode==1234) {
			if(resultCode==4321) {
				int index = data.getIntExtra("index", -1);
				Chi_Show.setText(words.get(index).getChi());
				Eng_Show.setText(words.get(index).getEng());
				//int与String类型错误
				For_Show.setText(words.get(index).getForget_Num()+"");
				List_Show.setText(words.get(index).getList_Num()+"");
			}
		}else {
			return;
		}
	};
	
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.page_, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
        case android.R.id.home:
        	ed.End("recite", re.getNum(), 0, wc.getIndex()+1, dao);
            this.finish(); // back button
            
            return true;
		}
		return super.onOptionsItemSelected(item);

		
	}
}
//this.bindService(intent_s, conn, Service.BIND_AUTO_CREATE);

/*
 * final Word_Count wc =  new Word_Count();
wc.setIndex(0);

int num = 0;
//供给内部类使用的变量
final int inner_num = 0;
button_rtn = (Button)findViewById(R.id.button_rtn);
button_atr = (Button)findViewById(R.id.button_atr);
Chi_Show = (TextView)findViewById(R.id.Chi_Show);
Eng_Show = (TextView)findViewById(R.id.Eng_Show);
For_Show = (TextView)findViewById(R.id.For_Show);
List_Show = (TextView)findViewById(R.id.List_Show);

//数据库操作
Dao dao = new Dao(getApplicationContext());
Intent i2 = getIntent();
Bundle bd = i2.getBundleExtra("List");
int List = bd.getInt("List");
Log.i("test","List="+List);

//获取数据库对象数据存储
List<Word> words = new ArrayList<Word>();
words = dao.query_Spc(List);
//供给内部类使用的变量
final List<Word> inner_words = words;

Log.i("test", words.get(1).getEng());
//显示到图形用户界面上
Chi_Show.setText(words.get(num).getChi());
Eng_Show.setText(words.get(num).getEng());
//int与String类型错误，注意类型转换，String 0x0 错误
For_Show.setText(words.get(num).getForget_Num()+"");
List_Show.setText(words.get(num).getList_Num()+"");

final Intent intent2 = new Intent(this, Word_Update.class);

button_atr.setOnClickListener(new OnClickListener() {
	

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		wc.Index_inc();
		int nnn = wc.getIndex();
		//显示到图形用户界面上
		Chi_Show.setText(inner_words.get(nnn).getChi());
		Eng_Show.setText(inner_words.get(nnn).getEng());
		//int与String类型错误，注意类型转换，String 0x0 错误
		For_Show.setText(inner_words.get(nnn).getForget_Num()+"");
		List_Show.setText(inner_words.get(nnn).getList_Num()+"");
		//intent2.putExtra("index", atr_num);
		//startActivityForResult(intent2, 1234);
		
	}
});
button_rtn.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		wc.Index_dec();
		int nnn = wc.getIndex();
		//显示到图形用户界面上
		Chi_Show.setText(inner_words.get(nnn).getChi());
		Eng_Show.setText(inner_words.get(nnn).getEng());
		//int与String类型错误，注意类型转换，String 0x0 错误
		For_Show.setText(inner_words.get(nnn).getForget_Num()+"");
		List_Show.setText(inner_words.get(nnn).getList_Num()+"");
		
	}
});*/

