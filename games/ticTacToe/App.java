package games.ticTacToe;

import supremeUtils.STextArea;
import supremeUtils.STextField;
import supremeUtils.SupremeChatUI;

public class App {

	public static void main(SupremeChatUI ui) {
		//starts tic tac toe
		STextArea.getInstance(ui.textArea);
		STextField.getInstance(ui.commandsField);
		
		
		System.out.println("The tic-tac-toe game is now starting.");
		//System.out.println("You will be playing against the AI.");
		System.out.println("We wish you a good game.");
		//repeat until game is over:
		Table game = new Table();
		System.out.println("Do you want to keep playing? (Yes/No)");
		//boolean yes or no
		
		
		System.out.println("The game has ended.");
		System.out.println("Thanks for playing with us.");
	}

}
