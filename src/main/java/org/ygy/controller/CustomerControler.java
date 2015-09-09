package org.ygy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.ygy.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerControler {
	
	@Autowired
	private ICustomerService customerService;

	@ResponseBody
	@RequestMapping("/queryUser")
	public ModelAndView queryUser(String id) {
		
		customerService.queryRegisterInfo(1, 10);
		
		return new ModelAndView("index" , "one" , "two");
	}
}
