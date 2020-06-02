package top.linruchang.view;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import top.linruchang.modal.BookType;
import top.linruchang.service.BookTypeService;
import top.linruchang.util.StringUtil;
import javax.swing.ImageIcon;

public class BookTypeInternalManagerView extends JInternalFrame {
	private JTable bookTypeTable;
	
	private BookTypeService bts = new BookTypeService();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeInternalManagerView frame = new BookTypeInternalManagerView();
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
	public BookTypeInternalManagerView() {
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setClosable(true);
		setIconifiable(true);
		setResizable(true);
		setBounds(100, 100, 645, 433);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel typeNameLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D");
		typeNameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 14));
		
		JTextArea typeNameText = new JTextArea();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setIcon(new ImageIcon(BookTypeInternalManagerView.class.getResource("/img/\u67E5\u8BE2.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String typeName = typeNameText.getText();
				
				if(StringUtil.isEmpty(typeName)) {
					fillTable(new BookType());
					return;
				}else {
					
					BookType bt = new BookType();
					bt.setBookTypeName(typeName);
					fillTable(bt);
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		
		JButton updateBtn = new JButton("\u7F16\u8F91\u6570\u636E");
		updateBtn.setIcon(new ImageIcon(BookTypeInternalManagerView.class.getResource("/img/\u4FEE\u6539.png")));
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = bookTypeTable.getSelectedRow();
				
				Integer id = (Integer)bookTypeTable.getValueAt(row, 0);
				String typeName = (String)bookTypeTable.getValueAt(row, 1);
				String typeText = (String)bookTypeTable.getValueAt(row, 2);
				
				BookTypeUpdateView d = new BookTypeUpdateView();
				d.init(id, typeName, typeText);
				d.setVisible(true);
			}
		});
		updateBtn.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		
		JButton deleteBtn = new JButton("\u5220\u9664\u6570\u636E");
		deleteBtn.setIcon(new ImageIcon(BookTypeInternalManagerView.class.getResource("/img/\u5220\u9664.png")));
		
		
		// É¾³ýÊý¾Ý°´Å¥
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO  É¾³ý°´Å¥´¦ÀíÊÂ¼þ
				int row = bookTypeTable.getSelectedRow();
				
				Integer id = (Integer)bookTypeTable.getValueAt(row, 0);
				String typeName = (String)bookTypeTable.getValueAt(row, 1);
				String typeText = (String)bookTypeTable.getValueAt(row, 2);
				
				int result = bts.delete(id);
				
				if(result != 0) {
					JOptionPane.showMessageDialog(null, "É¾³ýÍê³É");
					
					((DefaultTableModel)bookTypeTable.getModel()).removeRow(row);
					validate();
					
				}else {
					JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü");
				}
				
				
			}
		});
		deleteBtn.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(172)
							.addComponent(typeNameLabel)
							.addGap(31)
							.addComponent(typeNameText, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(btnNewButton)))
					.addContainerGap(35, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(140)
					.addComponent(updateBtn)
					.addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
					.addComponent(deleteBtn)
					.addGap(138))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(typeNameLabel)
						.addComponent(typeNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(updateBtn)
						.addComponent(deleteBtn))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		
		bookTypeTable = new JTable();
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7C7B\u522BID", "\u56FE\u4E66\u7C7B\u522B\u540D", "\u7C7B\u522B\u63CF\u8FF0"
			}
		));
		bookTypeTable.getColumnModel().getColumn(0).setPreferredWidth(73);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);

		
		this.fillTable(new BookType());
		
	}
	
	
	
	/**
	 * 
	 * @Description ³õÊ¼»¯±í¸ñ
	 * @param bt
	 */
	private void fillTable(BookType bt) {
		DefaultTableModel model = (DefaultTableModel)bookTypeTable.getModel();
		
		
		model.setRowCount(0);
		
		List<BookType> lists = bts.query(bt);
		
		List<Object> attrList = new ArrayList<Object>();
		
		for(BookType bt_q : lists) {
			attrList.add(bt_q.getId());
			attrList.add(bt_q.getBookTypeName());
			attrList.add(bt_q.getBookTypeDesc());
			
			model.addRow(new Vector<Object>(attrList));
			
			attrList.clear();
			
		}
		
	}
	
}
