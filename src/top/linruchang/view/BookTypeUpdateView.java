package top.linruchang.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import top.linruchang.modal.BookType;
import top.linruchang.service.BookTypeService;
import javax.swing.ImageIcon;

public class BookTypeUpdateView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField typeIDText;
	private JTextField typeNameText;
	private JTextArea typeDescText ;
	
	BookTypeService bts = new BookTypeService();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BookTypeUpdateView dialog = new BookTypeUpdateView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BookTypeUpdateView() {
		setTitle("\u9009\u4E2D\u7684\u6570\u636E");
		setBounds(100, 100, 536, 369);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522BID\uFF1A");
			lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		}
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
		typeDescText = new JTextArea();
		
		typeDescText.setBorder(BorderFactory.createLineBorder(Color.gray));
		typeDescText.setRows(10);
		typeDescText.setColumns(10);
		typeIDText = new JTextField();
		typeIDText.setEditable(false);
		typeIDText.setColumns(10);
		typeNameText = new JTextField();
		typeNameText.setColumns(10);
		
		JButton button = new JButton("\u66F4\u65B0\u6570\u636E");
		button.setIcon(new ImageIcon(BookTypeUpdateView.class.getResource("/img/\u4FEE\u6539.png")));
		
		
		// 图书类别的更新
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = typeIDText.getText();
				String typeName = typeNameText.getText();
				String typeDesc = typeDescText.getText();
				
				BookType bt = new BookType(Integer.valueOf(id), typeName, typeDesc);
				
				System.out.println(bt);
				
				int result = bts.update(bt);
				
				
				if(result == 0) {
					JOptionPane.showMessageDialog(null, "更新失败，可能数据库并不存在该图书类型ID号");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "更新成功");
					dispose();
				}
				
			}
		});
		button.setFont(new Font("微软雅黑", Font.BOLD, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(76)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(100)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(typeIDText)
								.addComponent(typeDescText, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(typeNameText)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(184)
							.addComponent(button)))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(typeIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(typeNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(typeDescText, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(32))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	
	public void init(Integer id, String typeName, String typeDesc) {
		
		typeIDText.setText(id.toString());
		typeNameText.setText(typeName);
		typeDescText.setText(typeDesc); ;
		
	}
	

}
