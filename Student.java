/**
 * 
 */

/**
 * @author Harrison Gilbert
 */
public class Student {
	private String firstName;
	private String lastName;
	private double GPA;
	private String homeAdd;
	private String currentAdd;
	private String phoneNum;
	
	public Student() {
		firstName = "BLANK";
		lastName = "BLANK";
		GPA = -1.0;
		homeAdd = "BLANK";
		currentAdd = "BLANK";
		phoneNum = "BLANK";
	}
	
	public Student(String first, String last, double gpa, String home, String current, String num) {
		firstName = first;
		lastName = last;
		GPA = gpa;
		homeAdd = home;
		currentAdd = current;
		phoneNum = num;
	}
	
	public void setFirstName(String name) {
		firstName = name; 
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String name) {
		lastName = name; 
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setHomeAdd(String add) {
		homeAdd = add; 
	}
	
	public String getHomeAdd() {
		return homeAdd;
	}
	
	public void setCurrentAdd(String add) {
		currentAdd = add; 
	}
	
	public String getCurrentAdd() {
		return currentAdd;
	}
	
	public void setGPA(double gpa) {
		GPA = gpa;
	}
	
	public double getGPA() {
		return GPA;
	}
	
	public void setPhoneNum(String num) {
		phoneNum = num;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public String toString() {
		return "First name: " + firstName + "\nLast Name: " + lastName + "\nGPA: " + GPA + "\nHome Address: " + homeAdd + "\nCurrent Address: "+ currentAdd + "\nPhone Number: " + phoneNum;
	}
}
