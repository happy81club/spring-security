<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="container-fluid modal-header">
	<h3>배열과 문자열</h3>
	<hr>
	<h4>2-4. 정렬</h4>
	<div class="middle height">
		<div class="middle-left height">
			<div>
 			    <p style="font-size: 15px; color: red;">문자 정렬전</p>
				<p class="allMems"></p>
			    <p style="font-size: 15px; color: red;">문자 정렬후 - sort()</p>
				<p class="sorted"></p>
			</div>
		</div>
		<div class="middle-right height outline0">
			<div>
 			    <p style="font-size: 15px; color: red;">숫자 정렬전</p>
				<p class="allNumber"></p>
			    <p style="font-size: 15px; color: red;">숫자 정렬후 - sort()</p>
				<p class="sortedNumber"></p>
			</div>
		</div>
	</div>
	<hr>
	<h4>2-5. 배열 나누기/ 합치기</h4>
	<div class="middle height">
		<div class="middle-left height">
			<div>
 			    <p style="font-size: 15px; color: red;">배열나누기 - splice()</p>
				<p class="allnum"></p>
				<p> First piece of array</p>
				<p class="firstp"></p>
				<p> Second piece of array</p>
				<p class="secondp"></p>
			</div>
		</div>
		<div class="middle-right height outline0">
			<div>
 			    <p style="font-size: 15px; color: red;">배열합치기 - concat()</p>
 			    <p> First array is</p>
				<p class="firstarr"></p>
 			    <p> Second array is</p>
				<p class="secondarr"></p>
 			    <p> Array after combination</p>
				<p class="combinedarr"></p>
			</div>
		</div>
	</div>
	<hr>
	<h4>2-6. 숫자로 구성된 배열을 문자로 변환, 부분 문자열 찾기</h4>
	<div>
		<p style="font-size: 15px; color: blue;"> Original array is</p>
		<p class="origarr"></p>
		<p style="font-size: 15px; color: blue;"> Array in form of string</p>
		<p class="arrstring"></p>
		<p style="font-size: 15px; color: blue;"> Substring is</p>
		<p class="partstirng"></p>
	</div>
	
</div><!-- container-fluid -->

<script>
	$(document).ready(function(){
		//문자정렬 
		var members = ["John", "Steve", "Ben", "Damon", "Ian"];
		$('p.allMems').html(members.join('<br/>'));
		members = members.sort(); // 정렬
		$('p.sorted').html(members.join('<br/>'));
		
		//숫자정렬
		var numbers = [45,10,3,22,7];
		$('p.allNumber').html(numbers.join('<br/>'));

		numbers = numbers.sort(function(a,b){return a-b}); // 숫자정렬
		$('p.sortedNumber').html(numbers.join('<br/>'));
		
		// 배열 나누기
		numbers = [45,10,3,22,7];
		$('p.allnum').html(numbers.join('<br/>'));

		memsecond = numbers.splice(0,3);
		$('p.firstp').html(memsecond.join('<br/>'));
		$('p.secondp').html(numbers.join('<br/>'));
		
		// 배열 합치기
		var mem1=[45,10,3];
		var mem2=[22,7];
		$('p.firstarr').html(mem1.join('<br/>'));
		$('p.secondarr').html(mem2.join('<br/>'));
		
		combinedarr = mem1.concat(mem2);
		$('p.combinedarr').html(combinedarr.join('<br/>'));
		
		
		// 2-6
		numbers = [45,10,3,22,7];
		$('p.origarr').html(numbers.join('<br/>'));
		
		var str =numbers.join("");
		$('p.arrstring').text(str);
		
		var substr = str.substr(0,3);
		$('p.partstirng').text(substr);
		
	});
</script>
			
