package org.ygy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ygy.service.IChannelService;

@Controller
@RequestMapping("/market")
public class MarketController {

	@Autowired
	private IChannelService channelService;

	/**
	 * 显示渠道整体信息_标题
	 */
	@ResponseBody
	@RequestMapping(value = "/outline/title" ,produces="text/html;charset=UTF-8")
	public String outlineTitle() {
		
		String result = channelService.queryOutlineTitle();
		
		return result;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/outline/data" ,produces="text/html;charset=UTF-8")
	public String outlineData() {
		
		String result = channelService.queryOutlineData();
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/outline/detail" ,produces="text/html;charset=UTF-8")
	public String outlineDetail(String item) {
		
		String result = channelService.queryOutlineDetail(item);
		
		return result;		
	}
}
