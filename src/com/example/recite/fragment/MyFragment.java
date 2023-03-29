package com.example.recite.fragment;

import java.util.List;

import com.example.entity.Word;
import com.example.reciteapp.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * ��Ƭ����ÿһ����ҳ����
 * @author Jackson
 *
 */
public class MyFragment extends Fragment {

	private TextView Chi_Show;
	private TextView Eng_Show;
	private TextView For_Show;
	private TextView List_Show;
	Word word = null;
	Context mContext;
	public MyFragment(Word word) {
		this.word = word;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}
	/**
	 * ����UI,�������õ�layout�γ�view,�Ѵ�UI����Ԫ����䵽fragment�����С�
	 */
	//��� fragment
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		
		Log.i("test", "222222222111111111111111222");
		View view = inflater.inflate(R.layout.fragment_layout	, container, false);
		Chi_Show = (TextView) view.findViewById(R.id.Chi_Show);
		Eng_Show = (TextView) view.findViewById(R.id.Eng_Show);
		For_Show = (TextView) view.findViewById(R.id.For_Show);
		//List_Show = (TextView) view.findViewById(R.id.List_Show);
		
		Chi_Show.setText(word.getChi());
		Eng_Show.setText(word.getEng());
		For_Show.setText(word.getForget_Num()+"");
		//List_Show.setText(word.getList_Num()+"");
		return view;
	}
	
}
