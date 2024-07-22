package com.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManagerEmployeeJava8 {
public static void main(String[] args) {
	 ArrayList<Employee> employees = getUnsortedEmployeeList();
	//Compare by first name and then last name
    Comparator<Employee> compareByName = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
     
    List<Employee> sortedEmployees = employees.stream()
                    .sorted(compareByName)
                    .collect(Collectors.toList());
    System.out.println(" sortedEmployees "+sortedEmployees);
    
  //first name comparator
    Comparator<Employee> comparingByFirstName = Comparator.comparing( Employee::getFirstName );
     
    //last name comparator
    Comparator<Employee> compareByLastName = Comparator.comparing( Employee::getLastName );
     
    //Compare by first name and then last name (multiple fields)
    Comparator<Employee> compareByFullName = comparingByFirstName.thenComparing(compareByLastName);
     
    //Using Comparator - pseudo code
    employees.stream().sorted( compareByFullName ).collect(Collectors.toList()); 
    
    List<Employee> sortedByFirstName = employees.stream()
            						   .sorted(Comparator.comparing( Employee::getFirstName ))
            						   .collect(Collectors.toList());
    
    
    System.out.println(" sortedByFirstName "+sortedByFirstName);

    
    System.out.println("---Sorting using Comparator by Gender--");
    List<Employee> slist = employees.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
    slist.forEach(e -> System.out.println("Age :"+ e.getAge()+", Name: "+e.getLastName()+", FirstName :"+e.getFirstName()));
    
    
    List<Integer> numbers = Arrays.asList(3, 2, 1, 2, 5);
    System.out.println(System.lineSeparator()+"Sort list of int numbers");
    List<Integer> result = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()) ;
    
    System.out.println(" numbers "+result);
    
    List<Integer> list = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
    System.out.println(" stream numbers "+list);
    
    
    IntStream stream = IntStream.range(1, 100); 
    List<Integer> primes = stream.filter(ManagerEmployeeJava8::isPrime).boxed().collect(Collectors.toList());
    System.out.println(" primes numbers "+primes);


	final String uuid = UUID.randomUUID().toString().replace("-", "");
	System.out.println("uuid = " + uuid);
	}



	public static boolean isPrime(int i) {
		IntPredicate isDivisible = index -> i % index == 0;
		return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
	}
 
	public static ArrayList<Employee> getUnsortedEmployeeList() {
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee(2l, "Lokesh", "Gupta"));
		list.add(new Employee(1l, "Alex", "Gussin"));
		list.add(new Employee(4l, "Brian", "Sux"));
		list.add(new Employee(5l, "Neon", "Piper"));
		list.add(new Employee(3l, "David", "Beckham"));
		list.add(new Employee(7l, "Alex", "Beckham"));
		list.add(new Employee(6l, "Brian", "Suxena"));
		return list;
	}
}
