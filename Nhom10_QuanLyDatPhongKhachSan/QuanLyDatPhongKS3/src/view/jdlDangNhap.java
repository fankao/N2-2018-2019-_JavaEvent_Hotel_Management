package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhanVienServices;
import model.NhanVienLeTan;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class jdlDangNhap extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	public static JPasswordField txtPass;
	public static JTextField txtTaiKhoan;
	private JButton btnLogin, btnCancel;
	private JLabel pnTbao;
	public static NhanVienLeTan nv;

	public static void main(String[] args) {

		try {
			jdlDangNhap dialog = new jdlDangNhap();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
	}

	/**
	 * Create the dialog.
	 */
	public jdlDangNhap() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(jdlDangNhap.class.getResource("/images/icons8-hotel-star-32.png")));
		setTitle("Đăng nhập hệ thống\r\n");
		setSize(882, 412);
		setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel pnLogin = new JPanel();
		pnTbao = new JLabel("");
		pnTbao.setFont(new Font("Arial", Font.BOLD, 14));
		pnTbao.setForeground(new Color(255, 0, 0));
		pnTbao.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setFont(new Font("Arial", Font.BOLD, 18));
		JLabel lblPass = new JLabel("Mật khẩu:");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Arial", Font.BOLD, 18));
		btnLogin = new JButton("Đăng nhập");

		btnLogin.setIcon(new ImageIcon(jdlDangNhap.class.getResource("/images/icons8-enter-32.png")));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 18));
		btnCancel = new JButton("Thoát");
		btnCancel.setIcon(new ImageIcon(jdlDangNhap.class.getResource("/images/icons8-cancel-32.png")));
		btnCancel.setFont(new Font("Arial", Font.BOLD, 18));
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Arial", Font.PLAIN, 18));
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtPass.setColumns(16);
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Arial", Font.BOLD, 18));
		txtTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		txtTaiKhoan.setColumns(35);
		JLabel pnTitle = new JLabel("Đăng nhập hệ thống");
		pnTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pnTitle.setFont(new Font("Arial", Font.BOLD, 22));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(jdlDangNhap.class.getResource("/images/user (4).png")));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(jdlDangNhap.class.getResource("/images/padlock (1).png")));
		GroupLayout gl_pnLogin = new GroupLayout(pnLogin);
		gl_pnLogin.setHorizontalGroup(gl_pnLogin.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnLogin
				.createSequentialGroup().addGap(27)
				.addGroup(gl_pnLogin
						.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel).addComponent(label))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING)
						.addComponent(pnTbao, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addComponent(pnTitle, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_pnLogin.createSequentialGroup().addGap(41)
								.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE).addGap(18)
								.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE).addGap(28))
						.addGroup(gl_pnLogin.createSequentialGroup()
								.addGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblPass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblTaiKhoan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGap(32)
								.addGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING, false).addComponent(txtPass)
										.addComponent(txtTaiKhoan, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGap(10)));
		gl_pnLogin.setVerticalGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING).addGroup(gl_pnLogin
				.createSequentialGroup().addGap(23)
				.addGroup(gl_pnLogin.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnLogin.createSequentialGroup()
						.addComponent(pnTitle, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addGap(29)
						.addGroup(gl_pnLogin.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTaiKhoan, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTaiKhoan, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnLogin.createSequentialGroup().addGap(43)
								.addGroup(gl_pnLogin.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnLogin.createSequentialGroup().addGap(34).addComponent(label,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
				.addComponent(pnTbao, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_pnLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(24, Short.MAX_VALUE)));
		pnLogin.setLayout(gl_pnLogin);
		JPanel pnLogo = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addComponent(pnLogo, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnLogin, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(pnLogo, GroupLayout.PREFERRED_SIZE, 370, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addComponent(pnLogin, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(jdlDangNhap.class.getResource("/images/2.png")));
		GroupLayout gl_pnLogo = new GroupLayout(pnLogo);
		gl_pnLogo.setHorizontalGroup(gl_pnLogo.createParallelGroup(Alignment.LEADING).addComponent(lblLogo,
				GroupLayout.PREFERRED_SIZE, 283, Short.MAX_VALUE));
		gl_pnLogo.setVerticalGroup(gl_pnLogo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLogo.createSequentialGroup()
						.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnLogo.setLayout(gl_pnLogo);
		contentPanel.setLayout(gl_contentPanel);
		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnLogin) {

			try {
				NhanVienLeTan login = NhanVienServices.layThongTinNhanVien(txtTaiKhoan.getText(), txtPass.getText());
				if (login != null) {
					this.dispose();
					frmMain frame = new frmMain();
					frmMain.lblTaiKhoan.setText(login.getTenNV());
					nv = login;
					frame.setVisible(true);

				} else {
					pnTbao.setText("Đăng nhập không thành công kiểm tra lại tài khoản,mật khẩu");
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Lỗi CSDL");
			}

		} else if (o == btnCancel) {
			System.exit(0);
		}
	}
}
