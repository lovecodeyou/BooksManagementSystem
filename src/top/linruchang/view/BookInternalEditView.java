package top.linruchang.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import top.linruchang.modal.Book;
import top.linruchang.modal.BookType;
import top.linruchang.service.BookService;
import top.linruchang.service.BookTypeService;
import top.linruchang.util.StringUtil;

public class BookInternalEditView extends JInternalFrame {
	private JTable table;
	
	private BookService bs = new BookService();
	private BookTypeService bts = new BookTypeService();
	
	private JTextField bookNameText;
	private JTextField bookAuthorText;
	private JComboBox bookTypeNameBox;
	
	
	private List<Book> lists;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInternalEditView frame = new BookInternalEditView();
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
	public BookInternalEditView() {
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u4FE1\u606F\u67E5\u8BE2\u4EE5\u53CA\u66F4\u65B0");
		setBounds(100, 100, 746, 445);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("\u641C\u7D22\u6761\u4EF6");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton updatebtn = new JButton("\u66F4\u65B0");
		
		// 数据更新窗口
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 更新按钮处理
				
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "请选择你要修改的数据行");
				}else {
					
					//TODO 选择选中行
					
					BookUpdateView dialog = new BookUpdateView();
					dialog.setVisible(true);
					
					int row = table.getSelectedRow();
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					
					String id = (String)model.getValueAt(row, 0);
					
					
					for( Book book : lists) {
						if (id.equals(book.getId().toString())) {
							dialog.load(book);
							return;
						}
					}
					
					
				}
				
				
				
			}
		});
		updatebtn.setIcon(new ImageIcon(BookInternalEditView.class.getResource("/img/\u4FEE\u6539.png")));
		updatebtn.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		JButton deleteBtn = new JButton("\u5220\u9664");
		
		// 删除按钮事件处理
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO  --- 待检查
				
				int selectedRow = table.getSelectedRow();
				
				if(selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "请选中你所要删除的行");
					return;
				}
				
				String sid = (String)table.getValueAt(selectedRow, 0);
				
				
				Book book = new Book();
				Integer bookId = Integer.valueOf(sid);
				book.setId(bookId);
				int result = bs.delete(book);
				
				if(result != 0) {
					JOptionPane.showMessageDialog(null, "删除成功");
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.removeRow(selectedRow);
					
				}else {
					JOptionPane.showMessageDialog(null, "删除失败，可能数据库中不存在该条记录");
				}
				
				
			}
		});
		deleteBtn.setIcon(new ImageIcon(BookInternalEditView.class.getResource("/img/\u5220\u9664.png")));
		deleteBtn.setFont(new Font("微软雅黑", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(168)
					.addComponent(updatebtn)
					.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
					.addComponent(deleteBtn)
					.addGap(154))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteBtn)
						.addComponent(updatebtn))
					.addGap(43))
		);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
		
		bookNameText = new JTextField();
		bookNameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 13));
		
		bookAuthorText = new JTextField();
		bookAuthorText.setColumns(10);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		label.setFont(new Font("微软雅黑", Font.BOLD, 13));
		
		bookTypeNameBox = new JComboBox();
		
		JButton searchBtn = new JButton("\u67E5\u8BE2");
		
		// 1. 查询数据，刷新表格
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				flushTable();
			}
		});
		searchBtn.setFont(new Font("微软雅黑", Font.BOLD, 15));
		searchBtn.setIcon(new ImageIcon(BookInternalEditView.class.getResource("/img/\u67E5\u8BE2.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookAuthorText, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookTypeNameBox, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(searchBtn)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookAuthorText, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(bookTypeNameBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBtn))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u4E66\u540D", "\u4F5C\u8005", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u6982\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		
		
		flushTable();
		loadComboBox();
	}
	
	/**
	 * 
	 * @Description 加载BookTypeName的数据
	 */
	private void loadComboBox() {
		List<BookType> lists = bts.query(new BookType());
		for(BookType bt : lists) {
			if( ! StringUtil.isEmpty(bt.getBookTypeName())) {
				bookTypeNameBox.addItem(bt.getBookTypeName());
			}
		}
		
	}
	
	
	/**
	 * 
	 * @Description 刷新表单数据
	 */
	private void flushTable() {
		
//		private JTextField bookNameText;
//	private JTextField bookAuthorText;
//	private JComboBox bookTypeNameBox;
		
		
		String bookName = bookNameText.getText();
		String bookAuthor = bookAuthorText.getText();
		String bookTypeName = (String)bookTypeNameBox.getSelectedItem();
		
		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthor(bookAuthor);
		book.setBookTypeName(bookTypeName);
		
		lists = bs.query(book);
		DefaultTableModel dtable = (DefaultTableModel) table.getModel();
		dtable.setRowCount(0);
		if(lists != null ) {
			for(Book book_q : lists) {
				dtable.addRow(data(book_q));
			}
		}
		
		
		
	}
	
	private Vector<String> data(Book book) {
		Vector<String> v = new Vector<String>();
		
		v.add(StringUtil.initalEmpty(book.getId()));
		v.add(StringUtil.initalEmpty(book.getBookName()));
		v.add(StringUtil.initalEmpty(book.getAuthor()));
		v.add(StringUtil.initalEmpty(book.getPrice()));
		v.add(StringUtil.initalEmpty(book.getBookDesc()));
		v.add(StringUtil.initalEmpty(book.getBookTypeName()));
		
		
		return v;
	}
	
	
}
