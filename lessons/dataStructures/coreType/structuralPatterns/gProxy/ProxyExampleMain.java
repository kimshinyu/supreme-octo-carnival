package lessons.dataStructures.coreType.structuralPatterns.gProxy;

import java.util.Scanner;

public class ProxyExampleMain {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter permission level: ");
		int permissionLevel = scanner.nextInt();
		System.out.println();
		WebAccessProxy webAccess = new WebAccessProxy(permissionLevel);
		
		System.out.println("List of allowed web pages: ");
		for(String url : webAccess.getAllowed()){
			System.out.println(url);
		}
		
		System.out.println("You have been granted administrative rights.");
		
		System.out.print("Would you like to make changes to the list of allowed web pages? (Y/N): ");
		String response = scanner.next();
		System.out.println();
		
		if((!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N"))){
			System.out.println("Sorry, but your answer is invalid.");
		}else{
			if(response.equalsIgnoreCase("Y")){
				System.out.print("Would you like to add or remove? (A/R): ");
				response = scanner.next();
				System.out.println();
				if((!response.equalsIgnoreCase("A") && !response.equalsIgnoreCase("R"))){
					System.out.println("Sorry, but your answer is invalid.");
				}else{
					if(response.equalsIgnoreCase("A")){
						System.out.println("Please enter url to add: ");
						response = scanner.next();
						System.out.println();
						webAccess.addToAllowed(response);
						System.out.println("url added.");
						System.out.println("New list of allowed web pages: ");
						for(String url : webAccess.getAllowed()){
							System.out.println(url);
						}
					}
					if(response.equalsIgnoreCase("R")){
						System.out.println("We are sorry to announce that removal is not implemented yet.");
					}
				}
			}
		}
		
		
		System.out.println("Thanks for your patronage.");
	}

}
