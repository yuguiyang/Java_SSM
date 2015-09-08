package org.ygy.entity.easyui;

public class ESColumn {

	private String field;
	private String title;
	private Integer width = 100;
	private String align;
	
	public ESColumn() {}

	public ESColumn(String field, String title) {
		this.field = field;
		this.title = title;
	}
	
	public ESColumn(String field, String title, Integer width) {
		this.field = field;
		this.title = title;
		this.width = width;
	}	
	
	public ESColumn(String field, String title, Integer width, String align) {
		this.field = field;
		this.title = title;
		this.width = width;
		this.align = align;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

}
