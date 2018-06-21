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
	void revealFirstUpperCaseLetterInHiddenProverbTextTest()
	{
		pickedLetter = "A";
		proverbText = "Czarna polewka";
		hiddenProverb = "______ _______";
		
		assertEquals("__A__A ______A", letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb, proverbText));
	}
	
	@Test
	void revealFirstLowerCaseLetterInHiddenProverbTextTest()
	{
		pickedLetter = "a";
		proverbText = "Czarna polewka";
		hiddenProverb = "______ _______";
		
		assertEquals("__A__A ______A", letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb, proverbText));
	}

	@Test
	void revealSecondLetterInHiddenProverbTextTest()
	{
		pickedLetter = "c";
		proverbText = "Czarna polewka";
		hiddenProverb = "__A__A ______A";
		
		assertEquals("C_A__A ______A", letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb, proverbText));
	}
	
	@Test
	void revealLastLetterInHiddenProverbTextTest()
	{
		pickedLetter = "P";
		proverbText = "Czarna polewka";
		hiddenProverb = "CZARNA _OLEWKA";
		
		assertEquals("CZARNA POLEWKA", letterRevealer.revealLetterInHiddenProverbText(pickedLetter, hiddenProverb, proverbText));
	}
	
}
