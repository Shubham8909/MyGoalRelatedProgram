package com.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.package1.Employee;

public class EmployeeMain {
	 int n=4;
	public static void main(String[] args) {

		Employee e1 = new Employee("Shubham", 1, 1);
		Employee e2 = new Employee("Nitin", 2, 1);
		Employee e3 = new Employee("jack", 3, 2);
		Employee e4 = new Employee("Nitin", 5, 1);

		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);

		Map<Long, List<Employee>> lis1 = list.stream().filter(i -> i.getEmpId() % 2 != 0).map(x -> {
			x.setName("A".concat(x.getName()));
			return x;
		}).collect(Collectors.groupingBy(Employee::getDptId,HashMap::new,Collectors.toCollection(ArrayList::new)));

		System.out.println(lis1);
		
		 List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
		  
	        // Finding sum of all elements
	        int sum = array.stream().reduce((element1, element2) -> element1 + element2).orElse(-1);
	  
	        // Displaying sum of all elements
	        System.out.println("The sum of all elements is " + sum);
	}

}
