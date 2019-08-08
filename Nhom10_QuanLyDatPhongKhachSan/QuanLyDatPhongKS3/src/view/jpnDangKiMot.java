package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import com.toedter.calendar.JYearChooser;

import bus.HoaDonBus;
import bus.KhachHangBus;
import controller.ChuyenManHinhController;
import dao.CT_HoaDonServices;
import dao.HoaDonServices;
import dao.KhachHangServices;
import dao.NhanVienServices;
import dao.PhongServices;
import model.CT_HoaDon;
import model.HoaDon;
import model.KhachHang;
import model.Phong;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class jpnDangKiMot extends JDialog implements  ActionListener {

	private JPanel contentPane;
	private JButton btnLuu;
	private JButton btnThoat;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCMND;
	private JTextField txtDC;
	private JTextField txtSdt;
	private JTable tbDaSa;
	private JDateChooser ngayThue;
	private JDateChooser ngayTra;
	private JTextField txtTen;
	private JButton btnReset;
	private JRadioButton rdbNu;
	private JRadioButton rdbNam;
	private JButton btnCheck;
	private JComboBox cbSoPhong;
	private JLabel lblHienGia;
	private JLabel lblPloai;
	private static DecimalFormat df = new DecimalFormat("#,### VNĐ");
	public jpnDangKiMot() {
		setTitle("Thuê Phòng");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(jpnDangKiMot.class.getResource("/images/icons8-hotel-star-32.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1035, 762);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setModalityType(DEFAULT_MODALITY_TYPE);
		JPanel pnChiTietThuePhong = new JPanel();
		pnChiTietThuePhong.setBorder(new TitledBorder(null, "Chi ti\u1EBFt thu\u00EA ph\u00F2ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JPanel pnThongTinKhachHang = new JPanel();
		pnThongTinKhachHang.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel pnChucNang = new JPanel();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 127));

		JPanel pnDanhSach = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1027,
												Short.MAX_VALUE)
										.addComponent(pnChiTietThuePhong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												1027, Short.MAX_VALUE))
								.addGap(0))
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup()
										.addComponent(pnThongTinKhachHang, GroupLayout.PREFERRED_SIZE, 1015,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(pnChucNang, GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
										.addComponent(pnDanhSach, GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE))
								.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnChiTietThuePhong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnThongTinKhachHang, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnDanhSach, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(pnChucNang,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		pnDanhSach.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pnDanhSach.add(scrollPane, BorderLayout.CENTER);

		tbDaSa = new JTable();
		tbDaSa.setRowHeight(20);

		tbDaSa.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "M\u00E3 KH", "CMND",
				"H\u1ECD v\u00E0 t\u00EAn", "\u0110\u1ECBa ch\u1EC9", "S\u0110T" }));
		tbDaSa.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane.setViewportView(tbDaSa);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JLabel lblThuPhng = new JLabel("THUÊ PHÒNG");
		lblThuPhng.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblThuPhng);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(jpnDangKiMot.class.getResource("/images/icons8-save-as-18.png")));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(jpnDangKiMot.class.getResource("/images/icons8-cancel-18.png")));
		GroupLayout gl_pnChucNang = new GroupLayout(pnChucNang);
		gl_pnChucNang.setHorizontalGroup(gl_pnChucNang.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnChucNang.createSequentialGroup().addContainerGap(685, Short.MAX_VALUE)
						.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE).addGap(63)
						.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_pnChucNang.setVerticalGroup(gl_pnChucNang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChucNang.createSequentialGroup()
						.addGroup(gl_pnChucNang.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnChucNang.setLayout(gl_pnChucNang);

		JLabel lblCMND = new JLabel("số CMND");
		lblCMND.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblTen = new JLabel("Họ tên");
		lblTen.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 14));

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCMND.setColumns(10);

		txtTen = new JTextField();
		txtTen.setEditable(false);
		txtTen.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTen.setColumns(10);

		rdbNam = new JRadioButton("Nam");
		rdbNam.setSelected(true);
		buttonGroup.add(rdbNam);

		rdbNu = new JRadioButton("Nữ");
		buttonGroup.add(rdbNu);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 14));

		txtDC = new JTextField();
		txtDC.setEditable(false);
		txtDC.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDC.setColumns(10);

		JLabel lblSdt = new JLabel("Số điện thoại");
		lblSdt.setFont(new Font("Arial", Font.BOLD, 14));

		txtSdt = new JTextField();
		txtSdt.setEditable(false);
		txtSdt.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSdt.setColumns(10);

		JLabel lblpLoaiKH = new JLabel("Phân loại khách");
		lblpLoaiKH.setFont(new Font("Arial", Font.BOLD, 14));

		lblPloai = new JLabel("");
		lblPloai.setForeground(new Color(165, 42, 42));
		lblPloai.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));

		btnReset = new JButton("Làm mới");
		btnReset.setIcon(new ImageIcon(jpnDangKiMot.class.getResource("/images/icons8-renew-16.png")));

		btnCheck = new JButton("Check");
		btnCheck.setIcon(new ImageIcon(jpnDangKiMot.class.getResource("/images/icons8-checkmark-16.png")));
		GroupLayout gl_pnThongTinKhachHang = new GroupLayout(pnThongTinKhachHang);
		gl_pnThongTinKhachHang.setHorizontalGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThongTinKhachHang.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCMND, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTen, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGap(54)
						.addGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnThongTinKhachHang.createSequentialGroup().addComponent(rdbNam).addGap(40)
										.addComponent(rdbNu)
										.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
										.addComponent(btnReset))
								.addComponent(txtCMND, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
								.addComponent(txtTen, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
						.addGap(42)
						.addGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSdt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblpLoaiKH, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING,
										gl_pnThongTinKhachHang.createSequentialGroup().addGap(2)
												.addComponent(lblPloai, GroupLayout.PREFERRED_SIZE, 112,
														GroupLayout.PREFERRED_SIZE)
												.addGap(38).addComponent(btnCheck).addContainerGap())
								.addGroup(Alignment.LEADING, gl_pnThongTinKhachHang.createSequentialGroup()
										.addGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, 337,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtDC, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 337,
														GroupLayout.PREFERRED_SIZE))
										.addContainerGap()))));
		gl_pnThongTinKhachHang.setVerticalGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThongTinKhachHang.createSequentialGroup().addGap(28)
						.addGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCMND, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCMND, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDC, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(37)
						.addGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSdt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(34)
						.addGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnThongTinKhachHang.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbNam).addComponent(rdbNu).addComponent(btnReset)
										.addComponent(lblpLoaiKH, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCheck))
								.addComponent(lblPloai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(32, Short.MAX_VALUE)));
		pnThongTinKhachHang.setLayout(gl_pnThongTinKhachHang);

		JLabel lblSoPhong = new JLabel("Số phòng");
		lblSoPhong.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblNgayThue = new JLabel("Ngày thuê");
		lblNgayThue.setFont(new Font("Arial", Font.BOLD, 14));

		cbSoPhong = new JComboBox();
		cbSoPhong.setModel(new DefaultComboBoxModel(new String[] { "-- Chọn phòng --" }));

		ngayThue = new JDateChooser();
		ngayThue.setDateFormatString("dd/MM/yyyy");

		JLabel lblGia = new JLabel("Giá");
		lblGia.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblNgyTrD = new JLabel("Ngày trả( dự kiến)");
		lblNgyTrD.setFont(new Font("Arial", Font.BOLD, 14));

		ngayTra = new JDateChooser();
		ngayTra.setDateFormatString("dd/MM/yyyy");

		lblHienGia = new JLabel("");
		lblHienGia.setForeground(new Color(220, 20, 60));
		lblHienGia.setHorizontalAlignment(SwingConstants.CENTER);
		lblHienGia.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		GroupLayout gl_pnChiTietThuePhong = new GroupLayout(pnChiTietThuePhong);
		gl_pnChiTietThuePhong
				.setHorizontalGroup(gl_pnChiTietThuePhong.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnChiTietThuePhong.createSequentialGroup().addContainerGap()
								.addGroup(gl_pnChiTietThuePhong.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNgayThue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblSoPhong, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
								.addGap(60)
								.addGroup(gl_pnChiTietThuePhong.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cbSoPhong, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(ngayThue, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
								.addGroup(gl_pnChiTietThuePhong.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNgyTrD).addComponent(lblGia, GroupLayout.PREFERRED_SIZE, 104,
												GroupLayout.PREFERRED_SIZE))
								.addGap(29)
								.addGroup(gl_pnChiTietThuePhong.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblHienGia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(ngayTra, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
								.addGap(46)));
		gl_pnChiTietThuePhong.setVerticalGroup(gl_pnChiTietThuePhong.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnChiTietThuePhong.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnChiTietThuePhong.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSoPhong, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbSoPhong, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGia, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHienGia, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
						.addGroup(gl_pnChiTietThuePhong.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnChiTietThuePhong.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNgyTrD, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNgayThue, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(ngayTra, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(ngayThue, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(36)));
		pnChiTietThuePhong.setLayout(gl_pnChiTietThuePhong);
		contentPane.setLayout(gl_contentPane);

		try {
			hienThiDanhSachPhongTrong();
			hienThiDanhSachKhachThue();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
		}
		ngayThue.setDate(new java.util.Date());
		ngayTra.setDate(new java.util.Date());
		cbSoPhong.addActionListener(this);
		btnLuu.addActionListener(this);
		btnCheck.addActionListener(this);
		btnReset.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	
	private void hienThiDanhSachPhongTrong() throws Exception {
		DefaultComboBoxModel cbModel = (DefaultComboBoxModel) cbSoPhong.getModel();
		cbModel.removeAllElements();
		cbModel.addElement("-- Chọn phòng --");
		for (Phong ph : PhongServices.layDanhSachPhong()) {
			if (ph.isTinhTrang() == false) {
				cbModel.addElement(ph.getSoPhong() + "-" + ph.getLoaiPhong().getTenLoaiPhong());
			}
		}
		cbSoPhong.setModel(cbModel);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == cbSoPhong) {
			if (cbSoPhong.getSelectedIndex() == -1 || cbSoPhong.getSelectedIndex() == 0)
				return;

			try {
				int vt = cbSoPhong.getSelectedItem().toString().indexOf("-");
				String maPh = cbSoPhong.getSelectedItem().toString().substring(0, vt);

				lblHienGia.setText(df.format(PhongServices.layThongTinPhong(maPh).getLoaiPhong().getDonGia()));

			} catch (Exception e1) {

				JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
			}

		} else if (o == btnLuu) {
			if (cbSoPhong.getSelectedIndex() == -1 || cbSoPhong.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Chưa chọn phòng");
				return;
			}

			
				if (validata()) {
					KhachHangBus khbus = new KhachHangBus();
					boolean gt = rdbNam.isSelected();
					if (!gt) {
						gt = false;
					}
					KhachHang kh = null;
					try {
						kh = new KhachHang(khbus.taoMaKh(), txtCMND.getText(), txtTen.getText(), gt,
								txtDC.getText(), txtSdt.getText(), lblPloai.getText());
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e2.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
					}
					if (kh != null) {
						try {
							int themKh = KhachHangServices.themKhachHang(kh);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
						}
					}
					HoaDonBus hdbus = new HoaDonBus();
					HoaDon hd = null;
					try {
						jdlDangNhap dn = new jdlDangNhap();
						double giamGia = 0;
						if (lblPloai.getText().equalsIgnoreCase("thân thiết")) {
							giamGia = 0.1;
						}
						hd = new HoaDon(hdbus.taoMahd(), dn.nv, kh, new Date(ngayTra.getDate().getTime()), giamGia,
								false);
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
					int vt = cbSoPhong.getSelectedItem().toString().indexOf("-");
					String maPh = cbSoPhong.getSelectedItem().toString().substring(0, vt);
					Phong ph= null;
					try {
						ph = PhongServices.layThongTinPhong(maPh);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					CT_HoaDon cthd = new CT_HoaDon(hd, ph, new Date(ngayThue.getDate().getTime()),
							new Date(ngayTra.getDate().getTime()));
					int themCTHD=0;
					try {
						themCTHD = CT_HoaDonServices.themChiTietHD(cthd);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Lỗi CSDL");
					}
					if (themCTHD > 0) {

						try {
							hienThiDanhSachKhachThue();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(this, e1.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công");
					}
				}

			

		} else if (btnCheck == o) {
			KhachHang kh = null;

			try {
				if (txtCMND.getText().trim().length() == 9) {
					kh = KhachHangServices.xemThongTinKhachHangTheoThanThietCMND(txtCMND.getText());
					if (kh != null) {
						KhachHangBus khbus = new KhachHangBus();
						lblPloai.setText(khbus.thietLapKHThanThiet(kh));
						txtTen.setText(kh.getHoTen());
						txtDC.setText(kh.getDiaChi());
						txtSdt.setText(kh.getSdt());
						if (kh.isGioiTinh()) {
							rdbNam.doClick();
						} else {
							rdbNu.doClick();
						}
					} else {
						lblPloai.setText("Thường");
						txtTen.setEditable(true);
						txtDC.setEditable(true);
						txtSdt.setEditable(true);

						txtTen.setText("");
						txtDC.setText("");
						txtSdt.setText("");

						txtTen.requestFocus();
						
					}
					btnCheck.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "Số CMND không được để trống, phải đủ 9 số!!!");
					txtCMND.requestFocus();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Lỗi CSDL");
			}

		} else if (btnThoat == o) {
			this.dispose();

		} else if (btnReset == o) {
			cbSoPhong.setSelectedIndex(0);
			lblHienGia.setText("");
			txtTen.setText("");
			txtCMND.setText("");
			txtDC.setText("");
			txtSdt.setText("");
			lblPloai.setText("");
			txtTen.setEditable(false);
			txtDC.setEditable(false);
			txtSdt.setEditable(false);
			btnCheck.setEnabled(true);
			try {
				hienThiDanhSachPhongTrong();
				hienThiDanhSachKhachThue();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Lỗi CSDL");
			}

		}

	}

	private boolean validata() {
		// TODO Auto-generated method stub
		String cMND = txtCMND.getText().trim();
		String ten = txtTen.getText().trim();
		String diaChi = txtDC.getText().trim();
		String sDT = txtSdt.getText().trim();
		String loaiKH = lblPloai.getText().trim();
		SimpleDateFormat sfm = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if(!LocalDate.parse(sfm.format(ngayThue.getDate()), dfm).isEqual(LocalDate.now())){
			JOptionPane.showMessageDialog(null,"Ngày thuê phải là ngày hiện tại!!!!");
			return false;
		}
		if (ngayTra.getDate().before(ngayThue.getDate())) {
			JOptionPane.showMessageDialog(null, "Ngày trả phòng phải sau ngày thuê phòng mặc định là ngày thuê!!!");
			return false;
		}
		if (!(cMND.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Số CMND không được để trống!!!");
			txtCMND.requestFocus();
			return false;
		}
		if (!(cMND.matches("[0-9]{9}"))) {
			JOptionPane.showMessageDialog(null, "Số CMND bao gồm 9 chữ số từ 0 đến 9!!!");
			txtCMND.requestFocus();
			txtCMND.selectAll();
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

		if (!(sDT.length() > 0)) {
			JOptionPane.showMessageDialog(null, "SĐT không được để trống!!!");
			txtSdt.requestFocus();
			return false;
		}
		if (!(sDT.matches("(\\+84|0)[0-9]{9}"))) {
			JOptionPane.showMessageDialog(null, "STĐ bắt đầu phải là +84 hoặc 0 và có 10 số!!!");
			txtSdt.requestFocus();
			txtSdt.selectAll();
			return false;
		}
		if (!(loaiKH.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Chưa phân loại khách hàng");
			btnCheck.requestFocus();
			return false;
		}
		return true;
	}

	
	private void hienThiDanhSachKhachThue() throws Exception {
		DefaultTableModel tbModel = (DefaultTableModel) tbDaSa.getModel();
		tbModel.setRowCount(0);
		int i = 1;
		for (KhachHang khs : KhachHangServices.xemDanhSachKhachHang()) {
			if (!HoaDonServices.layThongTinHDTheoMaKH(khs.getMaKH()).isDaThanhToan()) {
				tbModel.addRow(

						new Object[] { i, khs.getMaKH(), khs.getCMND(), khs.getHoTen(), khs.getDiaChi(),
								khs.getSdt() });
				i++;
			}
		}

	}

	
}
