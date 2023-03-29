package com.example.recite.adapter;

import java.util.List;

import com.example.entity.Rec_Element;
import com.example.reciteapp.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
public class Review_Adapter extends ArrayAdapter<Rec_Element> {
	
	private int resourceId;
	private Context mContext;
	private List<Rec_Element> relist;
	 public Review_Adapter( Context mContext,int resourceId, List<Rec_Element> relist) {
		 
		super(mContext, resourceId, relist);
		this.resourceId = resourceId;
		this.mContext = mContext;
		this.relist = relist;
	}

	 @Override
	public Rec_Element getItem(int position) {
		// TODO 自动生成的方法存根
		return relist.get(position);
	}
	 
	public View getView(int position, View convertView , ViewGroup parent) {
		 
		 Rec_Element rec = getItem(position);
		 View view = LayoutInflater.from(mContext).inflate(R.layout.recite_list, parent, false);
		 TextView tv = (TextView) view.findViewById(R.id.Rev_For_Num);
		 tv.setText(rec.getNum()+"");
		 
		
		return view;
		 
	 }
	
	
}

