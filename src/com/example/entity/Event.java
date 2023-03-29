package com.example.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.Time;

public class Event implements Parcelable{

	private int time;
	private String name;
	private int list;
	private int score;
	private int num;
	
	private int b_time;
	private int e_time;
	
	public int getB_time() {
		return b_time;
	}
	public void setB_time(int b_time) {
		this.b_time = b_time;
	}
	public int getE_time() {
		return e_time;
	}
	public void setE_time(int e_time) {
		this.e_time = e_time;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	private Time ddd = new Time("GMT+8");
	private String date;
	
	
	public void setDate() {
		ddd.setToNow();
		String s = (ddd.month+1) +"."+ (ddd.monthDay);
		System.out.println(s);
		
		this.date = s;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getList() {
		return list;
	}
	public void setList(int list) {
		this.list = list;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDate() {
		
		return date;
	}
	
	public Event() {
		super();
		this.name ="x";
		this.time = 0;
		this.list = 0;
		this.score = 0;
		this.num = 0;
		this.date = "0.0";
		this.b_time=0;
		this.e_time=0;
	}
	
	@Override
	public int describeContents() {
		// TODO 自动生成的方法存根
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO 自动生成的方法存根
		
		dest.writeInt(b_time);
		dest.writeString(name);
		dest.writeInt(time);
		dest.writeInt(list);
		dest.writeInt(score);
		dest.writeInt(num);
		dest.writeString(date);
		
	}
	
	public static final Parcelable.Creator<Event> CREATOR = new Creator<Event>() {
		@Override
		public Event[] newArray(int size) {
			return new Event[size];
		}
		
		@Override
		public Event createFromParcel(Parcel source) {
			
			Event e = new Event();
			e.setB_time(source.readInt());
			e.setName(source.readString());
			e.setTime(source.readInt());
			e.setList(source.readInt());
			e.setScore(source.readInt());
			e.setNum(source.readInt());
			e.setDate(source.readString());
			
			return e;
		}
	};
}
