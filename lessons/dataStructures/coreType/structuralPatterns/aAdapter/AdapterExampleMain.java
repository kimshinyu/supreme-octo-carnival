package lessons.dataStructures.coreType.structuralPatterns.aAdapter;

public class AdapterExampleMain {

	public static void main(String[] args) {
		InterfaceYouWantToUse interfaceObject = new AdaptiveClass();
		interfaceObject.createIncClassObject("Bob", "Dylan", "musician");
		System.out.println(interfaceObject.getIncClassInfo());
	}

}
