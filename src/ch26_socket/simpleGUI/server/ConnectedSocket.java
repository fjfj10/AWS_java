package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
//				System.out.println(requestBody);
				SimpleGUIServer.connectedSocketList.forEach(ConnectedSocket -> {
					try {
						PrintWriter printWriter = new PrintWriter(ConnectedSocket.socket.getOutputStream(), true);
						printWriter.println(requestBody);
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				});          //람다식
//				for(ConnectedSocket connectedSocket : SimpleGUIServer.connectedSocketList) {
//					
//				}
//				//향상된 for문
//				for(int i = 0; i < SimpleGUIServer.connectedSocketList.size(); i++) {
//					
//				}
//				//기본 반복문, 위 세 반복문은 같다 
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
