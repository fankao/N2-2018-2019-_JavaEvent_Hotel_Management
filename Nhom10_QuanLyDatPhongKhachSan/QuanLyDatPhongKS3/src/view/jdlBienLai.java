package view;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class jdlBienLai extends JDialog implements ActionListener{
	public static JLabel lblThucThu;
	public static JLabel lblTen;
	public static JLabel lblHGiamGia;
	public static JLabel lblTongTien;
	public static JLabel lblNgayTra;
	public static JLabel lblNgayThue;
	public static JLabel lblHPhong;
	private JButton btnClose;
	public jdlBienLai() {
		setModal(true);
		setSize(566,612);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(SystemColor.menu);
		setLocationRelativeTo(null);
		JPanel pnHienTen = new JPanel();
		FlowLayout fl_pnHienTen = (FlowLayout) pnHienTen.getLayout();
		fl_pnHienTen.setAlignment(FlowLayout.LEADING);
		
		JPanel pnHienPhong = new JPanel();
		FlowLayout fl_pnHienPhong = (FlowLayout) pnHienPhong.getLayout();
		fl_pnHienPhong.setAlignment(FlowLayout.LEFT);
		
		JLabel lblSPhong = new JLabel("Phòng:");
		lblSPhong.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		pnHienPhong.add(lblSPhong);
		
		JPanel pnNgayDen = new JPanel();
		FlowLayout fl_pnNgayDen = (FlowLayout) pnNgayDen.getLayout();
		fl_pnNgayDen.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNgayn = new JLabel("Ngày Đến:");
		lblNgayn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		pnNgayDen.add(lblNgayn);
		
		JPanel pnNgayDi = new JPanel();
		FlowLayout fl_pnNgayDi = (FlowLayout) pnNgayDi.getLayout();
		fl_pnNgayDi.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNgayi = new JLabel("Ngày Đi:");
		lblNgayi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		pnNgayDi.add(lblNgayi);
		
		JPanel pnTien = new JPanel();
		FlowLayout fl_pnTien = (FlowLayout) pnTien.getLayout();
		fl_pnTien.setAlignment(FlowLayout.LEFT);
		
		JLabel lblTngTin = new JLabel("Tổng Tiền:");
		lblTngTin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		pnTien.add(lblTngTin);
		
		JPanel pnGiamGia = new JPanel();
		FlowLayout fl_pnGiamGia = (FlowLayout) pnGiamGia.getLayout();
		fl_pnGiamGia.setAlignment(FlowLayout.LEFT);
		
		JLabel lblGiamGia = new JLabel("Giảm Giá:");
		lblGiamGia.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		pnGiamGia.add(lblGiamGia);
		
		JPanel pnLabel = new JPanel();
		pnLabel.setBackground(new Color(153, 204, 204));
		
		JPanel pnThu = new JPanel();
		pnThu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FlowLayout fl_pnThu = (FlowLayout) pnThu.getLayout();
		fl_pnThu.setAlignment(FlowLayout.LEFT);
		
		JLabel lblThcThu = new JLabel("Thực Thu:");
		lblThcThu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		pnThu.add(lblThcThu);
		
		JLabel lblNewLabel_2 = new JLabel("VNĐ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btnClose = new JButton("Đóng");
		btnClose.setIcon(new ImageIcon(jdlBienLai.class.getResource("/images/icons8-confirm-30.png")));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClose.setBackground(Color.LIGHT_GRAY);
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panel_ten = new JPanel();
		
		lblTen = new JLabel("");
		lblTen.setHorizontalAlignment(SwingConstants.LEFT);
		lblTen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		panel_ten.add(lblTen);
		
		JPanel panel_soPhong = new JPanel();
		
		lblHPhong = new JLabel("");
		lblHPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lblHPhong.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		panel_soPhong.add(lblHPhong);
		
		JPanel panel_NgayDen = new JPanel();
		
		lblNgayThue = new JLabel("");
		lblNgayThue.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayThue.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		panel_NgayDen.add(lblNgayThue);
		
		JPanel panel_NgayDi = new JPanel();
		
		lblNgayTra = new JLabel("");
		lblNgayTra.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayTra.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		panel_NgayDi.add(lblNgayTra);
		
		JPanel panel_TongTien = new JPanel();
		
		lblTongTien = new JLabel("");
		lblTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongTien.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		panel_TongTien.add(lblTongTien);
		
		JPanel panel_GiamGia = new JPanel();
		
		lblHGiamGia = new JLabel("");
		lblHGiamGia.setHorizontalAlignment(SwingConstants.LEFT);
		lblHGiamGia.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		panel_GiamGia.add(lblHGiamGia);
		
		JPanel panel_ThucThu = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_ThucThu.getLayout();
		flowLayout.setVgap(3);
		panel_ThucThu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		lblThucThu = new JLabel("");
		lblThucThu.setHorizontalAlignment(SwingConstants.LEFT);
		lblThucThu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		panel_ThucThu.add(lblThucThu);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(168)
							.addComponent(btnClose))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(pnNgayDi, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(pnGiamGia, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(pnTien, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(pnThu, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addGap(36)))
								.addComponent(pnHienPhong, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnHienTen, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnNgayDen, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_ThucThu, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(panel_NgayDen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panel_soPhong, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panel_ten, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel_GiamGia, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
								.addComponent(panel_TongTien, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
								.addComponent(panel_NgayDi, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
							.addGap(33)
							.addComponent(lblNewLabel_2)))
					.addGap(67))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnLabel, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(pnLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnHienTen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(pnHienPhong, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(pnNgayDen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_ten, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(panel_soPhong, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_NgayDen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnNgayDi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_NgayDi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnTien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_TongTien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnGiamGia, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_GiamGia, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnThu, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_ThucThu, 0, 0, Short.MAX_VALUE))
					.addGap(50)
					.addComponent(btnClose)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("BIÊN LAI");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		pnLabel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Tên:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pnHienTen.add(lblNewLabel);
		getContentPane().setLayout(groupLayout);
		
		btnClose.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnClose) {
			this.dispose();
		}
		
	}
	

   
}

