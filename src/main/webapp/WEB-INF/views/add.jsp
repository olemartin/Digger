<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/screen.css"/>
	<title>Add story</title>
</head>
<body>
<h1>
	Add story
</h1>
<form:form commandName="story" >
    <form:label path="url">Url</form:label><form:input cssClass="addInput" path="url"/>
    <form:label path="title">Title</form:label><form:input cssClass="addInput" path="title"/>
    <form:label path="description">Description</form:label><form:input cssClass="addInput" path="description"/>
    <form:label path="user">User</form:label><form:input cssClass="addInput" path="user"/>
    <input class="button" type="submit" value="Save Changes" />
</form:form>

</body>
</html>
