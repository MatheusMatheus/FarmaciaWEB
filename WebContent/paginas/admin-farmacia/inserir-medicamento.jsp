<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../../resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="../../resources/css/admin/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <c:import url="menu-superior-lateral.jsp" />
  <div class="content-wrapper">
    <div class="container-fluid">
 
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Novo medicamento</div>
      <div class="card-body">
        <form action = "${pageContext.request.contextPath}/controller" method = "POST" novalidate enctype="multipart/form-data">
        <input type="hidden" name="logica" value="insere-medicamento">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="nome">Nome</label>
                <input name = "nome" class="form-control" type="text" aria-describedby="nameHelp" placeholder="Nome" required>
              </div>
              <div class="col-md-6">
                <label for="fabricante">Fabricante</label>
                <input name = "fabricante" class="form-control" type="text" aria-describedby="nameHelp" placeholder="Fabricante" required>
              </div>
            </div>
          </div>
          <div class="form-group">
             <div class="form-row">
              <div class="col-md-6">
                <label for="preco">Preço</label>
                <input name = "preco" class="form-control" type="number" step="0.01" aria-describedby="nameHelp" placeholder="Preço" required>
              </div>
              <div class="col-md-6">
                <label for="validade">Validade</label>
                <input name = "validade" class="form-control" type="date" aria-describedby="nameHelp" placeholder="Validade" required>
              </div>
            </div>          
          </div>
          
          <div class="form-group">
          	<div class="form-row">
              <div class="col-md-6">
				  <label for="sel1">Tipo</label>
	            	<jsp:useBean id="dados"
							class="br.com.farmacia.controller.util.DadosEstaticos" />
				  <select name = "tipo" class="form-control" required>
				  	<option>Selecione um tipo</option>
				    <c:forEach var = "tipo" items = "${ dados.tipoMedicamentos }">
				    	<option value = "${ tipo }">${ tipo }</option>
				    </c:forEach>
				  </select>
		      </div>
              <div class="col-md-6">
                <label for="preco">Quantidade</label>
                <input name = "quantidade" class="form-control" type="number" aria-describedby="nameHelp" placeholder="Quantidade" required>
		      </div>

          	</div>
          </div>

          <div class="form-group">
            <div class="form-row">   
            <div class = "col-md-6">
				<label for="categorias">Categoria</label>
				<select name = "categoria" class="form-control" required>
					<c:forEach var="cat" items="${dados.categorias}">
						<optgroup label="${cat.key}">
							<c:forEach var="subCat" items="${cat.value}">
								<option value = "${subCat}">${subCat}</option>
							</c:forEach>
						</optgroup>
					</c:forEach>   
				</select>         
            </div>
            
			<div class="col-md-6">
				<label for="file">Imagem do medicamento</label>
				<div class="custom-file">
				  <label class="custom-file-label" for="logoPath">Selecione a imagem</label>
				  <input type="file" class="custom-file-input" name = "logoPath" >
				</div>	
			</div>
          </div>
		</div>

		<div class="form-group">
		  <label for="descricao">Descrição</label>
		  <textarea name = "descricao" class="form-control" rows="5" ></textarea>
		</div>
          <input type = "submit" class="btn btn-primary btn-block" value = "Inserir">
        </form>
      </div>
    </div>

    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright Â© Your Website 2018</small>
        </div>
      </div>
    </footer>

    <!-- Logout Modal-->
    <c:import url="/paginas/paginas-auxiliares/confirma-logout.jsp"/>
    
    <!-- Bootstrap core JavaScript-->
    <script src="../../resources/jquery/jquery.min.js"></script>
    <script src="../../resources/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../../resources/jquery-easing/jquery.easing.min.js"></script>
    
    <!-- Page level plugin JavaScript-->
    <script src="../../resources/chart.js/Chart.min.js"></script>

    <script src="../../resources/datatables/jquery.dataTables.js"></script>
    <script src="../../resources/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="../../resources/js/admin/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="../../resources/js/admin/sb-admin-datatables.min.js"></script>
    <script src="../../resources/js/admin/sb-admin-charts.min.js"></script>
  </div>
</body>

</html>
