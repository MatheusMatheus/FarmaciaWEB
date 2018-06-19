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
	
 <!-- Begin page content -->
    <main role="main" class="container">
      <h1 class="mt-5">Farmácia já cadastrada</h1>
      <p class="lead">O email informado já se encontra na base de dados, por favor insira outro.</p>
      <p><a href="${pageContext.request.contextPath}/paginas/cadastro/realizar-cadastro.jsp">Clique aqui para retornar à página de cadastro</a></p>
    </main>


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
