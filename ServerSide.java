import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSide {

	ServerSocket sSocket;
	Socket socket;

	PrintWriter out;
	BufferedReader in;

	static Terminal terminal;

	static ArrayList<User> users = new ArrayList<User>();

	public ServerSide(){
		try{
			sSocket = new ServerSocket(5006);

			new Thread(new Runnable(){

				@Override
				public void run() {
					while(true){
						try{
							socket =  sSocket.accept();
							out = new PrintWriter(socket.getOutputStream(),true);
							in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

							users.add(new User(out,in));
							new Thread(new Runnable(){

								@Override
								public void run() {
									PrintWriter o = out;
									BufferedReader i = in;

									o.println("Sveiks!");
									while(true){
										try {
											String text = i.readLine();
											broadcast(text);
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								}
							}).start();
						} catch(IOException e){
							e.printStackTrace();
						}
					}
				}

			}).start();


		} catch(IOException e){
			e.printStackTrace();
		}

		terminal = new Terminal();
	}

	public static void broadcast(String text){
		for(int i=0; i < users.size(); i++){
			User user = users.get(i);
			if(user == null || user.out ==null){
				users.remove(user);
			}
			user.out.println(text);
		}
	}
	public static void main(String[]args){
		new ServerSide();
		terminal.writeToTerminal("Servera puse darbojas");
	}
}
