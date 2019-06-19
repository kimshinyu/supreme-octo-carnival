import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Example extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Example() {
        initUI();
    }

    public final void initUI() {
        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");
        button1.setBounds(50, 60, 100, 30);
        button2.setBounds(180, 60, 100, 30);
				getContentPane().setLayout(null);
        getContentPane().add(button1);
        getContentPane().add(button2);

				button1.addActionListener(this);
				button2.addActionListener(this);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
		public void actionPerformed(ActionEvent e){
				System.out.println("Oui!");
		}
    public static void main(String[] args) {
        Example ex = new Example();
        ex.setVisible(true);
    }
}