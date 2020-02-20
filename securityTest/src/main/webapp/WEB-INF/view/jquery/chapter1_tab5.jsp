<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<style>
  table {
    width: 70%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th {
    border-bottom: 1px solid #444444;
    padding: 10px;
    text-align: center;
    background-color: #bbdefb;
  }
  td {
    border-bottom: 1px solid #444444;
    padding: 10px;
    text-align: center;
    background-color: #e3f2fd;
  }
  /*
  th:nth-child(2n), td:nth-child(2n) {
    background-color: #bbdefb;
  }
  th:nth-child(2n+1), td:nth-child(2n+1) {
    background-color: #e3f2fd;
  }
  */
</style>

<div class="container-fluid modal-header">
	<h3>배열과 문자열</h3>
	<hr>
	<h4>2-7. 객체의 배열 만들기</h4>
	<div>
		<p style="font-size: 15px; color: blue;"> 객체 배열 - each(), append() </p>
		<p class="listofstud"></p>
		<p style="font-size: 15px; color: blue;"> 객체 배열(TABLE) - each(),append() </p>
		<table class="tablelistofstud" border="1"></table>
	</div>
	<hr>
	<h4>2-8. 객체의 배열 정렬</h4>
	<div>
		<p style="font-size: 15px; color: blue;"> sort() - role(숫자) </p>
		<table class="tablelistofsort" border="1"></table>
		<p style="font-size: 15px; color: blue;"> sort() - name(문자) </p>
		<table class="tablelistofsortName" border="1"></table>
	</div>
</div>
<script>
	$(document).ready(function(){
		var students=[
			{
				"role":101,
				"name":"Ben",
				"emailId":"ben@gmail.com"
			},
			{
				"role":102,
				"name":"Ian",
				"emailId":"ian@gmail.com"
			},
			{
				"role":103,
				"name":"Caroline",
				"emailId":"carol@gmail.com"
			}
		];
		
		$.each(students, function(index, value){
			$('p.listofstud').append(value.role + " " + value.name + " " + value.emailId);
		});
		
		$('table.tablelistofstud').append("<tr><th>role</th><th>name</th><th>emil</th></tr>");
		$.each(students, function(index, value){
			$('table.tablelistofstud').append("<tr><td>" +  value.role + "</td><td>" +  value.name + "</td><td>" + value.emailId + "</td></tr>");
		});
		
		// 배열객체정렬
		students = students.sort(function(a,b){
			return b.role-a.role;
		});
		
		$('table.tablelistofsort').append("<tr><th>role</th><th>name</th><th>emil</th></tr>");
		$.each(students, function(index, value){
			$('table.tablelistofsort').append("<tr><td>" +  value.role + "</td><td>" +  value.name + "</td><td>" + value.emailId + "</td></tr>");
		});
		
		students = students.sort(function(a,b){
			if(a.name<b.name) {return -1}
			if(a.name>b.name) {return 1}
			return 0;
		});
		
		$('table.tablelistofsortName').append("<tr><th>role</th><th>name</th><th>emil</th></tr>");
		$.each(students, function(index, value){
			$('table.tablelistofsortName').append("<tr><td>" +  value.role + "</td><td>" +  value.name + "</td><td>" + value.emailId + "</td></tr>");
		});
	});
</script>
			
