<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>表单</title>
	
    <!-- EASY UI -->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	    
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
	    $('#form_channel_query').form({
	        onSubmit: function(){
				//表单提交，只需要 重新加载Grid 
	            
	            return false;
	        }
	    });
	    
	    //自定义时间函数
		function myformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
		}
		function myparser(s){
			if (!s) return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0],10);
			var m = parseInt(ss[1],10);
			var d = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(y,m-1,d);
			} else {
				return new Date();
			}
		}
	</script>
</head>
<body>

	<form id="form_channel_query" method="post">
       <span>部门：</span><input id="channel_type" class="easyui-combobox" name="channel_type"
        					data-options="valueField:'type',textField:'type',url:'channel/type'">
       <span>开始时间：</span><input class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="start_date"></input>
       <span>结束时间：</span><input class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="end_date"></input>
       <input type="submit" id="channel_type_query"/>
    </form>

</body>
</html>