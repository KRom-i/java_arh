<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>TODO FORM</h2>
<hr>
<form:form action="process-form" modelAttribute="todo">
    <div>
        <label>Description:</label>
        <div>
            <form:input path="description" />
        </div>
    </div>
    <div>
        <label>Deadline:</label>
        <div>
            <form:input path="deadline" type="date"/>
        </div>
    </div>
    <div>
        <input type="submit" value="Submit" />
    </div>
</form:form>
</body>
</html>