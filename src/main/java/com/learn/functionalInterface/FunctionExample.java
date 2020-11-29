package com.learn.functionalInterface;


import java.util.function.Function;

public class FunctionExample {

static Function<String, String> function = (name) -> name.toUpperCase().concat("First");
static Function<String, String> andSomeString = (name) -> name.toLowerCase().concat(" world");

static Function <String,String> demo = (i) -> i.toUpperCase();

public static void main(String[] args) {
// TODO Auto-generated method stub
System.out.println("Result is : " + function.apply("Hello"));
System.out.println("Result after adding is : " + function.andThen(andSomeString).apply("hello"));
System.out.println("Result after compose is : " + function.compose(andSomeString).apply("hello"));
}

}