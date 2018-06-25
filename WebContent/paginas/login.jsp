<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin - Start Bootstrap Template</title>
<!-- Bootstrap core CSS-->

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">
	
</head>

<body>
	<c:import url="paginas-auxiliares/menu.jsp" />
	<c:import url="paginas-auxiliares/categorias.jsp" />
	<div class="container">
	
			<form class="form-signin"
				action="${pageContext.request.contextPath}/controller" method="POST">
				<h2 class="form-signin-heading">Entrar</h2>
				<label for="inputEmail" class="sr-only">Email</label> 
				<input type="email" name="usuario" id="inputEmail" class="form-control" 
					placeholder="Email" required autofocus> 
					
				<label for="inputPassword" class="sr-only">Senha</label> 
				<input type="password" id="inputPassword" class="form-control"
					name="senha" placeholder="Senha" required>
				<div class="checkbox">
					<a href = "cadastro/realizar-cadastro.jsp">Realizar cadastro</a>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
				<input type="hidden" name="logica" value="login">
			</form>
	


	</div>
	<!-- /container -->

	<c:import url="paginas-auxiliares/footer.jsp" />
</body>
</html>

