package pl.tatastruga.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pl.tatastruga.web.LetterRevealer;

class LetterRevealerTest
{
	String pickedLetter;
	String proverbText;
	String hiddenProverb;
	LetterRevealer letterRevealer = new LetterRevealer();
	
	@Test
	void revealLetterInHiddenProverbTextTest()
	{
		pickedLetter = "A";
		proverbText = "Czarna polewka";
		hiddenProverb = "______ _______";
		
		assertEquals("__A__A ______A", letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb, proverbText));
	}

}
