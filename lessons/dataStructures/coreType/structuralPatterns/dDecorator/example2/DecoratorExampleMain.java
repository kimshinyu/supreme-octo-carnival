package lessons.dataStructures.coreType.structuralPatterns.dDecorator.example2;

public class DecoratorExampleMain {

	public static void main(String[] args) {

		CoffeeInterface window1 = new BlackCoffee();
		CoffeeInterface window2 = new WithMilk(window1);
		CoffeeInterface window3 = new WithCream(window1);
		CoffeeInterface window4 = new WithCream(window2);

		System.out.println(window1.getIngredients() + " costs " + window1.getCost() + " dollars.");
		System.out.println(window2.getIngredients() + " costs " + window2.getCost() + " dollars.");
		System.out.println(window3.getIngredients() + " costs " + window3.getCost() + " dollars.");
		System.out.println(window4.getIngredients() + " costs " + window4.getCost() + " dollars.");
		
	}

}
