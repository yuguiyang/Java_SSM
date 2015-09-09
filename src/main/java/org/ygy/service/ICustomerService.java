package org.ygy.service;

import org.ygy.entity.PageSearch;

public interface ICustomerService {
	
	/**
	 * 查询全站注册数据
	 * @param page 页数
	 * @param rows 每页显示数量
	 * @return
	 */
	public String queryRegisterInfo(PageSearch pageSearch);

	/**
	 * 查询注册图表
	 * @return
	 */
	public String queryRegisterChart();
}
