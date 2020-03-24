package com.academy.logic;

import java.util.ArrayList;

public class Subject {
	private String subjectName;
	private Teacher subjectTeacher;
	private ArrayList<Student> subjectStundents;
	
	public Subject(String subjectName) {
		this.subjectName = subjectName;
		subjectStundents = new ArrayList<Student>();
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public void addSubjectTeacher(Teacher teacher) {
		subjectTeacher = teacher;
	}
	
	public void addSubjectStudent(Student student) {
		subjectStundents.add(student);
	}
	
	public Teacher getSubjectTeacher() {
		return subjectTeacher;
	}
	
	public ArrayList<Student> getSubjectStudentList(){
		return subjectStundents;
	}
	
	
}
