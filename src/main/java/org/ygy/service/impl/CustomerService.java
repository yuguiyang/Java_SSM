package org.ygy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ygy.dao.ICustomerDao;
import org.ygy.entity.echarts.Echart;
import org.ygy.entity.echarts.Serie;
import org.ygy.service.ICustomerService;
import org.ygy.util.GsonUtil;
import org.ygy.vo.BaseVO;
import org.ygy.vo.RegisterVO;

@Service("customerService")
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public String queryRegisterInfo(Integer page, Integer rows) {

		BaseVO<RegisterVO> base = new BaseVO<RegisterVO>();
		
		int total = customerDao.selectRegisterCount(page , rows);
		base.setTotal(total);
		
		List<RegisterVO> registerList = customerDao.selectRegisters(page , rows); 
		base.setRows(registerList);
		
		return GsonUtil.toJson(base);
	}

	@Override
	public String queryRegisterChart() {
		
		List<RegisterVO> registerList = customerDao.selectRegisterChart();
		
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
		
		return GsonUtil.toJson(echart);
	}


}
