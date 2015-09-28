$(document).ready(function() {
	
    $.getJSON("company/lastupdate", function(json){
    	  $("#p_last_update").text(json.calendarId);
    });
	
});