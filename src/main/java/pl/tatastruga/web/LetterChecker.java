package pl.tatastruga.web;

public class LetterChecker
{
	
	
	public boolean isLetterPresent(String pickedLetter, String proverbText)
	{
		if(proverbText.toUpperCase().contains(pickedLetter.toUpperCase()))
			return true;
		else return false;
	}

}


//char[] proverbTextChars = proverbText.toCharArray();
//char pickedCharacter = pickedLetter.charAt(0);
//
//for (char character : proverbTextChars)
//{
//	if(Character.toUpperCase(character) == Character.toUpperCase(pickedCharacter))
//		return true;
//}