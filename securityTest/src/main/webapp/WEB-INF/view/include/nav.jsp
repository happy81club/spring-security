<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse">
	<div class="list-group">
	  <c:choose>
		  <c:when test="${loginVO.userId == null }">
			  <a href="<c:url value='/login'/>" class="list-group-item">로그인</a>
			  <a href="<c:url value='/member/join'/>" class="list-group-item">회원가입</a>
		  </c:when>
		  <c:otherwise>
		  	<a href="<c:url value='/logout'/>" class="list-group-item">로그아웃</a>
		  </c:otherwise>
	  </c:choose>
	  
	</div>

	
	<div class="list-group">
	  <a href="<c:url value='/jquery/chapter1'/>" class="list-group-item active dropdown-toggle" data-toggle="dropdown" aria-expanded="false">제이쿼리</a> <!-- active disabled  -->
		  <a href="<c:url value='/jquery/chapter1'/>" class="list-group-item">chapter1</a>
		  <a href="<c:url value='/jquery/chapter2'/>" class="list-group-item">chapter2</a>
		  <a href="<c:url value='/jquery/chapter3'/>" class="list-group-item">chapter3</a>
		  <a href="<c:url value='/bootstrap'/>" class="list-group-item">부트스트랩</a>
	</div>
	

	<!-- 로그인이 필요한 폴더 -->
	<%-- <sec:authorize access="hasRole('ROLE_USER')"> --%>
	<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_SUPER')">
	<div class="list-group">
	  	<a href="<c:url value='/user/main'/>" class="list-group-item active dropdown-toggle" data-toggle="dropdown" aria-expanded="false">USER</a> <!-- active disabled  -->
		<a href="<c:url value='/user/main'/>" class="list-group-item">main</a>
	</div>
	</sec:authorize>

	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')">
		<!-- 로그인이 필요한 폴더 -->
		<div class="list-group">
		  	<a href="<c:url value='/admin/main'/>" class="list-group-item active dropdown-toggle" data-toggle="dropdown" aria-expanded="false">ADMIN</a> <!-- active disabled  -->
			<a href="<c:url value='/admin/main'/>" class="list-group-item">main</a>
		</div>
	</sec:authorize>
	
</nav>

<script type="text/javascript" src="/js/bootstrap.js"></script>	
<script>
	$(document).ready(function(){
	});
</script>
		
		
