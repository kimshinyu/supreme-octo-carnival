package games.ticTacToe;

public class TicTacToeCell extends Position{
	TicTacToeCellValue value;
	
	public TicTacToeCell(int x, int y){
		super(x,y);
		value = TicTacToeCellValue.EMPTY;
	}
	
	public void putValue(int x, int y, TicTacToeCellValue value){
		
	}
}
