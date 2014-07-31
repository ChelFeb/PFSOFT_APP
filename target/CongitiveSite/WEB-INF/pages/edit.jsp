<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    #content {
        margin-top: 4%;
    }
</style>

<div id="content" class="container">

    <form:form method="POST" action="/updateUser/${userId}" modelAttribute="userInfo" name="userInfo"
               cssClass="form-signin">
        <legend class="text-info">Update user parameters</legend>

        <div>
            <label for="login" class="col-sm-2 control-label">Имя пользователя:</label>

            <div>
                <h4 id="login">
                        ${userInfo.login}
                </h4>
            </div>


            <label class="col-sm-2 control-label">Email</label>

            <div>
                <form:input path="email" cssClass="form-control" type="text"/>
            </div>

            <label class="col-sm-2 control-label">Name</label>

            <div>
                <form:input path="name" cssClass="form-control" type="text"/>
            </div>

            <label class="col-sm-2 control-label">Surname</label>

            <div>
                <form:input path="surname" cssClass="form-control" type="text"/>
            </div>

            <label class="col-sm-2 control-label">Address</label>

            <div>
                <form:input path="address" cssClass="form-control" type="text"/>
            </div>

            <label class="col-sm-2 control-label">Phone</label>

            <div>
                <form:input path="phone" cssClass="form-control" type="text"/>
            </div>

            <label class="col-sm-2 control-label">Sex</label>

            <div>
                <form:select class="form-control" path="sex">
                    <form:option cssClass="form-control" type="text" value="MALE"/>
                    <form:option cssClass="form-control" type="text" value="FEMALE"/>
                </form:select>
            </div>

            <label class="col-sm-2 control-label">Role</label>

            <div>
                <form:select class="form-control" path="roles">
                    <form:option cssClass="form-control" type="text" value="Role user"/>
                    <form:option cssClass="form-control" type="text" value="Role administrator"/>
                </form:select>
            </div>
        </div>

        <br/>
        <div>
            <input type="submit" class="btn-sm btn-primary btn-block" value="Update user"/>
        </div>
    </form:form>

</div>
