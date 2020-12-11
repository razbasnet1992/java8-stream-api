package com.dsr.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Program to find Max element in List and Map using Stream and lambda.
 * 
 * @author dharmendra
 *
 */
public class MaxMinUsingStream {

	public static void main(String[] args) {

		int[] salaryArr = new int[] { 1000, 2000, 3000, 4000 };

		// Arrays.asList(salaryArr).stream()

		List<Integer> intList = Arrays.asList(1000, 2000, 3000, 4000);
		findMaxElementInList(intList);

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("one", 1, 1000));
		employees.add(new Employee("two", 2, 2000));
		employees.add(new Employee("three", 3, 3000));
		employees.add(new Employee("four", 4, 4000));

		findMaxEmployeeInList(employees);

		Map<Integer, String> intMap = new HashMap<>();
		intMap.put(1, "one");
		intMap.put(2, "two");
		intMap.put(3, "three");
		intMap.put(4, "four");
		intMap.put(5, "five");

		findMaxElement(intMap);

		Map<String, Employee> empMap = new HashMap<>();
		empMap.put("one", new Employee("one", 1, 1000));
		empMap.put("two", new Employee("two", 2, 2000));
		empMap.put("three", new Employee("three", 3, 3000));
		empMap.put("four", new Employee("four", 4, 4000));

		findEmployeeWithMaxSalary(empMap);

	}

	private static void findMaxElementInList(List<Integer> intList) {
		int maxValue = intList.stream().max((k, v) -> {
			return k - v;
		}).get();

		System.out.println(" max Value " + maxValue);

		int maxValue1 = intList.stream().mapToInt(k -> k).max().getAsInt();
		
		int maxValue2 = intList.stream().mapToInt(Integer::intValue).max().orElse(0);

		System.out.println(" max Value " + maxValue1 + " " + maxValue2);

	}

	private static void findMaxEmployeeInList(List<Employee> employees) {
		Employee maxSalaryEmployee = employees.stream().max((k, v) -> {
			return k.getSalary() - v.getSalary();
		}).get();
		System.out.println(" Max salary employee " + maxSalaryEmployee);

		Employee minSalaryEmployee = employees.stream().min((k, v) -> {
			return k.getSalary() - v.getSalary();
		}).get();
		System.out.println(" Min salary employee " + minSalaryEmployee);

		Employee minSalaryEmployee1 = employees.stream().min(Comparator.comparing((Employee k) -> k.getSalary())).get();

		// method reference
		Employee minSalaryEmployee2 = employees.stream().min(Comparator.comparing(Employee::getSalary)).get();

		System.out.println(" Min salary employee " + minSalaryEmployee1 + " " + minSalaryEmployee2);
	}

	private static void findMaxElement(Map<Integer, String> intMap) {

		// using stream and Comparator
		Comparator<? super Integer> comp = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Integer maxKey = intMap.keySet().stream().max(comp).get();

		System.out.println(maxKey + " " + intMap.get(maxKey));

		// using stream and lambda
		Integer maxKey1 = intMap.keySet().stream().max((k, v) -> {
			return k - v;
		}).get();

		System.out.println(maxKey1 + " " + intMap.get(maxKey1));

	}

	private static void findEmployeeWithMaxSalary(Map<String, Employee> empMap) {

		// using stream and Comparator
		Comparator<? super Entry<String, Employee>> comparator = new Comparator<Entry<String, Employee>>() {

			@Override
			public int compare(Entry<String, Employee> o1, Entry<String, Employee> o2) {
				return (o1.getValue().getSalary() - o1.getValue().getSalary());

			}
		};
		Entry<String, Employee> maxEntry = empMap.entrySet().stream().max(comparator).get();

		System.out.println(" Max salary employee " + maxEntry.getValue());

		// using stream and lambda

		Entry<String, Employee> maxEntry1 = empMap.entrySet().stream().max((k, v) -> {
			return (k.getValue().getSalary() - v.getValue().getSalary());
		}).get();

		System.out.println(" Max salary employee " + maxEntry1.getValue());

	}
}
