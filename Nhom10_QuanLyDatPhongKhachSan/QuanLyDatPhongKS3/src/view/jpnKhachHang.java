package view;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.border.MatteBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import bean.HoaDonDaThanhToan;
import bus.HoaDonBus;
import dao.CT_HoaDonServices;
import dao.HoaDonServices;
import dao.KhachHangServices;
import dao.LoaiPhongServices;
import dao.PhongServices;
import model.CT_HoaDon;
import model.HoaDon;
import model.KhachHang;
import model.Phong;

import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import java.awt.Dimension;

public class jpnKhachHang extends JPanel implements ActionListener, MouseListener {
	private JTextField textField_1;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtTim;
	private JTextField txtMaKH;
	private JTextField txtCmnd;
	private JTextField txtDC;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTable tbDS;
	public static JTextField txtTongTien;
	public static JTextField txtGiamGia;
	public static JTextField txtThucThu;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtDonGia;
	private JButton btnLuu;
	private JButton btnCpNht;
	private JButton btnThanhTon;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnN;
	private JDateChooser NgayTra;
	private JDateChooser NgayThue;
	private JComboBox cbxPhongThue;
	private DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private SimpleDateFormat sfm = new SimpleDateFormat("dd/MM/yyyy");
	private double giamGia;
	private  double tienThucThu;
	private JButton btnTim;
	private JRadioButton rdbTen;
	private JRadioButton rdbCMND;
	private String loaiKH;
	private JButton btnReset;
	private  ArrayList<CT_HoaDon> cthd;
	private JLabel lblHienNg;

	private static ArrayList<Phong> listPh;

