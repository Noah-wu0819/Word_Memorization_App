package com.example.reciteapp.Recite;

import java.util.ArrayList;
import java.util.List;

import com.example.reciteapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List_Choose extends Activity {

	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_list__choose);
		//setContentView(listView);
		listView = (ListView)findViewById(R.id.listView1);
		listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_single_choice, getData()));
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		//添加单击事件
		listView.setOnItemClickListener(new OnItemClickListener() {
			
			

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO 自动生成的方法存根
				ArrayList<String> ar = (ArrayList<String>)getData();
				Intent i = new Intent(List_Choose.this, Page_Activity.class);
				Bundle bd = new Bundle();
				bd.putInt("List", position+1);
				i.putExtra("List", bd);
				Log.i("test", "您当前选择的是"+position+"，值为:"+ar.get(position));
				startActivity(i); 
			}
		});
	}
	
	private List<String> getData(){
		List<String> data = new ArrayList<String>();
		data.add("List1");
		data.add("List2");
		data.add("List3");
		data.add("List4");
		data.add("List5");
		data.add("List6");
		data.add("List7");
		data.add("List8");
		data.add("List9");
		data.add("List10");
		data.add("List11");
		data.add("List12");
		data.add("List13");
		data.add("List14");
		data.add("List15");
		data.add("List16");
		data.add("List17");
		data.add("List18");
		data.add("List19");
		data.add("List20");
		data.add("List21");
		data.add("List22");
		data.add("List23");
		data.add("List24");
		data.add("List25");
		data.add("List26");
		data.add("List27");
		data.add("List28");
		data.add("List29");
		data.add("List30");
		data.add("List31");
		
		return data;
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list__choose, menu);
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
