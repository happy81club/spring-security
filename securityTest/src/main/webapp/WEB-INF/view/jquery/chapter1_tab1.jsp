<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="container-fluid modal-header">
	<div class="middle">
		<div class="middle-left">
			<p style="font-size: 18px; color: red;">children(), each(), append(), prepend(), prependTo(), text(), parent(), html()</p>
			
			<br>
			<div id="root" style="background-color: gray;">
				<div>Darjeeling</div>	
				<div>Assam</div>	
				<div>Kerala</div>	
			</div>
			<br>
			<p id="basic">
			Creation is the act of producing something that has not existed before. 
			<span style="color: green;">As a result, the creative economy may mean the act of doing something that has never existed in the world in terms of finances,
			 such as a product, service or system.</span>
			 This definition made me realize why the phrase offends me so much.
			  I don’t have a memory of doing something so original that no one has ever done it before. 
			  As a newspaper reporter I live by the motto, “There is no new article under the sun.
			  ” So how would you dare to create anything related to the economy?
			   It is simply frustrating to be pushed to do something that we can’t.
			</p>
			<br>
			<button type="button" class="btn btn-primary" id="getHtml">html()</button>
		</div>
		<div class="middle-right">
			<p style="margin: 10px 10px 10px 10px;">실행결과</p>
			<div id="result" style="margin: 10px 10px 10px 10px;"></div>
			<div id="divParentTest" style="margin: 10px 10px 10px 10px;"></div>
		</div>
	</div>
</div><!-- container-fluid -->

<script>
	$(document).ready(function(){
		var $nodes = $('#root').children();
		//console.log('Number of nodes is ' + $nodes.length);
		$('#result').append('1. Number of nodes is ' + $nodes.length + "<br>");
		
		var txt = "2. ";
		$('#root').children().each(function(){
			txt += $(this).text();
		});
		$('#result').append("append >> " + txt + "<br>");
		$('#result').prepend("prepend >> " +txt + "<br>"); 
		
		$('<h2>Power of selectors</h2>').prependTo('div#result');/* prependTo() */
		
		$('#divParentTest').append($('span').parent().text());
		
		$('#getHtml').click(function(){
			alert($('p#basic').html());
		});
		
		//console.log(txt);
	});
</script>
			
