package dao;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Phong;

public class PhongServices {
	public static Phong layThongTinPhong(String soPhong) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "select * from tbPhong where soPhong=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, soPhong);
		ResultSet re = pre.executeQuery();

		if (re.next()) {
			return new Phong(re.getString(1), re.getBoolean(2),
					LoaiPhongServices.layThongTinLoaiPhongTheoMa(re.getString(3)));
		}
		conn.close();
		return null;
	}

	public static ArrayList<Phong> layDanhSachPhong() throws Exception {
		Connection conn = DBConnection.getConnect();
		ArrayList<Phong> listRo = new ArrayList<Phong>();
		String sql = "select * from tbPhong";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet re = pre.executeQuery();

		while (re.next()) {
			listRo.add(new Phong(re.getString(1), re.getBoolean(2),
					LoaiPhongServices.layThongTinLoaiPhongTheoMa(re.getString(3))));
		}
		conn.close();
		return listRo;
	}
	public static int capNhatTrangThaiPhong() throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "update tbPhong set tinhTrang = 1 where soPhong in (select soPhong from tbCTHoaDon)";
		PreparedStatement pre = conn.prepareStatement(sql);
		return pre.executeUpdate();
	}

	

}
