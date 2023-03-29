package com.example.eventcollection;

import java.util.ArrayList;
import java.util.List;

import com.example.database.Dao;
import com.example.entity.Event;

public class Event_Analyze {

	public Event ed ;
	public String date =null;
	private List<Event> evlist = new ArrayList<Event>();
	private List<Event> evlist2 = new ArrayList<Event>();
	
	public String getDate() {
		String s = null;
		ed = new Event();
		ed.setDate();
		s = ed.getDate();
		return  s;
	}
	public Event_Analyze(){};
	
	/*
	 * 速率计算过程算法
	 * 
	 */
	public float Velocity(Dao dao, String goal) {
		String s = getDate();
		float velocity = 0;
		int sumTime = 0;
		float right = 0;
		int score = 0;
		int sumNum = 0;
		
		if(goal == "review") {
			evlist = dao.queryEv_Rev(s);
		}else if(goal == "test") {
			evlist = dao.queryEv_Tes(s);
		}else if(goal == "recite") {
			evlist = dao.queryEv_Rec(s);
			//System.out.println("recite:Event_Analyze");
		}
		
		if(goal != "test") {
			for(int i = 0; i < evlist.size(); i++) {
				sumTime += evlist.get(i).getTime();
				sumNum  += evlist.get(i).getNum();
				System.out.println(goal+"速率:"+velocity);
				
			}
			if(sumNum!=0)
				velocity = ((float)sumNum/sumTime)/2;
			else
				velocity =0;
			//System.out.println(goal+"速率:"+velocity);
			
			return velocity;
			
		}else {
			for(int i = 0; i < evlist.size(); i++) {
				score  += evlist.get(i).getScore();
				sumNum += evlist.get(i).getNum();
			}
			if(sumNum!=0)
				right = (float)score/sumNum;
			else
				right =0;
			//System.out.println(goal+"正确率:"+right);
			
			return right;
		}
		

	}
/***
 * 比例计算过程算法
 * @param dao 数据库操作对象
 * @param goal 计算目标
 * @return
 */
	public float Proportion(Dao dao, String goal) {
		String s = getDate();
		float proportion = 0;
		int sum = 0;
		int numerator = 0;
		
		
		//计算分母
		evlist = dao.query_Event(s);
		for(int i = 0; i < evlist.size(); i++) {
			sum += evlist.get(i).getNum();
		}
		
		//计算分子,加入numerator = 0 减少数据耦合性
		if(goal == "review") {
			numerator = 0;
			evlist2 = dao.queryEv_Rev(s);
			for(int i = 0; i < evlist2.size(); i++) {
				System.out.println("review"+evlist2.get(i).getNum());
				numerator += evlist2.get(i).getNum();
			}
			System.out.println("review比例分子"+numerator);
		}else if(goal == "test") {
			
			numerator = 0;
			dao.queryEv_Tes(s);
			evlist2 = dao.queryEv_Tes(s);
			for(int i = 0; i < evlist2.size(); i++) {
				System.out.println("test"+evlist2.get(i).getNum());
				numerator += evlist2.get(i).getNum();
			}
			System.out.println("test比例分子"+numerator);
		}else if(goal == "recite") {
			numerator = 0;
			dao.queryEv_Rec(s);
			evlist2 = dao.queryEv_Rec(s);
			for(int i = 0; i < evlist2.size(); i++) {
				System.out.println("recite"+i+evlist2.get(i).getNum());
				numerator += evlist2.get(i).getNum();
			}
			System.out.println("recite比例分子"+numerator);
		}
		if(sum!=0)
			proportion = (float)numerator/ sum;
		else 
			proportion = 0;
	 return proportion;
}


}
