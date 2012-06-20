<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
</head>

<body>
    <form:form method="POST" commandName="photoCmd" enctype="multipart/form-data" onsubmit="return Validate();">
        <table>
            <tr>
                <td width="70" height="70">
                    <img src="image/userimage.html?userId=${userId}" alt="Header image" width="60" height="60" border="0"/>
                </td>
                <td>
                    <b><big>Hi! ${loginName}</big></b>
                </td>
            </tr>
        </table>
        <fieldset>
            <legend>Photo Details</legend>
            <table bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
                <tr>
                    <td>Add a caption:</td>
                    <td><form:input path="caption"/></td>
                    <td><form:errors path="caption" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Location: (optional)</td>
                    <td><form:input path="location"/></td>
                </tr>
                <tr>
                    <td>Description: (optional)</td>
                    <td><form:input path="description"/></td>
                </tr>
            </table>
        </fieldset>
        <br>
        <input type="submit" align="right" value="Ok">
        <input type="button" align="right" value="Cancel" onClick="returnHome()">
    </form:form>
</body>

</html>