package org.ygy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.ygy.entity.ChannelEntity;
import org.ygy.entity.easyui.ESColumn;
import org.ygy.entity.echarts.Echart;
import org.ygy.entity.echarts.Serie;
import org.ygy.service.ICustomerService;
import org.ygy.util.MyBatisUtil;
import org.ygy.vo.BaseVO;
import org.ygy.vo.ChannelInfoVO;
import org.ygy.vo.RegisterVO;
import org.ygy.vo.TitleVO;

import com.google.gson.Gson;

public class CustomerService implements ICustomerService {
	private SqlSession session = null;  
	
	@Override
	public String queryRegisterInfo(Integer page, Integer rows) {
		session = MyBatisUtil.getSession();
		
		BaseVO<RegisterVO> base = new BaseVO<RegisterVO>();

		int total = session.selectOne("org.ygy.mapper.CustomerMapper.selectRegisterPage");
		base.setTotal(total);

		Map<String, Integer> params = new HashMap<String , Integer>();
		params.put("page", rows*(page-1));
		params.put("rows", rows);
		
		List<RegisterVO> registerList = session.selectList("org.ygy.mapper.CustomerMapper.selectRegister",params);
		
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

	@Override
	public String queryChannelInfo() {
		
		//1. 查询所有渠道信息
		session = MyBatisUtil.getSession();
		
		List<TitleVO> titles = session.selectList("org.ygy.mapper.ChannelMapper.selectColumns");
		
		List<TitleVO> preTitles = new ArrayList<TitleVO>();
		preTitles.add(new TitleVO("channel_name" , "负责人-渠道名称"));
		preTitles.add(new TitleVO("channel_url" , "链接网址"));
		preTitles.add(new TitleVO("total_num" , "总注册人数"));
		
		titles.addAll(0, preTitles);
		
		List<ESColumn> columns = new ArrayList<ESColumn>();
		
		for(TitleVO each : titles) {
			ESColumn column = new ESColumn(each.getId() , each.getName());
			
			columns.add(column);
		}
		
		//columns 所有的标题信息
		//开始遍历 从8月30号开始，左关联所有的数据
		//所有的渠道
		List<ChannelEntity> channels = session.selectList("org.ygy.mapper.ChannelMapper.selectChannels");
		
		List<HashMap<String,Object>> vos = new ArrayList<HashMap<String,Object>>();
		for(ChannelEntity each : channels) {
			List<ChannelInfoVO> channelInfos = session.selectList("org.ygy.mapper.ChannelMapper.selectChannelInfo" , each.getId());

			HashMap<String , Object> datas = new HashMap<String , Object>();
			datas.put("channel_name", channelInfos.get(0).getShowName());
			datas.put("channel_url", channelInfos.get(0).getShowURL());
			datas.put("total_num", channelInfos.get(0).getTotalNum());
			
			for(int index=0; index<channelInfos.size(); index++) {
				//map
				datas.put(titles.get(index+3).getId(), channelInfos.get(index).getRegisterNum());
			}
			vos.add(datas);
		}
		
		BaseVO<HashMap<String,Object>> base = new BaseVO<HashMap<String,Object>>();
		base.setTotal(vos.size());
		base.setRows(vos);
		
		Gson gson = new Gson();
		
		return gson.toJson(base);
	}

	@Override
	public String queryColumns() {
		session = MyBatisUtil.getSession(); 
		
		//标题
		List<TitleVO> titles = session.selectList("org.ygy.mapper.ChannelMapper.selectColumns");
		
		List<TitleVO> preTitles = new ArrayList<TitleVO>();
		preTitles.add(new TitleVO("channel_name" , "负责人-渠道名称"));
		preTitles.add(new TitleVO("channel_url" , "链接网址"));
		preTitles.add(new TitleVO("total_num" , "总注册人数"));
		
		titles.addAll(0, preTitles);
		
		List<ESColumn> columns = new ArrayList<ESColumn>();
		
		for(TitleVO each : titles) {
			ESColumn column = new ESColumn(each.getId() , each.getName());
			
			columns.add(column);
		}
		
		Gson gson = new Gson();
		
		return gson.toJson(columns);
	}

}
