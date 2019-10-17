package lessons.dataStructures.coreType.structuralPatterns.aAdapter;

public class AdaptiveClass extends IncompatibleClass implements InterfaceYouWantToUse {
//very easily understandable,
	//this is good when you have a class upon which you want to implement an interface,
	// and yet the class is already created and incompatible with the interface,
	//so you create a child class that can implement the desired interface

	@Override
	public String getIncClassInfo() {
		return getAttr1()+getAttr2()+getAttr3();
	}

	@Override
	public void createIncClassObject(String attr1, String attr2, String attr3) {
		setAttr1(attr1);
		setAttr2(attr2);
		setAttr3(attr3);
	}

}
