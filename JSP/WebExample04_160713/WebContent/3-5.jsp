<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 이것은 JSP에 의해 생성된 HTML입니다. -->
</head>
<body>
	<%--다음은 데이터를 처리하는 스릡틀릿 입니다. --%>
	<%
		int iResult = 1;
		for (int c = 1; c < 10; c++) {
			iResult *= c;
		}
	%>
	<h2><%=iResult%>
	</h2>
</body>
</html>