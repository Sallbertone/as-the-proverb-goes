package pl.tatastruga.web;

public class LetterRevealer
{

	private String hiddenProverbTextWithRevealedLetters;
	private char[] proverbChars;
	private char[] hiddenProverbChars;
	
	public String revealLetterInHiddenProverbText(String pickedLetter, String hiddenProverb, String proverbText)
	{
		proverbChars = proverbText.toUpperCase().toCharArray();
		hiddenProverbChars = hiddenProverb.toUpperCase().toCharArray();

		for (int i = 0; i < proverbChars.length; i++)
		{
			if (proverbChars[i] == pickedLetter.toUpperCase().charAt(0))
			{
				hiddenProverbChars[i] = proverbChars[i];
			} 
		}
		
		hiddenProverbTextWithRevealedLetters = new String(hiddenProverbChars);
		return hiddenProverbTextWithRevealedLetters;
	}

}
