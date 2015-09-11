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
	
});
