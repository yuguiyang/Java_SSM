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
	        'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
	    ],
	    function (ec) {
	        // 基于准备好的dom，初始化echarts图表
	        var myChart = ec.init(document.getElementById('d_register_chart')); 
	        
	        //从后台获取json格式的数据  
	        $.getJSON("customer/trend" , function(data) {  
	            //初始化chart  
	            // 为echarts对象加载数据 
	            myChart.setOption(data); 
	        }); 
	        	                    
	
	    }
	);
});