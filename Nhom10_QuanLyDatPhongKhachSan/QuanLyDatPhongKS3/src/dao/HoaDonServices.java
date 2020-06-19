package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.HoaDonDaThanhToan;
import model.HoaDon;

public class HoaDonServices {
	public static ArrayList<HoaDon> layDSHoaDonDaThanhToan() throws Exception {
		Connection conn = DBConnection.getConnect();
		ArrayList<HoaDon> listHd = new ArrayList<HoaDon>();
		String sql = "select * from tbHoaDon where daThanhToan=1 order by len(maHD)";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet re = pre.executeQuery();
		while (re.next()) {
			listHd.add(new HoaDon(re.getString(1), NhanVienServices.layThongTinNhanVien(re.getString(2)),
					KhachHangServices.xemThongTinKhachHangTheoMa(re.getString(3)), re.getDate(4), re.getDouble(5),
					re.getBoolean(6)));
		}
		conn.close();
		return listHd;
	}

	public static ArrayList<HoaDon> layDSHoaDon() throws Exception {
		Connection conn = DBConnection.getConnect();
		ArrayList<HoaDon> listHd = new ArrayList<HoaDon>();
		String sql = "select * from tbHoaDon order by len(maHD)";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet re = pre.executeQuery();
		while (re.next()) {
			listHd.add(new HoaDon(re.getString(1), NhanVienServices.layThongTinNhanVien(re.getString(2)),
					KhachHangServices.xemThongTinKhachHangTheoMa(re.getString(3)), re.getDate(4), re.getDouble(5),
					re.getBoolean(6)));
		}
		conn.close();
		return listHd;
	}

	public static HoaDon layThongTinHoaDon(String maHd) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "select * from tbHoaDon where maHd=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, maHd);
		ResultSet re = pre.executeQuery();
		if (re.next()) {
			return new HoaDon(re.getString(1), NhanVienServices.layThongTinNhanVien(re.getString(2)),
					KhachHangServices.xemThongTinKhachHangTheoMa(re.getString(3)), re.getDate(4), re.getDouble(5),
					re.getBoolean(6));
		}
		pre.close();
		re.close();
		conn.close();
		return null;
	}

	public static int themHoaDon(HoaDon hd) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "insert into tbHoaDon(maHD,maNV,maKH,giamGia,daThanhToan) values(?,?,?,?,0)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, hd.getMaHd());
		pre.setString(2, hd.getNhanVien().getMaNV());
		pre.setString(3, hd.getKhachHang().getMaKH());
		pre.setDouble(4, hd.getGiamGia());

		return pre.executeUpdate();

	}

	public static int capNhatHoaDonThanhToan(HoaDon hd) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "update tbHoaDon set ngayThanhToan=?,daThanhToan=1 where maHD=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setDate(1, hd.getNgayThanhToan());
		pre.setString(2, hd.getMaHd());
		return pre.executeUpdate();

	}

	public static int huyHoaDon(HoaDon hd) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "delete from tbHoaDon where maHD=? and daThanhToan=1";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, hd.getMaHd());
		return pre.executeUpdate();

	}

	public static HoaDon layThongTinHDTheoMaKH(String maKH) throws Exception {
		Connection conn = DBConnection.getConnect();
		ArrayList<HoaDon> listHd = new ArrayList<HoaDon>();
		String sql = "select * from tbHoaDon where maKH=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, maKH);
		ResultSet re = pre.executeQuery();
		if (re.next()) {
			return new HoaDon(re.getString(1), NhanVienServices.layThongTinNhanVien(re.getString(2)),
					KhachHangServices.xemThongTinKhachHangTheoMa(maKH), re.getDate(4), re.getDouble(5),
					re.getBoolean(6));
		}
		pre.close();
		re.close();
		conn.close();
		return null;
	}
	public static int themThongTinHoaDonTT(HoaDonDaThanhToan hdtt) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "insert into tbHoaDonThanhToan values(?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, hdtt.getHd().getMaHd());
		pre.setDouble(2, hdtt.getTongTien());
		return pre.executeUpdate();
	}
	public static HoaDonDaThanhToan thongTinHoaDon(String maHD) throws Exception {
		Connection conn= DBConnection.getConnect();
		String sql ="select * from tbHoaDonThanhToan where maHD=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, maHD);
		ResultSet re = pre.executeQuery();
		if(re.next()) {
			return new HoaDonDaThanhToan(HoaDonServices.layThongTinHoaDon(maHD), re.getDouble(2));
		}
		return null;
	}
	public static ArrayList<HoaDon> timKiemHoaDonTheoNgay(int thang,int nam) throws Exception {
		Connection conn = DBConnection.getConnect();
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		String sql = "select * from tbHoaDon where (year(ngayThanhToan)=? and month(ngayThanhToan)=?) and daThanhToan=1 order by len(maHD)";
		PreparedStatement pre  = conn.prepareStatement(sql);
		pre.setInt(1, thang);
		pre.setInt(2, nam);
		ResultSet re = pre.executeQuery(sql);
		while (re.next()) {
			list.add(new HoaDon(re.getString(1),NhanVienServices.layThongTinNhanVien(re.getString(2)), KhachHangServices.xemThongTinKhachHangTheoMa(re.getString(3)), re.getDate(4), re.getDouble(5), re.getBoolean(6)));
		}
		return null;	
	}
	

}
