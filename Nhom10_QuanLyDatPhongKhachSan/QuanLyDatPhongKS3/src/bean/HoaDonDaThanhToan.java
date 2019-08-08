package bean;

import model.HoaDon;

public class HoaDonDaThanhToan {
	private HoaDon hd;
	private double tongTien;
	public HoaDonDaThanhToan(HoaDon hd, double tongTien) {
		super();
		this.hd = hd;
		this.tongTien = tongTien;
	}
	public HoaDon getHd() {
		return hd;
	}
	public void setHd(HoaDon hd) {
		this.hd = hd;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
}
