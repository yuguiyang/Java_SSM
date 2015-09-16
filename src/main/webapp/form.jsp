<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>表单</title>
	
		<!-- ECHARTS -->
	<script type="text/javascript" src="echarts/echarts.js"></script>
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		/* 
			1. Echarts
		*/
		require.config({
		    paths: {
		        echarts: 'echarts'
		    }
		});
		
		require(
		    [
		        'echarts',
		        'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
		    ],
		    function (ec) {
		        // 基于准备好的dom，初始化echarts图表
		        var myChart = ec.init(document.getElementById('chart_map_cus_register')); 
		        
		        //从后台获取json格式的数据  
		        $.getJSON("customer/map" , function(data) {  
		            //初始化chart  
		            // 为echarts对象加载数据 
		            myChart.setOption(data); 
		        }); 
		        	                    
		
		    }
		);
	});
	</script>
</head>
<body>
	<div id="chart_map_cus_register" style="width: 1000px; height: 600px"></div>
</body>
</html>