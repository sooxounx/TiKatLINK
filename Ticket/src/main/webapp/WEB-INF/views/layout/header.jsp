<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ticketPath" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Tik@Link</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- 네이버 지도 -->
  <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=fq5h763a1u"></script>

  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>

  <!-- include summernote css/js -->
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

  <!-- summernot를 위해서 추가해야 할 부분... -->
  <script type="text/javascript" src="${ ticketPath }/resources/summernote/summernote-lite.js"></script>
  <script type="text/javascript" src="${ ticketPath }/resources/summernote/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="${ ticketPath }/resources/summernote/summernote-lite.css">

  <!-- ajax -->
  <script src="${ ticketPath }/resources/js/httpRequest.js"></script>

  <!-- Favicons -->
  <link href="${ ticketPath }/resources/medilab/img/favicon.png" rel="icon">
  <link href="${ ticketPath }/resources/medilab/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <!-- Medilab -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <!-- ZenBlog -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;500&family=Inter:wght@400;500&family=Playfair+Display:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
  <!-- Gp -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <!-- NiceAdmin -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Template Main CSS File -->
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  <!-- Medilab -->
  <link href="${ ticketPath }/resources/medilab/css/style.css" rel="stylesheet">
  <!-- ZenBlog -->
  <link href="${ ticketPath }/resources/zenblog/css/variables.css" rel="stylesheet">
  <link href="${ ticketPath }/resources/zenblog/css/style.css" rel="stylesheet">
  <!-- Gp -->
  <link href="${ ticketPath }/resources/gp/css/style.css" rel="stylesheet">
  <!-- NiceAdmin -->
  <link href="${ ticketPath }/resources/niceadmin/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Medilab - v4.9.1
  * Template URL: https://bootstrapmade.com/medilab-free-medical-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <!-- =======================================================
  * Template Name: ZenBlog - v1.2.1
  * Template URL: https://bootstrapmade.com/zenblog-bootstrap-blog-template/
  * Author: BootstrapMade.com
  * License: https:///bootstrapmade.com/license/
  ======================================================== -->
  <!-- =======================================================
  * Template Name: Gp - v4.9.1
  * Template URL: https://bootstrapmade.com/gp-free-multipurpose-html-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <!-- =======================================================
  * Template Name: NiceAdmin - v2.4.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>
  
  <!-- ======= Top Bar ======= -->
  <!-- Medilab -->
  <div id="topbar" class="d-flex align-items-center fixed-top">
    <div class="container d-flex justify-content-between">
      <div class="contact-info d-flex align-items-center">
      	<c:choose>
			<c:when test="${!empty login }"><%--empty -> 없으면 --%>
				<i class="bi bi-envelope"></i><a href="${ ticketPath }/member/logout">로그아웃</a>
				<i class="bi bi-envelope"></i><a href="${ ticketPath }/member/withdrawalform">회원탈퇴</a> 				
		        <i class="bi bi-envelope"></i> <a href="${ ticketPath }/member/mypage">마이페이지</a>
		        <c:choose>
		        	<c:when test="${ admin == 4 }">
        				<i class="bi bi-envelope"></i> <a href="${ ticketPath }/admin/dashBoard">관리자페이지</a>
		        	</c:when>
		        </c:choose>
			</c:when>
			<c:otherwise>
				<i class="bi bi-envelope"></i><a href="${ ticketPath }/member/loginform">로그인</a>
				<i class="bi bi-envelope"></i><a href="${ ticketPath }/member/joinform">회원가입</a>				
			</c:otherwise>
		</c:choose>
        <i class="bi bi-envelope"></i> <a href="#">고객센터</a>
        <i class="bi bi-envelope"></i> <a href="#">관계사</a>
        <!-- 관리자 회원이 로그인 했을 경우 보여준다 -->
        
      </div>
    </div>
  </div>

  <!-- ======= Header ======= -->
  <!-- Medilab -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a href="/ticket/">TIK@LINK</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto active" href="/ticket/">홈</a></li>
          <li class="dropdown"><a href="#"><span>공연</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">뮤지컬</a></li>
              <li><a href="#">연극</a></li>
              <li><a href="#">콘서트</a></li>
              <li><a href="#">클래식/무용</a></li>
              <li><a href="#">아동/가족</a></li>
              <li><a href="#">전시/축제</a></li>
              <li><a href="#">레저/체험</a></li>
            </ul>
          </li>
          <li class="dropdown"><a href="#"><span>지역</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">서울</a></li>
              <li><a href="#">경기/인천</a></li>
              <li><a href="#">충청/강원</a></li>
              <li><a href="#">대구/경북</a></li>
              <li><a href="#">부산/경남</a></li>
              <li><a href="#">광주/전라</a></li>
              <li><a href="#">제주</a></li>
            </ul>
          </li>
          <li class="dropdown"><a href="#"><span>공연장</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">롯데콘서트홀</a></li>
              <li><a href="#">세종문화회관</a></li>
              <li><a href="#">LG아트센터 서울</a></li>
              <li><a href="#">대구수성아트피아</a></li>
              <li><a href="#">금호아트홀</a></li>
              <li><a href="#">안동문화예술의전당</a></li>
              <li><a href="#">대구콘서트하우스</a></li>
              <li><a href="#">대구문화예술회관</a></li>
              <li><a href="#">경주예술의전당</a></li>
              <li><a href="#">대덕문화전당/음악창작소</a></li>
              <li><a href="#">달서아트센터</a></li>
              <li><a href="#">어울아트센터</a></li>
              <li><a href="#">아양아트센터</a></li>
              <li><a href="#">광주문화예술회관</a></li>
              <li><a href="#">봉산문화회관</a></li>
              <li><a href="#">국립극장</a></li>
            </ul>
          </li>
          <li><a class="nav-link scrollto" href="${ ticketPath }/book/bookstep1form/1">예매 바로가기(테스트용)</a></li>
		  <li>
		  	<form action="${ ticketPath }/index/searchProduct" method="get" name="searchProduct">
			  	<div class="input-group">
			  		<button class="input-group-text" type="submit"><img src="${ ticketPath }/resources/niceadmin/img/search.png"></button>
			  		<input type="text" name="searchWord" class="form-control" autocomplete="off" placeholder="공연명 검색">
				</div>
	  		</form>	
		  </li>
     	</ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav>
      <!-- .navbar -->

    </div>
  </header>
  <!-- End Header -->
  
  <main id="main">