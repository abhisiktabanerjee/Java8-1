package com.learn.Predicate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

public class PredicateAndCosumerExample {

	Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;
	
	BiConsumer<String, List<String>> b1 = (name, activity) -> {
		System.out.println("Name is :" + name + " Activity is :" + activity);
	};
	BiPredicate<Integer, Double> b2 = (grade, gpa) -> grade > 3 && gpa >= 3.9;
	


	Consumer<Student> c1 = (student -> {
		if (p1.and(p2).test(student)) {
			b1.accept(student.getName(), student.getActivities());
		}
	});

	Consumer<Student> c2 = (student -> {
		if (b2.test(student.getGradeLevel(), student.getGpa())) {
			b1.accept(student.getName(), student.getActivities());
		}
	});

	public void printNameAndActivities(List<Student> studlist) {
		studlist.forEach(c1);
	}

	public static void main(String[] args) {
    // TODO Auto-generated method stub
		List<Student> studentlist = StudentDataBase.getAllStudents();
		new PredicateAndCosumerExample().printNameAndActivities(studentlist);
	}

}
