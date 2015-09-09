package org.ygy.service;

public interface IChannelService {
	/**
	 * 查询列表标题
	 * @return
	 */
	public String queryColumns();
	
	/**
	 * 查询渠道注册信息
	 * @return
	 */
	public String queryChannelInfo();

	/**
	 * 查询渠道类型 市场、运营、...
	 * @return
	 */
	public String queryChannelType();
}
