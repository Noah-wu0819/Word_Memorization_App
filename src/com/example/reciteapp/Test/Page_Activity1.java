package com.example.reciteapp.Test;

import java.util.ArrayList;
import java.util.List;

import com.example.database.Dao;
import com.example.entity.Word;
import com.example.recite.adapter.MyPageAdapter;
import com.example.recite.fragment.MyFragment;
import com.example.reciteapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;


public class Page_Activity1 extends ActionBarActivity {

	private ListView list_v;
	ViewPager viewPager;
	/* 2021.3.21 踩过的坑，baseadapter并不能实现我想要的效果
	//创建适配器，方便考试界面的绘制
	public class Myadapter extends BaseAdapter{

		//创建 数据库的数据变量， 创建上下文变量
		private List<Word> words = new ArrayList<Word>();
		private Context mContext;
		
		public  Myadapter(Context Context, List<Word> word) {
		
			super();
			this.mContext = Context;
			this.words = word;
			Log.i("test", this.words.get(0).getEng());
			
			// TODO 自动生成的构造函数存根
		}
		
		//数据源长度，想显示几个就返回几个
		@Override
		public int getCount() {
			// TODO 自动生成的方法存根
			return 1;
		}

		@Override
		public Object getItem(int position) {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO 自动生成的方法存根
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO 自动生成的方法存根
			/*LayoutInflater用来加载布局，用inflate()就可以将layout布局绘制出来
			 * getView方法中的三个参数，position是指现在是第几个条目，convertView是
			 * 旧视图，也就是绘制完成的视图，parent是父级视图
			 * 用inflate方法绘制好的view最后return 返回给getView()就可以了
			
			LayoutInflater inflater = LayoutInflater.from(mContext);
			//View view = inflater.inflate(R.layout.activity_page__activity1,null);
			Holder  holder = null;
			Log.i("test", "11112222222222222222222111");
			if(convertView == null ) {
				
				convertView = inflater.inflate(R.layout.activity_page__activity1, null);
				holder = new Holder();
				holder.Chi_SHow1 =(Button)convertView.findViewById(R.id.Chi_Show1);
				holder.Chi_SHow2 =(Button)convertView.findViewById(R.id.Chi_Show2);
				holder.Chi_SHow3 =(Button)convertView.findViewById(R.id.Chi_Show3);
				holder.Chi_SHow4 =(Button)convertView.findViewById(R.id.Chi_Show4);
				holder.Eng_Show1 =(TextView)convertView.findViewById(R.id.Eng_Show1);
				convertView.setTag(holder);
			}else {
				holder = (Holder) convertView.getTag();
			}
			
			
			return convertView;
		}
		
	}
	
	public class Holder{

		
		TextView Eng_Show1;
		Button Chi_SHow1;
		Button Chi_SHow2;
		Button Chi_SHow3;
		Button Chi_SHow4;
		
	}

	*/
	
	
	//========================================================
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_page__activity1);
		
		ArrayList<MyFragment> fragments;
		MyPageAdapter pageadapter;
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
		
		//设置布局大框架
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		Log.i("test", "1111111");
		
		fragments = new ArrayList<MyFragment>();
		//创建子视图
		for(int i = 0; i<12; i++) {
			
			//fragments.add(new MyFragment());
		}
		Log.i("test", "222222222222");
		
		//设置设配器，将视图绘制fragment
		pageadapter = new MyPageAdapter(getSupportFragmentManager(),fragments);
		viewPager.setAdapter(pageadapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.page__activity1, menu);
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
