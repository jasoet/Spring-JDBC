<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
<form action="<c:url value='/dosen?action-save'/>" method="POST">
    NIY <input type="text" name="niy"/> <br/>
    Nama <input type="text" name="nama"/> <br/>
    <input type="submit">OKE</input>
</form>
</body>
</html>
