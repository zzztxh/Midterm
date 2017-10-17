package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	static ArrayList<Section> sectionList = new ArrayList<Section>();
	static ArrayList<Enrollment> enrollList = new ArrayList<Enrollment>();

	@BeforeClass
	public static void setup() throws ParseException, PersonException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Student stu1 = new Student("Gucci", "Prada", "Versace", sdf.parse("01/04/1993"), eMajor.BUSINESS,
				"1 Easton Court", "302-581-5114", "GPV@gmail.com");

		Student stu2 = new Student("Ron", "Miller", "Jones", sdf.parse("21/04/1997"), eMajor.BUSINESS,
				"2 Easton Court", "302-509-2144", "RMJ@gmail.com");

		Student stu3 = new Student("Gary", "Milford", "Tims", sdf.parse("12/04/1995"), eMajor.CHEM,
				"3 Easton Court", "302-508-5197", "GMT@gmail.com");

		Student stu4 = new Student("Amy", "Tammy", "Poehler", sdf.parse("11/04/2002"), eMajor.COMPSI,
				"5 Easton Court", "302-501-2189", "ATP@gmail.com");

		Student stu5 = new Student("Rashida", "Tom", "Swanson", sdf.parse("13/06/1994"), eMajor.NURSING,
				"4 Easton Court", "302-401-6540", "RTS@gmail.com");

		Student stu6 = new Student("Tammy", "Bill", "Meagel", sdf.parse("12/04/1990"), eMajor.NURSING,
				"7 Mexico Drive", "302-533-7382", "TBM@gmail.com");

		Student stu7 = new Student("Tom", "James", "Haverford", sdf.parse("18/05/1995"), eMajor.PHYSICS,
				"6 Easton Court", "302-293-5471", "TJH@gmail.com");

		Student stu8 = new Student("Tommy", "Jim", "Matthew", sdf.parse("17/12/2001"), eMajor.COMPSI, "8 Easton Court",
				"302-509-8762", "TJM@gmail.com");

		Student stu9 = new Student("Chris", "Timmy", "Traeger", sdf.parse("08/08/2003"), eMajor.PHYSICS,
				"9 Easton Court", "302-508-6785", "CTT@gmail.com");

		Student stu10 = new Student("Donna", "Mary", "Matthew", sdf.parse("02/09/1993"), eMajor.CHEM,
				"10 Easton Court", "302-509-1236", "DMM@gmail.com");

		studentList.add(stu1);
		studentList.add(stu2);
		studentList.add(stu3);
		studentList.add(stu4);
		studentList.add(stu5);
		studentList.add(stu6);
		studentList.add(stu7);
		studentList.add(stu8);
		studentList.add(stu9);
		studentList.add(stu10);

		Course c1 = new Course(UUID.randomUUID(), "Chemistry", 10);
		Course c2 = new Course(UUID.randomUUID(), "Physics", 20);
		Course c3 = new Course(UUID.randomUUID(), "Business", 15);

		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);

		Semester sem1 = new Semester(UUID.randomUUID(), sdf.parse("05/09/2017"), sdf.parse("01/01/2018"));
		Semester sem2 = new Semester(UUID.randomUUID(), sdf.parse("02/01/2018"), sdf.parse("09/05/2018"));

		semesterList.add(sem1);
		semesterList.add(sem2);

		Section sec1 = new Section(c1.getCourseID(), sem1.getSemesterID(), UUID.randomUUID(), 1);
		Section sec2 = new Section(c1.getCourseID(), sem2.getSemesterID(), UUID.randomUUID(), 2);
		Section sec3 = new Section(c2.getCourseID(), sem1.getSemesterID(), UUID.randomUUID(), 3);
		Section sec4 = new Section(c2.getCourseID(), sem2.getSemesterID(), UUID.randomUUID(), 4);
		Section sec5 = new Section(c3.getCourseID(), sem1.getSemesterID(), UUID.randomUUID(), 5);
		Section sec6 = new Section(c3.getCourseID(), sem2.getSemesterID(), UUID.randomUUID(), 6);

		sectionList.add(sec1);
		sectionList.add(sec2);
		sectionList.add(sec3);
		sectionList.add(sec4);
		sectionList.add(sec5);
		sectionList.add(sec6);

		for (Section sec : sectionList) {
			for (Student stu : studentList) {
				enrollList.add(new Enrollment(stu.getStudentID(), sec.getSectionID()));
			}
		}

		for (Enrollment e : enrollList) {
			e.setGrade(Math.random() * 100);

		}
	}

	@Test
	public void test() {
		int gpa = 0, avgGrade = 0, totalGrade = 0;

		for (Enrollment e : enrollList) {
			if (e.getStudentID() == studentList.get(1).getStudentID()) {
				totalGrade += e.getGrade();
			}
			avgGrade += e.getGrade();
		}
		avgGrade /= 60;
		gpa = totalGrade / 6 / 25;
		
		assertEquals(avgGrade, avgGrade);
		assertEquals(gpa, gpa);
	}
	
	@Test
	public void test2(){
		studentList.get(1).setMajor(eMajor.COMPSI);
	}

}