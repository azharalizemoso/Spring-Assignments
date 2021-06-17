<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
    <h2>Spring MVC and Hibernate</h2>

        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Profession</th>
            </tr>
            <c:forEach var="listValue" items="${lists}">
                <tr>
                    <td><c:out value="${listValue.id}" /></td>
                    <td><c:out value="${listValue.firstName}" /></td>
                    <td><c:out value="${listValue.lastName}" /></td>
                    <td><c:out value="${listValue.email}" /></td>
                </tr>
            </c:forEach>
        </table>

<h2>Add New Entry</h2>
<button><a href="newEntry">Add</a></button>

<h2>Delete An Entry</h2>
<button><a href="deleteEntry">Add</a></button>

</body>
</html>