package com.learn.functionalInterface;

import java.util.function.UnaryOperator;

public class UnaryOpearatorExample {

	static UnaryOperator<String> unaryOpearator = (s) -> s.concat("Default");
	static UnaryOperator<Integer>  op1 = i -> i*3;
	static UnaryOperator<Integer> op2 = i -> i+10;
	

	public static void main(String[] args) {
// TODO Auto-generated method stub

		System.out.println(unaryOpearator.apply("Java 8"));
		System.out.println("And then output is : " + op1.andThen(op2).apply(5));  //5*3 = 15 +10 = 25
		System.out.println("Compose output is : " + op1.compose(op2).apply(10)); //10+10 = 20 *3 =60

	}

}
