public class Square {// DONEDONE
	SquareType type;
	int colour; // 0 for black, 1 for white, -1 for empty

	// builder
	public Square(SquareType type, int colour) {
		if (type == SquareType.EMPTY) {
			colour = -1;
		}
		this.type = type;
		this.colour = colour;
	}

	// getters
	public SquareType getType() {
		return type;
	}

	public int getColour() {
		return colour;
	}

	// setters
	public void setType(SquareType type) {
		this.type = type;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}
	
	public String toString(){
		String c = (this.colour == 0?"Black":"White");
		switch(this.type){
			case PAWN:
				return c + "PAWN" + "\t";
			case ROOK:
				return c + "ROOK" + "\t";
			case KNIGHT:
				return c + "KNIGHT" + "\t";
			case BISHOP:
				return c + "BISHOP" + "\t";
			case QUEEN:
				return c + "QUEEN" + "\t";
			case KING:
				return c + "KING" + "\t";
			case EMPTY:
				return "\t" + "0" + "\t";
			default:
				return "\t" + "ERROR" + "\t";
		}
	}
	
}