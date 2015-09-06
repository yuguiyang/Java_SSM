package org.ygy.entity.echarts;

public class YAxis implements java.io.Serializable{

	private static final long serialVersionUID = 8347675488090892310L;
	
	private String type;
	
	public YAxis() {}
	
	public YAxis(String type) {
		this.type = type;
	}	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
