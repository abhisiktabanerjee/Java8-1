package com.learn.functionalInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.learn.Predicate.PredicateExample;
import com.learn.data.*;

public class FunctionStudentExample {

	static Function<List<Student>, Map<String, Double>> studentFunc = (studentList) -> {
		Map<String, Double> studMap = new HashMap();

		studentList.forEach(students -> {
			if (PredicateExample.p1.test(students))
				studMap.put(students.getName(), students.getGpa());
		});

		return studMap;

	};

	public static void main(String[] args) {
// TODO Auto-generated method stub
		System.out.println(studentFunc.apply(StudentDataBase.getAllStudents()));

	}

}
