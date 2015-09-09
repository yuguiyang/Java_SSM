package org.ygy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ygy.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerControler {
	
	@Autowired
	private ICustomerService customerService;

	@ResponseBody
	@RequestMapping(value = "/trend" ,produces="text/html;charset=UTF-8")
	public String trend() {
		
		String result = customerService.queryRegisterChart();
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/grid" ,produces="text/html;charset=UTF-8")	
	public String grid(Integer page , Integer rows) {
		
		String result = customerService.queryRegisterInfo(page , rows);
		
		return result;
	}
}
