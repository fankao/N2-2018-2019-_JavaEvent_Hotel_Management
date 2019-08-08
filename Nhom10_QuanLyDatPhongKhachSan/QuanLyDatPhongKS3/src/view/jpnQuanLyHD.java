package view;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ButtonGroup;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import bean.HoaDonDaThanhToan;
import dao.CT_HoaDonServices;
import dao.HoaDonServices;
import model.CT_HoaDon;
import model.HoaDon;

import javax.swing.DebugGraphics;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;

public class jpnQuanLyHD extends JPanel implements ActionListener {
	private JTable tbThongKe;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtKey;
	private JButton btnTim;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private ArrayList<HoaDon> listHD;
	private JButton btnReset;

	/**
	 * Create the panel.
	 */
	public jpnQuanLyHD() {

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE));

		JPanel pnTraCuu = new JPanel();

		JPanel pnBgThogKeHD = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnTraCuu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE)
						.addComponent(pnBgThogKeHD, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnTraCuu, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnBgThogKeHD, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnBgThogKeHD.setLayout(new BorderLayout(0, 0));

		JScrollPane scrTable = new JScrollPane();
		scrTable.setMinimumSize(new Dimension(30, 30));
		scrTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnBgThogKeHD.add(scrTable, BorderLayout.CENTER);

		tbThongKe = new JTable();
		tbThongKe.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tbThongKe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbThongKe.setRowHeight(30);
		tbThongKe.setMaximumSize(new Dimension(100, 30));
		tbThongKe.setFont(new Font("Arial", Font.PLAIN, 14));
		tbThongKe.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 H\u0110", "Ph\u00F2ng", "T\u00EAn kh\u00E1ch h\u00E0ng",
						"Ng\u00E0y thanh to\u00E1n", "Gi\u1EA3m gi\u00E1", "T\u1ED5ng ti\u1EC1n",
						"Tr\u1EA1ng th\u00E1i" }));
		scrTable.setViewportView(tbThongKe);

		JPanel pnTKTheoTuKhoa = new JPanel();
		pnTKTheoTuKhoa.setEnabled(false);
		pnTKTheoTuKhoa.setFont(new Font("Arial", Font.PLAIN, 13));
		GroupLayout gl_pnTraCuu = new GroupLayout(pnTraCuu);
		gl_pnTraCuu.setHorizontalGroup(
			gl_pnTraCuu.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnTraCuu.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnTKTheoTuKhoa, GroupLayout.PREFERRED_SIZE, 578, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(592, Short.MAX_VALUE))
		);
		gl_pnTraCuu.setVerticalGroup(
			gl_pnTraCuu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTraCuu.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnTKTheoTuKhoa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);

		txtKey = new JTextField();
		txtKey.setVerifyInputWhenFocusTarget(false);
		txtKey.setToolTipText("Nhập từ khoá...");
		txtKey.setFocusTraversalKeysEnabled(false);
		txtKey.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		txtKey.setColumns(30);

		btnTim = new JButton("");
		btnTim.setBackground(new Color(192, 192, 192));
		btnTim.setIcon(new ImageIcon(jpnQuanLyHD.class.getResource("/images/icons8-search-20.png")));
		btnTim.setSelectedIcon(null);

		btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(jpnQuanLyHD.class.getResource("/images/icons8-renew-16.png")));
		
		JLabel lblKey = new JLabel("Nhập mã phòng:");
		lblKey.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_pnTKTheoTuKhoa = new GroupLayout(pnTKTheoTuKhoa);
		gl_pnTKTheoTuKhoa.setHorizontalGroup(
			gl_pnTKTheoTuKhoa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTKTheoTuKhoa.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnTKTheoTuKhoa.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnTKTheoTuKhoa.createSequentialGroup()
							.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
							.addComponent(btnReset))
						.addComponent(txtKey, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
						.addComponent(lblKey))
					.addContainerGap())
		);
		gl_pnTKTheoTuKhoa.setVerticalGroup(
			gl_pnTKTheoTuKhoa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTKTheoTuKhoa.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKey)
					.addGap(13)
					.addComponent(txtKey, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnTKTheoTuKhoa.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnTKTheoTuKhoa.setLayout(gl_pnTKTheoTuKhoa);
		pnTraCuu.setLayout(gl_pnTraCuu);
		panel.setLayout(gl_panel);

		setLayout(groupLayout);
		try {
			listHD = HoaDonServices.layDSHoaDonDaThanhToan();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
		}
		hienDanhSachHoaDon();
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);

	}

	private void hienDanhSachHoaDon() {
		DefaultTableModel dt = ((DefaultTableModel) tbThongKe.getModel());
		dt.setRowCount(0);
		int i = 1;
		ArrayList<CT_HoaDon> dsct = null;
		try {
			for (HoaDon hd : listHD) {
				dsct = CT_HoaDonServices.layChiTietHoaDonDaThanhToan(hd.getMaHd());
				jpnKhachHang ctThue = new jpnKhachHang();
				dt.addRow(new Object[] { i, hd.getMaHd(), dsct.size(), hd.getKhachHang().getHoTen(),
						hd.getNgayThanhToan(), String.format("%.2f", hd.getGiamGia() * 100) + "%",
						HoaDonServices.thongTinHoaDon(hd.getMaHd()).getTongTien(),
						hd.isDaThanhToan() ? "Đã thanh toán" : "Chưa thanh toán" });
				i++;
			}
			tbThongKe.setModel(dt);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (btnTim == o) {
			if(!txtKey.getText().trim().equalsIgnoreCase("")) {
				hienThongTinHoaDonTimKiem();
			}
		} else if (btnReset == o) {
			hienDanhSachHoaDon();
		}
	}

	private void hienThongTinHoaDonTimKiem() {
		DefaultTableModel dt = ((DefaultTableModel) tbThongKe.getModel());
		dt.setRowCount(0);
		int i = 1;
		ArrayList<CT_HoaDon> dsct = null;
		try {

			for (HoaDon hd :listHD) {
				if (txtKey.getText().trim().equalsIgnoreCase(hd.getMaHd())) {
					dsct = CT_HoaDonServices.layChiTietHoaDonDaThanhToan(hd.getMaHd());
					dt.addRow(new Object[] { i, hd.getMaHd(), dsct.size(), hd.getKhachHang().getHoTen(),
							hd.getNgayThanhToan(), String.format("%.2f", hd.getGiamGia() * 100) + "%",
							HoaDonServices.thongTinHoaDon(hd.getMaHd()).getTongTien(),
							hd.isDaThanhToan() ? "Đã thanh toán" : "Chưa thanh toán" });
					i++;
				}
			}

			tbThongKe.setModel(dt);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Errors", JOptionPane.ERROR_MESSAGE);
		}

	}
}
