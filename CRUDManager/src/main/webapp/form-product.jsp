<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@include file="base-head.jsp"%>
<title>CRUD Manager - Inserir Produto</title>
</head>
<body>
	<%@include file="nav-menu.jsp"%>

	<div id="container" class="container-fluid">
		<h3 class="page-header">${action eq "insert" ? "Adicionar" : "Editar"}
			Produto</h3>

		<form action="${pageContext.request.contextPath}/product/${action}"
			method="POST">

			<input type="hidden" name="product_id" value="${productToEdit.getId()}">

			<div class="row">
				<div class="form-group col-md-6">
					<label for="content">Nome</label> <input type="text"
						class="form-control" id="product_name" name="product_nome"
						autofocus="autofocus" placeholder="Nome do Produto" required
						oninvalid="this.setCustomValidity('Por favor, informe o Nome do Produto.')"
						oninput="setCustomValidity('')" value="${productToEdit.getNome()}">
				</div>

				<div class="form-group col-md-6">
					<label for="content">Quantidade</label> <input type="text"
						class="form-control" id="product_quantidade" name="product_quantidade"
						autofocus="autofocus" placeholder="Quantidade do produto" required
						oninvalid="this.setCustomValidity('Por favor, informe a quantidade do produto.')"
						oninput="setCustomValidity('')" value="${productToEdit.getQuantidade()}">
				</div>

				<div class="form-group col-md-6">
					<label for="content">Marca</label> <input type="text"
						class="form-control" id="product_marca" name="product_marca"
						autofocus="autofocus" placeholder="Marca do Produto" required
						oninvalid="this.setCustomValidity('Por favor, informe a Marca do produto.')"
						oninput="setCustomValidity('')" value="${productToEdit.getMarca()}">
				</div>

				<div class="form-group col-md-6">
					<label for="product_company">Empresa</label> <select
						id="product_company" class="form-control selectpicker"
						name="product_company" required
						oninvalid="this.setCustomValidity('Por favor, informe a Empresa.')"
						oninput="setCustomValidity('')">
						<option value=""disabled ${notemptyproductToEdit ? "" : "selected"}>Selecione
							uma empresa</option>
						<c:forEach var="company" items="${companies}">
							<option value="${company.getId()}"
								${productToEdit.getCompany().getId() eq company.getId() ? "selected" : ""}>
								${company.getName()}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<hr />

			<div id="actions" class="row pull-right">
				<div class="col-md-12">
					<a href="${pageContext.request.contextPath}/products"
						class="btn btn-default">Cancelar</a>
					<button type="submit" class="btn btn-primary">${action eq "insert" ? "Criar" : "Editar"}
						Produto</button>
				</div>
			</div>

		</form>
	</div>

	<!-- IMPORTAR OS SCRIPTS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>