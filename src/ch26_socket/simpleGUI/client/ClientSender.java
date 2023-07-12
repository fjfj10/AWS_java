package ch26_socket.simpleGUI.client;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;

public class ClientSender {
	
	private Gson gson;
	
	private static ClientSender instance;
	
	private ClientSender() {
		gson = new Gson();
	}
	
	public static ClientSender getInstance() {
		if(instance == null) {
			instance = new ClientSender();
		}
		return instance;
	}
	
	public void send(RequestBodyDto<?> requestBodyDto) {
		try {
			PrintWriter printWriter = new PrintWriter(SimpleGUIClient.getInstance().getSocket().getOutputStream(), true);
			printWriter.println(gson.toJson(requestBodyDto));
			//print로는 전송이 안된다. -> buffer에 다 채우지 못했기 때문
			//println은 엔터를 기준으로 플러싱? 시킴 buffer에 다 채우지 않아도 전송 가능
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
