package sundry.snackGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SnackGameGUI extends JFrame {

	private JPanel mainCardPanel;
	private CardLayout mainCardLayout;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnackGameGUI frame = new SnackGameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SnackGameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		//카드레이아웃을 사용하는 패널 생성
		mainCardLayout = new CardLayout();
		mainCardPanel = new JPanel();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);
		
		//게임 선택 패널 생성
		JPanel selectGamePanel = new JPanel();
		mainCardPanel.add(selectGamePanel, "selectGamePanel");
		selectGamePanel.setLayout(null);
		
		JButton selectSnackGameButton = new JButton("Snack Game");
		selectSnackGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		selectSnackGameButton.setBounds(12, 86, 166, 35);
		selectGamePanel.add(selectSnackGameButton);
		
		
	}
}
