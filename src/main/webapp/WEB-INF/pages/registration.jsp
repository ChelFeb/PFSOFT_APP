<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    #content {
        margin-top: 4%;
    }
</style>

<div id="content">

    <div class="starter-template">
        <p class="text-center bg-danger">${errorMessage}</p>
    </div>

    <div class="container">
        <div>
            <form:form method="POST" action="registration" modelAttribute="userInfo" name="userInfo" cssClass="form-signin">
                <legend class="text-info">New user</legend>

                <div>
                    <label for="login" class="col-sm-2 control-label">Login:</label>

                    <div>
                        <form:input path="login" cssClass="form-control" id="login" type="text"/>
                        <form:errors path="login" cssClass="errorMessage"/>
                    </div>

                    <label for="password" class="col-sm-2 control-label">Password:</label>

                    <div>
                        <form:input path="password" cssClass="form-control" id="password" type="password"/>
                        <form:errors path="password" cssClass="errorMessage"/>
                    </div>

                    <label class="col-sm-2 control-label">Repeat password:</label>

                    <div>
                        <form:input path="confirmPassword" cssClass="form-control" type="password" id="confirmPassword"/>
                        <form:errors path="confirmPassword" cssClass="errorMessage"/>
                    </div>

                    <label class="col-sm-2 control-label">Email</label>

                    <div>
                        <form:input path="email" cssClass="form-control" type="text" />
                        <form:errors path="email" cssClass="errorMessage"/>
                    </div>

                    <label class="col-sm-2 control-label">Name</label>

                    <div>
                        <form:input path="name" cssClass="form-control" type="text" />
                        <form:errors path="name" cssClass="errorMessage"/>
                    </div>

                    <label class="col-sm-2 control-label">Surname</label>

                    <div>
                        <form:input path="surname" cssClass="form-control" type="text" />
                        <form:errors path="surname" cssClass="errorMessage"/>
                    </div>

                    <label class="col-sm-2 control-label">Address</label>

                    <div>
                        <form:input path="address" cssClass="form-control" type="text" />
                        <form:errors path="address" cssClass="errorMessage"/>
                    </div>

                    <label class="col-sm-2 control-label">Phone</label>

                    <div>
                        <form:input path="phone" cssClass="form-control" type="text" />
                        <form:errors path="phone" cssClass="errorMessage"/>
                    </div>

                    <label class="col-sm-2 control-label">Sex</label>

                    <div>
                        <form:select class="form-control" path="sex">
                            <form:option cssClass="form-control" type="text" value="MALE"/>
                            <form:option cssClass="form-control" type="text" value="FEMALE"/>
                        </form:select>
                    </div>

                    <label class="col-sm-2 control-label">Type of user</label>

                    <div>
                        <form:select class="form-control" path="roles">
                            <form:option cssClass="form-control" type="text" value="Role user"/>
                            <form:option cssClass="form-control" type="text" value="Role administrator"/>
                        </form:select>
                    </div>
                </div>

                <br/>
                <div>
                    <input type="submit" class="btn-sm btn-primary btn-block" value="Cоздать пользователя"/>
                </div>
            </form:form>

        </div>
    </div>
</div>

