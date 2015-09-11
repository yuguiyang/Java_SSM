package org.ygy.service;

import java.util.ArrayList;
import java.util.List;

import org.ygy.entity.PageSearch;

public interface IChannelService {
	/**
	 * 查询列表标题
	 * @return
	 */
	public String queryColumns(PageSearch pageSearch);
	
	/**
	 * 查询渠道注册信息
	 * @return
	 */
	public String queryChannelInfo(PageSearch pageSearch);

	/**
	 * 查询渠道类型 市场、运营、...
	 * @return
	 */
	public String queryChannelType();
	
	/**
	 * 报表标题
	 * @return
	 */
	public List<String> queryColumnsForExport(PageSearch pageSearch);
	
	/**
	 * 报表内容
	 * @param pageSearch
	 * @return
	 */
	public List<ArrayList<String>> queryChannelInfoForExport(PageSearch pageSearch);
}
