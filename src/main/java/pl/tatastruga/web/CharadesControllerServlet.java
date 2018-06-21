package pl.tatastruga.web;

import java.io.IOException;
import java.util.ArrayList;
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
	
	private List<Integer> idList = new LinkedList<Integer>();

	private RandomListIndexChooser randomListIndexChooser = new RandomListIndexChooser();
	private ProverbIdChooser proverbIdChooser = new ProverbIdChooser();
	private IdRemover idRemover = new IdRemover();
	private Proverb proverb;
	private ProverbHider proverbHider = new ProverbHider();
	private LetterChecker letterChecker;
	private LetterRevealer letterRevealer;
	
	
	private int index;
	private int proverbId;
	private String proverbText;
	private String proverbMeaning;
	private String hiddenProverb;
	private String pickedLetter;
	boolean isLetterValid;
	private List<Character> allUsedLetters = new ArrayList<Character>();
	private List<Character> missedLetterShots = new ArrayList<Character>();







	


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
				if(isLetterValid)
				{
					revealPickedLetterInHiddenProverb(pickedLetter, hiddenProverb);
				}
				else
				{
					addPickedLetterToMissedLetterShots(pickedLetter);
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






	private void revealPickedLetterInHiddenProverb(String pickedLetter, String hiddenProverb)
	{
		this.hiddenProverb = letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb);
		
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
