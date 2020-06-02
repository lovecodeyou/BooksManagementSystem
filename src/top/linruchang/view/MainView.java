package top.linruchang.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame {

	private JPanel contentPane;

	JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {

		// 1. 当前窗口最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 434);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u57FA\u672C");
		mnNewMenu.setIcon(new ImageIcon(MainView.class.getResource("/img/\u7EF4\u62A4.png")));
		menuBar.add(mnNewMenu);

		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7C7B\u522B");
		menu_1.setIcon(new ImageIcon(MainView.class.getResource("/img/\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406.png")));
		mnNewMenu.add(menu_1);

		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO 增加图书类别增加窗口
				
				 BookTypeInternalView btiv = new  BookTypeInternalView();
				 btiv.setVisible(true);
				 
				 desktopPane.add(btiv);
				
				
				
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainView.class.getResource("/img/\u6DFB\u52A0.png")));
		menu_1.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		
		// 1. 增加图书类别管理窗口
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookTypeInternalManagerView btimv = new BookTypeInternalManagerView();
				
				btimv.setVisible(true);
				
				desktopPane.add(btimv);
				
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainView.class.getResource("/img/\u7EF4\u62A41.png")));
		menu_1.add(menuItem_2);

		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainView.class.getResource("/img/\u56FE\u4E66\u7BA1\u7406.png")));
		mnNewMenu.add(menu_2);

		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		
		
		// 1. 生成图书添加的窗口
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookInternalView biv = new BookInternalView();
				biv.setVisible(true);
				desktopPane.add(biv);
				
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainView.class.getResource("/img/\u6DFB\u52A0.png")));
		menu_2.add(menuItem_3);

		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		
		// 图书类别查询、更新窗口生成
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookInternalEditView biev = new BookInternalEditView();
				biev.setVisible(true);
				
				desktopPane.add(biev);
				
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainView.class.getResource("/img/\u7EF4\u62A41.png")));
		menu_2.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("\u9000\u51FA\u8D26\u53F7");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 0::是 1：否 2：取消
				int result = JOptionPane.showConfirmDialog(null, "是否退出账户");

				if (result == 0) {
					dispose();
				}

			}
		});
		menuItem_5.setIcon(new ImageIcon(MainView.class.getResource("/img/\u9000\u51FA.png")));
		mnNewMenu.add(menuItem_5);

		JMenu menu = new JMenu("\u5E2E\u52A9");
		menu.setIcon(new ImageIcon(MainView.class.getResource("/img/\u5E2E\u52A9.png")));
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("\u5173\u4E8E\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainInternalView introduce = new MainInternalView();
				introduce.setVisible(true);
				desktopPane.add(introduce);
			}
		});
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.DARK_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

}
