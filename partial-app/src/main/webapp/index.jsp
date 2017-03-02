<%@ page language="java" contentType="text/html;" %>
<%@ page import="org.demo.app.StringUtil" %>
<html>
<head>
    <title>Partial app</title>
</head>
<body>
    <span>Capitalize 'demo' from optional package: </span><%= StringUtil.capitalize("demo") %>
    <br>
    <span>Image from shared library: </span><img src="oracle.gif"/>
</body>
</html>