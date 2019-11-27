package lessons.dataStructures.coreType.structuralPatterns.dDecorator.example2;

public class WithCream extends CoffeeDecorator {

		public WithCream(CoffeeInterface coffee) {
			super(coffee);
		}
		
		@Override
	    public int getCost() {
			return super.getCost() + 2;
	    }

	    @Override
	    public String getIngredients() {
	        return super.getIngredients() + " and cream";
	    }


}
