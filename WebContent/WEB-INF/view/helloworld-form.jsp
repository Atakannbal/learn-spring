
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Hello World - Input Form</title>
        <script src="${pageContext.request.contextPath}/resources/js/test.js"></script>

        <style>
            .error {color: red}
        </style>
    </head>
    <body>
        
        <i>Fill out the form. Asterisk (*) means required.</i>

        <br><br>
        <form:form action="processForm" modelAttribute="user">

            First name: <form:input path="firstName" />
            <br><br>

            Last name (*): <form:input path="lastName" />
            <form:errors path="lastName" cssClass="error" />

            <br><br>

            Years of experience (*): <form:input path="yearsOfExperience" />
            <form:errors path="yearsOfExperience" cssClass="error" />

            <br><br>

            Postal Code: <form:input path="postalCode" />
            <form:errors path="postalCode" cssClass="error" />

            <br><br>

            <form:select path="country">
                    <form:options items="${theCountryOptions}" />
            </form:select>

            <br><br>

            Favorite Language:

            <form:checkboxes path="languages" items="${theLanguageOptions}" />

            <input type="submit" value="Submit" onclick="log('test')"/>
        </form:form>
    </body>
</html>