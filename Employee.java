
public class Employee {
	public String fname;
	public String lname;
	public String phone;
	public String department;
	
	public Employee (String first, String last, String dep, String phone2) {
		fname = first;
		lname = last;
		phone = phone2;
		department = dep;
	}
	
	public String toString () {
		return lname + ", " + fname + " " + phone + " " + department;
	}
}
