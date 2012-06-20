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
            <td height="50px">
               &nbsp;
            </td>
        </tr>
        <tr>
            <td>
                <table>
                    <tr>
                        <td>
                            <img src="image/photoimage.html?photoId=${photo.photoId}" alt="photo" border="0"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>${photo.caption}</b>
                        </td>
                    </tr>
                    <c:if test="${not empty photo.description} ">
                        <tr>
                            <td class="tableText">
                                ${photo.description}
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${not empty photo.location} ">
                        <tr>
                            <td class="tableText">
                                Location: ${photo.location}
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>Rating:</td>
                        <td>${rating}</td>
                    </tr>
                    <tr>
                        <td>
                            <form:hidden id="rating" path="rating"/>
                        </td>
                        <td>
                            <input type="submit" value="Rate" name="rate">
                        </td>
                    </tr>
                    <tr>
                        <td class="error">
                            ${error}
                        </td>
                    </tr>
                </table>
            </td>
            <td width="50px">
                &nbsp;
            </td>
            <td>
                <table bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
                    <tr>
                        <td width="70" height="70">
                            <img src="image/userimage.html?userId=${userId}" alt="Header image" width="60" height="60"
                                 border="0"/>
                        </td>
                        <td>
                            <b><big>Uploaded by ${uploadedBy} </big></b>
                        </td>
                    </tr>
                    <tr>
                        <td height="20px">
                            &nbsp;
                        </td>
                    </tr>
                </table>
                <table bgcolor="f8f8ff" border="3" bordercolor = "#ffffff" cellspacing="0" cellpadding="5" title="Photo Comments" >
                    <c:if test="${not empty commentList}">
                        <c:forEach var="comment" items="${commentList}">
                            <tr>
                                <td class="tableText">${comment.commentedBy.loginName}</td>
                                <td>${comment.photoComment}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
                <br>
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
                </table>
            </td>
        </tr>
    </table>
</form:form>
</body>

</html>