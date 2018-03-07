import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DirectoryEditor {
	 // user input to add to the directory
	static DateFormat formatter = new SimpleDateFormat("h:mm:ss:S");
	static DirectoryProxy controller = new DirectoryProxy();

	public final static void main(String[] args) {

		Scanner input = new Scanner(System.in); 
		String next; 
		String[] line;

		do {
			System.out.print("Enter a command (\"end\") to finish : ");

			next = input.nextLine();
			line = next.split(" ");

			if (line[0].equalsIgnoreCase("add")) {
				List<String> commandLines = getCommands(line[1]);
				for (String commandLine : commandLines) {
					controller.add(commandLine.toUpperCase());
				}
			}
			else if (line[0].equalsIgnoreCase("clear")) {
				controller.clear();
			}
			else if (line[0].equalsIgnoreCase("print")) {
				controller.print();
			}
		} while (!next.equalsIgnoreCase("end"));
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
