package com.java_practice_repo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java_practice_repo.pojo.Employee;


public class StreamsExmpl1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		//Find the longest string in a list of strings using Java streams
		String[] strngs = {"apple", "banana", "cherry", "date", "grapefruit" };
		
		String s = Arrays.stream(strngs).max((a,b) -> Integer.compare(a.length(), b.length())).orElse(null);
		System.out.println("Max String is " + s);
		
		String longestString = Arrays.stream(strngs)
	            .max(Comparator.comparingInt(String::length)).orElse(null);
		System.out.println("Max String is " + longestString);
		
		//Calculate the average age from a list of Employee objects 
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Yanksha", 48, 123, "F", "HR", "Blore", 2020));
		empList.add(new Employee(2, "Francesca", 48, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));
		empList.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
		empList.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));
		
		//Longest Employee Name
		Optional<Employee> emp1 = empList.stream().max(Comparator.comparingInt(e -> e.name().length()));
		if(emp1.isPresent()) System.out.println(emp1.get().name());
		
		//Group employees by city
		Map<Object, List<Employee>> cityEmpMap = empList.stream().collect(Collectors.groupingBy(e -> e.city()));
		System.out.println("Employees grouped by city : " + cityEmpMap);
			
		//count of male and female employees present in the organization.
		Map<String, Long> countMap = empList.stream().collect(Collectors.groupingBy(Employee::gender,Collectors.counting()));
		System.out.println("count of male and female employees present in the organization : " + countMap);
		
		//Print the names of all departments in the organization.
		empList.stream().map(Employee::deptName).distinct().forEach(System.out::println);
		
		//Print employee details whose age is greater than 28
		empList.stream().filter(e -> e.age() > 28).toList().forEach(System.out::println);;
		/**
		//Find maximum age of employee.
		Employee empMaxAge = empList.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
		System.out.println("Max Age of employee " + empMaxAge);
		
		//Print Average age of Male and Female Employees.
		Map<String, Double> empMap = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("Avg age of male and female emp " + empMap);
		
		//Print the number of employees in each department.
		Map<String, Long> empDeptMap = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("number of employees in each department " + empDeptMap);
		for(Map.Entry<String, Long> entry : empDeptMap.entrySet()) 
		{
		   System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		//longest serving employees in the organization
		Optional<Employee> longEmp = empList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		if(longEmp.isPresent()) System.out.println(longEmp.get());
		
		//longest serving employee in each department
		Map<String, Optional<Employee>> longserEmp = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining))));
		for(Map.Entry<String, Optional<Employee>> entry : longserEmp.entrySet()) 
		{
		   System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining)))).forEach((dept, empOpt) -> empOpt.ifPresent(emp -> System.out.println(dept + " -> " + emp.getName() + " (DOJ: " + emp.getYearOfJoining() + ")")));
		
		//second highest salary
		Employee secHigest = empList.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null);
		System.out.println(secHigest.getName());
		
		//Top 3 highest salaries
		empList.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);
		

		Integer a = 123, b= 123, c = 129, d = 129;
		System.out.println(a == b);  //true
		System.out.println(c == d);  // false
		// 
		
		String input = "Java Hungry Blog Alive is Awesome";

	    Character result = input.chars() // Stream of String       
	                            .mapToObj(s1 -> Character.toLowerCase(Character.valueOf((char) s1))) // First convert to Character object and then to lowercase         
	                            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
	                            .entrySet()
	                            .stream()
	                            .filter(entry -> entry.getValue() == 1L)
	                            .map(entry -> entry.getKey())
	                            .findFirst()
	                            .get();
	    System.out.println(result);   **/

	}

}
