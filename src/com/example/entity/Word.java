package com.example.entity;

public class Word {

	private String Eng;
	private String Chi;
	private int List_Num;
	private int Forget_Num;
	private int w_id;
	
	public Word() {
		Eng = null;
		Chi = null;
		
		List_Num = 0;
		Forget_Num = 0;
		
	};
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public Word(String eng, String chi) {
		super();
		Eng = eng;
		Chi = chi;
	}
	public Word(String eng, String chi, int list_Num, int forget_Num) {
		super();
		Eng = eng;
		Chi = chi;
		List_Num = list_Num;
		Forget_Num = forget_Num;
	}
	public Word(String eng, String chi, int list_Num) {
		super();
		Eng = eng;
		Chi = chi;
		List_Num = list_Num;
	}
	
	public String getEng() {
		return Eng;
	}
	public void setEng(String eng) {
		Eng = eng;
	}
	public String getChi() {
		return Chi;
	}
	public void setChi(String chi) {
		Chi = chi;
	}
	public int getList_Num() {
		return List_Num;
	}
	public void setList_Num(int list_Num) {
		List_Num = list_Num;
	}
	public int getForget_Num() {
		return Forget_Num;
	}
	public void setForget_Num(int forget_Num) {
		Forget_Num = forget_Num;
	}
}
