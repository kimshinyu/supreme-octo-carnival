package lessons.dataStructures.coreType.structuralPatterns.bBridge;

public class PeopleManager {
	protected Person person;
	public String groupName;
	
	public PeopleManager(String groupName){
		this.groupName = groupName;
	}
	
	public void next(){
		person.nextPerson();
	}
	public void previous(){
		person.previousPerson();
	}
	public void newPerson(String name){
		person.newPerson(name);
	}
	public void delete(String name){
		person.deletePerson(name);
	}
	public void display(){
		person.displayPerson();
	}
	public void displayAll(){
		System.out.println("Group: " + groupName);
		person.displayAllPeople();
	}

}
