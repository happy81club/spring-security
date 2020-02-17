<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf_token" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta charset="ko">
<title>home</title>
<link rel="stylesheet" href="<c:url value="/css/layout.css"/>">
<link rel="stylesheet" href="<c:url value="/css/fromStyle.css"/>">
<!-- 
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/css/boardStyle.css"/>">
 -->
</head>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>	
<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script> 

<div id="wrapper">

	<header>header</header>
	<nav>nav</nav>
	<section>
		<c:out value="${msgCode}"/>
	</section>
	<footer>footer</footer>
    
</div>


<script type="text/javascript" src="/js/bootstrap.js"></script>	
</body>
</html>