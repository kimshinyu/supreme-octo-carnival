package lessons.dataStructures.coreType.structuralPatterns.bBridge;

public class PersonFormat extends PeopleManager {
	public PersonFormat(String groupName){  
	        super(groupName);  
	    }

	public void displayAll() {
		System.out.println("\n---------------------------------------------------------");
		super.displayAll();
		System.out.println("-----------------------------------------------------------");
	}
}
