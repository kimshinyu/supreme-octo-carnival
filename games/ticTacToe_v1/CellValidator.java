package games.ticTacToe_v1;

public class CellValidator {
	boolean validity;
	
	public boolean validatePosition(Position position){
		int x = position.getxPosition();
		int y = position.getyPosition();
		return (x>0 && x<3) && (y>0 && y<3);
	}
}
