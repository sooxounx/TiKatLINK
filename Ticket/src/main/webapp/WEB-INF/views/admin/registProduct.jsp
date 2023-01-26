<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	function checkRegist() {
		
		if(document.regist.productName.value == ""){
			alert("작품명을 입력해주세요.");
			document.regist.productName.focus();
		} else if(document.regist.productPeriodBegin.value == ""){
			alert("공연 시작일을 입력해주세요.");
			document.regist.productPeriodBegin.focus();
		} else if(document.regist.productPeriodEnd.value == ""){
			alert("공연 종료일을 입력해주세요.");
			document.regist.productPeriodEnd.focus();
		} else if(document.regist.productRuntime.value == ""){
			alert("관람(상영)시간을 입력해주세요.");
			document.regist.productRuntime.focus();
		} else if(document.regist.productRate.value == ""){
			alert("관람 등급을 입력해주세요.");
			document.regist.productRate.focus();
		} else if(document.regist.productDetail.value == ""){
			alert("상세 정보를 입력해주세요.");
			document.regist.productDetail.focus();
		} else if(document.regist.productCxlInfo.value == ""){
			alert("예매/취소안내를 입력해주세요.");
			document.regist.productCxlInfo.focus();
		} else if(document.regist.productCxlDeadline.value == ""){
			alert("취소수수료 적용 기간을 입력해주세요.");
			document.regist.productCxlDeadline.focus();
		} else if(document.regist.productCxlFee.value == ""){
			alert("취소수수료를 입력해주세요.");
			document.regist.productCxlFee.focus();
		} else {
			document.regist.submit();
		}
	}
</script>	

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<section class="section profile">
	<div class="row">
		<div align="center">
			<div class="col-lg-8">

				<div class="card">
					<div class="card-body">
						<h5 class="card-title"></h5>
						<h5 class="card-title">작품 등록</h5>
						<h5 class="card-title"></h5>

						<!-- General Form Elements -->
						<form action="${ ticketPath }/admin/registProduct" method="post" name="regist" enctype="multipart/form-data">
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">작품명</label>
								<div class="col-sm-10">
									<input type="text" name="productName" class="form-control">
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">포스터 이미지</label>
								<div class="col-sm-10">
									<input type="file" name="file" class="form-control">
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">공연 시작일</label>
								<div class="col-sm-10">
									<input type="date" name="productPeriodBegin" class="form-control">
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">공연 종료일</label>
								<div class="col-sm-10">
									<input type="date" name="productPeriodEnd" class="form-control">
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">공연종류</label>
								<div class="col-sm-10">
									<select name="productPdType" class="form-select" aria-label="Default select example">
										<option value="1" selected>뮤지컬</option>
										<option value="2">연극</option>
										<option value="3">콘서트</option>
										<option value="4">클래식/무용</option>
										<option value="5">대학로</option>
										<option value="6">아동/가족</option>
										<option value="7">전시/축제</option>
										<option value="8">레저/체험</option>
									</select>
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">관람(상영)시간</label>
								<div class="col-sm-10">
									<input type="text" name="productRuntime" class="form-control" placeholder="ex) 170분(인터미션:20분)">
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">관람등급</label>
								<div class="col-sm-10">
									<input type="text" name ="productRate" class="form-control" placeholder="ex) 만13세이상, 중학생이상관람가">
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label ">상세정보</label>
								<div class="col-sm-10" align="left">
									<textarea class="summernote" name="productDetail"></textarea>
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">예매/취소안내</label>
								<div class="col-sm-10" align="left">
									<textarea class="summernote" name="productCxlInfo"></textarea>
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">취소수수료 적용 기간</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" name="productCxlDeadline" placeholder="숫자만 입력 가능 (ex : '7' 입력 시 공연일 기준 7일전부터 취소수수료 적용)">
								</div>
							</div>
							<div class="row mb-3" align="right">
								<label class="col-sm-2 col-form-label">취소수수료</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" name="productCxlFee" placeholder="숫자만 입력 가능 (티켓 구매 금액 기준 %)">
								</div>
							</div>
							<div class="row mb-3">
								<label class="col-sm-2 col-form-label"></label>
								<div class="col-sm-10">
									<button type="button" class="btn btn-primary" onclick="javascript:checkRegist()">등록하기</button>
								</div>
							</div>
						</form>
							
						<!-- End General Form Elements -->

					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script>
   $(document).ready(function(){
	   $('.summernote').summernote({
         height: 200,                 // 에디터 높이
         lang: "ko-KR",	
	   });
   });
</script>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>



