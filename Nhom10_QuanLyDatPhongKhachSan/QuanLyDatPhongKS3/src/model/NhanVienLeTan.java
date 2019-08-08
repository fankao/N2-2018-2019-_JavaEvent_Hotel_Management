package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class NhanVienLeTan implements Serializable {
	private String maNV;
	private String tenNV;
	private String CMND;
	private String diaChi;
	private String SDT;
	private Date ngayVaoLam;
	private String taiKhoan;
	private String matKhau;
	public NhanVienLeTan(String maNV, String tenNV, String cMND, String diaChi, String sDT, Date ngayVaoLam,
			String taiKhoan, String matKhau) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		CMND = cMND;
		this.diaChi = diaChi;
		SDT = sDT;
		this.ngayVaoLam = ngayVaoLam;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	public NhanVienLeTan() {
		super();
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	
	
}
