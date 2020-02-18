<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/nav.jsp" %>
	
<section>
<div class="container">
	<div class="modal-footer"><p> 제이쿼리 > chapter1 </p></div>
		
	<ul class="nav nav-tabs">
		<li><a data-toggle="tab" href="#tab1">TAB1</a></li>
		<li ><a data-toggle="tab" href="#tab2">TAB2</a></li>
		<li class="active"><a data-toggle="tab" href="#tab3">TAB3</a></li>
		<li><a data-toggle="tab" href="#tab4">TAB4</a></li>
		<li><a data-toggle="tab" href="#tab5">부트스트랩</a></li>
	</ul>

	<div class="tab-content">
	    <!-- TAB1 -->
		<div id="tab1" class="tab-pane ">
			<%@ include file="/WEB-INF/view/jquery/chapter1_tab1.jsp" %>
		</div><!-- id=tab1 -->		
	    <!-- TAB2 -->
		<div id="tab2" class="tab-pane ">
			<%@ include file="/WEB-INF/view/jquery/chapter1_tab2.jsp" %>
		</div>
		
	    <!-- TAB3 -->
		<div id="tab3" class="tab-pane fade in active">
			<%@ include file="/WEB-INF/view/jquery/chapter1_tab3.jsp" %>
		</div>
		
	    <!-- TAB4 -->
		<div id="tab4" class="tab-pane">
			<h3>TAB4</h3>
			<%@ include file="/WEB-INF/view/jquery/chapter1_tab4.jsp" %>
		</div>
		
	    <!-- TAB5 -->
		<div id="tab5" class="tab-pane">
			<%@ include file="/WEB-INF/view/jquery/chapter1_tab5.jsp" %>
		</div>
	</div>

</div>
</section>

<script type="text/javascript" src="/js/bootstrap.js"></script>	
<script>
	$(document).ready(function(){
	});
</script>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>