package org.ygy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ygy.dao.ICustomerDao;
import org.ygy.entity.PageSearch;
import org.ygy.entity.echarts.BaseSerie;
import org.ygy.entity.echarts.DataRange;
import org.ygy.entity.echarts.Echart;
import org.ygy.entity.echarts.ItemStyle;
import org.ygy.entity.echarts.MapData;
import org.ygy.entity.echarts.MapSerie;
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
	public String queryRegisterInfo(PageSearch pageSearch) {

		BaseVO<RegisterVO> base = new BaseVO<RegisterVO>();
		
		int total = customerDao.selectRegisterCount(pageSearch);
		base.setTotal(total);
		
		List<RegisterVO> registerList = customerDao.selectRegisters(pageSearch); 
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
		
		BaseSerie serie = new Serie<Integer>("每日新增客户数" , "line",datas);
		List<BaseSerie> series = new ArrayList<BaseSerie>();
		series.add(serie);
		
		echart.setSeries(series);
		
		return GsonUtil.toJson(echart);
	}

	@Override
	public List<ArrayList<String>> queryRegisterForExport(PageSearch pageSearch) {
		
		List<RegisterVO> registerList = customerDao.selectRegisters(pageSearch);
		
		List<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		
		for(RegisterVO each : registerList) {
			ArrayList<String> data = new ArrayList<String>();
			data.add(each.getCalendarId());
			data.add(each.getTodayAddNum()+"");
			data.add(each.getTotalNum()+"");
			
			datas.add(data);
		}
		
		return datas;
	}

	@Override
	public String queryRegisterMap() {
		Echart<Integer> echart = new Echart<Integer>();
		echart.setTitle("注册人数区域分布");
		echart.setTooltip(true , "item");
		echart.setLegend(new String[]{"注册用户数"});
		echart.setDataRange(new DataRange());
		
		List<MapData> datas = customerDao.selectRegisterMap();
		
		MapSerie serie = new MapSerie("注册用户数" , datas);
		serie.setItemStyle(new ItemStyle());
		
		List<BaseSerie> series = new ArrayList<BaseSerie>();
		series.add(serie);
		
		echart.setSeries(series);
		
		return GsonUtil.toJson(echart);
	}


}
