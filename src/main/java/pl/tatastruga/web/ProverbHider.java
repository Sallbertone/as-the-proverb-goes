package pl.tatastruga.web;

public class ProverbHider
{

	private String hiddenProverbText;
	private char[] proverbChars;
	private char[] hiddenProverbChars;
	
	public String hideProverbText(String proverbText)
	{
		proverbChars = proverbText.toCharArray();
		hiddenProverbChars = new char[proverbChars.length];

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
				hiddenProverbChars[i] = '_';
			}
		}
		
		hiddenProverbText = new String(hiddenProverbChars);
		return hiddenProverbText;
	}

}
