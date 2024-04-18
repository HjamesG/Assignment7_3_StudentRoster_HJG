/**
 * @author Harrison Gilbert
 */
public class StudentRoster {
	private Student[] arr;
		
	public StudentRoster() {
		arr = new Student[5];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Student();
		}
	}
	
	public StudentRoster(int len) {
		arr = new Student[len];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Student();
		}
	}
	
	public StudentRoster(Student one, Student two, Student three, Student four, Student five) {
		arr = new Student[5];
		arr[0] = one;
		arr[1] = two;
		arr[2] = three;
		arr[3] = four;
		arr[4] = five;
	}
	

	public void addStudent(Student stu) {
		Student[] copy = arr;
		arr = new Student[copy.length + 1];
		for(int i = 0; i < copy.length; i++) {
			arr[i] = copy[i];
		}
		arr[copy.length] = stu;
	}
	
	public Student getStudent(String fname, String lname) {
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i].getFirstName().equals(fname)) && (arr[i].getLastName().equals(lname))) {
				return arr[i];
			
			} 
		}
		System.out.println("Student not found.");
		return new Student();
	}
	
	public Student getStudent(int index) {
		return arr[index];
	}
	
	public void setStudent(int index, Student stu) {
		arr[index] = stu;
		
	}
	
	public void setStudent(String fname, String lname, Student stu) {
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i].getFirstName().equals(fname)) && (arr[i].getLastName().equals(lname))) {
				arr[i] = stu;
			
			} 
		}
		
	}
	
	public int getLength() {
		return arr.length;
	}
	
	public String toString() {
		String temp = "";
		for(int i = 0; i < arr.length; i++) {
			temp += arr[i].toString() + "\n\n";
		}
		return temp;
	}
}
