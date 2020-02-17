<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/nav.jsp" %>
	
<section>

	<div class="inner_login">
		<div class="login_tistory">

			<form method="post" id="authForm" action="/loginProcess">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
				<fieldset>
					<legend class="screen_out">로그인 정보 입력폼</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="username" class="screen_out">아이디</label> 
							<input type="text" id="userId" name="userId" placeholder="ID">
						</div>
						<div class="inp_text">
							<label for="password" class="screen_out">비밀번호</label>
							<input type="password" id="password" name="password" placeholder="Password">
						</div>
					</div>
					
					<button type="submit" class="btn_login" >로그인</button>
					
					<div class="login_append">
						<div class="inp_chk">
							<!-- 체크시 checked 추가 -->
							<input type="checkbox" id="keepLogin" class="inp_radio"	name="keepLogin"> 
							<label for="keepLogin" class="lab_g">
								<span class="img_top ico_check"></span> 
								<span class="txt_lab">로그인 상태 유지</span>
							</label>
						</div>
					</div>
				</fieldset>
				
			</form>
			
		</div>
	</div>

</section>

<script type="text/javascript" src="/js/bootstrap.js"></script>	
<script>
	$(document).ready(function(){
	});
</script>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>