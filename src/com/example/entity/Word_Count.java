package com.example.entity;
/**
 * 一个计数类，用于单词翻页
 * @author Jackson
 *
 */
public class Word_Count {

	private int index;
	private int grade;
	public int Grade_Inc() {
		grade += 1;
		return grade;
	}
	public int GetGrade() {
		return grade;
	}
	
	public Word_Count() {
		super();
	}
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Word_Count(int index, int grade) {
		super();
		this.index = index;
		this.grade = grade;
	}
	
	
	public int Index_inc() {
		index = index +1;
		return index;
	}
	public int Index_dec() {
		if(index>0)
			index = index -1;
		return index;
	}
	public void  WC_Reset() {
		this.index = 0;
	}
}
