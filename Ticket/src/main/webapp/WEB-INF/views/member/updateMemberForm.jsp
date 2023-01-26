<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>
	function checkUpdateMember(){
		
		let patternTel = /^\d{3}-\d{3,4}-\d{4}$/;
		
		if(document.updateMember.memberPassword.value == ""){
			alert("비밀번호를 입력해주세요");
			document.updateMember.memberPassword.focus();
		} else if(document.updateMember.memberTel.value == ""){
			alert("전화번호를 입력해주세요");
			document.updateMember.memberTel.focus();
		}else if(document.updateMember.memberTel.value.match(patternTel) == null){
			alert("전화번호를 형식에 맞게 입력해주세요.");
			document.updateMember.memberTel.focus();
		} else if(document.updateMember.memberAddress.value == ""){
			alert("주소를 입력해주세요");
			document.updateMember.memberAddress.focus();
		} else {
			document.updateMember.submit();
		}
	}
</script>

<div class="container">

	<section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
		<div class="container">
		
			<div class="row justify-content-center">
				<div class="col-lg-5 col-md-6 d-flex flex-column align-items-center justify-content-center">
					<div class="card mb-3">
						<div class="card-body">
						
							<div class="pt-4 pb-2">
								<h5 class="card-title text-center pb-0 fs-4">회원정보 수정</h5>
							</div>
							<br>

							<form class="row g-3 needs-validation" action="${ ticketPath }/member/updatemember" method="post" name="updateMember">
							
								<div class="col-12">
									<label class="form-label">아이디</label>
									<input type="text" name="memberId" value="${ mvo.memberId }" class="form-control" disabled>
								</div>

								<div class="col-12">
									<label class="form-label">비밀번호</label>
									<input type="password" name="memberPassword" class="form-control">
								</div>

								<div class="col-12">
									<label class="form-label">이름</label>
									<input type="text" name="memberName" value="${ mvo.memberName }" class="form-control" disabled>
								</div>

								<div class="col-12">
									<label class="form-label">전화번호</label>
									<input type="text" name="memberTel" value="${ mvo.memberTel }" class="form-control">
								</div>

								<div class="col-12">
									<label class="form-label">주소</label>
									<input type="text" name="memberAddress" value="${ mvo.memberAddress }" class="form-control">
								</div>
								
								<div class="col-12">
									<h5 class="card-title"></h5>
									<button class="btn btn-primary w-100" type="button" onclick="javascript:checkUpdateMember()" >회원정보 수정하기</button>
								</div>
								
							</form>

						</div>
						
					</div>
				</div>
			</div>
			
		</div>
	</section>

</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>



