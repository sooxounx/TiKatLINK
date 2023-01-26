<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<section class="section profile">
	<div class="row">
		<div align="center">
			<div class="col-lg-10">

				<div class="card">
					<div class="card-body">
						<!-- 타이틀 -->
						<h5 class="card-title"></h5>
						<h5 class="card-title">작품리스트</h5>
						<div align="right">
							<a href="${ ticketPath }/admin/registProductForm" class="appointment-btn scrollto"><span class="d-none d-md-inline">작품 등록하기</span></a>
						</div>
						<h5 class="card-title"></h5>

						<!-- 리스트 -->
						<table class="table table-striped">

							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">작품명</th>
									<th scope="col">공연종류</th>
									<th scope="col">공연홀</th>
									<th scope="col">공연기간</th>
								</tr>
							</thead>
							
							<c:choose>
								<c:when test="${empty productListOnAdmin }">
									<tr>
										<td colspan="5" align="center"><span
											style="font-weight: bold;">작성한 글이 없습니다.</span></td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="productList" items="${ productListOnAdmin }">

										<tr>
											<td>${ productList.productSeq }</td>
											<td>${ productList.productName }</td>
											<td>${ productList.pdTypeName }</td>
											<td>${ productList.hallName }</td>
											<td>${ productList.productPeriodBegin }~ ${ productList.productPeriodEnd }</td>
										</tr>

									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
						<!-- End Table with stripped rows -->

					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>



