package com.example.reciteapp.view;

import com.example.eventcollection.EventDao;
import com.example.reciteapp.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LVC_frag extends LinearLayout {
	private int num = 0;
	EventDao ed = new EventDao();
	private TextView title_text;
	
	public LVC_frag(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO �Զ����ɵĹ��캯�����
		LayoutInflater.from(context).inflate(R.layout.title_bar, this);
        Button btn = (Button)findViewById(R.id.title_back);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				 ((Activity) getContext()).finish();
			}
		});
        title_text = (TextView)findViewById(R.id.title_text);
        title_text.setText("���ʱ���");
        
       
	}
	

	public void sett(String s) {
		title_text = (TextView)findViewById(R.id.title_text);
		title_text.setText(s);
	}


}
