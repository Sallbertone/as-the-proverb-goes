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
	
	static private List<Integer> idList = new LinkedList<Integer>();

	private RandomListIndexChooser randomListIndexChooser = new RandomListIndexChooser();
	private ProverbIdChooser proverbIdChooser = new ProverbIdChooser();
	private IdRemover idRemover = new IdRemover();
	private Proverb proverb;
	private ProverbHider proverbHider = new ProverbHider();
	private LetterChecker letterChecker = new LetterChecker();
	private LetterRevealer letterRevealer = new LetterRevealer();
	private ProverbGuessedChecker proverbGuessedChecker = new ProverbGuessedChecker();

	
	
	
	static private int index;
	static private int proverbId;
	static private String proverbText;
	static private String proverbMeaning;
	static private String hiddenProverb;
	static private String pickedLetter;
	static private boolean isLetterValid;
	static private List<String> allUsedLetters = new ArrayList<String>();
	static private List<String> missedLetterShots = new ArrayList<String>();
	static private boolean isCharadeComplete;






	


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
				getIdList(session);
				getRandomListIndex(idList.size(), session);
				chooseProverbId(idList, index, session);
				getProverbById(proverbId, session);
				removeIdFromTheList(index, idList, proverbId, session);
				hideProverb(proverbText, session);
				setCharade(hiddenProverb, proverbMeaning, request, response, session);   
				clearListsOfMissedAndUsedLetters(allUsedLetters, missedLetterShots, session);
			
				break;

			case "CHECKLETTER":
				pickALetter(request, session);
				checkALetter(pickedLetter, proverbText, session);
				addPickedLetterToAllUsedLetters(pickedLetter, session);

				if(isLetterValid)
				{
					revealPickedLetterInHiddenProverb(pickedLetter, hiddenProverb, proverbText, session);
					checkIfCharadeIsComplete(hiddenProverb, proverbText, session);
					setCharadeWithAllUsedLetters(allUsedLetters, hiddenProverb, proverbMeaning, isCharadeComplete, request, response, session);
				}
				else
				{
					addPickedLetterToMissedLetterShots(pickedLetter, session);
					setCharadeWithAllUsedLetters(allUsedLetters, hiddenProverb, proverbMeaning, isCharadeComplete, request, response, session);
					// to do - changin hangman pics
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






	private void checkIfCharadeIsComplete(String hiddenProverb, String proverbText, HttpSession session)
	{
		isCharadeComplete = proverbGuessedChecker.checkIfProverbIsGuessed(hiddenProverb, proverbText);
		session.setAttribute("isCharadeComplete", isCharadeComplete);
	}






	private void clearListsOfMissedAndUsedLetters(List<String> allUsedLetters, List<String> missedLetterShots, HttpSession session)
	{
		allUsedLetters.clear();
		this.allUsedLetters = allUsedLetters;
		session.setAttribute("allUsedLetters", this.allUsedLetters);
		
		missedLetterShots.clear();
		this.missedLetterShots = missedLetterShots;
		session.setAttribute("missedLetterShots", this.missedLetterShots);
	}






	private void setCharadeWithAllUsedLetters(List<String> allUsedLetters, String hiddenProverb,	String proverbMeaning, boolean isCharadeComplete, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
	{
		session.setAttribute("CHARADE_MEANING", proverbMeaning);
		session.setAttribute("CHARADE_HIDDEN", hiddenProverb);
		session.setAttribute("ALL_USED_LETTERS", allUsedLetters);
		session.setAttribute("IS_CHARADE_COMPLETE", isCharadeComplete);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/charades.jsp");
		dispatcher.forward(request, response);
		
	}






	private void revealPickedLetterInHiddenProverb(String pickedLetter, String hiddenProverb, String proverbText, HttpSession session)
	{
		this.hiddenProverb = letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb, proverbText);
		session.setAttribute("hiddenProverb", this.hiddenProverb);
	}

	private void addPickedLetterToMissedLetterShots(String pickedLetter, HttpSession session)
	{
		missedLetterShots.add(pickedLetter);
		session.setAttribute("missedLetterShots", missedLetterShots);
	}

	private void addPickedLetterToAllUsedLetters(String pickedLetter, HttpSession session)
	{
		allUsedLetters.add(pickedLetter);
		session.setAttribute("allUsedLetters", allUsedLetters);
	}

	private void checkALetter(String pickedLetter, String proverbText, HttpSession session)
	{
		isLetterValid = letterChecker.isLetterPresent(pickedLetter, proverbText);
		session.setAttribute("isLetterValid", isLetterValid);
	}

	private void pickALetter(HttpServletRequest request, HttpSession session)
	{
		pickedLetter = request.getParameter("letter");
		session.setAttribute("pickedLetter", pickedLetter);
	}

	private void setCharade(String hiddenProverb, String proverbMeaning, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
	{
		session.setAttribute("CHARADE_MEANING", proverbMeaning);
		session.setAttribute("CHARADE_HIDDEN", hiddenProverb);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/charades.jsp");
		dispatcher.forward(request, response);
	}

	private void hideProverb(String proverbText, HttpSession session)
	{
		hiddenProverb = proverbHider.hideProverbText(proverbText);
		session.setAttribute("hiddenProverb", hiddenProverb);
	}

	private void getProverbById(int charadeId, HttpSession session)
	{
		proverb = proverbDAO.getProverb(charadeId);
		session.setAttribute("proverb", proverb);
		proverbText = proverb.getProverb();
		session.setAttribute("proverbText", proverbText);		
		proverbMeaning = proverb.getMeaning();
		session.setAttribute("proverbMeaning", proverbMeaning);
	}
	
	private void removeIdFromTheList(int index, List<Integer> list, int proverbId, HttpSession session) // for no duplicates
	{
		idList = idRemover.removeId(index, list, proverbId);
		session.setAttribute("idList", idList);
	}

	private void chooseProverbId(List<Integer> list, int index, HttpSession session) 
	{
		proverbId = proverbIdChooser.chooseCharadeId(list, index);
		session.setAttribute("proverbId", proverbId);
	}
	
	private void getRandomListIndex(int listSize, HttpSession session)
	{
		index = randomListIndexChooser.chooseRandomIndex(listSize);
		session.setAttribute("index", index);
	}

	private void getIdList(HttpSession session) 
	{
		idList = proverbDAO.getIdList();
		session.setAttribute("idList", idList);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		doGet(request, response);
	}

}
