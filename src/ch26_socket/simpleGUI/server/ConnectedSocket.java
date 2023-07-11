package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import ch26_socket.simpleGUI.server.dto.SendMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {

	private final Socket socket;
	
	@Override
	public void run() {
		
		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				
				requestController(requestBody);

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void requestController(String requestBody) {
		Gson gson = new Gson();
		RequestBodyDto<?> requestBodyDto = gson.fromJson(requestBody, RequestBodyDto.class);
		
		switch (requestBodyDto.getResource()) {
			case "SendMessage" : 
				SendMessage sendMessage = (SendMessage) requestBodyDto.getBody();
				
				if(Objects.isNull(sendMessage.getToUsername())) {                  //isNull: 모두에게 전송
					SimpleGUIServer.connectedSocketList.forEach(con -> {
						RequestBodyDto<String> showMessageDto = 
								new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + ": " + sendMessage.getMessageBody());
						ServerSender.getInstance().send(con.socket, showMessageDto);    
					});
				}
//				ServerSender.getInstance().send(socket, null);     	한명 지정하여 전송
				break;

		}
		
	}
}
