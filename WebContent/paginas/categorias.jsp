<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>
<body>

<!--Categorias -->
<nav class="navbar navbar-expand-lg navbar-light bg-light categorias">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav mr-auto">
				<!--  <li class="nav-item active"><a class="nav-link"
						href="paginas/admin-farmacia/admin-index.html">Home <span
							class="sr-only">(current)</span>
					</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="paginas/login.jsp">asdfasf</a>
					</li>-->

				<jsp:useBean id="categorias"
					class="br.com.farmacia.modelo.Categorias" />
				<c:forEach var="cat" items="${categorias.categorias}">
					<li class="dropdown"><a class="nav-link dropdown-content"
						href="#" data-toggle="dropdown">${cat.key}<span class="caret"></span></a>
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




