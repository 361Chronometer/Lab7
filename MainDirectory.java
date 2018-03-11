import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class MainDirectory {
	static ArrayList<Employee> emps = new ArrayList<Employee>();
	
	
	public static void add(String in){//commas?order?
		emps.clear();
		Gson g = new Gson();
		ArrayList<Employee> e = (g.fromJson(in,new TypeToken<Collection<Employee>>(){}.getType()));
		for(int i = 0; i < e.size(); ++i) {
			emps.add(i, e.get(i));
		}
		
	
		//print();
	}
	
	public static void print(){
		if(emps.isEmpty()){
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
