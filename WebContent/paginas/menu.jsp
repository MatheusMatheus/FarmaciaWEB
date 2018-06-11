<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
		<div class="container">
			<a class="navbar-brand" href="#">Start Bootstrap</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="/FarmaciaWEB/index.jsp">Home <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/FarmaciaWEB/paginas/login.jsp"> 
						<c:choose>
							<c:when test="${not empty sessionScope.clienteValido}">
								<li class="dropdown"><a class="nav-link dropdown-toggle" 
									href="/FarmaciaWEB/index.jsp" data-toggle="dropdown">
								Bem	vindo, <c:out value="${sessionScope.clienteValido.nome}" /><span class="carret"></span></a>
									<ul class="dropdown-menu">
										<c:if test="${sessionScope.clienteValido.perfil = 'FARMACIA'}">
											<li class="nav-link"><a href="#">Inserir novos medicamentos</a></li>
											<li class="nav-link"><a href="#">Vendas realizadas</a></li>
										</c:if>		

										<c:if test="${sessionScope.clienteValido.perfil = 'CLIENTE'}">
											<li class="nav-link"><a href="#">Minha conta</a></li>
											<li class="nav-link"><a href="#">Meus pedidos</a></li>
										</c:if>		
										<li class="nav-link"><a href="/FarmaciaWEB/index.jsp" onclick = 'logout()'>Sair</a></li>
									</ul>								
								</li>
							</c:when>
							
							<c:otherwise>
								Entrar ou cadastrar-se
							</c:otherwise>
						</c:choose>
					</a>
					</li>
					<li class="dropdown"><a class="nav-link dropdown-toggle"
						href="#" data-toggle="dropdown">Carrinho<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class="nav-link"><a href="#">Page 1-1</a></li>
							<li class="nav-link"><a href="#">Page 1-2</a></li>
							<li class="nav-link"><a href="#">Page 1-3</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	
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
	
	<script src="${pageContext.request.contextPath}/resources/js/logout.js"></script>
</body>

</html>
