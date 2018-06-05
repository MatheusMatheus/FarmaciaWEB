<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Farmácia</title>

<!-- Bootstrap core CSS -->
<link href="../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../resources/css/signin.css" rel="stylesheet">
</head>

<body>

	<c:import url="menu.jsp" />
	
	<c:import url="categorias.jsp"/>

	<div class="container">
		<form class="form-signin">
			<h2 class="form-signin-heading">Entrar</h2>
			<label for="inputEmail" class="sr-only">Email</label> <input
				type="email" id="inputEmail" class="form-control" name = "email"
				placeholder="Email" required autofocus> <label
				for="inputPassword" class="sr-only">Senha</label> <input
				type="password" id="inputPassword" class="form-control" name = "senha"
				placeholder="Senha" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Lembrar
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
			<input type="hidden" name = "logica" value="LoginLogica">
		</form>

	</div>
	<!-- /container -->

</body>
</html>
