package org.ygy.entity.echarts;

public class ItemStyle {

	private Normal normal;
	private Emphasis emphasis;
	
	public ItemStyle() {
		this.normal = new Normal();
		this.emphasis = new Emphasis();
	}

	public Normal getNormal() {
		return normal;
	}

	public void setNormal(Normal normal) {
		this.normal = normal;
	}

	public Emphasis getEmphasis() {
		return emphasis;
	}

	public void setEmphasis(Emphasis emphasis) {
		this.emphasis = emphasis;
	}

}
