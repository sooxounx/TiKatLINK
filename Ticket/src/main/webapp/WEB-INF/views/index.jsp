<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<!-- Gp -->
<!-- 검색 결과 시작 -->
<c:choose>
	<c:when test="${ !empty listSearchPd }">
		<section id="team" class="team profile">
			<div class="container" data-aos="fade-up">
				<!-- 타이틀 시작 -->
				<div class="section-title">
					<h2>검색 결과</h2>
				</div>
				<!-- 타이틀 끝 -->

				<div class="row">
					<!-- 파티션 시작 -->
					<c:forEach var="search" items="${ listSearchPd }">
						<div
							class="col-lg-3 col-md-6 d-flex align-items-stretch style='font-size=3em;">
							<div class="member" data-aos="fade-up" data-aos-delay="100">
								<a href="${ ticketPath }/product/${ search.productSeq }"> <!-- 이미지 -->
									<div class="member-img">
										<img
											src="${ ticketPath }/resources/images/poster/${ search.productImage }"
											class="img-fluid" alt="">
									</div> <!-- 텍스트 -->
									<div class="member-info">
										<h4>${ search.productName }</h4>
										<span>${ search.hallName }</span> <span>${ search.productPeriodBegin }-${ search.productPeriodEnd }</span>
									</div>
								</a>
							</div>
						</div>
					</c:forEach>
					<!-- 파티션 끝 -->
				</div>

			</div>
		</section>
	</c:when>
</c:choose>
<!-- 검색 결과 끝 -->

<!-- ZenBlog -->
<!-- 히어로 이미지 시작 -->
<section id="hero-slider" class="hero-slider">
	<div class="container-md" data-aos="fade-in">
		<div class="row">
			<div class="col-12">
				<div class="swiper sliderFeaturedPosts">
					<div class="swiper-wrapper">

						<div class="swiper-slide">
							<a href="${ ticketPath }/product/${ listHero.productSeq }"
								class="img-bg d-flex align-items-end"
								style="background-image: url('${ ticketPath }/resources/images/hero/02.hero_스위니토드.jpg')">
							</a>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- 히어로 이미지 끝 -->

<!-- Gp -->
<!-- 베스트 공연/전시 시작 -->
<section id="team" class="team">
	<div class="container" data-aos="fade-up">
		<!-- 타이틀 시작 -->
		<div class="section-title">
			<h2>베스트 공연/전시</h2>
		</div>
		<!-- 타이틀 끝 -->

		<div class="row">
			<!-- 파티션 시작 -->
			<c:forEach var="best" items="${ listBest }">
				<div class="col-lg-3 col-md-6 d-flex align-items-stretch style='font-size=3em;">
					<div class="member" data-aos="fade-up" data-aos-delay="100">
						<a href="${ ticketPath }/product/${ best.productSeq }">
							<!-- 이미지 -->
							<div class="member-img">
								<img src="${ ticketPath }/resources/images/poster/${ best.productImage }"
									class="img-fluid" alt="">
							</div>
							
							<!-- 텍스트 -->
							<div class="member-info">
								<h4>${ best.productName }</h4>
								<span>${ best.hallName }</span> <span>${ best.productPeriodBegin } ~ ${ best.productPeriodEnd }</span>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
			<!-- 파티션 끝 -->
		</div>
		
	</div>
</section>
<!-- 베스트 공연/전시 끝 -->

<!-- Gp -->
<!-- 오늘의 추천 시작 -->
<section id="cta" class="cta">
	<div class="container" data-aos="zoom-in">
		<div class="text-center">
			<h3>오늘의 추천</h3>
			<p>${ listRecommend.productName }</p>
			<P>${ listRecommend.productPeriodBegin } ~ ${ listRecommend.productPeriodEnd }</P>
			<a class="cta-btn"
				href="${ ticketPath }/product/${ listRecommend.productSeq }">자세히 보기</a>
		</div>
	</div>
</section>
<!-- 오늘의 추천 끝 -->

<!-- Gp -->
<!-- 장르별 공연/전시 시작 -->
<section id="team" class="team">
	<div class="container" data-aos="fade-up">
	
		<!-- 타이틀 시작 -->
		<div class="section-title">
			<h2>장르별 공연/전시</h2>
		</div>
		<!-- 타이틀 끝 -->

		<div class="row">
			<!-- 파티션 시작 -->
			<c:forEach var="byPdtype" items="${ listByPdtype }">
				<div class="col-lg-3 col-md-6 d-flex align-items-stretch">
					<div class="member" data-aos="fade-up" data-aos-delay="200"
						style="display: flex;">
						<a href="${ ticketPath }/product/${ byPdtype.productSeq }">
						
							<!-- 이미지 -->
							<div class="member-img">
								<img src="${ ticketPath }/resources/images/poster/${ byPdtype.productImage }"
									class="img-fluid" alt="">
							</div>
							
							<!-- 텍스트 -->
							<div class="member-info">
								<h4>${ byPdtype.productName }</h4>
								<span>${ byPdtype.productPeriodBegin } ~ ${ byPdtype.productPeriodEnd }</span>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
			<!-- 파티션 끝 -->
		</div>

	</div>
</section>
<!-- 장르별 공연/전시 끝 -->


<!-- Gp -->
<!-- 지역별 공연/전시 시작 -->
<section id="team" class="team">
	<div class="container" data-aos="fade-up">
	
		<!-- 타이틀 시작 -->
		<div class="section-title">
			<h2>지역별 공연/전시</h2>
		</div>
		<!-- 타이틀 끝 -->

		<div class="row">
			<!-- 파티션 시작 -->
			<c:forEach var="byArea" items="${ listByArea }">
				<div class="col-lg-3 col-md-6 d-flex align-items-stretch">
					<div class="member" data-aos="fade-up" data-aos-delay="300">
						<a href="${ ticketPath }/product/${ byArea.productSeq }">
						
							<!-- 이미지 -->
							<div class="member-img">
								<img src="${ ticketPath }/resources/images/poster/${ byArea.productImage }"
									class="img-fluid" alt="">
							</div>

							<!-- 텍스트 -->
							<div class="member-info">
								<h4>${ byArea.productName }</h4>
								<span>${ byArea.productPeriodBegin } ~ ${ byArea.productPeriodEnd }</span>
							</div>

						</a>
					</div>
				</div>
			</c:forEach>
			<!-- 파티션 끝 -->
		</div>

	</div>
</section>
<!-- 지역별 공연/전시 끝 -->


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>



