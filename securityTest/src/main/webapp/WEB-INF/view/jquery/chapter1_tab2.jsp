<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="container">
	<h3>DOM 노드 생성하기</h3>
		<p style="font-size: 18px; color: red;">	
		    prepend(), prependTo(), clone(), append(), appendTo(), before(), insertBefore(), after(), insertAfter()
		</p>
		<hr>
		<div class="row">
		<div class="pull-right">
		    <span id="add" style="margin-right: 5px;"><a><i class="fas fa-plus"></i></a></span>
		    <span id="del"><a><i class="fas fa-minus"></i></a></span>
		</div>
		<div id="tableDiv">
			<table id="bookTable" class="table table-striped"><!-- table-bordered  table-striped -->
			<thead>
			    <tr>
			        <th><input type="checkbox" id="all" class="custom-control-input"></th>
			        <th>도서명</th>
			        <th>저자</th>
			        <th>출판사</th>
			        <th></th>
			    </tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" id="jb-checkbox" class="custom-control-input"></td>
					<td><input type="text" class="form-control" placeholder="도서명"></td>
					<td><input type="text" class="form-control" placeholder="저자"></td>
					<td><input type="text" class="form-control" placeholder="출판사"></td>
					<td>
						<button type="button" id="btnInit" class="btn btn-success">초기화</button>
						<button type="button" id="btnDel" class="btn btn-warning">삭제</button>
					</td>
				</tr>
			</tbody>
			</table>	
		</div><!-- row -->
	</div>
	
	<div id="foo">FOO!</div>
    <p id="pfoo">I would like to say: </p>
    
</div><!-- container -->

<table id="copyTable" style="display: none;">
<tbody>
	<tr>
		<td><input type="checkbox" id="jb-checkbox" class="custom-control-input"></td>
		<td><input type="text" class="form-control" placeholder="도서명"></td>
		<td><input type="text" class="form-control" placeholder="저자"></td>
		<td><input type="text" class="form-control" placeholder="출판사"></td>
		<td>
			<button type="button" id="btnInit" class="btn btn-success">초기화</button>
			<button type="button" id="btnDel" class="btn btn-warning">삭제</button>
		</td>
	</tr>
</tbody>
</table>

<script>

	$(document).ready(function(){
		
		$( "p#pfoo" ).insertBefore( "#foo" );  // (a).insertBefore(b) - b 앞에 a를 insert 한다.
		
		// 행추가
		$('span#add').on('click', function(){
			var $tr = $('#copyTable > tbody > tr').clone();
			
			//$('#bookTable > tbody:last').append($tr); // 마지막행 뒤에 add
			$('#bookTable > tbody').prepend($tr);       // 무조건 첫번째 행 add
		});

		// 행삭제
		$('span#del').on('click', function(){
			var rowLength = $('#bookTable > tbody > tr').length;
			 if(rowLength > 0) {
				$('#bookTable > tbody > tr:last').remove();
			}
			
		});
		
		// 버튼행삭제 - 동적 태그에 이벤트 바인딩
		$(document).on('click','#btnDel', function(){
			$(this).parent().parent().remove();
		});
		
		// 버튼행초기화 - 동적 태그에 이벤트 바인딩
		$(document).on('click','#btnInit', function(){
			$(this).parent().parent().each(function(){
				$(this).find('input.form-control').val('');
				$(this).find('input[type=checkbox]:checkbox').prop('checked', false);
			});
		});
		
		// 체크박스 전체 선택, 해제
		$('#all').click(function(){
			var checked = $(this).is(":checked");
			console.log(checked);
		
			$('#bookTable > tbody').find('input[type=checkbox]:checkbox').each(function() {
				if(checked) {
					$(this).prop('checked', true);
				} else {
					$(this).prop('checked', false);
				}
				// 토글처리
				/*$(this).prop('checked', function(){
					return !$(this).prop('checked');
				});*/
			});
		});
		
		
		
	});
	
</script>
			
