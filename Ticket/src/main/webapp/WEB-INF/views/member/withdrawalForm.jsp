<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="container">

	<section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-5 col-md-6 d-flex flex-column align-items-center justify-content-center">
					<div class="card mb-3">
						<div class="card-body">

							<div class="pt-4 pb-2">
								<h5 class="card-title text-center pb-0 fs-4">회원탈퇴</h5>
							</div>
							
							<br>
							
							<form class="row g-3 needs-validation" action="${ ticketPath }/member/withdrawal" method="post" name="withdrawal">

								<div class="col-12">
									<input type="password" name="memberPassword" class="form-control" placeholder="비밀번호">
								</div>

								<div class="col-12">
									<button class="btn btn-primary w-100" type="submit">회원탈퇴하기</button>
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



