<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/nav.jsp" %>

<style>
.div{
  margin-top: 10px;
  width: 100%;
  height: 800px;
  position: relative;
}
.div-left{
  outline: 0px solid #9F9F9F;
  position: absolute;
  top: 0px;
  width: 30%;
  margin: 20px 5px 5px 5px;
}
.div-right{
  outline: 0px solid #9F9F9F;
  position: absolute;
  left: 38%;
  top: 0px;
  margin: 20px 5px 5px 5px;
}

.slable {float:left; width:120px;}
.infobox {width: 200px;}
.error {color:red; padding-left:10px;display: none;}
.submit {margin-left:125px; margin-top:10px;}
</style>

	
<section>
<div class="container">
	<div class="modal-footer"><p> 제이쿼리 > chapter2 </p></div>
	
	<h3>폼 유효성 확인</h3>	
	
	<div class="div">
		<div class="div-left">
			<ul>
				<li>필수항목이 입력되어있는지 확인하기</li>
				<li>숫자필드 유효성 검사</li>
				<li>전화번호 유효성 검사</li>
				<li>사용자 아이디 유효성 검사</li>
				<li>날짜 유효성 확인하기</li>
				<li>이메일 주소 유효성 확인하기</li>
				<li>체크박스 체크여부 확인하기</li>
				<li>라디오 버튼 선택여부 확인하기</li>
				<li>select 엘리먼트 항목 선택여부 확인하기</li>
				<li>폼 버튼과 옵션에 스타일 적용하기</li>
				<li>체크박스 모두 체크 또는 체크 해제하기</li>
				<li>두 개의 필드 유효성 확인하기</li>
				<li>비밀번호 필드와 비밀번호 확인 필드 비교하기</li>
				<li>특정 필드 비활성화시키기</li>
				<li>전체 폼 유효성 확인하기</li>
				<li>폼 데이터 직렬화하기</li>
			</ul>
		
		</div><!-- div-left -->
		
		<div class="div-right">
			<form action="">
				<div><span class="slable">User Id*</span><input type="text" class="infobox name" name="name"><span class="error name">This field cannot be blank</span></div>
				<div><span class="slable">Enter Age*</span><input type="text" class="infobox age" name="age"><span class="error age">This field cannot be blank</span></div>
				<div><span class="slable">phone number*</span><input type="text" class="infobox phone" name="phone"><span class="error phone">This field cannot be blank</span></div>
				
				<input type="submit" class="submit" value="submit">
			</form>
		
		</div><!-- div-right -->
	</div><!-- div -->

</div>
</section>

<script type="text/javascript" src="/js/bootstrap.js"></script>	
<script>
	$(document).ready(function(){
		
		$('.submit').click(function(e){
			// * 필수항목이 입력되어있는지 확인하기
			var data= $('.infobox').val();
			var uiddata = $('.infobox.name').val();
			var numdata = $('.infobox.age').val();
			var phonedata = $('.infobox.phone').val();
			
			var len = data.length;
			
			if(len<1) {
				$('.error').show();
				e.preventDefault(); // 서브밋 버튼이 사용자가 입력한 데이터를 서버로 보내는 것을 막는데 사용.
			}else{
				$('.error').hide();
			}
			
			// * 숫자필드 유효성 검사
			var c;
			for(var i=0;i<numdata.length;i++){
					c=numdata.charAt(i).charCodeAt(0);
					
					// 음수값 허용
					if(c==45 && i==0){
						continue;
					}
					
					// 숫자만 허용
					if(c < 48 || c>57) {
						$('.error.age').show();
						$('.error.age').text('Only numberals allowed');
						e.preventDefault();
						break;
					}else{
						$('.error.age').hide();
					}
			
					//범위 값만 허용
					var age=0;
					var flag=0;
					if(flag==0){
						age = parseInt(numdata);
						if(age<5 || age>99){
							$('.error.age').show();
							$('.error.age').text('Invalid Age. Please enter the age within the range 5 to 99');
							e.preventDefault();
						}
					}//end of (flag==0)
			  }
				
				
			// * 전화번호 유효성 검사
			if(validate_phoneno(phonedata)) {
				$('.error.phone').hide();
			}else{
				$('.error.phone').show();
				$('.error.phone').text('Phone number can contain Only numbers, + and -');
				e.preventDefault();
			}
			
			// * 사용자 아이디 유효성 검사
			if(validate_userId(uiddata)) {
				$('.error.name').hide();
			}else{
				$('.error.name').show();
				$('.error.name').text('numbers or underscore');
				e.preventDefault();
			}
			
			// * 날짜 유효성 확인하기
			
		});
		
		function validate_phoneno(ph){
			var pattern = new RegExp(/^[0-9-+]+$/);
			return pattern.test(ph);
		}
		
		function validate_userId(uid){
			var pattern = new RegExp(/^[a-z0-9_]+$/);
			return pattern.test(uid);
		}
		
	});
</script>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>