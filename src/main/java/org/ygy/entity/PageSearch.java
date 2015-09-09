package org.ygy.entity;

public class PageSearch {
	private Integer page;
	private Integer rows;
	private String channelType;
	private String startDate;
	private String endDate;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "PageSearch [page=" + page + ", rows=" + rows + ", channelType=" + channelType + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
}
