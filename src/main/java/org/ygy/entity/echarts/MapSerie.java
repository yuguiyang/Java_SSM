package org.ygy.entity.echarts;

import java.util.List;

public class MapSerie extends BaseSerie{

	private String name;
	private String type = "map";
	private String mapType = "china";
	private boolean roam = false;
	private List<MapData> data;
	
	public MapSerie() {}
	
	public MapSerie(String name , List<MapData> data) {
		this.name = name;
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

	public String getMapType() {
		return mapType;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public boolean isRoam() {
		return roam;
	}

	public void setRoam(boolean roam) {
		this.roam = roam;
	}

	public List<MapData> getData() {
		return data;
	}

	public void setData(List<MapData> data) {
		this.data = data;
	}

}
