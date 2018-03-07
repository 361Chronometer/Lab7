
public class Employee {
	public String fname;
	public String lname;
	public int phone;
	public String department;
	
	public Employee (String first, String last, String dep, int phonen) {
		fname = first;
		lname = last;
		phone = phonen;
		department = dep;
	}
	
	public String toString () {
		return lname + ", " + fname + " " + phone + " " + department;
	}
}
