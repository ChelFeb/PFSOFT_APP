<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .container {
        margin-top: 4%;
    }
</style>
<div class="container">


    <table class="table">
        <thead>
            <tr>
                <th>
                    <label for="searchInput">Search users by login or phone</label>
                    <form action="searchUsers">
                        <input id="searchInput" name="searchInput" placeholder="type login or phone"/>
                    </form>
                </th>
                <th>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <form action="/admin">
                            <button class="btn btn-info" type="submit">
                                Add user
                            </button>
                        </form>
                    </sec:authorize>
                </th>
            </tr>
        </thead>
    </table>



    <table class="table">
        <thead>
        <tr>
            <th>
                Login
            </th>
            <th>
                Name
            </th>
            <th>
                Phone
            </th>
            <th>
                Email
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${searchingResult}" var="user">
            <tr>
                <td>
                        ${user.login}
                </td>
                <td>
                        ${user.name}
                </td>
                <td>
                        ${user.phone}
                </td>
                <td>
                        ${user.email}
                </td>
                <td>
                    <form action="/editUser/${user.id}">
                        <button type="submit" class="btn">edit</button>
                    </form>
                </td>
                <td>
                    <form method="POST" action="/deleteUser/${user.id}">
                        <button type="submit" class="btn btn-danger">delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>