package org.ygy.test;

import org.junit.Test;
import org.ygy.entity.echarts.Serie;

import com.google.gson.Gson;

public class TestEcharts {
	
	@Test
	public void testLine() {
		Serie<Integer> serie = new Serie<Integer>();
		serie.setName("每日新增注册人数");
		serie.setType("line");
		serie.setData(new Integer[]{1,2,3,4});
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(serie));
	}
}
