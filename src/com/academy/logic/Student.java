package com.academy.logic;

public class Student extends Person{
	private int id;
	private int age;
	
	public Student(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
