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
			if (xhr.status == 401) {
	            alert("인증에 실패 했습니다. 로그인 페이지로 이동합니다.");
	            location.href = "/login";
	         } else if (xhr.status == 403) {
	            alert("세션이 만료가 되었습니다. 로그인 페이지로 이동합니다.");
	              location.href = "/logout";
	         }

		}
	});
	
});