package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class HoaDon implements Serializable {
	private String maHd;
	private NhanVienLeTan nhanVien;
	private KhachHang khachHang;
	private Date ngayThanhToan;
	private double giamGia;
	private boolean daThanhToan;

	public HoaDon(String maHd, NhanVienLeTan nhanVien, KhachHang khachHang, Date ngayThanhToan, double giamGia,
			boolean daThanhToan) {
		super();
		this.maHd = maHd;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayThanhToan = ngayThanhToan;
		this.giamGia = giamGia;
		this.daThanhToan = daThanhToan;
	}
	

	public HoaDon(String maHd, NhanVienLeTan nhanVien, KhachHang khachHang) {
		super();
		this.maHd = maHd;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}


	public String getMaHd() {
		return maHd;
	}

	public void setMaHd(String maHd) {
		this.maHd = maHd;
	}

	public NhanVienLeTan getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVienLeTan nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public boolean isDaThanhToan() {
		return daThanhToan;
	}

	public void setDaThanhToan(boolean daThanhToan) {
		this.daThanhToan = daThanhToan;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
