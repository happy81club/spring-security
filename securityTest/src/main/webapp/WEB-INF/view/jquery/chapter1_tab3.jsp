<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="container-fluid modal-header">
	<h3>배열과 문자열</h3>
	<hr>
	<h4>2-1. 배열을 사용하여 이름을 리스트로 표시하기</h4>
	<div>
		<p id="p1"></p>
		<p id="p2"></p>
	</div>
	<div>
		<ol id="list"></ol>
	</div>
	<div>
		<p id="p3"></p>
	</div>
	
	<hr>
	<h4>2-2. 배열 내의 원소 조작하기</h4>
	<div>
		<p id="p4"></p>
	</div>

	<hr>
	<h4>2-3. 배열 중 원하는 값만 표시</h4>
	<div>
		<p id="p5"></p>
	</div>
	
</div><!-- container-fluid -->

<script>
	$(document).ready(function(){
		
		var members = ["John", "Steve", "Ben", "Damon", "Ian"];
		
		// 2-1-----------------------------------------------------------------------------
		$('#p1').text(members.join(","));
		$('#p2').html(members.join("<br/>"));
		
		var memlist = $('#list');
		$.each(members, function(index, value){
			memlist.append($("<li class='tab3Li'>" + value + "</li>"));
		});
		
		var names = $('li.tab3Li').get();
		$('#p3').text('Following are the ' + names.length + ' members of my Group');
		
		// 2-2 ------------------------------------------------------------------------------
		// map(arry, callback) - n : 배열원소 , i : 배열원소위치 (0부터시작)
		members = $.map(members, function(n,i){
			return(i+1 + "." + n);
		});
		
		
		$('#p4').html(members.join("<br/>"));
		
		
		var fakeArray = { "length": 2, 0: "Addy", 1: "Subtracty" };
		console.log(fakeArray);
		
		var realArray = $.makeArray( fakeArray );
		console.log(realArray);
		 
		// map(arry, callback)
		// Now it can be used reliably with $.map()
		$.map( fakeArray, function( val, key ) {
		    console.log(key + " : " + val);
		});
		
		// 2-3 ------------------------------------------------------------------------------
		
	});
</script>
			
