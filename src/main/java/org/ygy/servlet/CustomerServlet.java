package org.ygy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ygy.service.ICustomerService;
import org.ygy.service.impl.CustomerService;

public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = -1175148506277622740L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String act = req.getParameter("act");
		
		ICustomerService customerService = new CustomerService();
		String result = "";
		
		if("grid".equals(act)) {
			result = customerService.queryRegisterInfo();
		} else if("line".equals(act)) {
			result = customerService.queryRegisterChart();
		} else if("channel".equals(act)) {
			result = customerService.queryChannelInfo();
		} else if ("columns".equals(act)) {
			result = customerService.queryColumns();
		}
		
		PrintWriter pw = resp.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

}
