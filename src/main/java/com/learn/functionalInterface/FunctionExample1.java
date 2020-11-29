package com.learn.functionalInterface;

public class FunctionExample1 {

	public static String performConcat(String str) {
		String result = FunctionExample.function.compose(FunctionExample.andSomeString).apply(str);
		return result;
	}

	public static void main(String[] args) {
// TODO Auto-generated method stub
		String result = performConcat("hello from new class");
		System.out.println("Result is : " + result);

	}

}
