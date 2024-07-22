package com.edu.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentMain {
	public static void main(String[] args) {
		 List<Student> studentList = new ArrayList<>();
		 studentList.add(new Student(1010, "Rajeev", "HYD"));
		 studentList.add(new Student(1004, "Chris", "BNG"));
		 studentList.add(new Student(1015, "David", "PUNE"));
		 studentList.add(new Student(1009, "Steve", null));
		 studentList.add(new Student(1011, null, "DELHI"));
		 studentList.add(null);

		 
		 List<Student> namesList= studentList.stream().filter(Objects::nonNull)
                 //.map(StudentMain::toLowerCaseAddress).collect(Collectors.toList());
				 .map(stu -> {
					 stu.setAddress( Optional.of(stu).map(Student::getAddress).orElse("Need Address"));
					 stu.setName( Optional.ofNullable(stu).map(Student::getName).orElse("Need Name"));
	                    return stu;
				 }).collect(Collectors.toList());
		 
		 List<Student> sortedByNameAndAddressDesc = namesList.stream()
	                .sorted(Comparator.comparing(Student::getName)//.reversed()
	                        .thenComparing(Comparator.comparing(Student::getAddress).reversed()))
	                .collect(Collectors.toList());
		 sortedByNameAndAddressDesc.forEach(s -> System.out.println(s));
		 
		 List<String> list11 = Arrays.asList("a", "d", "f", "z", "a",null);
		 Optional<String> secondLast = list11.stream().filter(Objects::nonNull)              // Create a Stream from the list11
                 .skip(list11.size() - 2) // Skip all elements except the second-last one
                 .findFirst()            // Find the first element in the stream
                 ;                 // Get the value from the Optional<String>
		 		System.out.println(secondLast.isPresent()? secondLast.get() : "not present");
	}
	
	private static String toLowerCaseAddress(Student student) {
		//return Optional.ofNullable(student).map(Student::getAddress).orElse("Need Address");
		Optional<Student> studentOpt = Optional.of(student);
	    return studentOpt.map(Student::getAddress).orElse("Need Address");
	  }
	
	private static String toUpperCaseName(Student student) {
		//return Optional.ofNullable(student).map(Student::getAddress).orElse("Need Address");
		Optional<String> studentOpt = Optional.ofNullable(student.getName());
	    return studentOpt.map(String::toUpperCase).orElse("Need Name");
	  }
}
