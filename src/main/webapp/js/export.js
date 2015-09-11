$(document).ready(function() {

	$("#cus_export").click(function() {
		
		var start_date=$("[name='cus_start_date']").val();
		var end_date=$("[name='cus_end_date']").val();
		
		var url = 'customer/export?startDate=' +start_date + '&endDate=' + end_date; 
		window.location.href=url;
		
/*		$.post("customer/export",{
	        startDate: start_date,
	        endDate: end_date			
		});*/
	});
	
	
	$("#chl_export").click(function() {
		
		var channel_type=$("[name='chl_channel_type']").val();
		var start_date=$("[name='cus_start_date']").val();
		var end_date=$("[name='cus_end_date']").val();
		
		var url = 'channel/export?startDate=' +start_date + '&endDate=' + end_date + '&channelType=' + channel_type; 
		window.location.href=url;

	});	
});
