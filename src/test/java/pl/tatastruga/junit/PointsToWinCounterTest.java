package pl.tatastruga.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pl.tatastruga.web.LetterRevealer;
import pl.tatastruga.web.PointsToWinCounter;

class PointsToWinCounterTest
{

	PointsToWinCounter pointsToWinCounter = new PointsToWinCounter();
	
	@Test
	void countCurrentPointsToWinTest1()
	{
		assertEquals(9, pointsToWinCounter.countCurrentPointsToWin(15, false));
	}
	
	@Test
	void countCurrentPointsToWinTest2()
	{
		assertEquals(10, pointsToWinCounter.countCurrentPointsToWin(15, true));
	}
	
	@Test
	void countCurrentPointsToWinTest3()
	{
		assertEquals(4, pointsToWinCounter.countCurrentPointsToWin(5, false));
	}
	
	@Test
	void countCurrentPointsToWinTest4()
	{
		assertEquals(5, pointsToWinCounter.countCurrentPointsToWin(5, true));
	}

}
