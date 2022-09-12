<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <body>
        <p> Welcome, ${user.firstName} ${user.lastName} </p>
        <p> Your country is ${user.country} </p>
        <br><br>
        Favorite Languages:
        <ul>
            <c:forEach var="language" items="${user.languages}">
                <li>${language}</li>
            </c:forEach>
        </ul>

        <br><br>
        Years of experience: ${user.yearsOfExperience} yrs.
        <br><br>
        Postal Code: ${user.postalCode}
    </body>
</html>
