<!DOCTYPE html>
<html>
    <head>
        <title>Hello World - Input Form</title>
        <script src="${pageContext.request.contextPath}/resources/js/test.js"></script>
    </head>
    <body>
        <form action="processForm" method="GET">
            <input type="text" name="userName" placeholder="What's your name?" />
            <input type="submit" onclick="log('test')"/>
        </form>
    </body>
</html>