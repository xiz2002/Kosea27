<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>action</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

param1 : ${param1}<br> <!-- model.addAttribute -->
param2 : ${param2}<br> <!-- request.setAttribute -->
param3 : ${param3}<br> <!-- map -->
param4 : ${param4}<br>  <!-- ReqeustBody  : 한글 처리 잘 안됨 -->
param5 : ${param5}<br>  <!-- POJO : member -->

</body>
</html>
