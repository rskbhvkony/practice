package com.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//https://javainfinite.com/java/collectors-in-java-8-with-examples/
public class CollectorsGoupingBy {
	public static void main(String args[]) {

        List<Employee> employeeList = Arrays.asList(new Employee(5, "Harry", "System Admin", 50000),
                new Employee(1, "Melanie", "Front Desk", 10000),
                new Employee(2, "Hikari", "Executive", 5000),
                new Employee(3, "Eel", "Executive", 5000),
                new Employee(4, "Alphabite", "Executive", 5000),
                new Employee(6, "Messy", "Front Desk", 10000));

        //Grouping by employees department
        Map<String, List<Employee>> groupByDepartment =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Group by Department");
        groupByDepartment.forEach((k, v) -> {
            System.out.println("Key is: " +k);
            System.out.println("Value: "+v);
        });
        
        System.out.println("**************************");

        Map<String, List<Employee>> sortAndGroupBy = employeeList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Sort by name and group by Department");
        sortAndGroupBy.forEach((k, v) -> {
            System.out.println("Key is: " +k);
            System.out.println("Value: "+v);
        });
        
        System.out.println("**************************");
        
        Map<String, Map<Integer, List<Employee>>> empData = employeeList.stream()
        		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getId)));

        System.out.println("Multiple groupingBy - department and id");
        empData.forEach((k, v) -> {
            System.out.println("Key: " + k);
            v.entrySet().forEach(s -> {
                System.out.println("sub-Key is: " + s.getKey());
                System.out.println("sub-Value is: " + s.getValue());
            });
        });
        
        System.out.println("**************************");
        
        Map<String, List<Employee>> multisortAndGrouping = employeeList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getId)).collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Multiple sorting - Name and Id - and grouping");
        multisortAndGrouping.forEach((k, v) -> {
            System.out.println("Key is: " + k);
            System.out.println("Value: " + v);
        });
        
        System.out.println("**************************");
        
        Map<String, Long> counting = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Counting the collectors");
        counting.forEach((k, v) -> {
            System.out.println("Key is: " + k);
            System.out.println("Value: " + v);
        });
        
        System.out.println("**************************");
        
        Map<String, Integer> summingSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
        System.out.println("Summing the salary");
        summingSalary.forEach((k, v) -> {
            System.out.println("Key is: " + k);
            System.out.println("Value: " + v);
        });
        
        System.out.println("**************************");
        
        Map<Boolean, List<Employee>> partitioningBy = employeeList.stream().collect(Collectors.partitioningBy(s -> s.getSalary() > 5000));
        System.out.println("PartitioningBy");
        partitioningBy.forEach((k, v) -> {
            System.out.println("Key is: " + k);
            System.out.println("Value: " + v);
        });
        
        System.out.println("**************************");
        
        Map<String, List<String>> mapping = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Mapping by");
        mapping.forEach((k, v) -> {
            System.out.println("Key is: " + k);
            System.out.println("Value: " + v);
        });
        
        System.out.println("**************************");
        
        Map<String, List<Employee>> filter = employeeList.stream()
        		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.filtering(s -> s.getSalary() > 10000, Collectors.toList())));
        System.out.println("Filtering by");
        filter.forEach((k, v) -> {
            System.out.println("Key is: " + k);
            System.out.println("Value: " + v);
        });
        System.out.println("**************************");
        
        Map<String, Long> counting2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Counting the collectors");
        counting2.forEach((k, v) -> {
            System.out.println("Key is: " + k);
            System.out.println("Value: " + v);
        });
	}
}
