<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h3>Edit Pet</h3>
<form method="post">
    <input type="hidden" value="${pet.id}" name="id"/>
    <label>Animal</label><br>
    <input name="animal" value="${pet.animal}"/><br><br>
    <label>Name</label><br>
    <input name="name" value="${pet.name}"/><br><br>
    <label>Age</label><br>
    <input name="age" value="${pet.age}"/><br><br>
    <label>Color</label><br>
    <input name="color" value="${pet.color}"/><br><br>
    <label>Owner_id</label><br>
    <input name="ownerId" value="${pet.ownerId}"/><br><br>
    <input type="submit" value="Send"/>
</form>
</body>
</html>
