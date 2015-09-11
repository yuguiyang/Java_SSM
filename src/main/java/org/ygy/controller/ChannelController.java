package org.ygy.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.ygy.entity.PageSearch;
import org.ygy.property.BIConstants;
import org.ygy.service.IChannelService;
import org.ygy.util.Downloadutil;
import org.ygy.util.POIUtil;

@Controller
@RequestMapping("/channel")
public class ChannelController {
	
	@Autowired
	private IChannelService channelService;

	/**
	 * 获取渠道标题
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/columns" ,produces="text/html;charset=UTF-8")
	public String columns(PageSearch pageSearch) {
		
		String result = channelService.queryColumns(pageSearch);
		
		return result;
	}
	
	/**
	 * 渠道明细信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/channel" ,produces="text/html;charset=UTF-8")	
	public String channel(PageSearch pageSearch) {
		
		String result = channelService.queryChannelInfo(pageSearch);
		
		return result;
	}

	/**
	 * 获取渠道类型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/type" ,produces="text/html;charset=UTF-8")	
	public String type() {
		
		String result = channelService.queryChannelType();
		
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/export")
	public ModelAndView export(PageSearch pageSearch,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("pageSearch->" + pageSearch);
		//1. 生成文件
		List<String> headers = channelService.queryColumnsForExport(pageSearch);
		
		String ctxPath = request.getSession().getServletContext().getRealPath("/download");
		
		String filePath = ctxPath + File.separator + BIConstants.REPORT_CHL;
		
		List<ArrayList<String>> datas = channelService.queryChannelInfoForExport(pageSearch);
		
		POIUtil.export2(filePath, BIConstants.SHEET_NAME, headers, datas);
		
		///2. 下载
		Downloadutil.download(filePath, BIConstants.REPORT_CHL, response);
		
		return null;	
	}
}
