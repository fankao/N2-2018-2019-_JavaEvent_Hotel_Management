package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DanhMucBean {
	private String name;
	private JPanel pn;
	private JLabel lbl;

	public DanhMucBean() {

	}

	public DanhMucBean(String name, JPanel pn, JLabel lbl) {
		super();
		this.name = name;
		this.pn = pn;
		this.lbl = lbl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JPanel getPn() {
		return pn;
	}

	public void setPn(JPanel pn) {
		this.pn = pn;
	}

	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}
	

}
