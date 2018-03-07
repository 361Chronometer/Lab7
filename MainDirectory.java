import java.util.ArrayList;


public class MainDirectory {
	ArrayList<Employee> emps = new ArrayList<Employee>();
	
	public void add(Employee e){
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
	
	public void print(){
		for(int i = 0; i < emps.size(); ++i){
			System.out.println(emps.get(i).toString());
		}
	}
	
	public void clear(){
		emps = new ArrayList<Employee>();
	}
}
