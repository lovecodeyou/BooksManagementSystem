package top.linruchang.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import top.linruchang.modal.User;
import top.linruchang.service.UserService;
import top.linruchang.util.StringUtil;

public class LoginView extends JFrame {
	
	UserService us = new UserService();
	
	private JPanel contentPane;
	private final JTextField textField = new JTextField();
	private JTextField userNameText;
	private JPasswordField passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		
		setTitle("\u56FE\u4E66\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/img/\u56FE\u4E66.png")));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u6237\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/img/\u7528\u6237\u540D.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel label = new JLabel("\u5BC6 \u7801\uFF1A");
		label.setIcon(new ImageIcon(LoginView.class.getResource("/img/\u5BC6\u7801.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		
		userNameText = new JTextField();
		userNameText.setColumns(10);
		
		passwordText = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginPerformed(e);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginView.class.getResource("/img/\u767B\u5F55.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 15));
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetPerformed(e);
			}

		});
		button.setIcon(new ImageIcon(LoginView.class.getResource("/img/\u91CD\u7F6E.png")));
		button.setFont(new Font("宋体", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(80)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(label))))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordText, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
								.addComponent(userNameText, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(117)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addComponent(button)
							.addGap(38)))
					.addGap(116))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(userNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		// 登录窗口居中显示
		this.setLocationRelativeTo(null);
		
	}
	
	
	/**
	 * 
	 * @Description 登录账户
	 * @param e
	 */
	protected void loginPerformed(ActionEvent e) {
		
		String userName = userNameText.getText();
		String password = new String(passwordText.getPassword());
		
		if(StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "用户名、密码不能为空");
			return;
		}
		
		User user = new User(userName, password);
		
		User getUser = us.login(user);
		
		if(getUser != null) {
//			JOptionPane.showMessageDialog(null, "登录成功");
			this.dispose();
			new MainView().setVisible(true);;
			
		}else {
			JOptionPane.showMessageDialog(null, "用户名、密码错误，请重新输入");
			resetPerformed(e);
		}
		
	}
	
	/**
	 * 
	 * @Description 将账户、密码输入框置空
	 * @param e
	 */
	protected void resetPerformed(ActionEvent e) {
		userNameText.setText("");
		passwordText.setText("");
	}
}
