import java.util.ArrayList;


public class MainDirectory {
	static ArrayList<Employee> emps = new ArrayList<Employee>();
	
	public static void add(Employee e){
		for(int i = 0; i < emps.size(); ++i){
			if(e.lname.charAt(0) < emps.get(i).lname.charAt(0)){
				emps.add(i, e);
				return;
			}
			else if (e.lname.charAt(0) == emps.get(i).lname.charAt(0)){
				for(int j = 0; j <e.lname.length() && j < emps.get(i).lname.length(); ++j){
					if(e.lname.charAt(j) < emps.get(i).lname.charAt(j)){
						emps.add(i,e);
						return;
					}
					emps.add(i+1, e);
				}
			}
		}
		emps.add(e);
	}
	public static void add(String fname, String lname, String department, int phone){
		if(fname.equalsIgnoreCase("add") || fname.equalsIgnoreCase("end") || fname.equalsIgnoreCase("print") || fname.equalsIgnoreCase("clr")){
			return;
		}
		Employee e = new Employee(fname,lname,department,phone);
		add(e);
	}
	public static void add(String in){//commas?order?
		String fname = "";
		String lname = "";
		String department = "";
		String phone = "";
		int p = 0;
		
		String temp = "";
		
		for(int i = 0; i < in.length(); ++i){
			if(in.charAt(i) != ' '){
				temp = temp + in.charAt(i);
			}
			else{
				if(fname.isEmpty()){
					fname = temp;
				}
				else if(lname.isEmpty()){
					lname = temp;
				}
				else if(department.isEmpty()){
					department = temp;
				}
				temp = "";
			}
		}
		phone = temp;
		p = Integer.parseInt(phone);
		if(!(phone.isEmpty())){
			add(fname,lname,department,p);
		}
		
	}
	
	public static void print(){
		if(emps.get(0) == null){
			System.out.println("Empty Directory");
		}
		for(int i = 0; i < emps.size(); ++i){
			System.out.println(emps.get(i).toString());
		}
	}
	
	public static void clear(){
		emps = new ArrayList<Employee>();
	}
}

