<%--
  Created by IntelliJ IDEA.
  User: Hasindu Dahanayake
  Date: 1/1/2021
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>USERO SignUp</title>
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
    <link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/"vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signup.css">

</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div id="sign-up-logo" class="login100-pic js-tilt " data-tilt>
                <img src="${pageContext.request.contextPath}/images/img-01.png" alt="IMG">
            </div>

            <form:form action="add-user" class="login100-form validate-form" modelAttribute="user" method="post">
            <span class="login100-form-title">
						Member Registration
					</span>
                <div class="wrap-input100 validate-input" data-validate="company code is required">
                    <form:input class="input100" type="text" name="companyCode" placeholder="company code" path="companyCode"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-building" aria-hidden="true"></i>
						</span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="first name is required">
                    <form:input class="input100" type="text" name="firstName" placeholder="firstname" path="firstName"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-pencil" aria-hidden="true"></i>
						</span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="last name is required">
                    <form:input class="input100" type="text" name="lastName" placeholder="lastname" path="lastName"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-pencil" aria-hidden="true"></i>
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
                <div class="wrap-input100 validate-input" data-validate="Contact number is required">
                    <form:input class="input100" type="number" name="contactNumber" placeholder="ContactNumber"
                                path="contactNumber"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-phone" aria-hidden="true"></i>
						</span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Address is required">
                    <form:input class="input100" type="text" name="address" placeholder="address" path="address"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>
                <div id="gender-container" class="container pt-4">
                    <div class="row justify-content-center">
                        <div class="col-sm-11">

                            <i class="fa fa-user pl-2 pr-2" aria-hidden="true"></i>
                            <div class="col-form-label  pt-0  d-inline-block"> Gender</div>
                        </div>
                        <div class="col-sm-11">
                            <div class="form-check pl-4 ">
                                <form:radiobutton class="form-check-input "  name="gridRadios" id="gridRadios1"
                                                  path="gender" value="Male" checked="checked"
                                />


                                <label class="form-check-label pl-0" for="gridRadios1">
                                    Male
                                </label>
                            </div>
                            <div class="form-check pl-4 ">
                                <form:radiobutton class="form-check-input"  name="gridRadios" id="gridRadios2"
                                                  path="gender" value="female"/>

                                <label class="form-check-label pl-0" for="gridRadios2">
                                    Female
                                </label>
                            </div>
                        </div>

                    </div>


                </div>
                <div id="user-role-container" class="container pt-4 mt-3">
                    <div class="form-group row justify-content-center">
                        <div class="col-sm-11">
                            <i class="fa fa-user pl-2" aria-hidden="true"></i>
                            <label for="inputState">User Role</label>
                            <form:select id="inputState" class="form-control" path="userRoleType" >
                                <form:option value="Standard" label="Standard"/>
                            </form:select>

                        </div>
                    </div>
                </div>
                <div class="container-login100-form-btn">
                    <input type="submit" class="login100-form-btn" value="Register"/>


                </div>

                <div class="text-center pb-5">
                    <a class="txt2" href="/user/login">
                        Already have an account ? Login
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
<script>
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>
<script src="${pageContext.request.contextPath}/js/registration.js"></script>

</body>
</html>