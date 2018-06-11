<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">
	
	<c:import url="menu.jsp" />

	<div class="container">
	
			<form class="form-signin"
				action="${pageContext.request.contextPath}/controller" method="POST">
				<h2 class="form-signin-heading">Entrar</h2>
				<label for="inputEmail" class="sr-only">Email</label> <input
					type="email" id="inputEmail" class="form-control" name="usuario"
					placeholder="Email" required autofocus> <label
					for="inputPassword" class="sr-only">Senha</label> <input
					type="password" id="inputPassword" class="form-control"
					name="senha" placeholder="Senha" required>
				<div class="checkbox">
					<a href = "realizar-cadastro.jsp">Realizar cadastro</a>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
				<input type="hidden" name="logica" value="sessao.LoginLogica">
			</form>
	


	</div>
	<!-- /container -->

	<c:import url="footer.jsp" />

