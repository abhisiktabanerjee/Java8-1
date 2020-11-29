package com.learn.functionalInterface;

import java.util.List;
import java.util.function.Consumer;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

public class ConsumerExample {

	static Consumer<Student> c2 = (student) -> System.out.println(student);
	static Consumer<Student> c3 = (student) -> System.out.println(student.getName());
	static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

	public static void printStudents() {

		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(c2);

	}

	public static void printNameActivities() {

		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(c3.andThen(c4));
	}

	public static void printNameAndActivitiesUsingCondition() {

		System.out.println("printNameAndActivitiesUsingCondition :");
		List<Student> studentList = StudentDataBase.getAllStudents();

		studentList.forEach(student -> {
			if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
				c3.andThen(c4).andThen(c2).accept(student);
			}
		});
	}

	public static void main(String[] args) {
// TODO Auto-generated method stub

		Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
		c1.accept("Java 8");
		printStudents();
		printNameActivities();
		printNameAndActivitiesUsingCondition();
	}

}