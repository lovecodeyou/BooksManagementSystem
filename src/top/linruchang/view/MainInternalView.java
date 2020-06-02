package top.linruchang.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class MainInternalView extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInternalView frame = new MainInternalView();
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
	public MainInternalView() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainInternalView.class.getResource("/img/\u56FE\u4E66.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u65E5\u671F\uFF1A2019-11-30");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 17));
		
		JLabel lbllrc = new JLabel("\u4F5C\u8005\uFF1ALRC");
		lbllrc.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(160)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbllrc)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addContainerGap(170, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(lblNewLabel)
					.addGap(30)
					.addComponent(lbllrc)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5173\u4E8E\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(100, 100, 450, 300);

	}
}
