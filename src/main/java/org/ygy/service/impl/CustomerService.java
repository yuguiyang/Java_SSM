package org.ygy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.ygy.entity.echarts.Echart;
import org.ygy.entity.echarts.Serie;
import org.ygy.service.ICustomerService;
import org.ygy.util.MyBatisUtil;
import org.ygy.vo.BaseVO;
import org.ygy.vo.RegisterVO;

import com.google.gson.Gson;

public class CustomerService implements ICustomerService {
	private SqlSession session = null;  
	
	@Override
	public String queryRegisterInfo() {
		session = MyBatisUtil.getSession();  
		List<RegisterVO> registerList = session.selectList("org.ygy.mapper.CustomerMapper.selectRegister");
		
		BaseVO<RegisterVO> base = new BaseVO<RegisterVO>();
		base.setTotal(registerList.size());
		base.setRows(registerList);
		
		Gson gson = new Gson();
		
		return gson.toJson(base);
	}

	@Override
	public String queryRegisterChart() {
		session = MyBatisUtil.getSession();  
		
		List<RegisterVO> registerList = session.selectList("org.ygy.mapper.CustomerMapper.selectRegisterChart");
		
		String[] names = new String[registerList.size()];
		Integer[] datas = new Integer[registerList.size()];
		for(int index=0; index<registerList.size();  index++) {
			names[index] = registerList.get(index).getCalendarId();
			datas[index] = registerList.get(index).getTodayAddNum();
		}
		
		
		Echart<Integer> echart = new Echart<Integer>();
		echart.setTitle("每日新增客户数趋势图");
		echart.setTooltip(true , "axis");
		echart.setLegend(new String[]{"每日新增客户数"});
		echart.setxAxis("category", names);
		echart.setyAxis("value");
		
		Serie<Integer> serie = new Serie<Integer>("每日新增客户数" , "line",datas);
		List<Serie<Integer>> series = new ArrayList<Serie<Integer>>();
		series.add(serie);
		
		echart.setSeries(series);
		
		
		Gson gson = new Gson();
		
		return gson.toJson(echart);
	}

}
