package org.ygy.entity;

public class RegisterVO implements java.io.Serializable {

	private static final long serialVersionUID = 3289911761820239735L;
	
	private String calendarId;
	private Integer todayAddNum;
	private Integer totalNum;

	public String getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}

	public Integer getTodayAddNum() {
		return todayAddNum;
	}

	public void setTodayAddNum(Integer todayAddNum) {
		this.todayAddNum = todayAddNum;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

}
