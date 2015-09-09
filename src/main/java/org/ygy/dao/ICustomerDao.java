package org.ygy.dao;

import java.util.List;

import org.ygy.entity.PageSearch;
import org.ygy.vo.RegisterVO;

public interface ICustomerDao {

	/**
	 * 查询客户总数
	 * @param page
	 * @param rows
	 * @return 
	 */
	public int selectRegisterCount(PageSearch pageSearch);

	/**
	 * 查询所有客户信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<RegisterVO> selectRegisters(PageSearch pageSearch);

	/**
	 * 查询客户趋势信息(可以合并)
	 * @return
	 */
	public List<RegisterVO> selectRegisterChart();

}
