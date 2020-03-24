package com.academy.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.academy.logic.FullTeacher;
import com.academy.logic.PartTeacher;
import com.academy.logic.Student;
import com.academy.logic.Subject;
import com.academy.logic.Teacher;
import com.academy.logic.University;

public class App {

	public static void main(String[] args) {
	//Add initial information
		University university = new University("Globant University");
		
		//Initialize minimum 2 different teachers of each type (full time, part time).
		//Full time
		Teacher teacherA = new FullTeacher(5);
		teacherA.setName("Maria");
		Teacher teacherB = new FullTeacher(8);
		teacherB.setName("Veronica");
		//Part time teacher
		Teacher teacherC = new PartTeacher(8);
		teacherC.setName("Carlos");
		Teacher teacherD = new PartTeacher(10);
		teacherD.setName("Rocio");
		
		university.addTeacher(teacherA);
		university.addTeacher(teacherB);
		university.addTeacher(teacherC);
		university.addTeacher(teacherD);
		
		//Initialize minimum 6 different students
		Student studentA = new Student("Pablo", 202001, 17);
		Student studentB = new Student("Billie", 202002, 18);
		Student studentC = new Student("Ana", 202002, 18);
		Student studentD = new Student("Alan", 202003, 17);
		Student studentE = new Student("Silvana", 202004, 18);
		Student studentF = new Student("Santiago", 202005, 17);
		Student studentG = new Student("Pedro", 202006, 17);
		
		university.addStudent(studentA);
		university.addStudent(studentB);
		university.addStudent(studentC);
		university.addStudent(studentD);
		university.addStudent(studentE);
		university.addStudent(studentF);
		university.addStudent(studentG);

		//Initialize minimum 4 different classes including its teacher , students
		Subject subjectA = new Subject("Engineer Introduction");
		Subject subjectB = new Subject("Basic Programming");
		Subject subjectC = new Subject("Object Oriented Programming");
		Subject subjectD = new Subject("integral calculus");
		
		subjectA.addSubjectTeacher(teacherA);
		subjectB.addSubjectTeacher(teacherB);
		subjectC.addSubjectTeacher(teacherC);
		subjectD.addSubjectTeacher(teacherD);
		
		subjectA.addSubjectStudent(studentA);
		subjectA.addSubjectStudent(studentB);
		subjectA.addSubjectStudent(studentC);
		
		subjectB.addSubjectStudent(studentD);
		subjectB.addSubjectStudent(studentE);
		subjectB.addSubjectStudent(studentF);
		
		subjectC.addSubjectStudent(studentG);
		subjectC.addSubjectStudent(studentA);
		subjectC.addSubjectStudent(studentB);
		
		subjectD.addSubjectStudent(studentC);
		subjectD.addSubjectStudent(studentF);
		subjectD.addSubjectStudent(studentG);
		
		university.addSubject(subjectA);
		university.addSubject(subjectB);
		university.addSubject(subjectC);
		university.addSubject(subjectD);
		
		app(university);
		
	}
	
	public static void app(University university) {
		//Aplication menu
		System.out.println("Welcome to university system, choose an option:");
		System.out.println("1. Show Teacher Information");
		System.out.println("2. Show scheduled subjets");
		System.out.println("3. Create new student");
		System.out.println("4. Create new Subject");
		System.out.println("5. Search subject scheduled by student");
		System.out.println("6. Exit");
		
		boolean activeApp = true;
		Scanner in = new Scanner(System.in);
		
		while(activeApp) {
			try {
				int o = in.nextInt();
				switch (o) {
				case 1:
					for (int i = 0; i < university.getTeacherSize() ; i++) {
						System.out.println("Teacher: " + university.getTeacher(i).getName() + ", salary: " 
								+ university.getTeacher(i).getSalary() );
					}
					break;
				case 2:
					System.out.println("The scheduled subjects are (choose any it for more information and '0' for exit):");
					boolean tempSubject = true;
					for (int i = 0; i < university.getSubjectSize(); i++) {
						System.out.println( i+1 +". " + university.getSubject(i).getSubjectName());
					}
					while (tempSubject) {
						int oSubject = in.nextInt();
						if(oSubject != 0 && university.getSubjectSize() > oSubject  ) {
							//Teacher information
							System.out.println("Teacher: "+ university.getSubject(oSubject-1).getSubjectTeacher().getName());
							//Students information
							for (int j = 0; j < university.getSubject(oSubject-1).getSubjectStudentList().size(); j++) {
								System.out.println("Student: " + university.getSubject(oSubject-1).getSubjectStudentList().get(j).getName()
										+ " id: " + university.getSubject(oSubject-1).getSubjectStudentList().get(j).getId());
							}
						}else {
							tempSubject = false;
						}	
					}
					break;
				
				case 3:
					System.out.println("Enter the id of the new student: ");
					int newCodStudent = in.nextInt();
					System.out.println("Enter the name of the new student: ");
					String newName = in.next();
					System.out.println("Ingrese la edad del nuevo estudiante: ");
					int age = in.nextInt();	
					Student student = new Student(newName, newCodStudent, age);
					university.addStudent(student);
					
					System.out.println("Choose the subject in order to add the new student:");
					for (int i = 0; i < university.getSubjectSize(); i++) {
						System.out.println( i+1 +". " + university.getSubject(i).getSubjectName());
					}
					int subjectTemp = in.nextInt();
					university.getSubject(subjectTemp-1).addSubjectStudent(student);
					
					System.out.println("Student creation done!");				
					break;
				case 4:
					System.out.println("Enter subject name: ");
					String tempName = in.next();
					Subject subject = new Subject(tempName);
					System.out.println("Add teacher:");
					for (int i = 0; i < university.getTeacherSize(); i++) {
						System.out.println(i + " " + university.getTeacher(i).getName());
					}
					int tempTeacher = in.nextInt();
					subject.addSubjectTeacher(university.getTeacher(tempTeacher));
					
					System.out.println("Add Students:");
					boolean tempAdd = true;
					while(tempAdd) {
						System.out.println("Enter Student id");
						int tempId = in.nextInt();
						Student tempStudent = university.getStudent(tempId);
						if(tempStudent != null) {
							subject.addSubjectStudent(tempStudent);
						}else {
							System.out.println("Enter a valid student");
						}
						System.out.println("Would you like to add another student?(y/n)");
						String cont = in.next();
						if(cont.equals("n")) {
							tempAdd= false;
						}
					}
					university.addSubject(subject);
					app(university);
					break;
				case 5:
					System.out.println("Enter Student id: ");
					int id = in.nextInt();
					ArrayList<Subject> subjects = university.searchSchudeledSubjectById(id);
					if(subjects.size()== 0) {
						System.out.println("the enter student doesn't have subjects scheduled");
					}else {
						System.out.println("The student has the next subjects scheduled:");
						for (int i = 0; i < subjects.size(); i++) {
							System.out.println(subjects.get(i).getSubjectName());
						}
					}
					app(university);
					break;
			
				case 6:
					System.out.println("Good bye");
					activeApp = false;
					break;	
				default:
					break;
				}
				
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Ingrese una opción valida");
				app(university);
			}	
			
			
		}
	}

}
