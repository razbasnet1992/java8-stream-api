package com.dsr.java.java8;

import java.util.Arrays;
import java.util.Stack;

public class StackUsage {

	public static void main(String[] in) {
		Stack<Employee> s = new Stack<>();
		s.push(new Employee("e1", 1, 1000));
		s.push(new Employee("e2", 2, 1000));
		
		s.forEach(x->System.out.print(x.id + " "));
		
		Stack<String> s1 = new Stack<>();
		s1.push("item1");
		s1.push("item2");
		s1.push("item3");
		Arrays.asList(s1.toArray()).forEach(System.out :: println);
		
	}
}
