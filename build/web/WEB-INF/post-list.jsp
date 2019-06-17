
<%@page import="model.Profile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="list" value="${requestScope.postList}"></c:set>
<c:forEach var="post" items="${list}">
    <div class="middle-section user-post">
        <div class="user-post-header">
            <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=${post.email_mobile}">
            <span>
                <a href="#">${post.username}</a>
                <%
                    Profile currentUser = (Profile)session.getAttribute("user");
                %>
                <a href="" class="btn btn-danger">Delete your post</a>
            </span>
        </div>
        <div class="user-post-body">
            ${post.posttext}
            <img src="${pageContext.servletContext.contextPath}/ProcessImagePost?id=${post.id}">
        </div>

        <div class="user-post-tool">
            <a href=""><i class="fa fa-thumbs-up" aria-hidden="true"></i> Like</a>
            <a href=""><i class="fa fa-comment" aria-hidden="true"></i> Comment</a>
            <a href=""><i class="fa fa-share" aria-hidden="true"></i> Share</a>
        </div>
        <div class="user-post-info">
            <span class="like-icon"><i class="fa fa-thumbs-up" aria-hidden="true"></i></span>
            <a href="">You and others like this</a>
        </div>

        <div class="user-post-comment-list">
            <div class="user-post-comment-item">
                <img src="img/user-comment1.jpg">
                <span>
                    <a href="#">Kiki</a> Ahuhu ahihi
                    <div class="help-block">
                        <a href="#">Like</a>.
                        <a href="#">Reply</a>.
                        21 hrs
                    </div>
                </span>
                <div class="user-post-reply-item">
                    <i class="fa fa-share" aria-hidden="true"></i>
                    <img src="img/user-comment3.jpg">
                    <a href="">Ahiuhiu . 20 replies</a>
                </div>
            </div>
            <div class="user-post-comment-item">
                <img src="img/user_comment2.jpg">
                <span>
                    <a href="#">John cena</a> Ngon
                    <div class="help-block">
                        <a href="#">Like</a>.
                        <a href="#">Reply</a>.
                        21 hrs
                    </div>
                </span>
            </div>
            <div class="user-post-comment-item">
                <img src="img/user-comment3.jpg">
                <span>
                    <a href="#">RNG Xiaohu</a> Ngon ngon
                    <div class="help-block">
                        <a href="#">Like</a>.
                        <a href="#">Reply</a>.
                        <span class="like-icon-small"><i class="fa fa-thumbs-up" aria-hidden="true"></i></span>. 21 hrs
                    </div>
                </span>
            </div>
        </div>

        <div class="user-post-reply-form">
            <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=${sessionScope.user.emailOrPhone}"> 
            <div class="user-post-reply-editor" contenteditable="true">

            </div>
            <span>
                <i class="fa fa-picture-o" aria-hidden="true"></i>
                <input type="file" class="masked-file-input" name="upload-2"/>
            </span>
            <span>
                <i class="fa fa-smile-o" aria-hidden="true"></i>
            </span>

        </div>
    </div>
</c:forEach>

