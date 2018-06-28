package pl.tatastruga.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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

		try
		{
			String theCommand = request.getParameter("command");

			if (theCommand == null)
				theCommand = "GETIDLISTANDFIRSTCHARADE";

			switch (theCommand)
			{
			case "GETIDLISTANDFIRSTCHARADE":
				getIdList();
				getRandomListIndex(idList.size());
				chooseProverbId(idList, index);
				getProverbById(proverbId);
				removeIdFromTheList(index, idList, proverbId);
				hideProverb(proverbText);
				setCharade(hiddenProverb, proverbMeaning, request, response);   
				clearListsOfMissedAndUsedLetters(allUsedLetters, missedLetterShots);
			
				break;

			case "CHECKLETTER":
				pickALetter(request);
				checkALetter(pickedLetter, proverbText);
				addPickedLetterToAllUsedLetters(pickedLetter);

				if(isLetterValid)
				{
					revealPickedLetterInHiddenProverb(pickedLetter, hiddenProverb, proverbText);
					checkIfCharadeIsComplete(hiddenProverb, proverbText);
					setCharadeWithAllUsedLetters(allUsedLetters, hiddenProverb, proverbMeaning, isCharadeComplete, request, response);
				}
				else
				{
					addPickedLetterToMissedLetterShots(pickedLetter);
					setCharadeWithAllUsedLetters(allUsedLetters, hiddenProverb, proverbMeaning, isCharadeComplete, request, response);
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






	private void checkIfCharadeIsComplete(String hiddenProverb, String proverbText)
	{
		isCharadeComplete = proverbGuessedChecker.checkIfProverbIsGuessed(hiddenProverb, proverbText);
	}






	private void clearListsOfMissedAndUsedLetters(List<String> allUsedLetters, List<String> missedLetterShots)
	{
		allUsedLetters.clear();
		this.allUsedLetters = allUsedLetters;
		
		missedLetterShots.clear();
		this.missedLetterShots = missedLetterShots;
	}






	private void setCharadeWithAllUsedLetters(List<String> allUsedLetters, String hiddenProverb,	String proverbMeaning, boolean isCharadeComplete, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("CHARADE_MEANING", proverbMeaning);
		request.setAttribute("CHARADE_HIDDEN", hiddenProverb);
		request.setAttribute("ALL_USED_LETTERS", allUsedLetters);
		request.setAttribute("IS_CHARADE_COMPLETE", isCharadeComplete);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/charades.jsp");
		dispatcher.forward(request, response);
		
	}






	private void revealPickedLetterInHiddenProverb(String pickedLetter, String hiddenProverb, String proverbText)
	{
		this.hiddenProverb = letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb, proverbText);
	}

	private void addPickedLetterToMissedLetterShots(String pickedLetter)
	{
		missedLetterShots.add(pickedLetter);
	}

	private void addPickedLetterToAllUsedLetters(String pickedLetter)
	{
		allUsedLetters.add(pickedLetter);
	}

	private void checkALetter(String pickedLetter, String proverbText)
	{
		isLetterValid = letterChecker.isLetterPresent(pickedLetter, proverbText);
	}

	private void pickALetter(HttpServletRequest request)
	{
		pickedLetter = request.getParameter("letter");
	}

	private void setCharade(String hiddenProverb, String proverbMeaning, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("CHARADE_MEANING", proverbMeaning);
		request.setAttribute("CHARADE_HIDDEN", hiddenProverb);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/charades.jsp");
		dispatcher.forward(request, response);
	}

	private void hideProverb(String proverbText)
	{
		hiddenProverb = proverbHider.hideProverbText(proverbText);
	}

	private void getProverbById(int charadeId)
	{
		proverb = proverbDAO.getProverb(charadeId);
		proverbText = proverb.getProverb();
		proverbMeaning = proverb.getMeaning();
	}
	
	private void removeIdFromTheList(int index, List<Integer> list, int proverbId) // for no duplicates
	{
		idList = idRemover.removeId(index, list, proverbId);
	}

	private void chooseProverbId(List<Integer> list, int index) 
	{
		proverbId = proverbIdChooser.chooseCharadeId(list, index);
	}
	
	private void getRandomListIndex(int listSize)
	{
		index = randomListIndexChooser.chooseRandomIndex(listSize);
	}

	private void getIdList() 
	{
		idList = proverbDAO.getIdList();
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		doGet(request, response);
	}

}
