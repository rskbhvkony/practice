package com.collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8MapAndFlatMapExample 
{
    public static void main(String[] args) 
    {
    	 List<Employee> employeeList = Arrays.asList(new Employee(5, "Harry", "System Admin", 50000),
                 new Employee(1, "Melanie", "Front Desk", 10000),
                 new Employee(2, "Hikari", "Executive", 5000),
                 new Employee(3, "Eel", "Executive", 5000),
                 new Employee(4, "Alphabite", "Executive", 5000),
                 new Employee(6, "Messy", "Front Desk", 10000));
    	 
        List<Institute> instituteList = new ArrayList<>();
         
        instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
        instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));
         
        //Java 8 Map() : Get names of all institutes
         
        List<String> namesOfInstitutes = instituteList.stream().map(Institute::getName).collect(Collectors.toList());
         
        System.out.println(namesOfInstitutes);
         
        //Java 8 FlatMap() : Get unique locations of all institutes
         
        Set<String> locationsOfInstitutes = instituteList.stream().flatMap(institute -> institute.getLocations().stream()).collect(Collectors.toSet());
        System.out.println(locationsOfInstitutes);

        System.out.println();
        List<String> nameCharList = instituteList.stream()
       	       .map(emp-> emp.getName().split(""))
     	       .flatMap(array->Arrays.stream(array))//.peek(i ->System.out.print(i))
     	       .map(str -> str.toUpperCase()) 
     	       .filter(str -> !(str.equals(" ")))
     	       .collect(Collectors.toList());
        System.out.println();
        nameCharList.forEach(str -> System.out.print(str));
        System.out.println();
        
        
        List<Employee> empList = employeeList.stream().filter(emp->emp.getId()> 3)
                .map(emp->{
                    
                   // Integer increment = emp.getSalary()*2/100;
                    emp.setSalary(emp.getSalary()+(emp.getSalary()*2/100));
                    return emp;
                    
                }).collect(Collectors.toList());
       System.out.println();
       System.out.println("Employee List After Hike "+empList);
       
       
       List<Double> collect = employeeList.stream().filter(i -> i.getId() >= 2)
    		   				  .map(i -> i.getSalary() *0.1).collect(Collectors.toList());
       System.out.println(" After "+ collect);
    }
}
