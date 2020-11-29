package com.learn.functionalInterface;

import java.util.List;
import java.util.function.BiConsumer;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

public class BiConsumerExample {

	public static void nameAndActivities() {
		BiConsumer<String, List<String>> biConsumer = (name, activities) -> {
			System.out.println("Name is: " + name + "Activity is :" + activities);
		};

		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach((student -> biConsumer.accept(student.getName(), student.getActivities())));
	}

	public static void main(String[] args) {
		BiConsumer<Integer, Integer> b1 = (a, b) -> {
			System.out.println("Multiplication is :" + a * b);
		};

		b1.accept(5, 4);
		nameAndActivities();
	}
}