<%--
  Created by IntelliJ IDEA.
  User: Hasindu
  Date: 1/2/2021
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>USERO</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i,900" rel="stylesheet">

    <!-- Vendor CSS Files -->

    <link href="${pageContext.request.contextPath}/vendor/icofont/icofont.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendor/venobox/venobox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendor/aos/aos.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/modifyUser.css">

</head>

<body>

<!-- ======= Top Bar ======= -->

<jsp:include page="topbar.jsp"></jsp:include>

<!-- ======= End Top Bar ======= -->
<!-- ======= Header ======= -->
<jsp:include page="header.jsp"></jsp:include>

<!-- End Header -->




<main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
        <div class="container">

            <div class="d-flex justify-content-between align-items-center">
                <h2>Modify User Details</h2>
                <ol>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="portfolio.html">Modify User Details</a></li>

                </ol>
            </div>

        </div>
    </section><!-- Breadcrumbs Section -->
    <!-- ======= User Details Modification Section ======= -->

    <section id="about" class="about">
        <div  class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-sm-3 pl-5 pl-sm-0">
                    <img src="${pageContext.request.contextPath}/images/img-01.png" alt="IMG">
                </div>
            <form:form class="col-sm-7 validate-form" action="save-user" modelAttribute="user">
                <form:hidden path="userId"/>
                <div class="form-row validate-input" >
                    <div class="form-group col-md-6" data-validate="user name is required">
                        <label for="userName">User Name</label>
                        <form:input class="form-control input100" type="text" name="userName" placeholder="User Name" path="userName"/>
                    </div>
                    <div class="form-group col-md-6" data-validate="Password is required">
                        <label for="pass">Password</label>
                        <form:input class="form-control input100" type="password" name="pass" placeholder="Password" path="password" />

                    </div>
                </div>
                <div class="form-row validate-input">
                <div class="form-group col-md-6" data-validate="First name is required">
                    <label for="firstName">First name</label>
                    <form:input class="form-control input100" type="text" name="firstName" placeholder="firstname" path="firstName"/>

                </div>
                <div class="form-group col-md-6" data-validate="Last name is required">
                    <label for="lastName">Last name</label>
                    <form:input class="form-control input100" type="text" name="lastName" placeholder="lastName" path="lastName"/>
                </div>
                </div>
                <div class="form-row validate-input">
                    <div class="form-group col-md-6"data-validate="Contact Number is required">
                        <label for="contactNumber">Contact Number</label>

                        <form:input class="input100 form-control" type="number" name="contactNumber" placeholder="ContactNumber"
                                    path="contactNumber"/>
                    </div>

                    <div class="form-group col-md-6">

                        <label for="inputState">User Role</label>
                        <form:select id="inputState" class="form-control" path="userRoleType" >
                            <form:option value="Standard" label="Standard"/>
                        </form:select>
                    </div>
                </div>
                <div class="form-row validate-input">

                    <div class="form-group col-12" data-validate="Address is required" >
                        <label for="address">Address</label>
                        <form:input class="input100 form-control" type="text" name="address" placeholder="Address" path="address"/>
                    </div>
                </div>
                <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="gridRadios" class="pr-2">Gender</label>
                    <div class="form-check pl-4 d-inline-block">
                        <form:radiobutton class="form-check-input "  name="gridRadios" id="gridRadios1"
                                          path="gender" value="Male" checked="checked"
                        />


                        <label class="form-check-label pl-0" for="gridRadios1">
                            Male
                        </label>
                    </div>
                    <div class="form-check pl-4 d-inline-block">
                        <form:radiobutton class="form-check-input"  name="gridRadios" id="gridRadios2"
                                          path="gender" value="female"/>

                        <label class="form-check-label pl-0" for="gridRadios2">
                            Female
                        </label>
                    </div>
                </div>
                </div>
                <div class="container-login100-form-btn">
                    <input type="submit" class="btn btn-primary" value="Save"/>


                </div>
            </form:form>
            </div>
        </div>

    </section><!-- End of  User Details Modification  Section -->









</main><!-- End #main -->

<!-- ======= Footer ======= -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->


<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/php-email-form/validate.js"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery-sticky/jquery.sticky.js"></script>
<script src="${pageContext.request.contextPath}/vendor/venobox/venobox.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/waypoints/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/counterup/counterup.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/owl.carousel/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/aos/aos.js"></script>

<!-- Main JS Files -->
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/registration.js"></script>

</body>

</html>
