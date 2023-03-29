package com.example.recite.adapter;

import java.util.List;

import com.example.entity.Word;
import com.example.reciteapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ReviwWord_Adapter extends ArrayAdapter<Word> {

	private int resourceId;
	private Context mContext;
	private List<Word> words;
	public ReviwWord_Adapter(Context mContext, int resourceId, List<Word> words) {
		super(mContext, resourceId, words);
		// TODO 自动生成的构造函数存根
		this.resourceId = resourceId;
		this.mContext = mContext;
		this.words = words;
	}

	public Word getItem(int position) {
		return words.get(position);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		
		Word word = getItem(position);
		View view = LayoutInflater.from(mContext).inflate(R.layout.recite, parent, false);
		
		TextView Eng_Review = (TextView)view.findViewById(R.id.Eng_Review);
		TextView Chi_Review = (TextView)view.findViewById(R.id.Chi_Review);
		
		Eng_Review.setText(word.getEng());
		Chi_Review.setText(word.getChi());
		return view;
	}
}
