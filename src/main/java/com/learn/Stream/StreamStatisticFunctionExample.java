package com.learn.Stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.learn.student.Student;

public class StreamStatisticFunctionExample {
	
	static Consumer<Student> c3 = (student) -> System.out.println(student.getName());
	static Predicate<Student> p1(Integer n) { return (s) -> s.getMarks()==n; }
	
	


	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Student>studentList = new ArrayList<Student>();
		String name[]= {"A","B","C","D","E","F","G","H","I","J"};
		for (int i=0;i<10;i++)
		{
			Student obj=new Student();
			obj.setName(name[i]);
			obj.setMarks(i+5);
			studentList.add(obj);
		}
		
		
		ArrayList<Integer> marks = new ArrayList<Integer>();
		for (Student s : studentList) {
			marks.add(s.getMarks());
		}
		
		IntSummaryStatistics stats = marks.stream().mapToInt((i)->i).summaryStatistics();
		int n = stats.getMax();
//		List <Student>name1 
//		= studentList.stream().filter(i->i.getMarks()==n).collect(Collectors.toList());	
//		
		studentList.stream().forEach(s->{ if(s.getMarks() == n)
			{c3.accept(s);}
		}
		);
		
		studentList.stream().forEach(t->{ if (p1(n).test(t)) {c3.accept(t); } } );
		
		//providing input parameter to a predicate for each student t.

	}

}
