package org.ygy.entity.echarts;

public class DataZoom {
	private boolean show = true;
	private boolean realtime = true;
	private int start;
	private int end = 100;
	
	public DataZoom() {}
	
	public DataZoom(int start) {
		this.start = start;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public boolean isRealtime() {
		return realtime;
	}

	public void setRealtime(boolean realtime) {
		this.realtime = realtime;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
