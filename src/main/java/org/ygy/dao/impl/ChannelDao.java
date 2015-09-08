package org.ygy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.ygy.dao.IChannelDao;
import org.ygy.entity.ChannelEntity;
import org.ygy.entity.easyui.ESColumn;
import org.ygy.property.Mappers;
import org.ygy.util.MyBatisUtil;
import org.ygy.vo.ChannelInfoVO;

public class ChannelDao implements IChannelDao {
	private SqlSession session = null;

	@Override
	public List<ESColumn> selectChannelColumns() {
		long start = System.currentTimeMillis();
		session = MyBatisUtil.getSession();
		
		List<ESColumn> columns = session.selectList(Mappers.CHANNEL + "selectColumns");		
		long end = System.currentTimeMillis();
		System.out.println("dao selectChannelColumns 耗时:" +(end-start)/1000);			
		return columns;
	}

	@Override
	public List<ChannelEntity> selectChannels() {
		long start = System.currentTimeMillis();
		session = MyBatisUtil.getSession();
		
		List<ChannelEntity> channels = session.selectList(Mappers.CHANNEL + "selectChannels");
		long end = System.currentTimeMillis();
		System.out.println("dao selectChannels 耗时:" +(end-start)/1000);			
		return channels;
	}

	@Override
	public List<ChannelInfoVO> selectChannelInfo(String id) {
		long start = System.currentTimeMillis();		
		session = MyBatisUtil.getSession();
		
		List<ChannelInfoVO> channelInfos = session.selectList(Mappers.CHANNEL + "selectChannelInfo" , id);

		long end = System.currentTimeMillis();
		System.out.println("dao selectChannelInfo 耗时:" +(end-start)/1000);			
		return channelInfos;
	}  
	
	
	
}
