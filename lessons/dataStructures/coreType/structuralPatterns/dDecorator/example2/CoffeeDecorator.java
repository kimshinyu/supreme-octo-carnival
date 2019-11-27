package lessons.dataStructures.coreType.structuralPatterns.dDecorator.example2;

public abstract class CoffeeDecorator implements CoffeeInterface{
	private final CoffeeInterface coffee;
	
	public CoffeeDecorator (CoffeeInterface coffee) {
        this.coffee = coffee;
    }
	
	@Override
	public int getCost() {
		return coffee.getCost();
	}

	@Override
	public String getIngredients() {
		return coffee.getIngredients();
	}
}
