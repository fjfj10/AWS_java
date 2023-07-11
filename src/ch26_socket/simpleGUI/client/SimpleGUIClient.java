 package ch26_socket.simpleGUI.client;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;
import lombok.Getter;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class SimpleGUIClient extends JFrame {
	//싱글톤 쓴이유 : ClientReceiver에서 SimpleGUIClient안의 메소드들을 사용하고 싶어서
	private static SimpleGUIClient instance;
	public static SimpleGUIClient getInstance() {
		if(instance == null) {
			instance = new SimpleGUIClient();
		}
		return instance;
	}
	
	
	private String username;
	private Socket socket;

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	
	private JScrollPane userListScrollPane;
	private DefaultListModel<String> userListModel;
	private JList userList;
	
	

	/*GUIClient 생성*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUIClient frame = SimpleGUIClient.getInstance();
					frame.setVisible(true);
					
					ClientReceiver clientReceiver = new ClientReceiver();
					clientReceiver.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SimpleGUIClient() {
		
		username = JOptionPane.showInputDialog(contentPane, "ID를 입력하세요");							
		
		if(Objects.isNull(username)) {
			System.exit(0);
		}
		if(username.isBlank()) {
			System.exit(0);
		}
		try {
			socket = new Socket("127.0.0.1", 8000);          //127.0.0.1은 로컬주소의 변수 같은거 자신의 주소를 불러옴
			RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", username); 
			ClientSender.getInstance().send(requestBodyDto);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		/*<<Text 입력과 출력(Client간의 대화 표시)부분>>*/
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 298, 188);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					                     
					SendMessage sendmessage = SendMessage.builder().fromUsername(username).messageBody(textField.getText()).build();
					
					RequestBodyDto<SendMessage> requestBodyDto = new RequestBodyDto<>("SendMessage", sendmessage);
					
					ClientSender.getInstance().send(requestBodyDto);
					textField.setText("");
				}
			}
		});
		textField.setBounds(12, 208, 410, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		/*<<접속자 목록 표시>>*/
		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(322, 10, 100, 188);
		contentPane.add(userListScrollPane);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userListScrollPane.setViewportView(userList);
		
	}
}
