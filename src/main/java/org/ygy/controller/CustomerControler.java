package org.ygy.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
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
import org.ygy.service.ICustomerService;
import org.ygy.util.POIUtil;
import org.ygy.vo.RegisterVO;

@Controller
@RequestMapping("/customer")
public class CustomerControler {

	@Autowired
	private ICustomerService customerService;

	@ResponseBody
	@RequestMapping(value = "/trend", produces = "text/html;charset=UTF-8")
	public String trend() {

		String result = customerService.queryRegisterChart();

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/grid", produces = "text/html;charset=UTF-8")
	public String grid(PageSearch pageSearch) {

		String result = customerService.queryRegisterInfo(pageSearch);

		return result;
	}

	/**
	 * 导出功能
	 * 1. 生成文件
	 * 2. 进行下载
	 * @param pageSearch
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/export")
	public ModelAndView  export(PageSearch pageSearch,HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(pageSearch);
		//1. 生成文件
		pageSearch.setAct(false);
		List<String> headers = new ArrayList<String>();
		headers.add("日期");
		headers.add("新增注册人数");
		headers.add("总注册人数");

		List<RegisterVO> datas = customerService.queryRegisterForExport(pageSearch);
		
		String ctxPath = request.getSession().getServletContext().getRealPath("/download");
		
		String filePath = ctxPath + File.separator + BIConstants.EXCEL_NAME;
		
		System.out.println(filePath);
		
		POIUtil.export(filePath, BIConstants.SHEET_NAME, headers, datas);
		
		///2. 下载
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		long fileLength = new File(filePath).length();

		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment; filename="
				+ new String(BIConstants.EXCEL_NAME.getBytes("utf-8"), "ISO8859-1"));
		response.setHeader("Content-Length", String.valueOf(fileLength));

		bis = new BufferedInputStream(new FileInputStream(filePath));
		bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();	

		return null;
	}
	
}
