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
		session = MyBatisUtil.getSession();
		
		List<ESColumn> columns = session.selectList(Mappers.CHANNEL + "selectColumns");		
		
		return columns;
	}

	@Override
	public List<ChannelEntity> selectChannels() {
		session = MyBatisUtil.getSession();
		
		List<ChannelEntity> channels = session.selectList(Mappers.CHANNEL + "selectChannels");
		
		return channels;
	}

	@Override
	public List<ChannelInfoVO> selectChannelInfo(String id) {
		session = MyBatisUtil.getSession();
		
		List<ChannelInfoVO> channelInfos = session.selectList(Mappers.CHANNEL + "selectChannelInfo" , id);
		
		return channelInfos;
	}  
	
	
	
}
