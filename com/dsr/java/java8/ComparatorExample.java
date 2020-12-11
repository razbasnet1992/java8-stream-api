package com.dsr.java.java8;



import java.util.ArrayList;
import java.util.List;

/**
 * Java8 Lambda comparator
 * Comparator using lamdba and For each examples.
 * 
 * @author dharmendra
 *
 */

class Employee {
	String name;
	int id;
	int salary;

	Employee(String name, int id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}
	
	
}

public class ComparatorExample {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("one",1,10));
		employees.add(new Employee("tow",2,20));
		employees.add(new Employee("three",3,30));
		employees.add(new Employee("four",4,40));
		checkComprator(employees);
	}
	
	/*
	 * No need to use anonymous class to implement comparator, we can do it with lambda expression.
	 */
	public static void checkComprator(List<Employee> employees) {
		employees.forEach(System.out:: println);
		employees.sort((Employee e1, Employee e2) -> e2.getId()-e1.getId());
		employees.forEach(System.out:: println);
		employees.sort((e1, e2) -> e2.getId()-e1.getId());
		employees.forEach(System.out:: println);
	}

}
