<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer Manager</title>
</head>
<body>
<div align="center">
    <h2>Customer Manager</h2>
    <form action="searchCustomer">
        <input type="text" name="keyword" placeholder="Name"/>
        <input type="submit" value="Search" />
    </form>
    <br>
    <input type="button" value="Add"
           onclick="window.location.href='addNewCustomer'"/>
    <br>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>E-mail</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${allEmps}" var="customer">
            <c:url var="updateButton" value="/updateInfo">
                <c:param name="empId" value="${customer.id}"/>

            </c:url>
            <c:url var="deleteButton" value="/deleteCustomer">
                <c:param name="empId" value="${customer.id}"/>
            </c:url>
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.adress}</td>
                <td>
                    <input type="button" value="Update"
                           onclick="window.location.href = '${updateButton}'"/>

                    <input type="button" value="Delete"
                           onclick="window.location.href = '${deleteButton}'"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>