package lessons.dataStructures.coreType.structuralPatterns.bBridge;

public interface Person {
	public void nextPerson();

	public void previousPerson();

	public void newPerson(String person);

	public void deletePerson(String person);

	public void displayPerson();

	public void displayAllPeople();
}
