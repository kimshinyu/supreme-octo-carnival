package games.chess_v2.validator;

import games.chess_v2.Square;

public interface MovementValidator {
	public boolean validateMove(Square a, Square b);
}
