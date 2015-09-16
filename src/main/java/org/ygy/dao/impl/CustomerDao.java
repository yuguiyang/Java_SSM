package org.ygy.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.ygy.dao.ICustomerDao;
import org.ygy.entity.PageSearch;
import org.ygy.entity.echarts.MapData;
import org.ygy.property.Mappers;
import org.ygy.vo.RegisterVO;

public class CustomerDao extends SqlSessionDaoSupport  implements ICustomerDao {
	
	@Override
	public int selectRegisterCount(PageSearch pageSearch) {
	
		int total = getSqlSession().selectOne(Mappers.CUSTOMER + "selectRegisterPage" , pageSearch);
		
		return total;
	}

	@Override
	public List<RegisterVO> selectRegisters(PageSearch pageSearch) {
		
		if(pageSearch.isAct()) {
			pageSearch.setPage(pageSearch.getRows()*(pageSearch.getPage()-1));
		}
		
		List<RegisterVO> registerList = getSqlSession().selectList(Mappers.CUSTOMER + "selectRegister",pageSearch);
		
		return registerList;
	}

	@Override
	public List<RegisterVO> selectRegisterChart() {
		
		List<RegisterVO> registerList = getSqlSession().selectList(Mappers.CUSTOMER + "selectRegisterChart");
		
		return registerList;
	}

	@Override
	public List<MapData> selectRegisterMap() {
		
		List<MapData> datas = getSqlSession().selectList(Mappers.CUSTOMER + "selectRegisterMap");
		
		return datas;
	}

}
