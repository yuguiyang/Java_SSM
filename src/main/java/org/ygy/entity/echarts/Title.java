package org.ygy.entity.echarts;

public class Title implements java.io.Serializable {

	private static final long serialVersionUID = -7933848341705585891L;

	private String text;
	private String subtext;
	
	public Title() {
		
	}
	
	public Title(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSubtext() {
		return subtext;
	}

	public void setSubtext(String subtext) {
		this.subtext = subtext;
	}


}
