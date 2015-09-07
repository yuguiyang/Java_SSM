<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    <!--[if lte IE 8]><link rel="stylesheet" href="nav/responsive-nav.css"><![endif]-->
    <!--[if gt IE 8]><!--><link rel="stylesheet" href="nav/styles.css"><!--<![endif]-->
    <script src="nav/responsive-nav.js"></script>
    
    
	<!-- ECHARTS -->
	<script type="text/javascript" src="echarts/echarts.js"></script>
    <script type="text/javascript">
        
    </script>
    
    <!-- EASY UI -->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	    
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
		//注册统计人数趋势图 
		$(document).ready(function() {
			// 路径配置
	        require.config({
	            paths: {
	                echarts: 'echarts'
	            }
	        });
	        // 使用
	        require(
	            [
	                'echarts',
	                'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
	            ],
	            function (ec) {
	                // 基于准备好的dom，初始化echarts图表
	                var myChart = ec.init(document.getElementById('d_register_chart')); 
	                
	                //从后台获取json格式的数据  
	                $.getJSON("customer?act=line" , function(data) {  
	                    //初始化chart  
	                    // 为echarts对象加载数据 
	                    myChart.setOption(data); 
	                }); 
	                	                    
	        
	            }
	        );
	        
			//注册人数表格 
		    $('#t_register_grid').datagrid({
		    	title: '全站注册人数统计表',
		    	width: 800,
		    	height: 600,
		        url:'customer?act=grid',
		        method:'get',
		        fitColumns: true,
		        singleSelect: true,
		        striped: true,
		        pagination: true,
		        pageSize: 20,//每页显示的记录条数，默认为10 
		        columns:[[
		    		{field:'calendarId',title:'日期',width:100},
		    		//对数字进行千分位转换格式
		    		{field:'todayAddNum',title:'新增注册人数',width:100,align:'right'},
		    		{field:'totalNum',title:'总注册人数',width:100,align:'right'}
		        ]]
		    });
		    
            //设置分页控件       
            var p = $('#t_register_grid').datagrid('getPager');       
            $(p).pagination({           
                pageSize: 20,//每页显示的记录条数，默认为10           
                beforePageText: '第  ',//页数文本框前显示的汉字           
                afterPageText: '页    共 {pages} 页',           
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'                
            });
            
            //导航栏 
            var navigation = responsiveNav("foo", {customToggle: ".nav-toggle"});
            
            //监听a标签 
            $("#foo li a").click(function() {
            	$("#foo li").removeClass('active');
            	$(this).parent().addClass('active');
            });
            
            $("#a_report_register").click(function() {
            	$("#d_report_channel").hide();            	
            	//div d_report_register
            	$("#d_report_register").show();
            });   
            
            $("#a_report_channel").click(function() {
            	$("#d_report_register").hide();            	
            	//div d_report_register
            	$('#t_register_grid').datagrid('load','customer?act=grid');
            	$("#d_report_channel").show();
            }); 
		});
	</script>
	
</head>
<body>
	<!-- 导航栏 -->
	<div role="navigation" id="foo" class="nav-collapse">
		<ul>
			<li class="active"><a id="a_report_register" href="#">注册人数统计</a></li>
			<li><a id="a_report_channel" href="#">各渠道注册人数统计</a></li>
		</ul>
	</div>

	<!-- 内容区 -->
	<center>
	
		<div role="main" class="main">
		
			<div id="d_report_register" class="main" style="display:block;">
			
				<a href="#nav" class="nav-toggle">Menu</a>
				
				<div id="d_register_chart" style="width: 1000px; height: 600px"></div>
		
			</div>
			
			<div id="d_report_channel" style="display:none;">
			
				<table id="t_register_grid"></table>
				
			</div>
			
		</div>
		
	</center>

</body>
</html>