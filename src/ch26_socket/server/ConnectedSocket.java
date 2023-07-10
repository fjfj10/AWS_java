package ch26_socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread{

	private final Socket socket;  //final을 붙이면 상수취급 final을 붙인 변수만 RequiredArgsConstructor 적용가능(매개변수가 자동으로 잡힘.)
	
	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		
		try {
			while (true) {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				System.out.println("입력데이터: " + requestBody);
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
