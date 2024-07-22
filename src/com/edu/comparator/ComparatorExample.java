package com.edu.comparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparatorExample {
    public static void main(String[] args) {
        List<com.edu.comparator.Employee> employees = new ArrayList<>();

        employees.add(new com.edu.comparator.Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
        employees.add(new com.edu.comparator.Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
        employees.add(new com.edu.comparator.Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
        employees.add(new com.edu.comparator.Employee(1009, "Steve", 100000.00, LocalDate.of(2016, 5, 18)));

        System.out.println("Employees : " + employees);

        // Sort employees by Name
        Collections.sort(employees, Comparator.comparing(com.edu.comparator.Employee::getName));
        System.out.println("\nEmployees (Sorted by Name) : " + employees);

        // Sort employees by Salary
        Collections.sort(employees, Comparator.comparingDouble(com.edu.comparator.Employee::getSalary));
        System.out.println("\nEmployees (Sorted by Salary) : " + employees);

        // Sort employees by JoiningDate
        Collections.sort(employees, Comparator.comparing(com.edu.comparator.Employee::getJoiningDate));
        System.out.println("\nEmployees (Sorted by JoiningDate) : " + employees);

        // Sort employees by Name in descending order
        Collections.sort(employees, Comparator.comparing(com.edu.comparator.Employee::getName).reversed());
        System.out.println("\nEmployees (Sorted by Name in descending order) : " + employees);

        // Chaining multiple Comparators
        // Sort by Salary. If Salary is same then sort by Name
        Collections.sort(employees, Comparator.comparingDouble(com.edu.comparator.Employee::getSalary).thenComparing(com.edu.comparator.Employee::getName));
        System.out.println("\nEmployees (Sorted by Salary and Name) : " + employees);
        
        
        List<com.edu.comparator.Employee> numbers = new ArrayList<>();
        List<com.edu.comparator.Employee> empDuplicates = new ArrayList<>();
        empDuplicates.add(new com.edu.comparator.Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
        empDuplicates.add(new com.edu.comparator.Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
        empDuplicates.add(new com.edu.comparator.Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
        empDuplicates.add(new com.edu.comparator.Employee(1009, "Steve", 100000.00, LocalDate.of(2016, 5, 18)));
        
        empDuplicates.add(new com.edu.comparator.Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
        empDuplicates.add(new com.edu.comparator.Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
        empDuplicates.add(new com.edu.comparator.Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
        empDuplicates.add(new com.edu.comparator.Employee(1009, "Steve", 100000.00, LocalDate.of(2016, 5, 18)));

        System.out.println("ArrayList with duplicate elements: " + empDuplicates);
        Stream<com.edu.comparator.Employee> stream = empDuplicates.stream();
        // call the distinct() of Stream
        // to remove duplicate elements
        stream = stream.distinct();
        // convert the stream to arraylist
        numbers = stream.collect(Collectors.toList());
        numbers.forEach(e -> System.out.println(" E "+e.getId()));
    }
}
