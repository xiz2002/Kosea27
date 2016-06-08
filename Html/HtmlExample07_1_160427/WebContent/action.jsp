<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>form action</title>
</head>
<body>
	<%
		request.setCharacterEncoding("EUC-KR"); 
	%>
	text :
	<%=request.getParameter("id")%><br> password :
	<%=request.getParameter("pw")%><br> checkbox :
	<%
		String[] chkArr = request.getParameterValues("chkbox");

		for (String arr : chkArr) {
			out.println(arr);
		}
	%><br> radio :
	<%=request.getParameter("rd")%><br> textarea :
	<%=request.getParameter("longtext")%><br> file :
	<%=request.getParameter("filename")%><br>
</body>
</html>