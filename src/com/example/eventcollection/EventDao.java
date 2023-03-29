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
		System.out.println("开始时间"+event.getB_time());
	}
	
	
	public void End(String name, int list, int score, int num, Dao dao) {
		event.setE_time((int) System.currentTimeMillis());
//		System.out.println("开始时间"+event.getB_time());
//		System.out.println("结束时间"+event.getE_time());
		event.setTime( (event.getE_time()-event.getB_time())/1000 );
		//System.out.println("学习时间为："+event.getTime());
		// name, time, list, score
		event.setName(name);
		event.setList(list);
		event.setScore(score);		
		event.setNum(num);
		
		dao.insert_event(event);
		System.out.println(event);
		System.out.println("学习名称："+event.getName());
		System.out.println("学习时间："+event.getTime());
		System.out.println("学习List："+event.getList());
		System.out.println("学习分数："+event.getScore());
		System.out.println("学习个数："+event.getNum());
		System.out.println("学习时间："+event.getDate());
		
		
	}
}
