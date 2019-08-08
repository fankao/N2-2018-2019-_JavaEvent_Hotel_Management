package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Phong implements Serializable{
	private String soPhong;
	private boolean tinhTrang;
	private LoaiPhong loaiPhong;
	public Phong(String soPhong, Boolean tinhTrang, LoaiPhong loaiPhong) {
		super();
		this.soPhong = soPhong;
		this.tinhTrang = tinhTrang;
		this.loaiPhong = loaiPhong;
		
		
	}
	
	public Phong(String soPhong) {
		super();
		this.soPhong = soPhong;
	}

	public String getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	
	



}
