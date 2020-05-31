//Terminal class

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Terminal {
	static final JFrame frame = new JFrame("Server Terminal");
	static final JPanel panel = new JPanel();

	public static final JTextArea textarea = new JTextArea();
	public static final JScrollPane scroll = new JScrollPane(textarea);

	static final int WIDTH = 640;
	static final int HEIGHT =300;

//Simple GUI interface
	public Terminal(){
		frame.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scroll.setPreferredSize(new Dimension(WIDTH-32,HEIGHT-64));
		textarea.setEditable(false);
		panel.add(scroll);
		frame.add(panel);
	}

	public void writeToTerminal(String text){
		textarea.append(text +"\n");
	}

}
