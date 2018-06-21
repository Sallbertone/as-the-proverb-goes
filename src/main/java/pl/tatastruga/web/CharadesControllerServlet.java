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
	
	
	static private int index;
	static private int proverbId;
	static private String proverbText;
	static private String proverbMeaning;
	static private String hiddenProverb;
	static private String pickedLetter;
	static private boolean isLetterValid;
	static private List<Character> allUsedLetters = new ArrayList<Character>();
	static private List<Character> missedLetterShots = new ArrayList<Character>();







	


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
			
				break;

			case "CHECKLETTER":
				pickALetter(request);
				checkALetter(pickedLetter, proverbText);
				addPickedLetterToAllUsedLetters(pickedLetter);
		//		forwardAllUsedLettersToView(allUsedLetters, request, response);  
				if(isLetterValid)
				{
					revealPickedLetterInHiddenProverb(pickedLetter, hiddenProverb, proverbText);
					setCharadeWithAllUsedLetters(allUsedLetters, hiddenProverb, proverbMeaning, request, response);
					
					System.out.println("all used letters: " + Arrays.toString(allUsedLetters.toArray()));
				}
				else
				{
					addPickedLetterToMissedLetterShots(pickedLetter);
					System.out.println("missed Letter Shots: " + Arrays.toString(missedLetterShots.toArray()));
					
					setCharadeWithAllUsedLetters(allUsedLetters, hiddenProverb, proverbMeaning, request, response);
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






	private void setCharadeWithAllUsedLetters(List<Character> allUsedLetters, String hiddenProverb,	String proverbMeaning, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("CHARADE_MEANING", proverbMeaning);
		request.setAttribute("CHARADE_HIDDEN", hiddenProverb);
		request.setAttribute("ALL_USED_LETTERS", allUsedLetters);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/charades.jsp");
		dispatcher.forward(request, response);
		
	}






	private void revealPickedLetterInHiddenProverb(String pickedLetter, String hiddenProverb, String proverbText)
	{
		this.hiddenProverb = letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb, proverbText);
	}

	private void addPickedLetterToMissedLetterShots(String pickedLetter)
	{
		missedLetterShots.add(pickedLetter.charAt(0));
	}

	private void addPickedLetterToAllUsedLetters(String pickedLetter)
	{
		allUsedLetters.add(pickedLetter.charAt(0));
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

	private void getIdList() //extracting all id from DB
	{
		idList = proverbDAO.getIdList();
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		doGet(request, response);
	}

}
