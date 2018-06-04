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

<header>
	<div id="header-inner">
		<a href="#" id="logo"></a> 
		<nav>
			<a href="#" id="menu-icon"></a>
			<ul>
				<li><a href="#">Zasady</a></li>
				<li><a href="#">Kontakt</a></li>
			</ul>
		</nav>
	</div>
</header>

<c:set var="zmienna" value="test1"   />


<section class="${zmienna == 'test2'? 'meaning':'meaningtwo'}">
	<div class="meaning-inner">
		<p>O przysłowiu:</p>
		<c:out value="${CHARADE_MEANING}"/>
	</div>
</section>

<section class="hangman">
	<div class="hangman-inner">
		<p>Obrazek:</p>
		<img src="hangman.png">  <!---changing images-->
	</div>
</section>

<section class="points">
	<div class="points-inner">
		<p>Punkty do zdobycia:</p>
		<c:out value="${POINTS_TO_WIN}"/>
	</div>
</section>

<section class="hidden">
	<div class="hidden-inner">
		<p>Odgadnij przysłowie:</p>
		<c:out value="${CHARADE_HIDDEN}"/>
	</div>
</section>

<section class="letters">
	<div class="letters-inner">
		<p>Wybierz literę:</p>
		<form action="">
			

		</form>
	</div>
</section>


<footer>
	<div class="container">
		<p>Piotr Szewczul</p>
	</div>	
</footer>


</body>
</html>