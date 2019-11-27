package tryouts;

import javax.swing.*;

public class swing {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(300, 300);
		JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        window.getContentPane().add(button1);
        window.getContentPane().add(button2);
        window.setVisible(true);
	}

}
