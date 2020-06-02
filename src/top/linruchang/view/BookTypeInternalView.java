package top.linruchang.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import top.linruchang.modal.BookType;
import top.linruchang.service.BookTypeService;
import top.linruchang.util.StringUtil;

public class BookTypeInternalView extends JInternalFrame {
	
	
	BookTypeService bts = new BookTypeService();
	
	private JTextField TypeIDText;
	private JTextField TypeNameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeInternalView frame = new BookTypeInternalView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		new BookTypeInternalView();
		
	}

	/**
	 * Create the frame.
	 */
	public BookTypeInternalView() {
		try {
			setIcon(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 605, 437);
		
		JLabel lblNewLabel = new JLabel("\u7C7B\u522BID\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		TypeIDText = new JTextField();
		TypeIDText.setColumns(10);
		
		TypeNameText = new JTextField();
		TypeNameText.setColumns(10);
		
		JTextArea TypeDescText = new JTextArea();
		TypeDescText.setWrapStyleWord(true);
		TypeDescText.setToolTipText("\u586B\u5199\u7C7B\u522B\u7684\u63CF\u8FF0\r\n");
		TypeDescText.setColumns(30);
		TypeDescText.setRows(10);
		
		//TODO 美化文本域边框
		TypeDescText.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setIcon(new ImageIcon(BookTypeInternalView.class.getResource("/img/\u6DFB\u52A0.png")));
		
		
		// 图书类别增加窗口 -- 添加数据
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = TypeIDText.getText();
				String name = TypeNameText.getText();
				String desc = TypeDescText.getText();
				
				
				if( StringUtil.isEmpty(id.toString()) || StringUtil.isEmpty(name)) {
					
					
					JOptionPane.showMessageDialog(null, "图书类别ID、以及图书类别名不能为空");
					return;
				}else {
					
					Integer typeId = Integer.valueOf(TypeIDText.getText());
					
					BookType bt = new BookType(typeId, name, desc);
					int result = bts.add(bt);
					
					if(result == 0) {
						JOptionPane.showMessageDialog(null, "不能成功添加，可能存在同样的图书类别ID号");
					}else {
						JOptionPane.showMessageDialog(null, "添加成功");
					}
					
				}
				
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(BookTypeInternalView.class.getResource("/img/\u91CD\u7F6E.png")));
		
		// 图书类别增加窗口 -- 文本框重置
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TypeIDText.setText("");
				TypeNameText.setText("");
				TypeDescText.setText("");
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(TypeDescText, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(TypeIDText, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
							.addComponent(TypeNameText)))
					.addContainerGap(169, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(113)
					.addComponent(btnNewButton)
					.addGap(154)
					.addComponent(btnNewButton_1)
					.addContainerGap(208, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(TypeIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(TypeNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(TypeDescText, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(42))
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
