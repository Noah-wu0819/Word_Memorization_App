package com.example.recite.review;

import java.util.ArrayList;
import java.util.List;

import com.example.database.Dao;
import com.example.entity.Word;
import com.example.eventcollection.EventDao;
import com.example.recite.adapter.ReviwWord_Adapter;
import com.example.reciteapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class Review_Word extends ActionBarActivity {
	private EventDao ed;
	private List<Integer> nums ;
	private ListView listView;
	private List<Word> words = new ArrayList<Word>();
	private Dao dao;
	
	public List<Word> getData(Integer For_Num) {
		List<Word> word_rtn = new ArrayList<Word>();
		Dao dao = new Dao(getApplicationContext());
		word_rtn = dao.query_For(For_Num);
		return word_rtn;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_review__word);
		dao = new Dao(getApplicationContext());
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		    if(actionBar != null){
		        actionBar.setHomeButtonEnabled(true);
		        actionBar.setDisplayHomeAsUpEnabled(true);
		    }
		ed =  new EventDao();
		Intent ii = getIntent();
		Integer mes = ii.getIntExtra("For_Num", -1);
		
		words = getData(mes);
		
		
		listView = (ListView)findViewById(R.id.Rec_wordlist);
		ReviwWord_Adapter adapter = new ReviwWord_Adapter(getApplicationContext(), R.id.Rec_wordlist, words);
		listView.setAdapter(adapter);
		ed.Start();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.review__word, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
        case android.R.id.home:
        	ed.End("review", 32, 0, words.size(), dao);
            this.finish(); // back button
            
            return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
