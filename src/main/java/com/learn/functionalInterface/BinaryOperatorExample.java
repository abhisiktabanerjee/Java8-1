package com.learn.functionalInterface;
import java.util.Comparator;
import java.util.function.*;

public class BinaryOperatorExample {

static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);


public static void main(String[] args) {
// TODO Auto-generated method stub

BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;
System.out.println(binaryOperator.apply(3, 4));

BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
System.out.println("Result of maxBy: " + maxBy.apply(4, 5));

BinaryOperator<Integer> minOf = BinaryOperator.minBy(comparator);
System.out.println("Result of minOf: " + minOf.apply(1, 9));

}

}
