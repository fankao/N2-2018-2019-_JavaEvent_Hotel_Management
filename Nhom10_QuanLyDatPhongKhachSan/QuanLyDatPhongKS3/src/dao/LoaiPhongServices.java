package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.LoaiPhong;

public class LoaiPhongServices {
	public static LoaiPhong	layThongTinLoaiPhongTheoMa(String maLoaiPh) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "select * from tbLoaiPhong where maLoaiPh=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, maLoaiPh);
		ResultSet re = pre.executeQuery();
		if(re.next()) {
			return new LoaiPhong(re.getString(1),re.getString(2), re.getDouble(3));
		}
		return null;
	}
	
}