	/**
	 * Create the panel.
	 */
	public jpnKhachHang() {

		JPanel panelKhachHang = new JPanel();

		JPanel panelThongTinKhach = new JPanel();
		panelThongTinKhach.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JPanel panelThanhToan = new JPanel();
		panelThanhToan.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JPanel panelDanhSach = new JPanel();
		panelDanhSach.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JPanel panelThongTinPhongThue = new JPanel();
		panelThongTinPhongThue.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout gl_panelKhachHang = new GroupLayout(panelKhachHang);
		gl_panelKhachHang.setHorizontalGroup(gl_panelKhachHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelKhachHang.createSequentialGroup().addGroup(gl_panelKhachHang
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelKhachHang.createSequentialGroup()
								.addComponent(panelThongTinKhach, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
								.addGap(3).addComponent(panelThanhToan, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
						.addGroup(gl_panelKhachHang.createSequentialGroup()
								.addComponent(panelDanhSach, GroupLayout.PREFERRED_SIZE, 650, Short.MAX_VALUE).addGap(3)
								.addComponent(panelThongTinPhongThue, GroupLayout.PREFERRED_SIZE, 310,
										Short.MAX_VALUE)))
						.addGap(3)));
		gl_panelKhachHang
				.setVerticalGroup(gl_panelKhachHang.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelKhachHang.createSequentialGroup()
								.addGroup(gl_panelKhachHang.createParallelGroup(Alignment.LEADING)
										.addComponent(panelThanhToan, 0, 0, Short.MAX_VALUE)
										.addGroup(gl_panelKhachHang.createSequentialGroup()
												.addComponent(panelThongTinKhach, GroupLayout.DEFAULT_SIZE, 304,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGap(3)
								.addGroup(gl_panelKhachHang.createParallelGroup(Alignment.LEADING, false)
										.addComponent(panelDanhSach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(panelThongTinPhongThue, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

								.addContainerGap()));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(176, 196, 222));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 240));
		GroupLayout gl_panelThongTinPhongThue = new GroupLayout(panelThongTinPhongThue);
		gl_panelThongTinPhongThue.setHorizontalGroup(gl_panelThongTinPhongThue.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelThongTinPhongThue.createSequentialGroup().addGroup(gl_panelThongTinPhongThue
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelThongTinPhongThue.createSequentialGroup().addGap(2)
								.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE).addGap(1))
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 308, Short.MAX_VALUE)).addGap(0)));
		gl_panelThongTinPhongThue.setVerticalGroup(gl_panelThongTinPhongThue.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelThongTinPhongThue.createSequentialGroup()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE).addGap(1)
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE).addGap(1))

		);

		JPanel panelSoPhong = new JPanel();
		panelSoPhong.setBackground(new Color(255, 255, 240));

		JLabel lblSoPhong = new JLabel("Số Phòng:");
		lblSoPhong.setFont(new Font("Arial", Font.BOLD, 14));

		txtSoPhong = new JTextField();
		txtSoPhong.setEditable(false);
		txtSoPhong.setColumns(20);
		GroupLayout gl_panelSoPhong = new GroupLayout(panelSoPhong);
		gl_panelSoPhong.setHorizontalGroup(gl_panelSoPhong.createParallelGroup(Alignment.LEADING)
				.addGap(0, 285, Short.MAX_VALUE).addGap(0, 285, Short.MAX_VALUE)
				.addGroup(gl_panelSoPhong.createSequentialGroup()
						.addComponent(lblSoPhong, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtSoPhong, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)));
		gl_panelSoPhong.setVerticalGroup(gl_panelSoPhong.createParallelGroup(Alignment.LEADING)
				.addGap(0, 30, Short.MAX_VALUE).addGap(0, 30, Short.MAX_VALUE)
				.addComponent(txtSoPhong, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
				.addComponent(lblSoPhong, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE));
		panelSoPhong.setLayout(gl_panelSoPhong);

		JPanel panelLoaiPhong = new JPanel();
		panelLoaiPhong.setBackground(new Color(255, 255, 240));

		JLabel lblLoaiPhong = new JLabel("Loại Phòng:");
		lblLoaiPhong.setFont(new Font("Arial", Font.BOLD, 14));

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(20);
		GroupLayout gl_panelLoaiPhong = new GroupLayout(panelLoaiPhong);
		gl_panelLoaiPhong.setHorizontalGroup(gl_panelLoaiPhong.createParallelGroup(Alignment.LEADING)
				.addGap(0, 285, Short.MAX_VALUE).addGap(0, 285, Short.MAX_VALUE)
				.addGroup(gl_panelLoaiPhong.createSequentialGroup()
						.addComponent(lblLoaiPhong, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtLoaiPhong, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)));
		gl_panelLoaiPhong.setVerticalGroup(gl_panelLoaiPhong.createParallelGroup(Alignment.LEADING)
				.addGap(0, 30, Short.MAX_VALUE).addGap(0, 30, Short.MAX_VALUE)
				.addComponent(txtLoaiPhong, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
				.addComponent(lblLoaiPhong, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE));
		panelLoaiPhong.setLayout(gl_panelLoaiPhong);

		JPanel panelDonGia = new JPanel();
		panelDonGia.setBackground(new Color(255, 255, 240));

		JLabel lblDonGia = new JLabel("Đơn Giá");
		lblDonGia.setFont(new Font("Arial", Font.BOLD, 14));

		txtDonGia = new JTextField();
		txtDonGia.setEditable(false);
		txtDonGia.setColumns(20);
		GroupLayout gl_panelDonGia = new GroupLayout(panelDonGia);
		gl_panelDonGia.setHorizontalGroup(gl_panelDonGia.createParallelGroup(Alignment.LEADING)
				.addGap(0, 285, Short.MAX_VALUE).addGap(0, 285, Short.MAX_VALUE)
				.addGroup(gl_panelDonGia.createSequentialGroup()
						.addComponent(lblDonGia, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtDonGia, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)));
		gl_panelDonGia.setVerticalGroup(gl_panelDonGia.createParallelGroup(Alignment.LEADING)
				.addGap(0, 30, Short.MAX_VALUE).addGap(0, 30, Short.MAX_VALUE)
				.addComponent(txtDonGia, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
				.addComponent(lblDonGia, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE));
		panelDonGia.setLayout(gl_panelDonGia);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
								.addComponent(panelSoPhong, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
								.addComponent(panelLoaiPhong, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
								.addComponent(panelDonGia, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_7.setVerticalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup().addGap(30)
						.addComponent(panelSoPhong, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addGap(27)
						.addComponent(panelLoaiPhong, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addGap(26)
						.addComponent(panelDonGia, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addGap(108)));
		panel_7.setLayout(gl_panel_7);

		JLabel lblNewLabel_3 = new JLabel("Thông Tin Phòng Thuê");
		lblNewLabel_3.setBackground(new Color(176, 196, 222));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3,
				GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3,
				GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panel_3.setLayout(gl_panel_3);
		panelThongTinPhongThue.setLayout(gl_panelThongTinPhongThue);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 196, 222));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 240));
		GroupLayout gl_panelDanhSach = new GroupLayout(panelDanhSach);
		gl_panelDanhSach.setHorizontalGroup(gl_panelDanhSach.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDanhSach.createSequentialGroup()
						.addGroup(gl_panelDanhSach.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelDanhSach.createSequentialGroup().addGap(2).addComponent(panel_5,
										GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE))
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 649, Short.MAX_VALUE))
						.addGap(2)));
		gl_panelDanhSach.setVerticalGroup(gl_panelDanhSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDanhSach.createSequentialGroup()
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(2).addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)));

		JLabel lblTimKiem = new JLabel("Tìm Kiếm:");
		lblTimKiem.setFont(new Font("Arial", Font.BOLD, 14));

		txtTim = new JTextField();
		txtTim.setColumns(10);

		rdbTen = new JRadioButton("Theo Tên");
		buttonGroup.add(rdbTen);
		rdbTen.setFont(new Font("Arial", Font.BOLD, 14));
		rdbTen.setBackground(new Color(255, 255, 240));

		rdbCMND = new JRadioButton("Theo CMND");
		buttonGroup.add(rdbCMND);
		rdbCMND.setFont(new Font("Arial", Font.BOLD, 14));
		rdbCMND.setBackground(new Color(255, 255, 240));

		btnTim = new JButton("Tìm");
		btnTim.setEnabled(false);
		btnTim.setIcon(new ImageIcon(jpnKhachHang.class.getResource("/images/icons8-search-20.png")));
		btnTim.setFont(new Font("Arial", Font.BOLD, 14));

		JPanel panelTable = new JPanel();

		btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(jpnKhachHang.class.getResource("/images/icons8-renew-16.png")));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5.createSequentialGroup()
						.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE).addContainerGap())
						.addGroup(gl_panel_5.createSequentialGroup()
								.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_5.createSequentialGroup()
												.addComponent(txtTim, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 88,
														GroupLayout.PREFERRED_SIZE)
												.addGap(6)
												.addComponent(rdbTen, GroupLayout.PREFERRED_SIZE, 119,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbCMND,
														GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_5.createSequentialGroup()
												.addComponent(lblTimKiem, GroupLayout.DEFAULT_SIZE, 502,
														Short.MAX_VALUE)
												.addGap(109).addComponent(btnReset)))
								.addGap(37)))));
		gl_panel_5
				.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTimKiem, GroupLayout.PREFERRED_SIZE, 26,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnReset))
								.addGap(6)
								.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbCMND, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
										.addComponent(txtTim, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
										.addComponent(rdbTen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnTim, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGap(18)
								.addComponent(panelTable, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		panelTable.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelTable.add(scrollPane, BorderLayout.CENTER);

		tbDS = new JTable();
		tbDS.setRowHeight(25);

		tbDS.setFont(new Font("Arial", Font.PLAIN, 13));
		tbDS.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "M\u00E3 KH", "CMND",
				"H\u1ECD V\u00E0 T\u00EAn", "\u0110\u1ECBa Ch\u1EC9", "S\u0110T", "Lo\u1EA1i Kh\u00E1ch" }));
		scrollPane.setViewportView(tbDS);

		tbDS.getColumnModel().getColumn(0).setPreferredWidth(10);
		tbDS.getColumnModel().getColumn(1).setPreferredWidth(20);
		tbDS.getColumnModel().getColumn(2).setPreferredWidth(50);
		tbDS.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbDS.getColumnModel().getColumn(4).setPreferredWidth(100);
		tbDS.getColumnModel().getColumn(5).setPreferredWidth(40);
		tbDS.getColumnModel().getColumn(6).setPreferredWidth(50);
		tbDS.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		panel_5.setLayout(gl_panel_5);

		JLabel lblNewLabel_2 = new JLabel("Danh Sách Khách Hàng");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBackground(new Color(176, 196, 222));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_2,
				GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_2,
				GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE));
		panel_2.setLayout(gl_panel_2);
		panelDanhSach.setLayout(gl_panelDanhSach);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 196, 222));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 240));
		GroupLayout gl_panelThanhToan = new GroupLayout(panelThanhToan);
		gl_panelThanhToan.setHorizontalGroup(gl_panelThanhToan.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelThanhToan.createSequentialGroup()
						.addGroup(gl_panelThanhToan.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 317,
										Short.MAX_VALUE)
								.addGroup(gl_panelThanhToan.createSequentialGroup().addGap(2).addComponent(panel_6,
										GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
						.addGap(1)));
		gl_panelThanhToan.setVerticalGroup(gl_panelThanhToan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelThanhToan.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addGap(1)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 272, Short.MAX_VALUE).addGap(1)));

		JPanel panelPhongThue = new JPanel();
		panelPhongThue.setBackground(new Color(255, 255, 240));

		JPanel panelTongTien = new JPanel();
		panelTongTien.setBackground(new Color(255, 255, 240));

		JLabel lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setFont(new Font("Arial", Font.BOLD, 14));

		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTongTien.setColumns(10);
		GroupLayout gl_panelTongTien = new GroupLayout(panelTongTien);
		gl_panelTongTien.setHorizontalGroup(gl_panelTongTien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTongTien.createSequentialGroup()
						.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTongTien, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)));
		gl_panelTongTien.setVerticalGroup(gl_panelTongTien.createParallelGroup(Alignment.LEADING)
				.addComponent(txtTongTien, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
				.addComponent(lblTongTien, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE));
		panelTongTien.setLayout(gl_panelTongTien);

		JPanel panelGiamGia = new JPanel();
		panelGiamGia.setBackground(new Color(255, 255, 240));

		JLabel lblGiamGia = new JLabel("Giảm Giá:");
		lblGiamGia.setFont(new Font("Arial", Font.BOLD, 14));

		txtGiamGia = new JTextField();
		txtGiamGia.setEditable(false);
		txtGiamGia.setFont(new Font("Arial", Font.PLAIN, 15));
		txtGiamGia.setColumns(10);
		GroupLayout gl_panelGiamGia = new GroupLayout(panelGiamGia);
		gl_panelGiamGia.setHorizontalGroup(gl_panelGiamGia.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGiamGia.createSequentialGroup()
						.addComponent(lblGiamGia, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtGiamGia, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)));
		gl_panelGiamGia.setVerticalGroup(gl_panelGiamGia.createParallelGroup(Alignment.LEADING)
				.addComponent(txtGiamGia, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
				.addComponent(lblGiamGia, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE));
		panelGiamGia.setLayout(gl_panelGiamGia);

		JPanel panelThucThu = new JPanel();
		panelThucThu.setBackground(new Color(255, 255, 240));

		JLabel lblThucThu = new JLabel("Thực Thu:");
		lblThucThu.setFont(new Font("Arial", Font.BOLD, 14));

		txtThucThu = new JTextField();
		txtThucThu.setEditable(false);
		txtThucThu.setFont(new Font("Arial", Font.PLAIN, 15));
		txtThucThu.setColumns(10);
		GroupLayout gl_panelThucThu = new GroupLayout(panelThucThu);
		gl_panelThucThu.setHorizontalGroup(gl_panelThucThu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelThucThu.createSequentialGroup()
						.addComponent(lblThucThu, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtThucThu, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)));
		gl_panelThucThu.setVerticalGroup(gl_panelThucThu.createParallelGroup(Alignment.LEADING)
				.addComponent(txtThucThu, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
				.addComponent(lblThucThu, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE));
		panelThucThu.setLayout(gl_panelThucThu);

		btnThanhTon = new JButton("Thanh Toán");
		btnThanhTon.setEnabled(false);
		btnThanhTon.setIcon(new ImageIcon(jpnKhachHang.class.getResource("/images/icons8-paycheque-18.png")));
		btnThanhTon.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addComponent(panelTongTien, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
								.addComponent(panelGiamGia, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
								.addComponent(panelThucThu, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
								.addComponent(panelPhongThue, 0, 0, Short.MAX_VALUE))
						.addGap(10))
				.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup().addContainerGap(160, Short.MAX_VALUE)
						.addComponent(btnThanhTon).addContainerGap()));
		gl_panel_6.setVerticalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_6.createSequentialGroup().addContainerGap()
						.addComponent(panelPhongThue, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addGap(27)
						.addComponent(panelTongTien, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addGap(26)
						.addComponent(panelGiamGia, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addGap(27)
						.addComponent(panelThucThu, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addGap(18)
						.addComponent(btnThanhTon, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE).addGap(16)));

		JLabel lblPhongThue = new JLabel("Phòng Thuê:");
		lblPhongThue.setFont(new Font("Arial", Font.BOLD, 14));

		cbxPhongThue = new JComboBox();
		cbxPhongThue.setFont(new Font("Arial", Font.BOLD, 15));
		cbxPhongThue.setBackground(new Color(255, 255, 240));
		GroupLayout gl_panelPhongThue = new GroupLayout(panelPhongThue);
		gl_panelPhongThue.setHorizontalGroup(gl_panelPhongThue.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPhongThue.createSequentialGroup()
						.addComponent(lblPhongThue, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(cbxPhongThue, 0, 248, Short.MAX_VALUE)
						.addGap(0)));
		gl_panelPhongThue.setVerticalGroup(gl_panelPhongThue.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPhongThue.createSequentialGroup()
						.addGroup(gl_panelPhongThue.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPhongThue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 43,
										Short.MAX_VALUE)
								.addComponent(cbxPhongThue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 43,
										Short.MAX_VALUE))
						.addGap(0)));
		panelPhongThue.setLayout(gl_panelPhongThue);
		panel_6.setLayout(gl_panel_6);

		JLabel lblNewLabel_1 = new JLabel("Thanh Toán");
		lblNewLabel_1.setBackground(new Color(176, 196, 222));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE).addGap(0)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1,
				GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE));
		panel_1.setLayout(gl_panel_1);
		panelThanhToan.setLayout(gl_panelThanhToan);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 240));
		GroupLayout gl_panelThongTinKhach = new GroupLayout(panelThongTinKhach);
		gl_panelThongTinKhach.setHorizontalGroup(gl_panelThongTinKhach.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelThongTinKhach.createSequentialGroup()
						.addGroup(gl_panelThongTinKhach.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelThongTinKhach.createSequentialGroup().addGap(1).addComponent(panel_4,
										GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE))
						.addGap(1)));
		gl_panelThongTinKhach.setVerticalGroup(gl_panelThongTinKhach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelThongTinKhach.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(2).addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE).addGap(1)));

		JPanel panelMaKH = new JPanel();
		panelMaKH.setBackground(new Color(255, 255, 240));

		JPanel panelCMND = new JPanel();
		panelCMND.setBackground(new Color(255, 255, 240));

		JLabel lblCmnd = new JLabel("CMND:");
		lblCmnd.setFont(new Font("Arial", Font.BOLD, 14));

		txtCmnd = new JTextField();
		txtCmnd.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCmnd.setEditable(false);
		txtCmnd.setColumns(25);
		GroupLayout gl_panelCMND = new GroupLayout(panelCMND);
		gl_panelCMND
				.setHorizontalGroup(gl_panelCMND.createParallelGroup(Alignment.TRAILING).addGap(0, 280, Short.MAX_VALUE)
						.addGroup(gl_panelCMND.createSequentialGroup()
								.addComponent(lblCmnd, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtCmnd, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)));
		gl_panelCMND.setVerticalGroup(gl_panelCMND.createParallelGroup(Alignment.LEADING).addGap(0, 27, Short.MAX_VALUE)
				.addComponent(txtCmnd, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
				.addComponent(lblCmnd, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE));
		panelCMND.setLayout(gl_panelCMND);

		JPanel panelDiaChi = new JPanel();
		panelDiaChi.setBackground(new Color(255, 255, 240));

		JLabel lblDC = new JLabel("Địa Chỉ:");
		lblDC.setFont(new Font("Arial", Font.BOLD, 14));

		txtDC = new JTextField();
		txtDC.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDC.setEditable(false);
		txtDC.setColumns(10);
		GroupLayout gl_panelDiaChi = new GroupLayout(panelDiaChi);
		gl_panelDiaChi.setHorizontalGroup(
				gl_panelDiaChi.createParallelGroup(Alignment.TRAILING).addGap(0, 280, Short.MAX_VALUE)
						.addGroup(gl_panelDiaChi.createSequentialGroup()
								.addComponent(lblDC, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtDC, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)));
		gl_panelDiaChi.setVerticalGroup(gl_panelDiaChi.createParallelGroup(Alignment.LEADING)
				.addGap(0, 27, Short.MAX_VALUE).addComponent(txtDC, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
				.addComponent(lblDC, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE));
		panelDiaChi.setLayout(gl_panelDiaChi);

		JPanel panelNgayDen = new JPanel();
		panelNgayDen.setBackground(new Color(255, 255, 240));

		JLabel lblNgayDen = new JLabel("Ngày thuê:");
		lblNgayDen.setFont(new Font("Arial", Font.BOLD, 14));

		NgayThue = new JDateChooser();
		NgayThue.setEnabled(false);
		NgayThue.setDateFormatString("dd/MM/yyyy");
		GroupLayout gl_panelNgayDen = new GroupLayout(panelNgayDen);
		gl_panelNgayDen.setHorizontalGroup(gl_panelNgayDen.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNgayDen.createSequentialGroup()
						.addComponent(lblNgayDen, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(NgayThue, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)));
		gl_panelNgayDen.setVerticalGroup(gl_panelNgayDen.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNgayDen, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
				.addComponent(NgayThue, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE));
		panelNgayDen.setLayout(gl_panelNgayDen);

		JPanel panelTen = new JPanel();
		panelTen.setBackground(new Color(255, 255, 240));

		JLabel lblTen = new JLabel("Họ Và Tên:");
		lblTen.setFont(new Font("Arial", Font.BOLD, 14));

		txtTen = new JTextField();
		txtTen.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTen.setEditable(false);
		txtTen.setColumns(10);
		GroupLayout gl_panelTen = new GroupLayout(panelTen);
		gl_panelTen.setHorizontalGroup(gl_panelTen.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 280, Short.MAX_VALUE)
				.addGroup(gl_panelTen.createSequentialGroup()
						.addComponent(lblTen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTen, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)));
		gl_panelTen.setVerticalGroup(gl_panelTen.createParallelGroup(Alignment.LEADING).addGap(0, 27, Short.MAX_VALUE)
				.addComponent(txtTen, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
				.addComponent(lblTen, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE));
		panelTen.setLayout(gl_panelTen);

		JPanel panelSĐT = new JPanel();
		panelSĐT.setBackground(new Color(255, 255, 240));

		JLabel lblSdt = new JLabel("SĐT:");
		lblSdt.setFont(new Font("Arial", Font.BOLD, 14));

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		GroupLayout gl_panelSĐT = new GroupLayout(panelSĐT);
		gl_panelSĐT
				.setHorizontalGroup(gl_panelSĐT.createParallelGroup(Alignment.TRAILING).addGap(0, 280, Short.MAX_VALUE)
						.addGroup(gl_panelSĐT.createSequentialGroup()
								.addComponent(lblSdt, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtSDT, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)));
		gl_panelSĐT.setVerticalGroup(gl_panelSĐT.createParallelGroup(Alignment.LEADING).addGap(0, 27, Short.MAX_VALUE)
				.addComponent(txtSDT, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
				.addComponent(lblSdt, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE));
		panelSĐT.setLayout(gl_panelSĐT);

		JPanel panelGioiTinh = new JPanel();
		panelGioiTinh.setBackground(new Color(255, 255, 240));

		JLabel lblPhai = new JLabel("Giới Tính:");
		lblPhai.setFont(new Font("Arial", Font.BOLD, 14));

		rdbtnNam = new JRadioButton("Nam");
		buttonGroup.add(rdbtnNam);
		rdbtnNam.setBackground(new Color(255, 255, 240));
		rdbtnNam.setFont(new Font("Arial", Font.BOLD, 13));

		rdbtnN = new JRadioButton("Nữ");
		buttonGroup.add(rdbtnN);
		rdbtnN.setBackground(new Color(255, 255, 240));
		rdbtnN.setFont(new Font("Arial", Font.BOLD, 13));
		GroupLayout gl_panelGioiTinh = new GroupLayout(panelGioiTinh);
		gl_panelGioiTinh.setHorizontalGroup(gl_panelGioiTinh.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelGioiTinh.createSequentialGroup()
						.addComponent(lblPhai, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rdbtnNam, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE).addGap(26)
						.addComponent(rdbtnN, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE).addGap(61)));
		gl_panelGioiTinh
				.setVerticalGroup(gl_panelGioiTinh.createParallelGroup(Alignment.LEADING).addGap(0, 27, Short.MAX_VALUE)
						.addGroup(gl_panelGioiTinh.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPhai, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
								.addComponent(rdbtnNam).addComponent(rdbtnN)));
		panelGioiTinh.setLayout(gl_panelGioiTinh);

		btnCpNht = new JButton("Cập Nhật");
		btnCpNht.setIcon(new ImageIcon(jpnKhachHang.class.getResource("/images/icons8-update-18.png")));
		btnCpNht.setFont(new Font("Arial", Font.BOLD, 14));

		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setIcon(new ImageIcon(jpnKhachHang.class.getResource("/images/icons8-save-as-18.png")));
		btnLuu.setFont(new Font("Arial", Font.BOLD, 14));

		JPanel panelNgayTra = new JPanel();
		panelNgayTra.setBackground(new Color(255, 255, 240));

		JLabel lblNgayTra = new JLabel("Ngày Trả:");
		lblNgayTra.setFont(new Font("Arial", Font.BOLD, 14));

		NgayTra = new JDateChooser();
		NgayTra.setDateFormatString("dd/MM/yyyy");
		GroupLayout gl_panelNgayTra = new GroupLayout(panelNgayTra);
		gl_panelNgayTra.setHorizontalGroup(
				gl_panelNgayTra.createParallelGroup(Alignment.TRAILING).addGap(0, 280, Short.MAX_VALUE)
						.addGroup(gl_panelNgayTra.createSequentialGroup()
								.addComponent(lblNgayTra, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(NgayTra, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)));
		gl_panelNgayTra.setVerticalGroup(gl_panelNgayTra.createParallelGroup(Alignment.LEADING)
				.addGap(0, 29, Short.MAX_VALUE).addComponent(NgayTra, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
				.addComponent(lblNgayTra, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE));
		panelNgayTra.setLayout(gl_panelNgayTra);

		JLabel lblTg = new JLabel("Số ngày đã ở:");
		lblTg.setFont(new Font("Arial", Font.BOLD, 14));

		lblHienNg = new JLabel("");
		lblHienNg.setHorizontalAlignment(SwingConstants.CENTER);
		lblHienNg.setForeground(new Color(128, 0, 0));
		lblHienNg.setFont(new Font("Arial", Font.BOLD, 16));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(lblTg, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblHienNg, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelNgayDen, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
						.addComponent(panelMaKH, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
						.addComponent(panelCMND, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
						.addComponent(panelDiaChi, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
				.addGap(48)
				.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelGioiTinh, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
						.addComponent(panelSĐT, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
						.addComponent(panelTen, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
						.addGroup(gl_panel_4.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
								.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(btnCpNht))
						.addComponent(panelNgayTra, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
				.addGap(28)));
		gl_panel_4
				.setVerticalGroup(
						gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
												.addComponent(panelMaKH, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
												.addComponent(panelTen, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
										.addGap(28)
										.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
												.addComponent(panelCMND, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
												.addComponent(panelSĐT, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
										.addGap(26)
										.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
												.addComponent(panelDiaChi, GroupLayout.DEFAULT_SIZE, 41,
														Short.MAX_VALUE)
												.addComponent(panelGioiTinh, GroupLayout.DEFAULT_SIZE, 41,
														Short.MAX_VALUE))
										.addGap(26)
										.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
												.addComponent(panelNgayDen, GroupLayout.DEFAULT_SIZE, 43,
														Short.MAX_VALUE)
												.addComponent(panelNgayTra, GroupLayout.DEFAULT_SIZE, 43,
														Short.MAX_VALUE))
										.addGap(26)
										.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
												.addComponent(btnCpNht, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
												.addComponent(btnLuu, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
												.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblTg, GroupLayout.PREFERRED_SIZE, 41,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblHienNg, GroupLayout.PREFERRED_SIZE, 43,
																GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));

		JLabel lblMaKH = new JLabel("Mã KH:");
		lblMaKH.setFont(new Font("Arial", Font.BOLD, 14));

		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMaKH.setEditable(false);
		txtMaKH.setColumns(10);
		GroupLayout gl_panelMaKH = new GroupLayout(panelMaKH);
		gl_panelMaKH.setHorizontalGroup(gl_panelMaKH.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panelMaKH.createSequentialGroup()
						.addComponent(lblMaKH, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtMaKH, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)));
		gl_panelMaKH.setVerticalGroup(gl_panelMaKH.createParallelGroup(Alignment.LEADING)
				.addComponent(txtMaKH, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
				.addComponent(lblMaKH, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelMaKH.setLayout(gl_panelMaKH);
		panel_4.setLayout(gl_panel_4);

		JLabel lblNewLabel = new JLabel("Thông Tin Khách Hàng");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(176, 224, 230));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE).addGap(1)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel,
				GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panel.setLayout(gl_panel);
		panelThongTinKhach.setLayout(gl_panelThongTinKhach);
		panelKhachHang.setLayout(gl_panelKhachHang);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Theo Tên");
		rdbtnNewRadioButton.setBackground(UIManager.getColor("inactiveCaption"));
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 12));

		JRadioButton rdbtnCmnd = new JRadioButton("CMND");
		rdbtnCmnd.setBackground(UIManager.getColor("inactiveCaption"));
		rdbtnCmnd.setFont(new Font("Arial", Font.BOLD, 12));

		JRadioButton rdbtnTheoPhng = new JRadioButton("Theo Phòng");
		rdbtnTheoPhng.setBackground(UIManager.getColor("inactiveCaption"));
		rdbtnTheoPhng.setFont(new Font("Arial", Font.BOLD, 12));

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panelKhachHang, GroupLayout.PREFERRED_SIZE, 966, Short.MAX_VALUE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panelKhachHang,
				GroupLayout.PREFERRED_SIZE, 623, Short.MAX_VALUE));
		tbDS.addMouseListener(this);
		cbxPhongThue.addActionListener(this);
		btnCpNht.addActionListener(this);
		btnTim.addActionListener(this);
		btnThanhTon.addActionListener(this);
		btnReset.addActionListener(this);
		rdbCMND.addActionListener(this);
		rdbTen.addActionListener(this);
		btnLuu.addActionListener(this);

		try {
			hienDanhSachKhachHang();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
		}

		setLayout(groupLayout);

	}

	private void hienDanhSachKhachHang() throws Exception {
		DefaultTableModel tbModel = (DefaultTableModel) tbDS.getModel();
		tbModel.setRowCount(0);
		int i = 1;
		for (KhachHang khs : KhachHangServices.xemDanhSachKhachHang()) {
			if (!HoaDonServices.layThongTinHDTheoMaKH(khs.getMaKH()).isDaThanhToan()) {
				tbModel.addRow(

						new Object[] { i, khs.getMaKH(), khs.getCMND(), khs.getHoTen(), khs.getDiaChi(), khs.getSdt(),
								khs.getLoaiKhach() });
				i++;
			}
		}

	}

	private boolean validata() {
		// TODO Auto-generated method stub
		
		String ten = txtTen.getText().trim();
		String diaChi = txtDC.getText().trim();
		String sDT = txtSDT.getText().trim();
		SimpleDateFormat sfm = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (NgayTra.getDate().before(NgayThue.getDate())) {
			JOptionPane.showMessageDialog(null, "Ngày trả phòng phải sau ngày thuê phòng mặc định là ngày thuê!!!");
			return false;
		}
		if (!(diaChi.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!!!");
			txtDC.requestFocus();
			return false;
		}
		if (!(diaChi.matches("[\\w ]{1,30}"))) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không chứa kí tự đặc biệt và không quá 30 kí tự!!!");
			txtDC.requestFocus();
			txtDC.selectAll();
			return false;
		}
		if (!(ten.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng 'không được để trống!!!");
			txtTen.requestFocus();
			return false;
		}
		if (!(ten.matches("[A-Z][a-zA-z ]{0,30}"))) {
			JOptionPane.showMessageDialog(null,
					"Tên không chứa chữ số và bắt đầu bằng chữa hoa và không quá 30 kí tự !!!");
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		}

		if (!(sDT.length() > 0)) {
			JOptionPane.showMessageDialog(null, "SĐT không được để trống!!!");
			txtSDT.requestFocus();
			return false;
		}
		if (!(sDT.matches("(\\+84|0)[0-9]{9}"))) {
			JOptionPane.showMessageDialog(null, "STĐ bắt đầu phải là +84 hoặc 0 và có 10 số!!!");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == cbxPhongThue) {
			try {
				if (cbxPhongThue.getSelectedItem() != null) {
					String tt = cbxPhongThue.getSelectedItem().toString();
					Phong ph = PhongServices.layThongTinPhong(tt);
					txtSoPhong.setText(ph.getSoPhong());
					txtLoaiPhong.setText(ph.getLoaiPhong().getTenLoaiPhong());
					txtDonGia.setText(ph.getLoaiPhong().getDonGia() + "");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Lỗi CSDL", "SQL Errors", JOptionPane.ERROR_MESSAGE);

			}
		} else if (btnLuu == o) {

			if(validata()) {
				boolean gt = false;
				if (rdbtnNam.isSelected()) {
					gt = true;
				}

				KhachHang kh = null;
				try {
					kh = new KhachHang(txtMaKH.getText(), txtCmnd.getText(), txtTen.getText(), gt, txtDC.getText(),
							txtSDT.getText(), loaiKH);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "Lỗi CSDL", "SQL Errors", JOptionPane.ERROR_MESSAGE);
				}
				if (kh != null) {
					try {
						int suaKH = KhachHangServices.capNhatKhachHang(kh);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, "Lỗi CSDL", "SQL Errors", JOptionPane.ERROR_MESSAGE);
					}
				}
				int suaCTHD = 0;
				try {
					suaCTHD = CT_HoaDonServices
							.capNhatCTHoaDon(new CT_HoaDon(HoaDonServices.layThongTinHDTheoMaKH(kh.getMaKH()),
									new Date(NgayThue.getDate().getTime()), new Date(NgayTra.getDate().getTime())));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "Lỗi CSDL", "SQL Errors", JOptionPane.ERROR_MESSAGE);
				}
				if (suaCTHD > 0) {
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					try {
						hienDanhSachKhachHang();
						hienChiTietKH(kh.getMaKH());
						btnLuu.setEnabled(false);
						txtDC.setEditable(false);
						txtSDT.setEditable(false);
						txtTen.setEditable(false);
					} catch (Exception e1) {

						JOptionPane.showMessageDialog(this, "Lỗi CSDL", "SQL Errors", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		} else if (o == btnCpNht) {
			btnLuu.setEnabled(true);
			txtDC.setEditable(true);
			txtSDT.setEditable(true);
			txtTen.setEditable(true);
			txtCmnd.requestFocus();

		} else if (o == btnThanhTon) {
			if (JOptionPane.showConfirmDialog(null, "Xác nhận thanh toán", "Thanh toán",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				try {
					HoaDon hd = new HoaDon(HoaDonServices.layThongTinHDTheoMaKH(txtMaKH.getText()).getMaHd(),
							new jdlDangNhap().nv, KhachHangServices.xemThongTinKhachHangTheoMa(txtMaKH.getText()),
							new Date(new java.util.Date().getTime()), giamGia, true);
					int capnhatHD = HoaDonServices.capNhatHoaDonThanhToan(hd);
					int themTTHD = HoaDonServices
							.themThongTinHoaDonTT(new HoaDonDaThanhToan(hd, Double.parseDouble(txtThucThu.getText())));

					int themCTHoaDonTT = 0;
					int xoa = 0;
					for (CT_HoaDon ct : CT_HoaDonServices.layChiTietHoaDon(hd.getMaHd())) {
						themCTHoaDonTT = CT_HoaDonServices.luuCTHoaDonDaThanhToan(ct);
						if (themCTHoaDonTT > 0) {
							xoa = CT_HoaDonServices.xoaCTHoaDon(ct);
						}
					}

					if (xoa > 0) {
						jdlBienLai bienLai = new jdlBienLai();
						bienLai.lblTen.setText(txtTen.getText());
						String DsPh = "";
						for (CT_HoaDon ct : CT_HoaDonServices.layChiTietHoaDonDaThanhToan(hd.getMaHd())) {
							DsPh += ct.getPhong().getSoPhong() + ",";
						}
						bienLai.lblHPhong.setText(DsPh);
						bienLai.lblNgayThue.setText(sfm.format(NgayThue.getDate()));
						bienLai.lblNgayTra.setText(sfm.format(NgayTra.getDate()));
						bienLai.lblTongTien.setText(txtTongTien.getText());
						bienLai.lblHGiamGia.setText(txtGiamGia.getText());
						bienLai.lblThucThu.setText(txtThucThu.getText());
						bienLai.setVisible(true);

						if (bienLai.isDisplayable() == false) {
							JOptionPane.showMessageDialog(null, "Thanh toán thành công");
							this.removeAll();
							this.setLayout(new BorderLayout());
							this.add(new jpnKhachHang());
							this.validate();
							this.repaint();
						}

					}
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(this, e2.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
				}

			}
		} else if (o == btnReset) {
			try {
				hienDanhSachKhachHang();
				this.removeAll();
				this.setLayout(new BorderLayout());
				this.add(new jpnKhachHang());
				this.validate();
				this.repaint();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Lỗi CSDL");
			}
		} else if (btnTim == o) {
			try {
				hienThongTinTimKiem(txtTim.getText(), rdbCMND.isSelected());
			} catch (Exception e1) {
				
				
				JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
			}
		} else if (rdbTen == o) {
			btnTim.setEnabled(true);

		} else if (rdbCMND == o) {
			btnTim.setEnabled(true);
		}
	}

	private void hienThongTinTimKiem(String text, boolean selected) throws Exception {
		DefaultTableModel tbModel = (DefaultTableModel) tbDS.getModel();
		tbModel.setRowCount(0);
		int i = 1;
		if (selected) {
			for (KhachHang khs : KhachHangServices.timKiemTheoCMND(text)) {
				if (!HoaDonServices.layThongTinHDTheoMaKH(khs.getMaKH()).isDaThanhToan()) {
					tbModel.addRow(

							new Object[] { i, khs.getMaKH(), khs.getCMND(), khs.getHoTen(), khs.getDiaChi(),
									khs.getSdt(), khs.getLoaiKhach() });
					i++;
				}
			}
		} else {
			for (KhachHang khs : KhachHangServices.timKiemTenKH(text)) {
				if (!HoaDonServices.layThongTinHDTheoMaKH(khs.getMaKH()).isDaThanhToan()) {
					tbModel.addRow(

							new Object[] { i, khs.getMaKH(), khs.getCMND(), khs.getHoTen(), khs.getDiaChi(),
									khs.getSdt(), khs.getLoaiKhach() });
					i++;
				}
			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int selRow = tbDS.getSelectedRow();
		if (selRow == -1)
			return;
		try {
			String maKh = tbDS.getValueAt(selRow, 1).toString();
			hienChiTietKH(maKh);
			btnThanhTon.setEnabled(true);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void hienChiTietKH(String ma) throws Exception {
		KhachHang kh = KhachHangServices.xemThongTinKhachHangTheoMa(ma);
		txtMaKH.setText(kh.getMaKH());
		txtCmnd.setText(kh.getCMND());
		txtTen.setText(kh.getHoTen());
		txtDC.setText(kh.getDiaChi());
		txtSDT.setText(kh.getSdt());
		loaiKH = kh.getLoaiKhach();

		if (kh.isGioiTinh()) {
			rdbtnNam.doClick();
		} else {
			rdbtnN.doClick();
		}
		HoaDon hd = HoaDonServices.layThongTinHDTheoMaKH(kh.getMaKH());
		giamGia = hd.getGiamGia();

		hienThiThongTinThue(hd.getMaHd());

	}

	public void hienThiThongTinThue(String mahd) throws Exception {

		double tienPhDoi, tienPhDon, donGiaPhDoi = 0, donGiaPhDon = 0;
		int demPhDoi = 0, demPhDon = 0;
		DefaultComboBoxModel<String> cbModel = (DefaultComboBoxModel<String>) cbxPhongThue.getModel();
		cbModel.removeAllElements();

		for (CT_HoaDon ct : CT_HoaDonServices.layChiTietHoaDon(mahd)) {
			cbModel.addElement(ct.getPhong().getSoPhong());
			if (ct.getPhong().getLoaiPhong().getTenLoaiPhong().equalsIgnoreCase("phòng đơn")) {
				demPhDon++;
				donGiaPhDon = ct.getPhong().getLoaiPhong().getDonGia();
			} else {
				demPhDoi++;
				donGiaPhDoi = ct.getPhong().getLoaiPhong().getDonGia();
			}
			NgayThue.setDate(ct.getNgayDen());
			NgayTra.setDate(ct.getNgayDi());

		}
		tienPhDoi = (double) demPhDoi * donGiaPhDoi;

		tienPhDon = (double) demPhDon * donGiaPhDon;
		double tongTien = 0;
		int soNgay = 0;
		if (LocalDate.now().isEqual(LocalDate.parse(sfm.format(NgayThue.getDate()), dfm))) {
			tongTien = tienPhDoi + tienPhDon;
			soNgay = 1;
		} else {
			Period khoangTg = Period.between(LocalDate.parse(sfm.format(NgayThue.getDate()), dfm), LocalDate.now());
			soNgay = khoangTg.getDays();
			tongTien = soNgay * (tienPhDoi + tienPhDon);
		}
		lblHienNg.setText(soNgay + "");

		txtTongTien.setText(tongTien + "");
		double tienGiamGia = Math.round(tongTien * giamGia);

		txtGiamGia.setText(tienGiamGia + "");
		tienThucThu = tongTien - tienGiamGia;
		txtThucThu.setText(tienThucThu + "");

		cbxPhongThue.setModel(cbModel);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
