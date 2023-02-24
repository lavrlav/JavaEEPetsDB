<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            border-collapse: collapse
        }

        table, tr, td, th {
            border: 1px solid black;
        }
    </style>
    <title>tables</title>
</head>
<body>
<h2>Owners table</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    <c:forEach items="${owners}" var="owner">
        <tr>
            <td>${owner.id}</td>
            <td>${owner.name}</td>
        </tr>
    </c:forEach>
</table>
<h2>Pets table</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Animal</th>
        <th>Name</th>
        <th>Age</th>
        <th>Color</th>
        <th>Owner_id</th>
    </tr>
    <c:forEach items="${pets}" var="pet">
        <tr>
            <td>${pet.id}</td>
            <td>${pet.animal}</td>
            <td>${pet.name}</td>
            <td>${pet.age}</td>
            <td>${pet.color}</td>
            <td>${pet.ownerId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
