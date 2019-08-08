package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.main;
import model.NhanVienLeTan;

public class NhanVienServices {
	public static NhanVienLeTan layThongTinNhanVien(String username, String pass) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "select * from tbNhanVien where taiKhoan=? and matKhau=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, username);
		pre.setString(2, pass);
		ResultSet re = pre.executeQuery();
		
		if (re.next()) {
			return new NhanVienLeTan(re.getString(1), re.getString(2), re.getString(3), re.getString(4),
					re.getString(5), re.getDate(6), username, pass);
		}
		conn.close();
		return null;
	}
	public static NhanVienLeTan layThongTinNhanVien(String maNV) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "select * from tbNhanVien where maNV=?";
		PreparedStatement pre  = conn.prepareStatement(sql);
		pre.setString(1, maNV);
		ResultSet re = pre.executeQuery();
		if(re.next()) {
			return new NhanVienLeTan(re.getString(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5), re.getDate(6), re.getString(7),re.getString(8));
		}
		return null;
	}


}
