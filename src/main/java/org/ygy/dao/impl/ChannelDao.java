package org.ygy.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.ygy.dao.IChannelDao;
import org.ygy.entity.ChannelEntity;
import org.ygy.entity.easyui.ESColumn;
import org.ygy.property.Mappers;
import org.ygy.vo.ChannelInfoVO;

public class ChannelDao extends SqlSessionDaoSupport  implements IChannelDao {

	@Override
	public List<ESColumn> selectChannelColumns() {
		
		List<ESColumn> columns = getSqlSession().selectList(Mappers.CHANNEL + "selectColumns");		
		
		return columns;
	}

	@Override
	public List<ChannelEntity> selectChannels() {
		
		List<ChannelEntity> channels = getSqlSession().selectList(Mappers.CHANNEL + "selectChannels");
		
		return channels;
	}

	@Override
	public List<ChannelInfoVO> selectChannelInfo(String id) {
		
		List<ChannelInfoVO> channelInfos = getSqlSession().selectList(Mappers.CHANNEL + "selectChannelInfo" , id);

		return channelInfos;
	}

	@Override
	public List<ChannelEntity> selectChannelTypes() {
		
		List<ChannelEntity> channels = getSqlSession().selectList(Mappers.CHANNEL + "selectChannelType");
		
		return channels;
	}  
	
	
	
}
