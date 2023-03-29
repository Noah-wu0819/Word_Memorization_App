package com.example.reciteapp.view;

import com.example.reciteapp.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LVC extends LinearLayout {
	private int flag = 0;
	private TextView title_text;
	
	public LVC(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO 自动生成的构造函数存根
		LayoutInflater.from(context).inflate(R.layout.title_bar, this);
        Button btn = (Button)findViewById(R.id.title_back);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				 ((Activity) getContext()).finish();
			}
		});
        title_text = (TextView)findViewById(R.id.title_text);
        title_text.setText("List选择");
        
       
	}
	

	
	public void setText_1(String s) {
		 title_text = (TextView)findViewById(R.id.title_text);
        	title_text.setText(s);
	}

}
