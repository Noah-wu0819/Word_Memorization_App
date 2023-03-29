package com.example.recite.adapter;

import java.util.ArrayList;

import com.example.recite.fragment.MyFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPageAdapter extends FragmentStatePagerAdapter {



	//适配器，减少内存的类型
	private final ArrayList<MyFragment> fragments;

	public MyPageAdapter(FragmentManager fm, ArrayList<MyFragment> fragments ) {
		super(fm);
		this.fragments = fragments;
		// TODO 自动生成的构造函数存根
	}

	/**
	 * 根据位置返回对应的fragment
	 * @param position
	 * @return
	 */
	@Override
	public Fragment getItem(int position) {
		// TODO 自动生成的方法存根
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return fragments.size();
	}

	
}
