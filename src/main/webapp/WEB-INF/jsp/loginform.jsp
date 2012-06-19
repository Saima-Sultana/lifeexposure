<%--
  Created by IntelliJ IDEA.
  User: saima
  Date: 6/7/12
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
</head>

<body>
    <form:form method="POST" commandName="loginForm">
        <br>
        <br>
        <fieldset>
            <legend>LogIn</legend>
            <table width="100%" align="right">
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="userName"/></td>
                    <td><form:errors path="userName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password"/></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
            </table>
        </fieldset>
        <br>
        <input type="submit" align="right" value="Submit">
    </form:form>

    <table>
        <tr>
            <td><a href="newuser.html">Sign Up</a></td>
        </tr>
    </table>
</body>

</html>