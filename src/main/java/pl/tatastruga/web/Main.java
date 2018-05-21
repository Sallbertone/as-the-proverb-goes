package pl.tatastruga.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main
{

	public static void main(String[] args)
	{

		ArrayList<String> proverbsList = new ArrayList<String>();
		ArrayList<String> meaningsList = new ArrayList<String>();

		Proverb proverb = null;

		Document doc = null;

		// connection to web page for scraping
		try
		{
			doc = Jsoup.connect("https://www.polskatradycja.pl/folklor/przyslowia.html").userAgent("Mozilla/5.0").get();
			System.out.println("connected");
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		// web scraping for proverbs and storing in list
		Elements webProverbs = doc.select("tr.row0");

		for (Element tempWebProverb : webProverbs)
		{
			proverbsList.add(tempWebProverb.getElementsByTag("a").first().text());
		}

		webProverbs = doc.select("tr.row1");

		for (Element tempWebProverb : webProverbs)
		{
			proverbsList.add(tempWebProverb.getElementsByTag("a").first().text());
		}

		// web scraping for meanings and storing in list
		Elements webMeanings = doc.select("tr.row0");

		for (Element tempWebMeanings : webMeanings)
		{
			meaningsList.add(tempWebMeanings.getElementsByTag("p").first().text());
		}

		webMeanings = doc.select("tr.row1");

		for (Element tempWebMeanings : webMeanings)
		{
			meaningsList.add(tempWebMeanings.getElementsByTag("p").first().text());
		}

		
		// create Hibernate session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Proverb.class)
									.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try
		{
			//saving proverbs and meanings in DB
			for (int i = 0; i < proverbsList.size(); i++)
			{
				// create a Proverb oject
				Proverb tempProverb = new Proverb(proverbsList.get(i), meaningsList.get(i));
				
				session.beginTransaction();
				session.save(tempProverb);
				session.getTransaction().commit();
				session.close();
				
				//restoring session
				session = factory.getCurrentSession();
			}

		} 
		finally
		{
			factory.close();
		}

		//testing DB connection and stored data
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String dbUrl = "jdbc:mysql://s43.linuxpl.com/creall_proverbs";
		String user = "creall_provUser";
		String pass = "tzfyJExk";

		try
		{
			myConn = DriverManager.getConnection(dbUrl, user, pass);

			System.out.println("Połączono z bazą");

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery("SELECT * FROM proverbs WHERE id=60");

			while (myRs.next())
			{
				proverb = new Proverb(myRs.getInt("id"), myRs.getString("proverb"), myRs.getString("meaning"));
			}

		} catch (SQLException ex)
		{
			ex.printStackTrace();
		}

		Scanner input = new Scanner(System.in);

		char[] proverbChars = proverb.getProverb().toCharArray();

		char[] hiddenProverbChars = new char[proverbChars.length];

		String missedShots = "";
		String missedShotsCounter = "";

		for (int i = 0; i < proverbChars.length; i++)
		{
			if (proverbChars[i] == ',' || proverbChars[i] == ' ' || proverbChars[i] == '-' || proverbChars[i] == '?'
					|| proverbChars[i] == '!' || proverbChars[i] == '.' || proverbChars[i] == ':'
					|| proverbChars[i] == ';')
			{
				hiddenProverbChars[i] = proverbChars[i];
			} else
			{
				hiddenProverbChars[i] = '.';
			}
		}

		System.out.println(proverb.getMeaning());
		System.out.println();
		System.out.println("Odgadnij przysłowie :)\n");
		System.out.println(hiddenProverbChars);
		System.out.println();

		boolean isComplete = false;

		while (!isComplete)
		{
			String userChar;
			boolean hit = false;

			do
			{
				System.out.println("Podaj jedną literę: \n");
				userChar = input.next();

			} while (userChar.length() != 1 || Character.isDigit(userChar.charAt(0)));

			for (int i = 0; i < proverbChars.length; i++)
			{
				if (Character.toLowerCase(proverbChars[i]) == Character.toLowerCase(userChar.charAt(0)))
				{
					hiddenProverbChars[i] = proverbChars[i];

					hit = true;
				}

			}

			if (hit == true)
			{
				System.out.println("Trafione!\n");
				System.out.println(missedShots);
				System.out.println(missedShotsCounter + " (" + missedShotsCounter.length() + "/10)");
				System.out.println();
			}

			else if (hit == false && missedShotsCounter.length() < 10)
			{
				missedShots = Character.toUpperCase(userChar.charAt(0)) + missedShots;
				missedShotsCounter += "X";
				System.out.println("Pudło!\n");
				System.out.println(missedShots);
				System.out.println(missedShotsCounter + " (" + missedShotsCounter.length() + "/10)");
				System.out.println();
			}

			if (missedShotsCounter.length() == 10)
			{

				System.out.println("Pudło po raz 10! Nie udało Ci się odgadnąć hasła. \n\nPrzysłowie brzmi: " + "\""
						+ proverb.getProverb() + "\"");
				break;
			}

			System.out.println(hiddenProverbChars);
			System.out.println();

			isComplete = Arrays.equals(proverbChars, hiddenProverbChars);
			if (isComplete)
				System.out.println("Brawo! Gratulujacje!");

		}
	}

}
