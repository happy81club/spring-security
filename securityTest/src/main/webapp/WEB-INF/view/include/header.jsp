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
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
<!-- 
<link rel="stylesheet" href="<c:url value="/css/boardStyle.css"/>">
 -->
</head>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>	
<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script> 

<div id="wrapper">

	<header>
		<div class="container-fluid">
		     <div class="navbar-header">
		      <a class="navbar-brand" href="#">Brand</a>
		    </div>
		     <div class="navbar-inverse">
		      <a class="navbar-brand" href="#"><c:out value="${loginUser.userId}"/></a>
		    </div>
			  <c:choose>
				  <c:when test="${loginUser.userId == null }"><a class="navbar-brand" href="/login">로그인</a></c:when>
				  <c:otherwise><c:out value="${loginUser.userName}"/>님 로그인하였습니다.</c:otherwise>
		  	  </c:choose>
	    </div>
	</header>
<script type="text/javascript" src="/js/bootstrap.js"></script>	
	