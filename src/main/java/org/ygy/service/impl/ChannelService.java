package org.ygy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.ygy.dao.IChannelDao;
import org.ygy.dao.impl.ChannelDao;
import org.ygy.entity.ChannelEntity;
import org.ygy.entity.easyui.ESColumn;
import org.ygy.service.IChannelService;
import org.ygy.util.GsonUtil;
import org.ygy.vo.BaseVO;
import org.ygy.vo.ChannelInfoVO;

public class ChannelService implements IChannelService {
	private IChannelDao channelDao = new ChannelDao();

	public List<ESColumn> packageColumns(List<ESColumn> columns) {
		long start = System.currentTimeMillis();
		List<ESColumn> preColumns = new ArrayList<ESColumn>();
		preColumns.add(new ESColumn("channel_name" , "负责人-渠道名称",200));
		preColumns.add(new ESColumn("channel_url" , "链接网址",200));
		preColumns.add(new ESColumn("total_num" , "总注册人数"));
		
		columns.addAll(0, preColumns);	
		long end = System.currentTimeMillis();
		System.out.println("service packageColumns 耗时:" +(end-start)/1000);
		
		return columns;
	}
	
	@Override
	public String queryColumns() {
		long start = System.currentTimeMillis();
		//标题
		List<ESColumn> columns = packageColumns(channelDao.selectChannelColumns()); 
		long end = System.currentTimeMillis();
		System.out.println("service queryColumns 耗时:" +(end-start)/1000);	
		return GsonUtil.toJson(columns);
	}
	

	
	@Override
	public String queryChannelInfo() {
		long start = System.currentTimeMillis();	
		//1. 查询所有渠道信息
		List<ESColumn> columns = packageColumns(channelDao.selectChannelColumns()); 
		
		//columns 所有的标题信息
		//开始遍历 从8月30号开始，左关联所有的数据
		//所有的渠道
		List<ChannelEntity> channels = channelDao.selectChannels(); 
		
		List<HashMap<String,Object>> vos = new ArrayList<HashMap<String,Object>>();
		for(ChannelEntity each : channels) {
			List<ChannelInfoVO> channelInfos = channelDao.selectChannelInfo(each.getId()); 

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
		
		BaseVO<HashMap<String,Object>> base = new BaseVO<HashMap<String,Object>>();
		base.setTotal(vos.size());
		base.setRows(vos);

		long end = System.currentTimeMillis();
		System.out.println("service queryChannelInfo 耗时:" +(end-start)/1000);
		
		return GsonUtil.toJson(base);
	}
}
