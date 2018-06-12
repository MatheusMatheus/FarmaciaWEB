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
	<div class="form-group collapse pessoa-fisica">
		<div class="form-row">
		    <div class="col-md-6 mb-3">
		      <label for="primeiroNome">Primeiro nome</label>
		      <input name = "primeiroNome" type="text" class="form-control" id="primeiroNome" placeholder="Primeiro nome" required>
		      <div class="invalid-feedback">
		        Por favor, insira o seu primeiro nome.
		      </div>
		    </div>
		    
		    <div class="col-md-6 mb-3">
		      <label for="sobrenome">Sobrenome</label>
		      <input name = "sobrenome" type="text" class="form-control" id="sobrenome" placeholder="Sobrenome" required>
		      <div class="invalid-feedback">
		        Por favor, insira o seu sobrenome.
		      </div>
		    </div>
		</div>	
		
		<div class="form-row">
		    <div class="col-md-6 mb-3">
		      <label for="cpf">CPF</label>
		      <input name = "cpf" type="text" class="form-control" id="cpf" placeholder="CPF" required>
		      <div class="invalid-feedback">
		        Por favor, insira o CPF.
		      </div>
		    </div>

		    <div class="col-md-6 mb-3">
		      <label for="dtnasc">Data de Nascimento</label>
		      <input name = "dtnasc" type="date" class="form-control" id="dtnasc" placeholder="Data de Nascimento" required>
		      <div class="invalid-feedback">
		         Por favor, insira a data de nascimento.
		      </div>
		    </div>
		</div>	
		
		<div class="form-row">
		 	 <label class="control-label">Sexo</label>
			 <div class="col-md-8 mb-3">
				<div class="custom-control custom-radio custom-control-inline">
				  <input type="radio" id="masculino" name="sexo" class="custom-control-input">
				  <label class="custom-control-label" for="masculino">Masculino</label>
				</div>
				
				<div class="custom-control custom-radio custom-control-inline">
				  <input type="radio" id="feminino" name="sexo" class="custom-control-input">
				  <label class="custom-control-label" for="feminino">Feminino</label>
				</div>
				
				<div class="custom-control custom-radio custom-control-inline">
				  <input type="radio" id="outro" name="sexo" class="custom-control-input">
				  <label class="custom-control-label" for="outro">Outro</label>
				</div>								 
			 </div>
		</div>									
	</div>
</body>
</html>