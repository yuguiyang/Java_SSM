package org.ygy.service;

public interface ICustomerService {
	
	public String queryRegisterInfo(Integer page, Integer rows);

	public String queryRegisterChart();

	public String queryChannelInfo();

	public String queryColumns();
}
