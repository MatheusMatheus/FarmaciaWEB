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

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/shop.css" rel="stylesheet">

</head>

<body>

	<c:import url="paginas/paginas-auxiliares/menu.jsp"/>

	<c:import url="paginas/paginas-auxiliares/categorias.jsp"/>
	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<div class="col-12">
				<div class="row">

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="paginas/produto-descricao.html"> <img
								class="card-img-top" src="http://placehold.it/700x400" alt="">
							</a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="paginas/cliente-final/produto-descricao.html">Item
										One</a>
								</h4>
								<h5>$24.99</h5>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Amet numquam aspernatur!</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"> <img class="card-img-top"
								src="http://placehold.it/700x400" alt="">
							</a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Item Two</a>
								</h4>
								<h5>$24.99</h5>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor
									sit amet.</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"> <img class="card-img-top"
								src="http://placehold.it/700x400" alt="">
							</a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Item Three</a>
								</h4>
								<h5>$24.99</h5>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Amet numquam aspernatur!</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"> <img class="card-img-top"
								src="http://placehold.it/700x400" alt="">
							</a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Item Four</a>
								</h4>
								<h5>$24.99</h5>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Amet numquam aspernatur!</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"> <img class="card-img-top"
								src="http://placehold.it/700x400" alt="">
							</a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Item Five</a>
								</h4>
								<h5>$24.99</h5>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor
									sit amet.</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"> <img class="card-img-top"
								src="http://placehold.it/700x400" alt="">
							</a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Item Six</a>
								</h4>
								<h5>$24.99</h5>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Amet numquam aspernatur!</p>
							</div>
						</div>
					</div>

				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<c:import url="paginas/paginas-auxiliares/footer.jsp" />

	<!-- Bootstrap core JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>