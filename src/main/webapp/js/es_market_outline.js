$(document).ready(function() {
	
	//数字，格式化，千分位
	function toThousands(num) {
	    var num = (num || 0).toString(), result = '';
	    while (num.length > 3) {
	        result = ',' + num.slice(-3) + result;
	        num = num.slice(0, num.length - 3);
	    }
	    if (num) { result = num + result; }
	    return result;
	}
	
	   $('#es_market_outline').datagrid({
	    	width: '1170px',
	    	height: '600px',
	        url:'market/outline/data',
	        method:'post',
	        striped: true,
	        columns:[[
	    		{field:'name',title:'渠道名称',width:200},
	    		{field:'url',title:'监测URL',width:200},
	    		{field:'personResponse',title:'负责人',width:150},
	    		{field:'registerNum',title:'注册人数',width:150,
	    			formatter:function(val,rec){
	    				return toThousands(val);
	    			}
	    		},
	    		{field:'realNum',title:'实名人数',width:150,
	    			formatter: function(value,row,index){
	    				return toThousands(value);
	    			}
	    		},
	    		{field:'investNum',title:'投资人数',width:150,
	    			formatter: function(value,row,index){
	    				return toThousands(value);
	    			},
	    			styler: function(value,row,index){
	    			}	    			
	    		},
	    		{field:'investMoney',title:'投资金额 (万元)',width:150
	    		}
	        ]],
			rowStyler: function(index,row){
				if (index==0){
					return 'background-color:#FFE1FF;';
				}
			},
			styler:function(value, row, index) {
				return 'border:0;';				
			},			
	        onLoadSuccess: function(data){
	        	$(this).datagrid('freezeRow',0);
	    	}		        
	    });
	   
	   
	    $('#es_market_detail').tabs({
	    	border:false,
	        onSelect:function(title){
//	    		alert(title+' is selected');
	        }
	    });
	    
	    
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
	        // 1
	        var ec_register = ec.init(document.getElementById('ec_market_detail_register')); 
	        
	        $.getJSON("market/outline/detail" , {item:'register'} , function(data) {  
	        	ec_register.setOption(data); 
	        }); 
	        
	        
	        //2
	        var ec_real = ec.init(document.getElementById('ec_market_detail_real')); 

	        $.getJSON("market/outline/detail" , {item:'real'} , function(data) {  
	        	ec_real.setOption(data); 
	        });  
	        
	        
	        //3
	        var ec_invest = ec.init(document.getElementById('ec_market_detail_invest')); 
	        
	        $.getJSON("market/outline/detail" , {item:'invest'} , function(data) {
	        	ec_invest.setOption(data); 
	        });
	        
	        //4
	        var ec_money = ec.init(document.getElementById('ec_market_detail_money')); 
	        
	        $.getJSON("market/outline/detail" , {item:'money'} , function(data) {
	        	ec_money.setOption(data); 
	        });	        
	
	    }
	);	    
});