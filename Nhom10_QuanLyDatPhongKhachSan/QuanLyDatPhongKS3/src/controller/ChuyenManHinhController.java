package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bean.DanhMucBean;

import view.jpnKhachHang;
import view.jpnManHinhGioiThieu;
import view.jpnQuanLyHD;
import view.jpnThongTinNhanVien;
import view.jpnTrangChinh;

public class ChuyenManHinhController {
	private JPanel root;
	private String tenManHinh = "";
	private ArrayList<DanhMucBean> listItems = null;

	public ChuyenManHinhController(JPanel root) {
		super();
		this.root = root;
	}

	public void setView(JPanel pnItem, JLabel lblItem, JPanel pnChuyen) {
		tenManHinh = "TrangChu";
		pnItem.setBackground(new Color(96, 100, 191));
		lblItem.setBackground(new Color(96, 100, 191));

		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(pnChuyen);
		root.validate();
		root.repaint();
	}

	public void setEvent(ArrayList<DanhMucBean> listItem) {
		this.listItems = listItem;
		for (DanhMucBean item : listItem) {
			item.getPn().addMouseListener(new LabelEvent(item.getName(), item.getPn(), item.getLbl()));
		}

	}

	class LabelEvent implements MouseListener {
		private JPanel node;
		private String kind;
		private JPanel pnItem;
		private JLabel lblItem;

		public LabelEvent(String kind, JPanel pnItem, JLabel lblItem) {
			super();
			this.kind = kind;
			this.pnItem = pnItem;
			this.lblItem = lblItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			switch (kind) {
			case "TrangChu":
				node = new jpnTrangChinh();
				break;
			case "KhachHang":
				node = new jpnKhachHang();
				break;
			case "ThongKe":
				node = new jpnQuanLyHD();
				break;
			case "TTNhanVien":
				node = new jpnThongTinNhanVien();
				break;
			case "GioiThieu":
				node = new jpnManHinhGioiThieu() ;
				break;
			default:
				node = new jpnTrangChinh();
				break;
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangeBackground(kind);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			pnItem.setBackground(new Color(96, 100, 191));
			lblItem.setBackground(new Color(96, 100, 191));

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!tenManHinh.equalsIgnoreCase(kind)) {
				pnItem.setBackground(new Color(76, 175, 80));
				lblItem.setBackground(new Color(76, 175, 80));
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			tenManHinh = kind;
			pnItem.setBackground(new Color(96, 100, 191));
			lblItem.setBackground(new Color(96, 100, 191));

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private void setChangeBackground(String kind) {
		for (DanhMucBean item : listItems) {
			if (item.getName().equalsIgnoreCase(kind)) {
				item.getPn().setBackground(new Color(96, 100, 191));
				item.getLbl().setBackground(new Color(96, 100, 191));
			} else {
				item.getPn().setBackground(new Color(76, 175, 80));
				item.getLbl().setBackground(new Color(76, 175, 80));
			}
		}

	}

}
