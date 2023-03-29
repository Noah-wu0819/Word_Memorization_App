package com.example.reciteapp;

import com.example.database.Dao;
import com.example.entity.Word;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends Activity {

	private Button Search_btn;
	private TextView Chi_Search;
	private TextView Eng_Search;
	private EditText Search_Text;
	private Word word;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search);
		Chi_Search = (TextView)findViewById(R.id.Chi_Search);
		Search_btn = (Button)findViewById(R.id.Search_btn);
		Eng_Search = (TextView)findViewById(R.id.Eng_Search);
		Search_Text = (EditText)findViewById(R.id.Search_Text);
		final Dao dao = new Dao(getApplicationContext());
		
		
		
		Search_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				word = dao.query_word_eng(Search_Text.getText().toString());
					
					Chi_Search.setText(word.getChi());
					Eng_Search.setText(word.getEng());
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
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
