package com.dsr.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dsr.java.java8.Employee;
import com.dsr.java.java8.EmployeeNotFoundException;

public class OptionalUsage {

	static List<Employee> employess = new ArrayList<>();

	public static void main(String[] args) throws EmployeeNotFoundException {
		employess.add(new Employee("emp1", 1, 1000));
		employess.add(new Employee("emp2", 2, 2000));
		employess.add(new Employee("emp1", 3, 3000));

		Optional<Employee> employee = getEmployeeWithId(1);

		Employee e = employee.orElseThrow(() -> new EmployeeNotFoundException("emp not found"));
		System.out.println(e);
	}

	public static Optional<Employee> getEmployeeWithId(int id) {

		Optional<Employee> employee = employess.stream().filter(e -> (e.getId() == id)).findFirst();
		return employee;

	}

}
