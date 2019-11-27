package lessons.dataStructures.coreType.creationalPatterns.cSingleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//With Enum
public class SingletonExampleMain {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Started.");
		
		SingletonEnum instance = SingletonEnum.INSTANCE;
		
		System.out.println("Username is: " + instance.getUser());
		
		System.out.print("Do you want to change the data? (Y/N): ");
		boolean wantToChange = br.readLine().equalsIgnoreCase("Y");
		while(wantToChange){
			System.out.println();
			System.out.print("Please enter a new username: ");
			System.out.println();
			String newUsername = br.readLine();
			
			instance.setUser(newUsername);
			
			System.out.println("User's credentials have changed. The new data is: " + instance.getUser());
			System.out.print("Do you want to change the data? (Y/N): ");
			wantToChange = br.readLine().equalsIgnoreCase("Y");
		}
		

		System.out.println("User's last saved username is: " + instance.getUser());
		
		System.out.println("Ended.");
	}

}


/*package lessons.dataStructures.coreType.creationalStructures.cSingleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingletonExampleMain {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Started.");
		
		SingletonClass instance = SingletonClass.getInstance();
		
		System.out.println("Creating user");
		UserClass user = instance.getUser();
		System.out.println("Starting user: " + user.toString());
		
		System.out.println("Creating extra user");
		UserClass user2 = instance.getUser();
		System.out.println("Starting user2: " + user2.toString());

		System.out.print("Do you want to change the data? (Y/N): ");
		boolean wantToChange = br.readLine().equalsIgnoreCase("Y");
		if(wantToChange){
			System.out.println();
			System.out.print("Please enter a new username: ");
			System.out.println();
			String newUsername = br.readLine();
			System.out.print("Please enter a new password: ");
			System.out.println();
			String newPassword = br.readLine();
			
			user.setUsername(newUsername);
			user.setPassword(newPassword);
			
			System.out.println("User's credentials have changed. The new data is: " + user.toString());
		}
		
		System.out.println("User1's credentials: " + user.toString());
		System.out.println("User2's credentials: " + user2.toString());
		
		user2 = instance.getUser();
		System.out.println("User2's credentials: " + user2.toString());
		user = instance.getUser();
		System.out.println("User1's credentials: " + user.toString());
		
		System.out.println("Ended.");
	}

}
*/