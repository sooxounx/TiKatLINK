<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<c:set var="ticketPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">

	function changeDate(){
		
		const roundDate = document.getElementById("roundDate");
		console.log(roundDate.value);
		
		var method = "POST";
		var param = "roundDate=" + encodeURIComponent(roundDate.value);
		var url = "${ticketPath}/book/changedate";
		console.log(url);
		sendRequest(url, param, resultChangeDate, method);
	}
	
	function resultChangeDate(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			console.log("수신 완료");
			alert(data);
		}
	}
	
</script>


<section class="section profile">
	<form action="${ticketPath}/book/setStep1" method="post" name="bookStep1">
		<div class="row">
			<div class="col-lg-3">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">STEP1. 날짜선택</h5>
						<input type="date" id="roundDate" class="form-control" name="roundDate" value="2022-12-02" min="2022-12-02" onchange="changeDate()">
					</div>
				</div>
			</div>

			<div class="col-lg-5">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">STEP2. 회차선택</h5>

						<c:forEach var="vo" items="${listRound}">
							<div class="col-lg-10">
								<div class="card">
									<div class="card-body">
										<h5 class="card-title">${vo.roundTime}</h5>
										<p>${Actor.actorName}</p>
									</div>
								</div>
							</div>
							<br>
						</c:forEach>

					</div>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">예매가능좌석</h5>
						<table class="table table-borderless">
							<tbody>
								<tr>
									<td>${Seatrate.name}</td>
									<td>${Round.seatcnt}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row profile">
			<div class="col-lg-12" align="center">
				<button type="submit" class="btn btn-primary">다음단계</button>
			</div>
		</div>
	</form>
</section>



<%@ include file="/WEB-INF/views/layout/footer.jsp"%>



