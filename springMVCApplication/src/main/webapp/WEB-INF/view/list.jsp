<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
</head>
<body>
<h2>TO-DO LIST</h2>
<hr>
<ul>
    <c:forEach var="item" items="${list}">
        <li>
            <div class="todo-item">
                <span>${item.description}</span>
                <span>${item.deadline}</span>
                <a href="/to-do/remove/${item.id}">remove</a>
            </div>
        </li>
    </c:forEach>
</ul>
<a href="/to-do/form">Add</a>
</body>
</html>
