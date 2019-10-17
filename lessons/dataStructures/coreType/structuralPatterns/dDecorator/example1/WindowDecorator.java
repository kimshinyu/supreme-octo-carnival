package lessons.dataStructures.coreType.structuralPatterns.dDecorator.example1;

public abstract class WindowDecorator implements WindowInterface{
	private final WindowInterface window;
	
	public WindowDecorator (WindowInterface window) {
        this.window = window;
    }
	
	@Override
	public void fill() {
		window.fill();
	}

	@Override
	public String getDescription() {
		return window.getDescription();
	}
}
