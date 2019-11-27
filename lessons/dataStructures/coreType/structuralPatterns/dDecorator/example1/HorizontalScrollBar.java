package lessons.dataStructures.coreType.structuralPatterns.dDecorator.example1;

public class HorizontalScrollBar extends WindowDecorator {

		public HorizontalScrollBar(WindowInterface window) {
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
	        return super.getDescription() + ", including horizontal scrollbars";
	    }


}
