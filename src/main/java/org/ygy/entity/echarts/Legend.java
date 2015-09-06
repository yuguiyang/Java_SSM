package org.ygy.entity.echarts;

public class Legend implements java.io.Serializable{
	
	private static final long serialVersionUID = 6612128565819539292L;
	
	private String[] data;
	
	public Legend() {}

	public Legend(String[] data) {
		this.data = data;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}
	
	
}
