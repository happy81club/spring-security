<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/nav.jsp" %>
	
<section>
	<h1>Admin User is login is... </h1>
	<h6><c:out value="${loginUser.userId}"/></h6>

</section>

<script type="text/javascript" src="/js/bootstrap.js"></script>	
<script>
	$(document).ready(function(){
	});
</script>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>