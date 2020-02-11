package games.ticTacToe_v1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import games.chess_v2.Square;

class Table {
	
	Map<Position, TicTacToeCellValue> table;
	
	public Table(){
		table = new HashMap<Position, TicTacToeCellValue>();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				table.put(new Position(i,j), TicTacToeCellValue.EMPTY);
			}
		}
	}
	
	public void draw(boolean firstPlayersTurn, TicTacToeCell cell){
		
	}
	
	public byte getVictor(){ //return 0 if no victory yet, 1 if first player won, 2 if second player won
		return 0;
	}
	
	public void printTable(){
		System.out.println("[\tX1\t,\tX2\t,\tX3]");
		printRow(printEachColumn);
	    for (Square[] rank : this.table) {
	        // converting each row as string 
	        // and then printing in a separate line 
	    	System.out.print("Y"+i);
	        System.out.println(Arrays.toString(rank));
	        i++;
		} 
	}
}
