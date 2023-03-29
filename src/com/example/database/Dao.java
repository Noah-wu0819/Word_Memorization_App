package com.example.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.entity.Event;
import com.example.entity.Test_Element;
import com.example.entity.Word;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
/**
 * ��������ڲ������ݿ����ɾ�Ĳ�
 * @author Jackson
 *
 */
public class Dao {

	private SQLiteDatabase db;
	private Random random = new Random();
	
	public Dao(Context context) {
		 SQL_Import im = new SQL_Import();
		 db = im.openDatabase(context);

	}
	/**
	 * �����ݿ��е��뵥�ʱ�
	 * @param words
	 */
	public void insert(List<Word> words) {
		
		db.beginTransaction();
		
		try {
			for(Word word: words) {
				
				db.execSQL("INSERT INTO WordList1 VALUES(?,?,?,?)",new Object[]{word.getEng(),word.getChi(),word.getList_Num(),0});
			}
			db.setTransactionSuccessful();
		} finally {
			// TODO: handle finally clause
			db.endTransaction();
		}
		
		
		
	}
	
	public void insert_event(Event event) {
		db.beginTransaction();
		String sql = "insert into Event(time, name, list, score, num, date) values(?, ?, ?, ?, ?, ?)";
		
		try {
			
			db.execSQL(sql, new Object[] {event.getTime(), event.getName(), event.getList(), event.getScore(), event.getNum(), event.getDate()});
			//Insert_Successful!!!!!!!!
			System.out.println("###########ѧϰ���ƣ�"+event.getName());
			System.out.println("###########ѧϰʱ�䣺"+event.getTime());
			System.out.println("###########ѧϰList��"+event.getList());
			System.out.println("###########ѧϰ������"+event.getScore());
			System.out.println("###########ѧϰ������"+event.getNum());
			System.out.println("###########ѧϰʱ�䣺"+event.getDate());
			db.setTransactionSuccessful();
		}finally {
			db.endTransaction();
		}
	}
	/**
	 * ��ѯ���е���,����һ�������ĵ��ʱ�
	 * @return
	 */
	public List<Word> query(){
		ArrayList<Word> words =new ArrayList<Word>();
		Cursor cr = queryTheCursor();
		
		while(cr.moveToNext()) {
			Word word = new Word();
			word.setW_id(cr.getInt(cr.getColumnIndex("id")));
			word.setEng(cr.getString(cr.getColumnIndex("Eng")));
			word.setChi(cr.getString(cr.getColumnIndex("Chi")));
			word.setList_Num(cr.getInt(cr.getColumnIndex("List_Num")));
			word.setForget_Num(cr.getInt(cr.getColumnIndex("Forget_Num")));
		}
		return words;
		
	}
	
