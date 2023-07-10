package ch26_socket.server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SeverApplication {
	
	public static ServerSocket serverSocket;
	public static int port;
	
	
	
	public static void main(String[] args) {
		
		Thread connectionThread = null;
		
		System.out.println("[서버 프로그램 실행]");
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			int slsctedManu = 0;
			System.out.println("1. 서버켜기");
			System.out.println("2. 서버끄기");
			System.out.print("선택: ");
			try {
				slsctedManu = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력가능합니다.");
				continue;
			}
		
			
			switch (slsctedManu) {
			case 1:
				if(serverSocket != null) {
					System.out.println("이미 서버가 실행중입니다.");
					break;
				}
				System.out.println("서버의 포트번호를 입력하세요");
				
				try {
					port = scanner.nextInt();
				} catch (InputMismatchException e2) {
					System.out.println("숫자만 입력가능합니다.");
					continue;
				}
//				다른 client의 접속을 기다리는 스레드 생성      
				connectionThread = new Thread(() -> {
					try {
						serverSocket = new ServerSocket(port);
						while (!Thread.interrupted()) {          //interrupted: 중간에 끼어드는거? -> case2에서 serverSocket.close();로 서버 종료가 일어날 경우 true-> !true = false가 되어 스레드 종료 
							Socket socket = serverSocket.accept();        //Client의 접속을 기다림(accept), socket은 Client와 연결된 스레드
							ConnectedSocket connectedSocket = new ConnectedSocket(socket);          //접속이 될 때마다(각각의 소켓마다) 스레드를 만들고 
							connectedSocket.start();                                                //실행시켜준다
							
							ConnectedClientController.getInstance().getConnectedSockets().add(connectedSocket);
							
							System.out.println("접속!!");
							System.out.println(socket.getInetAddress().getHostAddress());				
						}
					} catch (BindException e) {
						System.out.println("이미 사용중인 포트번호입니다.");
					} catch (SocketException e) {
						System.out.println("서버의 연결이 종료되었습니다.");
					} catch (IOException e) {
						e.printStackTrace();
					}										
				}, "connectionThread");
				
				connectionThread.start();
				
				break;
			
			case 2:
				if(serverSocket == null) {
					System.out.println("서버가 실행중이지 않습니다.");
					break;
				}
				try {
					serverSocket.close();                     //Socket 서버를 죽임 
				} catch (IOException e) {}
				
				connectionThread.interrupt();
				
				try {
					connectionThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("프로그램 종료");
				return;

			default:
				System.out.println("다시 선택하세요.");				
			}
//			connectionThread가 실행될 때까지 0.5초만 기다려 달라
			if(serverSocket == null) {
				try {
					connectionThread.join(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}