package supremeUtils;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SupremeUI extends JFrame {

	private JPanel panel;
	private JTextArea textArea;
	public JTextField commandsField;
	private JButton quitButton;
	/**
	 * LA idea de tener esta clase es separar el UI del proyecto actual (games),
	 * y poder utilizarlo en otras cosas
	 */
	private static final long serialVersionUID = -8428665381926564795L;

	public SupremeUI(String title) {
		initUI(title);
	}
	
	public static void main(String[] args){
		new SupremeUI("SupremeUI");
	}
	
	public void show(String s){
		this.textArea.append(s + "\n");
	}
	
	public final void initUI(String title) {
		
		initPanel();
		initTextArea();
		initCommandsField();
		setCommandsFieldListeners();
		initQuitButton();
		setQuitButtonListeners();

		panel.add(textArea);
		panel.add(commandsField);
		panel.add(quitButton);

		setResizable(false);
		setTitle(title);
		setSize(800, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.out.println("END");
	}

	private void initPanel() {
		this.panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
	}

	private void initTextArea() {
		this.textArea = new JTextArea();
		textArea.setBounds(0, 0, 800, 600);
		textArea.setFont(new Font("Serif", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
	}

	private void initCommandsField() {
		this.commandsField = new JTextField("Enter your commands here...");
		commandsField.setBounds(0, 600, 800, 30);
		commandsField.setEnabled(true);
	}

	private void initQuitButton() {
		this.quitButton = new JButton("Quit");
		quitButton.setBounds(350, 640, 80, 30);
	}

	private void setCommandsFieldListeners() {
		commandsField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				textArea.append(commandsField.getText() + "\n");
				commandsField.setText(null);
			}
		});
		commandsField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(commandsField.getText() == null || commandsField.getText().equals("Enter your commands here...")){
					commandsField.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(!commandsField.hasFocus()){
					if(commandsField.getText() == null || commandsField.getText().isEmpty()){
						commandsField.setText("Enter your commands here...");
					}
				}
			}
		});
	}

	private void setQuitButtonListeners() {
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}

}
