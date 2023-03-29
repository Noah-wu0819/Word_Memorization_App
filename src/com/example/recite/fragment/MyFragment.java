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
 * 碎片构成每一个翻页内容
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
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}
	/**
	 * 关联UI,将所设置的layout形成view,把此UI布局元素填充到fragment区域中。
	 */
	//填充 fragment
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		
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
