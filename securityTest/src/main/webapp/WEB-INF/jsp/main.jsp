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
		<p>이렇게
		<span style="border: 3px solid red">span요소로 텍스트의 일부분</span>
		만을 따로 묶은 후에 스타일을 적용할 수 있습니다만을 따로 묶은 후에 스타일을 적용할 수 있습니다.만을 따로 묶은 후에 스타일을 적용할 수 있습니다.만을 따로 묶은 후에 스타일을 적용할 수 있습니다..</p>

	</section>
	<footer>footer</footer>
    
</div>


<script type="text/javascript" src="/js/bootstrap.js"></script>	
</body>
</html>