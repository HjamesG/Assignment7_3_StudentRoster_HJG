/**
 * 
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Harrison Gilbert
 */
public class Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		StudentRoster roster;
		String filename = "studentRosterDataSheet.txt";
		
		//Initializes file if not already made
		try {
			File myObj = new File(filename);
		    if (myObj.createNewFile()) {
		      System.out.println("File created: " + myObj.getName());
		    } else {
		      System.out.println("Exisiting File Loading...");
		    }
		} catch (IOException e) {
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}

		roster = new StudentRoster(0);
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNext()) {

			    String fname = myReader.next(); 
			   	String lname = myReader.next();
			   	double GPA = myReader.nextDouble();
			   	String hadd = myReader.next();
			   	String cadd = myReader.next();
		    	String pnum = myReader.next();
		    	Student temp = new Student(fname, lname, GPA, hadd, cadd, pnum);
		    	roster.addStudent(temp);
			}
			System.out.println("File Loaded!\n\n");
			myReader.close();
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		
	
		
		boolean exit = true;
		while (exit){
			System.out.println("MAIN MENU:\n1.Veiw Roster\n2.Veiw Student\n3.Add Student\n4.Change Student data \n5.Save Data\n6.Exit");
			System.out.println("\nEnter choice: ");
			int choice = scnr.nextInt();
			if (choice == 1) {
				if (roster.getLength() < 1) {
					System.out.println("\nYour roster is empty.\n");
				} else {
					System.out.println(roster.toString());
				}
			} else if (choice == 2) {
				System.out.println("Enter the student first name you would like to veiw: ");
				String tempfname = scnr.next();
				System.out.println("Enter the student last name you would like to veiw: ");
				Student temp = roster.getStudent(tempfname, scnr.next());
				System.out.println(temp.toString() + "\n");
			} else if (choice == 3) {
				System.out.println("Student's first name: ");
				String fname = scnr.next();
				System.out.println("Student's last name: ");
				String lname = scnr.next();
				System.out.println("Student's GPA: ");
				double GPA = scnr.nextDouble();
				System.out.println("Student's home address: ");
				String homeAdd = scnr.next();
				System.out.println("Student's current address: ");
				String currAdd = scnr.next();
				System.out.println("Student's phone number: ");
				String phone = scnr.next();
				
				Student temp = new Student(fname, lname, GPA, homeAdd, currAdd, phone);
				roster.addStudent(temp);
			} else if (choice == 4) {
				System.out.println("What's the first name of the student would you like to alter?");
				String first = scnr.next();
				System.out.println("What's the last name of the student would you like to alter?");
				String last = scnr.next();
				System.out.println("What would you like to change?\n1. First name\n2. Last name\n3. GPA\n4. Home address\n5. Current address\n6. Phone Number\n7. Back");
				int input = scnr.nextInt();
				if (input == 1) {
					System.out.println("Enter First name: ");
					Student tempStu = roster.getStudent(first, last);
					tempStu.setFirstName(scnr.next());
					roster.setStudent(first, last, tempStu);
				} else if (input == 2) {
					System.out.println("Enter Last name: ");
					Student tempStu = roster.getStudent(first, last);
					tempStu.setLastName(scnr.next());
					roster.setStudent(first, last, tempStu);
				} else if (input == 3) {
					System.out.println("Enter GPA: ");
					Student tempStu = roster.getStudent(first, last);
					tempStu.setGPA(scnr.nextDouble());
					roster.setStudent(first, last, tempStu);
				} else if (input == 4) {
					System.out.println("Enter Home Address:  (Use underscores instead of spaces)");
					Student tempStu = roster.getStudent(first, last);
					tempStu.setHomeAdd(scnr.next());
					roster.setStudent(first, last, tempStu);
				} else if (input == 5) {
					System.out.println("Enter Current Address: (Use underscores instead of spaces)");
					Student tempStu = roster.getStudent(first, last);
					tempStu.setCurrentAdd(scnr.next());
					roster.setStudent(first, last, tempStu);
				} else if (input == 6) {
					System.out.println("Enter Phone Number: ");
					Student tempStu = roster.getStudent(first, last);
					tempStu.setPhoneNum(scnr.nextLine());
					roster.setStudent(first, last, tempStu);
				} else {
					break;
				}
				
				
			} else if (choice == 5) {				
				try {
				    FileWriter myWriter = new FileWriter(filename);
				    
				    for(int i = 0; i < roster.getLength(); i++) {
				    	myWriter.write(roster.getStudent(i).getFirstName() + " ");
				    	myWriter.write(roster.getStudent(i).getLastName() + " ");
				    	myWriter.write("" + (roster.getStudent(i).getGPA()) + " ");
				    	myWriter.write(roster.getStudent(i).getHomeAdd() + " ");
				    	myWriter.write(roster.getStudent(i).getCurrentAdd() + " ");
				    	myWriter.write(roster.getStudent(i).getPhoneNum() + "\n");
				    }				    
				    myWriter.close();
				    System.out.println("\nSuccessfully saved the file.\n");
				} catch (IOException e) {
					System.out.println("An error occurred.");
				    e.printStackTrace();
				}
				
			} else if (choice == 6) {
				exit = false;
			}
			
			
		}
		

		

		
		scnr.close();
	}

}
