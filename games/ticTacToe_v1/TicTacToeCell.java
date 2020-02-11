package games.ticTacToe_v1;

public class TicTacToeCell extends Position{
	TicTacToeCellValue value;
	
	public TicTacToeCell(int x, int y){
		super(x,y);
		value = TicTacToeCellValue.EMPTY;
	}
	
	public void putValue(int x, int y, TicTacToeCellValue value){
		
	}
}
