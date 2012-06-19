<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
</head>

<body>
    <table>
        <tr>
            <td align="left">
                <table>
                    <tr>
                        <td>
                            <img src="image/photoimage.html?photoId=${photo.photoId}" alt="photo" border="0"/>
                        </td>
                    </tr>
                    <td>
                            ${photo.caption}
                    </td>
                </table>
            </td>
            <td width="100%">
            </td>
            <td>
                <table bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
                    <tr>
                        <td width="70" height="70">
                            <img src="image/userimage.html?userId=${photo.user.userId}" alt="Header image" width="60" height="60"
                                 border="0"/>
                        </td>
                        <td>
                            <b><big>Uploaded by ${photo.user.loginName} </big></b>
                        </td>
                    </tr>
                    <br>
                    <br>
                    <tr>
                        <c:if test="${not empty commentList}">
                            <fieldset>
                                <legend>Photo Comments</legend>
                                <c:forEach var="comment" items="${commentList}">
                                    <tr>
                                        <td>${comment.commentedBy.loginName}</td>
                                        <td>${comment.photoComment}</td>
                                    </tr>
                                </c:forEach>
                            </fieldset>
                        </c:if>
                    </tr>
                </table>
                <br>
                <table>
                        <td>rating:</td>
                        <td>${rating}</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>

</html>