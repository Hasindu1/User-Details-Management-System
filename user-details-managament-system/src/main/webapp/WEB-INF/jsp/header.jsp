<%--
  Created by IntelliJ IDEA.
  User: Hasindu
  Date: 1/2/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<header id="header">
    <div class="container">

        <div class="logo float-left">
            <h1 class="text-light"><a href="/"><span>USERO</span></a></h1>
        </div>

        <nav class="nav-menu float-right d-none d-lg-block">
            <ul>
                <li class="active"><a href="/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/user/user-management">User Management</a></li>
                <li><a href="${pageContext.request.contextPath}/login-history/all">Login History</a></li>

                <li class="drop-down"><a href="">Account</a>
                    <ul>
                        <li><a href="/user/login"><i class="icofont-sign-in pr-3"></i></i>Sign In</a></li>
                        <li class=" pl-4 pl-md-0 pl-lg-3" >
                            <form:form action="${pageContext.request.contextPath}/logout" method="post">
                                <i class="icofont-sign-out ml-3 ml-sm-0 text-sm-light" style="padding-left: 0.3rem;"></i><input type="submit"
                                                                                                      class="btn btn-link text-sm-light text-md-dark"
                                                                                                      style="padding-left: 0.8rem; text-decoration: none;font-size: 0.95rem"
                                                                                                      value="Log out"/>
                            </form:form>
                        </li>

                        <li><a href="/user/signup"><i class="icofont-user pr-3"></i></i>Sign Up</a></li>

                    </ul>
                </li>

            </ul>
        </nav><!-- .nav-menu -->

    </div>
</header>
<!-- End Header -->


