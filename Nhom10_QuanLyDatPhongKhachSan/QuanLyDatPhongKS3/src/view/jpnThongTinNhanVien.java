package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.NhanVienServices;
import model.NhanVienLeTan;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class jpnThongTinNhanVien extends JPanel implements ActionListener{
	private JLabel lblTen;
	private JLabel lblHienDc;
	private JLabel lblHienSdt;
	private JLabel lblHienNgvLm;
	private JLabel lblHienCM;
	private JPanel panelUser;
	private  JButton btnLogout;

	/**
	 * Create the panel.
	 */
	public jpnThongTinNhanVien() {
		
		JPanel panelUser = new JPanel();
		panelUser.setBackground(new Color(230, 230, 250));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelUser, GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelUser, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
		);
		
		JPanel lblAnh = new JPanel();
		lblAnh.setBackground(new Color(230, 230, 250));
		
		btnLogout = new JButton("Đăng Xuất");
		btnLogout.setIcon(new ImageIcon(jpnThongTinNhanVien.class.getResource("/images/icons8-import-20.png")));
		btnLogout.setBackground(new Color(230, 230, 250));
		btnLogout.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel pnThogTin = new JPanel();
		GroupLayout gl_panelUser = new GroupLayout(panelUser);
		gl_panelUser.setHorizontalGroup(
			gl_panelUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUser.createSequentialGroup()
					.addGap(400)
					.addComponent(lblAnh, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addGap(400))
				.addGroup(Alignment.TRAILING, gl_panelUser.createSequentialGroup()
					.addGap(220)
					.addComponent(pnThogTin, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
					.addGap(220))
				.addGroup(Alignment.TRAILING, gl_panelUser.createSequentialGroup()
					.addGap(432)
					.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addGap(432))
		);
		gl_panelUser.setVerticalGroup(
			gl_panelUser.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelUser.createSequentialGroup()
					.addGap(39)
					.addComponent(lblAnh, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addGap(40)
					.addComponent(pnThogTin, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		lblTen = new JLabel("");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(128, 0, 0));
		lblTen.setFont(new Font("Arial", Font.BOLD, 23));
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblsdt = new JLabel("Số điện Thoại:");
		lblsdt.setHorizontalAlignment(SwingConstants.CENTER);
		lblsdt.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNgayLam = new JLabel("Ngày vào làm:");
		lblNgayLam.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgayLam.setFont(new Font("Arial", Font.BOLD, 14));
		
		lblHienDc = new JLabel("");
		lblHienDc.setForeground(new Color(72, 61, 139));
		lblHienDc.setFont(new Font("Arial", Font.BOLD, 14));
		
		lblHienSdt = new JLabel("");
		lblHienSdt.setForeground(new Color(72, 61, 139));
		lblHienSdt.setFont(new Font("Arial", Font.BOLD, 14));
		
		lblHienNgvLm = new JLabel("");
		lblHienNgvLm.setForeground(new Color(72, 61, 139));
		lblHienNgvLm.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("Số CMND:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		lblHienCM = new JLabel("");
		lblHienCM.setForeground(new Color(72, 61, 139));
		lblHienCM.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout gl_pnThogTin = new GroupLayout(pnThogTin);
		gl_pnThogTin.setHorizontalGroup(
			gl_pnThogTin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnThogTin.createSequentialGroup()
					.addGap(108)
					.addGroup(gl_pnThogTin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnThogTin.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(84)
							.addComponent(lblHienCM, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
						.addGroup(gl_pnThogTin.createSequentialGroup()
							.addGroup(gl_pnThogTin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDiaChi)
								.addComponent(lblsdt)
								.addComponent(lblNgayLam))
							.addGap(54)
							.addGroup(gl_pnThogTin.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblHienNgvLm, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
								.addComponent(lblHienDc, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
								.addComponent(lblHienSdt, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))))
					.addContainerGap())
				.addGroup(gl_pnThogTin.createSequentialGroup()
					.addGap(142)
					.addComponent(lblTen, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
					.addGap(145))
		);
		gl_pnThogTin.setVerticalGroup(
			gl_pnThogTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThogTin.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTen, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pnThogTin.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblHienCM, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_pnThogTin.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDiaChi)
						.addComponent(lblHienDc, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_pnThogTin.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblsdt)
						.addComponent(lblHienSdt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_pnThogTin.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNgayLam)
						.addComponent(lblHienNgvLm, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		pnThogTin.setLayout(gl_pnThogTin);
		lblAnh.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(new ImageIcon(jpnThongTinNhanVien.class.getResource("/images/icons8-administrator-male-200.png")));
		lblAnh.add(lblIcon, BorderLayout.CENTER);
		panelUser.setLayout(gl_panelUser);
		hienThongTinNhanVien();
		setLayout(groupLayout);
		
		btnLogout.addActionListener(this);
	}

	private void hienThongTinNhanVien() {
		jdlDangNhap login = new jdlDangNhap();
		try {
			jdlDangNhap dn = new jdlDangNhap();
			NhanVienLeTan nv = login.nv;
			if(nv!=null) {
				lblHienCM.setText(nv.getCMND());
				lblTen.setText(nv.getTenNV());
				lblHienSdt.setText(nv.getSDT());
				lblHienDc.setText(nv.getDiaChi());
				lblHienNgvLm.setText(new SimpleDateFormat("dd/MM/yyyy").format(nv.getNgayVaoLam()));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất ?","Đăng xuất",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			((Window) getRootPane().getParent()).dispose();
			new jdlDangNhap().setVisible(true);
		}	
	}
}
