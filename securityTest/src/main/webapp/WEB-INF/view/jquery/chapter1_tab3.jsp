<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="container-fluid modal-header">
	<h3>배열과 문자열</h3>
	<hr>
	<h4>2-1. 배열을 사용하여 이름을 리스트로 표시하기</h4>
	<p style="font-size: 15px; color: red;">	
	    join()
	</p>
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
	<p style="font-size: 15px; color: red;">	
	    map(arry, callback) - n : 배열원소 , i : 배열원소위치 (0부터시작)  , makeArray()
	</p>
	<div>
		<p id="p4"></p>
	</div>

	<hr>
	<h4>2-3. 배열 중 원하는 값만 표시</h4>
	<div class="middle height">
		<div class="middle-left height">
			<p style="font-size: 15px; color: red;">	
			    grep(array, callback, boolean) - boolean 보통생략;디폴트 false; true 결과반대,  match()
			</p>
			<div>
				<p class="allmem"></p>
				<p class="selected"></p>
			</div>
		</div>
		<div class="middle-right height outline0">
		     <p>정규식 사용법</p>
			<table border="1">
				<tr><th>문자</th>
				    <th>부합</th></tr>
				<tr><td>\b</td>
				    <td>단어의 경계</td></tr>
				<tr><td>\d</td>
				    <td>숫자(0~9)</td></tr>
				<tr><td>\s</td>
				    <td>공백하나</td></tr>
				<tr><td>\w</td>
				    <td>문자,숫자,밑줄문자</td></tr>
				<tr><td>.</td>
				    <td>새 라인 문자를 제외한 모든 문자</td></tr>
				<tr><td>[..]</td>
				    <td>대괄호 안의 문자들 중 하나</td></tr>
				<tr><td>{n}</td>
				    <td>정확히 n번</td></tr>
				<tr><td>{n,}</td>
				    <td>n번 또는 그 이상</td></tr>
				<tr><td>{n.m}</td>
				    <td>n번과 m사이</td></tr>
				<tr><td>?</td>
				    <td>0또는 여러번</td></tr>
				<tr><td>+</td>
				    <td>한번 또는 그 이상</td></tr>
				<tr><td>^</td>
				    <td>시작</td></tr>
				<tr><td>$</td>
				    <td>끝</td></tr>
			</table>
		</div>
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
		//console.log(fakeArray);
		
		var realArray = $.makeArray( fakeArray );
		//console.log(realArray);
		 
		// map(arry, callback)
		// Now it can be used reliably with $.map()
		$.map( fakeArray, function( val, key ) {
		    console.log(key + " : " + val);
		});
		
		// 2-3 ------------------------------------------------------------------------------
		
		members = ["John", "Steve", "Ben", "Damon", "Ian"];
		
		$('p.allmem').html(members.join('<br/>'));
		members = $.grep(members, function(v){
			//return v.length > 4;
			  return v.match(/^[A-D]/);
		});
		
		$('p.selected').html(members.join('<br/>'));
		
	});
</script>
			
