package org.ygy.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.ygy.dao.ICustomerDao;
import org.ygy.property.Mappers;
import org.ygy.util.MyBatisUtil;
import org.ygy.vo.RegisterVO;

public class CustomerDao implements ICustomerDao {
	private SqlSession session = null;  
	
	@Override
	public int selectRegisterCount(Integer page, Integer rows) {
		session = MyBatisUtil.getSession();
		
		int total = session.selectOne(Mappers.CUSTOMER + "selectRegisterPage");
		
		return total;
	}

	@Override
	public List<RegisterVO> selectRegisters(Integer page, Integer rows) {
		session = MyBatisUtil.getSession();
		
		Map<String, Integer> params = new HashMap<String , Integer>();
		params.put("page", rows*(page-1));
		params.put("rows", rows);
		
		List<RegisterVO> registerList = session.selectList(Mappers.CUSTOMER + "selectRegister",params);
		return registerList;
	}

	@Override
	public List<RegisterVO> selectRegisterChart() {
		session = MyBatisUtil.getSession();
		List<RegisterVO> registerList = session.selectList(Mappers.CUSTOMER + "selectRegisterChart");
		
		return registerList;
	}

}
