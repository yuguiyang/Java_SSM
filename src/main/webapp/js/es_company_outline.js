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
		
	var data_before = [];
	
	   $('#es_company_outline').datagrid({
	    	width: '1100px',
	    	height: 'auto',
//	    	fit:true,
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
	   
});