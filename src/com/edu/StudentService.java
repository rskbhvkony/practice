package com.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
	List<Student> studentsList = null;
	public List<Student> getAllStudents() {
		studentsList = new ArrayList<>();
		studentsList.add(new Student("1", "Ram", "A"));
		studentsList.add(new Student("2", "Rammam", "A"));
		studentsList.add(new Student("3", "Raghava", "B"));
		studentsList.add(new Student("4", "Ravi", "C"));
		studentsList.add(new Student("5", "Raghu", "A"));
		studentsList.add(new Student("6", "Rageev", "A"));
		studentsList.add(new Student("7", "Ragender", "B"));
		studentsList.add(new Student("8", "Ravi", "D"));
		return studentsList;
	}
	
	public List<Student> getStudent( List<Student>  li){
		return li.stream().filter(s-> s.getGrade().equals(StudentConstants.GRADE_A)).collect(Collectors.toList());
	}
	
	public Student getStudentByGradeA( List<Student>  li){
		return li.stream().filter(s-> s.getGrade().equals(StudentConstants.GRADE_A)).findAny().get();//(Collectors.toList());
	}
}