	/**
	 * �����ض�forgetnum���Դ���ϼ�
	 */
	public List<Test_Element> query_RevTest(Integer For_Num) {
		db.beginTransaction();
		List<Test_Element> test_elements = new ArrayList<Test_Element>();
		String sql1 = "SELECT * FROM WordList11 WHERE id =?";
		String sql = "SELECT * FROM WordList11 WHERE Forget_Num = ?";
		Integer random_1 = null;
		Integer random_2 = null;
		Integer random_3 = null;
		Cursor cr = db.rawQuery(sql, new String[] {For_Num.toString()});
		Cursor cr1 = null;
		Cursor cr2 = null;
		Cursor cr3 = null;
		
		System.out.println(cr);
		//System.out.println(cr.getInt(cr.getColumnCount()));
		//Log.i("tt", cr.getString(cr.getColumnIndex("Eng")));
		cr.moveToFirst();
		 random_1 = (int)(random.nextInt(1001)+1);
		 random_2 = (int)(random.nextInt(1000) + 1001);
		 random_3 = (int)(random.nextInt(1041) + 2001);
		 
		 Cursor cr11 = db.rawQuery(sql1, new String[] {random_1.toString()});
		 Cursor cr22 = db.rawQuery(sql1, new String[] {random_2.toString()});
		 Cursor cr33 = db.rawQuery(sql1, new String[] {random_3.toString()});
		
		 cr11.moveToFirst();
		 cr22.moveToFirst();
		 cr33.moveToFirst();
		 
		
		
		
		Test_Element test_element1 = new Test_Element() {};
		test_element1.setEng_Show_Test(cr.getString(cr.getColumnIndex("Eng")));
		test_element1.setChi_Show_Test1(cr.getString(cr.getColumnIndex("Chi")));
		test_element1.setChi_Show_Test2(cr11.getString(cr11.getColumnIndex("Chi")));
		test_element1.setChi_Show_Test3(cr22.getString(cr22.getColumnIndex("Chi")));
		test_element1.setChi_Show_Test4(cr33.getString(cr33.getColumnIndex("Chi")));
		test_element1.setChi_Show_Test5(Constants.CHINESE);
		test_elements.add(test_element1);
			
		 cr11.close();
		 cr22.close();
		 cr33.close();
		while(cr.moveToNext()) {
			 random_1 = (int)(random.nextInt(1001)+1);
			 random_2 = (int)(random.nextInt(1000) + 1001);
			 random_3 = (int)(random.nextInt(1041) + 2001);
			 
			 cr1 = db.rawQuery(sql1, new String[] {random_1.toString()});
			 cr2 = db.rawQuery(sql1, new String[] {random_2.toString()});
			 cr3 = db.rawQuery(sql1, new String[] {random_3.toString()});
			
			 cr1.moveToFirst();
			 cr2.moveToFirst();
			 cr3.moveToFirst();
			
			System.out.println("succccccccessful");
			
			Test_Element test_element = new Test_Element() {};
			test_element.setEng_Show_Test(cr.getString(cr.getColumnIndex("Eng")));
			test_element.setChi_Show_Test1(cr.getString(cr.getColumnIndex("Chi")));
			test_element.setChi_Show_Test2(cr1.getString(cr1.getColumnIndex("Chi")));
			test_element.setChi_Show_Test3(cr2.getString(cr2.getColumnIndex("Chi")));
			test_element.setChi_Show_Test4(cr3.getString(cr3.getColumnIndex("Chi")));
			test_element.setChi_Show_Test5(Constants.CHINESE);
			test_elements.add(test_element);
			
		}
		db.setTransactionSuccessful();
		Log.i("tt", "11111asdasdasdasdasdas111111");
		cr.close();
		if(cr1!= null) cr1.close();
		if(cr2!= null) cr2.close();
		if(cr3!= null) cr3.close();
		db.endTransaction();
		//Log.i("tttt", test_elements.get(9).getChi_Show_Test3());
		return test_elements;
		
	}
	
	
	/**
	 * �����ض�List�Ŀ��Դ���ϼ�
	 * @param num
	 * @return
	 */
	public List<Test_Element> query_single(Integer List) {
		db.beginTransaction();
		List<Test_Element> test_elements = new ArrayList<Test_Element>();
		String sql1 = "SELECT * FROM WordList11 WHERE id =?";
		String sql = "SELECT * FROM WordList11 WHERE List_Num = ?";
		Integer random_1 = null;
		Integer random_2 = null;
		Integer random_3 = null;
		Cursor cr = db.rawQuery(sql, new String[] {List.toString()});
		Cursor cr1 = null;
		Cursor cr2 = null;
		Cursor cr3 = null;
		
		System.out.println(cr);
		//System.out.println(cr.getInt(cr.getColumnCount()));
		//Log.i("tt", cr.getString(cr.getColumnIndex("Eng")));
		cr.moveToFirst();
		 random_1 = (int)(random.nextInt(1001)+1);
		 random_2 = (int)(random.nextInt(1000) + 1001);
		 random_3 = (int)(random.nextInt(1041) + 2001);
		 
		 Cursor cr11 = db.rawQuery(sql1, new String[] {random_1.toString()});
		 Cursor cr22 = db.rawQuery(sql1, new String[] {random_2.toString()});
		 Cursor cr33 = db.rawQuery(sql1, new String[] {random_3.toString()});
		
		 cr11.moveToFirst();
		 cr22.moveToFirst();
		 cr33.moveToFirst();
		 
		
		
		
		Test_Element test_element1 = new Test_Element() {};
		test_element1.setEng_Show_Test(cr.getString(cr.getColumnIndex("Eng")));
		test_element1.setChi_Show_Test1(cr.getString(cr.getColumnIndex("Chi")));
		test_element1.setChi_Show_Test2(cr11.getString(cr11.getColumnIndex("Chi")));
		test_element1.setChi_Show_Test3(cr22.getString(cr22.getColumnIndex("Chi")));
		test_element1.setChi_Show_Test4(cr33.getString(cr33.getColumnIndex("Chi")));
		test_element1.setChi_Show_Test5(Constants.CHINESE);
		test_elements.add(test_element1);
			
		 cr11.close();
		 cr22.close();
		 cr33.close();
		while(cr.moveToNext()) {
			 random_1 = (int)(random.nextInt(1001)+1);
			 random_2 = (int)(random.nextInt(1000) + 1001);
			 random_3 = (int)(random.nextInt(1041) + 2001);
			 
			 cr1 = db.rawQuery(sql1, new String[] {random_1.toString()});
			 cr2 = db.rawQuery(sql1, new String[] {random_2.toString()});
			 cr3 = db.rawQuery(sql1, new String[] {random_3.toString()});
			
			 cr1.moveToFirst();
			 cr2.moveToFirst();
			 cr3.moveToFirst();
			
			//System.out.println("succccccccessful");
			
			Test_Element test_element = new Test_Element() {};
			test_element.setEng_Show_Test(cr.getString(cr.getColumnIndex("Eng")));
			test_element.setChi_Show_Test1(cr.getString(cr.getColumnIndex("Chi")));
			test_element.setChi_Show_Test2(cr1.getString(cr1.getColumnIndex("Chi")));
			test_element.setChi_Show_Test3(cr2.getString(cr2.getColumnIndex("Chi")));
			test_element.setChi_Show_Test4(cr3.getString(cr3.getColumnIndex("Chi")));
			test_element.setChi_Show_Test5(Constants.CHINESE);
			test_elements.add(test_element);
			
		}
		db.setTransactionSuccessful();
		//Log.i("tt", "11111asdasdasdasdasdas111111");
		cr.close();
		if(cr1!= null) cr1.close();
		if(cr2!= null) cr2.close();
		if(cr3!= null) cr3.close();
		db.endTransaction();
		//Log.i("tttt", test_elements.get(9).getChi_Show_Test3());
		return test_elements;
		
	}
	/**
	 * ��ѯ�ض����� ----id
	 * @param index
	 * @return
	 */
	public Word query_word(Integer index, SQLiteDatabase db1) {
		Word word = new Word();
		
		String sql1 = "SELECT * FROM WordList11 WHERE id =?";
		Cursor cr1 = db1.rawQuery(sql1, new String[] {index.toString()});
		
		System.out.println(cr1.getString(cr1.getColumnIndex("Eng")));
		System.out.println("����query_word");
		cr1.moveToFirst();
		word.setChi(cr1.getString(cr1.getColumnIndex("Chi")));
		word.setEng(cr1.getString(cr1.getColumnIndex("Eng")));
		//word.setList_Num(cr.getInt(cr.getColumnIndex("List_Num")));
		//word.setForget_Num(cr.getInt(cr.getColumnIndex("Forget_Num")));
		cr1.close();
		
		return word;
	}
	
