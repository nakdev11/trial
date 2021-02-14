<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate,java.time.format.DateTimeFormatter" %>
<%
// 運勢をランダムで決定
String[] luckArray = {"大吉", "中吉", "吉", "凶" };
int index = (int)(Math.random() * 4);
String luck = luckArray[index];
// 日付
LocalDate date = LocalDate.now();
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
String today = date.format(dtf);
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