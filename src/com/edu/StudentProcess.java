package com.edu;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentProcess {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		List<Student>  list = studentService.getAllStudents();
		System.out.println("Result "+ studentService.getStudentByGradeA(list));
		
		
		List<Student>  list1 = studentService.getAllStudents();
		Collections.sort(list1, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getGrade().compareTo(o2.getGrade());
			}
		
		});
		
		
		list.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()))
		.forEach((k,v)->System.out.println("Student Grade "+k+" Count "+v));
		System.out.println(" Collectors.toMap ");
		list.stream().collect(Collectors.toMap(Student::getGrade, s->1l, Long::sum))
		.forEach((k,v)->System.out.println("Student Grade "+k+" Count "+v));
		System.out.println(" Grouping and Custom Collectors ");
		list.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.collectingAndThen(Collectors.toList(), List::size)))
		.forEach((k,v)->System.out.println("Student Grade "+k+" Count "+v));
	}
}
