package org.ygy.service;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 查询要导出的客户信息
	 * @param pageSearch
	 * @return
	 */
	public List<ArrayList<String>> queryRegisterForExport(PageSearch pageSearch);
}
