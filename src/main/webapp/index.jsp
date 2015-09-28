<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>BI平台</title>
	<link rel="shortcut icon" href="images/favicon.ico" />	
	
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
    <!-- EASY UI -->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="js/es_company_outline.js"></script>
	
	    
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="echarts/echarts.js"></script>
	
	<script type="text/javascript" src="js/base.js"></script>
	<link rel="stylesheet" href="css/base.css">
</head>
<body>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
      
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">BI平台</a>
        </div>
        
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">主页</a></li>
            <li><a href="market.jsp">市场部</a></li>
            <li><a href="#">运营部</a></li>
            <li><a href="#about">关于</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    
     <div class="container" style="font-family:microsoft yahei;">

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="page-header">
						<h1>
							公司核心KPI <small></small>
						</h1>
					</div>
					
				</div>
				<div style="text-align:right;margin-top:20px;margin-bottom:20px;">上次更新时间：<span id="p_last_update">a</span></div>
				<table id="es_company_outline" style="margin-top:20px;font-family:microsoft yahei;"></table>
				
			</div>
			
				<div id="es_company_detail" class="easyui-tabs" style="width:1200px;height:800px;padding-top:50px;padding-bottom:20px;">
				    <div title="注册人数" style="padding:20px;">
						<div id="ec_market_detail_register" style="width: 1200px; height: 400px;"></div>
				    </div>
				    
				    <div title="实名人数" style="padding:20px;">
						<div id="ec_market_detail_real" style="width: 1200px; height: 400px;"></div>
				    </div>
				    
				    <div title="投资人数"  style="padding:20px;">
						<div id="ec_market_detail_invest" style="width: 1200px; height: 400px;"></div>
				    </div>
				    
			        <div title="投资金额"  style="padding:20px;">
			            <div id="ec_market_detail_money" style="width: 1200px; height: 400px;"></div>
			        </div>	
			        	    
				</div>			

		</div>

	</div> <!-- /container -->
    
    
</body>
</html>