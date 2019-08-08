package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import dao.PhongServices;
public class jpnTrangChinh extends JPanel implements ActionListener {
	private JLabel label_TongSoPhong, label_TongSoPhongDT;
	private JButton btnDatNhieuPhong;
	private JLabel lblP, lblP_1, lblP_3, lblP_5, lblP_6, lblP_2, lblP_4,
			label_Phong9, label_Phong10, label_Phong11, label_Phong12, label_Phong13, label_Phong14, label_Phong15,
			label_Phong16, label_Phong17, label_Phong18, label_Phong19, label_Phong20, lblP_7;
	private JPanel panel_Tang1, panel_Tang2, panel_Tang3, panel_Tang4;
	private ArrayList<JLabel> listLbl;
	private JButton btnDatMotPhong;
	private JLabel label_TongSoPhongTrong;
	private JLabel label_Trong;
	private JPanel panelMain;

	/**
	 * Create the panel.
	 */
	public jpnTrangChinh() {

		panelMain = new JPanel();

		JPanel panel_Tong = new JPanel();
		panel_Tong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Tong.setBackground(Color.GRAY);
		panel_Tong.setLayout(new BorderLayout(0, 0));

		JPanel panel_Trong = new JPanel();
		panel_Trong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Trong.setBackground(new Color(0, 128, 0));
		panel_Trong.setLayout(new BorderLayout(0, 0));

		JPanel panel_DaThue = new JPanel();
		panel_DaThue.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_DaThue.setBackground(Color.RED);
		panel_DaThue.setLayout(new BorderLayout(0, 0));

		btnDatNhieuPhong = new JButton("Thuê nhiều phòng");
		btnDatNhieuPhong.setBackground(Color.LIGHT_GRAY);
		btnDatNhieuPhong.setFont(new Font("Arial", Font.BOLD, 20));

		JPanel panel_DsPhong = new JPanel();

		JPanel panel_Tang = new JPanel();
		panel_Tang.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(70, 130, 180), null));

		panel_Tang1 = new JPanel();
		panel_Tang1.setBackground(new Color(70, 130, 180));
		panel_Tang1.setLayout(new BorderLayout(0, 0));

		panel_Tang3 = new JPanel();
		panel_Tang3.setBackground(new Color(70, 130, 180));
		panel_Tang3.setLayout(new BorderLayout(0, 0));

		panel_Tang4 = new JPanel();
		panel_Tang4.setBackground(new Color(70, 130, 180));
		panel_Tang4.setLayout(new BorderLayout(0, 0));

		panel_Tang2 = new JPanel();
		panel_Tang2.setBackground(new Color(70, 130, 180));
		panel_Tang2.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_panel_Tang = new GroupLayout(panel_Tang);
		gl_panel_Tang
				.setHorizontalGroup(gl_panel_Tang.createParallelGroup(Alignment.LEADING).addGap(0, 103, Short.MAX_VALUE)
						.addGroup(gl_panel_Tang.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_Tang.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_Tang1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
										.addComponent(panel_Tang3, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
										.addComponent(panel_Tang4, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
										.addComponent(panel_Tang2, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
								.addContainerGap()));
		gl_panel_Tang
				.setVerticalGroup(gl_panel_Tang.createParallelGroup(Alignment.LEADING).addGap(0, 374, Short.MAX_VALUE)
						.addGroup(gl_panel_Tang.createSequentialGroup().addContainerGap()
								.addComponent(panel_Tang1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE).addGap(45)
								.addComponent(panel_Tang2, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE).addGap(44)
								.addComponent(panel_Tang3, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE).addGap(43)
								.addComponent(panel_Tang4, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE).addGap(21)));

		JLabel label_Tang4 = new JLabel("T\u1EA7ng 4");
		label_Tang4.setHorizontalAlignment(SwingConstants.CENTER);
		label_Tang4.setFont(new Font("Arial", Font.BOLD, 15));
		panel_Tang4.add(label_Tang4, BorderLayout.CENTER);

		JLabel label_Tang3 = new JLabel("T\u1EA7ng 3");
		label_Tang3.setHorizontalAlignment(SwingConstants.CENTER);
		label_Tang3.setFont(new Font("Arial", Font.BOLD, 15));
		panel_Tang3.add(label_Tang3, BorderLayout.CENTER);

		JLabel label_Tang2 = new JLabel("T\u1EA7ng 2");
		label_Tang2.setHorizontalAlignment(SwingConstants.CENTER);
		label_Tang2.setFont(new Font("Arial", Font.BOLD, 15));
		panel_Tang2.add(label_Tang2, BorderLayout.CENTER);

		JLabel label_Tang1 = new JLabel("T\u1EA7ng 1");
		label_Tang1.setHorizontalAlignment(SwingConstants.CENTER);
		label_Tang1.setFont(new Font("Arial", Font.BOLD, 15));
		panel_Tang1.add(label_Tang1, BorderLayout.CENTER);
		panel_Tang.setLayout(gl_panel_Tang);

		JPanel panel_DSPhongTang1 = new JPanel();

		JPanel panel_Phong1 = new JPanel();
		panel_Phong1.setBackground(new Color(0, 128, 0));
		panel_Phong1.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong2 = new JPanel();
		panel_Phong2.setBackground(new Color(0, 128, 0));
		panel_Phong2.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong3 = new JPanel();
		panel_Phong3.setBackground(new Color(0, 128, 0));
		panel_Phong3.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong4 = new JPanel();
		panel_Phong4.setBackground(new Color(0, 128, 0));
		panel_Phong4.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong5 = new JPanel();
		panel_Phong5.setBackground(new Color(0, 128, 0));
		panel_Phong5.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_panel_DSPhongTang1 = new GroupLayout(panel_DSPhongTang1);
		gl_panel_DSPhongTang1.setHorizontalGroup(gl_panel_DSPhongTang1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 915, Short.MAX_VALUE)
				.addGroup(gl_panel_DSPhongTang1.createSequentialGroup().addGap(39)
						.addComponent(panel_Phong1, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(67)
						.addComponent(panel_Phong2, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(67)
						.addComponent(panel_Phong3, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(58)
						.addComponent(panel_Phong4, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(49)
						.addComponent(panel_Phong5, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(40)));
		gl_panel_DSPhongTang1.setVerticalGroup(
				gl_panel_DSPhongTang1.createParallelGroup(Alignment.LEADING).addGap(0, 85, Short.MAX_VALUE)
						.addGroup(gl_panel_DSPhongTang1.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_DSPhongTang1.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_Phong3, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong4, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong5, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong1, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong2, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
								.addContainerGap()));

		lblP_6 = new JLabel("");
		lblP_6.setForeground(Color.WHITE);
		lblP_6.setVerticalTextPosition(SwingConstants.TOP);
		lblP_6.setHorizontalTextPosition(SwingConstants.CENTER);
		lblP_6.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		lblP_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblP_6.setFont(new Font("Arial", Font.BOLD, 20));
		lblP_6.setBackground(new Color(0, 128, 0));
		panel_Phong5.add(lblP_6, BorderLayout.CENTER);

		lblP_5 = new JLabel("");
		lblP_5.setForeground(Color.WHITE);
		lblP_5.setVerticalTextPosition(SwingConstants.TOP);
		lblP_5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblP_5.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/doi.png")));
		lblP_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblP_5.setFont(new Font("Arial", Font.BOLD, 20));
		lblP_5.setBackground(new Color(0, 128, 0));
		panel_Phong4.add(lblP_5, BorderLayout.CENTER);

		lblP_3 = new JLabel("");
		lblP_3.setForeground(Color.WHITE);
		lblP_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblP_3.setVerticalTextPosition(SwingConstants.TOP);
		lblP_3.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		lblP_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblP_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblP_3.setBackground(new Color(0, 128, 0));
		panel_Phong3.add(lblP_3, BorderLayout.CENTER);

		lblP_1 = new JLabel("");
		lblP_1.setForeground(Color.WHITE);
		lblP_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblP_1.setVerticalTextPosition(SwingConstants.TOP);
		lblP_1.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		lblP_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblP_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblP_1.setBackground(new Color(0, 128, 0));
		panel_Phong2.add(lblP_1, BorderLayout.CENTER);

		lblP = new JLabel("");
		lblP.setForeground(Color.WHITE);
		lblP.setVerticalTextPosition(SwingConstants.TOP);
		lblP.setHorizontalTextPosition(SwingConstants.CENTER);
		lblP.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/doi.png")));
		lblP.setHorizontalAlignment(SwingConstants.CENTER);
		lblP.setFont(new Font("Arial", Font.BOLD, 20));
		lblP.setBackground(new Color(0, 128, 0));
		panel_Phong1.add(lblP, BorderLayout.CENTER);
		panel_DSPhongTang1.setLayout(gl_panel_DSPhongTang1);

		JPanel panel_DSPhongTang2 = new JPanel();

		JPanel panel_Phong6 = new JPanel();
		panel_Phong6.setBackground(new Color(0, 128, 0));
		panel_Phong6.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong7 = new JPanel();
		panel_Phong7.setBackground(new Color(0, 128, 0));
		panel_Phong7.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong8 = new JPanel();
		panel_Phong8.setBackground(new Color(0, 128, 0));
		panel_Phong8.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong9 = new JPanel();
		panel_Phong9.setBackground(new Color(0, 128, 0));
		panel_Phong9.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong10 = new JPanel();
		panel_Phong10.setBackground(new Color(0, 128, 0));
		panel_Phong10.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_panel_DSPhongTang2 = new GroupLayout(panel_DSPhongTang2);
		gl_panel_DSPhongTang2.setHorizontalGroup(gl_panel_DSPhongTang2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 915, Short.MAX_VALUE)
				.addGroup(gl_panel_DSPhongTang2.createSequentialGroup().addGap(39)
						.addComponent(panel_Phong6, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(67)
						.addComponent(panel_Phong7, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(67)
						.addComponent(panel_Phong8, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(58)
						.addComponent(panel_Phong9, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(49)
						.addComponent(panel_Phong10, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(40)));
		gl_panel_DSPhongTang2.setVerticalGroup(
				gl_panel_DSPhongTang2.createParallelGroup(Alignment.LEADING).addGap(0, 85, Short.MAX_VALUE)
						.addGroup(gl_panel_DSPhongTang2.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_DSPhongTang2.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_Phong8, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong9, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong10, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong6, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong7, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
								.addContainerGap()));

		lblP_7 = new JLabel("");
		lblP_7.setForeground(Color.WHITE);
		lblP_7.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		lblP_7.setVerticalTextPosition(SwingConstants.TOP);
		lblP_7.setHorizontalTextPosition(SwingConstants.CENTER);
		lblP_7.setFont(new Font("Arial", Font.BOLD, 20));
		lblP_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Phong8.add(lblP_7, BorderLayout.CENTER);

		label_Phong10 = new JLabel("");
		label_Phong10.setForeground(Color.WHITE);
		label_Phong10.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		label_Phong10.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong10.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong10.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong10.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong10.setBackground(new Color(0, 128, 0));
		panel_Phong10.add(label_Phong10, BorderLayout.CENTER);

		label_Phong9 = new JLabel("");
		label_Phong9.setForeground(Color.WHITE);
		label_Phong9.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/doi.png")));
		label_Phong9.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong9.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong9.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong9.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong9.setBackground(new Color(0, 128, 0));
		panel_Phong9.add(label_Phong9, BorderLayout.CENTER);

		lblP_4 = new JLabel("");
		lblP_4.setForeground(Color.WHITE);
		lblP_4.setVerticalTextPosition(SwingConstants.TOP);
		lblP_4.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		lblP_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblP_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblP_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblP_4.setBackground(new Color(0, 128, 0));
		panel_Phong7.add(lblP_4, BorderLayout.CENTER);

		lblP_2 = new JLabel("");
		lblP_2.setForeground(Color.WHITE);
		lblP_2.setVerticalTextPosition(SwingConstants.TOP);
		lblP_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblP_2.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/doi.png")));
		lblP_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblP_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblP_2.setBackground(new Color(0, 128, 0));
		panel_Phong6.add(lblP_2, BorderLayout.CENTER);
		panel_DSPhongTang2.setLayout(gl_panel_DSPhongTang2);

		JPanel panel_DSPhongTang3 = new JPanel();

		JPanel panel_Phong11 = new JPanel();
		panel_Phong11.setBackground(new Color(0, 128, 0));
		panel_Phong11.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong12 = new JPanel();
		panel_Phong12.setBackground(new Color(0, 128, 0));
		panel_Phong12.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong13 = new JPanel();
		panel_Phong13.setBackground(new Color(0, 128, 0));
		panel_Phong13.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong14 = new JPanel();
		panel_Phong14.setBackground(new Color(0, 128, 0));
		panel_Phong14.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong15 = new JPanel();
		panel_Phong15.setBackground(new Color(0, 128, 0));
		panel_Phong15.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_panel_DSPhongTang3 = new GroupLayout(panel_DSPhongTang3);
		gl_panel_DSPhongTang3.setHorizontalGroup(gl_panel_DSPhongTang3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 915, Short.MAX_VALUE)
				.addGroup(gl_panel_DSPhongTang3.createSequentialGroup().addGap(39)
						.addComponent(panel_Phong11, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(67)
						.addComponent(panel_Phong12, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(67)
						.addComponent(panel_Phong13, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(58)
						.addComponent(panel_Phong14, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(49)
						.addComponent(panel_Phong15, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(40)));
		gl_panel_DSPhongTang3.setVerticalGroup(
				gl_panel_DSPhongTang3.createParallelGroup(Alignment.LEADING).addGap(0, 85, Short.MAX_VALUE)
						.addGroup(gl_panel_DSPhongTang3.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_DSPhongTang3.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_Phong13, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong14, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong15, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong11, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong12, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
								.addContainerGap()));

		label_Phong15 = new JLabel("");
		label_Phong15.setForeground(Color.WHITE);
		label_Phong15.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		label_Phong15.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong15.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong15.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong15.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong15.setBackground(new Color(0, 128, 0));
		panel_Phong15.add(label_Phong15, BorderLayout.CENTER);

		label_Phong14 = new JLabel("");
		label_Phong14.setForeground(Color.WHITE);
		label_Phong14.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/doi.png")));
		label_Phong14.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong14.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong14.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong14.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong14.setBackground(new Color(0, 128, 0));
		panel_Phong14.add(label_Phong14, BorderLayout.CENTER);

		label_Phong13 = new JLabel("");
		label_Phong13.setForeground(Color.WHITE);
		label_Phong13.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		label_Phong13.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong13.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong13.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong13.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong13.setBackground(new Color(0, 128, 0));
		panel_Phong13.add(label_Phong13, BorderLayout.CENTER);

		label_Phong12 = new JLabel("");
		label_Phong12.setForeground(Color.WHITE);
		label_Phong12.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		label_Phong12.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong12.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong12.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong12.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong12.setBackground(new Color(0, 128, 0));
		panel_Phong12.add(label_Phong12, BorderLayout.CENTER);

		label_Phong11 = new JLabel("");
		label_Phong11.setForeground(Color.WHITE);
		label_Phong11.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/doi.png")));
		label_Phong11.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong11.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong11.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong11.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong11.setBackground(new Color(0, 128, 0));
		panel_Phong11.add(label_Phong11, BorderLayout.CENTER);
		panel_DSPhongTang3.setLayout(gl_panel_DSPhongTang3);

		JPanel panel_DSPhongTang4 = new JPanel();

		JPanel panel_Phong16 = new JPanel();
		panel_Phong16.setBackground(new Color(0, 128, 0));
		panel_Phong16.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong17 = new JPanel();
		panel_Phong17.setBackground(new Color(0, 128, 0));
		panel_Phong17.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong18 = new JPanel();
		panel_Phong18.setBackground(new Color(0, 128, 0));
		panel_Phong18.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong19 = new JPanel();
		panel_Phong19.setBackground(new Color(0, 128, 0));
		panel_Phong19.setLayout(new BorderLayout(0, 0));

		JPanel panel_Phong20 = new JPanel();
		panel_Phong20.setBackground(new Color(0, 128, 0));
		panel_Phong20.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_panel_DSPhongTang4 = new GroupLayout(panel_DSPhongTang4);
		gl_panel_DSPhongTang4.setHorizontalGroup(gl_panel_DSPhongTang4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 915, Short.MAX_VALUE)
				.addGroup(gl_panel_DSPhongTang4.createSequentialGroup().addGap(39)
						.addComponent(panel_Phong16, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(67)
						.addComponent(panel_Phong17, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(67)
						.addComponent(panel_Phong18, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(58)
						.addComponent(panel_Phong19, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(49)
						.addComponent(panel_Phong20, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(40)));
		gl_panel_DSPhongTang4.setVerticalGroup(
				gl_panel_DSPhongTang4.createParallelGroup(Alignment.LEADING).addGap(0, 85, Short.MAX_VALUE)
						.addGroup(gl_panel_DSPhongTang4.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_DSPhongTang4.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_Phong18, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong19, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong20, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong16, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(panel_Phong17, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
								.addContainerGap()));

		label_Phong20 = new JLabel("");
		label_Phong20.setForeground(Color.WHITE);
		label_Phong20.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		label_Phong20.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong20.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong20.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong20.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong20.setBackground(new Color(0, 128, 0));
		panel_Phong20.add(label_Phong20, BorderLayout.CENTER);

		label_Phong19 = new JLabel("");
		label_Phong19.setForeground(Color.WHITE);
		label_Phong19.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/doi.png")));
		label_Phong19.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong19.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong19.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong19.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong19.setBackground(new Color(0, 128, 0));
		panel_Phong19.add(label_Phong19, BorderLayout.CENTER);

		label_Phong18 = new JLabel("");
		label_Phong18.setForeground(Color.WHITE);
		label_Phong18.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		label_Phong18.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong18.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong18.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong18.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong18.setBackground(new Color(0, 128, 0));
		panel_Phong18.add(label_Phong18, BorderLayout.CENTER);

		label_Phong17 = new JLabel("");
		label_Phong17.setForeground(Color.WHITE);
		label_Phong17.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/don.png")));
		label_Phong17.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong17.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong17.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong17.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong17.setBackground(new Color(0, 128, 0));
		panel_Phong17.add(label_Phong17, BorderLayout.CENTER);

		label_Phong16 = new JLabel("");
		label_Phong16.setForeground(Color.WHITE);
		label_Phong16.setIcon(new ImageIcon(jpnTrangChinh.class.getResource("/images/doi.png")));
		label_Phong16.setVerticalTextPosition(SwingConstants.TOP);
		label_Phong16.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Phong16.setHorizontalAlignment(SwingConstants.CENTER);
		label_Phong16.setFont(new Font("Arial", Font.BOLD, 20));
		label_Phong16.setBackground(new Color(0, 128, 0));
		panel_Phong16.add(label_Phong16, BorderLayout.CENTER);
		panel_DSPhongTang4.setLayout(gl_panel_DSPhongTang4);
		GroupLayout gl_panel_DsPhong = new GroupLayout(panel_DsPhong);
		gl_panel_DsPhong.setHorizontalGroup(
			gl_panel_DsPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_DsPhong.createSequentialGroup()
					.addComponent(panel_Tang, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_DsPhong.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_DSPhongTang1, GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
						.addComponent(panel_DSPhongTang2, GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
						.addComponent(panel_DSPhongTang4, GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
						.addComponent(panel_DSPhongTang3, GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_DsPhong.setVerticalGroup(
			gl_panel_DsPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_DsPhong.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel_DsPhong.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_DsPhong.createSequentialGroup()
							.addComponent(panel_DSPhongTang1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_DSPhongTang2, GroupLayout.PREFERRED_SIZE, 85, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_DSPhongTang3, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
							.addGap(1)
							.addComponent(panel_DSPhongTang4, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
							.addGap(13))
						.addComponent(panel_Tang, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_DsPhong.setLayout(gl_panel_DsPhong);

		btnDatMotPhong = new JButton("Thuê một phòng");
		btnDatMotPhong.setBackground(Color.LIGHT_GRAY);
		btnDatMotPhong.setFont(new Font("Arial", Font.BOLD, 20));
		GroupLayout gl_panelMain = new GroupLayout(panelMain);
		gl_panelMain.setHorizontalGroup(
			gl_panelMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMain.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMain.createSequentialGroup()
							.addGap(100)
							.addComponent(panel_Tong, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
							.addGap(53)
							.addComponent(panel_Trong, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
							.addGap(53)
							.addComponent(panel_DaThue, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
							.addGap(90))
						.addGroup(gl_panelMain.createSequentialGroup()
							.addComponent(btnDatNhieuPhong, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDatMotPhong, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_DsPhong, GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelMain.setVerticalGroup(
			gl_panelMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMain.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_Tong, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_Trong, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_DaThue, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panelMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDatNhieuPhong, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDatMotPhong, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_DsPhong, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
					.addContainerGap())
		);

		JLabel label_DaThue = new JLabel("\u0110\u00E3 thu\u00EA");
		label_DaThue.setPreferredSize(new Dimension(45, 40));
		label_DaThue.setHorizontalAlignment(SwingConstants.CENTER);
		label_DaThue.setFont(new Font("Arial", Font.BOLD, 25));
		panel_DaThue.add(label_DaThue, BorderLayout.NORTH);

		label_TongSoPhongDT = new JLabel("");
		label_TongSoPhongDT.setForeground(Color.WHITE);
		label_TongSoPhongDT.setHorizontalAlignment(SwingConstants.CENTER);
		label_TongSoPhongDT.setFont(new Font("Arial", Font.BOLD, 35));
		panel_DaThue.add(label_TongSoPhongDT, BorderLayout.CENTER);

		label_Trong = new JLabel("Tr\u1ED1ng");
		label_Trong.setPreferredSize(new Dimension(34, 40));
		label_Trong.setHorizontalAlignment(SwingConstants.CENTER);
		label_Trong.setFont(new Font("Arial", Font.BOLD, 25));
		panel_Trong.add(label_Trong, BorderLayout.NORTH);

		label_TongSoPhongTrong = new JLabel("");
		label_TongSoPhongTrong.setForeground(Color.WHITE);
		label_TongSoPhongTrong.setHorizontalAlignment(SwingConstants.CENTER);
		label_TongSoPhongTrong.setFont(new Font("Arial", Font.BOLD, 35));
		panel_Trong.add(label_TongSoPhongTrong, BorderLayout.CENTER);

		JLabel label_Tong = new JLabel("T\u1ED5ng");
		label_Tong.setPreferredSize(new Dimension(0, 40));
		label_Tong.setHorizontalAlignment(SwingConstants.CENTER);
		label_Tong.setForeground(Color.BLACK);
		label_Tong.setFont(new Font("Arial", Font.BOLD, 25));
		panel_Tong.add(label_Tong, BorderLayout.NORTH);

		label_TongSoPhong = new JLabel("20");
		label_TongSoPhong.setHorizontalAlignment(SwingConstants.CENTER);
		label_TongSoPhong.setForeground(Color.WHITE);
		label_TongSoPhong.setFont(new Font("Arial", Font.BOLD, 35));
		panel_Tong.add(label_TongSoPhong, BorderLayout.CENTER);
		panelMain.setLayout(gl_panelMain);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelMain, GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelMain, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
		);
		setLayout(groupLayout);


		listLbl = new ArrayList<JLabel>();
		listLbl.add(lblP);
		listLbl.add(lblP_1);
		listLbl.add(lblP_3);
		listLbl.add(lblP_5);

		listLbl.add(lblP_6);
		listLbl.add(lblP_2);
		listLbl.add(lblP_4);
		listLbl.add(lblP_7);
		listLbl.add(label_Phong9);
		listLbl.add(label_Phong10);
		listLbl.add(label_Phong11);
		listLbl.add(label_Phong12);
		listLbl.add(label_Phong13);
		listLbl.add(label_Phong14);
		listLbl.add(label_Phong15);
		listLbl.add(label_Phong16);
		listLbl.add(label_Phong17);
		listLbl.add(label_Phong18);
		listLbl.add(label_Phong19);
		listLbl.add(label_Phong20);
		try {
			hienThiTrangThaiPhong();
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		btnDatNhieuPhong.addActionListener(this);
		btnDatMotPhong.addActionListener(this);
	}

	private void hienThiTrangThaiPhong() throws Exception {
		int tang = 1;
		int sp = 1,demPhongTrong=0;
		
		for (int j = 0; j < listLbl.size(); j++) {
			listLbl.get(j).setText(tang + "0" + (sp));
			sp++;
			if (sp == 6) {
				tang++;
				sp = 1;
			}
			if (PhongServices.layThongTinPhong(listLbl.get(j).getText()).isTinhTrang() == true) {
				listLbl.get(j).getParent().setBackground(Color.RED);
			}else {
				demPhongTrong++;
			}
			

		}
		label_TongSoPhongTrong.setText(demPhongTrong+"");
		label_TongSoPhongDT.setText(PhongServices.layDanhSachPhong().size()-demPhongTrong+"");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnDatNhieuPhong) {
			JDialog thueNhieu = new jpnDangKiNhieu();
			thueNhieu.setVisible(true);
			if(thueNhieu.isDisplayable()==false) {
				panelMain.removeAll();
				panelMain.setLayout(new BorderLayout());
				panelMain.add(new jpnTrangChinh());
				panelMain.validate();
				panelMain.repaint();
			}
		} else if (o == btnDatMotPhong) {
			JDialog thueMot = new jpnDangKiMot();
			thueMot.setVisible(true);
			if(thueMot.isDisplayable()==false) {
				panelMain.removeAll();
				panelMain.setLayout(new BorderLayout());
				panelMain.add(new jpnTrangChinh());
				panelMain.validate();
				panelMain.repaint();
			}
		
		}

	}
}
