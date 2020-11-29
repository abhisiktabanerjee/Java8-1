package com.learn.functionalInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.learn.Predicate.PredicateExample;
import com.learn.data.*;

public class BiFunctionExample {

	static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (studentList,
			studentPredicate) -> {
		Map<String, Double> map = new HashMap();
		studentList.forEach(student -> {
			if (studentPredicate.test(student)) {
				map.put(student.getName(), student.getGpa());
			}
		});
		return map;
	};

	public static void main(String[] args) {
// TODO Auto-generated method stub
		System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), PredicateExample.p1));

	}

}