package lessons.dataStructures.coreType.structuralPatterns.dDecorator.example2;

public class WithMilk extends CoffeeDecorator {

	public WithMilk(CoffeeInterface coffee) {
		super(coffee);
	}
	
	@Override
    public int getCost() {
		return super.getCost() + 2;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " with milk";
    }

}
