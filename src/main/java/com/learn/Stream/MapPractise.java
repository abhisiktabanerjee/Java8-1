package com.learn.Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

public class MapPractise {
	
	public static void Test(List<Student> studentList) {
		List result = studentList.stream()
			.map(Student::getGpa)
			.filter(s-> s>3.8)
			.collect(Collectors.toList());
		
		System.out.println(result); //filter is used to satisfy a condition
	}
	
	public static void Test1(List<Student> studentList) {
		Double result = studentList.stream()
			.map(Student::getGpa)
			.reduce(0.0,Double::max);
		
		System.out.println(result); //using only map and reduce to find the maximum gpa
	}
	
	public static void Test2(List<Student> studentList) {
		Double result = studentList.stream()
				.filter(s-> s.getGender().equals("male"))
			.map(Student::getGpa)
			.reduce(0.0,Double::max);
		
		System.out.println(result); //filter is used before map to find out the maximum gpa of a male student
	}
	
	
	
	 public static void main(String[] args) {

		 Test(StudentDataBase.getAllStudents());
		 Test1(StudentDataBase.getAllStudents());
		 Test2(StudentDataBase.getAllStudents());

	    }


}
