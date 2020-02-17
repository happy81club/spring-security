<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/nav.jsp" %>
	
<section>

	<div class="inner_login">
		<div class="login_tistory">

			<form:form id="join" name="join" modelAttribute="userInfo" action="/member/memberJoinProc" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
				<fieldset>
					<legend class="screen_out">회원가 입력폼</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="userId" class="screen_out">아이디</label> 
							<form:input path="userId" type="text" placeholder="ID"/>
						</div>
						<div class="inp_text">
							<label for="userName" class="screen_out">성명</label> 
							<form:input path="userName" type="text" placeholder="성명"/>
						</div>
						<div class="inp_text">
							<label for="password" class="screen_out">비밀번호</label>
							<form:input path="password" type="password" placeholder="Password"/>
						</div>
					</div>
					
					<button type="submit" class="btn_login" >가입</button>
					
				</fieldset>
				
			</form:form>
			
		</div>
	</div>

</section>

<script type="text/javascript" src="/js/bootstrap.js"></script>	
<script>
	$(document).ready(function(){
	});
</script>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>