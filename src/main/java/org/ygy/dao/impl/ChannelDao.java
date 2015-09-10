package org.ygy.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.ygy.dao.IChannelDao;
import org.ygy.entity.ChannelEntity;
import org.ygy.entity.PageSearch;
import org.ygy.entity.easyui.ESColumn;
import org.ygy.property.Mappers;
import org.ygy.vo.ChannelInfoVO;

public class ChannelDao extends SqlSessionDaoSupport  implements IChannelDao {

	@Override
	public List<ESColumn> selectChannelColumns(PageSearch pageSearch) {
		
		List<ESColumn> columns = getSqlSession().selectList(Mappers.CHANNEL + "selectColumns",pageSearch);
		
		return columns;
	}

	@Override
	public List<ChannelEntity> selectChannels(PageSearch pageSearch) {
		
		List<ChannelEntity> channels = getSqlSession().selectList(Mappers.CHANNEL + "selectChannels" , pageSearch);
		
		return channels;
	}

	@Override
	public List<ChannelInfoVO> selectChannelInfo(PageSearch pageSearch) {
		//渠道类型，过滤
		List<ChannelInfoVO> channelInfos = getSqlSession().selectList(Mappers.CHANNEL + "selectChannelInfo" , pageSearch);

		return channelInfos;
	}

	@Override
	public List<ChannelEntity> selectChannelTypes() {
		
		List<ChannelEntity> channels = getSqlSession().selectList(Mappers.CHANNEL + "selectChannelType");
		
		return channels;
	}  
	
	
	
}
