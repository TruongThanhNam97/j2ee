<%@page import="dao.CommentDAO"%>
<%@page import="model.Comment"%>
<%@page import="dao.LikeDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Post"%>
<!DOCTYPE html>
<html>

    <jsp:include page="/WEB-INF/head_tag.jsp">
        <jsp:param name="title" value="New feed" />
    </jsp:include>

    <body>
        <%@include file="/WEB-INF/top_nav.jspf" %>

        <section class="container-fluid" id="main-body">
            <div class="row no-pad">
                <div class="col-md-2 no-pad">
                    <div class="left-tool-section">
                        <a href="">
                            <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=${sessionScope.user.emailOrPhone}"> 
                            ${sessionScope.user.firstName}
                            ${sessionScope.user.lastName}
                        </a>
                        <a href="FrontController?action=view-profile"><i class="fa fa-pencil" aria-hidden="true"></i> Edit Profile</a>
                    </div>

                    <div class="left-tool-section">
                        <h4>FAVORITES</h4>
                        <a href=""><i class="fa fa-newspaper-o" aria-hidden="true"></i> News Feed</a>
                        <a href=""><i class="fa fa-globe" aria-hidden="true"></i> Messages</a>
                        <a href=""><i class="fa fa-weixin" aria-hidden="true"></i> Events</a>
                        <a href=""><i class="fa fa-life-ring" aria-hidden="true"></i> Sales Group</a>
                    </div>

                    <div class="left-tool-section">
                        <h4>FRIENDS</h4>
                        <a href=""><i class="fa fa-location-arrow" aria-hidden="true"></i> Ho Chi Minh City</a>
                        <a href=""><i class="fa fa-graduation-cap" aria-hidden="true"></i> Truong THPT Phu Nhuan</a>
                        <a href=""><i class="fa fa-building" aria-hidden="true"></i> FPT Corporation</a>
                        <a href=""><i class="fa fa-graduation-cap" aria-hidden="true"></i> UIT</a>
                    </div>

                    <div class="left-tool-section">
                        <h4>APPS</h4>
                        <a href=""><i class="fa fa-industry" aria-hidden="true"></i> Live Videos</a>
                        <a href=""><i class="fa fa-gamepad" aria-hidden="true"></i> Games</a>
                        <a href=""><i class="fa fa-heart-o" aria-hidden="true"></i> On This Day</a>
                        <a href=""><i class="fa fa-picture-o" aria-hidden="true"></i> Photos</a>
                        <a href=""><i class="fa fa-gamepad" aria-hidden="true"></i> Games Feed</a>
                    </div>

                    <div class="left-tool-section">
                        <h4>EVENTS</h4>
                        <a href=""><i class="fa fa-bicycle" aria-hidden="true"></i> Live Videos</a>
                        <a href=""><i class="fa fa-music" aria-hidden="true"></i> Musics</a>
                        <a href=""><i class="fa fa-fax" aria-hidden="true"></i> Re-Union</a>
                        <a href=""><i class="fa fa-deaf" aria-hidden="true"></i> Company Trips</a>
                        <a href=""><i class="fa fa-credit-card-alt" aria-hidden="true"></i> Family Trips</a>
                    </div>
                </div>
                <div class="col-md-5 no-pad">
                    <div class="middle-section" id="post-form">
                        <form action="ProcessAddPost" method="post" enctype="multipart/form-data">
                            <div id="post-form-header">
                                <a href="#" id="button-upload-photo">
                                    <i class="fa fa-file-image-o" aria-hidden="true"></i> Photo/Camera
                                    <input type="file" class="masked-file-input" id="myfile" name="postimage" />
                                </a>
                                <span id="post-form-close-button">x</span>
                            </div>
                            <div id="post-form-body">
                                <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=${sessionScope.user.emailOrPhone}">
                                <!--                                                            <div id="post-form-editor" contenteditable>
                                                                                                
                                                                                            </div>-->
                                <textarea  name="posttext"  id="post-form-editor" style="width: 100%;height: 100%;" placeholder="What's your mind?"></textarea>
                            </div>
                            <div id="post-form-footer">
                                <div class="row no-pad">
                                    <div class="col-md-6 no-pad">
                                        <a href="">
                                            <i class="fa fa-user-plus" aria-hidden="true"></i>
                                        </a>
                                        <a href="">
                                            <i class="fa fa-map-marker" aria-hidden="true"></i>
                                        </a>
                                        <a href="">
                                            <i class="fa fa-smile-o" aria-hidden="true"></i>
                                        </a>
                                    </div>
                                    <div class="col-md-6 no-pad" style="text-align:right;">
                                        <a href="#" id="button-public">
                                            <i class="fa fa-globe" aria-hidden="true"></i> Public <i class="fa fa-caret-down" aria-hidden="true"></i>
                                        </a>
                                        <button type="submit" id="button-post">
                                            Post
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                                
                    <div class="alert-danger">${sessionScope.error}</div>
                    
                    <%                        
                            List<Post> postList = (List<Post>) request.getAttribute("postList");
                            for (Post post : postList) {
                            boolean x = false;
                            Profile current = (Profile) session.getAttribute("user");
                            if (post.getIduser() == current.getId()) {
                                x = true;
                            }
                            int likes = LikeDAO.getLike(post.getId());
                            boolean checkLiked = LikeDAO.checkLiked(post.getId(), current.getId());
                            List<Comment> commentList = CommentDAO.getCommentList(post.getId());
                    %>
                    <div class="middle-section user-post">
                        <div class="user-post-header">
                            <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=<%=post.getEmail_mobile()%>">
                            <span>
                                <a href="#"><%=post.getUsername()%></a>
                                <p class="posttime"><%=post.getPosttime() %></p>
                                
                            </span>
                                 <%
                                    if (x) 
                                    {
                                        %>
                                        <a href="ProcessDeletePost?id=<%=post.getId()%>" class="btn btn-danger btndelete">Delete your post</a>
                                        <%
                                    }
                                %>
                        </div>
                        <div class="user-post-body">
                            <%= post.getPosttext()%>
                            <%
                                   if ( post.getPostimage().length !=0 )
                                   {
                                       %>
                                                                        <img src="${pageContext.servletContext.contextPath}/ProcessImagePost?id=<%=post.getId()%>">
                                       <%
                                   }
                            %>
                        </div>

                        <div class="user-post-tool">
                            <%
                                   if (checkLiked)
                                   {
                                       %>
                                       <a href="" id="<%=post.getId()%>" class="like" style="color: blue;"><i class="fa fa-thumbs-up" aria-hidden="true"></i> Like</a>
                                        <%
                                   }
                                   else
                                   {
                                        %>
                                                <a href="" id="<%=post.getId()%>" class="like"><i class="fa fa-thumbs-up" aria-hidden="true"></i> Like</a>
                                        <%
                                   }
                            %>
                            <a href=""><i class="fa fa-comment" aria-hidden="true"></i> Comment</a>
                            <a href=""><i class="fa fa-share" aria-hidden="true"></i> Share</a>
                        </div>
                            <%
                                    if ( likes != 0 )
                                    {
                                        %>
                                                <div class="user-post-info <%=post.getId()%>">
                                                <span class="like-icon"><i class="fa fa-thumbs-up" aria-hidden="true"></i></span>
                                                <a href=""><%=likes%> likes</a>
                                                </div>
                                        <%
                                    }
                                    else
                                    {
                                        %>
                                                <div class="user-post-info <%=post.getId()%>">
                                                </div>
                                        <%
                                    }
                            %>
                        <div class="user-post-comment-list <%=post.getId()%>">
                            <%
                                    for ( Comment item : commentList )
                                    {
                                        boolean yourComment = false;
                                        if ( current.getId() == item.getIduser() )
                                        {
                                             yourComment = true;
                                        }
                                        %>
                                                <div class="user-post-comment-item">
                                                <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=<%=item.getEmail_mobile()%>">
                                                 <span>
                                                <a href="#"><%=item.getUsername() %></a><%=item.getCommenttext() %>
                                                <div class="help-block">
                                                <a href="#">Like</a>
                                                <a href="#">Reply</a>
                                                <a href="#" class="commenttime"><%=item.getCommenttime() %></a>
                                                </div>
                                                </span>
                                                <%
                                                        if ( yourComment )
                                                        {
                                                            %>
                                                                   <div class="btn btn-danger deleteComment" id="<%=item.getId() %>@<%=item.getIdpost()%>"><i class="fa fa-times"></i></div>
                                                            <%
                                                        }
                                                %>
                                                </div>
                                        <%
                                    }
                            %>
                        </div>

                        <div class="user-post-reply-form">
                            <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=${sessionScope.user.emailOrPhone}"> 
                            <input id="<%=post.getId()%>" class="user-post-reply-editor" contenteditable="true" placeholder="Write a comment">

                            </input>
                            <span>
                                <i class="fa fa-picture-o" aria-hidden="true"></i>
                                <input type="file" class="masked-file-input" name="upload-2"/>
                            </span>
                            <span>
                                <i class="fa fa-smile-o" aria-hidden="true"></i>
                            </span>

                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
                <div class="col-md-3 no-pad">
                    <div class="middle-right-section">
                        <div class="middle-right-section-header">
                            <span>
                                <i class="fa fa-gift" aria-hidden="true"></i>
                                <a href="#">3 event invitations today</a>
                            </span>
                            <span>
                                <i class="fa fa-calendar" aria-hidden="true"></i>
                                <a href="">Truong Thanh Nam</a>'s birthday is today
                            </span>
                        </div>
                        <div class="middle-right-section-body">
                            <div class="middle-right-section-body-title">
                                <label>PEOPLE YOU MAY KNOW</label>
                                <a href="#">See All</a>
                            </div>
                            
                            
                            <div id="suggested-friend">

                            </div>
                            
                            
                            
                        </div>
                    </div>
                </div>
                <div class="col-md-2 no-pad ahi">
                    <%@include file="/WEB-INF/friend-list.jsp" %>
                </div>
            </div>
            <section id="chat-box">
                <div id="chat-box-header">
                    <a href="#">Cà Chua</a>
                    <span>
                        <i class="fa fa-plus" aria-hidden="true"></i>
                        <i class="fa fa-camera" aria-hidden="true"></i>
                        <i class="fa fa-volume-control-phone" aria-hidden="true"></i>
                        <i class="fa fa-cog" aria-hidden="true"></i>
                        <i id="close-chat-box-button" class="fa fa-times" aria-hidden="true"></i>
                    </span>
                </div>
                <div id="chat-box-content-wrapper">
                    <div id="chat-box-content">
                    </div>
                    <div id="chat-box-editor" contenteditable="true"></div>
                </div>
                <div id="chat-box-editor-tool">
                    <span>
                        <i class="fa fa-picture-o" aria-hidden="true"></i>
                        <i class="fa fa-paperclip" aria-hidden="true"></i>
                        <i class="fa fa-smile-o" aria-hidden="true"></i>
                        <i class="fa fa-hand-peace-o" aria-hidden="true"></i>
                    </span>
                    <span>
                        <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
                    </span>
                </div>
            </section>
        </section>

        <!--Confirm dialog -This must be the child of body-->
        <div id="dialog-confirm">
            <div id="dialog-confirm-header">
                <a href="#" id="dc-btn-close">Close</a>
            </div>
            <div id="dialog-confirm-body">
                <p>Are you sure you want to remove this friend?</p>
                <p>Becareful! Because you will not be able to see this person again</p>
                <p>Why don't you take some time to think about this action?</p>
            </div>
            <div id="dialog-confirm-footer">
                <a href="#" id="dc-btn-yes">Yes, I do</a>
                <a href="#" id="dc-btn-no">No, This is a mistake</a>
                <a href="#" id="dc-btn-cancel">Cancel</a>
            </div>
        </div>

        <script>
            $(function () {
                // Load suggested friend with AJAX
                $.ajax({
                    url: "ProcessSuggestFriend",
                    type: "POST",
                    success: function (data) {
                        $("#suggested-friend").html(data);
                    },
                    error: function (e) {
                        alert("Error loading ajax " + e);
                    }
                })
                var viewportHeight = $(window).height();
                $("#online-list ul").css("max-height", viewportHeight);
                
                $(".like").click(function(e){
                    e.preventDefault();
                    var idPost = $(this).attr("id");
                    $.ajax({
                        url : "ProcessLikePost",
                        type : "POST",
                        data : {
                            idPost : idPost
                        },
                        success : function (data)
                        {
                           var likes = data.likes;
                           var checkLiked = data.checkLiked;
                           if ( likes == "0" )
                           {
                               $(".user-post-info."+idPost+"").html("");
                           }
                           else
                           {
                              $(".user-post-info."+idPost+"").html('<span class="like-icon"><i class="fa fa-thumbs-up" aria-hidden="true"></i></span><a href="">'+likes+' likes</a>');
                           }
                           if ( checkLiked == "nolike" )
                           {
                                 $(".like").css({"color":""});
                           }
                           else
                           {
                                  $(".like").css({"color":"blue"});
                           }
                        },
                        error : function ()
                        {
                            alert("Error event like");
                        }
                    })
                })
                $(".user-post-reply-editor").on("keydown",function (e){
                    if ( e.keyCode == "13" )
                    {
                       var commenttext = $(this).val();
                       var idpost = $(this).attr("id");
                       $.ajax({
                           url : "ProcessAddComment",
                           type: "POST",
                           data : {
                               commenttext : commenttext,
                               idpost : idpost
                           },
                           success : function (data)
                           {
                               $(".user-post-comment-list."+idpost).html(data);
                           },
                           error : function ()
                           {
                               alert("Error event write comment");
                           }
                       })
                       $(this).val("");
                    }
                })
                $(".deleteComment").click(function (){
                    var data = $(this).attr("id");
                    var idComment = data.split("@")[0];
                    var idPost = data.split("@")[1];
                    $.ajax({
                        url : "ProcessDeleteComment",
                        type: 'POST',
                        data : {
                            idComment : idComment,
                            idPost : idPost
                        },
                        success : function (data)
                        {
                            $(".user-post-comment-list."+idPost).html(data);
                        },
                        error : function ()
                        {
                            alert("Error delete comment");
                        }
                    })
                })
            });
        </script>
        <script src="js/app.js"></script>
    </body>

</html>
