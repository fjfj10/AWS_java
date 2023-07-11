package ch26_socket.simpleGUI.client;

import java.io.IOException;
import java.io.PrintWriter;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;

public class ClientSender {
	
	private static ClientSender instance;
	private ClientSender() {}
	public static ClientSender getInstance() {
		if(instance == null) {
			instance = new ClientSender();
		}
		return instance;
	}
	
	public void send(RequestBodyDto<?> requestBodyDto) {
		try {
			PrintWriter printWriter = new PrintWriter(SimpleGUIClient.getInstance().getSocket().getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
