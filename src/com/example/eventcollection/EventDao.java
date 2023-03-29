package com.example.eventcollection;

import com.example.database.Dao;
import com.example.entity.Event;

public class EventDao {
	
	
	public EventDao() {
		event = new Event();
	}
	public EventDao(Event event) {
		this.event = event;
	}
	
	
	private Event event;
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public void Start() {
		event.setB_time((int) System.currentTimeMillis());
		event.setDate();
		System.out.println("��ʼʱ��"+event.getB_time());
	}
	
	
	public void End(String name, int list, int score, int num, Dao dao) {
		event.setE_time((int) System.currentTimeMillis());
//		System.out.println("��ʼʱ��"+event.getB_time());
//		System.out.println("����ʱ��"+event.getE_time());
		event.setTime( (event.getE_time()-event.getB_time())/1000 );
		//System.out.println("ѧϰʱ��Ϊ��"+event.getTime());
		// name, time, list, score
		event.setName(name);
		event.setList(list);
		event.setScore(score);		
		event.setNum(num);
		
		dao.insert_event(event);
		System.out.println(event);
		System.out.println("ѧϰ���ƣ�"+event.getName());
		System.out.println("ѧϰʱ�䣺"+event.getTime());
		System.out.println("ѧϰList��"+event.getList());
		System.out.println("ѧϰ������"+event.getScore());
		System.out.println("ѧϰ������"+event.getNum());
		System.out.println("ѧϰʱ�䣺"+event.getDate());
		
		
	}
}
