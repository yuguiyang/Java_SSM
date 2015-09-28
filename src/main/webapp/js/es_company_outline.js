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
		
/*	
	var data_before = [];
	   $('#es_company_outline').datagrid({
	    	width: '1100px',
	    	height: 'auto',
//	    	fit:true,
	    	checkOnSelect:false,
	        url:'company/outline/data',
	        method:'post',
	        striped: false,//隔行变色
	        columns:[[
	            {field:'calendarId' , title:'',width:220},
	    		{field:'registerNum',title:'注册人数',width:220,
	    			formatter:function(value,row,index){
	    				if(index==1) {
	    					if(value > data_before[0]) {
	    						return toThousands(value)+ " <img src='images/arrow_up.png'></img>";
	    					} else if(value < data_before[0]){
	    						return toThousands(value)+ " <img src='images/arrow_down.png'></img>";
	    					}
	    				} else {
	    					//初始化前天数据
	    					data_before[0] = value;
	    					return toThousands(value);
	    				}
	    			},
	    			styler: function(value,row,index){
	    				
	    			}
	    		},
	    		{field:'realNum',title:'实名人数',width:220,
	    			formatter: function(value,row,index){
	    				if(index==1) {
	    					if(value > data_before[1]) {
	    						return toThousands(value)+ " <img src='images/arrow_up.png'></img>";
	    					} else if(value < data_before[1]){
	    						return toThousands(value)+ " <img src='images/arrow_down.png'></img>";
	    					}
	    				} else {
	    					//初始化前天数据
	    					data_before[1]= value;
	    					return toThousands(value);
	    				}
	    			},
	    			styler: function(value,row,index){
	    				
	    			}	    			
	    		},
	    		{field:'investNum',title:'投资人数',width:220,
	    			formatter: function(value,row,index){
	    				if(index==1) {
	    					if(value > data_before[2]) {
	    						return toThousands(value)+ " <img src='images/arrow_up.png'></img>";
	    					} else if(value < data_before[2]){
	    						return toThousands(value)+ " <img src='images/arrow_down.png'></img>";
	    					}
	    				} else {
	    					//初始化前天数据
	    					data_before[2] = value;
	    					return toThousands(value);
	    				}
	    			},
	    			styler: function(value,row,index){
	    				
	    			}	    			
	    		},
	    		{field:'investMoney',title:'投资金额 (万元)',width:220,
	    			formatter: function(value,row,index){
	    				if(index==1) {
	    					if(value > data_before[3]) {
	    						return value+ " <img src='images/arrow_up.png'></img>";
	    					} else if(value < data_before[3]){
	    						return value+ " <img src='images/arrow_down.png'></img>";
	    					}
	    				} else {
	    					//初始化前天数据
	    					data_before[3] = value;
	    					return value;
	    				}
	    			},	    			
	    			styler: function(value,row,index){
	    				
	    			}
	    		}
	        ]],
			rowStyler: function(index,row){
				if (index==0){
//					return 'background-color:#FFE1FF;';
				}
			},
	        onLoadSuccess: function(data){
//	        	$(this).datagrid('freezeRow',0);
	    	}		        
	    });
*/	   
	   

	   $('#es_company_outline').datagrid({
	    	width: '1200px',
	    	height: 'auto',
//	    	fit:true,
	    	checkOnSelect:false,
	        url:'company/outline/data',
	        method:'post',
	        striped: false,//隔行变色
	        columns:[[
	    		{field:'registerNum',title:'注册人数',width:300,align:'center',
	    			formatter:function(value,row,index){
	    				return toThousands(value);
	    			},
	    			styler: function(value,row,index){
	    				
	    			}
	    		},
	    		{field:'realNum',title:'实名人数',width:300,align:'center',
	    			formatter: function(value,row,index){
	    				return toThousands(value);
	    			},
	    			styler: function(value,row,index){
	    				
	    			}	    			
	    		},
	    		{field:'investNum',title:'投资人数',width:300,align:'center',
	    			formatter: function(value,row,index){
	    				return toThousands(value);
	    			},
	    			styler: function(value,row,index){
	    				
	    			}	    			
	    		},
	    		{field:'investMoney',title:'投资金额 (万元)',width:300,align:'center',
	    			formatter: function(value,row,index){
	    				return value;
	    			},	    			
	    			styler: function(value,row,index){
	    				
	    			}
	    		}
	        ]],
			rowStyler: function(index,row){
				if (index==0){
				}
			},
	        onLoadSuccess: function(data){
	    	}		        
	    });
	   
	    $('#es_company_detail').tabs({
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