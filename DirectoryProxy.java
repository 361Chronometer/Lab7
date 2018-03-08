import java.util.ArrayList;

public class DirectoryProxy {
	// add collection to the directory
	public void add (String e) {
		// transport to directory server
		// parse string to get names, phone, and dep
		MainDirectory.add(e);
	}
	
	// print with Json
	public void print () {
		// transport to directory server
		MainDirectory.print();
	}
	
	// clear
	public void clear() {
		// transport to directory server
		MainDirectory.clear();
	}
}
