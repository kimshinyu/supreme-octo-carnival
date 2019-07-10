package games;

import java.io.IOException;

import supremeUtils.SupremeUI;

public class GamesMain {
	
	private static SupremeUI ui = new SupremeUI("Games");
	
	public static void main() throws IOException {
		boolean gameChosen = false;
		System.out.println("Hello there. Which game do you want to play?");
		while(!gameChosen){
			System.out.println("0.Chess");
			System.out.println("1.Tic-Tac-Toe");
			if(ui.controller.hasNext()){
				int sel = ui.controller.nextInt();
				switch(sel){
					case 0:
						games.chess.App.main();
						return;
					case 1:
						games.ticTacToe.App.main();
						return;
					default:
				}
				System.out.println("The input is incorrect. Please enter again your choice: ");
			}
		}
	}
}
