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
	<c:import url="paginas-auxiliares/menu.jsp" />
	<c:import url="paginas-auxiliares/categorias.jsp" />

	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Cadastro</div>
			<div class="card-body">
				<div class="form-group" id = "grupo">
					<div class="custom-control custom-radio custom-control-inline">
					  <input type="radio" id="pacienteConsumidor" name="perfil" class="custom-control-input">
					  <label class="custom-control-label" for="pacienteConsumidor">Paciente ou consumidor</label>
					</div>
					
					<div class="custom-control custom-radio custom-control-inline">
					  <input type="radio" id="propFarmacia" name="perfil" class="custom-control-input">
					  <label class="custom-control-label" for="propFarmacia">Proprietário de farmácia</label>
					</div>						
				</div>
				<form method = "POST" action = "${pageContext.request.contextPath}/controller" class="needs-validation" novalidate>
					<!-- A lógica será definida no arquivo aux-cadastro.js -->
					<input type = "hidden" class = "logica" name = "logica" value = ""/>
					<div class="form-row">
					    <div class="col-md-6 mb-3">
					      <label for="telefone">Telefone</label>
					      <input name = "telefone" type="text" class="form-control" id="telefone" placeholder="Telefone" required>
					      <div class="invalid-feedback">
					        Por favor, insira o telefone.
					      </div>
					    </div>						

						<div class="col-md-6 mb-3">
						  <label for="email">Email</label>
							  <div class="input-group">
								    <div class="input-group-prepend">
								      <span class="input-group-text" id="inputGroupPrepend">@</span>
								  </div>
								    <input name = "email" type="text" class="form-control" id="email" placeholder="Email" aria-describedby="inputGroupPrepend" required>
								   <div class="invalid-feedback">
								     Por favor, insira o email.
								   </div>
							  </div>
						</div>	
					</div>
					
					<div class="form-row">
						<div class="col-md-6 mb-3">
						  <label for="senha">Senha</label>
							  <div class="input-group">
								    <input name = "senha" type="password" class="form-control" id="senha" placeholder="Senha" required>
								   <div class="invalid-feedback">
								     Por favor, insira a senha.
								   </div>
							  </div>
						</div>						

						<div class="col-md-6 mb-3">
						  <label for="confirma-senha">Confirmar Senha</label>
							  <div class="input-group">
								    <input name = "confirma-senha" type="password" class="form-control" id="confirma-senha" placeholder="Confirmar Senha" required>
								   <div class="invalid-feedback">
								     Por favor, insira a senha.
								   </div>
							  </div>
						</div>	
					</div>
					
					<div class="form-row">
						 <div class="col-md-8 mb-3">
						      <label for="endereco">Endereço</label>
						      <input name = "endereco" type="text" class="form-control" id="endereco" placeholder="Endereco" required>
						      <div class="invalid-feedback">
						        Por favor, insira um endereço.
						      </div>						 
						 </div>
						 
					    <div class="col-md-4 mb-3">
					      <label for="cep">CEP</label>
					      <input name= "cep" type="text" class="form-control" id="cep" placeholder="CEP" required>
					      <div class="invalid-feedback">
					        Por favor, insira um CEP.
					      </div>
					    </div>	
					</div>
					
					<div class="form-row">
					    <div class="col-md-6 mb-3">
					      <label for="estado">Estado</label>
					      <input name = "estado" type="text" class="form-control" id="estado" placeholder="Estado" required>
					      <div class="invalid-feedback">
					        Por favor, insira um estado.
					      </div>
					    </div>						

					    <div class="col-md-6 mb-3">
					      <label for="cidade">Cidade</label>
					      <input name= "cidade" type="text" class="form-control" id="cidade" placeholder="Cidade" required>
					      <div class="invalid-feedback">
					        Por favor, insira uma cidade.
					      </div>
					    </div>	
					</div>
									

										
					<div class="form-group collapse pessoa-juridica">
						<div class="form-row">
						    <div class="col-md-6 mb-3">
						      <label for="razaoSocial">Razão Social</label>
						      <input name = "razaoSocial" type="text" class="form-control" id="razaoSocial" placeholder="Razão Social" required>
						      <div class="valid-feedback">
						        Ok!
						      </div>
						    </div>

						    <div class="col-md-6 mb-3">
						      <label for="nomeFantasia">Nome Fantasia</label>
						      <input name = "nomeFantasia" type="text" class="form-control" id="nomeFantasia" placeholder="Nome Fantasia" required>
						      <div class="valid-feedback">
						        Ok!
						      </div>
						    </div>
						</div>
						
						<div class="form-row">
							<div class="col-md-12 mb-3">
						      <label for="cnpj">CNPJ</label>
						      <input name = "cnpj" type="text" class="form-control" id="cnpj" placeholder="CNPJ" required>
						      <div class="valid-feedback">
						        Ok!
						      </div>
						    </div>
						</div>
						
						<div class="form-row">
							<div class="col-md-12 mb-3">
								<div class="custom-file">
								  <input type="file" class="custom-file-input" id="logoPath" name = "logoPath">
								  <label class="custom-file-label" for="logoPath">Logomarca</label>
								</div>	
							</div>
						</div>
					</div>
					

					<button class="btn btn-lg btn-primary btn-block" type="submit">Registrar</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="login.jsp">Entrar</a> <a
						class="d-block small" href="esqueceu-senha.html">Esqueceu a
						senha?</a>
				</div>
			</div>
		</div>
	</div>

	<c:import url="paginas-auxiliares/footer.jsp" />
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
