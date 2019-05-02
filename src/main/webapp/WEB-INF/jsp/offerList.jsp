 <!--used to display list of offers at admin side  -->
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
 
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="resources/assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/assets/libs/css/style.css">
    <link rel="stylesheet" href="resources/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="resources/assets/vendor/charts/chartist-bundle/chartist.css">
    <link rel="stylesheet" href="resources/assets/vendor/charts/morris-bundle/morris.css">
    <link rel="stylesheet" href="resources/assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="resources/assets/vendor/charts/c3charts/c3.css">
    <link rel="stylesheet" href="resources/assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
   <script src="resources/assets/JS/validation.js"></script>
    
    <title>Booking</title>
    
    <style>
    
    form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}
body {
       
        font-family: Arial, Helvetica, sans-serif;
    }

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
    </style>
</head>

<body>
    <!-- ============================================================== -->
    <!-- main wrapper -->
    <!-- ============================================================== -->
    <div class="dashboard-main-wrapper">
        <!-- ============================================================== -->
        <!-- navbar -->
        <!-- ============================================================== -->
      <div class="dashboard-header">
            <nav class="navbar navbar-expand-lg bg-white fixed-top">
                <a class="navbar-brand" href="#">Booking</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse " id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto navbar-right-top">
                        <li class="nav-item">
                            
                              <div id="custom-search" class="top-search-bar">
                              <form action="searchData" method="post">
                              <div class="form-inline">
                               <input class="form-control" type="text" placeholder="Search.." name="filter">
                               <button style="display:none"><i class="fa fa-search"></i></button>
                               </div>
                               
                              
                              </form>
                            </div>
                        </li>
                        
                               
                        
                        <li class="nav-item dropdown nav-user">
                            <a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="resources/assets/images/avatar-1.jpg" alt="" class="user-avatar-md rounded-circle"></a>
                            <div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
                                <div class="nav-user-info">
                                    <h5 class="mb-0 text-white nav-user-name"><%=session.getAttribute("email1") %></h5>
                                    <span class="status"></span><span class="ml-2">Available</span>
                                </div>
                                <a class="dropdown-item" href="exitadmin"><i class="fas fa-power-off mr-2"></i>Logout</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <!-- ============================================================== -->
        <!-- end navbar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- left sidebar -->
        <!-- ============================================================== -->
 <div class="nav-left-sidebar sidebar-dark">
            <div class="menu-list">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav flex-column">
                            <li class="nav-divider">
                                Menu
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="offerList" ><i class="fa fa-fw fa-user-circle"></i>Dashboard </a>
                                
                            </li>
                        
                            
                            <li class="nav-item ">
                                <a class="nav-link "  href="offer"><i class="fab fa-fw fa-wpforms"></i>Create Offer</a>
                              
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="offerList"><i class="fas fa-fw fa-table"></i>Offer List</a>
                             
                            </li>
                           
                           
                            
                      
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- end left sidebar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- wrapper  -->
        <!-- ============================================================== -->
        <div class="dashboard-wrapper">
            <div class="container-fluid  dashboard-content">
                <!-- ============================================================== -->
                <!-- pageheader -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="page-header">
                            <h2 class="pageheader-title" style="font-family:  font-family: Arial, Helvetica, sans-serif;">Offers List</h2>
                            <p class="pageheader-text">Proin placerat ante duiullam scelerisque a velit ac porta, fusce sit amet vestibulum mi. Morbi lobortis pulvinar quam.</p>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="offerList" class="breadcrumb-link">Dashboard</a></li>
                                        
                                        <li class="breadcrumb-item active" aria-current="page">OfferList</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end pageheader -->
                <!-- ============================================================== -->
                <div class="row">
                    <!-- ============================================================== -->
                    <!-- basic table  -->
                    <!-- ============================================================== -->
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card">
                            <h5 class="card-header">Offers Detail</h5>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered first">
                                       
                             <tr>
<th>Offer</th>
<th>Description</th>
<th>CreateDate</th>
<th>StartDate</th>
<th>EndDate</th>
<th>Price</th>
<th>ExpiryDate</th>
<th colspan='3'>Setting</th>
</tr>
<c:forEach items="${offer}" var="offer">
<tr>
<td>${offer.offerName}</td>
<td>${offer.description}</td>
<td>${offer.dateCreated}</td>
<td>${offer.startdate}</td>
<td>${offer.enddate}</td>
<td>${offer.price}</td>
<c:choose>
<c:when test="${offer.expiryDate==null}">
<td style="color:green">Not yet</td>
</c:when>
<c:otherwise>
<td style="color:red"><i>${offer.expiryDate}</i></td>
</c:otherwise>
</c:choose>
<td><a href="<c:url value='/get/${offer.id}'/>">Post</a></td>
<td><a href="<c:url value='/edit/${offer.id}'/>">Edit</a></td>
<td><a href="<c:url value='/delete/${offer.id}'/>" onclick="deleteConfirm()">Delete</a></td>
</tr>

</c:forEach>
</table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- end basic table  -->
                    <!-- ============================================================== -->
                </div>
               
             
            </div>
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
         
            <!-- ============================================================== -->
            <!-- end footer -->
            <!-- ============================================================== -->
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- end main wrapper -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <script src="resources/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="resources/assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="resources/assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src="resources/assets/vendor/multi-select/js/jquery.multi-select.js"></script>
    <script src="resources/assets/libs/js/main-js.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="resources/assets/vendor/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
    <script src="resources/assets/vendor/datatables/js/buttons.bootstrap4.min.js"></script>
     <script src="resources/assets/vendor/datatables/js/data-table.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
    <script src="https:///cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.colVis.min.js"></script>
    <script src="https://cdn.datatables.net/rowgroup/1.0.4/js/dataTables.rowGroup.min.js"></script>
    <script src="https://cdn.datatables.net/select/1.2.7/js/dataTables.select.min.js"></script>
    <script src="https://cdn.datatables.net/fixedheader/3.1.5/js/dataTables.fixedHeader.min.js"></script>  
    
</body>
 
</html>