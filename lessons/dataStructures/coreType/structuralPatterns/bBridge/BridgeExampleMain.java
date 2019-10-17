package lessons.dataStructures.coreType.structuralPatterns.bBridge;

public class BridgeExampleMain {

	public static void main(String[] args) {
		//The Bridge Pattern works by having an intermediary class between the 'main' (called functional abstraction)
		//from the formal implementation of an interface
		    PersonFormat manager = new PersonFormat("G Sanatorial Developers");  
		    manager.person = new People();
		    manager.newPerson("Freddy");
		    manager.newPerson("Diego");
		    manager.newPerson("Anibal");
		    manager.newPerson("Aron");
		    manager.newPerson("Francisco");
		    manager.newPerson("Santiago");
		    manager.newPerson("Leo");
		    manager.newPerson("Walter");
		    manager.displayAll();
		    manager.display();
		    manager.next();
		    manager.next();
		    manager.next();
		    manager.next();
		    manager.next();
		    manager.next();
		    manager.next();
		    manager.delete("Santiago");  
		    manager.next();
		    manager.next();
		    manager.display();  
		    manager.next();
		    manager.next();
		    manager.next();
		    manager.delete("Francisco");  
		    manager.next();
		    manager.next();
		    manager.next();
		    manager.display();  
		    manager.displayAll();  
		
		
	}

}
