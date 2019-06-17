<%@page import="model.Profile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="list" value="${requestScope.suggestedList}"></c:set>
<c:forEach var="friend" items="${list}">
    <div class="friend-item">
        <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=${friend.emailOrPhone}"> 
        <span>
            <a href="#">${friend.lastName} ${friend.firstName}</a>
            <span style="display: block;">123 mutual friends</span>
            <button id="${friend.id}"><i class="fa fa-user-plus" aria-hidden="true"></i>Add friend</button>
        </span>
        <a href="#" class="ignore-friend"><i class="fa fa-times" aria-hidden="true"></i></a>
    </div>
</c:forEach>
<script>
    $(function (){
        $(".friend-item button").click(function (){
            var friendId = $(this).attr("id");
            $.ajax({
                url : "ProcessSuggestFriend",
                type : "POST",
                data : {
                   action : "add-friend",
                   "friend-id" : friendId
                },
                success : function (data){
                    $("#suggested-friend").html(data);
                    $.ajax({
                        url : "ProcessReloadFriendList",
                        type : "GET",
                        success : function (data){
                            $(".ahi").html(data);
                        },
                        error : function ()
                        {
                            alert("error");
                        }
                    })
                },
                error : function (e) {
                    alert("Error loading ajax: ");
                }
            })
        })
    })
</script>
