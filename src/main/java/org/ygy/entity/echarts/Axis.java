package org.ygy.entity.echarts;

public class Axis implements java.io.Serializable {

	private static final long serialVersionUID = 5055125337636634730L;

	private String type;

	private String[] data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

}
