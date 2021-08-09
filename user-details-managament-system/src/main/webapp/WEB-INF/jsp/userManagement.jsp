<%--
  Created by IntelliJ IDEA.
  User: Hasindu Dahanayake
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
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <!-- Template Main CSS File -->

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userManagement.css">
    <!-- =======================================================
    * Template Name: Mamba - v2.5.0
    * Template URL: https://bootstrapmade.com/mamba-one-page-bootstrap-template-free/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
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
            <h2>User Details Management</h2>
            <ol>
                <li><a href="/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/user/user-management">User Details Management</a></li>

            </ol>
        </div>

    </div>
</section><!-- Breadcrumbs Section -->


<main id="main">

    <!-- ======= User Details Management Section ======= -->

    <section id="about" class="about">

        <div class="container">
            <div class="container py-3">
                <div class="row ">
                    <div class="col-12">
                        <div class="row">
                            <form class="form-inline my-2 my-lg-0">
                                <div class="col-8">

                                    <input class="form-control mr-sm-2 input-user-name" type="search"
                                           placeholder="Search by username"
                                           aria-label="Search">
                                </div>
                                <div class="col-2">
                                    <input type="hidden" id="search-response" name="=search-response"
                                           value="${message}">

                                    <form:form action="user-management" method="get">

                                        <button id="btn-user-name" name="userName"
                                                class="btn btn-outline-primary my-2 my-sm-0" value="empty"
                                                type="submit">Search
                                        </button>
                                    </form:form>

                                </div>
                                <div class="col-12 col-md-2 mt-1">
                                    <input type=button" value="Add User"
                                           onclick="window.location.href='modify-user';return false;"
                                           class="btn btn-primary btn-sm"
                                    />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th id="col-user-id" scope="col">User Id</th>
                    <th scope="col">User Name</th>
                    <th scope="col">First Name</th>
                    <th id="last-name" scope="col">Last Name</th>
                    <th id="col-gender" scope="col">Gender</th>
                    <th id="col-contact-number" scope="col">Contact Number</th>
                    <th id="col-address" scope="col">Address</th>
                    <th id="col-user-type" scope="col">User Type</th>
                    <th id="col-company-code" scope="col">Company Code</th>
                    <th scope="col">Modify User</th>
                    <th scope="col">Remove User</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach var="currentUser" items="${users}">
                    <c:url var="updatedurl" value="/user/modify-user">
                        <c:param name="id" value="${currentUser.userId}"/>
                    </c:url>

                    <c:url var="deleteurl" value="/user/delete-user">
                        <c:param name="id" value="${currentUser.userId}"></c:param>
                    </c:url>

                    <tr>
                        <td class="td-user-id">${currentUser.userId}</td>
                        <td>${currentUser.userName}</td>
                        <td>${currentUser.firstName}</td>
                        <td class="td-last-name">${currentUser.lastName}</td>
                        <td class="td-gender">${currentUser.gender}</td>
                        <td class="td-contact-number">${currentUser.contactNumber}</td>
                        <td class="td-address">${currentUser.address}</td>
                        <td class="td-user-role">${currentUser.userRoleType}</td>
                        <td class="td-company-code">${currentUser.companyCode}</td>
                        <td><a class="btn btn-primary" href="${updatedurl}">Update</a></td>
                        <td><a class="btn btn-primary" href="${deleteurl}">Delete</a>
                    </tr>

                </c:forEach>
                </tbody>
            </table>


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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!--Main JS File -->
<script src="${pageContext.request.contextPath}/js/main.js"></script>

<script type="text/javascript">
    /*
     *Getting the request params
     */
    let get = (name) => {
        if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(location.search))
            return decodeURIComponent(name[1]);
    }
    let loginResponse = get('response');
    /*
     *Changing the search button value to search field value
     */
    document.querySelector('.input-user-name').addEventListener('change', () => {
        document.getElementById("btn-user-name").value = document.querySelector('.input-user-name').value;

    });
    /*
     *Handling the invalid search response messages
     */
    let searchResponse = document.getElementById("search-response").value;
    console.log("Search", searchResponse);
    if (searchResponse === "UserNameNotExists") {

        swal("Error", "User name not exists!", "error");

    }
    /*
     *Adding the logged in user's history through an ajax request
     */
    let addUserHistory = () => {
        $.ajax({
            type: "GET",
            url: "/login-history/add",
            success: (result) => {
                if (result.message == "Success") {

                    console.log("Success: ", result);
                    window.location.replace("http://localhost:8093/user/user-management");//Preventing resubmissions of login data in a page reload
                } else {

                    console.log("Fail: ", result);
                }
            }
        })
    }
    if (loginResponse === "success") {
        addUserHistory();
    }


</script>

</body>

</html>
