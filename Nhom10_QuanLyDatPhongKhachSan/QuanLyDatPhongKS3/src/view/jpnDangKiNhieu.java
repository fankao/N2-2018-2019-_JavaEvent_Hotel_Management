package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import bus.HoaDonBus;
import bus.KhachHangBus;
import dao.CT_HoaDonServices;
import dao.HoaDonServices;
import dao.KhachHangServices;
import dao.NhanVienServices;
import dao.PhongServices;
import model.CT_HoaDon;
import model.HoaDon;
import model.KhachHang;
import model.Phong;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ButtonGroup;

public class jpnDangKiNhieu extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCMND;
	private JTextField txtDiaChi;
	private JTextField txtTen;
	private JTextField txtSdt;
	private JButton btnLuu;
	private DefaultListModel<String> model1;
	private DefaultListModel<String> model2;
	private JList<String> list_b;
	private JList<String> list_a;
	private JButton btnChonPh;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbNu;
	private JRadioButton rdbNam;
	private JDateChooser ngayThue;
	private JDateChooser ngayTra;
	private JLabel lblSoPh;
	private JButton btnHuyPh;
	private JButton btnHuy;
	private JLabel lblHienLkH;
	private JButton btnCheck;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jpnDangKiNhieu frame = new jpnDangKiNhieu();
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
	public jpnDangKiNhieu() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1356, 785);
		setModal(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 204, 51));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(51, 204, 51));

		JLabel lbltNhiuPhong = new JLabel("Đặt Nhiều Phòng");
		lbltNhiuPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lbltNhiuPhong.setForeground(Color.WHITE);
		lbltNhiuPhong.setFont(new Font("Source Code Pro", Font.BOLD, 24));
		lbltNhiuPhong.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup().addContainerGap(539, Short.MAX_VALUE)
						.addComponent(lbltNhiuPhong, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
						.addGap(535)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(19).addComponent(lbltNhiuPhong).addContainerGap(21, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true),
				"Chi Ti\u00EA\u0301t Thu\u00EA Pho\u0300ng", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBackground(new Color(220, 220, 220));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(75, 0, 130), new Color(75, 0, 130)));
		panel_3.setBackground(new Color(245, 245, 245));

		JLabel txtSoPhong = new JLabel("Số phòng thuê: ");
		txtSoPhong.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoPhong.setForeground(Color.BLACK);
		txtSoPhong.setFont(new Font("Arial", Font.BOLD, 17));

		lblSoPh = new JLabel("");
		lblSoPh.setFont(new Font("Arial", Font.BOLD, 16));
		lblSoPh.setBackground(Color.BLACK);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(txtSoPhong).addGap(18)
						.addComponent(lblSoPh, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(12)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSoPhong, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoPh, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(75, 0, 130), new Color(75, 0, 130)));
		panel_4.setBackground(new Color(245, 245, 245));

		JLabel lblngayThue = new JLabel("Ngày thuê: ");
		lblngayThue.setForeground(Color.BLACK);
		lblngayThue.setFont(new Font("Arial", Font.BOLD, 17));

		ngayThue = new JDateChooser();
		ngayThue.setDateFormatString("dd/MM/yyyy");
		ngayThue.getCalendarButton().setBackground(new Color(204, 51, 0));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap().addComponent(lblngayThue)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(ngayThue, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE).addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(ngayThue, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblngayThue, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(75, 0, 130), new Color(75, 0, 130)));
		panel_5.setBackground(new Color(245, 245, 245));

		JLabel lblNgayTra = new JLabel("Ngày trả: ");
		lblNgayTra.setForeground(Color.BLACK);
		lblNgayTra.setFont(new Font("Asap SemiBold", Font.BOLD, 17));

		ngayTra = new JDateChooser();
		ngayTra.setDateFormatString("dd/MM/yyyy");
		ngayTra.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ngayTra.getCalendarButton().setBackground(new Color(204, 51, 0));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup().addContainerGap().addComponent(lblNgayTra)
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addComponent(ngayTra, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(ngayTra, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgayTra, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_5.setLayout(gl_panel_5);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 560,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 560,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(18).addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGap(64)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_6.setBackground(new Color(204, 204, 204));

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		panel_7.setBackground(new Color(102, 204, 102));

		JLabel label_5 = new JLabel("CHỌN PHÒNG");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arima Madurai ExtraBold", Font.BOLD, 20));
		label_5.setBackground(new Color(102, 204, 102));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup().addContainerGap()
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(14, Short.MAX_VALUE)));
		gl_panel_7.setVerticalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_7.createSequentialGroup().addGap(5).addComponent(label_5, GroupLayout.DEFAULT_SIZE, 39,
						Short.MAX_VALUE)));
		panel_7.setLayout(gl_panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBackground(Color.WHITE);

		btnChonPh = new JButton("Thuê Phòng");
		btnChonPh.setIcon(new ImageIcon(jpnDangKiNhieu.class.getResource("/images/icons8-auto-update-40.png")));
		btnChonPh.setFont(new Font("Arial", Font.BOLD, 16));

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBackground(Color.WHITE);

		btnHuyPh = new JButton("Huỷ chọn");
		btnHuyPh.setIcon(new ImageIcon(jpnDangKiNhieu.class.getResource("/images/twotone_cancel_black_18dp.png")));
		btnHuyPh.setFont(new Font("Arial", Font.BOLD, 16));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup().addContainerGap(219, Short.MAX_VALUE)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(203))
				.addGroup(gl_panel_6.createSequentialGroup().addGap(23).addGroup(gl_panel_6
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
								.addComponent(btnChonPh, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
								.addComponent(btnHuyPh, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 642, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)).addGap(24)));
		gl_panel_6.setVerticalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_6
				.createSequentialGroup().addContainerGap()
				.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE).addGap(11)
				.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnHuyPh, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChonPh))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(35, Short.MAX_VALUE)));
		panel_10.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_10.add(scrollPane_1, BorderLayout.CENTER);

		list_b = new JList();
		list_b.setVisibleRowCount(5);
		scrollPane_1.setViewportView(list_b);
		panel_8.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_8.add(scrollPane, BorderLayout.CENTER);

		list_a = new JList();
		list_a.setModel(new AbstractListModel() {
			String[] values = new String[] { "Minh Chiến CD" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_a.setVisibleRowCount(5);
		scrollPane.setViewportView(list_a);
		panel_6.setLayout(gl_panel_6);

		JPanel panel_12 = new JPanel();
		panel_12.setForeground(Color.BLACK);

		panel_12.setBorder(
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Th\u00F4ng Tin Kha\u0301ch Ha\u0300ng",
						TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));

		panel_12.setBackground(new Color(220, 220, 220));

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(245, 245, 245));

		JLabel lblCMnd = new JLabel("CMND: ");
		lblCMnd.setForeground(Color.BLACK);
		lblCMnd.setFont(new Font("Asap SemiBold", Font.BOLD, 14));

		txtCMND = new JTextField();
		txtCMND.setColumns(12);
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup().addContainerGap()
						.addComponent(lblCMnd, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtCMND, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE).addContainerGap()));
		gl_panel_13.setVerticalGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_13.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCMND, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCMnd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))));
		panel_13.setLayout(gl_panel_13);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(245, 245, 245));

		JLabel label_9 = new JLabel("Địa Chỉ: ");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Asap SemiBold", Font.BOLD, 14));

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup().addContainerGap()
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtDiaChi, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE).addContainerGap()));
		gl_panel_14.setVerticalGroup(gl_panel_14.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_14.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_14.setLayout(gl_panel_14);

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(245, 245, 245));

		JLabel lblHTn = new JLabel("Họ tên:");
		lblHTn.setForeground(Color.BLACK);
		lblHTn.setFont(new Font("Asap SemiBold", Font.BOLD, 14));

		txtTen = new JTextField();
		txtTen.setEditable(false);
		txtTen.setColumns(10);
		GroupLayout gl_panel_15 = new GroupLayout(panel_15);
		gl_panel_15.setHorizontalGroup(gl_panel_15.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_15.createSequentialGroup().addContainerGap()
						.addComponent(lblHTn, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtTen, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE).addContainerGap()));
		gl_panel_15.setVerticalGroup(gl_panel_15.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_15.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_15.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHTn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_15.setLayout(gl_panel_15);

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(245, 245, 245));

		JLabel lblLoai = new JLabel("Phân Loại KH:");
		lblLoai.setForeground(Color.BLACK);
		lblLoai.setFont(new Font("Athiti SemiBold", Font.BOLD, 14));
		lblLoai.setBackground(new Color(0, 102, 255));

		btnCheck = new JButton("Check");
		btnCheck.setIcon(new ImageIcon(jpnDangKiNhieu.class.getResource("/images/icons8-renew-16.png")));

		lblHienLkH = new JLabel("");
		lblHienLkH.setForeground(new Color(178, 34, 34));
		lblHienLkH.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblHienLkH.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_16 = new GroupLayout(panel_16);
		gl_panel_16.setHorizontalGroup(gl_panel_16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_16.createSequentialGroup().addContainerGap().addComponent(lblLoai)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblHienLkH, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnCheck).addContainerGap()));
		gl_panel_16.setVerticalGroup(gl_panel_16.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_16.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_16.createParallelGroup(Alignment.BASELINE).addComponent(btnCheck)
								.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHienLkH, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_16.setLayout(gl_panel_16);

		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(245, 245, 245));

		JLabel label_12 = new JLabel("Giới Tính:");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Asap SemiBold", Font.BOLD, 14));

		rdbNam = new JRadioButton("Nam");
		buttonGroup.add(rdbNam);
		rdbNam.setSelected(true);

		rdbNu = new JRadioButton("Nữ");
		buttonGroup.add(rdbNu);
		GroupLayout gl_panel_17 = new GroupLayout(panel_17);
		gl_panel_17.setHorizontalGroup(gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_17.createSequentialGroup().addContainerGap().addComponent(label_12)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(rdbNam)
						.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE).addComponent(rdbNu)
						.addGap(27)));
		gl_panel_17.setVerticalGroup(gl_panel_17.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_17.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_17.createParallelGroup(Alignment.BASELINE).addComponent(rdbNu)
								.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbNam))
						.addContainerGap()));
		panel_17.setLayout(gl_panel_17);

		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(245, 245, 245));

		JLabel label_13 = new JLabel("SĐT:");
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Asap SemiBold", Font.BOLD, 14));

		txtSdt = new JTextField();
		txtSdt.setEditable(false);
		txtSdt.setColumns(10);
		GroupLayout gl_panel_18 = new GroupLayout(panel_18);
		gl_panel_18.setHorizontalGroup(gl_panel_18.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_18.createSequentialGroup().addContainerGap().addComponent(label_13).addGap(18)
						.addComponent(txtSdt, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE).addContainerGap()));
		gl_panel_18.setVerticalGroup(gl_panel_18.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_18.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_18.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_18.setLayout(gl_panel_18);
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_12.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_12.createSequentialGroup()
										.addComponent(panel_16, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(
												panel_17, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_panel_12.createSequentialGroup().addGroup(gl_panel_12
										.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel_15, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_panel_12.createSequentialGroup()
												.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(panel_18,
														GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
										.addComponent(panel_14, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 554,
												Short.MAX_VALUE))
										.addGap(16)))));
		gl_panel_12.setVerticalGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup().addGap(25)
						.addGroup(gl_panel_12.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_18, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_15, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_12.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_17, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_16, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_12.setLayout(gl_panel_12);

		btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon(jpnDangKiNhieu.class.getResource("/images/icons8-cancel-48.png")));
		btnHuy.setHorizontalAlignment(SwingConstants.LEFT);
		btnHuy.setFont(new Font("Arial", Font.BOLD, 14));
		btnHuy.setBackground(Color.LIGHT_GRAY);

		btnLuu = new JButton("Lưu");
		btnLuu.setForeground(new Color(0, 0, 0));

		btnLuu.setIcon(new ImageIcon(jpnDangKiNhieu.class.getResource("/images/icons8-save-as-48.png")));
		btnLuu.setFont(new Font("Arial", Font.BOLD, 14));
		btnLuu.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1333, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_12, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 469, Short.MAX_VALUE).addComponent(
												btnLuu, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 123,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE))
								.addContainerGap()))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(panel_12,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE))
				.addGap(27)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHuy, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnLuu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));

		ngayTra.setDate(new java.util.Date());
		ngayThue.setDate(new java.util.Date());
		contentPane.setLayout(gl_contentPane);
		btnLuu.addActionListener(this);
		btnChonPh.addActionListener(this);
		btnHuyPh.addActionListener(this);
		btnHuy.addActionListener(this);
		btnCheck.addActionListener(this);

		model1 = new DefaultListModel();
		model2 = new DefaultListModel();
		hienThiPhongTrong();
		list_a.setModel(model1);
		list_b.setModel(model2);

	}

	private void hienThiPhongTrong() {
		model1.removeAllElements();
		try {
			for (Phong ph : PhongServices.layDanhSachPhong()) {
				if (ph.isTinhTrang() == false) {
					model1.addElement(ph.getSoPhong() + "-" + ph.getLoaiPhong().getTenLoaiPhong());
					;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void showNotice(JTextField tx, String no) {
		JOptionPane.showMessageDialog(this, no);
		tx.requestFocus();
	}

	public boolean validata() {
		String cmnd = txtCMND.getText().trim();
		String ten = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String sdt = txtSdt.getText().trim();
		SimpleDateFormat sfm = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (!(model2.size() > 0)) {
			JOptionPane.showMessageDialog(null, "Chưa chọn phòng!!!");
			return false;
		}
		if(!LocalDate.parse(sfm.format(ngayThue.getDate()), dfm).isEqual(LocalDate.now())){
			JOptionPane.showMessageDialog(null,"Ngày thuê phải là ngày hiện tại!!!!");
			return false;
		}
		if (ngayTra.getDate().before(ngayThue.getDate())) {
			JOptionPane.showMessageDialog(null, "Ngày trả phòng phải sau ngày thuê phòng mặc định là ngày thuê!!!");
			return false;
		}
		if (cmnd.length() == 0 || ten.length() == 0 || diachi.length() == 0 || sdt.length() == 0) {
			if (cmnd.length() == 0) {
				showNotice(txtCMND, "CMND không đươc rỗng");
				txtCMND.requestFocus();
				return false;
			}
			
			if (ten.length() == 0) {
				showNotice(txtTen, "Tên không đươc rỗng");
				txtTen.requestFocus();
				return false;

			}
			
			if (diachi.length() == 0) {
				showNotice(txtDiaChi, "Địa Chỉ không đươc rỗng");
				txtDiaChi.requestFocus();
				return false;

			}
			if (sdt.length() == 0) {
				showNotice(txtSdt, "Số Điện Thoại không đươc rỗng");
				txtSdt.requestFocus();
				return false;
			}
			return false;
		}
		if (cmnd.matches("[0-9]{9}") == false) {
			showNotice(txtCMND, "CMND Gồm 9 ký tự số");
			txtCMND.requestFocus();
			return false;
		}
		if (ten.matches("[A-Za-z ]{3,30}$") == false) {
			showNotice(txtSdt, "Tên Chưa Hợp Lệ ( Tên Không Có Kí Tự Đặc Biệt Và Số)");
			txtTen.requestFocus();
			return false;
		}
		if (!(sdt.matches("(\\+84|0)[0-9]{9}"))) {
			showNotice(txtSdt, "Số Điện Thoại Gồm 10 Ký Tự Số");
			txtSdt.requestFocus();
			return false;
		}
		if (!(lblHienLkH.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Chưa phân loại khách hàng");
			btnCheck.requestFocus();
			return false;
		}
		if (!(diachi.matches("[\\w ]{1,30}"))) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không chứa kí tự đặc biệt và không quá 30 kí tự!!!");
			txtSdt.requestFocus();
			txtDiaChi.selectAll();
			return false;
		}

		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnLuu) {
			if (validata()) {
				KhachHangBus khbus = new KhachHangBus();
				boolean gt = rdbNam.isSelected();
				if (!gt) {
					gt = false;
				}
				KhachHang kh = null;
				try {
					kh = new KhachHang(khbus.taoMaKh(), txtCMND.getText(), txtTen.getText(), gt, txtDiaChi.getText(),
							txtSdt.getText(), lblHienLkH.getText());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (kh != null) {
					try {
						int themKh = KhachHangServices.themKhachHang(kh);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
					}
				}
				HoaDonBus hdbus = new HoaDonBus();
				HoaDon hd = null;
				try {
					jdlDangNhap dn = new jdlDangNhap();
					double giamGia = 0;
					if (lblHienLkH.getText().equalsIgnoreCase("thân thiết")) {
						giamGia = 0.1;
					}
					hd = new HoaDon(hdbus.taoMahd(), dn.nv, kh, new Date(ngayThue.getDate().getTime()), giamGia, false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
				}
				if (hdbus != null) {
					try {
						int themHoaDon = HoaDonServices.themHoaDon(hd);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
					}
				}
				//Thue nhieu phong
				int themCTHD = 0;
				for (int i = 0; i < model2.size(); i++) {
					int vt = model2.getElementAt(i).toString().indexOf("-");
					String maPh = model2.getElementAt(i).toString().substring(0, vt);
					Phong ph = null;
					try {
						ph = PhongServices.layThongTinPhong(maPh);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
					}
					CT_HoaDon cthd = new CT_HoaDon(hd, ph, new Date(ngayThue.getDate().getTime()),
							new Date(ngayTra.getDate().getTime()));
					try {
						themCTHD = CT_HoaDonServices.themChiTietHD(cthd);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
					}
				}
				if (themCTHD > 0) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					xoaTrangDuLieu();
					
				}
			}

		} else if (o == btnChonPh) {

			List<String> selectedList = list_a.getSelectedValuesList();
			if (!selectedList.isEmpty()) {
				for (String se : selectedList) {

					model2.addElement(se);
					model1.removeElement(se);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Chưa chọn phòng cần thuê");
			}
			lblSoPh.setText(selectedList.size() + "");

		} else if (o == btnHuyPh) {

			List<String> selectedList = list_b.getSelectedValuesList();
			if (!selectedList.isEmpty()) {
				for (String se : selectedList) {
					model1.addElement(se);
					model2.removeElement(se);
				}
				lblSoPh.setText(model2.size() + "");
			} else {
				JOptionPane.showMessageDialog(this, "Không có phòng nào được chọn");
			}
		} else if (btnCheck == o) {
			KhachHang kh = null;
			try {
				if (txtCMND.getText().trim().length() == 9) {
					kh = KhachHangServices.xemThongTinKhachHangTheoThanThietCMND(txtCMND.getText());
					if (kh != null) {
						KhachHangBus khbus = new KhachHangBus();
						lblHienLkH.setText(khbus.thietLapKHThanThiet(kh));
						txtTen.setText(kh.getHoTen());
						txtDiaChi.setText(kh.getDiaChi());
						txtSdt.setText(kh.getSdt());
						if (kh.isGioiTinh()) {
							rdbNam.doClick();
						} else {
							rdbNu.doClick();
						}
					} else {
						lblHienLkH.setText("Thường");
						txtTen.setEditable(true);
						txtDiaChi.setEditable(true);
						txtSdt.setEditable(true);

						txtTen.setText("");
						txtDiaChi.setText("");
						txtSdt.setText("");
						
						txtTen.requestFocus();
					}
					btnCheck.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "Số CMND không được để trống, phải đủ 9 kí số!!!");
					txtCMND.requestFocus();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
			}
		} else if (o == btnHuy) {
			this.dispose();
		}

	}

	private void xoaTrangDuLieu() {
		model2.removeAllElements();
		lblHienLkH.setText("");
		ngayTra.setDate(new java.util.Date());
		txtCMND.setText("");
		txtSdt.setText("");
		txtDiaChi.setText("");
		txtTen.setText("");
		lblSoPh.setText("");
		
		txtTen.setEditable(false);
		txtDiaChi.setEditable(false);
		txtSdt.setEditable(false);
	
		

	}
}
