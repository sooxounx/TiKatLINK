<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<!-- End Page Title -->
<div class="container-md">
	<section class="section profile col-xl-9">
		<div class="row">
			<div class="pagetitle">
				<h1>회원정보</h1>
			</div>
			<div class="col-xl-4">
	
				<div class="card">
					<div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
						<img src="${ ticketPath }/resources/images/profile/${ mvo.memberProfileImage }" alt="Profile"
							class="rounded-circle" width="150">
						<h2>${ mvo.memberName }</h2>
					</div>
				</div>
				<h5 class="card-title"></h5>
	
				<div align="center">
					<a href="${ ticketPath }/member/updatememberform" class="appointment-btn scrollto"><span class="d-none d-md-inline">회원정보 수정하기</span></a>
				</div>
			</div>
	
			<div class="col-xl-8">
	
				<div class="card">
					<div class="card-body pt-3">
						<!-- Bordered Tabs -->
						<ul class="nav nav-tabs nav-tabs-bordered">
	
							<li class="nav-item">
								<h5 class="card-title">회원 상세정보</h5>
							</li>
	
						</ul>
						<div class="tab-content pt-2">
	
							<div class="tab-pane fade show active profile-overview"
								id="profile-overview">
	
								<h5 class="card-title"></h5>
	
								<div class="row">
									<div class="col-lg-3 col-md-4 label ">아이디</div>
									<div class="col-lg-9 col-md-8">${ mvo.memberId }</div>
								</div>
	
								<div class="row">
									<div class="col-lg-3 col-md-4 label">연락처</div>
									<div class="col-lg-9 col-md-8">${ mvo.memberTel }</div>
								</div>
	
								<div class="row">
									<div class="col-lg-3 col-md-4 label">주소</div>
									<div class="col-lg-9 col-md-8">${ mvo.memberAddress }</div>
								</div>
	
								<div class="row">
									<div class="col-lg-3 col-md-4 label">회원등급</div>
									<div class="col-lg-9 col-md-8">${ mvo.membershipName }</div>
								</div>
	
							</div>
	
						</div>
					</div>
		
				</div>
		</div>
					
	</section>
</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>



