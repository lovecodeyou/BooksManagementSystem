package top.linruchang.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import top.linruchang.modal.Book;
import top.linruchang.modal.BookType;
import top.linruchang.service.BookService;
import top.linruchang.service.BookTypeService;
import top.linruchang.util.StringUtil;

public class BookInternalView extends JInternalFrame {
	private JTextField bookIdText;
	private JTextField bookNameText;
	private JTextField bookPriceText;
	private JTextField bookAuthorText;
	private JTextField bookTypeText;
	private JTextArea bookDescText;
	private JComboBox TypeNamesBox;

	private List<BookType> types;

	private BookTypeService bts = new BookTypeService();
	
	private BookService bs = new BookService();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInternalView frame = new BookInternalView();
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
	public BookInternalView() {
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setResizable(true);
		setIconifiable(true);
		setBounds(100, 100, 604, 437);

		JLabel lblNewLabel = new JLabel("\u56FE\u4E66ID\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));

		bookIdText = new JTextField();
		bookIdText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u4E66\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 13));

		bookNameText = new JTextField();
		bookNameText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u4EF7\u683C");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 13));

		bookPriceText = new JTextField();
		bookPriceText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 13));

		bookAuthorText = new JTextField();
		bookAuthorText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u7C7B\u522BID\uFF1A");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 13));

		bookTypeText = new JTextField();
		
		// 填写图书类别ID
		bookTypeText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String typeId =  bookTypeText.getText();
				
				if(StringUtil.isEmpty(typeId)) {
					return;
				}else {
					
					for(BookType bt :  types) {
						if( typeId.equals(bt.getId().toString())) {
							TypeNamesBox.setSelectedItem(bt.getBookTypeName().toString());
							return;
						}
					}
					bookTypeText.setText("");
					JOptionPane.showMessageDialog(null, "数据库不存在该图书类型");
					
				}
				
			}
		});
		
		
		bookTypeText.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 13));

		bookDescText = new JTextArea();
		bookDescText.setRows(10);
		bookDescText.setColumns(10);

		bookDescText.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		JButton addBtn = new JButton("\u6DFB\u52A0\u56FE\u4E66\u4FE1\u606F");

		// 1. 图书添加按钮 点击事件的处理
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String bookId = bookIdText.getText();
				String bookName = bookNameText.getText();
				String bookPrice = bookPriceText.getText();
				String bookAuthor = bookAuthorText.getText();
				String bookType = bookTypeText.getText();
				String bookDesc = bookDescText.getText();

				if (StringUtil.isEmpty(bookId)) {
					JOptionPane.showMessageDialog(null, "图书的ID号不能为空");
				} else {

					Book book = new Book(Integer.valueOf(bookId), bookName, Double.parseDouble(bookPrice), bookAuthor,
							bookDesc, Integer.valueOf(bookType), null);
					
					int result = bs.add(book);
					
					if(result != 0) {
						JOptionPane.showMessageDialog(null, "添加成功");
					}else {
						JOptionPane.showMessageDialog(null, "添加失败，请检查一下你添加的内容");
					}
					
				}

			}
		});

		addBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addBtn.setIcon(new ImageIcon(BookInternalView.class.getResource("/img/\u6DFB\u52A0.png")));

		JButton resetBtn = new JButton("\u91CD\u7F6E\u4FE1\u606F");

		// 重置按钮点击的的处理事件
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bookIdText.setText("");
				;
				bookNameText.setText("");
				;
				bookPriceText.setText("");
				;
				bookTypeText.setText("");
				;
				bookAuthorText.setText("");
				;
				bookDescText.setText("");
				;

			}
		});
		resetBtn.setIcon(new ImageIcon(BookInternalView.class.getResource("/img/\u91CD\u7F6E.png")));
		resetBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));

		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\uFF1A");
		label.setFont(new Font("微软雅黑", Font.BOLD, 13));

		TypeNamesBox = new JComboBox();
		TypeNamesBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String selectedTypeName = (String) TypeNamesBox.getSelectedItem();

//				System.out.println(selectedTypeName);

				for (BookType bt : types) {
					if (selectedTypeName.equals(bt.getBookTypeName())) {
						bookTypeText.setText(bt.getId().toString());
						System.out.println(bt.getBookTypeName());
					}
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup().addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel).addComponent(lblNewLabel_2).addComponent(label))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup().addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(bookPriceText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108,
												Short.MAX_VALUE)
										.addComponent(bookTypeText, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addComponent(bookIdText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108,
												Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup().addGap(20)
										.addComponent(TypeNamesBox, GroupLayout.PREFERRED_SIZE, 115,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(addBtn)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(37)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_3).addComponent(lblNewLabel_5))
								.addGap(50)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(bookDescText, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
										.addComponent(bookAuthorText, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
										.addComponent(bookNameText, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
								.addGap(81))
						.addGroup(groupLayout.createSequentialGroup().addGap(85).addComponent(resetBtn)
								.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(23)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1).addComponent(bookNameText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(68)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(bookPriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(63).addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
										.addComponent(bookAuthorText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGap(94)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_4).addGap(33)
								.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(bookTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(29).addComponent(TypeNamesBox, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_5)
						.addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(resetBtn)
						.addComponent(addBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(20)));
		getContentPane().setLayout(groupLayout);

		initComboBox_typeName();
	}

	/**
	 * 
	 * @Description 初始化 typeName -- combobox的数据
	 */

	private void initComboBox_typeName() {

		types = bts.query(new BookType());

		for (BookType bt : types) {
			TypeNamesBox.addItem(bt.getBookTypeName());
		}

	}

}
