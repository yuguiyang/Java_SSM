package org.ygy.vo;

public class ChannelInfoVO {

	private int id;
	private String type;
	private String showName;
	private String showURL;
	private String calendarId;
	private long registerNum;
	private long totalNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowURL() {
		return showURL;
	}

	public void setShowURL(String showURL) {
		this.showURL = showURL;
	}

	public String getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}

	public long getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(long registerNum) {
		this.registerNum = registerNum;
	}

	public long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}

	@Override
	public String toString() {
		return "ChannelInfoVO [id=" + id + ", showName=" + showName + ", showURL=" + showURL + ", calendarId="
				+ calendarId + ", registerNum=" + registerNum + ", totalNum=" + totalNum + "]";
	}
	
}
