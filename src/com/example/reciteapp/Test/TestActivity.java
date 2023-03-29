package com.example.reciteapp.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.database.Dao;
import com.example.entity.Test_Element;
import com.example.entity.Word;
import com.example.entity.Word_Count;
import com.example.eventcollection.EventDao;
import com.example.reciteapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends ActionBarActivity {

	private EventDao ed;
	private TextView    Eng_Show_Test;
	private Button Button_Test1;
	private Button Button_Test2;
	private Button Button_Test3;
	private Button Button_Test4;
	private Button Button_Test5;
	

	public List<Integer>  Rdm_Test(){
		List<Integer> list = new ArrayList<Integer>();
		List<Integer>ran_l = new ArrayList<Integer>();
		for(int i = 0; i<4; i++) {
			list.add(i);
			
		}
		for(int i = 0; i<4; i++) {
			Collections.shuffle(list);
			ran_l.add(list.get(0));
			list.remove(0);
		}
		return ran_l;
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		ed = new EventDao(); 
		List<Integer> rdm0 = new ArrayList<Integer>();
		rdm0 = Rdm_Test();
		final Word_Count wc = new Word_Count(0,0);
		Dao dao = new Dao(getApplicationContext());
		final Dao da = new Dao(getApplicationContext());
		Intent i2 = getIntent();
		Bundle bd = i2.getBundleExtra("List");
		int List = bd.getInt("List");
		//收集List数据
		ed.getEvent().setList(32);
		
		Log.i("test","List="+List);
		//获取数据库对象数据存储
		List<Test_Element> test_element = new ArrayList<Test_Element>();
		test_element = dao.query_single(List);
		
		//收集num数据
		ed.getEvent().setNum(test_element.size());
		List<Word> words = new ArrayList<Word>();
		words = da.query_Spc(List);
		//供给内部类使用的变量
		final List<Test_Element> inner_test_element = test_element;
		final List<Word> inner_words = words;
		Eng_Show_Test  = (TextView)findViewById(R.id.Eng_Show_Test);
		Button_Test1 = (Button)findViewById(R.id.Chi_Show_Test1);
		Button_Test2 = (Button)findViewById(R.id.Chi_Show_Test2);
		Button_Test3 = (Button)findViewById(R.id.Chi_Show_Test3);
		Button_Test4 = (Button)findViewById(R.id.Chi_Show_Test4);
		Button_Test5 = (Button)findViewById(R.id.Chi_Show_Test5);
		
		Eng_Show_Test.setText(test_element.get(wc.getIndex()).getEng_Show_Test());
		Button_Test1.setText(test_element.get(wc.getIndex()).getSpc_Show(rdm0.get(0)));
		Button_Test2.setText(test_element.get(wc.getIndex()).getSpc_Show(rdm0.get(1)));
		Button_Test3.setText(test_element.get(wc.getIndex()).getSpc_Show(rdm0.get(2)));
		Button_Test4.setText(test_element.get(wc.getIndex()).getSpc_Show(rdm0.get(3)));
		Button_Test5.setText(test_element.get(wc.getIndex()).getChi_Show_Test5());
		
		ed.Start();
		//int与String类型错误，注意类型转换，String 0x0 错误
		//For_Show.setText(words.get(num).getForget_Num()+"");
		//List_Show.setText(words.get(num).getList_Num()+"");
		
		Button_Test1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Button_Test1.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
					//System.out.println(wc.GetGrade());
				}else {
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				
				
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(TestActivity.this, Test_Result.class);
					Bundle bd = new Bundle();
					bd.putInt("grade", wc.GetGrade());
					bd.putParcelable("event", ed.getEvent());
					tr.putExtra("bd", bd);
					startActivity(tr);
					
				}else {
					
					wc.Index_inc();
					List<Integer> ran1 = new ArrayList<Integer>();
					ran1 = Rdm_Test();
					//System.out.println(ran1);
				//下一页内容呈现
				Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
				Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran1.get(0)));
				Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran1.get(1)));
				Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran1.get(2)));
				Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran1.get(3)));
				Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
				
			}}
		});
		Button_Test2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Button_Test2.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
					//System.out.println(wc.GetGrade());
				}else {
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(TestActivity.this, Test_Result.class);
					Bundle bd = new Bundle();
					bd.putInt("grade", wc.GetGrade());
					bd.putParcelable("event", ed.getEvent());
					tr.putExtra("bd", bd);
					startActivity(tr);
					
				}else {
				//下一页内容呈现
				
				wc.Index_inc();
				List<Integer> ran2 = new ArrayList<Integer>();
				ran2 = Rdm_Test();
				//System.out.println(ran2);
				Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
				Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran2.get(0)));
				Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran2.get(1)));
				Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran2.get(2)));
				Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran2.get(3)));
				Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
			}}
		});
		Button_Test3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Button_Test3.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
				//	System.out.println(wc.GetGrade());
				}else {
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(TestActivity.this, Test_Result.class);
					Bundle bd = new Bundle();
					bd.putInt("grade", wc.GetGrade());
					bd.putParcelable("event", ed.getEvent());
					tr.putExtra("bd", bd);
					startActivity(tr);
					
				}else {
				//下一页内容呈现
				wc.Index_inc();
				List<Integer> ran3 = new ArrayList<Integer>();
				ran3 = Rdm_Test();
				//System.out.println(ran3);
				Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
				Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran3.get(0)));
				Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran3.get(1)));
				Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran3.get(2)));
				Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran3.get(3)));
				Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
			}}
		});
		Button_Test4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Button_Test4.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
					//System.out.println(wc.GetGrade());
				}else {
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(TestActivity.this, Test_Result.class);
					Bundle bd = new Bundle();
					bd.putInt("grade", wc.GetGrade());
					bd.putParcelable("event", ed.getEvent());
					tr.putExtra("bd", bd);
					startActivity(tr);
					
				}else {
				//下一页内容呈现
				wc.Index_inc();
				List<Integer> ran4 = new ArrayList<Integer>();
				ran4 = Rdm_Test();
				//System.out.println(ran4);
				Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
				Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran4.get(0)));
				Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran4.get(1)));
				Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran4.get(2)));
				Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran4.get(3)));
				Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
			}}
		});
		Button_Test5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Button_Test5.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
					//System.out.println(wc.GetGrade());
				}else {
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(TestActivity.this, Test_Result.class);
					Bundle bd = new Bundle();
					bd.putInt("grade", wc.GetGrade());
					bd.putParcelable("event", ed.getEvent());
					System.out.println(ed.getEvent().getB_time());
					System.out.println(ed.getEvent().getDate());
					tr.putExtra("bd", bd);
					startActivity(tr);
					
				}else {
				//下一页内容呈现
				wc.Index_inc();
				List<Integer> ran5 = new ArrayList<Integer>();
				ran5=Rdm_Test();
				//System.out.println(ran5);
				Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
				Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran5.get(0)));
				Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran5.get(1)));
				Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran5.get(2)));
				Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran5.get(3)));
				Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
			}}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
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
