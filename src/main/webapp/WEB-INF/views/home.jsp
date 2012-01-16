<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/screen.css"/>
	<title>Home</title>
</head>
<body>
<div class="header">
    <span class="heading">
        Stories
    </span>
    <a href="add" class="add">Add new story</a>
</div>
<c:forEach items="${stories}" var="story">
    <div class="story">
        <h3><a href="${story.url}">${story.title}</a></h3>
        <sub>Submitted by ${story.user}</sub>
        <p>${story.description}</p>
        (${story.score} votes) <a href="vote?id=${story.id}">Vote!</a>
    </div>
</c:forEach>
</body>
</html>
