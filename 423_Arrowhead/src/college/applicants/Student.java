/*
 * Created on : 4-23-17
 * Author     : Shane Yang
 * Description: Software Engineering Candidate Project: Student: This describes everything student.
 * This will allow anyone to set and get the named student's attributes.
 * If necessary the constructor can be modified or a new one can be added for a student with more attributes.
 */
package college.applicants;

public class Student {
	private int myAge;
	private int mySAT;
	private int myACT;
	private double myGPA;
	private double myGPAScale;
	private int myFelonies;
	private String myFName;
	private String myLName;
	private String myStatus;
	private String message = "";
	//Set student attributes
	//make a student by just name in case of external entry
	public Student(String  fName){
		myFName = fName;
	}
	//student with all variables filled, new attributes can be added to this constructor or a new one can be created to meet the requirements of another type of student
	public Student(int age, double GPA, double GPAScale, int SAT, int ACT, int felonies, String fName, String Lname, String status){
		myAge = age;
		myGPA = GPA;
		myGPAScale= GPAScale;
		mySAT = SAT;
		myACT = ACT;
		myFelonies = felonies;
		myFName = fName;
		myLName = Lname;
		myStatus = status;
	}
	public void setAge(int age){
		myAge = age;
	}
	public void setName(String Fname, String Lname){
		myFName = Fname;
		myLName = Lname;
	}
	public void setGPA(double GPA){
		myGPA = GPA;
	}
	public void setGPAScale(double GPAScale){
		myGPAScale = GPAScale;
	}
	public void setSAT(int SATScore){
		mySAT = SATScore;
	}
	public void setACT(int ACTScore){
		myACT = ACTScore;
	}
	public void setFelonies(int felonies){
		myFelonies = felonies;
	}
	public void setStatus(String status){
		myStatus = status;
	}
	public void setMessage(String msg){
		message+=msg;
	}
	//Get student attributes
	public int getAge(){
		return myAge;
	}
	public String getName(){
		return myFName + " " + myLName;
	}
	public String getFName(){
		return myFName;
	}
	public String getLName(){
		return myLName;
	}
	public double getGPA(){
		return myGPA;
	}
	public double getGPAScale(){
		return myGPAScale;
	}
	public int getSAT(){
		return mySAT;
	}
	public int getACT(){
		return myACT;
	}
	public int getFelonies(){
		return myFelonies;
	}
	public String getStatus(){
		return myStatus;
	}
	public String getMsg(){
		return message;
	}
}
