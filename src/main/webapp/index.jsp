<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Toy Store</title>
<!-- CDN-->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/school.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="css/custom.css" rel="stylesheet" />
</head>
<body>
  	<c:url var="registerURL" value="toyfigure">
  		<c:param name="mode" value="CREATE"></c:param>]
  	</c:url>
	<div class="container"></div>
	<!-- Responsive navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#"><img id="logo"
				src="assets/analytics.png" alt="logo" />Mg Pan's Toy Store</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="toyfigure">Log Out</a></li>
					<li class="nav-item"><a class="nav-link" href="registerfigure.html">Add Figure</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
	<!-- Page content-->
	<div class="container mt-5">
		<table id="toyfigure" class="table table-striped">
		
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>SpareParts</th>
					<th>Stand</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Stockin</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="toyfigure" items="${toyFigureList }">
					<c:url var="updateLink" value="toyfigure">
						<c:param name="mode" value="LOAD"></c:param>
						<c:param name="id" value="${toyfigure.id }"></c:param>
					</c:url>
					<c:url var="searchLink" value="toyfigure">
						<c:param name="mode" value="SEARCH"></c:param>
						<c:param name="name" value="${toyfigure.name }"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="toyfigure">
						<c:param name="mode" value="DELETE"></c:param>
						<c:param name="id" value="${toyfigure.id }"></c:param>
					</c:url>
					
					<tr>
						<td> <c:out value="${toyfigure.id }"></c:out> </td>
						<td> <c:out value="${toyfigure.name }"></c:out> </td>
						<td> <c:out value="${toyfigure.spareParts }"></c:out> </td>
						<td> 
							<c:choose>
						    <c:when test="${toyfigure.stand }">
						        <c:out value="Included"></c:out>
						    </c:when>
						    <c:otherwise>
						    	<c:out value="Not Included!"></c:out>
						    </c:otherwise>
						    </c:choose>
						</td>
						<td> <c:out value="${toyfigure.price }"></c:out> </td>
						<td> <c:out value="${toyfigure.quantity }"></c:out> </td>
						<td> <c:out value="${toyfigure.stockin }"></c:out> </td>
						<td> 
							<a class="btn btn-primary" href="${updateLink }"> Edit </a>
							<a class="btn btn-danger" id="delete" href="${deleteLink }"> Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>SpareParts</th>
					<th>Stand</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Stockin</th>
					<th>Action</th>
				</tr>
			</tfoot>
		</table>

	</div>	
	

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

	<script>
            $(document).ready(function () {
                 $('#toyfigure').DataTable();
            });
        </script>
        
</body>
</html>
