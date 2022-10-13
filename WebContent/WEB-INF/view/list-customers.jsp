<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.springdemo.mvc.SortUtils" %>





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

            <c:url var="sortLinkFirstName" value="/customer/list">
                <c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
            </c:url>

            <c:url var="sortLinkLastName" value="/customer/list">
                <c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
            </c:url>

            <c:url var="sortLinkEmail" value="/customer/list">
                <c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
            </c:url>

            <!-- add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                <input type="submit" value="Submit" class="add-button"/>
            </form:form>

            <!-- add out html table here -->
            <table>
                <tr>
                    <th><a href="${sortLinkFirstName}">First Name</a></th>
                    <th><a href="${sortLinkLastName}">Last Name</a></th>
                    <th><a href="${sortLinkEmail}">Email</a></th>
                    <th>Action</th>
                </tr>

                <!-- loop over and print customers-->
                <c:forEach var="tempCustomer" items="${customers}">

                    <!-- construct an "update" link with customer id -->
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>

                    <!-- construct an "delete" link with customer id -->
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>
                    
                    
                    <tr>
                        <td> ${tempCustomer.firstName} </td>
                        <td> ${tempCustomer.lastName} </td>
                        <td> ${tempCustomer.email} </td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a>
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
