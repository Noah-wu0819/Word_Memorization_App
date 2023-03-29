package com.example.recite.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.database.Dao;
import com.example.entity.Test_Element;
import com.example.entity.Word;
import com.example.entity.Word_Count;
import com.example.eventcollection.EventDao;
import com.example.reciteapp.R;
import com.example.reciteapp.Test.TestActivity;
import com.example.reciteapp.Test.Test_Result;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Review_Test extends ActionBarActivity {

	private EventDao ed;
	private List<Integer> nums ;
	private ListView listView;
	private List<Word> words = new ArrayList<Word>();
	
	
	public List<Word> getData(Integer For_Num) {
		List<Word> word_rtn = new ArrayList<Word>();
		Dao dao = new Dao(getApplicationContext());
		word_rtn = dao.query_For(For_Num);
		return word_rtn;
	}
	
	private TextView  Rev_Eng_Show_Test;
	private Button Rev_Button_Test1;
	private Button Rev_Button_Test2;
	private Button Rev_Button_Test3;
	private Button Rev_Button_Test4;
	private Button Rev_Button_Test5;
	

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
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.review__test);
		Intent ii = getIntent();
		Integer For_Num = ii.getIntExtra("For_Num", -1);
		
		ed = new EventDao(); 
		//收集List数据
		ed.getEvent().setList(33);		
		List<Integer> rdm0 = new ArrayList<Integer>();
		rdm0 = Rdm_Test();
		Dao dao = new Dao(getApplicationContext());
		final Dao da = new Dao(getApplicationContext());
		
		final Word_Count wc = new Word_Count(0,0);
		List<Test_Element> t_element = new ArrayList<Test_Element>();
		//返回特定Forget_Num的组合试卷
		t_element = dao.query_RevTest(For_Num);
		//返回特定Forget_Num的单词序列
		words = dao.query_For(For_Num);
		
		//收集num数据
		ed.getEvent().setNum(t_element.size());
		
		final List<Test_Element> inner_test_element = t_element;
		final List<Word> inner_words = words;
		
		Rev_Eng_Show_Test  = (TextView)findViewById(R.id.Rev_Eng_Show_Test);
		Rev_Button_Test1 = (Button)findViewById(R.id.Rev_Chi_Show_Test1);
		Rev_Button_Test2 = (Button)findViewById(R.id.Rev_Chi_Show_Test2);
		Rev_Button_Test3 = (Button)findViewById(R.id.Rev_Chi_Show_Test3);
		Rev_Button_Test4 = (Button)findViewById(R.id.Rev_Chi_Show_Test4);
		Rev_Button_Test5 = (Button)findViewById(R.id.Rev_Chi_Show_Test5);
		
		Rev_Eng_Show_Test.setText(t_element.get(wc.getIndex()).getEng_Show_Test());
		Rev_Button_Test1.setText(t_element.get(wc.getIndex()).getSpc_Show(rdm0.get(0)));
		Rev_Button_Test2.setText(t_element.get(wc.getIndex()).getSpc_Show(rdm0.get(1)));
		Rev_Button_Test3.setText(t_element.get(wc.getIndex()).getSpc_Show(rdm0.get(2)));
		Rev_Button_Test4.setText(t_element.get(wc.getIndex()).getSpc_Show(rdm0.get(3)));
		Rev_Button_Test5.setText(t_element.get(wc.getIndex()).getChi_Show_Test5());
		ed.Start();
		
		Rev_Button_Test1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Rev_Button_Test1.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
					System.out.println(wc.GetGrade());
				}else {
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				
				
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(Review_Test.this, Test_Result.class);
					Bundle bd = new Bundle();
					bd.putInt("grade", wc.GetGrade());
					bd.putParcelable("event", ed.getEvent());
					tr.putExtra("bd", bd);
					startActivity(tr);
					
				}else {
					
					wc.Index_inc();
					List<Integer> ran1 = new ArrayList<Integer>();
					ran1 = Rdm_Test();
					System.out.println(ran1);
				//下一页内容呈现
					Rev_Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
					Rev_Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran1.get(0)));
					Rev_Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran1.get(1)));
					Rev_Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran1.get(2)));
					Rev_Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran1.get(3)));
					Rev_Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
				
			}}
		});
		Rev_Button_Test2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Rev_Button_Test2.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
					System.out.println(wc.GetGrade());
				}else {
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(Review_Test.this, Test_Result.class);
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
				System.out.println(ran2);
				Rev_Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
				Rev_Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran2.get(0)));
				Rev_Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran2.get(1)));
				Rev_Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran2.get(2)));
				Rev_Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran2.get(3)));
				Rev_Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
			}}
		});
		Rev_Button_Test3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Rev_Button_Test3.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
					System.out.println(wc.GetGrade());
				}else {
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(Review_Test.this, Test_Result.class);
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
				System.out.println(ran3);
				Rev_Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
				Rev_Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran3.get(0)));
				Rev_Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran3.get(1)));
				Rev_Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran3.get(2)));
				Rev_Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran3.get(3)));
				Rev_Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
			}}
		});
		Rev_Button_Test4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Rev_Button_Test4.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
					System.out.println(wc.GetGrade());
				}else {
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(Review_Test.this, Test_Result.class);
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
				System.out.println(ran4);
				Rev_Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
				Rev_Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran4.get(0)));
				Rev_Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran4.get(1)));
				Rev_Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran4.get(2)));
				Rev_Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran4.get(3)));
				Rev_Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
			}}
		});
		Rev_Button_Test5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//分数计算
				if(Rev_Button_Test5.getText()==inner_test_element.get(wc.getIndex()).getChi_Show_Test1()) {
					wc.Grade_Inc();
					System.out.println(wc.GetGrade());
				}else {
					System.out.println("Review_test:id测试"+inner_words.get(wc.getIndex()).getW_id());
					da.Update_For_Num(inner_words.get(wc.getIndex()).getW_id());
				}
				//判断是否进入结算
				if(wc.getIndex() ==inner_test_element.size()-1) {
					Intent tr = new Intent(Review_Test.this, Test_Result.class);
					Bundle bd = new Bundle();
					bd.putInt("grade", wc.GetGrade());
					bd.putParcelable("event", ed.getEvent());
					tr.putExtra("bd", bd);
					startActivity(tr);
					
				}else {
				//下一页内容呈现
				wc.Index_inc();
				List<Integer> ran5 = new ArrayList<Integer>();
				ran5=Rdm_Test();
				System.out.println(ran5);
				Rev_Eng_Show_Test.setText(inner_test_element.get(wc.getIndex()).getEng_Show_Test());
				Rev_Button_Test1.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran5.get(0)));
				Rev_Button_Test2.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran5.get(1)));
				Rev_Button_Test3.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran5.get(2)));
				Rev_Button_Test4.setText(inner_test_element.get(wc.getIndex()).getSpc_Show(ran5.get(3)));
				Rev_Button_Test5.setText(inner_test_element.get(wc.getIndex()).getChi_Show_Test5());
			}}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.review__test, menu);
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
