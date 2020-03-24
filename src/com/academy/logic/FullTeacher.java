package com.academy.logic;

public class FullTeacher extends Teacher {
	private int experienceYears;
	private double fullSalary;
	private int baseSalary;
	private double percentValue;

	
	public FullTeacher(int experienceYears) {
		this.experienceYears = experienceYears;
		this.percentValue = 1.1;
		this.baseSalary = 1000;
	}

	@Override
	public double getSalary() {
		fullSalary = baseSalary * (experienceYears * percentValue);
		return fullSalary;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getPercentValue() {
		return percentValue;
	}

	public void setPercentValue(double percentValue) {
		this.percentValue = percentValue;
	}

}
