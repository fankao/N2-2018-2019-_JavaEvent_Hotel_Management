package model;

import java.io.Serializable;
import java.sql.Date;

public class CT_HoaDon implements Serializable{
	private HoaDon hoaDon;
	private Phong phong;
	private Date ngayDen,ngayDi;
	public CT_HoaDon(HoaDon hoaDon, Phong phong, Date ngayDen, Date ngayDi) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
	}
	
	public CT_HoaDon(HoaDon hoaDon, Date ngayDen, Date ngayDi) {
		super();
		this.hoaDon = hoaDon;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public Date getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}
	public Date getNgayDi() {
		return ngayDi;
	}
	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}
	
	
}
