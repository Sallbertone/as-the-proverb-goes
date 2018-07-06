package pl.tatastruga.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/CharadesControllerServlet")
public class CharadesControllerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private ProverbDAO proverbDAO = new ProverbDAO();
	private RandomListIndexChooser randomListIndexChooser = new RandomListIndexChooser();
	private ProverbIdChooser proverbIdChooser = new ProverbIdChooser();
	private IdRemover idRemover = new IdRemover();
	private Proverb proverb;
	private ProverbHider proverbHider = new ProverbHider();
	private LetterChecker letterChecker = new LetterChecker();
	private LetterRevealer letterRevealer = new LetterRevealer();
	private ProverbGuessedChecker proverbGuessedChecker = new ProverbGuessedChecker();

	
	
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		HttpSession session = request.getSession();
		
		try
		{
			String theCommand = request.getParameter("command");

			if (theCommand == null)
				theCommand = "GETIDLISTANDFIRSTCHARADE";

			switch (theCommand)
			{
			case "GETIDLISTANDFIRSTCHARADE":
				session.setAttribute("isCharadeComplete", false);
				getIdList(session);
				getRandomListIndex(session);
				chooseProverbId(session);
				getProverbById(session);
				removeIdFromTheList(session);
				hideProverb(session);
				setCharade(request, response, session);
				break;

			case "CHECKLETTER":
				pickALetter(request, session);
				checkALetter(session);
				addPickedLetterToAllUsedLetters(session);

				if((boolean)session.getAttribute("isLetterValid") == true)
				{
					revealPickedLetterInHiddenProverb(session);
					checkIfCharadeIsComplete(session);
					setCharadeWithAllUsedLetters(request, response, session);
				}
				else
				{
					addPickedLetterToMissedLetterShots(session);  
					setCharadeWithAllUsedLetters(request, response, session);
					// to do - changing hangman pics
					// to do - changing remainig points
				}

				break;

			case "NEXTCHARADE":
				//		getProverbById(chooseCharadeId(idList));
						break;
				
			}

		} catch (Exception e)
		{
			throw new ServletException(e);
		}
	}


	private void checkIfCharadeIsComplete(HttpSession session)
	{
		String hiddenProverb = (String) session.getAttribute("hiddenProverb");
		String proverbText = (String) session.getAttribute("proverbText");
		
		boolean isCharadeComplete = proverbGuessedChecker.checkIfProverbIsGuessed(hiddenProverb, proverbText);
		session.setAttribute("isCharadeComplete", isCharadeComplete);   

	}


	private void setCharadeWithAllUsedLetters(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
	{
		ArrayList<String> allUsedLetters = (ArrayList<String>) session.getAttribute("allUsedLetters");
		System.out.println("id = " + session.getId() + " and allUsedLetters in setCharadeWithAllUsedLetter: " + Arrays.toString(allUsedLetters.toArray()));
		String  hiddenProverb = (String) session.getAttribute("hiddenProverb");
		String proverbMeaning = (String) session.getAttribute("proverbMeaning");
		boolean isCharadeComplete = (boolean) session.getAttribute("isCharadeComplete");
		
		session.setAttribute("CHARADE_MEANING", proverbMeaning);
		session.setAttribute("CHARADE_HIDDEN", hiddenProverb);
		session.setAttribute("ALL_USED_LETTERS", allUsedLetters);
		session.setAttribute("IS_CHARADE_COMPLETE", isCharadeComplete);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/charades.jsp");
		dispatcher.forward(request, response);
	}


	private void revealPickedLetterInHiddenProverb(HttpSession session)
	{
		String pickedLetter = (String) session.getAttribute("pickedLetter");
		String hiddenProverb = (String) session.getAttribute("hiddenProverb");
		String proverbText = (String) session.getAttribute("proverbText");
		
		hiddenProverb = letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb, proverbText);
		session.setAttribute("hiddenProverb", hiddenProverb);
	}

	private void addPickedLetterToMissedLetterShots(HttpSession session)
	{
		String pickedLetter = (String) session.getAttribute("pickedLetter");
		
		Object sessionListTest = session.getAttribute("missedLetterShots");
		
		ArrayList<String> missedLetterShots;
		
		if(sessionListTest == null) 
		{
			missedLetterShots = new ArrayList<String>();
			missedLetterShots.add(pickedLetter);
		}
		else
		{
			missedLetterShots = (ArrayList<String>) session.getAttribute("missedLetterShots");
			missedLetterShots.add(pickedLetter);
		}
		
		session.setAttribute("missedLetterShots", missedLetterShots);
	}

	private void addPickedLetterToAllUsedLetters(HttpSession session)
	{
		
		String pickedLetter = (String) session.getAttribute("pickedLetter");
		
		Object sessionListTest = session.getAttribute("allUsedLetters");
		
		ArrayList<String> allUsedLetters;
		
		if(sessionListTest == null) 
		{
			System.out.println("sessionListTest NULL");
			allUsedLetters = new ArrayList<String>();
			
			allUsedLetters.add(pickedLetter);
			System.out.println("id = " + session.getId() + " and allUsedLetters in addPickedLetterToAllUsedLetters after add(pickedLetter) in NULL: " + Arrays.toString(allUsedLetters.toArray()));		
		}
		else
		{
			System.out.println("sessionListTest NOT NULL");
			allUsedLetters = (ArrayList<String>) session.getAttribute("allUsedLetters");
			System.out.println("id = " + session.getId() + " and allUsedLetters in addPickedLetterToAllUsedLetters: " + Arrays.toString(allUsedLetters.toArray()));			
			allUsedLetters.add(pickedLetter);
			System.out.println("id = " + session.getId() + " and allUsedLetters in addPickedLetterToAllUsedLetters after add(pickedLetter): " + Arrays.toString(allUsedLetters.toArray()));		
		}
		
		session.setAttribute("allUsedLetters", allUsedLetters);
	
	}

	private void checkALetter(HttpSession session)
	{
		String pickedLetter = (String) session.getAttribute("pickedLetter");
		String proverbText = (String) session.getAttribute("proverbText");
		
		boolean isLetterValid = letterChecker.isLetterPresent(pickedLetter, proverbText);
		session.setAttribute("isLetterValid", isLetterValid);
	}

	private void pickALetter(HttpServletRequest request, HttpSession session)
	{
		String pickedLetter = request.getParameter("letter");
		session.setAttribute("pickedLetter", pickedLetter);
	}

	private void setCharade(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
	{
		String proverbMeaning = (String) session.getAttribute("proverbMeaning");
		String hiddenProverb = (String) session.getAttribute("hiddenProverb");
		
		session.setAttribute("CHARADE_MEANING", proverbMeaning);
		session.setAttribute("CHARADE_HIDDEN", hiddenProverb);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/charades.jsp");
		dispatcher.forward(request, response);
	}

	private void hideProverb(HttpSession session)
	{
		String proverbText = (String) session.getAttribute("proverbText");
		
		String hiddenProverb = proverbHider.hideProverbText(proverbText);
		session.setAttribute("hiddenProverb", hiddenProverb);
	}

	private void getProverbById(HttpSession session)
	{
		int proverbId = (int) session.getAttribute("proverbId");
		
		Proverb proverb = proverbDAO.getProverb(proverbId);
		session.setAttribute("proverb", proverb);
		
		String proverbText = proverb.getProverb();
		session.setAttribute("proverbText", proverbText);		
		
		String proverbMeaning = proverb.getMeaning();
		session.setAttribute("proverbMeaning", proverbMeaning);
	}
	
	private void removeIdFromTheList(HttpSession session) // for no duplicates
	{
		int index = (int) session.getAttribute("index");
		List<Integer> idList = (List<Integer>) session.getAttribute("idList");
		int proverbId = (int) session.getAttribute("proverbId");
		
		idList = idRemover.removeId(index, idList, proverbId);
		session.setAttribute("idList", idList);
	}

	private void chooseProverbId(HttpSession session) 
	{
		int index = (int) session.getAttribute("index");
		List<Integer> idList = (List<Integer>) session.getAttribute("idList");
		
		int proverbId = proverbIdChooser.chooseCharadeId(idList, index);
		session.setAttribute("proverbId", proverbId);
	}
	
	private void getRandomListIndex(HttpSession session)
	{
		List<Integer> sessionIdList = (List<Integer>) session.getAttribute("idList");
		int listSize = sessionIdList.size();
		int index = randomListIndexChooser.chooseRandomIndex(listSize);
		session.setAttribute("index", index);
	}

	private void getIdList(HttpSession session) 
	{
		List<Integer> idList = proverbDAO.getIdList();
		session.setAttribute("idList", idList);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		doGet(request, response);
	}

}
