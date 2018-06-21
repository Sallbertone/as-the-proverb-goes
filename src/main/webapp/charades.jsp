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

<c:set var="zmienna" value="test1"   />   <!---figuring out how to set a variable to change form class later on-->


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
			<h1>15</h1>
			<c:out value="${POINTS_TO_WIN}"/>
		</div>
	</div>
</section>

<section id="hidden">
	<div class="container">
		<h3>
			<c:out value="${CHARADE_HIDDEN}"/>
		</h3>
	</div>
</section>

<section id="letters">
	<div class="container">
		<h2>Wybierz literę:</h2>
		
<!---   class="${zmienna == 'test2'? 'green':'grey'}"   changing button class-->

		<form  action="CharadesControllerServlet" method="GET" id="a">   
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="A">
		</form>
		<button class="to-click" type="submit" form="a" value="A">A</button>

		<form  action="CharadesControllerServlet" method="GET" id="ą">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Ą">			
		</form>
		<button class="to-click" type="submit" form="ą" value="Ą">Ą</button>

		<form  action="CharadesControllerServlet" method="GET" id="b">   
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="B">
		</form>
		<button class="to-click" type="submit" form="b" value="B">B</button>

		<form  action="CharadesControllerServlet" method="GET" id="c">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="C">			
		</form>
		<button class="to-click" type="submit" form="c" value="C">C</button>
		
		<form  action="CharadesControllerServlet" method="GET" id="ć">   
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Ć">
		</form>
		<button class="to-click" type="submit" form="ć" value="Ć">Ć</button>

		<form  action="CharadesControllerServlet" method="GET" id="d">
		<input type="hidden" name="command" value="CHECKLETTER">	
		<input type="hidden" name="letter" value="D">			
		</form>
		<button class="clicked" type="submit" form="d" value="D">D</button>

		<form  action="CharadesControllerServlet" method="GET" id="e">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="E">			
		</form>
		<button class="clicked" type="submit" form="e" value="E">E</button>

		<form  action="CharadesControllerServlet" method="GET" id="ę">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Ę">			
		</form>
		<button class="to-click" type="submit" form="ę" value="Ę">Ę</button>

		<form  action="CharadesControllerServlet" method="GET" id="f">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="F">			
		</form>
		<button class="to-click" type="submit" form="f" value="F">F</button>

		<form  action="CharadesControllerServlet" method="GET" id="g">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="G">			
		</form>
		<button class="to-click" type="submit" form="g" value="G">G</button>

		<form  action="CharadesControllerServlet" method="GET" id="h">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="H">			
		</form>
		<button class="to-click" type="submit" form="h" value="H">H</button>

		<form  action="CharadesControllerServlet" method="GET" id="i">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="I">			
		</form>
		<button class="to-click" type="submit" form="i" value="I">I</button>

		<form  action="CharadesControllerServlet" method="GET" id="j">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="J">			
		</form>
		<button class="to-click" type="submit" form="j" value="J">J</button>

		<form  action="CharadesControllerServlet" method="GET" id="k">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="K">			
		</form>
		<button class="to-click" type="submit" form="k" value="K">K</button>

		<form  action="CharadesControllerServlet" method="GET" id="l">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="L">			
		</form>
		<button class="to-click" type="submit" form="l" value="L">L</button>	

		<form  action="CharadesControllerServlet" method="GET" id="ł">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Ł">			
		</form>
		<button class="to-click" type="submit" form="ł" value="Ł">Ł</button>	

		<form  action="CharadesControllerServlet" method="GET" id="m">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="M">			
		</form>
		<button class="to-click" type="submit" form="m" value="M">M</button>

		<form  action="CharadesControllerServlet" method="GET" id="n">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="N">			
		</form>
		<button class="to-click" type="submit" form="n" value="N">N</button>

		<form  action="CharadesControllerServlet" method="GET" id="ń">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Ń">			
		</form>
		<button class="to-click" type="submit" form="ń" value="Ń">Ń</button>	

		<form  action="CharadesControllerServlet" method="GET" id="o">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="O">			
		</form>
		<button class="to-click" type="submit" form="o" value="O">O</button>	

		<form  action="CharadesControllerServlet" method="GET" id="p">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="P">			
		</form>
		<button class="to-click" type="submit" form="p" value="P">P</button>		

		<form  action="CharadesControllerServlet" method="GET" id="r">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="R">			
		</form>
		<button class="to-click" type="submit" form="r" value="R">R</button>

		<form  action="CharadesControllerServlet" method="GET" id="s">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="S">			
		</form>
		<button class="to-click" type="submit" form="s" value="S">S</button>

		<form  action="CharadesControllerServlet" method="GET" id="ś">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Ś">			
		</form>
		<button class="to-click" type="submit" form="ś" value="Ś">Ś</button>

		<form  action="CharadesControllerServlet" method="GET" id="t">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="T">			
		</form>
		<button class="to-click" type="submit" form="t" value="T">T</button>

		<form  action="CharadesControllerServlet" method="GET" id="u">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="U">			
		</form>
		<button class="to-click" type="submit" form="u" value="U">U</button>

		<form  action="CharadesControllerServlet" method="GET" id="w">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="W">			
		</form>
		<button class="to-click" type="submit" form="w" value="W">W</button>

		<form  action="CharadesControllerServlet" method="GET" id="y">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Y">			
		</form>
		<button class="to-click" type="submit" form="y" value="Y">Y</button>

		<form  action="CharadesControllerServlet" method="GET" id="z">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Z">			
		</form>
		<button class="to-click" type="submit" form="z" value="Z">Z</button>

		<form  action="CharadesControllerServlet" method="GET" id="ź">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Ź">			
		</form>
		<button class="to-click" type="submit" form="ź" value="Ź">Ź</button>

		<form  action="CharadesControllerServlet" method="GET" id="ż">
		<input type="hidden" name="command" value="CHECKLETTER">
		<input type="hidden" name="letter" value="Ż">			
		</form>
		<button class="to-click" type="submit" form="ż" value="Ż">Ż</button>		

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

<footer>
	<div class="container">
		<p>Piotr Szewczul</p>
	</div>	
</footer>


</body>
</html>