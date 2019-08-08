package bus;

import dao.HoaDonServices;
import dao.KhachHangServices;
import model.HoaDon;
import model.KhachHang;

public class KhachHangBus {
	public String taoMaKh() throws Exception {

		if (KhachHangServices.xemDanhSachKhachHang().size() > 0) {
			String makhCuoi = KhachHangServices.xemDanhSachKhachHang()
					.get(KhachHangServices.xemDanhSachKhachHang().size() - 1).getMaKH();
			int vt = makhCuoi.indexOf("H");
			String chiSo = makhCuoi.substring(vt + 1);
			int csThem = Integer.parseInt(chiSo) + 1;
			return "KH" + csThem;
		} else {
			return "KH" + 1;
		}
	}
	public String thietLapKHThanThiet(KhachHang kh) throws Exception {
		int  dem = 0;
		for (HoaDon hd : HoaDonServices.layDSHoaDonDaThanhToan()) {
			if(hd.getKhachHang().getCMND().equalsIgnoreCase(kh.getCMND())) {
				dem++;
			}
		}
		if(dem>=3) {
			return "Thân thiết";
		
		}
			return "Thường";
		
	}

}
