<%--
  Created by IntelliJ IDEA.
  User: Hasindu
  Date: 1/2/2021
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

</head>

<body>

<!-- ======= Top Bar ======= -->

<jsp:include page="topbar.jsp"></jsp:include>

<!-- ======= End Top Bar ======= -->
<!-- ======= Header ======= -->
<jsp:include page="header.jsp"></jsp:include>

<!-- End Header -->


<!-- ======= Hero Section ======= -->
<section id="hero">
    <div class="hero-container">
        <div id="heroCarousel" class="carousel slide carousel-fade" data-ride="carousel">


            <div class="carousel-inner" role="listbox">

                <!-- Slide 1 -->
                <div class="carousel-item active"
                     style="background-image: url('${pageContext.request.contextPath}/images/slide/slide-1.jpg');">
                    <div class="carousel-container">
                        <div class="carousel-content container">
                            <h2 class="animate__animated animate__fadeInDown">Welcome to <span>USERO</span></h2>
                            <p class="animate__animated animate__fadeInUp">
                                This solution allows you to manage
                                users, groups, and roles defined in the default security realm. You must be logged in as
                                a member to add, delete, or modify a user or role.You can also view the login history of
                                users in a detailed manner including the information such as ip
                                address,browser,date,time,device type.</p>
                            <a href="#about" class="btn-get-started animate__animated animate__fadeInUp scrollto">Read
                                More</a>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</section><!-- End Hero -->

<main id="main">

    <!-- ======= Services Section ======= -->
    <section id="about" class="about">
        <div class="container">

            <div class="row no-gutters">
                <div class="col-lg-6 video-box">
                    <img src="${pageContext.request.contextPath}/images/about.jpg" class="img-fluid" alt="">
                    <a href="https://www.youtube.com/watch?v=jDDaplaOz7Q" class="venobox play-btn mb-4"
                       data-vbtype="video" data-autoplay="true"></a>
                </div>

                <div class="col-lg-6 d-flex flex-column justify-content-center about-content">

                    <div class="section-title">
                        <h2>Services</h2>
                        <p>Manage your company user details instantly with us.</p>
                    </div>

                    <div class="icon-box" data-aos="fade-up" data-aos-delay="100">
                        <div class="icon"><i class="bx bx-history"></i></div>
                        <h4 class="title"><a href="">View Login History</a></h4>
                        <p class="description">View login history of users in a detailed manner including ip
                            address,browser,date,time,device type</p>
                    </div>

                    <div class="icon-box" data-aos="fade-up" data-aos-delay="100">
                        <div class="icon"><i class="bx bx-user-circle"></i></div>
                        <h4 class="title"><a href="">Organize User Details</a></h4>
                        <p class="description">This solution allows you to manage users, groups, and roles
                            defined in the default security realm. You must be logged in as a member to add, delete, or
                            modify a user or role</p>
                    </div>

                </div>
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

<!-- Main JS File -->
<script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</html>
