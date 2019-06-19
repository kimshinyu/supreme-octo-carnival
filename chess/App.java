package chess;


public class App{
	public static void main() { //done done
		//starts chess
		System.out.println("The chess game is now starting.");
		Table chess = new Table();
//maybe ask for player names		
		//repeat until game is over:
		boolean whitePlays = true;
		while (!chess.checkedKing()){
			chess.printTable();//prints table (tabulate) for the player
			if(whitePlays){//do movement for white
				System.out.println("The whites plays.");
				chess.getInputAndMove(1);	
			}
			else{//do movement for black
				System.out.println("The blacks plays.");
				chess.getInputAndMove(0);	
			}
		//check kings (to change keepPlaying, if white cannot move print "blacks win" if black cannot move print "whites win")
		whitePlays = !whitePlays; //changes turns
		}
		System.out.println("The game has ended.");
		System.out.println("Thanks for playing with us.");
	}
}