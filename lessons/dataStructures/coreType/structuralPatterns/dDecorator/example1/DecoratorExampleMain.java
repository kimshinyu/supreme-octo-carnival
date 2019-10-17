package lessons.dataStructures.coreType.structuralPatterns.dDecorator.example1;

public class DecoratorExampleMain {

	public static void main(String[] args) {

		WindowInterface window1 = new SimpleWindow();
		WindowInterface window2 = new VerticalScrollBar(new SimpleWindow());
		WindowInterface window3 = new HorizontalScrollBar(new SimpleWindow());

		System.out.println(window1.getDescription());
		System.out.println(window2.getDescription());
		System.out.println(window3.getDescription());
		
	}

}
