package com.example.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test_Element {

	private String Eng_Show_Test;
	private String Chi_Show_Test1;
	private String Chi_Show_Test2;
	private String Chi_Show_Test3;
	private String Chi_Show_Test4;
	private String Chi_Show_Test5;


	
	
	public Test_Element() {
		super();
		this.Eng_Show_Test = null;
		this.Chi_Show_Test1 = null;
		this.Chi_Show_Test2 = null;
		this.Chi_Show_Test3 = null;
		this.Chi_Show_Test4 = null;
		this.Chi_Show_Test5 = null;
	}
	public Test_Element(String eng_Show_Test, String chi_Show_Test1, String chi_Show_Test2, String chi_Show_Test3,
			String chi_Show_Test4, String chi_Show_Test5) {
		super();
		this.Eng_Show_Test = eng_Show_Test;
		this.Chi_Show_Test1 = chi_Show_Test1;
		this.Chi_Show_Test2 = chi_Show_Test2;
		this.Chi_Show_Test3 = chi_Show_Test3;
		this.Chi_Show_Test4 = chi_Show_Test4;
		this.Chi_Show_Test5 = chi_Show_Test5;
	}
	
	
	public String getEng_Show_Test() {
		return Eng_Show_Test;
	}
	public void setEng_Show_Test(String eng_Show_Test) {
		this.Eng_Show_Test = eng_Show_Test;
	}
	public String getChi_Show_Test1() {
		return Chi_Show_Test1;
	}
	public void setChi_Show_Test1(String chi_Show_Test1) {
		this.Chi_Show_Test1 = chi_Show_Test1;
	}
	public String getChi_Show_Test2() {
		return Chi_Show_Test2;
	}
	public void setChi_Show_Test2(String chi_Show_Test2) {
		this.Chi_Show_Test2 = chi_Show_Test2;
	}
	public String getChi_Show_Test3() {
		return Chi_Show_Test3;
	}
	public void setChi_Show_Test3(String chi_Show_Test3) {
		this.Chi_Show_Test3 = chi_Show_Test3;
	}
	public String getChi_Show_Test4() {
		return Chi_Show_Test4;
	}
	public void setChi_Show_Test4(String chi_Show_Test4) {
		this.Chi_Show_Test4 = chi_Show_Test4;
	}
	public String getChi_Show_Test5() {
		return Chi_Show_Test5;
	}
	public void setChi_Show_Test5(String chi_Show_Test5) {
		this.Chi_Show_Test5 = chi_Show_Test5;
	}
	
	public String getSpc_Show(Integer it) {
		switch(it) {
		
			case 0:
				return Chi_Show_Test1;
			case 1:
				return Chi_Show_Test2;
			case 2:
				return Chi_Show_Test3;
			case 3:
				return Chi_Show_Test4;
		}
		return null;
			
		
		
	}
}
