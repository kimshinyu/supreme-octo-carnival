package games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supremeUtils.STextArea;
import supremeUtils.STextField;
import supremeUtils.SupremeChatUI;

public class GamesMain {

	/*public static void main(String[] args) {
		SupremeUI ui = new SupremeUI("Games");
		ui.show("Hello there. Which game do you want to play?");
		ui.show("Chess");
		ui.show("TicTacToe");

		ui.commandsField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String input = ui.commandsField.getText();
				if (input == null || input.isEmpty()) {
					ui.show("               The input is incorrect. Please enter again your choice: ");
				} else {
					String selector = input.toLowerCase();
					switch (selector) {
					case "chess":
						games.chess.App.main();
						return;
					case "tictactoe":
						games.ticTacToe.App.main();
						return;
					default:
					}
				}
			}
		});
	}*/
	public static void main(String[] args) {
		SupremeChatUI ui = new SupremeChatUI("Games");
		STextArea.getInstance(ui.textArea);
		STextField.getInstance(ui.commandsField);
		System.out.println("Hello there. Which game do you want to play?");
		System.out.println("Chess");
		System.out.println("TicTacToe");

		ui.commandsField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String input = ui.commandsField.getText();
				if (input == null || input.isEmpty()) {
					System.out.println("               The input is incorrect. Please enter again your choice: ");
				} else {
					String selector = input.toLowerCase();
					ui.commandsField.setText(null);
					switch (selector) {
					case "chess":
						games.chess.MainGame.init(ui);
						return;
					case "tictactoe":
						games.ticTacToe.MainGame.init(ui);
						return;
					case "checkers":
						games.checkers.MainGame.init(ui);
						return;
					default:
					}
				}
			}
		});
	}
}
