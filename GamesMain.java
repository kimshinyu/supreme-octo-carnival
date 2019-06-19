

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class GamesMain {
	
	private static Scanner gameSelector = new Scanner(System.in);
	
	public static void main() throws IOException {
		boolean gameChosen = false;
		System.out.println("Hello there. Which game do you want to play?");
		while(!gameChosen){
			System.out.println("0.Chess");
			System.out.println("1.Tic-Tac-Toe");
			if(gameSelector.hasNext()){
				int sel = gameSelector.nextInt();
				switch(sel){
					case 0:
						chess.App.main();
						return;
					case 1:
						ticTacToe.App.main();
						return;
					default:
				}
				System.out.println("The input is incorrect. Please enter again your choice: ");
			}
		}
	}
}
