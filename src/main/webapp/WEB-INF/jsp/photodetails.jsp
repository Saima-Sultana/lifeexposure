<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <link href='<c:url value="/rating/rating_simple.css"/>' rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src='<c:url value="/rating/jquery.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/rating/rating_simple.js"/>'></script>
    <script language="javascript" type="text/javascript">
        function test(value) {
            alert("This rating's value is " + value);
        }
        $(function () {
            $("#rating").webwidget_rating_simple({
                rating_star_length:'5',
                rating_initial_value:'0',
                rating_function_name:'', //this is function name for click
                directory:'rating/'
            });
        });
    </script>
</head>

<body>
<form:form method="POST" commandName="photoReview">
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
                            <img src="image/userimage.html?userId=${userId}" alt="Header image" width="60" height="60"
                                 border="0"/>
                        </td>
                        <td>
                            <b><big>Uploaded by ${loginName} </big></b>
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
                    <tr>
                        <td>Add comment:</td>
                        <td><form:input path="comment"/></td>
                    </tr>
                    <tr>
                        <td>
                            <%--@todo--%>
                            <input type="submit" align="middle" value="Comment" name="comment">
                        </td>
                    </tr>
                    <tr>
                        <td>rating:</td>
                        <td>${rating}</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td><form:hidden id="rating" path="rating"/></td>
        </tr>
        <td>
            <input type="submit" value="Rate" name="rate">
        </td>
    </table>
</form:form>
</body>

</html>