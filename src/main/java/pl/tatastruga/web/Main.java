package pl.tatastruga.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Proverb proverb = new Proverb("W marcu jak w garncu", "Przysłowie określające zmienność marcowej pogody");
		Proverb proverb2 = new Proverb("Czego Jaś się nie nauczy, tego Jan nie będzie umiał!",
				"Przysłowie to mówi nam, że wiedza i umiejętności, które zdobywamy w czasie dzieciństwa pozostają nam na całe życie. \nDlatego ważne jest aby w dzieciństwie nabrać odpowiednich cech charakteru, które ukształtują nas na resztę naszego życia.");

		 Connection myConn = null;
		 Statement myStmt = null;
		 ResultSet myRs = null;
		 
		 String dbUrl = "jdbc:mysql://s43.linuxpl.com/creall_proverbs";
		 String user = "creall_provUser";
		 String pass = "tzfyJExk";

		 try 
		 {
		    myConn =  DriverManager.getConnection(dbUrl, user, pass);
		 
		    System.out.println("Połączono z bazą");
		    
		    myStmt  =  myConn.createStatement();
		    
		    myRs = myStmt.executeQuery("SELECT id, meaning FROM proverbs WHERE proverb LIKE '%bab%'  ");
		    
		    while(myRs.next())
		    {
		    System.out.println(myRs.getString("id")+". "+myRs.getString("meaning"));
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
					|| proverbChars[i] == '!' || proverbChars[i] == '.')
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

				System.out.println("Pudło po raz 10! Nie udało Ci się odgadnąć hasła. \n\nPrzysłowie brzmi: "
						+ "\"" + proverb.getProverb() + "\"");
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
