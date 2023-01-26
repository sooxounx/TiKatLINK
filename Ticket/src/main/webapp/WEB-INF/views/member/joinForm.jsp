<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>
	function checkJoin(){
		
		let patternId = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		let patternPw = /^[A-Za-z0-9]{4,12}$/;
		let patternTel = /^\d{3}-\d{3,4}-\d{4}$/;
		
		if(document.join.memberId.value == ""){
			alert("아이디를 입력해주세요.");
			document.join.memberId.focus();
		}else if(document.join.memberId.value.match(patternId) == null){
			alert("아이디를 이메일 형식에 맞게 입력해주세요.");
			document.join.memberId.focus();
		}else if(document.join.memberPassword.value == ""){
			alert("비밀번호를 입력해주세요.");
			document.join.memberPassword.focus();
		}else if(document.join.memberPassword.value.match(patternPw) == null){
			alert("비밀번호 형식 : 숫자와 문자 포함 형태의 6~12자리 이내");
			document.join.memberPassword.focus();
		}else if(document.join.repw.value == ""){
			alert("비밀번호 확인란을 입력해주세요.");
			document.join.repw.focus();
		}else if(document.join.memberPassword.value != document.join.repw.value){
			alert("비밀번호가 일치하지 않습니다.");
			document.join.repw.focus();
		}else if(document.join.memberName.value == ""){
			alert("이름을 입력해주세요.");
			document.join.memberName.focus();
		}else if(document.join.memberTel.value == ""){
			alert("전화번호를 입력해주세요.");
			document.join.memberTel.focus();
		}else if(document.join.memberTel.value.match(patternTel) == null){
			alert("전화번호를 형식에 맞게 입력해주세요.");
			document.join.memberTel.focus();
		}else if(document.join.memberAddress.value == ""){
			alert("주소를 입력해주세요.");
			document.join.memberAddress.focus();
		}else{
			document.join.submit();
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
								<h5 class="card-title text-center pb-0 fs-4">회원가입</h5>
							</div>
							<br>

							<form class="row g-3 needs-validation" action="${ ticketPath }/member/join" method="post" name="join" enctype="multipart/form-data">
							
								<div class="col-12">
									<label class="col-sm-3 col-form-label">프로필 이미지</label>
									<input type="file" name="file" class="form-control">
								</div>
							
								<div class="col-12">
									<input type="text" name="memberId" placeholder="아이디 (이메일 주소)" class="form-control">
								</div>

								<div class="col-12">
									<input type="password" name="memberPassword" placeholder="비밀번호 (숫자와 문자 포함 형태의 6~12자리 이내)" class="form-control">
								</div>
								
								<div class="col-12">
									<input type="password" name="repw" placeholder="비밀번호 재입력" class="form-control">
								</div>

								<div class="col-12">
									<input type="text" name="memberName" placeholder="이름" class="form-control">
								</div>

								<div class="col-12">
									<input type="text" name="memberTel" placeholder="전화번호" class="form-control">
								</div>

								<div class="col-12">
									<input type="text" name="memberAddress" placeholder="주소" class="form-control">
								</div>
								
								<div class="col-12">
									<button class="btn btn-primary w-100" type="button" onclick="javascript:checkJoin()" >회원가입하기</button>
								</div>
								
								<div class="col-12">
									<p class="small mb-0">
										이미 가입하셨나요? <a href="${ ticketPath }/member/loginform">로그인</a>
									</p>
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



