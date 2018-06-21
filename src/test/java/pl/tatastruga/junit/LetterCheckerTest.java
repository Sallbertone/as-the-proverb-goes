package pl.tatastruga.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pl.tatastruga.web.LetterChecker;

class LetterCheckerTest
{

	LetterChecker letterChecker = new LetterChecker();
	
	@Test
	void isLetterUppercaseAPresentTest()
	{
		assertTrue(letterChecker.isLetterPresent("A", "W marcu, jak w garncu"));
	}
	
	@Test
	void isLetterLowercaseAPresentTest()
	{
		assertTrue(letterChecker.isLetterPresent("a", "W marcu, jak w garncu"));
	}
	
	@Test
	void isLetterLowercaseZPresentTest()
	{
		assertFalse(letterChecker.isLetterPresent("z", "Kwiecień plecień"));
	}
	
	@Test
	void isLetterUppercaseZPresentTest()
	{
		assertFalse(letterChecker.isLetterPresent("Z", "Kwiecień plecień"));
	}
}
