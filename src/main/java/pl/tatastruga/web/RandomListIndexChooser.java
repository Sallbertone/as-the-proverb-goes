package pl.tatastruga.web;

import java.util.List;
import java.util.Random;

public class RandomListIndexChooser
{
	public int chooseRandomIndex(int listSize)
	{
		Random random = new Random();
		int index = random.nextInt(listSize);
		return index;
	}
}
