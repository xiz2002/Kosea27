<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	GregorianCalendar now = new GregorianCalendar();
%>
<%=String.format(" %TY, %Tm, %Td ", now, now, now)%>
