package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.CT_HoaDon;
import model.HoaDon;
import model.Phong;

public class CT_HoaDonServices {
	public static ArrayList<CT_HoaDon> layChiTietHoaDon(String maHD) throws Exception {
		ArrayList<CT_HoaDon>cthd = new ArrayList<CT_HoaDon>();
		Connection conn = DBConnection.getConnect();
		String sql = "select * from tbCTHoaDon where maHD=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, maHD);
		ResultSet re =pre.executeQuery();
		while(re.next()) {
			cthd.add(new CT_HoaDon(HoaDonServices.layThongTinHoaDon(maHD), PhongServices.layThongTinPhong(re.getString(2)), re.getDate(3), re.getDate(4))) ;
		}
		return cthd;
		
	}
	

	public static int themChiTietHD(CT_HoaDon cthd) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "insert into tbCTHoaDon values(?,?,?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, cthd.getHoaDon().getMaHd());
		pre.setString(2, cthd.getPhong().getSoPhong());
		pre.setDate(3, cthd.getNgayDen());
		pre.setDate(4, cthd.getNgayDi());
		
		return pre.executeUpdate();
	}

	public static int capNhatCTHoaDon(CT_HoaDon cthd) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "update tbCTHoaDon set ngayDen=?,ngayDi=? where maHD=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setDate(1, cthd.getNgayDen());
		pre.setDate(2, cthd.getNgayDi());
		pre.setString(3, cthd.getHoaDon().getMaHd());
		return pre.executeUpdate();
	}

	public static int xoaCTHoaDon(CT_HoaDon cthd) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "delete from tbCTHoaDon where maHD=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, cthd.getHoaDon().getMaHd());
		
		return pre.executeUpdate();
	}
	public static int  luuCTHoaDonDaThanhToan(CT_HoaDon ct) throws Exception {
		Connection conn = DBConnection.getConnect();
		String sql = "insert into tbCTHoaDonDaXoa select * from tbCTHoaDon ct where ct.maHD=?";
		PreparedStatement pre =conn.prepareStatement(sql);
		pre.setString(1, ct.getHoaDon().getMaHd());
		return pre.executeUpdate();
	}
	public static ArrayList<CT_HoaDon> layChiTietHoaDonDaThanhToan(String maHD) throws Exception {
		ArrayList<CT_HoaDon>cthd = new ArrayList<CT_HoaDon>();
		Connection conn = DBConnection.getConnect();
		String sql = "select * from tbCTHoaDonDaXoa where maHD=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, maHD);
		ResultSet re =pre.executeQuery();
		while(re.next()) {
			cthd.add(new CT_HoaDon(HoaDonServices.layThongTinHoaDon(maHD), PhongServices.layThongTinPhong(re.getString(2)), re.getDate(3), re.getDate(4))) ;
		}
		return cthd;
		
	}
	

}
