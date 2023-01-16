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
<title>Toy Figures Register Form</title>
<!-- CDN-->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/school.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="css/custom.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
    	<form action="toyfigure" method="post" class="form-horizontal" role="form">
        <h2>Registration</h2>
        
        <h3>ID : ${toyfigure.id } </h3>
        <input type="hidden" name="mode" value="UPDATE" />
        <input type="hidden" name="id" value="${toyfigure.id}" />
        
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>           
                <input type="text" value="${toyfigure.name}" id="name" name="name" placeholder="Name" class="form-control" autofocus>
        </div>
        
        <div class="mb-3">
                <label for="spareParts" class="form-label">SpareParts </label>
                <input type="number" value="${toyfigure.spareParts}" id="spareParts" name="spareParts" placeholder="Spare Parts" class="form-control">
        </div>
        
      <div class="mb-3">
            <label class="form-label">Stand</label>
            <div class="col-sm-6">
                <div class="row">
                <c:choose>
                	<c:when test="${toyfigure.stand }">
                	     <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="yes" name="stand" value="true" checked="checked" >Yes
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="no" name="stand" value="false">No
                        </label>
                    </div>
                	</c:when>
                	<c:otherwise>
                	 <div class="col-sm-4">
                	    <label class="radio-inline">
                            <input type="radio" id="yes" name="stand" value="true">Yes
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="no" name="stand" value="false" checked="checked">No
                        </label>
                    </div>
                	</c:otherwise>
                </c:choose>
                </div>
            </div>
        </div> <!-- /.form-group -->
        
        <div class="mb-3">
                <label for="price" class="form-label">Price </label>
                <input type="number" value="${toyfigure.price}" id="price" name="price" placeholder="Price" class="form-control">
        </div>
  
        <button type="submit" class="btn btn-primary btn-block">Update</button>
        <button type="reset" class="btn btn-danger btn-block">Cancel</button>
    </form> <!-- /form -->
</div> <!-- ./container -->

<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>