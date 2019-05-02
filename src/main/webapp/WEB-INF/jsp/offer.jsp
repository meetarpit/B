<!-- used display creation of new offers -->

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
    <title>Booking</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="resources/assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/assets/libs/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script> 
    <link rel="stylesheet" href="resources/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
        <link rel="stylesheet" href="resources/assets/vendor/datepicker/tempusdominus-bootstrap-4.css" />
        <script src="resources/assets/JS/validation.js"></script>
</head>

<body data-ng-app="">
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
                            <h2 class="pageheader-title">Booking </h2>
                          
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="offerList" class="breadcrumb-link">Dashboard</a></li>
                                        <li class="breadcrumb-item"><a href="offer" class="breadcrumb-link">Booking</a></li>
                                        
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
                        <!-- validation form -->
                        <!-- ============================================================== -->
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="card">
                                <h5 class="card-header">Booking Form</h5>
                                <div class="card-body">
                                  
                                      <form:form action="createoffer" method="post" modelAttribute="offer" name="offerForm">
                                        <div class="row">
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 form-group">
                                                <label for="validationCustom01">Offer Name</label>
                                                <!-- <input type="text" class="form-control" id="validationCustom01" placeholder="First name" value="Mark" required> -->
                                                <input type="text" data-ng-model="offerName" name="offerName"  class="form-control" id="validationCustom01" required>
                                               <div data-ng-if="!offerForm.offerName.$valid">
                                               <p style="color:red">Please Enter Offer Name</p>
                                               </div>
                                                
                                                
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 form-group">
                                                <label for="validationCustom02">Description</label>
                                                <!-- <input type="text" class="form-control" id="validationCustom02" placeholder="Last name" value="Otto" required> -->
                                                    <input type="text" data-ng-model="description" name="description"  class="form-control" id="validationCustom01" value="Mark" required>
                                                <div data-ng-if="!offerForm.description.$valid">
                                               <p style="color:red">Please Enter Description</p>
                                               </div>
                                            </div>
                                            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 mb-2 form-group">
                                                <label for="validationCustomUsername">Price</label>
                                                <div class="input-group">
                                                   
                                                   
                                                   <input type="text" data-ng-model="price" name="price"  class="form-control" id="validationCustom01" required>
                                                  
                                                </div>
                                                <div data-ng-if="!offerForm.price.$valid">
                                               <p style="color:red">Please Enter Price</p>
                                               </div>
                                            </div>
                                             
                                              <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 mb-2 form-group">
                                        <label>Start Date</label>
                                        <div class="input-group date" id="datetimepicker4" data-target-input="nearest">
                                            <input name="startdate" data-ng-model="startDate" type="text" class="form-control datetimepicker-input" data-target="#datetimepicker4" required>
                                            <div class="input-group-append" data-target="#datetimepicker4" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="far fa-calendar-alt"></i></div>
                                            </div>
                                     
                                    </div>
                                     <div data-ng-if="!offerForm.startDate.$valid">
                                               <p style="color:red;">Please Enter Start Date</p>
                                               </div>
                                </div>
   
                                        <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 mb-2 form-group">
                                        <label>End Date</label>
                                        <div class="input-group date "  id="datetimepickerend" data-target-input="nearest">
                                            <input name="enddate" data-ng-model="endDate" type="text" class="form-control datetimepicker-input" data-target="#datetimepickerend" required>
                                            <div class="input-group-append" data-target="#datetimepickerend" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="far fa-calendar-alt"></i></div>
                                            </div>
                                      
                                    </div>
                                     <div data-ng-if="!offerForm.endDate.$valid">
                                               <p style="color:red">Please Enter End Date</p>
                                               </div>
                                </div>
                                
                                
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                                <button class="btn btn-primary" type="submit" onclick="offer()">Create Offer</button>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <!-- ============================================================== -->
                        <!-- end validation form -->
                        <!-- ============================================================== -->
                    </div>
                    
                </div>
           
            </div>
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
        
    <!-- ============================================================== -->
    <!-- end main wrapper -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <script src="resources/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="resources/assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="resources/assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src="resources/assets/vendor/parsley/parsley.js"></script>
     <script src="resources/assets/vendor/datepicker/moment.js"></script>
    <script src="resources/assets/vendor/datepicker/tempusdominus-bootstrap-4.js"></script>
    <script src="resources/assets/vendor/datepicker/datepicker.js"></script>
    <script src="resources/assets/libs/js/main-js.js"></script>
    <script>
    $('#form').parsley();
    </script>
    <script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
    </script>
</body>
 
</html>
