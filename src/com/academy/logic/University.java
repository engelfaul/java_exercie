package com.academy.logic;

import java.util.ArrayList;

public class University {

	private String nameUniversity;
	private ArrayList<Student> students;
	private ArrayList<Teacher> teachers;
	private ArrayList<Subject> subjects;
	
	public University(String nameUniversity) {
		this.nameUniversity = nameUniversity;
		students = new ArrayList<Student>();
		teachers = new ArrayList<Teacher>();
		subjects = new ArrayList<Subject>();
	}
	public String getName_university() {
		return nameUniversity;
	}

	public void setName_university(String nameUniversity) {
		this.nameUniversity = nameUniversity;
	}
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	};
	public void addStudent(Student student) {
		students.add(student);
	};
	
	public Subject getSubject(int i) {
		return subjects.get(i);
	}
	
	public int getSubjectSize() {
		return subjects.size();
	}
	
	public Teacher getTeacher(int i) {
		return teachers.get(i);
	}
	
	public int getTeacherSize() {
		return teachers.size();
	}
	public ArrayList<Teacher> getTeachers(){
		return teachers;
	}
	
	public ArrayList<Subject> searchSchudeledSubjectById(int id) {
		ArrayList<Subject> subjectTemp = new ArrayList<Subject>();
		for (int i = 0; i < subjects.size(); i++) {
			for (int j = 0; j < subjects.get(i).getSubjectStudentList().size(); j++) {
				if(subjects.get(i).getSubjectStudentList().get(j).getId() == id) {
					subjectTemp.add(subjects.get(i));
				}
			}
			
		}
		return subjectTemp;
	}
	public Student getStudent(int tempId) {
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getId() == tempId) {
				return students.get(i); 
			}
		}
		return null;
	}
	
}
