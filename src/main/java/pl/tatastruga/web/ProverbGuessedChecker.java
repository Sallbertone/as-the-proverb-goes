package pl.tatastruga.web;

public class ProverbGuessedChecker
{

	public boolean checkIfProverbIsGuessed(String hiddenProverb, String proverbText)
	{
		if(hiddenProverb.equals(proverbText.toUpperCase()))
			return true;

		return false;
	}

}
