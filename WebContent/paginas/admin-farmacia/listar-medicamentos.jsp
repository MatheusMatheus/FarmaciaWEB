<!DOCTYPE html>
<%@page import="br.com.farmacia.modelo.FarmaciaPJ"%>
<%@page import="br.com.farmacia.modelo.Medicamento"%>
<%@page import="br.com.farmacia.dto.InsereMedicamentoDTO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.farmacia.dto.MedicamentoDTO"%>
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
  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="${pageContext.request.contextPath}/resources/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/admin/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <c:import url="menu-superior-lateral.jsp" />
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Sua Farmácia</a>
        </li>
        <li class="breadcrumb-item active">Lista de medicamentos</li>
      </ol>

      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i>  Medicamentos</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-striped table-hover" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr align="center">
                  <th align="center">Nome</th>
                  <th align="center">Preço</th>
                  <th align="center">Quantidade</th>
                  <th align="center">Categoria</th>
                  <th align="center">Detalhes</th>
                  <th align="center">Excluir</th>
                </tr>
              </thead>
              <tfoot>
                <tr align="center">
                  <th align="center">Nome</th>
                  <th align="center">Preço</th>
                  <th align="center">Quantidade</th>
                  <th align="center">Categoria</th>
                  <th align="center">Detalhes</th>
                  <th align="center">Excluir</th>
                </tr>
              </tfoot>
              <tbody>
              <%
              	Connection connection = (Connection)session.getAttribute("connection");
              	InsereMedicamentoDTO medicamentoDTO = new InsereMedicamentoDTO(connection);
              	FarmaciaPJ farmacia = (FarmaciaPJ)session.getAttribute("farmaciaValida");
              	for(Medicamento med : medicamentoDTO.getMedicamentos(farmacia)) {
              %>
              	
                 <tr align="center">
                  <td align="center"><% out.print(med.getNome()); %></td>
                  <td align="center"><% out.print(med.getPreco()); %></td>
                  <td align="center"><% out.print(med.getQuantidade()); %></td>
                  <td align="center"><% out.print(med.getCategoria()); %></td>
                  <td align="center">
                  	<a style = "cursor: pointer;" data-toggle="modal" data-target="#detalhes"
                  	onclick = "detalhar(<% out.print(med.getId()); %>)">
                  		<i class="fa fa-eye" aria-hidden="true"></i>
                  	</a>
                  </td>
                  <td align="center"><i class="fa fa-trash-o" aria-hidden="true"></i></td>
                </tr>             	
              	<% } %>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
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
    
    
    <!-- Detalhes Modal-->
    <div class="modal fade" id="detalhes" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Detalhes do medicamento</h5>

          </div>
          <div class="modal-body">Informações do medicamento aparecem aqui.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Voltar</button>
            <a class="btn btn-primary">Alterar</a>
            <a class="btn btn-primary">Excluir</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    
    <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/jquery-easing/jquery.easing.min.js"></script>
    
    <!-- Page level plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/chart.js/Chart.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/datatables/jquery.dataTables.js"></script>
    <script src="../../resources/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/resources/js/admin/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="${pageContext.request.contextPath}/resources/js/admin/sb-admin-datatables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/admin/sb-admin-charts.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/admin/manipula-medicamento.js"></script>
  </div>
</body>

</html>
