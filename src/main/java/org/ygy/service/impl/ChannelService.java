package org.ygy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ygy.dao.IChannelDao;
import org.ygy.entity.ChannelEntity;
import org.ygy.entity.PageSearch;
import org.ygy.entity.easyui.ESColumn;
import org.ygy.entity.echarts.BaseSerie;
import org.ygy.entity.echarts.Echart;
import org.ygy.entity.echarts.Serie;
import org.ygy.service.IChannelService;
import org.ygy.util.GsonUtil;
import org.ygy.vo.ChannelInfoVO;
import org.ygy.vo.ESBaseVO;
import org.ygy.vo.OutlineData;
import org.ygy.vo.OutlineDetail;

@Service("channelService")
public class ChannelService implements IChannelService {
	
	@Autowired
	private IChannelDao channelDao;

	public List<ESColumn> packageColumns(List<ESColumn> columns) {
		List<ESColumn> preColumns = new ArrayList<ESColumn>();
		preColumns.add(new ESColumn("channel_name" , "负责人-渠道名称",200));
		preColumns.add(new ESColumn("channel_url" , "链接网址",300));
		preColumns.add(new ESColumn("total_num" , "总注册人数"));
		
		columns.addAll(0, preColumns);	
		
		return columns;
	}
	
	@Override
	public String queryColumns(PageSearch pageSearch) {
		if(pageSearch.getStartDate() == null || pageSearch.getStartDate() == "") {
			pageSearch.setStartDate("2015-08-30");
		}		
		//标题
		List<ESColumn> columns = packageColumns(channelDao.selectChannelColumns(pageSearch)); 

		return GsonUtil.toJson(columns);
	}
	

	
	@Override
	public String queryChannelInfo(PageSearch pageSearch) {
		
		if(pageSearch.getStartDate() == null || pageSearch.getStartDate() == "") {
			pageSearch.setStartDate("2015-08-30");
		}
		//1. 查询所有渠道信息
		List<ESColumn> columns = packageColumns(channelDao.selectChannelColumns(pageSearch)); 
		
		//columns 所有的标题信息
		//开始遍历 从8月30号开始，左关联所有的数据
		//所有的渠道
		List<ChannelEntity> channels = channelDao.selectChannels(pageSearch); 
		
		List<HashMap<String,Object>> vos = new ArrayList<HashMap<String,Object>>();
		for(ChannelEntity each : channels) {
			
			pageSearch.setChannelId(each.getId());
			
			List<ChannelInfoVO> channelInfos = channelDao.selectChannelInfo(pageSearch); 
			
			HashMap<String , Object> datas = new HashMap<String , Object>();
			datas.put("channel_name", channelInfos.get(0).getShowName());
			datas.put("channel_url", channelInfos.get(0).getShowURL());
			datas.put("total_num", channelInfos.get(0).getTotalNum());
			
			for(int index=0; index<channelInfos.size(); index++) {
				//map
				datas.put(columns.get(index+3).getField(), channelInfos.get(index).getRegisterNum());
			}
			vos.add(datas);
		}
		
		ESBaseVO<HashMap<String,Object>> base = new ESBaseVO<HashMap<String,Object>>();
		base.setTotal(vos.size());
		base.setRows(vos);

		return GsonUtil.toJson(base);
	}

	@Override
	public String queryChannelType() {
		
		List<ChannelEntity> channelTypes = channelDao.selectChannelTypes();
		
		return GsonUtil.toJson(channelTypes);
	}

	@Override
	public List<String> queryColumnsForExport(PageSearch pageSearch) {
		if(pageSearch.getStartDate() == null || pageSearch.getStartDate() == "") {
			pageSearch.setStartDate("2015-08-30");
		}		
		//标题
		List<ESColumn> columns = packageColumns(channelDao.selectChannelColumns(pageSearch)); 
		
		List<String> headers = new ArrayList<String>();
		for(ESColumn each : columns) {
			headers.add(each.getTitle());
		}
		
		return headers;
	}

