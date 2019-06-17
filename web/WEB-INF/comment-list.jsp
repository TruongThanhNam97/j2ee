<%@page import="model.Profile"%>
<%@page import="model.Comment"%>
<%@page import="java.util.List"%>
<%@page import="dao.CommentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<c:set var="list" value="${requestScope.commentList}"></c:set>
<c:forEach var="comment" items="${list}">
    <div class="user-post-comment-item">
        <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=${comment.email_mobile}">
        <span>
            <a href="#">${comment.username}</a>${comment.commenttext}
            <div class="help-block">
                <a href="#">Like</a>
                <a href="#">Reply</a>
            </div>
        </span>
    </div>
</c:forEach>--%>

<%
    List<Comment> commentList = (List<Comment>) request.getAttribute("commentList");
    Profile current = (Profile) session.getAttribute("user");
    for (Comment item : commentList) {
        boolean check = false;
        if (item.getIduser() == current.getId()) {
            check = true;
        }
%>
<div class="user-post-comment-item">
    <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=<%=item.getEmail_mobile()%>">
    <span>
        <a href="#"><%=item.getUsername()%></a><%=item.getCommenttext()%>
        <div class="help-block">
            <a href="#">Like</a>
            <a href="#">Reply</a>
            <a href="#" class="commenttime"><%=item.getCommenttime() %></a>
        </div>
    </span>
    <%
        if (check) {
    %>
    <div class="btn btn-danger deleteComment" id="<%=item.getId()%>@<%=item.getIdpost()%>"><i class="fa fa-times"></i></div>
        <%
            }
        %>
</div>
<%
    }
%>
<script>
    $(".deleteComment").click(function () {
        var data = $(this).attr("id");
        var idComment = data.split("@")[0];
        var idPost = data.split("@")[1];
        $.ajax({
            url: "ProcessDeleteComment",
            type: 'POST',
            data: {
                idComment: idComment,
                idPost: idPost
            },
            success: function (data)
            {
                $(".user-post-comment-list." + idPost).html(data);
            },
            error: function ()
            {
                alert("Error delete comment");
            }
        })
    })
</script>


