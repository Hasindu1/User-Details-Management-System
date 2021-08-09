<%--
  Created by IntelliJ IDEA.
  User: Hasindu Dahanayake
  Date: 1/1/2021
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>USERO Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/icons/favicon.ico"/>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/vendor/css-hamburgers/hamburgers.min.css">


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signup.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">

</head>
<body>

<div class="limiter">
    <div class="container-login100 ">
        <div class="wrap-login100 login-container">
            <div class="login100-pic js-tilt " data-tilt>
                <img src="${pageContext.request.contextPath}/images/img-01.png" alt="IMG">
            </div>

            <form:form action="" class="login100-form validate-form" modelAttribute="user">


                <input type="hidden" id="signUpResponse" name="=SignUpResponse" value="${message}">


                <span class="login100-form-title">
						Member Login

					</span>

                <c:if test="${param.error.length() == 0}">
                    <div class="alert alert-danger text-center">
                        Invalid username and password.
                    </div>
                </c:if>
                <c:if test="${param.logout.length() == 0}">
                    <div class="alert alert-success text-center">
                        You have successfully logged out.
                    </div>
                </c:if>

                <div class="wrap-input100 validate-input" data-validate="company code is required">
                    <form:input class="input100" type="text" name="companyCode" placeholder="company code"
                                path="companyCode"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-building" aria-hidden="true"></i>
						</span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="user name is required">
                    <form:input class="input100" type="text" name="email" placeholder="username" path="userName"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-user-circle" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <form:input class="input100" type="password" name="pass" placeholder="Password" path="password"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>


                <div class="container-login100-form-btn">
                    <input type="submit" class="login100-form-btn" value="Login"/>


                </div>


                <div class="text-center pb-5">
                    <a class="txt2" href="/user/signup">
                        New member ? Signup
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form:form>
        </div>
    </div>
</div>


<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/tilt/tilt.jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>

<script src="${pageContext.request.contextPath}/js/registration.js"></script>

<script type="text/javascript">
    /*
     *Handling the sign up response messages
     */
    let uploadStatus = document.getElementById("signUpResponse").value;
    if (uploadStatus === "error") {

        swal("Error", "Something went wrong!", "error");

    } else if (uploadStatus === "userNameDuplication") {
        swal("User Name Exists!", "Please try a different username", "error");
    } else if (uploadStatus == "success") {
        swal("success", "You have successfully registered!", "success");
    }
</script>

</body>
</html>