	/**
	 * ��ѯ�ض�����----english
	 * @param index
	 * @return
	 */
	public Word query_word_eng(String Eng) {
		Word word = new Word();
		
		String sql1 = "SELECT * FROM WordList11 WHERE Eng =?";
		Cursor cr1 = db.rawQuery(sql1, new String[] {Eng});
		
		System.out.println("����query_word_eng");
		cr1.moveToFirst();
		if(cr1.getCount()!=0) {
			
			word.setChi(cr1.getString(cr1.getColumnIndex("Chi")));
			word.setEng(cr1.getString(cr1.getColumnIndex("Eng")));
		}else {
			word.setChi("�޴˵���");
			word.setEng("input invalid");
		}
		//word.setList_Num(cr.getInt(cr.getColumnIndex("List_Num")));
		//word.setForget_Num(cr.getInt(cr.getColumnIndex("Forget_Num")));
		cr1.close();
		
		return word;
	}
	/**
	 * ��ѯ�ض�Event
	 */
	public List<Event> queryEv_Tes(String date){
		//System.out.println("test���ʲ�ѯ");
		List<Event> eventlist = new ArrayList<Event>();
		String sql = "select * from Event where date = ? and (name = ? or name = ?)";
		Cursor cr = db.rawQuery(sql, new String[] { date,"test", "review_test"});
		cr.moveToFirst();
		if(cr.getCount()!=0) {
			Event e = new Event();
			e.setName(cr.getString(cr.getColumnIndex("name")));
			e.setNum(cr.getInt(cr.getColumnIndex("num")));
			e.setTime(cr.getInt(cr.getColumnIndex("time")));
			e.setScore(cr.getInt(cr.getColumnIndex("score")));
			eventlist.add(e);
			while(cr.moveToNext()) {
				Event e2 = new Event();
				e2.setName(cr.getString(cr.getColumnIndex("name")));
				e2.setNum(cr.getInt(cr.getColumnIndex("num")));
				e2.setTime(cr.getInt(cr.getColumnIndex("time")));
				e2.setScore(cr.getInt(cr.getColumnIndex("score")));
				eventlist.add(e2);
			}
		}else {
			Event e = new Event();
			System.out.println(e.getScore());
			eventlist.add(e);
			System.out.println("�����⣡������");
		}
		cr.close();
		//System.out.println("test���ʲ�ѯ����");
		return eventlist;
	}
	public List<Event> queryEv_Rev(String date){
		//System.out.println("review���ʲ�ѯ");
		List<Event> eventlist = new ArrayList<Event>();
		String sql = "select * from Event where date = ? and name = ? ";
		Cursor cr = db.rawQuery(sql, new String[] { date,"review"});
		cr.moveToFirst();
		if(cr.getCount()!=0) {
			Event e = new Event();
			e.setName(cr.getString(cr.getColumnIndex("name")));
			e.setNum(cr.getInt(cr.getColumnIndex("num")));
			e.setTime(cr.getInt(cr.getColumnIndex("time")));
			eventlist.add(e);
			while(cr.moveToNext()) {
				Event e2 = new Event();
				e2.setName(cr.getString(cr.getColumnIndex("name")));
				e2.setNum(cr.getInt(cr.getColumnIndex("num")));
				e2.setTime(cr.getInt(cr.getColumnIndex("time")));
				e2.setScore(cr.getInt(cr.getColumnIndex("score")));
				eventlist.add(e2);
			}
		}else {
			Event e = new Event();
			eventlist.add(e);
		}
		//System.out.println("review���ʲ�ѯ����");
		cr.close();
		return eventlist;
	}
	public List<Event> queryEv_Rec(String date){
		//System.out.println("recite���ʲ�ѯ");
		List<Event> eventlist = new ArrayList<Event>();
		String sql = "select * from Event where date = ? and name = ? ";
		Cursor cr = db.rawQuery(sql, new String[] { date,"recite"});
		cr.moveToFirst();
		//���� cr������Ϊ�գ�ֻ����getcount�ж�
		if(cr.getCount()!=0) {
			Event e = new Event();
			e.setName(cr.getString(cr.getColumnIndex("name")));
			e.setNum(cr.getInt(cr.getColumnIndex("num")));
			e.setTime(cr.getInt(cr.getColumnIndex("time")));
			e.setScore(cr.getInt(cr.getColumnIndex("score")));
			eventlist.add(e);
			while(cr.moveToNext()) {
				Event e2 = new Event();
				e2.setName(cr.getString(cr.getColumnIndex("name")));
				e2.setNum(cr.getInt(cr.getColumnIndex("num")));
				e2.setTime(cr.getInt(cr.getColumnIndex("time")));
				e2.setScore(cr.getInt(cr.getColumnIndex("score")));
				eventlist.add(e2);
			}
		}else {
			Event e = new Event();
			eventlist.add(e);
			}
		System.out.println(eventlist);
		System.out.println(eventlist.get(0));
		cr.close();
		//System.out.println("recite���ʲ�ѯ����");
		return eventlist;
	}
	
