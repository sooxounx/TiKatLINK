<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<section class="section profile">
<div class="container-md">
	<div class="row">
		<div class="col-xl-6">

			<div class="card">
				<div class="d-flex flex-column">
					<!-- 포스터 -->
					<img src="${ ticketPath }/resources/images/poster/${ pvo.productImage }" alt="Profile">
				</div>
			</div>

		</div>

		<div class="col-xl-6">

			<div class="card">
				<div class="card-body pt-3">
					<!-- Bordered Tabs -->
					<ul class="nav nav-tabs nav-tabs-bordered">

						<li class="nav-item">
							<h3 class="card-title">${ pvo.productName }</h3>
						</li>

					</ul>
					<div class="tab-content pt-2">

						<div class="tab-pane fade show active profile-overview" id="profile-overview">
							<div class="row">
								<div class="col-lg-3 col-md-4 label ">장소</div>
								<div class="col-lg-9 col-md-8">${ pvo.hallName }</div>
							</div>

							<div class="row">
								<div class="col-lg-3 col-md-4 label">기간</div>
								<div class="col-lg-9 col-md-8">${ pvo.productPeriodBegin } ~ ${ pvo.productPeriodEnd }</div>
							</div>

							<div class="row">
								<div class="col-lg-3 col-md-4 label">관람시간</div>
								<div class="col-lg-9 col-md-8">${ pvo.productRuntime }</div>
							</div>

							<div class="row">
								<div class="col-lg-3 col-md-4 label">관람등급</div>
								<div class="col-lg-9 col-md-8">${ pvo.productRate }</div>
							</div>

							<!-- 가격 forEach문 -->
							<div class="row">
								<div class="col-lg-3 col-md-4 label">가격</div>
								<div class="col-lg-9 col-md-8">
									<c:forEach var="seatRate" items="${ seatList }">
										<tr>
											<td>${ seatRate.seatRateName }석  ${ seatRate.seatRatePrice }원</td>
											<br>
										</tr>
									</c:forEach>
								</div>
							</div>

							<!-- 할인 forEach문 -->
							<div class="row">
								<div class="col-lg-3 col-md-4 label">할인</div>
								<div class="col-lg-9 col-md-8">
									<c:forEach var="discnt" items="${ discntList }">
										<tr>
											<td>${ discnt.discntName }</td>
											<br>
										</tr>
									</c:forEach>
								</div>
							</div>
							
						</div>
					</div>
					<!-- End Bordered Tabs -->

				</div>
			</div>
		</div>
	</div>
	</div>
</section>

