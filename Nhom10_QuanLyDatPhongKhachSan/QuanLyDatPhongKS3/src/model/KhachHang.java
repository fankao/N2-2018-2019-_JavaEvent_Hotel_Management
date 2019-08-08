package model;

import java.io.Serializable;
import java.util.ArrayList;

public class KhachHang implements Serializable{
	private String maKH;
	private String CMND;
	private String hoTen;
	private boolean gioiTinh;
	private String diaChi;
	private String sdt;
	private String loaiKhach;
	
	public KhachHang(String maKH) {
		this.maKH = maKH;
	}

	public KhachHang(String maKH, String cMND, String hoTen, boolean gioiTinh, String diaChi, String sdt,
			String loaiKhach) {
		super();
		this.maKH = maKH;
		CMND = cMND;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.loaiKhach = loaiKhach;
	}

	public KhachHang() {
		super();
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getLoaiKhach() {
		return loaiKhach;
	}
	public void setLoaiKhach(String loaiKhach) {
		this.loaiKhach = loaiKhach;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CMND == null) ? 0 : CMND.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (CMND == null) {
			if (other.CMND != null)
				return false;
		} else if (!CMND.equals(other.CMND))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
