<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-default navbar-fixed-top" roles="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <sec:authorize access="isAnonymous()">
                <a class="navbar-brand" href="/">Test Site</a>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <a href="/main" class="navbar-brand">Main page</a>
            </sec:authorize>


        </div>


        <sec:authorize access="isAnonymous()">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">

                </ul>
            </div>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout"> Logout </a></li>
                </ul>
            </div>
        </sec:authorize>


    </div>
</div>