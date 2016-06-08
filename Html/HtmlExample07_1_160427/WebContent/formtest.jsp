<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!-- 
	160427 - 수업 파일
		   - HTML Method 설명
		   
	160429 - maxlegth, checkbox, radio, file select, option 설명
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Form</title>
</head>
<body>
	<form name="frm" method="post" action="action.jsp">
	<!-- HTML Method
		 Create - insert - POST
		 Read - select - GET / Default / 전송시 1Kb 이상 불가.
		 update - update - PUT
		 delete - delete - DELETE
		 ISO-8859-1 / 서유럽어로 전송된다.
		 
	 -->
		<!--maxlength : 최대 입력 가능 글자 수
						영문과 한글과 다름
						Byte 계산
						공백문제를 해결하기 위해 trim(앞뒤공백)과 replaceAll(중간공백)사용
			checkbox : id 와 name은 제어를 용이하게 하기 위해 같게 한다.
					 checked를 넣으면 체크된체로 나온다. (값자체임)
			radio : 동일하게 해야 같은 그룹으로 본다. 
			file : 파일 업로드 하기 위해서는 post 방식만 가능하다.
		 -->
		<input type="text" id="id" name="id"><br>
		<input type="password" id="pw" name="pw"><br>
		<input type="checkbox" id="chkbox" name="chkbox" value="11"> 1&nbsp;
		<input type="checkbox" id="chkbox" name="chkbox" value="22"> 2&nbsp;
		<input type="checkbox" id="chkbox" name="chkbox" value="33"> 3&nbsp;<br>
		<input type="radio" id="rd" name="rd" value="yes">&nbsp;
		<input type="radio" id="rd" name="rd" value="no"><br>
		<textarea id="longtext" name="longtext" cols="30" rows="10"></textarea><br>
		<select id="slctbox" name="slctbox">
			<option>--------</option> <!-- 크기를 일부러 늘리는 방법. 단, 구분선이 서버로 넘어가지 않도록 확인을 해야한다.-->
			<option value ="1111" selected>1</option> <!-- value에 있는 값이 넘어간다. -->
			<option>2</option>
		</select>
		<input type="file" id="filename" name="filename"><p>
		<input type="submit" value="전송">&nbsp;
		<input type="reset" value="취소">
		
	</form>
</body>
</html>