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

public class SupremeCalculatorUI extends JFrame {

	private JPanel panel;
	public JTextArea textArea;
	private JButton b7,b8,b9,b4,b5,b6,b1,b2,b3,b0,bdot,bplus,bminus,bmult,bdiv,bequals;
	private static final long serialVersionUID = -8428665381926564795L;

	public SupremeCalculatorUI() {
		this.setVisible(true);
		initUI();
	}
	
	public static void main(String[] args){
		new SupremeCalculatorUI();
	}
	
	private final void initUI() {
		
		initPanel();
		initTextArea();
		initButtons();
		setButtonsListeners();

		panel.add(textArea);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b0);
		panel.add(bdot);
		panel.add(bplus);
		panel.add(bminus);
		panel.add(bmult);
		panel.add(bdiv);
		panel.add(bequals);

		setResizable(false);
		setTitle("Calculator");
		setSize(320, 430);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initPanel() {
		this.panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
	}

	private void initTextArea() {
		this.textArea = new JTextArea();
		textArea.setBounds(0, 0, 300, 200);
		textArea.setFont(new Font("Serif", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
	}

	private void initButtons() {
		this.b7 = new JButton("7");
		this.b8 = new JButton("8");
		this.b9 = new JButton("9");
		this.b4 = new JButton("4");
		this.b5 = new JButton("5");
		this.b6 = new JButton("6");
		this.b1 = new JButton("1");
		this.b2 = new JButton("2");
		this.b3 = new JButton("3");
		this.b0 = new JButton("0");
		this.bdot = new JButton(".");
		this.bequals = new JButton("=");
		this.bplus = new JButton("+");
		this.bminus = new JButton("-");
		this.bmult = new JButton("*");
		this.bdiv = new JButton("/");
		
		this.b7.setBounds(0, 200, 80, 50);
		this.b8.setBounds(80, 200, 80, 50);
		this.b9.setBounds(160, 200, 80, 50);
		this.b4.setBounds(0, 250, 80, 50);
		this.b5.setBounds(80, 250, 80, 50);
		this.b6.setBounds(160, 250, 80, 50);
		this.b1.setBounds(0, 300, 80, 50);
		this.b2.setBounds(80, 300, 80, 50);
		this.b3.setBounds(160, 300, 80, 50);
		this.b0.setBounds(0, 350, 80, 50);
		this.bdot.setBounds(80, 350, 80, 50);
		this.bequals.setBounds(160, 350, 80, 50);
		this.bplus.setBounds(240, 200, 80, 50);
		this.bminus.setBounds(240, 250, 80, 50);
		this.bmult.setBounds(240, 300, 80, 50);
		this.bdiv.setBounds(240, 350, 80, 50);
	}

	private void setButtonsListeners() {
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		bdot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		bequals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		bplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		bminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		bmult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		bdiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}

}
