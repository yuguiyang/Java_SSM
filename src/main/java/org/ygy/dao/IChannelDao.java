package org.ygy.dao;

import java.util.List;

import org.ygy.entity.ChannelEntity;
import org.ygy.entity.PageSearch;
import org.ygy.entity.easyui.ESColumn;
import org.ygy.vo.ChannelInfoVO;
import org.ygy.vo.OutlineData;
import org.ygy.vo.OutlineDetail;

public interface IChannelDao {

	/**
	 * 查询标题
	 * 
	 * @return
	 */
	public List<ESColumn> selectChannelColumns(PageSearch pageSearch);

	/**
	 * 查询所有渠道信息
	 * 
	 * @return
	 */
	public List<ChannelEntity> selectChannels(PageSearch pageSearch);

	/**
	 * 根据渠道ID，查询渠道信息
	 * 
	 * @param id
	 * @return
	 */
	public List<ChannelInfoVO> selectChannelInfo(PageSearch pageSearch);

	/**
	 * 获取渠道所有的类型
	 * @return
	 */
	public List<ChannelEntity> selectChannelTypes();

	
	public List<OutlineData> selectOutlineData();

	public List<OutlineDetail> selectOutlineDetailRegister();

	public List<OutlineDetail> selectOutlineDetailReal();

	public List<OutlineDetail> selectOutlineDetailInvest();

	public List<OutlineDetail> selectOutlineDetailMoney();

	public List<OutlineData> selectCompanyData();
	

}
