<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Farmácia</title>

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/shop.css" rel="stylesheet">

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav mr-auto">
					<jsp:useBean id="categorias"
						class="br.com.farmacia.modelo.Categorias" />
					<c:forEach var="cat" items="${categorias.categorias}">
						<li class="dropdown">
							<a class="nav-link dropdown-content" href="#" data-toggle="dropdown">${cat.key}<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<c:forEach var="subCat" items="${cat.value}">
									<li class="nav-link"><a href="#">${subCat}</a></li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>


