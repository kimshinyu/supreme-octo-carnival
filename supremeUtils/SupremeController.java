package supremeUtils;

import java.util.Scanner;

public class SupremeController {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public boolean hasNext(){
		return scanner.hasNext();
	}
	
	public int nextInt(){
		return scanner.nextInt();
	}
	
	public void show(){
		//TODO see about showing text and stuff
	}
}
