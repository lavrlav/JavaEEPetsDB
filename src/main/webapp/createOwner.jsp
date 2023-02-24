<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h3>New owner</h3>
<form method="post">
  <label>Id</label><br>
  <input name="id"/><br><br>
  <label>Name</label><br>
  <input name="name"/><br><br>
  <input type="submit" value="Save"/>
</form>
<h2>Owners List</h2>
<p><a href='<c:url value="/createOwner" />'>Create new</a></p>
<table>
  <tr><th>Id</th><th>Name</th></tr>
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
