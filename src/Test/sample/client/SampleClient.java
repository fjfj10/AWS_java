package Test.sample.client;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ch26_socket.simpleGUI.client.SimpleGUIClient;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SampleClient extends JFrame {
	
	private static SampleClient instance;
	public static SampleClient getInstance() {
		if(instance == null) {
			instance = new SampleClient();
		}
		return instance;
	}

	private String username;
	private Socket socket;
		
	private CardLayout mainCardLayout;
	private JPanel mainCardPanel;
	
	private JPanel chattingRoomListPanel;
	
	
	private JPanel chattingRoomPanel;
	
	
	private JTextField messageTextField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SampleClient frame = SampleClient.getInstance();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SampleClient() {
		/*<<Client socket 생성>>*/
		username = JOptionPane.showInputDialog(chattingRoomPanel, "ID를 입력하세요");	
		
		if(Objects.isNull(username)) {
			System.exit(0);
		}
		if(username.isBlank()) {
			System.exit(0);
		}		
		try {
				socket = new Socket("127.0.0.1", 8000);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 546);
		
		/*<<mainCardPanel 생성>>*/
		mainCardLayout = new CardLayout();
		mainCardPanel = new JPanel();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);

		/*chattingRoomListPanel 생성*/
		chattingRoomListPanel = new JPanel();
		chattingRoomListPanel.setLayout(null);
		chattingRoomListPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainCardPanel.add(chattingRoomListPanel, "chattingRoomListPanel");
		/*방만들기 버튼 생성*/
		JButton createRoomButton = new JButton("방만들기");
		createRoomButton.setBounds(12, 10, 246, 47);
		chattingRoomListPanel.add(createRoomButton);
		
		JScrollPane roomListScrollPanel = new JScrollPane();
		roomListScrollPanel.setBounds(12, 83, 791, 405);
		chattingRoomListPanel.add(roomListScrollPanel);
		
		JList roomList = new JList();
		roomListScrollPanel.setViewportView(roomList);
		
		JPanel chattingRoomPanel = new JPanel();
		mainCardPanel.add(chattingRoomPanel, "chattingRoomPanel");
		chattingRoomPanel.setLayout(null);
		
		JScrollPane chattingTextAreaScrollPanel = new JScrollPane();
		chattingTextAreaScrollPanel.setBounds(12, 10, 608, 386);
		chattingRoomPanel.add(chattingTextAreaScrollPanel);
		
		JTextArea chattingTextArea = new JTextArea();
		chattingTextAreaScrollPanel.setViewportView(chattingTextArea);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 406, 102, 54);
		chattingRoomPanel.add(lblNewLabel);
		
		messageTextField = new JTextField();
		messageTextField.setBounds(116, 410, 687, 54);
		chattingRoomPanel.add(messageTextField);
		messageTextField.setColumns(10);
		
		JButton exitButton = new JButton("나가기");
		exitButton.setBounds(632, 12, 171, 45);
		chattingRoomPanel.add(exitButton);
		
		JScrollPane userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(632, 67, 171, 329);
		chattingRoomPanel.add(userListScrollPane);
		
		JList userList = new JList();
		userListScrollPane.setViewportView(userList);
	}
}
