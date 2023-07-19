package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import ch26_socket.simpleGUI.server.dto.SendMessage;
import ch26_socket.simpleGUI.server.entity.Room;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {

	private final Socket socket;
	private Gson gson;
	
	private String username;
	
	@Override
	public void run() {
		gson = new Gson();
		
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
		
		String resorce = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch (resorce) {
			case "connection" : 
					connection(requestBody);
				break;
			
			case "createRoom":
				createRoom(requestBody);
				break;
		
			case "join" : 
				join(requestBody);
				break;
								
			case "SendMessage" :
				sendMessage(requestBody);			
				break;
		}		
	}
	
	private void connection(String requestBody) {
		username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();	
		//아래가 없으면 새로 접속하는 사람은 방 리스트를 못받는다
		List<String> roomNameList = new ArrayList<>();
		
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto = new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		ServerSender.getInstance().send(socket, updateRoomListRequestBodyDto);
	}
	
	private void createRoom(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();		
		
		Room newRoom = Room.builder()
				.roomName(roomName)
				.owner(username)
				.userList(new ArrayList<ConnectedSocket>())
				.build();
		
		SimpleGUIServer.roomList.add(newRoom);
		
		List<String> roomNameList = new ArrayList<>();
		
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto = new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		SimpleGUIServer.connectedSocketList.forEach(con -> {
			ServerSender.getInstance().send(con.socket, updateRoomListRequestBodyDto);
		});
		
	}
	
	private void join(String requestBody) {
		//room중에서 내가 들어가고자 하는 roomName을 찾는다
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		SimpleGUIServer.roomList.forEach(room -> {
			//룸이름이 같은곳의 list에 본인을 포함 시킨다
			if(room.getRoomName().equals(roomName)) {
				room.getUserList().add(this);
				
				List<String> usernameList = new ArrayList<>();
				
				room.getUserList().forEach(con -> {
					usernameList.add(con.username);
				});
				
				room.getUserList().forEach(connectedSocket -> {					
					RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 들어왔습니다.");
					
					ServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);
				});				
			}
		});				
	}
	
	private void sendMessage(String requestBody) {
		TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<RequestBodyDto<SendMessage>>() {};
		//SendMessage을 제네릭으로 사용했기 때문에 TypeToken를 사용하여 SendMessage객체로 정의?
		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
		SendMessage sendMessage = requestBodyDto.getBody();            //SendMessage객체로 변환
		
		SimpleGUIServer.roomList.forEach(room -> {
			//만약 room의 getUserList에 this(= connectedsocket)이 들어있다면 
			if(room.getUserList().contains(this)) {
				//방안의 UserList에 들어있는 con(= connectedsocket)에게 showMessage해주겠다.
				room.getUserList().forEach(con -> {
					RequestBodyDto<String> dto = new RequestBodyDto<String>("showMessage", 
							sendMessage.getFromUsername() + ": " + sendMessage.getMessageBody());
					ServerSender.getInstance().send(con.socket , dto);
				});
			}
		});
		
//		SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
//			RequestBodyDto<String> dto = new RequestBodyDto<String>("showMessage", 
//					sendMessage.getFromUsername() + ": " + sendMessage.getMessageBody());
//			ServerSender.getInstance().send(connectedSocket.socket, dto);
//		});
	}
	
}
