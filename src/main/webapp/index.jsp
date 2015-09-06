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
                
                var option = {
                	    title : {
                	        text: '未来一周气温变化'
                	    },
                	    tooltip : {
                	        trigger: 'axis'
                	    },
                	    legend: {
                	        data:['最高气温','最低气温']
                	    },
                	    xAxis : [
                	        {
                	            type : 'category',
                	            boundaryGap : false,
                	            data : ['周一','周二','周三','周四','周五','周六','周日']
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value',
                	            axisLabel : {
                	                formatter: '{value} °C'
                	            }
                	        }
                	    ],
                	    series : [
                	        {
                	            name:'最高气温',
                	            type:'line',
                	            data:[11, 11, 15, 13, 12, 13, 10]
                	        },
                	        {
                	            name:'最低气温',
                	            type:'line',
                	            data:[1, -2, 2, 5, 3, 2, 0]
                	        }
                	    ]
                	};
                	                    
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
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
		        url:'customer',
		        method:'get',
		        fitColumns: true,
		        singleSelect: true,
		        columns:[[
		    		{field:'calendarId',title:'日期',width:100},
		    		//对数字进行千分位转换格式
		    		{field:'todayAddNum',title:'新增注册人数',width:100,align:'right'},
		    		{field:'totalNum',title:'总注册人数',width:100,align:'right'}
		        ]]
		    });
		});
		
	</script>

</head>
<body>

	
	<center style="margin-top:50px;">
	
		<h1>全站注册人数统计表</h1>
		<div id="main" style="width: 900px;height:400px"></div>
		<table id="dg" style="width: 600px;height:800px;"></table>
	</center>
</body>
</html>