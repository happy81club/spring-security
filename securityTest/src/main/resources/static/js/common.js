$(document).ready(function () {
	
	$.ajaxSetup({
		headers :  { 'X-CSRF-TOKEN': $('meta[name="_csrf_token"]').attr('content') },
		crossDomain: true,
		beforeSend : function(request){
		},
		complete : function(response){
		},
		error : function(data, status, xhr) {
			console.log(data);
			alert('네트워크 통신이 불안정하거나 시스템에 장애가 있습니다.');
		}
	});
	
});