	public List<Event> query_Event(String date){
		List<Event> eventlist = new ArrayList<Event>();
		//System.out.println("event��ѯ");
		String sql = "select * from Event where date = ?  ";
		Cursor cr = db.rawQuery(sql, new String[] { date});
		cr.moveToFirst();
		if(cr.getCount()!=0) {
			Event e = new Event();
			e.setName(cr.getString(cr.getColumnIndex("name")));
			e.setNum(cr.getInt(cr.getColumnIndex("num")));
			e.setTime(cr.getInt(cr.getColumnIndex("time")));
			eventlist.add(e);
			while(cr.moveToNext()) {
				Event e2 = new Event();
				e2.setName(cr.getString(cr.getColumnIndex("name")));
				e2.setNum(cr.getInt(cr.getColumnIndex("num")));
				e2.setTime(cr.getInt(cr.getColumnIndex("time")));
				e2.setScore(cr.getInt(cr.getColumnIndex("score")));
				eventlist.add(e2);
			}
		}else {
			Event e = new Event();
			eventlist.add(e);
		}
		//System.out.println("event��ѯ����");
		cr.close();
		return eventlist;
	}
	
	/**
	 * ��ѯ�ض�List����
	 * @return
	 */
	public List<Word> query_Spc(Integer List){
		List<Word> words = new ArrayList<Word>() ;
		String sql = "select * from WordList11 where List_Num = ?";
		Cursor cr = db.rawQuery(sql, new String[] {List.toString()});
		cr.moveToFirst();
		Word word1 = new Word();
			word1.setW_id(cr.getInt(cr.getColumnIndex("id")));
			word1.setEng(cr.getString(cr.getColumnIndex("Eng")));
			word1.setChi(cr.getString(cr.getColumnIndex("Chi")));
			word1.setList_Num(cr.getInt(cr.getColumnIndex("List_Num")));
			word1.setForget_Num(cr.getInt(cr.getColumnIndex("Forget_Num")));
			words.add(word1);
		while(cr.moveToNext()) {
			Word word = new Word();
				word.setW_id(cr.getInt(cr.getColumnIndex("id")));
				word.setEng(cr.getString(cr.getColumnIndex("Eng")));
				word.setChi(cr.getString(cr.getColumnIndex("Chi")));
				word.setList_Num(cr.getInt(cr.getColumnIndex("List_Num")));
				word.setForget_Num(cr.getInt(cr.getColumnIndex("Forget_Num")));
				words.add(word);
		
		}
		cr.close();
		return words;
		
	}
	/**
	 * ��ѯ�ض�Forget_Num����
	 * @return
	 */
	public List<Word> query_For(Integer For_Num){
		List<Word> words = new ArrayList<Word>() ;
		String sql = "select * from WordList11 where Forget_Num = ?";
		Cursor cr = db.rawQuery(sql, new String[] {For_Num.toString()});
		cr.moveToFirst();
		Word word1 = new Word();
		if(cr.getInt(cr.getColumnIndex("Forget_Num"))==For_Num) {
			word1.setW_id(cr.getInt(cr.getColumnIndex("id")));
			word1.setEng(cr.getString(cr.getColumnIndex("Eng")));
			word1.setChi(cr.getString(cr.getColumnIndex("Chi")));
			word1.setList_Num(cr.getInt(cr.getColumnIndex("List_Num")));
			word1.setForget_Num(cr.getInt(cr.getColumnIndex("Forget_Num")));
			
			words.add(word1);
		}
		while(cr.moveToNext()) {
			Word word = new Word();
			if(cr.getInt(cr.getColumnIndex("Forget_Num"))==For_Num) {
				word.setW_id(cr.getInt(cr.getColumnIndex("id")));
				word.setEng(cr.getString(cr.getColumnIndex("Eng")));
				word.setChi(cr.getString(cr.getColumnIndex("Chi")));
				word.setList_Num(cr.getInt(cr.getColumnIndex("List_Num")));
				word.setForget_Num(cr.getInt(cr.getColumnIndex("Forget_Num")));
				words.add(word);
			}
		
		}
		cr.close();
		return words;
		
	}
	
	
	public Cursor queryTheCursor() {
		Cursor c=db.rawQuery("SELECT * FROM WordList11", null);		
		
		return c;
	}
	
