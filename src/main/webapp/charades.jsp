<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Kalambury</title>
</head>
<body>


<c:out value="${CHARADE_MEANING}" default="jeślinull" />
<c:out value="${CHARADE_HIDDEN}" default="jeślinull" />

<footer>
	<div class="container">
		<p>Piotr Szewczul<br>
		piotr.szewczul@gmaii.com<br>
		605182777</p>
	</div>	
</footer>


</body>
</html>