package org.ygy.entity.echarts;

public class Serie<T> extends BaseSerie implements java.io.Serializable {

	private static final long serialVersionUID = 2579979034796743165L;
	
	private String name;
	private String type;
	private T[] data;
	private Mark markPoint;
	private Mark markLine;
	
	public Serie() {}
	
	public Serie(String name, String type , T[] data) {
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public T[] getData() {
		return data;
	}

	public void setData(T[] data) {
		this.data = data;
	}

	public Mark getMarkPoint() {
		return markPoint;
	}

	public void setMarkPoint(Mark markPoint) {
		this.markPoint = markPoint;
	}

	public Mark getMarkLine() {
		return markLine;
	}

	public void setMarkLine(Mark markLine) {
		this.markLine = markLine;
	}
	
}
