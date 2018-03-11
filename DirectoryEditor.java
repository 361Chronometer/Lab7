import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class DirectoryEditor {
	 // user input to add to the directory
	static DateFormat formatter = new SimpleDateFormat("h:mm:ss:S");
	static DirectoryProxy controller = new DirectoryProxy();
	static ArrayList<Employee> emps = new ArrayList<Employee>();
	
	public final static void main(String[] args) {

		//ArrayList<Employee> emps = new ArrayList<Employee>();
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); 
		String next; 
		Gson g = new Gson();
		do {
			
			
			System.out.print("Enter a command (\"end\") to finish : ");

			next = input.nextLine();

			if (next.equalsIgnoreCase("add")) {
				
				add(input.nextLine());
				String out = g.toJson(emps);
				controller.add(out);
			}
			else if (next.equalsIgnoreCase("clear")) {
				emps = new ArrayList<Employee>();
				controller.clear();
			}
			else if (next.equalsIgnoreCase("print")) {
				controller.print();
			}
		} while (!next.equalsIgnoreCase("end"));
		String out = g.toJson(emps);
		controller.add(out);
	}

	public static void add(Employee e){
		for(int i = 0; i < emps.size(); ++i){
			if(e.lname.charAt(0) < emps.get(i).lname.charAt(0)){
				emps.add(i, e);
				return;
			}
		}
		emps.add(e);
	}
	public static void add(String fname, String lname, String department, String phone){
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
		
		String[] info = in.split(" ");
		
		fname = info[0];
		lname = info[1];
		department = info[2];
		phone = info[3];
		if (fname != null && lname != null && department != null && phone != null) {
			for(int i = 0; i < 4; ++i) {
				if(info[i] == "add" || info[i] == "clear" || info[i] == "print") {
					return;
				}
			}
			add (fname, lname, department, phone);
		}
		
//		Gson g = new Gson();
//		ArrayList<Employee> e = (g.fromJson(in,new TypeToken<Collection<Employee>>(){}.getType()));
//		emps.add(e.get(0));
		
	
		
	}

	public static List<String> getCommands(String fileName) {
		if(fileName == null) return new ArrayList<String>(0);
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource("resources/" + fileName).getFile());
		if(! (file.exists() && file.canRead())) {
			System.err.println("Cannot access file! Non-existent or read access restricted");
			return new ArrayList<String>(0);
		}

		List<String> commandLines = new ArrayList<String>(32);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		while(scanner.hasNextLine()) {
			commandLines.add(scanner.nextLine());
		}

		scanner.close();

		return commandLines;
	}
}
