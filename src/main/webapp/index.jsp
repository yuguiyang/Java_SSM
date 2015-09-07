<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>BI 平台报表</title>
	
	<link rel="stylesheet" type="text/css"
		href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	

	<!-- ECHARTS -->
	<script type="text/javascript" src="echarts/echarts.js"></script>
    <script type="text/javascript">
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
                var myChart = ec.init(document.getElementById('main')); 
                
                //从后台获取json格式的数据  
                $.getJSON("customer?act=line" , function(data) {  
                    //初始化chart  
                    // 为echarts对象加载数据 
                    myChart.setOption(data); 
                }); 
                	                    
        
            }
        );
    </script>
    
    <!-- EASY UI -->
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#dg').datagrid({
		    	title: '全站注册人数统计表',
		    	width: 700,
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
            var p = $('#dg').datagrid('getPager');       
            $(p).pagination({           
                pageSize: 20,//每页显示的记录条数，默认为10           
                beforePageText: '第  ',//页数文本框前显示的汉字           
                afterPageText: '页    共 {pages} 页',           
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'                
            });		    
		   
		    /////////////////////////////// 各个渠道 注册信息 
		    var grid_channel;
		    
		    grid_channel = $('#dg_channel').datagrid({
		    	title: '各渠道注册人数统计表',
		        url:'customer?act=channel',
		        method:'get',
		        fitColumns: true,
		        singleSelect: true,
		        columns: [[]]
		    });
		    
            //从后台获取json格式的数据  
            $.getJSON("customer?act=columns" , function(data) {  
            	grid_channel.datagrid({ 
                    columns:[data] 
                }).datagrid("loadData", data);
            }); 
		});
		
	</script>

</head>
<body>

	
	<center style="margin-top:50px;">
	
		<h1>全站注册人数统计表</h1>
		<div id="main" style="width: 900px;height:400px"></div>
		<table id="dg" ></table>
		
		<table id="dg_channel" style="width: 1200px;height:800px;"></table>
	</center>
</body>
</html>