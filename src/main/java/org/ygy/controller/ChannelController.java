package org.ygy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ygy.service.IChannelService;

@Controller
@RequestMapping("/channel")
public class ChannelController {
	
	@Autowired
	private IChannelService channelService;

	@ResponseBody
	@RequestMapping(value = "/columns" ,produces="text/html;charset=UTF-8")
	public String columns() {
		
		String result = channelService.queryColumns();
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/channel" ,produces="text/html;charset=UTF-8")	
	public String channel() {
		
		String result = channelService.queryChannelInfo();
		
		return result;
	}
}
