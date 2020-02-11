package games.ticTacToe_v1;

public class Position {
	private int xPosition;
	private int yPosition;
	
	public Position(){}
	
	public Position(int x, int y){
		this.xPosition = x;
		this.yPosition = y;
	}
	
	public int getxPosition() {
		return xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}
	
}


private func minimax(board: Array<Player>, player: Player) -> Int {
    if let winner = self.getWinner(board) as Player {
      return winner.rawValue * player.rawValue // -1 * -1 || 1 * 1
    }

    var move = -1
    var score = -2

    for var i = 0; i < 9; ++i { // For all moves
        if board[i] == Player.Blank { // Only possible moves
            var boardWithNewMove = board // Copy board to make it mutable
            boardWithNewMove[i] = player // Try the move
            let scoreForTheMove = -self.minimax(boardWithNewMove, player: self.getOponnentFor(player)) // Count negative score for oponnent
            if scoreForTheMove > score {
                score = scoreForTheMove
                move = i
            } // Picking move that gives oponnent the worst score
        }
    }
    if move == -1 {
        return 0 // No move - it's a draw
    }
    return score
}