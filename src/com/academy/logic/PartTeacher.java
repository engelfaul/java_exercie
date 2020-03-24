package com.academy.logic;

public class PartTeacher extends Teacher{
	private int hoursWeek;
	private int baseSalary;
	
	public PartTeacher(int hoursWeek){
		this.hoursWeek = hoursWeek;
		baseSalary = 500;
	}
	
	public double getSalary() {
		
		return hoursWeek * baseSalary;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

}
