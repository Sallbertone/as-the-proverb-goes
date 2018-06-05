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
		
		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="A">
		<input type="submit" value="A">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Ą">			
		<input type="submit" value="Ą">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="B">
		<input type="submit" value="B">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="C">
		<input type="submit" value="C">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Ć">			
		<input type="submit" value="Ć">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="D">
		<input type="submit" value="D">
		</form>



		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="E">
		<input type="submit" value="E">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Ę">			
		<input type="submit" value="Ę">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="F">
		<input type="submit" value="F">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="G">
		<input type="submit" value="G">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="H">			
		<input type="submit" value="H">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="I">
		<input type="submit" value="I">
		</form>



		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="J">
		<input type="submit" value="J">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="K">			
		<input type="submit" value="K">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="L">
		<input type="submit" value="L">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Ł">
		<input type="submit" value="Ł">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="M">			
		<input type="submit" value="M">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="N">
		<input type="submit" value="N">
		</form>



		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Ń">
		<input type="submit" value="Ń">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="O">			
		<input type="submit" value="O">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Ó">
		<input type="submit" value="Ó">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="P">
		<input type="submit" value="P">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="R">			
		<input type="submit" value="R">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="S">
		<input type="submit" value="S">
		</form>




		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Ś">
		<input type="submit" value="Ś">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="T">			
		<input type="submit" value="T">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="U">
		<input type="submit" value="U">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="W">
		<input type="submit" value="W">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Y">			
		<input type="submit" value="Y">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Z">
		<input type="submit" value="Z">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Ź">
		<input type="submit" value="Ź">
		</form>

		<form action="CharadesControllerServlet">
		<input type="hidden" name="letter" value="Ż">
		<input type="submit" value="Ż">
		</form>

	</div>
</section>

<section class="hidden">
	<div class="hidden-inner">
		<p>Odgadnij przysłowie:</p>
			<form action="CharadesControllerServlet" method="POST">
				<input type="hidden" name="command" value="GUESSPROVERB">
				<input type="text" placeholder="Wpisz przysłowie. Pamiętaj o znakach przestankowych!" name="guess">
				<input type="submit" value="ODGADNIJ PRZYSŁOWIE" >
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