<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/screen.css"/>
	<title>Home</title>
</head>
<body>
<div class="header">
    <span class="heading">
        Stories
    </span>
    <a href="add" class="add">Add new story</a>
</div>
<c:forEach items="${stories}" var="holder">
    <div class="story">
        <h3><a href="${story.url}">${holder.story.title}</a></h3>
        <sub>Submitted by ${holder.story.user}</sub>
        <p>${holder.story.description}</p>
        (${holder.score} votes) <a href="vote?id=${holder.id}">Vote!</a>
    </div>
</c:forEach>
</body>
</html>
