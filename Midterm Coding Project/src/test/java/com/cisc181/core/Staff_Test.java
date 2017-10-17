package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.eTitle;

public class Staff_Test {

	static ArrayList<Staff> staffList = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() throws PersonException, ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Staff s1 = new Staff("Tian", "Hao", "Zhao", sdf.parse("21/12/1997"), "7 Christina Drive",
				"732-184-1951", "TZ@gmail.com", "10am-2pm", 3, 1500.50, sdf.parse("1/11/2004"), eTitle.MR);
		
		Staff s2 = new Staff("Di", "Xiao", "Zhang", sdf.parse("20/01/1995"), "7 Christina Drive",
				"701-193-1811", "DZy@gmail.com", "9am-1pm", 3, 1300.50, sdf.parse("1/11/2004"), eTitle.MRS);
		
		Staff s3 = new Staff("Tong", "Sb", "Zhao", sdf.parse("10/04/1996"), "1 Easton Court",
				"104-581-8311", "TSZ@gmail.com", "9pm-1am", 3, 200.30, sdf.parse("24/06/2005"), eTitle.MRS);
		
		Staff s4 = new Staff("Zhuo", "Qi", "Li", sdf.parse("14/01/1995"), "1 Easton Court",
				"130-138-8531", "ZL@gmail.com", "9pm-10pm", 3, 800.30, sdf.parse("11/12/2007"), eTitle.MR);
		
		Staff s5 = new Staff("Han", "Wen", "Yin", sdf.parse("21/01/1996"), "1 Easton Court",
				"194-318-9511", "HY@gmail.com", "12pm-3pm", 3, 500.60, sdf.parse("1/12/2006"), eTitle.MR);
	
		staffList.add(s1);
		staffList.add(s2);
		staffList.add(s3);
		staffList.add(s4);
		staffList.add(s5);
		
	}

	@Test
	public void test() {
		
		// The Real average salary : 860.44
		double avgSal = 0;
		for(Staff staff : staffList){
			avgSal += staff.getSalary();
		}
		avgSal /= staffList.size();
	    assertEquals(avgSal, 860.44, 0.01);
	}	
	
	@Test(expected= PersonException.class)
	public void testageException() throws PersonException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Staff s1 = new Staff("Beijing", "Shanghai", "Guangzhou", sdf.parse("01/01/1800"), "4546 Easton Court",
				"123-456-7892", "BSG@gmail.com", "12pm-3pm", 3, 1800.30, sdf.parse("4/7/2002"), eTitle.MR);
	
		
	}
	@Test(expected= PersonException.class)
	public void testphoneException() throws PersonException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Staff s1 = new Staff("Beijing", "Shanghai", "Guangzhou", sdf.parse("01/01/1997"), "4546 Easton Court",
				"123-456-78923", "BSG@gmail.com", "12pm-3pm", 3, 1800.30, sdf.parse("4/7/2002"), eTitle.MR);
	}
}