$(document).ready(function() {
	
	//全局变量 
	var local_load = false;
	
	//查询按钮 事件监听
	$("#cus_query").click(function() {
		
		var start_date=$("[name='cus_start_date']").val();
		var end_date=$("[name='cus_end_date']").val();
		
		//获取参数 数据
	    $('#t_register_grid').datagrid('load', {
	        startDate: start_date,
	        endDate: end_date
	    });		
		
	});
	
    
	/*
		2. EasyUI 注册人数表格
	*/
    $('#t_register_grid').datagrid({
    	title: '全站注册人数统计表',
    	width: '900px',
    	height: '600px',
        url:'customer/grid',
        method:'get',
        //fitColumns: true,
        striped: true,
        pagination: true,
        pageSize: 20,//每页显示的记录条数，默认为10 
        columns:[[
    		{field:'calendarId',title:'日期',width:290},
    		//对数字进行千分位转换格式
    		{field:'todayAddNum',title:'新增注册人数',width:290,align:'right'},
    		{field:'totalNum',title:'总注册人数',width:290,align:'right'}
        ]],
        onLoadSuccess: function(data){
        	//待表格数据加载完成后，进行操作
           /* var panel = $(this).datagrid('getPanel');   
            var tr = panel.find('div.datagrid-body tr');   
            tr.each(function(){   
                var td = $(this).children('td[field="todayAddNum"]');   
                td.children("div").css({   
                    "color": "red" ,
                    "font-weight":"bold"
                });   
                ;   
            });*/ 
    	}		        
    });

    //设置分页控件       
    var p = $('#t_register_grid').datagrid('getPager');       
    $(p).pagination({
        pageSize: 20,//每页显示的记录条数，默认为10
        beforePageText: '第  ',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
    });	
    
    
    /*
    $('#t_register_grid').datagrid({
    	loadFilter: function(data){
    		var a = data;
			//在这里可以对所有数据进行处理,千分位 
			return data;
    	}
    });
    */
    
    

    /* 
    	3. EasyUI 各个渠道 注册信息
    */
    var grid_channel;
    
    grid_channel = $('#dg_channel').datagrid({
    	title: '各渠道注册人数统计表',
        //url:'customer?act=channel',
        method:'get',
        fitColumns: true,
        singleSelect: true,
        columns: [[]],
        striped: true
       // pagination: true
    });
    
    


    /*
      	4. 导航栏 
    */
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
    	 
    	//动态加载数据 
			if(!local_load) {
				$('#dg_channel').datagrid('load','channel/channel');
				
	           	//动态加载Grid的列   
	            $.getJSON("channel/columns" , function(data) {  
	            	grid_channel.datagrid({ 
	                    columns:[data] 
	                });//.datagrid("loadData", data);
	            	
					//可以获取标题 信息 
				    var columns = grid_channel.datagrid("options").columns;
					
					for(var index=2; index<columns[0].length; index++) {
						var eachColumn = columns[0][index];
						eachColumn.styler = function (value,row,index) {
							if(value > 0) {
								return 'background-color:#FFE1FF;';
							}
						}
					}				
	            	
	            });
	           	
				
				local_load = true;
			} 
    	
    	$("#d_report_channel").show();
    });     
});