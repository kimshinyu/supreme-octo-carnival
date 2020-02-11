package games.ticTacToe_v1;

import supremeUtils.STextArea;
import supremeUtils.STextField;
import supremeUtils.SupremeChatUI;

public class MainGame {

	public static void init(SupremeChatUI ui){
		main(ui);
	}
	
	public static void main(SupremeChatUI ui) {
		//starts tic tac toe
		STextArea.getInstance(ui.textArea);
		STextField.getInstance(ui.commandsField);
		
		
		System.out.println("The tic-tac-toe game is now starting.");
		//System.out.println("You will be playing against the AI.");
		System.out.println("We wish you a good game.");
		boolean keepPlaying = true;
		//repeat until game is over:
		while(keepPlaying){
			Table table = new Table();
			byte someoneWon = 0;
			boolean firstPlayersTurn = true;
			while(someoneWon == 0){
				table.printTable();
				System.out.println((firstPlayersTurn?"First":"Second") + " player's turn. Choose the cell:");
				TicTacToeCell cell = chooseCell();
				table.draw(firstPlayersTurn, cell);
				table.printTable();
				someoneWon = table.getVictor();
			}
			System.out.print("The victory has been decided! Thw winner is the " + (someoneWon == 1?"first":"second") + " player.");
			System.out.println("Do you want to keep playing? (Yes/No)");
			String response = ui.commandsField.getText();
			keepPlaying = (response.toLowerCase().equals("yes")?true:false);
		}
		System.out.println("The game has ended.");
		System.out.println("Thanks for playing with us.");
	}
	
	private static TicTacToeCell chooseCell(){//TODO
		int i;
		TicTacToeCell selectedCell = null;
		System.out.println("Select the horizontal position:");
		
		
		return selectedCell;
	}

}
