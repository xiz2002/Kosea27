<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$("#searchFromDate").datepicker(
				{
					changeMonth : true,
					changeYear : true,
					dateFormat : 'mm dd.yy',
					showOn : "button",
					onSelect : function(selectedDate) {
						$("#searchToDate").datepicker("option", "minDate",
								selectedDate);
					}
				});
	});
	$(function() {
		$("#searchToDate").datepicker(
				{
					changeMonth : true,
					changeYear : true,
					dateFormat : 'mm dd.yy',
					showOn : "button",
					onSelect : function(selectedDate) {
						$("#searchFromDate").datepicker("option", "maxDate",
								selectedDate);
					}
				});
	});
	function btn() {
		alert($("#test").val());
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="searchFromDate" name="searchFromDate" value="">
	<input type="text" id="searchToDate" name="searchToDate" value="">
	<input type="text" id="test" name="test">
	<input type="button" id="btn" name="btn" onclick="btn();"
		value="BUTTON">
</body>
</html>