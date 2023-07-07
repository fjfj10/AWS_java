package ch25_gui;

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
import java.awt.CardLayout;

public class GUIMain1 extends JFrame {
	
	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234";

	private JPanel MainPanel;
	private CardLayout mainCardLayout;
	private JTextField UsernameTextField;
	private JPasswordField PasswordTextField;
	private JPanel homepanel;

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
	public GUIMain1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);                                //(좌표, 좌표, 가로, 세로) 0,0 = 왼쪽 위  
				/*<<MainPanel>>*/
		MainPanel = new JPanel();                                   // 객체생성
		mainCardLayout = new CardLayout(0, 0);
		
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));           
		MainPanel.setLayout(mainCardLayout);
		
		setContentPane(MainPanel);

				/*<<LoginPanel>>*/
		JPanel Loginpanel = new JPanel();
		MainPanel.add(Loginpanel, "Loginpanel");
		Loginpanel.setLayout(null);
							
		UsernameTextField = new JTextField();
		UsernameTextField.setBounds(73, 78, 287, 33);
		Loginpanel.add(UsernameTextField);
		UsernameTextField.setColumns(10);
				
		PasswordTextField = new JPasswordField();
		PasswordTextField.setBounds(73, 121, 287, 33);
		Loginpanel.add(PasswordTextField);
		PasswordTextField.setColumns(10);
		
		JButton SigninButton = new JButton("Login");
		SigninButton.setBounds(73, 189, 287, 33);
		Loginpanel.add(SigninButton);
		
		SigninButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = UsernameTextField.getText();
				String password = PasswordTextField.getText();
				if(!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) {
//					                                대상                     내용                     제목             아이콘 
					JOptionPane.showMessageDialog(MainPanel, "사용자 정보가 일치하지 않습니다", "로그인 실패", JOptionPane.ERROR_MESSAGE);
//					System.out.println("사용자 정보가 일치하지 않습니다.");
					return;
				}
				JOptionPane.showMessageDialog(MainPanel, "환영합니다", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
//				System.out.println("로그인 성공");
				mainCardLayout.show(MainPanel, "homepanel");
			}
		});
		
//		<<SubLoginPanel>>
		homepanel = new JPanel();
		MainPanel.add(homepanel, "homepanel");
		homepanel.setLayout(null);
		
		JButton btnNewButton = new JButton("로그인 성공");
		btnNewButton.setBounds(97, 105, 236, 23);
		homepanel.add(btnNewButton);
		
		
		
	}
}
