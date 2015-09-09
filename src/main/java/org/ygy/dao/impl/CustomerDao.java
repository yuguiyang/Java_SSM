package org.ygy.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.ygy.dao.ICustomerDao;
import org.ygy.property.Mappers;
import org.ygy.vo.RegisterVO;

public class CustomerDao extends SqlSessionDaoSupport  implements ICustomerDao {
	
	@Override
	public int selectRegisterCount(Integer page, Integer rows) {
		
		int total = getSqlSession().selectOne(Mappers.CUSTOMER + "selectRegisterPage");
		
		return total;
	}

	@Override
	public List<RegisterVO> selectRegisters(Integer page, Integer rows) {
		
		Map<String, Integer> params = new HashMap<String , Integer>();
		params.put("page", rows*(page-1));
		params.put("rows", rows);
		
		List<RegisterVO> registerList = getSqlSession().selectList(Mappers.CUSTOMER + "selectRegister",params);
		return registerList;
	}

	@Override
	public List<RegisterVO> selectRegisterChart() {
		
		List<RegisterVO> registerList = getSqlSession().selectList(Mappers.CUSTOMER + "selectRegisterChart");
		
		return registerList;
	}

}
