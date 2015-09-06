package org.ygy.entity.echarts;

public class XAxis implements java.io.Serializable{

	private static final long serialVersionUID = 8422603941561119380L;

	private String type;
	
	private String[] data;
	
	public XAxis() {}
	
	public XAxis(String type, String[] data) {
		this.type = type;
		this.data = data;
	}



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
