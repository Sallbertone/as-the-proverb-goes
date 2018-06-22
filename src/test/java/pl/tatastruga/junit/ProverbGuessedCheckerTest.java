package pl.tatastruga.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pl.tatastruga.web.ProverbGuessedChecker;

class ProverbGuessedCheckerTest
{
	
	private String hiddenProverb;
	private String proverbText;
	private ProverbGuessedChecker proverbGuessedChecker = new ProverbGuessedChecker();

	@Test
	void checkIfProverbIsGuessedTest1()
	{
		hiddenProverb = "GRUSZKI NA WIERZBIE";
		proverbText = "Gruszki na wierzbie";
						
		assertTrue(proverbGuessedChecker.checkIfProverbIsGuessed(hiddenProverb, proverbText));
	}

	@Test
	void checkIfProverbIsGuessedTest2()
	{
		hiddenProverb = "GRUSZKI NA WIERZBIE";
		proverbText = "Gruszki n_ wierzbie";
						
		assertFalse(proverbGuessedChecker.checkIfProverbIsGuessed(hiddenProverb, proverbText));
	}
	
	@Test
	void checkIfProverbIsGuessedTest3()
	{
		hiddenProverb = "GRUSZKI NA WIERZBIE";
		proverbText = "GRUSZKI NA WIERZBIE";
						
		assertTrue(proverbGuessedChecker.checkIfProverbIsGuessed(hiddenProverb, proverbText));
	}
}
