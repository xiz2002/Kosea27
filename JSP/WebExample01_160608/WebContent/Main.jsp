<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// Java 문법 영역!
	// "함수"/변수 정의/선언
	// 선언부(declaration)
	// 최근에는 MVC 패턴에 따라 작성함으로 선언부를 사용하지 않고
	// 자바 빈 (Java Bean)으로 대체하는 경우가 많다.(보안)
%>
<%-- Page Directive (지시자) --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- &lt;!DOCTYPE html&gt; -->
<!-- DTD( html(xml) 문법 정의 파일 ) 명세를 적지 안는다.(브라우저에서 판단)-->
<%-- 디렉티브(Directive) 페이지 설정/ 삽입, 라이브러리 호출 등등 --%>
<html>
<!-- &lt;html lang="ko" &gt; : html 5 -->
<head>
<!-- &lt;meta charset = "UTF-8" &gt : html 5 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- 주의사향 : content="text/html; charset=UTF-8"
			  mine(text/html)과 charset간의 중간의 띄워쓰기에 유의 --%>
<title>Insert title here</title>
</head>
<body>
<% 
	// 스크립트릿(scriptlet)
	// 변수, 프로그램의 논리(조건, 반복, 순차 등등)
	// java Code
	// 근간에는 보안/가시적인 부분으로 
	// JSTL등으로 대체하는 경향이 있다.
%>
표현식 : &lt;%=2+3%&gt;<br>
EL(표현 언어) : &#36;&#123;1+2+3&#125; 
<!-- Expression(표현식) : 값이 하나로 반환되는 경우만 사용 : 
					    연산 수식, 낱개 값, (결과값이 낱개로 반환)함수 -->
<!-- 결과값이 void인 함수 ===> 표현식(X) --> 								    
								  
</body>
</html>