package com.learn.functionalInterface;

import java.util.Arrays;
import java.util.function.Supplier;

import com.learn.data.Student;

public class SupplierExample {

	public static void main(String[] args) {
// TODO Auto-generated method stub

		Supplier<Student> studentsupplier = () -> {
			return new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));
		};

		System.out.println("Student is :" + studentsupplier.get());
	}

}