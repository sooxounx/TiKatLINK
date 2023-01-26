<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	function checkLogin() {
		if(document.login.memberId.value == ""){
			alert("아이디를 입력해주세요.");
		} else if(document.login.memberPassword.value == ""){	
			alert("비밀번호를 입력해주세요.");
		} else {
			document.login.submit();
		}
	}
</script>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="container">

	<section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-5 col-md-6 d-flex flex-column align-items-center justify-content-center">
					<div class="card mb-3">
						<div class="card-body">

							<div class="pt-4 pb-2">
								<h5 class="card-title text-center pb-0 fs-4">로그인</h5>
							</div>
							<br>
							<form class="row g-3 needs-validation" action="${ ticketPath }/member/login" method="post" name="login">

								<div class="col-12">
									<input type="text" name="memberId" class="form-control" value="${ memberId }" placeholder="아이디 (이메일 주소)">
								</div>

								<div class="col-12">
									<input type="password" name="memberPassword" class="form-control" placeholder="비밀번호">
								</div>

								<div class="col-12">
									<div class="form-check">
										<c:choose>
											<c:when test="${ check }">
												<input class="form-check-input" type="checkbox" name="ckid" value="true" checked="checked">
											</c:when>
											<c:otherwise>
												<input class="form-check-input" type="checkbox" name="ckid" value="true">
											</c:otherwise>
										</c:choose>
										<label class="form-check-label">아이디 저장</label>
									</div>
								</div>
								<div class="col-12">
									<button class="btn btn-primary w-100" type="button" onclick="javascript:checkLogin()">로그인하기</button>
								</div>
								<div class="col-12">
									<p class="small mb-0">
										아직 가입을 안하셨다면? <a href="${ ticketPath }/member/joinform">회원가입</a>
									</p>
									<p class="small mb-0">
										아이디를 잊으셨다면? <a href="${ ticketPath }/member/findidpwform?mode=id">아이디 찾기</a>
									</p>
									<p class="small mb-0">
										비밀번호를 잊으셨다면? <a href="${ ticketPath }/member/findidpwform?mode=pw">비밀번호 찾기</a>
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



