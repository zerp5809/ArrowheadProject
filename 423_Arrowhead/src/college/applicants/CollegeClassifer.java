/*
 * Created on : 4-23-17
 * Author     : Shane Yang
 * Description: Software Engineering Candidate Project: CollegeClassifier: This class contains methods required for the CollegeClassiferApp to run

 */
package college.applicants;
import java.util.Scanner;
public class CollegeClassifer {
	public Student newStudent(){
		Scanner sc = new Scanner(System.in);
		//age, GPA, GPAScale, SAT, ACT, felonies, fName, Lname, status
		System.out.print("Enter first name of student: ");
		String fName = sc.nextLine();
		System.out.print("Enter last name of student: ");
		String lName = sc.nextLine();
		System.out.print("Enter age of student: ");
		int age = sc.nextInt();
		System.out.print("Enter GPA of student: ");
		double GPA = sc.nextDouble();
		System.out.print("Enter GPA Scale of student's school: ");
		double GPAScale = sc.nextDouble();
		System.out.print("Enter SAT score of student(If none enter 0): ");
		int SAT = sc.nextInt();
		System.out.print("Enter ACT score of student(If none enter 0): ");
		int ACT = sc.nextInt();
		System.out.print("Enter number of felonies student may have committed(If none enter 0): ");
		int felonies = sc.nextInt();
		Student s = new Student(age, GPA, GPAScale, SAT, ACT, felonies, fName, lName, "new");
		//sc.close();
		return s;
	}
	//prints  name status and reasons to console window
	public void printStatus(Student s){
		String status = s.getName()+ ": " + s.getStatus();
		String msg = s.getMsg();
		if (!msg.equals (" ")){
			status += " Reason: " + msg; 
		}
		System.out.println(status);
	}
}
