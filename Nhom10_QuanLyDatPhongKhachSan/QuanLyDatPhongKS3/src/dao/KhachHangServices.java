package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.KhachHang;
import model.Phong;

public class KhachHangServices {
	public static ArrayList<KhachHang> xemDanhSachKhachHang() throws Exception {
		Connection conn = DBConnection.getConnect();
		ArrayList<KhachHang> listKh = new ArrayList<KhachHang>();
		String sql = "select * from tbKhachHang order by len(maKH)";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet re = pre.executeQuery();

		while (re.next()) {
			listKh.add(new KhachHang(re.getString(1), re.getString(2), re.getString(3), re.getBoolean(4),
					re.getString(5), re.getString(6), re.getString(7)));
		}
		conn.close();
		return listKh;

	}

	public static KhachHang xemThongTinKhachHangTheoThanThietCMND(String cmnd) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "select * from tbKhachHang where cmnd=? order by len(maKH) ";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, cmnd);
		ResultSet re = pre.executeQuery();
		if (re.next()) {
			return new KhachHang(re.getString(1), cmnd, re.getString(3), re.getBoolean(4), re.getString(5),
					re.getString(6), re.getString(7));
		}
		conn.close();
		return null;
	}

	public static KhachHang xemThongTinKhachHangTheoMa(String ma) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "select * from tbKhachHang  where maKH=? order by len(maKH)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, ma);
		ResultSet re = pre.executeQuery();
		if (re.next()) {
			return new KhachHang(ma, re.getString(2), re.getString(3), re.getBoolean(4), re.getString(5),
					re.getString(6), re.getString(7));
		}
		conn.close();
		return null;
	}

	public static int themKhachHang(KhachHang kh) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "insert into tbKhachHang values(?,?,?,?,?,?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, kh.getMaKH());
		pre.setString(3, kh.getHoTen());
		pre.setString(2, kh.getCMND());
		pre.setBoolean(4, kh.isGioiTinh());
		pre.setString(5, kh.getDiaChi());
		pre.setString(6, kh.getSdt());
		pre.setString(7, kh.getLoaiKhach());

		return pre.executeUpdate();
	}

	public static int capNhatKhachHang(KhachHang kh) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "update tbKhachHang set CMND=?,hoTen=?,gioiTinh=?,diaChi=?,sdt=?,loaiKH=? where maKH=?";
		PreparedStatement pre = conn.prepareStatement(sql);

		pre.setString(1, kh.getCMND());
		pre.setString(2, kh.getHoTen());
		pre.setBoolean(3, kh.isGioiTinh());
		pre.setString(4, kh.getDiaChi());
		pre.setString(5, kh.getSdt());
		pre.setString(6, kh.getLoaiKhach());
		pre.setString(7, kh.getMaKH());

		return pre.executeUpdate();
	}
	public static ArrayList<KhachHang> timKiemTheoCMND(String cmnd) throws Exception {
		Connection conn = DBConnection.getConnect();
		ArrayList<KhachHang> listKh = new ArrayList<KhachHang>();
		String sql = "select * from tbKhachHang where cmnd like '%"+cmnd+"%'";
		Statement sta = conn.createStatement();
		ResultSet re = sta.executeQuery(sql);
		while (re.next()) {
			listKh.add(new KhachHang(re.getString(1), re.getString(2), re.getString(3), re.getBoolean(4),
					re.getString(5), re.getString(6), re.getString(7)));
		}
		conn.close();
		return listKh;
	}
	public static ArrayList<KhachHang> timKiemTenKH(String ten) throws Exception {
		Connection conn = DBConnection.getConnect();
		ArrayList<KhachHang> listKh = new ArrayList<KhachHang>();
		String sql = "select * from tbKhachHang where hoTen like '%"+ten+"%'";
		Statement sta = conn.createStatement();
		ResultSet re = sta.executeQuery(sql);
		while (re.next()) {
			listKh.add(new KhachHang(re.getString(1), re.getString(2), re.getString(3), re.getBoolean(4),
					re.getString(5), re.getString(6), re.getString(7)));
		}
		conn.close();
		return listKh;
	}

}
