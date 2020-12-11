package com.dsr.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A stream is a sequence of objects that supports various methods which can be
 * pipelined to produce the desired result. 
 * Intermediate Operations:map, filter,sorted 
 * Terminal Operations:collect, forEach , findAny, reduce
 * 
 * @author dharmendra
 *
 */
public class StreamExample {

	public static void main(String[] names) {
		StreamExample st = new StreamExample();
		st.test();
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("one", 1, 10));
		employees.add(new Employee("two", 2, 20));
		employees.add(new Employee("three", 3, 30));
		employees.add(new Employee("four", 4, 40));
		st.stremTest(employees);
	}

	private void stremTest(List<Employee> employees) {
		// filter and forEach
		employees.stream().filter(x -> {
			if (x.getId() == 1) {
				return true;
			} else
				return false;
		}).forEach(System.out::println);

		// filter and collect
		List<Employee> newList = employees.stream().filter(x -> {
			if (x.getId() == 1) {
				return true;
			} else
				return false;
		}).collect(Collectors.toList());
		newList.forEach(System.out::println);

		// filter and findAny and orElse
		Employee e = employees.stream().filter(x -> x.getName().equals("two")).findAny().orElse(null);
		System.out.println(e);

		// map and Collect
		List<String> nameList = employees.stream().map(x -> x.getName()).collect(Collectors.toList());
		nameList.forEach(System.out::println);
	}

	private void test() {

		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");

		// for loop
		for (String item : list) {
			System.out.println(item);
		}

		// for each
		list.forEach(item -> System.out.println(item));

		// method reference
		list.forEach(System.out::println);

		// Consumer<? super String> x->System.out.println(x);
		list.stream().filter(x -> x.startsWith("o")).skip(1).forEach(x -> System.out.println(x));
		Function mapper;
		list.parallelStream().filter(x -> x != null).skip(1).forEach(System.out::println);

	}

}
