<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h3>New pet</h3>
<form method="post">
    <label>Id</label><br>
    <input name="id"/><br><br>
    <label>Animal</label><br>
    <input name="animal"/><br><br>
    <label>Name</label><br>
    <input name="name"/><br><br>
    <label>Age</label><br>
    <input name="age" type="number"/><br><br>
    <label>Color</label><br>
    <input name="color"/><br><br>
    <label>Owner_id</label><br>
    <input name="owner_id"/><br><br>
    <input type="submit" value="Save"/>
</form>
<h2>Pets List</h2>
<p><a href='<c:url value="/createPet" />'>Create new</a></p>
<table>
    <tr>
        <th>Id</th>
        <th>Animal</th>
        <th>Name</th>
        <th>Age</th>
        <th>Color</th>
        <th>Owner_id</th>
        <th></th>
    </tr>
    <c:forEach var="pet" items="${pets}">
        <tr>
            <td>${pet.id}</td>
            <td>${pet.animal}</td>
            <td>${pet.name}</td>
            <td>${pet.age}</td>
            <td>${pet.color}</td>
            <td>${pet.owner_id}</td>
            <td>
                <a href='<c:url value="/edit?id=${pet.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${pet.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
