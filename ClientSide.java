//ClientSide class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class ClientSide {
	Socket socket;
	public static PrintWriter out;
	public static BufferedReader in;

	public static String username ="";

	public ClientSide(){
		new ClientGUI();

		try {
			socket = new Socket("localhost", 5006);
			out = new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
			String message = in.readLine();
			ClientGUI.writeToChat(message);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[]args){
		username = JOptionPane.showInputDialog("Ka tevi sauc?");
		new ClientSide();
	}

}
