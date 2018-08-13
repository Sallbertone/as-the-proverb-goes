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
	<div class="container">
		<a href="#" id="logo">KALAMBURY - Polskie Przysłowia</a> 
		<nav>
			<a href="#" id="menu-icon"></a>
			<ul>
				<li><a href="#">Zasady</a></li>
				<li><a href="#">Kontakt</a></li>
			</ul>
		</nav>
	</div>
</header>




<section id="meaning">   
	<div class="container">
		<h2>O przysłowiu:</h2>
		<c:out value="${CHARADE_MEANING}"/>
	</div>
</section>

<section id="hangman-and-points">
	<div class="container">
		<div id="hangman">
			<img src="img/chalkboard.jpg">  <!---changing images-->
		</div>
		<div id="points">
			<h2>Punkty do zdobycia:</h2>

			<h1><c:out value="${sessionScope.POINTS_TO_WIN}"/></h1>
		</div>
	</div>
</section>

<section id="hidden">
	<div class="container">
		<h3>
			<c:out value="${sessionScope.CHARADE_HIDDEN}"/>
		</h3>
	</div>
</section>



<c:forEach var="tempLetter" items="${ALL_USED_LETTERS}">

	<c:if test="${tempLetter == 'A'}">
    	<c:set var="varA" value="${tempLetter}" scope="page"/>
	</c:if>

	<c:if test="${tempLetter == 'Ą'}">
    	<c:set var="varĄ" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'B'}">
    	<c:set var="varB" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'C'}">
    	<c:set var="varC" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'Ć'}">
    	<c:set var="varĆ" value="${tempLetter}" scope="page" />
	</c:if>


	<c:if test="${tempLetter == 'D'}">
    	<c:set var="varD" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'E'}">
    	<c:set var="varE" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'Ę'}">
    	<c:set var="varĘ" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'F'}">
    	<c:set var="varF" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'G'}">
    	<c:set var="varG" value="${tempLetter}" scope="page" />
	</c:if>	



	<c:if test="${tempLetter == 'H'}">
    	<c:set var="varH" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'I'}">
    	<c:set var="varI" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'J'}">
    	<c:set var="varJ" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'K'}">
    	<c:set var="varK" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'L'}">
    	<c:set var="varL" value="${tempLetter}" scope="page" />
	</c:if>



	<c:if test="${tempLetter == 'Ł'}">
    	<c:set var="varŁ" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'M'}">
    	<c:set var="varM" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'N'}">
    	<c:set var="varN" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'Ń'}">
    	<c:set var="varŃ" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'O'}">
    	<c:set var="varO" value="${tempLetter}" scope="page" />
	</c:if>



	<c:if test="${tempLetter == 'Ó'}">
    	<c:set var="varÓ" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'P'}">
    	<c:set var="varP" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'R'}">
    	<c:set var="varR" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'S'}">
    	<c:set var="varS" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'Ś'}">
    	<c:set var="varŚ" value="${tempLetter}" scope="page" />
	</c:if>



	<c:if test="${tempLetter == 'T'}">
    	<c:set var="varT" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'U'}">
    	<c:set var="varU" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'W'}">
    	<c:set var="varW" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'Y'}">
    	<c:set var="varY" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'Z'}">
    	<c:set var="varZ" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'Ź'}">
    	<c:set var="varŹ" value="${tempLetter}" scope="page" />
	</c:if>

	<c:if test="${tempLetter == 'Ż'}">
    	<c:set var="varŻ" value="${tempLetter}" scope="page" />
	</c:if>

</c:forEach>

