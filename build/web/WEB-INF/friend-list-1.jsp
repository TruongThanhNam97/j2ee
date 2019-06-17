<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="online-list">
    <div id="friend-detail-popup">
        <span id="back-triange"></span>
        <span id="front-triange"></span>
        <img id="profile-img" src="img/profile.jpg">
        <div id="friend-detail-popup-detail">
            <p>
                <a id="profile-full-name" href="#"></a>
            </p>
        </div>
    </div>
    <ul>
        <c:set var="list" value="${sessionScope.friendList}"></c:set>
        <c:forEach var="friend" items="${list}">
            <li id="${friend.emailOrPhone}" class="${friend.id}">
                <img class="avatar-small" src="${pageContext.servletContext.contextPath}/ProcessImage?emailOrPhone=${friend.emailOrPhone}"> 
                <span>${friend.lastName} ${friend.firstName}</span>
                <span></span>
            </li>
        </c:forEach>
    </ul>
</div>
<script>
    $(document).ready(function () {
        $("#online-list li").click(function () {
            if (window.confirm("Do you want to unfriend?") === true)
            {
                var idFriend = $(this).attr("class");
                $.ajax({
                    url: "ProcessUnfriend1",
                    type: "POST",
                    data: {
                        idFriend: idFriend
                    },
                    success: function (data) {
                        $(".ahi").html(data);
                    },
                    error: function () {
                        alert("cannot unfriend");
                    }
                })
            }
        })
        $("#online-list li").hover(function () {
            var emailOrPhone = $(this).attr("id");
            $.ajax({
                url: "IndividualProfile",
                type: "POST",
                dataType: "json",
                data: {
                    emailOrPhone: emailOrPhone
                },
                success: function (data) {
                    $("#profile-img").attr("src", data.imageString);
                    $("#profile-full-name").html(data.fullName);
                },
                error: function () {
                    alert("cannot load data");
                }
            });
        }, function () {
        })
    })
</script>
