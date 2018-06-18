package pl.tatastruga.web;

import java.util.List;
import java.util.Random;

public class ProverbIdChooser
{

	
	public int chooseCharadeId(List<Integer> list, int index)
	{
		int choosenId = list.get(index);

		System.out.println("choosen id- " + choosenId);
		
		return choosenId;
	}
	
	
}
