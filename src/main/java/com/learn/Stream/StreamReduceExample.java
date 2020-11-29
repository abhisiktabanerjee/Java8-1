package com.learn.Stream;


import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.stream.Collector;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

public class StreamReduceExample {
	
	static BiPredicate<Integer,Integer> b1 = (s1,s2) ->s1>s2;

    public static int performMultiplication(List<Integer> integerList){

        return integerList.stream().reduce(1, (a,b) -> a*b);

    }

    public static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> integerList){

        return integerList.stream()
                .reduce( (a,b) -> a*b); // performs multiplication for each element in the stream and returns a new result fo.
    }

    public static String combineStudentNames(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .distinct()
                .reduce("",(a,b) -> a.concat(b));  // performs multiplication for each element in the stream.
    }

    public static Optional<Student> getHighestGradeStudent(){

        Optional<Student> studentOptional =  StudentDataBase.getAllStudents().stream()
                .reduce((s1,s2)->(s1.getGpa()>s2.getGpa()) ? s1 : s2);
        		
        return studentOptional;
    }
    
    public static List<Student> getNames(){

        List<Student> result =  StudentDataBase.getAllStudents().stream()
        		.filter(s1-> s1.getName().startsWith("A"))
        		.collect(toList());
        		
        return result;
    }




    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,3,5,7);
        //List<Integer> integerList = Arrays.asList();
        
        Optional<Integer> n = integerList.stream().reduce( (a,b) -> a+b);
        System.out.println(n.get());

        System.out.println("Result is : " + performMultiplication(integerList));
        Optional<Integer> result = performMultiplicationWithNoInitialValue(integerList);

        if(result.isPresent()){
            System.out.println("Result is : " +result.get());
        }else{
            System.out.println("Result is : " +0);
        }

        System.out.println(combineStudentNames());
        System.out.println(getHighestGradeStudent().get());
        System.out.println(getNames());
    }
}