
public class Employee {
	public String firstn;
	public String lastn;
	public String phone;
	public String department;
	
	public Employee (String first, String last, String phonen, String dep) {
		firstn = first;
		lastn = last;
		phone = phonen;
		department = dep;
	}
	
	public String toString () {
		return lastn + ", " + firstn + " " + phone + " " + department;
	}
}
