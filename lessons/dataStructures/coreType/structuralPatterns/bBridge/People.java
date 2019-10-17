package lessons.dataStructures.coreType.structuralPatterns.bBridge;

import java.util.ArrayList;
import java.util.List;

public class People implements Person {

	private List<String> listOfPeople;
	private int pointer = 0;

	public People(){
		listOfPeople = new ArrayList<String>();
	}
	
	@Override
	public void nextPerson() {
		if(pointer < listOfPeople.size()-1){
			pointer++;
		}else{
			pointer = 0;
		}
		System.out.println("Current person: " + listOfPeople.get(pointer));
	}

	@Override
	public void previousPerson() {
		if(pointer > 0){
			pointer--;
		}else{
			pointer = listOfPeople.size()-1;
		}
		System.out.println("Current person: " + listOfPeople.get(pointer));
	}

	@Override
	public void newPerson(String person) {
		listOfPeople.add(person);
		System.out.println("New person added! " + person + " has been added to the list.");
	}

	@Override
	public void deletePerson(String person) {
		System.out.println(listOfPeople.remove(person)?
				person + " has been removed from the list."
				:person + " does not exist in the list.");
	}

	@Override
	public void displayPerson() {
		System.out.println("The current person to be seen is " + listOfPeople.get(pointer) + ".");
	}

	@Override
	public void displayAllPeople() {
		System.out.println("Displaying the full list...");
		for(String person:listOfPeople){
			System.out.println("Person: " + person + ".");
		}
	}

}
