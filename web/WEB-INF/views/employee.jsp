<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee Registration</title>
</head>
<body>
    <h2>Insert employee all information to proceed.</h2>
    <form:form method="POST" action="/employee.do" commandName="employee">
        <table border="1">
            <tr>
                <td>Employee ID</td>
                <td><form:input path="empID" /></td>
            </tr>
            <tr>
                <td>Employee Name</td>
                <td><form:input path="empName"/></td>
            </tr>
            <tr>
                <td>MobileNo</td>
                <td><form:input path="mobileNo"/></td>
            </tr>
            <tr>
                <td>HomeNo</td>
                <td><form:input path="homeNo"/></td>
            </tr>
            <tr>
                <td>OfficeNo</td>
                <td><form:input path="officeNo"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td>FaxNo</td>
                <td><form:input path="faxNo"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="ADD"/>
                    <input type="submit" value="EDIT">
                    <input type="submit" value="DELETE">
                    <input type="submit" value="Search">
                </td>
            </tr>
        </table>
    </form:form>
    <br>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>MobileNo</th>
            <th>HomeNo</th>
            <th>OfficeNo</th>
            <th>email</th>
            <th>FaxNo</th>
        </tr>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>${employee.empID}</td>
                <td>${employee.empName}</td>
                <td>${employee.mobileNo}</td>
                <td>${employee.homeNo}</td>
                <td>${employee.officeNo}</td>
                <td>${employee.email}</td>
                <td>${employee.faxNo}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>