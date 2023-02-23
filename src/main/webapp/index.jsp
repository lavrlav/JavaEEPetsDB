<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Pets</title>
</head>
<body>
<h2>Pets List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
  <tr><th>Id</th><th>Animal</th><th>Name</th><th>Age</th><th>Color</th><th>Owner_id</th><th></th></tr>
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
      </td></tr>
  </c:forEach>
</table>
<h2>Owners List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
  <tr><th>Id</th>><th>Name</th></tr>
  <c:forEach var="owner" items="${owners}">
    <tr>
      <td>${owner.id}</td>
      <td>${owner.name}</td>
      <td>
        <a href='<c:url value="/edit?id=${owner.id}" />'>Edit</a>
        <form method="post" action='<c:url value="/delete" />' style="display:inline;">
          <input type="hidden" name="id" value="${owner.id}">
          <input type="submit" value="Delete">
        </form>
      </td></tr>
  </c:forEach>
</table>
</body>
</html>
