<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<c:forEach items="${tags}" var="tag">
    <a href="/digger/stories/tagged?tag=${tag}">${tag}</a>
</c:forEach>