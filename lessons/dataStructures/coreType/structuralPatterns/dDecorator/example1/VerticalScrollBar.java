package lessons.dataStructures.coreType.structuralPatterns.dDecorator.example1;

public class VerticalScrollBar extends WindowDecorator {

	public VerticalScrollBar(WindowInterface window) {
		super(window);
	}
	
	@Override
    public void fill() {
        super.fill();
        drawVerticalScrollBar();
    }

    private void drawVerticalScrollBar() {
        // Draw the vertical scrollbar
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", including vertical scrollbars";
    }

}
