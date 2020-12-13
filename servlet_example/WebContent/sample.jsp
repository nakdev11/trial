<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate,java.time.format.DateTimeFormatter" %>
<%
String[] luckArray = {"大吉", "吉", "凶"};
int index = (int)(Math.random() * 3);
String luck = luckArray[index];

LocalDate date = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
String today = date.format(formatter);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ占い</title>
</head>
<body>
	<p><%= today %>の運勢は「<%= luck %>」です</p>
</body>
</html>