/*
 * Created on : 4-23-17
 * Author     : Shane Yang
 * Description: Software Engineering Candidate Project: StudentChecker: This checks for 
 * all the requirements needed to be accepted into the college. Age, GPA, Test Scores, Felonies, and correct name syntax
 */
package college.applicants;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class StudentChecker {
	
	//check for instant acceptance rejection or review then save the student
	public void checkStudent(Student s){
		boolean ageCheck = false;
		boolean gpaCheck = false;
		boolean satCheck = false;
		boolean rejectCheck = false;
		//age
		int age = s.getAge();
		if(age >= 17 && age < 26 || age > 80){
			ageCheck = true;
		}
		else if (age < 0 ){
			s.setStatus("instant reject");
			s.setMessage("Age is negative. ");
			if (!rejectCheck){
				rejectCheck = true;
			}
		}
		else{
			s.setMessage("Age does not fit criteria. ");
		}
		//gpa
		double gpa = s.getGPA();
		double gpaS = s.getGPAScale();
		double percent = gpa/gpaS;
		if (percent >= 0.9){
			gpaCheck = true;
		}
		else if (percent < 0.7){
			s.setStatus("instant reject");
			s.setMessage("Gpa lower than 70% scale. ");
			if (!rejectCheck){
				rejectCheck = true;
			}
		}
		else{
			s.setMessage("Gpa scale between 70% and 90%. ");
		}
		//sat
		int sat = s.getSAT();
		int act = s.getACT();
		if (sat >= 1920 || act > 27){
			satCheck = true;
		}
		else{
			s.setMessage("SAT or ACT score needs review. ");
		}
		//felonies 
		int f = s.getFelonies();
		if (f > 0){
			s.setStatus("instant reject");
			s.setMessage("Applicant has records of 1 or more felonies. ");
			if (!rejectCheck){
				rejectCheck = true;
			}
		}
		//name case check
		String Fname = s.getFName();
		String Lname = s.getLName();
		if (Fname.substring(0,1).equals(Fname.substring(0,1).toLowerCase()) || Lname.substring(0,1).equals(Lname.substring(0,1).toLowerCase())){
			s.setStatus("instant reject");
			s.setMessage("Name invalid. ");
			if (!rejectCheck){
				rejectCheck = true;
			}
		}
		else if(!Fname.substring(1).equals(Fname.substring(1).toLowerCase()) || !Lname.substring(1).equals(Lname.substring(1).toLowerCase())){
			s.setStatus("instant reject");
			s.setMessage("Name invalid. ");
			if (!rejectCheck){
				rejectCheck = true;
			}
		}
		
		//final check
		if(ageCheck && gpaCheck && satCheck && !rejectCheck){
			s.setStatus("instant accept");
			s.setMessage(" ");
			
		}
		else if(!rejectCheck){
			s.setStatus("further review");
		}
		//save student to array or external file
		saveStudent(s);
	}
	
	//In case of future use of array or saved to memory students	
	public void saveStudent(Student s){
		//to text file
		PrintStream accepted = null;
		PrintStream review = null;
		PrintStream rejected = null;
		try {
			accepted = new PrintStream(new FileOutputStream("acceptedStudents.txt",true));
			review = new PrintStream(new FileOutputStream("reviewStudents.txt",true));
			rejected = new PrintStream(new FileOutputStream("rejectedStudents.txt",true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//to array
		ArrayList<Student> acceptedArray= new ArrayList<Student>();
		ArrayList<Student> rejectArray= new ArrayList<Student>();
		ArrayList<Student> reviewArray= new ArrayList<Student>();
		
		if (s.getStatus().equals("instant accept")){
			accepted.println(s.getName());
			acceptedArray.add(s);
		}
		else if(s.getStatus().equals("instant reject")){
			rejected.println(s.getName() + " " + s.getMsg());
			rejectArray.add(s);
		}
		else{
			review.println(s.getName() + " " + s.getMsg());
			reviewArray.add(s);
		}
	}
}
