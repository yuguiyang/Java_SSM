<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="images/favicon.ico" />
<title>BI报表平台</title>


    
    
	<!-- ECHARTS -->
	<script type="text/javascript" src="echarts/echarts.js"></script>
    <script type="text/javascript">
        
    </script>
    
    <!-- EASY UI -->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	    
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	
    <link rel="stylesheet" href="nav/styles.css">
    <script src="nav/responsive-nav.js"></script>	
    
    <script type="text/javascript" src="js/echart_customer.js"></script>
    <script type="text/javascript" src="js/easyui_customer.js"></script>
	<script type="text/javascript" src="js/easyui_date.js"></script>
	
</head>
<body>
	<!-- 导航栏 -->
	<div id="foo" class="nav-collapse">
		<ul>
			<li class="active"><a id="a_report_register" href="#">注册人数统计</a></li>
			<li><a id="a_report_channel" href="#">各渠道注册人数统计</a></li>
		</ul>
	</div>

	<!-- 内容区 -->
	<center>
	
		<div class="main">
		
			<div id="d_report_register" class="main" style="display:block;">
			
				<a href="#nav" class="nav-toggle">Menu</a>
				
				<div id="d_register_chart" style="width: 1000px; height: 600px"></div>
				
				<div id="div_customer_form" style="">
						
					<span>开始时间：</span><input class="easyui-datebox"
						data-options="formatter:myformatter,parser:myparser"
						name="cus_start_date"></input> 
						
					<span>结束时间：</span><input
						class="easyui-datebox"
						data-options="formatter:myformatter,parser:myparser" name="cus_end_date"></input>
						
					<input type="button" id="cus_query" value="查询"/>
				</div>
				
				<table id="t_register_grid" style="margin-top:20px;"></table>
			</div>
			
			<div id="d_report_channel" style="display:none;">
			
				<div id="div_channel_form" style="">
					<span>部门：</span><input class="easyui-combobox"
						name="chl_channel_type"
						data-options="valueField:'type',textField:'type',url:'channel/type'" style="width: 121px;">
						
					<span>开始时间：</span><input class="easyui-datebox"
						data-options="formatter:myformatter,parser:myparser"
						name="chl_start_date" style="width: 121px;"></input> 
						
					<span>结束时间：</span><input
						class="easyui-datebox"
						data-options="formatter:myformatter,parser:myparser" name="chl_end_date" style="width: 121px;"></input>
						
					<input type="button" id="chl_query" value="查询"/>
				</div>
							
				<table id="dg_channel" style="width: 1300px;height:800px;" ></table>
				
			</div>
			
		</div>
		
	</center>

</body>
</html>