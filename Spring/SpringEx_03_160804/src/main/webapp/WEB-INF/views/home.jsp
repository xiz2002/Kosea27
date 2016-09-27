<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
	<title>POST Param throw</title>
</head>
<body>
<form name="frm"  method="post" action="${pageContext.request.contextPath}/action.do">
	<input type="text" name="name" id="name">
	<input type="submit" value="전송">
</form>
</body>
</html>
