package org.ygy.entity.echarts;

import java.io.Serializable;
import java.util.List;

public class Echart implements Serializable {
	
	private static final long serialVersionUID = -5008104692637786764L;
	
	private Title title;
	
	private Tooltip tooltip;
	
	private DataZoom dataZoom;
	
	private Legend legend;
	
	private boolean calculable;

	private XAxis xAxis;  
    
    private YAxis yAxis;  
    
    private DataRange dataRange;
  
    private List<BaseSerie> series;

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	
	public void setTitle(String title) {
		this.title = new Title(title);
	}

	public Tooltip getTooltip() {
		return tooltip;
	}

	public DataZoom getDataZoom() {
		return dataZoom;
	}

	public void setDataZoom(DataZoom dataZoom) {
		this.dataZoom = dataZoom;
	}
	
	public void setDataZoom(int start) {
		this.dataZoom = new DataZoom(start);
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}
	
	public void setTooltip(boolean show , String trigger) {
		this.tooltip = new Tooltip(show , trigger);
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}
	
	public void setLegend(String[] data) {
		this.legend = new Legend(data);
	}
	
	public boolean isCalculable() {
		return calculable;
	}

	public void setCalculable(boolean calculable) {
		this.calculable = calculable;
	}

	public XAxis getxAxis() {
		return xAxis;
	}

	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}
	
	public void setxAxis(String type, String[] data){
		this.xAxis = new XAxis(type , data);
	}

	public YAxis getyAxis() {
		return yAxis;
	}

	public void setyAxis(YAxis yAxis) {
		this.yAxis = yAxis;
	}
	
	public void setyAxis(String type) {
		this.yAxis = new YAxis(type);
	}

	public List<BaseSerie> getSeries() {
		return series;
	}

	public void setSeries(List<BaseSerie> series) {
		this.series = series;
	}

	public DataRange getDataRange() {
		return dataRange;
	}

	public void setDataRange(DataRange dataRange) {
		this.dataRange = dataRange;
	}
	
}
