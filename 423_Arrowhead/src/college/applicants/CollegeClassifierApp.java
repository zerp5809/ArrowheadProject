/*
 * Created on : 4-23-17
 * Author     : Shane Yang
 * Description: Software Engineering Candidate Project: College Applicant Classifier: application should check,
 * sort, and save applicant status based on requirements. Users can enter their own student or use sample data provided. New attributes can be added to the Student Object class

 */
package college.applicants;

import java.util.Scanner;

public class CollegeClassifierApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentChecker sc  = new StudentChecker();
		CollegeClassifer cc = new CollegeClassifer();
		boolean valid = false;
		//test data this can be changed or a new student can be added if there are more students to be added
		
		
		
		System.out.println("Welcome to the College Classifer app. You can select to add a new student to this application by typing A. Type B to use students already listed or modified in the CollegeClassifireApp.java");
		while (!valid){
			System.out.print("Enter option A, B, or Quit to exit: ");
			String option = scan.nextLine();
			if (option.toLowerCase().equals("a")){
				System.out.println("You have chosen to enter a new student, please enter the following information: .");
				Student nStudent = cc.newStudent();
				sc.checkStudent(nStudent);
				cc.printStatus(nStudent);
			}
			else if(option.toLowerCase().equals("b")){
				//age, GPA, GPAScale, SAT, ACT, felonies, fName, Lname, status
				Student s = new Student(20, 3.3, 4.0, 1850 , 27, 0, "Stephen", "Can", "new");
				Student s1 = new Student(28, 2.3, 4.0, 1520 , 27, 0, "Bob", "Smith", "new");
				Student s2 = new Student(16, 4.5, 5.0, 1920 , 27, 0, "Lucy", "Brown", "new");
				Student s3 = new Student(20, 4.0, 4.0, 1920,29,0, "Bobby", "R", "new");
				Student s4 = new Student(25,2.5, 4.0, 1400, 0, 5, "BadPerson", "Person", "new");
				Student s5 = new Student(20, 4.0, 4.0, 1920,0,0, "Roger", "M", "new");
				Student s6 = new Student (20, 4.0, 4.0, 1920, 0, 0, "bob", "lowercase", "new");
				
				//pass student information to student checker and print
				sc.checkStudent(s);
				cc.printStatus(s);
				sc.checkStudent(s1);
				cc.printStatus(s1);
				sc.checkStudent(s2);
				cc.printStatus(s2);
				sc.checkStudent(s3);
				cc.printStatus(s3);
				sc.checkStudent(s4);
				cc.printStatus(s4);
				sc.checkStudent(s5);
				cc.printStatus(s5);
				sc.checkStudent(s6);
				cc.printStatus(s6);
			}
			else if(option.toLowerCase().equals("quit")){
				System.out.println("Thank You for using the College Classifier App.");
				
				break;
			}
			else{
				System.out.println("I dont understand: " + option + " please try again.");
			}
		}
		
		
		
		
	}

}
