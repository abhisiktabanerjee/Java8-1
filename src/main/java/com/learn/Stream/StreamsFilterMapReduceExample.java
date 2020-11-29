package com.learn.Stream;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.function.Predicate;

public class StreamsFilterMapReduceExample {

    static Predicate<Student> genderPredicte =(student -> {
        return student.getGender().equals("male");
    });

    static Predicate<Student> gradeLevel =(student -> {
        return student.getGradeLevel()==2.0;
    });

    private static int noOfNoteBooks(){

        int totalNoOfnoteBooks = StudentDataBase.getAllStudents().stream()
              //  .filter(genderPredicte)
                .filter(gradeLevel) //on filtering , we get the stream<Students> with matching criteria.
                .map((Student::getNoteBooks)) //using method reference with :: instead of object reference and this return a stream <Integer> i.e no of notebooks of students matchign the filteration
             //  .reduce(0,(a,b)->a+b); //summing the notebooks.
                .reduce(0,Integer::sum); //summing the notebooks.
        	//	.reduce((s1,s2)-> s1.getNoteBooks() + s2.getNoteBooks());
        return  totalNoOfnoteBooks;

    }
    public static void main(String[] args) {

        System.out.println("Total No of NoteBooks are : " + noOfNoteBooks());
    }
}