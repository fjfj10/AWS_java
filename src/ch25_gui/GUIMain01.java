package ch25_gui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//수업내용
public class GUIMain01 extends JFrame {
	
	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234";

	private CardLayout mainCardLayout;
	
	private JPanel mainCardPanel;
	private JPanel LoginPanel;	
	private JPanel homePanel;	
	private JTextField usernameTextField;
	private JPasswordField PasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain1 frame = new GUIMain1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
//	생성자
	public GUIMain01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);                                //(좌표, 좌표, 가로, 세로) 0,0 = 왼쪽 위  
		mainCardPanel = new JPanel();
		mainCardLayout = new CardLayout();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);
				
		LoginPanel = new JPanel();                                   // 객체생성
		LoginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));           
		LoginPanel.setLayout(null);
		mainCardPanel.add(LoginPanel, "LoginPanel");
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(124, 61, 196, 37);
		LoginPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		PasswordTextField = new JPasswordField();
		PasswordTextField.setBounds(124, 108, 196, 37);
		LoginPanel.add(PasswordTextField);
		PasswordTextField.setColumns(10);
		
		JButton signinBtn = new JButton("Login");
		signinBtn.addMouseListener(new MouseAdapter() {       
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = usernameTextField.getText();
				String password = PasswordTextField.getText();
				if(!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) {
//					                                대상                     내용                     제목             아이콘 
					JOptionPane.showMessageDialog(LoginPanel, "사용자 정보가 일치하지 않습니다", "로그인 실패", JOptionPane.ERROR_MESSAGE);
//					System.out.println("사용자 정보가 일치하지 않습니다.");
					return;
				}
				JOptionPane.showMessageDialog(LoginPanel, "환영합니다", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				mainCardLayout.show(mainCardPanel, "homePanel");
			}
		});
		signinBtn.setBounds(124, 189, 196, 37);
		LoginPanel.add(signinBtn);
		
		homePanel = new JPanel();
		homePanel.setLayout(null);
		mainCardPanel.add(homePanel, "homePanel");
		
	}
}