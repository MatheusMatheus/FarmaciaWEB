<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/shop.css" rel="stylesheet">
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
								Bem	vindo (a), <c:out value="${sessionScope.clienteValido.nome}" /><span class="carret"></span></a>
									<ul class="dropdown-menu">
	
										<li class="nav-link"><a href="/FarmaciaWEB/index.jsp" onclick = 'logout()'>Sair</a></li>
									</ul>								
								</li>
							</c:when>

							<c:when test="${not empty sessionScope.farmaciaValida}">
								<li class="dropdown"><a class="nav-link dropdown-toggle" 
									href="/FarmaciaWEB/index.jsp" data-toggle="dropdown">
								Bem	vindo, <c:out value="${sessionScope.farmaciaValida.nomeFantasia}" /><span class="carret"></span></a>
									<ul class="dropdown-menu">
										<li class="nav-link"><a href="${pageContext.request.contextPath}/paginas/admin-farmacia/admin-index.jsp">Administrar conta</a></li>
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
		
	<script type = "text/javascript">
	function logout() {
		$.ajax({
			 url: "controller",
			 data: {logica : "logout"},
			 success: function() {
				 // Recarrega a página
				 window.location.reload();
			 }
		});
	}
	</script>
</body>

</html>
