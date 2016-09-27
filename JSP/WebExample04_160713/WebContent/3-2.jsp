<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 2 ^ 1 = <%= power(2,1) %></h2>
	<h2> 2 ^ 2 = <%= power(2,2) %></h2>
	<h2> 2 ^ 3 = <%= power(2,3) %></h2>
	<h2> 2 ^ 4 = <%= power(2,4) %></h2>
	<h2> 2 ^ 5 = <%= power(2,5) %></h2>
	<%! 
		private int power(int base, int f ) {
		int s  = 1;
		for (int c = 1; c <= f; c++ ){
			s *= base;
		}
		return s;
		}
	%>
</body>
</html>