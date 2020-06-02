package top.linruchang.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import top.linruchang.modal.Book;
import top.linruchang.modal.BookType;
import top.linruchang.service.BookService;
import top.linruchang.service.BookTypeService;
import top.linruchang.util.StringUtil;

public class BookUpdateView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField bookIdText;
	private JTextField bookNameText;
	private JTextField bookAuthorText;
	private JTextField bookPriceText;
	private JTextArea bookDescText;
	private JComboBox<String> typeNameBox;
	
	BookService bs = new BookService();
	
	BookTypeService bts = new BookTypeService();
	private List<BookType> bookTypes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BookUpdateView dialog = new BookUpdateView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BookUpdateView() {
		setBounds(100, 100, 509, 469);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));

		bookIdText = new JTextField();
		bookIdText.setEditable(false);
		bookIdText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u4E66\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));

		bookNameText = new JTextField();
		bookNameText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 14));

		bookAuthorText = new JTextField();
		bookAuthorText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u4EF7\u683C\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 14));

		bookPriceText = new JTextField();
		bookPriceText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u6982\u8FF0\uFF1A");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 14));

		JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 14));

		typeNameBox = new JComboBox();

		JButton updateBtn = new JButton("\u66F4\u65B0");
		
		// 更新按钮事件处理 -- 提交到数据库
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 更新按钮
				
				String id = bookIdText.getText();
				String bookName =  bookNameText.getText();
				String bookAuthor =	bookAuthorText.getText();
				String	bookPrice  = bookPriceText.getText();
				String	bookDesc  =	bookDescText.getText();
				String bookTypeName = (String)typeNameBox.getSelectedItem();
				Integer bookTypeId = null;
				
				for(BookType bt: bookTypes) {
					if (bookTypeName.equals(bt.getBookTypeName())) {
						bookTypeId = bt.getId();
					}
				}
				Book book = new Book(Integer.valueOf(id), bookName, Double.parseDouble(bookPrice), bookAuthor, bookDesc, bookTypeId, null);
				
				int result = bs.update(book);
				
				if(result > 0) {
					JOptionPane.showMessageDialog(null, "更新成功");
				}else {
					JOptionPane.showMessageDialog(null, "更新失败，可能有些值不符合要求，或者数据库中不存在该id数据");
				}
				
			}
		});
		updateBtn.setFont(new Font("微软雅黑", Font.BOLD, 15));
		updateBtn.setIcon(new ImageIcon(BookUpdateView.class.getResource("/img/\u4FEE\u6539.png")));

		JButton resetBtn = new JButton("\u91CD\u7F6E");

		// 重置按钮 -- 点击事件处理
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bookNameText.setText("");
				bookAuthorText.setText("");
				bookPriceText.setText("");
				bookDescText.setText("");

			}
		});
		resetBtn.setFont(new Font("微软雅黑", Font.BOLD, 15));
		resetBtn.setIcon(new ImageIcon(BookUpdateView.class.getResource("/img/\u91CD\u7F6E.png")));

		bookDescText = new JTextArea();
		bookDescText.setRows(8);
		bookDescText.setColumns(5);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(24).addGroup(gl_contentPanel
								.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_4).addComponent(lblNewLabel_2))
										.addGap(18)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(bookDescText, GroupLayout.DEFAULT_SIZE, 97,
														Short.MAX_VALUE)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGroup(gl_contentPanel
																.createParallelGroup(Alignment.TRAILING)
																.addComponent(bookIdText, GroupLayout.PREFERRED_SIZE,
																		95, GroupLayout.PREFERRED_SIZE)
																.addComponent(bookAuthorText,
																		GroupLayout.PREFERRED_SIZE, 97,
																		GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED))))))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(118).addComponent(updateBtn)))
						.addGap(38)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel
												.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_5)
												.addComponent(lblNewLabel_3).addComponent(lblNewLabel_1))
										.addGap(18)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(bookNameText, GroupLayout.DEFAULT_SIZE, 113,
														Short.MAX_VALUE)
												.addComponent(bookPriceText, GroupLayout.DEFAULT_SIZE, 113,
														Short.MAX_VALUE)
												.addComponent(typeNameBox, 0, 113, Short.MAX_VALUE))
										.addContainerGap(35, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup().addComponent(resetBtn)
										.addContainerGap()))));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(21)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(bookIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(59)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(bookAuthorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3).addComponent(bookPriceText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(69)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(typeNameBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 110,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE).addGroup(gl_contentPanel
								.createParallelGroup(Alignment.BASELINE).addComponent(updateBtn).addComponent(resetBtn))
						.addGap(36)));
		contentPanel.setLayout(gl_contentPanel);

		// 设置文本域的边框颜色
		bookDescText.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		loadComboBox();
	}

	private void loadComboBox() {
		bookTypes = bts.query(new BookType());
		
		
		if (bookTypes != null) {

			for (BookType bt : bookTypes) {
				String typeName = bt.getBookTypeName();
				if(!StringUtil.isEmpty(typeName))
					typeNameBox.addItem(typeName);
			}
		}

	}

	public void load(Book book) {
//		private JTextField bookIdText;
//		private JTextField bookNameText;
//		private JTextField bookAuthorText;
//		private JTextField bookPriceText;
//		private JTextArea bookDescText;
//		private JComboBox typeNameBox;

		bookIdText.setText(book.getId().toString());

		bookNameText.setText(book.getBookName());

		bookAuthorText.setText(book.getAuthor());

		bookPriceText.setText(String.valueOf(book.getPrice()));

		bookDescText.setText(book.getBookDesc());
		
		
		String typeName = book.getBookTypeName();
		
		for(int i = 0; i < typeNameBox.getItemCount(); i++) {
			if(typeNameBox.getItemAt(i).equals(typeName)) {
				typeNameBox.setSelectedIndex(i);
			}
		}
		
	}

}
