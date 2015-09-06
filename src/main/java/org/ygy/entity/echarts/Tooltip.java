package org.ygy.entity.echarts;

public class Tooltip implements java.io.Serializable{

	private static final long serialVersionUID = -4770129150063993151L;
	
	private boolean show;
	private String trigger;
	
	public Tooltip() {}
	
	public Tooltip(boolean show , String trigger){
		this.show = show;
		this.trigger = trigger;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}
	
	

}
