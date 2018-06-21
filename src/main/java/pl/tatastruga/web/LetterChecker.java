package pl.tatastruga.web;

public class LetterChecker
{

	char pickedCharacter;

	public boolean isLetterPresent(String pickedLetter, String proverbText)
	{
		if (proverbText.toUpperCase().contains(pickedLetter.toUpperCase()))
			return true;
		else
			return false;
	}
}
