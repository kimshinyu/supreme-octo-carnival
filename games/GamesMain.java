package games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supremeUtils.SupremeUI;

public class GamesMain {

	public static void main(String[] args) {
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
		ui.show("end");
	}
}
