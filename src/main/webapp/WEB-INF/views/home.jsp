<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/screen.css"/>
    <script type="text/javascript" src="resources/javascript/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="resources/javascript/jquery.formdefaults.js"></script>
    <title>Home</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".tag").formDefaults();
            $(".tag").blur(function () {
                addTag($(this))
                $(this).val("New tag")
            });
            $(".tag").keypress(function (e) {
                code = (e.keyCode ? e.keyCode : e.which);
                if (code == 13) {
                    addTag($(this));
                    $(this).val("");
                }
            });
        });

        function addTag(element) {
            if (element.val() != "New tag" && element.val() != "") {
                var storyId = element.prev().val();
                jQuery.get("/digger/stories/tag", {tag:element.val(), story:element.prev().val()}, function (data) {
                        $("#tags-" + storyId).html(data)
                });

            }
        }
    </script>
</head>
<body>
<div class="header">
    <span class="heading">
        Stories
        <c:if test="${not empty param.tag}">
            <span class="tagheading">(tag:${param.tag})</span>
        </c:if>
    </span>
    <a href="add" class="add">Add new story</a>
</div>
<c:forEach items="${stories}" var="holder">
    <div class="story">
        <h3><a href="${story.url}">${holder.story.title}</a></h3>
        <span class="tags" id="tags-${holder.id}">
            <c:forEach items="${holder.tags}" var="tag">
                <a href='/digger/stories/tagged?tag=${tag}'>${tag}</a>
            </c:forEach>
        </span>
        <input type="hidden" name="id" value="${holder.id}"/>
        <input type="text" name="tag" class="tag" value="New tag"/>

        <span class="submitted">Submitted by ${holder.story.user}</span>

        <p>${holder.story.description}</p>
        (${holder.score} votes) <a href="vote?id=${holder.id}">Vote!</a>
    </div>
</c:forEach>
</body>
</html>
