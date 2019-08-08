package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import java.util.ArrayList;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class frmMain extends JFrame{

	public JPanel contentPane;
	public JLabel lblTrangChu;
	public JPanel pnTaiKhoan;
	public static JLabel lblTaiKhoan;
	public static frmMain frame;
	public static JLabel lblNgay;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new frmMain();
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
	public frmMain() {

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(frmMain.class.getResource("/images/icons8-hotel-star-32.png")));

		setTitle("Qu\u1EA3n l\u00FD th\u00F4ng tin \u0111\u1EB7t ph\u00F2ng kh\u00E1ch s\u1EA1n");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 738);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JPanel pnMenu = new JPanel();
		pnMenu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192),
				new Color(192, 192, 192), new Color(192, 192, 192)));
		pnMenu.setBackground(new Color(240, 255, 255));

		JPanel pnTrangChinh = new JPanel();
		pnTrangChinh.setBorder(new EmptyBorder(0, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) pnTrangChinh.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		pnTrangChinh.setBackground(new Color(240, 240, 240));

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBackground(new Color(51, 204, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(pnMenu, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnTrangChinh, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE).addContainerGap())
				.addComponent(pnTieuDe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1282, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(3)
				.addComponent(
						pnTieuDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnMenu, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
						.addComponent(pnTrangChinh, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
				.addContainerGap()));

		JLabel lblLogo = new JLabel("QUẢN LÝ THÔNG TIN ĐẶT PHÒNG KHÁCH SẠN");
		lblLogo.setIcon(new ImageIcon(frmMain.class.getResource("/images/icons8-room-40.png")));
		lblLogo.setForeground(new Color(255, 255, 240));
		lblLogo.setFont(new Font("Arial", Font.BOLD, 19));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);

		pnTaiKhoan = new JPanel();
		pnTaiKhoan.setBackground(new Color(50, 205, 50));
		
		lblNgay = new JLabel("");
		lblNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_pnTieuDe = new GroupLayout(pnTieuDe);
		gl_pnTieuDe.setHorizontalGroup(
			gl_pnTieuDe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTieuDe.createSequentialGroup()
					.addGap(32)
					.addComponent(lblLogo)
					.addGap(138)
					.addComponent(lblNgay, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
					.addComponent(pnTaiKhoan, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_pnTieuDe.setVerticalGroup(
			gl_pnTieuDe.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnTieuDe.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnTieuDe.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNgay, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(pnTaiKhoan, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
						.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);

		lblTaiKhoan = new JLabel("");
		lblTaiKhoan.setForeground(new Color(255, 255, 240));
		lblTaiKhoan.setFont(new Font("Arial", Font.BOLD, 13));
		lblTaiKhoan.setIcon(new ImageIcon(frmMain.class.getResource("/images/icons8-businessman-20.png")));
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_pnTaiKhoan = new GroupLayout(pnTaiKhoan);
		gl_pnTaiKhoan.setHorizontalGroup(
			gl_pnTaiKhoan.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTaiKhoan, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
		);
		gl_pnTaiKhoan.setVerticalGroup(
			gl_pnTaiKhoan.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTaiKhoan, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
		);
		pnTaiKhoan.setLayout(gl_pnTaiKhoan);
		pnTieuDe.setLayout(gl_pnTieuDe);

		JPanel pnTrangChu = new JPanel();
		pnTrangChu.setBackground(new Color(96, 100, 191));

		JPanel pnQlKhach = new JPanel();
		pnQlKhach.setBackground(new Color(76, 175, 80));

		JPanel pnThongKe = new JPanel();
		pnThongKe.setBackground(new Color(76, 175, 80));

		JPanel pnGThieu = new JPanel();
		pnGThieu.setBackground(new Color(76, 175, 80));
		GroupLayout gl_pnMenu = new GroupLayout(pnMenu);
		gl_pnMenu.setHorizontalGroup(gl_pnMenu.createParallelGroup(Alignment.LEADING).addGroup(gl_pnMenu
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnMenu.createParallelGroup(Alignment.LEADING)
						.addComponent(pnGThieu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
						.addComponent(pnTrangChu, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
						.addComponent(pnQlKhach, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
						.addComponent(pnThongKe, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
				.addContainerGap()));
		gl_pnMenu.setVerticalGroup(gl_pnMenu.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_pnMenu.createSequentialGroup().addGap(21)
						.addComponent(pnTrangChu, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(pnQlKhach, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(pnThongKe, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
						.addComponent(pnGThieu, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JLabel lblGThieu = new JLabel("Giới thiệu");
		lblGThieu.setIcon(new ImageIcon(frmMain.class.getResource("/images/icons8-about-63.png")));
		lblGThieu.setForeground(Color.WHITE);
		lblGThieu.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGThieu.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_pnGThieu = new GroupLayout(pnGThieu);
		gl_pnGThieu.setHorizontalGroup(gl_pnGThieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnGThieu.createSequentialGroup()
						.addComponent(lblGThieu, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(62, Short.MAX_VALUE)));
		gl_pnGThieu.setVerticalGroup(
				gl_pnGThieu.createParallelGroup(Alignment.LEADING).addGroup(gl_pnGThieu.createSequentialGroup()
						.addComponent(lblGThieu, GroupLayout.PREFERRED_SIZE, 61, Short.MAX_VALUE).addContainerGap()));
		pnGThieu.setLayout(gl_pnGThieu);

		JLabel lblThongKe = new JLabel("Thống kê hoá đơn");
		lblThongKe.setIcon(new ImageIcon(frmMain.class.getResource("/images/icons8-invoice-64.png")));
		lblThongKe.setForeground(Color.WHITE);
		lblThongKe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_pnThongKe = new GroupLayout(pnThongKe);
		gl_pnThongKe.setHorizontalGroup(gl_pnThongKe.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_pnThongKe.createSequentialGroup().addContainerGap()
						.addComponent(lblThongKe, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE).addContainerGap()));
		gl_pnThongKe.setVerticalGroup(
				gl_pnThongKe.createParallelGroup(Alignment.LEADING).addGroup(gl_pnThongKe.createSequentialGroup()
						.addComponent(lblThongKe).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnThongKe.setLayout(gl_pnThongKe);

		JLabel lblQlKhachHang = new JLabel("Quản lý khách hàng");
		lblQlKhachHang.setIcon(new ImageIcon(frmMain.class.getResource("/images/icons8-conference-64.png")));
		lblQlKhachHang.setForeground(Color.WHITE);
		lblQlKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQlKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_pnQlKhach = new GroupLayout(pnQlKhach);
		gl_pnQlKhach.setHorizontalGroup(gl_pnQlKhach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnQlKhach.createSequentialGroup().addContainerGap()
						.addComponent(lblQlKhachHang, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
						.addContainerGap()));
		gl_pnQlKhach.setVerticalGroup(
				gl_pnQlKhach.createParallelGroup(Alignment.LEADING).addGroup(gl_pnQlKhach.createSequentialGroup()
						.addComponent(lblQlKhachHang).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnQlKhach.setLayout(gl_pnQlKhach);

		lblTrangChu = new JLabel("Trang chủ");
		lblTrangChu.setIcon(new ImageIcon(frmMain.class.getResource("/images/icons8-home-64.png")));
		lblTrangChu.setForeground(Color.WHITE);
		lblTrangChu.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_pnTrangChu = new GroupLayout(pnTrangChu);
		gl_pnTrangChu
				.setHorizontalGroup(gl_pnTrangChu.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_pnTrangChu.createSequentialGroup()
								.addComponent(lblTrangChu, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(80, Short.MAX_VALUE)));
		gl_pnTrangChu.setVerticalGroup(
				gl_pnTrangChu.createParallelGroup(Alignment.LEADING).addGroup(gl_pnTrangChu.createSequentialGroup()
						.addComponent(lblTrangChu).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnTrangChu.setLayout(gl_pnTrangChu);
		pnMenu.setLayout(gl_pnMenu);
		contentPane.setLayout(gl_contentPane);

		ChuyenManHinhController controller = new ChuyenManHinhController(pnTrangChinh);
		controller.setView(pnTrangChu, lblTrangChu, new jpnTrangChinh());

		ArrayList<DanhMucBean> listItem = new ArrayList<DanhMucBean>();
		listItem.add(new DanhMucBean("TrangChu", pnTrangChu, lblTrangChu));
		listItem.add(new DanhMucBean("KhachHang", pnQlKhach, lblQlKhachHang));
		listItem.add(new DanhMucBean("ThongKe", pnThongKe, lblThongKe));
		listItem.add(new DanhMucBean("GioiThieu", pnGThieu, lblGThieu));
		listItem.add(new DanhMucBean("TTNhanVien", pnTaiKhoan, lblTaiKhoan));
		controller.setEvent(listItem);
		
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ngayHienTai = dfm.format(LocalDate.now());
		lblNgay.setText(ngayHienTai);
		
	}
}
