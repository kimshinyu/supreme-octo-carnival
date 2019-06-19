import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import supremeUtils.STextArea;
import supremeUtils.STextField;

public class SwingApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8428665381926564795L;

	public SwingApp() {
		initUI();
	}

	public final void initUI() {

		JPanel panel = new JPanel();
		getContentPane().add(panel);

		panel.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 800, 600); 
		textArea.setFont(new Font("Serif", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		STextArea.getInstance(textArea);
		
		JTextField commandsField = new JTextField("Enter your commands here...");
		commandsField.setBounds(0, 600, 800, 30);
		commandsField.setEnabled(true);
		
		//STextField.getInstance(commandsField);
		
		commandsField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				textArea.append(commandsField.getText() + "\n");
				commandsField.setText(null);
			}
		});
		commandsField.addMouseListener(new MouseListener(){
			@Override
			public void mouseEntered(MouseEvent event) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				commandsField.setText(null);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				commandsField.setText(null);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(350, 640, 80, 30);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		panel.add(quitButton);
		//JScrollPane jText = new JScrollPane(textField);
		panel.add(textArea);
		panel.add(commandsField);

		setResizable(false);
		setTitle("Game Apps GUI");
		setSize(800, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		CustomInputStream cis = new CustomInputStream(commandsField);
		System.setIn(cis);
		
		try{
			GamesMain.main();
		}catch(NullPointerException e){System.out.println("nullpointer");}
		catch(IOException e){System.out.println("ioexception");}
		
	}
	
	class CustomInputStream extends InputStream {
	    byte[] contents;
	    int pointer = 0;

	    public CustomInputStream(final JTextField text) {

	        text.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyReleased(KeyEvent e) {
	                if(e.getKeyChar()=='\n'){
	                    contents = text.getText().getBytes();
	                    pointer = 0;
	                    text.setText("");
	                }
	                super.keyReleased(e);
	            }
	        });
	    }

	    @Override
	    public int read() throws IOException {
	        if(pointer >= contents.length) return -1;
	        return this.contents[pointer++];
	    }

	}
	
	public static void main(String[] args) {
		SwingApp ex = new SwingApp();
		ex.setVisible(true);
	}
}
