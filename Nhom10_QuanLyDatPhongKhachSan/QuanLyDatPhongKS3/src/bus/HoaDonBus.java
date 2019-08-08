package bus;

import dao.HoaDonServices;
import dao.KhachHangServices;

public class HoaDonBus {
	public String taoMahd() throws Exception {

		if (HoaDonServices.layDSHoaDon().size() > 0) {
			String mahdCuoi = HoaDonServices.layDSHoaDon().get(HoaDonServices.layDSHoaDon().size() - 1).getMaHd();
			int vt = mahdCuoi.indexOf("D");
			String chiSo = mahdCuoi.substring(vt + 1);
			int csThem = Integer.parseInt(chiSo) + 1;
			return "HD" + csThem;
		} else {
			return "HD" + 1;
		}
	}

}