	@Override
	public List<ArrayList<String>> queryChannelInfoForExport(PageSearch pageSearch) {
		if(pageSearch.getStartDate() == null || pageSearch.getStartDate() == "") {
			pageSearch.setStartDate("2015-08-30");
		}
		
		//开始遍历 从8月30号开始，左关联所有的数据
		//所有的渠道
		List<ChannelEntity> channels = channelDao.selectChannels(pageSearch); 
		
		List<ArrayList<String>> vos = new ArrayList<ArrayList<String>>();
		
		for(ChannelEntity each : channels) {
			
			pageSearch.setChannelId(each.getId());
			
			List<ChannelInfoVO> channelInfos = channelDao.selectChannelInfo(pageSearch); 
			
			ArrayList<String> datas = new ArrayList<String>();
			
			datas.add(channelInfos.get(0).getShowName());
			datas.add(channelInfos.get(0).getShowURL());
			datas.add(channelInfos.get(0).getTotalNum()+"");
			
			for(int index=0; index<channelInfos.size(); index++) {
				datas.add(channelInfos.get(index).getRegisterNum()+"");
			}
			
			vos.add(datas);
		}		
		
		return vos;
	}

	@Override
	public String queryOutlineTitle() {
		//报表标题、手工指定
		List<ESColumn> preColumns = new ArrayList<ESColumn>();
		preColumns.add(new ESColumn("channel_name" , "渠道名称",200));
		preColumns.add(new ESColumn("channel_url" , "监测网址",250));
		preColumns.add(new ESColumn("person_response" , "负责人"));
		preColumns.add(new ESColumn("register_num" , "注册人数"));
		preColumns.add(new ESColumn("real_num" , "实名人数"));
		preColumns.add(new ESColumn("invest_num" , "投资人数"));
		preColumns.add(new ESColumn("invest_money" , "投资金额"));
		
		return GsonUtil.toJson(preColumns);
	}

	@Override
	public String queryOutlineData() {
		
		List<OutlineData> datas = channelDao.selectOutlineData();
		
		OutlineData total = new OutlineData();
		total.setName("汇总");
		
		for(OutlineData each : datas) {
			total.setRegisterNum(total.getRegisterNum()+each.getRegisterNum());
			total.setRealNum(total.getRealNum()+each.getRealNum());
			total.setInvestNum(total.getInvestNum()+each.getInvestNum());
			total.setInvestMoney(total.getInvestMoney().add(each.getInvestMoney()));
		}
		datas.add(0, total);
		
		ESBaseVO<OutlineData> base = new ESBaseVO<OutlineData>();
		base.setTotal(datas.size());
		base.setRows(datas);

		return GsonUtil.toJson(base);
	}

	@Override
	public String queryOutlineDetail(String item) {
		String baseName = "";
		List<OutlineDetail> details = null;
		
		if("register".equals(item)) {
			baseName = "注册人数";
			details = channelDao.selectOutlineDetailRegister();
		} else if("real".equals(item)) {
			baseName = "实名人数";
			details = channelDao.selectOutlineDetailReal();
		} else if("invest".equals(item)) {
			baseName = "投资人数";
			details = channelDao.selectOutlineDetailInvest();
		} else if("money".equals(item)) {
			baseName = "投资金额";
			details = channelDao.selectOutlineDetailMoney();
		}
		
		String[] names = new String[details.size()];
		Integer[] datas = new Integer[details.size()];
		for(int index=0; index<details.size();  index++) {
			names[index] = details.get(index).getCalendarId();
			datas[index] = details.get(index).getCustNum();
		}
		
		
		//公共初始化
		Echart echart = new Echart();
		echart.setTooltip(true , "axis");
		echart.setDataZoom(70);
		echart.setLegend(new String[]{baseName});
		echart.setxAxis("category", names);
		echart.setyAxis("value");
		
		BaseSerie serie = new Serie<Integer>(baseName , "line",datas);
		List<BaseSerie> series = new ArrayList<BaseSerie>();
		series.add(serie);
		
		echart.setSeries(series);
		
		return GsonUtil.toJson(echart);
	}

	@Override
	public String queryCompanyData() {
		List<OutlineData> datas = channelDao.selectCompanyData();
		
		ESBaseVO<OutlineData> base = new ESBaseVO<OutlineData>();
		base.setTotal(datas.size());
		base.setRows(datas);

		return GsonUtil.toJson(base);
	}
}