	public Cursor queryWord_Cursor(Integer index) {
		String sql = "SELECT * FROM WordList11 WHERE List_Num = ?";
		//Cursor c = db.rawQuery(sql, index.toString());
		return null;
	}

	
	public void delete() {
		
		
		String sql = "delete from " + Constants.table_name + "where Eng = word";
		
		db.execSQL(sql);
		db.close();
	}
	public void update() {
	
		
		String sql = "update " + Constants.table_name + "set Eng = abc where Eng = word";
		
		db.execSQL(sql);
		db.close();
	}
	public void query111() {
	
		
		String sql = "select * from " + Constants.table_name ;
		
		db.execSQL(sql);
		Cursor cursor = db.rawQuery(sql, null);
		while(cursor.moveToNext()) {
			int index = cursor.getColumnIndex("Eng");
			String name = cursor.getString(index);
			Log.d("DAO", "Eng ==" + name);
		}
		cursor.close();
	}
	
	//���Ǳ���ȥ�ز�ѯ
	public List<Integer> query_dis() {
		List<Integer> ab = new ArrayList<Integer>();
		int i = 0;
		String sql = "select distinct Forget_Num from WordList11 order by Forget_Num";
		Cursor cr = db.rawQuery(sql, null);
		cr.moveToFirst();
		ab.add(cr.getInt(cr.getColumnIndex("Forget_Num")));
		while(cr.moveToNext()) {
			ab.add(cr.getInt(cr.getColumnIndex("Forget_Num")));
		}
		cr.close();
		return ab;
	}
	//sql���ִ�У����Ǳ���+1
	public void Update_For_Num(Integer id) {
		String sql = "select Forget_Num from WordList11 where id = ?";
		Cursor cr = db.rawQuery(sql, new String[] {id.toString()});
		cr.moveToFirst();
		System.out.println("++++++++++++++++++++++++++++++"+cr);
		Integer i = cr.getInt(cr.getColumnIndex("Forget_Num"));
		i=i+1;
		//System.out.println("����ǰ:"+cr.getInt(cr.getColumnIndex("Forget_Num")));
		
		ContentValues newvalues = new  ContentValues();
		newvalues.put("Forget_Num", i);
		String[] args = new String[] {id.toString()};
		db.update("WordList11", newvalues, "id=?", args);
		Cursor cr1 = db.rawQuery(sql, new String[] {id.toString()});
		cr1.moveToFirst();
		//System.out.println("���ĺ�:"+cr1.getInt(cr1.getColumnIndex("Forget_Num")));
		cr.close();
		cr1.close();
	}
	
}
