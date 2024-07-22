package com.synchron;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.edu.Employee;
//https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/#google_vignette
public class EmployeeMain {
	public static void main(String[] args) {
		List<com.synchron.Employee> employeeList = new ArrayList<com.synchron.Employee>();

		employeeList.add(new com.synchron.Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new com.synchron.Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new com.synchron.Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new com.synchron.Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new com.synchron.Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new com.synchron.Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new com.synchron.Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new com.synchron.Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new com.synchron.Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new com.synchron.Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new com.synchron.Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new com.synchron.Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new com.synchron.Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new com.synchron.Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new com.synchron.Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new com.synchron.Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new com.synchron.Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(com.synchron.Employee::getGender, Collectors.counting()));
		System.out.println("noOfMaleAndFemaleEmployees " + noOfMaleAndFemaleEmployees);

		List<String> allDepartments = employeeList.stream().map(com.synchron.Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		System.out.println("All departments " + allDepartments);

		Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(com.synchron.Employee::getGender, Collectors.averagingInt(com.synchron.Employee::getAge)));
		System.out.println("avgAgeOfMaleAndFemaleEmployees " + avgAgeOfMaleAndFemaleEmployees);

		Optional<com.synchron.Employee> highestPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(com.synchron.Employee::getSalary)));
		com.synchron.Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
		System.out.println("Details Of Highest Paid Employee : " + highestPaidEmployee);

		List<String> empJoinedAfter2015 = employeeList.stream().filter(e -> e.getYearOfJoining() > 2015)
				.map(com.synchron.Employee::getName).collect(Collectors.toList());
		System.out.println("empJoinedAfter2015 " + empJoinedAfter2015);

		Map<String, Long> employeeCountByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(com.synchron.Employee::getDepartment, Collectors.counting()));
		Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();
		for (Entry<String, Long> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("employeeCountByDepartment " + employeeCountByDepartment);

		Map<String, Double> avgSalaryOfDepartments = employeeList.stream().collect(
				Collectors.groupingBy(com.synchron.Employee::getDepartment, Collectors.averagingDouble(com.synchron.Employee::getSalary)));
		Set<Entry<String, Double>> entrySet2 = avgSalaryOfDepartments.entrySet();
		for (Entry<String, Double> entry : entrySet2) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		Optional<com.synchron.Employee> yongest = employeeList.stream()
				.filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(com.synchron.Employee::getAge));
		System.out.println("Details Of Youngest Male Employee In Product Development" + yongest.get());

		Optional<com.synchron.Employee> seniorMostEmployeeWrapper = employeeList.stream()
				.sorted(Comparator.comparingInt(com.synchron.Employee::getYearOfJoining)).findFirst();
		System.out.println("Most Experience " + seniorMostEmployeeWrapper.get());
		Optional<com.synchron.Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(com.synchron.Employee::getAge));
		System.out.println("Oldest Employee " + oldestEmployeeWrapper.get());
		
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing=
				employeeList.stream().filter(e -> e.getDepartment()=="Sales And Marketing")
				            .collect(Collectors.groupingBy(com.synchron.Employee::getGender, Collectors.counting()));
				System.out.println("countMaleFemaleEmployeesInSalesMarketing "+countMaleFemaleEmployeesInSalesMarketing);
				
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployees=
						employeeList.stream().collect(Collectors.groupingBy(com.synchron.Employee::getGender, Collectors.averagingDouble(com.synchron.Employee::getSalary)));
						System.out.println("avgSalaryOfMaleAndFemaleEmployees "+avgSalaryOfMaleAndFemaleEmployees);
						
		DoubleSummaryStatistics employeeSalaryStatistics=employeeList.stream().collect(Collectors.summarizingDouble(com.synchron.Employee::getSalary));
    			System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());
				System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());
				
		Map<Boolean, List<com.synchron.Employee>> partitionEmployeesByAge = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
						         
						Set<Entry<Boolean, List<com.synchron.Employee>>> entrySet3 = partitionEmployeesByAge.entrySet();
						         
						for (Entry<Boolean, List<com.synchron.Employee>> 	entry : entrySet3) 
						{
						    System.out.println("----------------------------");
						             
						    if (entry.getKey()) 
						    {
						        System.out.println("Employees older than 25 years :");
						    }
						    else
						    {
						        System.out.println("Employees younger than or equal to 25 years :");
						    }
						             
						    System.out.println("----------------------------");
						             
						    List<com.synchron.Employee> list = entry.getValue();
						             
						    for (com.synchron.Employee e : list) 
						    {
						        System.out.println(e.getName());
						    }
						}
						
		List<com.synchron.Employee> sortedByNameAndSalaryDesc = employeeList.stream()
				                .sorted(Comparator.comparing(com.synchron.Employee::getName)//.reversed()
				                        .thenComparing(Comparator.comparingDouble(com.synchron.Employee::getSalary).reversed()))
				                .collect(Collectors.toList());

				        System.out.println("Sorted by Name and Salary (Descending):");
				        sortedByNameAndSalaryDesc.forEach(System.out::println);
						
				        
		 Comparator<com.synchron.Employee> comparingBySal = Comparator.comparingDouble(com.synchron.Employee::getSalary ).reversed();
				        
		 //sal comparator
		 Comparator<com.synchron.Employee> compareByLastName = Comparator.comparing(com.synchron.Employee::getName);//Comparator.comparing(com.synchron.Employee::getLastName);
				         
		 //Compare by first name and then last name (multiple fields)
		 Comparator<com.synchron.Employee> compareByNameSal = compareByLastName.thenComparing(comparingBySal);
		 List<com.synchron.Employee> collect = employeeList.stream().sorted( compareByNameSal ).collect(Collectors.toList());
		 collect.forEach(e -> System.out.println(" * "+e));
	}
}
