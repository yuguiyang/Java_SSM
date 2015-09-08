package org.ygy.dao;

import java.util.List;

import org.ygy.entity.ChannelEntity;
import org.ygy.entity.easyui.ESColumn;
import org.ygy.vo.ChannelInfoVO;

public interface IChannelDao {

	/**
	 * 查询标题
	 * 
	 * @return
	 */
	public List<ESColumn> selectChannelColumns();

	/**
	 * 查询所有渠道信息
	 * 
	 * @return
	 */
	public List<ChannelEntity> selectChannels();

	/**
	 * 根据渠道ID，查询渠道信息
	 * 
	 * @param id
	 * @return
	 */
	public List<ChannelInfoVO> selectChannelInfo(String id);

}
