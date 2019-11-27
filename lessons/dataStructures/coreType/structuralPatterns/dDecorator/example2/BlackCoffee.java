package lessons.dataStructures.coreType.structuralPatterns.dDecorator.example2;

public class BlackCoffee implements CoffeeInterface{

	@Override
	public int getCost() {
		return 5;
	}

	@Override
	public String getIngredients() {
		return "Coffee";
	}

}
