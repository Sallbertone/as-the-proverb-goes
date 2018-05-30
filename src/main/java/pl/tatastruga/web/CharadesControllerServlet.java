package pl.tatastruga.web;

import java.io.IOException;
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

	ProverbDAO proverbDAO = new ProverbDAO();
	List<Integer> idList = new LinkedList<Integer>();
	Proverb proverb;

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
				getProverbById(chooseCharadeId(idList));
				setCharade(proverb, request, response);   //	hideProverb(proverb);
			
				break;

			case "NEXTCHARADE":
				getProverbById(chooseCharadeId(idList));
				break;

			}

		} catch (Exception e)
		{
			throw new ServletException(e);
		}
	}

	private void setCharade(Proverb proverb, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String meaning = proverb.getMeaning();

		request.setAttribute("CHARADE_MEANING", meaning);
		
		String hiddenProverbText = hideProverb(proverb);

		request.setAttribute("CHARADE_HIDDEN", hiddenProverbText);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

		dispatcher.forward(request, response);
		
	}

	private String hideProverb(Proverb proverb)
	{
		String hiddenProverbText;
		
		char[] proverbChars = proverb.getProverb().toCharArray();

		char[] hiddenProverbChars = new char[proverbChars.length];


		for (int i = 0; i < proverbChars.length; i++)
		{
			if (proverbChars[i] == ',' || proverbChars[i] == ' ' || proverbChars[i] == '-' || proverbChars[i] == '?'
					|| proverbChars[i] == '!' || proverbChars[i] == '.' || proverbChars[i] == ':'
					|| proverbChars[i] == ';')
			{
				hiddenProverbChars[i] = proverbChars[i];
			} 
			else
			{
				hiddenProverbChars[i] = '.';
			}
		}
		
		hiddenProverbText = new String(hiddenProverbChars);
		
		return hiddenProverbText;
	}

	
	private void getProverbById(int choosenId)
	{
		proverb = proverbDAO.getProverb(choosenId);
	}

	private int chooseCharadeId(List<Integer> list) //choosing id and removing it from the list for no duplicates
	{
		Random random = new Random();
		int index = random.nextInt(list.size());
		int choosenId = list.get(index);
		idList.remove(index);
		System.out.println("choosen - " + choosenId);
		return choosenId;
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
