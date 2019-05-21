public enum SquareType{//DONEDONE
	EMPTY,KING,QUEEN,ROOK,BISHOP,KNIGHT,PAWN;	
	
	public SquareType fromString(String s){
		switch(s){
		case "PAWN":
			return PAWN;
		case "ROOK":
			return ROOK;
		case "KNIGHT":
			return KNIGHT;
		case "BISHOP":
			return BISHOP;
		case "QUEEN":
			return QUEEN;
		case "KING":
			return KING;
		default:
		System.out.println("Error in String to SquareType transformation.");
		return EMPTY;
		}
	}
	
}