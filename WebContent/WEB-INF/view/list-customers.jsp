<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
  <head>
    <title>List Customers</title>
  </head>

  <body>
    <div id="wrapper">
        <div id="header">
            <h2> CRM - Customer Relationship Manager </h2>
        </div>
    </div>

    <div id="container">
        <div id="content">


            <!-- add out html table here -->

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <!-- loop over and print customers-->
                <c:forEach var="tempCustomer" items="${customers}">

                    <!-- construct an "update" link with customer id -->
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>
                    
                    <tr>
                        <td> ${tempCustomer.firstName} </td>
                        <td> ${tempCustomer.lastName} </td>
                        <td> ${tempCustomer.email} </td>
                        <td>
                            <a href="${updateLink}">Update</a>
                        </td>
                    </tr>
                    
                </c:forEach>

            </table>

            <!-- put new button: Add customer -->
            <input type="button" value="Add Customer"
                onclick="window.location.href='showFormForAdd'; return false;"
                class="add-button"
            />
    
        </div>
    </div>

  </body>
</html>