<c:choose>
	<c:when test="${sessionScope.IS_CHARADE_COMPLETE}">

		<section id="congrats">
			<div class="container">
				<h1>Gratulacje!</h1>
				<h2>Twój wynik: </h2>
				<c:out value="${sessionScope.PLAYERS_POINTS}"/>
					<form action="CharadesControllerServlet" method="POST">
						<input type="hidden" name="command" value="STILLPLAYING">
						<input type="submit" value="graj dalej" >
					</form>
					<h2>lub</h2>
					<form action="CharadesControllerServlet" method="POST">
						<input type="hidden" name="command" value="SCORESAVE">
						<input type="text" placeholder="Wpisz swój nick i ..." name="save">
						<br>
						<input type="submit" value="zapisz wynik" >
					</form>
			</div>
		</section>

	</c:when>


	<c:otherwise>

		<section id="letters">
			<div class="container">
			    
				  	<h2>Wybierz literę:</h2>
					
					<form  action="CharadesControllerServlet" method="GET" id="a">   
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="A" >
					</form>
					<button class="${pageScope.varA == 'A'? 'clicked':'to-click'}" type="submit" form="a">A</button>

					<form  action="CharadesControllerServlet" method="GET" id="ą">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Ą">			
					</form>
					<button class="${pageScope.varĄ == 'Ą'? 'clicked':'to-click'}" type="submit" form="ą">Ą</button>

					<form  action="CharadesControllerServlet" method="GET" id="b">   
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="B">
					</form>
					<button class="${pageScope.varB == 'B'? 'clicked':'to-click'}" type="submit" form="b">B</button>

					<form  action="CharadesControllerServlet" method="GET" id="c">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="C">			
					</form>
					<button class="${pageScope.varC == 'C'? 'clicked':'to-click'}" type="submit" form="c">C</button>
					
					<form  action="CharadesControllerServlet" method="GET" id="ć">   
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Ć">
					</form>
					<button class="${pageScope.varĆ == 'Ć'? 'clicked':'to-click'}" type="submit" form="ć">Ć</button>

					<form  action="CharadesControllerServlet" method="GET" id="d">
					<input type="hidden" name="command" value="CHECKLETTER">	
					<input type="hidden" name="letter" value="D">			
					</form>
					<button class="${pageScope.varD == 'D'? 'clicked':'to-click'}" type="submit" form="d">D</button>

					<form  action="CharadesControllerServlet" method="GET" id="e">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="E">			
					</form>
					<button class="${pageScope.varE == 'E'? 'clicked':'to-click'}" type="submit" form="e">E</button>

					<form  action="CharadesControllerServlet" method="GET" id="ę">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Ę">			
					</form>
					<button class="${pageScope.varĘ == 'Ę'? 'clicked':'to-click'}" type="submit" form="ę">Ę</button>

					<form  action="CharadesControllerServlet" method="GET" id="f">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="F">			
					</form>
					<button class="${pageScope.varF == 'F'? 'clicked':'to-click'}" type="submit" form="f">F</button>

					<form  action="CharadesControllerServlet" method="GET" id="g">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="G">			
					</form>
					<button class="${pageScope.varG == 'G'? 'clicked':'to-click'}" type="submit" form="g">G</button>

					<form  action="CharadesControllerServlet" method="GET" id="h">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="H">			
					</form>
					<button class="${pageScope.varH == 'H'? 'clicked':'to-click'}" type="submit" form="h">H</button>

					<form  action="CharadesControllerServlet" method="GET" id="i">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="I">			
					</form>
					<button class="${pageScope.varI == 'I'? 'clicked':'to-click'}" type="submit" form="i">I</button>

					<form  action="CharadesControllerServlet" method="GET" id="j">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="J">			
					</form>
					<button class="${pageScope.varJ == 'J'? 'clicked':'to-click'}" type="submit" form="j">J</button>

					<form  action="CharadesControllerServlet" method="GET" id="k">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="K">			
					</form>
					<button class="${pageScope.varK == 'K'? 'clicked':'to-click'}" type="submit" form="k">K</button>

					<form  action="CharadesControllerServlet" method="GET" id="l">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="L">			
					</form>
					<button class="${pageScope.varL == 'L'? 'clicked':'to-click'}" type="submit" form="l">L</button>	

					<form  action="CharadesControllerServlet" method="GET" id="ł">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Ł">			
					</form>
					<button class="${pageScope.varŁ == 'Ł'? 'clicked':'to-click'}" type="submit" form="ł">Ł</button>	

					<form  action="CharadesControllerServlet" method="GET" id="m">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="M">			
					</form>
					<button class="${pageScope.varM == 'M'? 'clicked':'to-click'}" type="submit" form="m">M</button>

					<form  action="CharadesControllerServlet" method="GET" id="n">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="N">			
					</form>
					<button class="${pageScope.varN == 'N'? 'clicked':'to-click'}" type="submit" form="n">N</button>

					<form  action="CharadesControllerServlet" method="GET" id="ń">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Ń">			
					</form>
					<button class="${pageScope.varŃ == 'Ń'? 'clicked':'to-click'}" type="submit" form="ń">Ń</button>	

					<form  action="CharadesControllerServlet" method="GET" id="o">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="O">			
					</form>
					<button class="${pageScope.varO == 'O'? 'clicked':'to-click'}" type="submit" form="o">O</button>	

					<form  action="CharadesControllerServlet" method="GET" id="ó">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Ó">			
					</form>
					<button class="${pageScope.varÓ == 'Ó'? 'clicked':'to-click'}" type="submit" form="ó">Ó</button>

					<form  action="CharadesControllerServlet" method="GET" id="p">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="P">			
					</form>
					<button class="${pageScope.varP == 'P'? 'clicked':'to-click'}" type="submit" form="p">P</button>		

					<form  action="CharadesControllerServlet" method="GET" id="r">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="R">			
					</form>
					<button class="${pageScope.varR == 'R'? 'clicked':'to-click'}" type="submit" form="r">R</button>

					<form  action="CharadesControllerServlet" method="GET" id="s">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="S">			
					</form>
					<button class="${pageScope.varS == 'S'? 'clicked':'to-click'}" type="submit" form="s">S</button>

					<form  action="CharadesControllerServlet" method="GET" id="ś">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Ś">			
					</form>
					<button class="${pageScope.varŚ == 'Ś'? 'clicked':'to-click'}" type="submit" form="ś">Ś</button>

					<form  action="CharadesControllerServlet" method="GET" id="t">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="T">			
					</form>
					<button class="${pageScope.varT == 'T'? 'clicked':'to-click'}" type="submit" form="t">T</button>

					<form  action="CharadesControllerServlet" method="GET" id="u">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="U">			
					</form>
					<button class="${pageScope.varU == 'U'? 'clicked':'to-click'}" type="submit" form="u">U</button>

					<form  action="CharadesControllerServlet" method="GET" id="w">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="W">			
					</form>
					<button class="${pageScope.varW == 'W'? 'clicked':'to-click'}" type="submit" form="w">W</button>

					<form  action="CharadesControllerServlet" method="GET" id="y">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Y">			
					</form>
					<button class="${pageScope.varY == 'Y'? 'clicked':'to-click'}" type="submit" form="y">Y</button>

					<form  action="CharadesControllerServlet" method="GET" id="z">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Z">			
					</form>
					<button class="${pageScope.varZ == 'Z'? 'clicked':'to-click'}" type="submit" form="z">Z</button>

					<form  action="CharadesControllerServlet" method="GET" id="ź">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Ź">			
					</form>
					<button class="${pageScope.varŹ == 'Ź'? 'clicked':'to-click'}" type="submit" form="ź">Ź</button>

					<form  action="CharadesControllerServlet" method="GET" id="ż">
					<input type="hidden" name="command" value="CHECKLETTER">
					<input type="hidden" name="letter" value="Ż">			
					</form>
					<button class="${pageScope.varŻ == 'Ż'? 'clicked':'to-click'}" type="submit" form="ż">Ż</button>		

			</div>
		</section>
		
		
		<section id="guess">
			<div class="container">
				<h2>Odgadnij przysłowie:</h2>
					<form action="CharadesControllerServlet" method="POST">
						<input type="hidden" name="command" value="GUESSPROVERB">
						<input type="text" placeholder="Wpisz przysłowie. Pamiętaj o znakach przestankowych!" name="guess">
						<br>
						<input type="submit" value="odgadnij przysłowie" >
					</form>
			</div>
		</section>

	</c:otherwise>
</c:choose>






<footer>
	<div class="container">
		<p>Piotr Szewczul</p>
	</div>	
</footer>


</body>
</html>