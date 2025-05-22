package com.j8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMain {
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
		empList.add(new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));

		empList.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
		empList.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));

		System.out.println("Group the Employees by city");
		Map<String, List<Employee>> empByCity;
		empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
		System.out.println("Employees grouped by city :: \n" + empByCity);

		System.out.println("Group the Employees by age");
		Map<Integer, List<Employee>> empByAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println("Employees grouped by age :: \n" + empByAge);

		System.out.println("Find the count of male and female employees present in the organization");
		Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(
				"Count of male and female employees present in the organization:: \n" + noOfMaleAndFemaleEmployees);

		System.out.println("Print the names of all departments in the organization");
		empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

		System.out.println("Employee details whose age is greater than 28");
		empList.stream().filter(e -> e.getAge() > 28).collect(Collectors.toList()).forEach(System.out::println);

		OptionalInt max = empList.stream().mapToInt(Employee::getAge).max();
		if (max.isPresent())
			System.out.println("Maximum age of Employee: " + max.getAsInt());

		Map<String, Double> avgAge = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("Average age of Male and Female Employees:: " + avgAge);

		Map<String, Long> countByDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("No of employees in each department");
		for (Map.Entry<String, Long> entry : countByDept.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparingInt(Employee::getAge));
		Employee oldestEmployee = oldestEmp.get();
		System.out.println("Oldest employee details:: \n" + oldestEmployee);

		Optional<Employee> seniorEmp = empList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining))
				.findFirst();
		System.out.println("Longest-serving employee:" + seniorEmp.get());

		System.out.println("\n--- Oldest Employee per Department ---");
		empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName,
						Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining))))
				.forEach((dept, empOpt) -> empOpt.ifPresent(emp -> System.out
						.println(dept + " -> " + emp.getName() + " (DOJ: " + emp.getYearOfJoining() + ")")));

		System.out.println("\n--- Youngest Employee per Department ---");
		empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName,
						Collectors.maxBy(Comparator.comparing(Employee::getYearOfJoining))))
				.forEach((dept, empOpt) -> empOpt.ifPresent(emp -> System.out
						.println(dept + " -> " + emp.getName() + " (DOJ: " + emp.getYearOfJoining() + ")")));

		//can use anyMatch also
		Optional<Employee> youngestEmp = empList.stream().filter(e -> e.getGender() == "F")
		                                  .min(Comparator.comparingInt(Employee::getAge));
		Employee youngestEmployee = youngestEmp.get();
		System.out.println("Youngest Female employee details:: \n" + youngestEmployee);
		
		
		System.out.println("Employees whose age is greater than 25 and less than 25");
		Map<Boolean, List<Employee>> partitionEmployeesByAge =
		                empList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));

		Set<Map.Entry<Boolean, List<Employee>>> empSet = partitionEmployeesByAge.entrySet();

		for (Map.Entry<Boolean, List<Employee>> entry : empSet) {
		  if (Boolean.TRUE.equals(entry.getKey())) {
		                System.out.println("Employees greater than 30 years ::" + entry.getValue());
		            } else {
		                System.out.println("Employees less than 30 years ::" + entry.getValue());
		            }
		        }
		
		
		Map.Entry<String, Long> maxNoOfEmployeesInDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("Max no of employees present in Dept :: " + maxNoOfEmployeesInDept.getKey());
		
		Optional<Employee> emp = empList
				.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR")).findAny();
		emp.ifPresent(employee -> System.out.println("Found employees from HR department " + employee));
		
		System.out.println("Department names where the number of employees in the department is over 3 :: ");
		empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).
		entrySet().stream().filter(entry -> entry.getValue() > 3).forEach(System.out::println);
		
		System.out.println("Distinct department names that employees work for:: ");
		 empList.stream().map(Employee::getDeptName).distinct().
		 forEach(System.out::println);
		 
		 empList.stream().filter(e -> e.getCity().equalsIgnoreCase("Blore"))
		 .sorted(Comparator.comparing(Employee::getName))
		 .forEach(e -> System.out.println("Employees staying in Blore:: " + e.getName()));
		 
		 System.out.println("No of employees in the organisation :: " + empList.stream().count());
		 
		 Map<String, Long> employeeCountInDepartmentMap = empList.stream().collect(Collectors.
                 groupingBy(Employee::getDeptName, Collectors.counting()));
		 System.out.print("Employee department and its count :- \n"+ employeeCountInDepartmentMap);
		 
		 
		 Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = employeeCountInDepartmentMap.entrySet().stream().max(Map.Entry.comparingByValue());
		 if (deptNameWithHighestEmp.isPresent()) {
		     System.out.println("Department which has the highest number of employees " + deptNameWithHighestEmp.get());
		 }
		 
		 System.out.println("Sorting based on name and age:: ");
		 Comparator<Employee> comparator1 = Comparator.comparing(Employee::getName);
		 Comparator<Employee> comparator2 = Comparator.comparingInt(Employee::getAge);
		 empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);
		 
		 
		 DoubleSummaryStatistics empSalary = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		 System.out.println("Average Salary in the organisation = " + empSalary.getAverage());
		 System.out.println("Total Salary in the organisation  = " + empSalary.getSum());
		 
		 
		 System.out.println("Print Average salary of each department");
		 Map<String, Double> avgSalary = empList.stream().collect(Collectors.groupingBy
		                                (Employee::getDeptName,
		                                 Collectors.averagingDouble(Employee::getSalary)));
		  Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
		  for (Map.Entry<String, Double> entry : entrySet) {
		             System.out.println(entry.getKey() + " : " + entry.getValue());
		  }
		  
		  
		  System.out.println("\n--- Average Salary by Gender in Department ---");
		  Map<String, Map<String, Double>> avgSalaryByGenderPerDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary))));
		  avgSalaryByGenderPerDept.forEach((dept, genderAvg) -> genderAvg.forEach((gender, avg) -> System.out.println(dept + " - " + gender + ": ₹" + avg)));
		  
		  /**
		  empList.stream()
          .filter(e -> e.getSalary() > averageMap.get(e.getDeptName()))
          .collect(Collectors.groupingBy(Employee::getDeptName))
          .forEach((dept, empListAboveAvg) -> {
              System.out.println("Employees in Department who salary greater than average salary: " + dept);
              empListAboveAvg.forEach(e -> System.out.println("  " + e.getName() + " – >" + e.getSalary()));
          });
          */
		  
		  Optional<Employee> empHighest = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                  .findFirst();

		  System.out.println("Highest Salary in the organisation : " + empHighest.get().getSalary());
		  
		  Optional<Employee> emp2 = 
				  empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
		  System.out.println("Second Highest Salary in the organisation : " + emp2.get().getSalary());
		  
		  int n = 1;// this can be any nth number highest salary
		  Optional<Employee> emps2 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
		                           .reversed()).skip(n-1).findFirst();
		  System.out.println("Second Highest Salary in the organisation : " + emps2.get().getSalary());
		  
		  
		  empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).forEach(e -> System.out.println("top 3 highest salary earned employees: " + e.getName() + " – ₹" + e.getSalary()));
		  
		  Map<String, Optional<Employee>> highestPaidMFEmployee = empList
				  .stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
		  System.out.println("Highest paid male and female employee in the organisation: " + highestPaidMFEmployee);		  
		  
		  empList.stream().min(Comparator.comparingDouble(Employee::getSalary)).ifPresent(e -> System.out.println("Lowest paid employee in the organisation: " + e.getName()));
		  
		  Map<String, Optional<Employee>> lowestPaidMFEmployee = empList.stream().collect(Collectors.groupingBy(Employee::getGender, 
                  Collectors.minBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
		  System.out.println("Lowest paid male and female employee : " + lowestPaidMFEmployee);		  

		  
		  System.out.println("Sorting the organisation's employee salary in ascending order ");
		  empList.stream().sorted(Comparator.comparingLong(Employee::getSalary)).forEach(System.out::println);
		  
		  System.out.println("Sorting the organisation's employee salary in descending order ");
		  empList.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).forEach(System.out::println);
		  
		  System.out.println("Highest salary dept wise:: \n" + empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
				  list -> list.stream().max(Comparator.comparingDouble(Employee::getSalary))))));
		  
		  Map<String, Optional<Employee>> lowestEmployeeInDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.minBy(Comparator.comparing(Employee::getSalary))));
	        lowestEmployeeInDept.forEach((dept, empo) -> empo.ifPresent(e -> System.out.println("lowest paid dept wise "+dept + " -> " + e.getName() + "::" + e.getSalary())));
	        
	        
	}
}
