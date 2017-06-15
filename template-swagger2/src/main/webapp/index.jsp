<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Server Time</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date"/>    
Server Time: <fmt:formatDate value="${now}" pattern="dd-MM-yyyy HH:mm:ss a z" />
</body>
</html>