
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Hello World - Input Form</title>
        <script src="${pageContext.request.contextPath}/resources/js/test.js"></script>
    </head>
    <body>
        <form:form action="processForm" modelAttribute="user">

            First name: <form:input path="firstName" />

            <br><br>

            Last name: <form:input path="lastName" />

            <br><br>

            <input type="submit" value="Submit" onclick="log('test')"/>
        </form:form>
    </body>
</html>