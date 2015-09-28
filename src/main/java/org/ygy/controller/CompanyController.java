package org.ygy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ygy.service.IChannelService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private IChannelService channelService;
	
	@ResponseBody
	@RequestMapping(value = "/outline/data" ,produces="text/html;charset=UTF-8")
	public String outlineData() {
		
		String result = channelService.queryCompanyData();
		
		return result;
	}	
}
