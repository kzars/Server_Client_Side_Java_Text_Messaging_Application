import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ClientGUI extends JFrame{
	private static final long serialVersionUID = 1L;

	static int WIDTH=640;
	static int HEIGHT = WIDTH/16*9;
	static final JTextField textField = new JTextField();
	static final JButton button = new JButton("Sutit zinu");
	static final JPanel panel = new JPanel();
	static final JTextArea textarea = new JTextArea();
	static final JScrollPane scroll = new JScrollPane(textarea);

//Simple GUI for chat user
	public ClientGUI(){
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setSize(WIDTH,HEIGHT);
		this.setResizable(false);
		scroll.setPreferredSize(new Dimension(WIDTH -32, HEIGHT -100));
		textField.setPreferredSize(new Dimension (WIDTH -32, 32));

		panel.add(textField);
		panel.add(button);
		this.add(panel);
		panel.add(scroll);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = textField.getText();
				ClientSide.out.println(ClientSide.username + ":" + text);
				textField.setText("");

			}
		});

	}

	public static void writeToChat(String text){
		textarea.append(text+"\n");
	}

}
