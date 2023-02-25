<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
<h3>Edit Owner</h3>
<form method="post">
  <input type="hidden" value="${owner.id}" name="id"/>
  <label>Name</label><br>
  <input name="name" value="${owner.name}"/><br><br>
  <input type="submit" value="Send"/>
</form>
</body>
</html>
