package com.learn.Predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

public class PredicateExample {
// static Predicate<Integer> p1=(i) -> i%2 ==0;
// static Predicate<Integer> p2=(i) -> i%5 ==0;

	public static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	static Predicate<Student> p2 = (s) -> s.getGradeLevel() > 3;
	static Predicate <Student> p3 = s-> s.getGpa()> 3;

	public static void filterStudentByGrade() {
		List<Student> studentlist = StudentDataBase.getAllStudents();
		studentlist.forEach(student -> {
			if (p1.test(student)) {
				System.out.println(student);
			}
		});

	}

	public static void filterStudentByGPA() {
		List<Student> studentlist = StudentDataBase.getAllStudents();
		studentlist.forEach(student -> {
			if (p2.and(p1).test(student)) {
				System.out.println(student);
			}
		});

	}

// public static void PredicateAnd() {
// System.out.println("Predicate first test:" +p1.test(4));
// System.out.println("Predicate And Test:" + p2.and(p1).test(10));
// System.out.println("Predicate And Test:" + p2.or(p1).test(8));
// System.out.println("Predicate And Test:" + p2.or(p1).test(7));
//
//
// }

	public static void main(String[] args) {
// TODO Auto-generated method stub

// PredicateAnd();
// filterStudentByGrade();
		//filterStudentByGPA();
		
		List <Student> stud = StudentDataBase.getAllStudents();
		List<Student> result = stud.stream().filter(p3.and(p1)).collect(Collectors.<Student>toList());
		System.out.println(result);
	
	}

}