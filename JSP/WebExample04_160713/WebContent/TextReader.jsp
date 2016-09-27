<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Reader</title>
</head>
<body>
	<%
		BufferedReader reader = null;
		String path = application.getContextPath();
		out.println(path+"<BR>");
		try {
			String strPath = application.getRealPath("/WEB-INF/TT.txt");
			out.println(strPath+"<BR>");
			reader = new BufferedReader(new FileReader(strPath));
			while (true) {
				String strSub = reader.readLine();
				if (strSub == null) {
					break;
				}
				out.println(strSub + "<BR>");
			}
		} catch (FileNotFoundException e) {
			out.println("File is Not Found!");
			e.printStackTrace();
		} catch (IOException e) {
			out.println("IO ERROR");
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	%>

</body>
</html>