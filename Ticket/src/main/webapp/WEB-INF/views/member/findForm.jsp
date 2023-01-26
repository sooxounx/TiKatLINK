<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>
	function checkFindIdPw(){
		if(document.findIdPw.memberName.value == ""){
			alert("이름을 입력해주세요");
		} else if (document.findIdPw.memberTel.value == ""){
			alert("전화번호를 입력해주세요");
		} else {
			document.findIdPw.submit();
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
								<h5 class="card-title text-center pb-0 fs-4">아이디/비밀번호 찾기</h5>
							</div>
							<br>

							<form class="row g-3 needs-validation" action="${ ticketPath }/member/findidpw" method="post" name="findIdPw">
								<c:choose>
									<c:when test="${ param.mode == 'pw' }">
										<div class="col-12">
											<input type="text" name="memberId" placeholder="아이디 (이메일 주소)" class="form-control">
										</div>
									</c:when>
								</c:choose>
								
								<div class="col-12">
									<input type="text" name="memberName" placeholder="이름" class="form-control">
								</div>

								<div class="col-12">
									<input type="text" name="memberTel" placeholder="전화번호" class="form-control">
								</div>
								
								<c:choose>
									<c:when test="${ param.mode == 'id' }">
										<input type="hidden" name="mode" value="id">
										<div class="col-12">
											<button class="btn btn-primary w-100" type="button" onclick="javascript:checkFindIdPw()" >아이디 찾기</button>
										</div>
									</c:when>
									<c:otherwise>
										<input type="hidden" name="mode" value="pw">
										<div class="col-12">
											<button class="btn btn-primary w-100" type="button" onclick="javascript:checkFindIdPw()" >비밀번호 찾기</button>
										</div>
									</c:otherwise>
								</c:choose>
								
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>



