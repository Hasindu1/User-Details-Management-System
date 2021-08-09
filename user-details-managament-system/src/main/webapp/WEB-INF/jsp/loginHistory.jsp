<%--
  Created by IntelliJ IDEA.
  User: Hasindu
  Date: 1/2/2021
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i,900"
          rel="stylesheet">

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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginHistory.css">

</head>

<body>

<!-- ======= Top Bar ======= -->

<jsp:include page="topbar.jsp"></jsp:include>

<!-- ======= End Top Bar ======= -->
<!-- ======= Header ======= -->
<jsp:include page="header.jsp"></jsp:include>

<!-- End Header -->

<!-- ======= Breadcrumbs Section ======= -->
<section class="breadcrumbs">
    <div class="container">

        <div class="d-flex justify-content-between align-items-center">
            <h2>Login History</h2>
            <ol>
                <li><a href="/">Home</a></li>
                <li><a href="/login-history/all">Login History</a></li>

            </ol>
        </div>

    </div>
</section><!-- Breadcrumbs Section -->


<main id="main">

    <!-- ======= User Details Management Section ======= -->

    <section id="about" class="about">

        <div class="container">

            <table class="table">
                <thead>
                <tr>
                    <th id="col-record-id" scope="col">Record Id</th>
                    <th scope="col">User Name</th>
                    <th scope="col">Date</th>
                    <th scope="col">Time</th>
                    <th id="col-device-type" scope="col">Device Type</th>
                    <th id="col-browser-name" scope="col">Browser Name</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach var="currentHistory" items="${loginHistories}">


                    <tr>
                        <td class="td-record-id">${currentHistory.recordId}</td>
                        <td>${currentHistory.user.userName}</td>
                        <td>${currentHistory.loggedInDate}</td>
                        <td>${currentHistory.loggedInTime}</td>
                        <td class="td-device-type">${currentHistory.deviceType}</td>
                        <td class="td-browser-name">${currentHistory.browserName}</td>

                    </tr>

                </c:forEach>
                </tbody>
            </table>


        </div>
        <div class="row justify-content-end">
            <div class="col-3 pl-0">
                <input type=button" value="Generate Report"
                       onclick="window.location.href='generate-report';return false;"
                       class="btn btn-primary btn-sm"
                />
            </div>
        </div>
    </section><!-- End About Us Section -->


</main><!-- End #main -->

<!-- ======= Footer ======= -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->


<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery-sticky/jquery.sticky.js"></script>
<script src="${pageContext.request.contextPath}/vendor/venobox/venobox.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/waypoints/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/counterup/counterup.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/owl.carousel/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/aos/aos.js"></script>

<!-- Main JS File -->
<script src="${pageContext.request.contextPath}/js/main.js"></script>


</body>

</html>

