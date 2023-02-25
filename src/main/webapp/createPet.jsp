<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h3>New pet</h3>
<form method="post">
<%--    <label>Id</label><br>--%>
<%--    <input name="id"/><br><br>--%>
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
</body>
</html>