<section class="section">
	<div class="container-md">
		<div class="row">
			<div class="col-lg-12">

				<div class="card">
					<div class="card-body">

						<!-- 타이틀 시작 -->
						<ul class="nav nav-tabs d-flex" id="myTabjustified" role="tablist">
							<li class="nav-item flex-fill" role="presentation">
								<button class="nav-link w-100 active" id="detail-tab" data-bs-toggle="tab" data-bs-target="#detail-justified"
									type="button" role="tab" aria-controls="detail" aria-selected="true">상세정보</button>
							</li>
							<li class="nav-item flex-fill" role="presentation">
								<button class="nav-link w-100" id="review-tab" data-bs-toggle="tab" data-bs-target="#review-justified"
									type="button" role="tab" aria-controls="review" aria-selected="false">관람후기</button>
							</li>
							<li class="nav-item flex-fill" role="presentation">
								<button class="nav-link w-100" id="expect-tab" data-bs-toggle="tab" data-bs-target="#expect-justified"
									type="button" role="tab" aria-controls="expect" aria-selected="false">기대평</button>
							</li>
							<li class="nav-item flex-fill" role="presentation">
								<button class="nav-link w-100" id="placeinfo-tab" data-bs-toggle="tab" data-bs-target="#placeinfo-justified"
									type="button" role="tab" aria-controls="placeinfo" aria-selected="false">장소정보</button>
							</li>
							<li class="nav-item flex-fill" role="presentation">
								<button class="nav-link w-100" id="cxlinfo-tab" data-bs-toggle="tab" data-bs-target="#cxlinfo-justified"
									type="button" role="tab" aria-controls="cxlinfo" aria-selected="false">예매/취소안내</button>
							</li>
						</ul>
						<!-- 타이틀 끝 -->

						<div class="tab-content pt-2" id="myTabjustifiedContent">

							<!-- 상세정보 -->
							<div class="tab-pane fade show active" id="detail-justified" role="tabpanel" aria-labelledby="detail-tab">
								<h5 class="card-title"></h5>
								<pre>${ pvo.productDetail }</pre>
							</div>

							<!-- 관람후기 -->
							<div class="tab-pane fade" id="review-justified" role="tabpanel" aria-labelledby="review-tab">
								<div class="card-body">
								
									<!-- 입력창 -->
									<c:choose>
										<c:when test="${!empty login}">
											<h5 class="card-title"></h5>
											<div class="card-body">
											<p>게시판 운영규정에 맞지 않는 글은 사전 통보없이 삭제될 수 있습니다.</p>
												<div class="quill-editor-default">
													<div class="row">

														<form action="${ ticketPath }/product/writeReview/${ pvo.productSeq }" method="post" name="writeReview">
															<div class="row mb-3">
																<div class="col-sm-10">
																	<textarea class="form-control" name="reviewContent" style="height: 100px"></textarea>
																</div>
															</div>

															<div class="text-right">
																<button class="btn btn-primary" type="submit">등록</button>
															</div>
															
														</form>
														
													</div>
												</div>
											</div>
										</c:when>
									</c:choose>

									<!-- 관람후기 리스트 -->
									<ul class="list-group list-group-flush">
										<h5 class="card-title"></h5>

										<c:forEach var="review" items="${ reviewList }">
											<li class="list-group-item">
												<img src="${ ticketPath }/resources/images/profile/${ review.memberProfileImage }" alt="Profile"
												class="rounded-circle" width="50">
												<p>${ review.reviewContent }<br>${ review.memberId } | ${ review.reviewDate }</p>
											</li>
										</c:forEach>
									</ul>

								</div>
							</div>

							<!-- 기대평 -->
							<div class="tab-pane fade" id="expect-justified" role="tabpanel" aria-labelledby="expect-tab">
								<div class="card-body">
								
								<!-- 입력창 -->
									<c:choose>
										<c:when test="${!empty login}">
											<h5 class="card-title"></h5>
											<div class="card-body">
											<p>게시판 운영규정에 맞지 않는 글은 사전 통보없이 삭제될 수 있습니다.</p>
												<div class="quill-editor-default">

													<form action="${ ticketPath }/product/writeExpect/${ pvo.productSeq }" method="post" name="writeExpect">

														<div class="row mb-3">
															<div class="col-sm-10">
																<textarea class="form-control" name="expectContent" style="height: 100px"></textarea>
															</div>
														</div>

														<div class="text-right">
															<button class="btn btn-primary" type="submit">등록</button>
														</div>

													</form>

												</div>
												
											</div>
										</c:when>
									</c:choose>

									<!-- 기대평 리스트 -->
									<ul class="list-group list-group-flush">
										<h5 class="card-title"></h5>
	
										<c:forEach var="expect" items="${ expectList }">
											<li class="list-group-item">
												<img src="${ ticketPath }/resources/images/profile/${ expect.memberProfileImage }" alt="Profile"
												class="rounded-circle" width="50">
												<p>${ expect.expectContent }<br>${ expect.memberId } | ${ expect.expectDate }</p>
											</li>
										</c:forEach>
									</ul>
									
								</div>
							</div>

							<!-- 장소정보 -->
							<div class="tab-pane fade" id="placeinfo-justified" role="tabpanel" aria-labelledby="placeinfo-tab">
								
								<!-- 타이틀 -->
								<h5 class="card-title">공연장 정보</h5>
								
								<!-- 텍스트 -->
								<div class="row">
									<pre>장소 : ${ pvo.hallName }</pre>
									<pre>주소 : ${ pvo.hallAddress }</pre>
									<pre>대표번호 : ${ pvo.hallTel }</pre>
									<br>
								</div>
								
								<!-- 네이버 지도 -->
								<div class="col-sm-12">
									<div id="map" style="width:100%; height:50vh; margin: 0 auto;"></div>
								</div>
							</div>
							
							<!-- 예매/취소안내 -->
							<div class="tab-pane fade" id="cxlinfo-justified" role="tabpanel" aria-labelledby="cxlinfo-tab">
								<h5 class="card-title">예매/취소 안내</h5>
								<pre>${ pvo.productCxlInfo }</pre>
							</div>
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script type="text/javascript">
	$(function(){
		initMap();
	});
	
	function initMap() {
		
		var map = new naver.maps.Map('map', {
			center: new naver.maps.LatLng(${pvo.hallLatitude}, ${pvo.hallLongitude}),
			zoom: 15
		});
		
		var marker = new naver.maps.Marker({
	        map: map,
	        title: "남산서울타워",
	        position: new naver.maps.LatLng(${pvo.hallLatitude}, ${pvo.hallLongitude}),
	        icon: {
	            content: '<img src="${ ticketPath }/resources/images/marker.png" alt="" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 32px; height: 32px; left: 0px; top: 0px;">',
	            size: new naver.maps.Size(32, 32),
	            anchor: new naver.maps.Point(16, 32)
	        }
	    });
		
		/*  
		// 네이버 맵 생성
		var mapOptions = {
		    center: new naver.maps.LatLng(37.550179, 127.073627),
		    zoom: 12
		};
		let map = new naver.maps.Map('map', mapOptions);
		 
		// 네이버 맵 크기조정
		window.addEventListener('DOMContentLoaded', function(){
		    resize();
		    window.addEventListener('resize', resize);
		});
		 
		function resize(){
		    var Size = new naver.maps.Size(window.innerWidth, window.innerHeight);
		    map.setSize(Size);
		}
		 */
	}
</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>