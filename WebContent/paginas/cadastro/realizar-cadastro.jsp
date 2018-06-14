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
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/resources/css/admin/sb-admin.css"
	rel="stylesheet">
</head>

<body>
	<c:import url="../paginas-auxiliares/menu.jsp" />
	<c:import url="../paginas-auxiliares/categorias.jsp" />

	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Cadastro</div>
			<div class="card-body">
				<form method = "POST" action = "${pageContext.request.contextPath}/controller" class="needs-validation" novalidate>
					<input type = "hidden" name = "logica" class = "logica"/>
					<div class="form-group">
						<div class="form-row">
							  <!-- <input type="radio" id="pacienteConsumidor" name="perfil" class="custom-control-input"
							  data-toggle="collapse" data-target="#pessoaFisica"> -->
							  <div class="col-md-6 mb-3 text-center">
							  <button type="button" class="btn btn-primary" id="pacienteConsumidor" name="perfil"
							  data-toggle="collapse" data-target="#pessoaFisica">Paciente ou consumidor</button>
							</div>
							
							<div class="col-md-6 mb-3 text-center">
							 <!-- <input type="radio" id="propFarmacia" name="perfil" class="custom-control-input"
							  data-toggle="collapse" data-target="#pessoaJuridica"> --> 
							  
							  <button type="button" class="btn btn-primary"  name="perfil"
							  data-toggle="collapse" data-target="#pessoaJuridica">Proprietário de farmácia</button>
							  </div>
						</div>	
					</div>
					<c:import url="comum.jsp"/>
					<c:import url="pessoa-fisica.jsp"/>
					<c:import url="pessoa-juridica.jsp"/>

				<div class="text-center">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Registrar</button>
					<a class="d-block small mt-3" href="login.jsp">Entrar</a> <a
						class="d-block small" href="esqueceu-senha.html">Esqueceu a
						senha?</a>
				</div>
				</form>
			</div>
		</div>
	</div>

	<c:import url="../paginas-auxiliares/footer.jsp" />
	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/resources/jquery-easing/jquery.easing.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/js/aux-cadastro.js"></script>
</body>

</html>
