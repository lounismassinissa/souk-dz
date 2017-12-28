<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Souk-dz - ${title}</title>

<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstap theme -->
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap-theme.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">


		<!-- Navigation -->
		<%@ include file="./shared/navbar.jsp"%>>

		<div class="content">
			<!-- Load this section one user click Home -->
			<c:if test="${userClickedHome == true }">
				<%@ include file="home.jsp"%>
			</c:if>

			<!-- Load this section one user click About -->
			<c:if test="${userClickedAbout == true }">
				<%@ include file="about.jsp"%>
			</c:if>

			<!-- Load this section one user click contact -->
			<c:if test="${userClickedContact == true }">
				<%@ include file="contact.jsp"%>
			</c:if>
			
			<!-- Load this section one user click products or category products -->
			<c:if test="${userClickedAllProducts == true or userClickedCategoryProducts == true}">
					<%@ include file="listProducts.jsp"%>
			</c:if>
			
		</div>

		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/myapp.js"></script>
	</div>

</body>

</html>
