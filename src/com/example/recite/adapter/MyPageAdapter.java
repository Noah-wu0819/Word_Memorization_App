package com.example.recite.adapter;

import java.util.ArrayList;

import com.example.recite.fragment.MyFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPageAdapter extends FragmentStatePagerAdapter {



	//�������������ڴ������
	private final ArrayList<MyFragment> fragments;

	public MyPageAdapter(FragmentManager fm, ArrayList<MyFragment> fragments ) {
		super(fm);
		this.fragments = fragments;
		// TODO �Զ����ɵĹ��캯�����
	}

	/**
	 * ����λ�÷��ض�Ӧ��fragment
	 * @param position
	 * @return
	 */
	@Override
	public Fragment getItem(int position) {
		// TODO �Զ����ɵķ������
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
		return fragments.size();
	}

	
}
