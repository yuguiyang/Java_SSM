package org.ygy.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.ygy.service.ICustomerService;
import org.ygy.util.MyBatisUtil;
import org.ygy.vo.BaseVO;
import org.ygy.vo.RegisterVO;

import com.google.gson.Gson;

public class CustomerService implements ICustomerService {
	private SqlSession session = null;  
	
	@Override
	public String queryRegisterInfo() {
		session = MyBatisUtil.getSession();  
		List<RegisterVO> registerList = session.selectList("org.ygy.mapper.CustomerMapper.selectRegister");
		
		BaseVO<RegisterVO> base = new BaseVO<RegisterVO>();
		base.setTotal(registerList.size());
		base.setRows(registerList);
		
		Gson gson = new Gson();
		
		return gson.toJson(base);
	}

}
