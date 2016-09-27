<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int iTotal = 0;
		for (int iCnt = 1; iCnt <= 100; iCnt ++){
			iTotal += iCnt;
		}
	%>
	<h2>1 부터 100까지의 합 = <%=iTotal%></h2>
	<%
		for (int iCnt = 101; iCnt <= 200; iCnt++) {
			iTotal += iCnt;
		}
	%>
	<h2>1 부터 200까지의 합 = <%=iTotal%></h2>
</body>
</html>