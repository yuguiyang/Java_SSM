package org.ygy.service;

public interface ICustomerService {
	
	/**
	 * 查询全站注册数据
	 * @param page 页数
	 * @param rows 每页显示数量
	 * @return
	 */
	public String queryRegisterInfo(Integer page, Integer rows);

	/**
	 * 查询注册图表
	 * @return
	 */
	public String queryRegisterChart();


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
}
