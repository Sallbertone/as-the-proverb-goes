package pl.tatastruga.web;

import java.util.LinkedList;
import java.util.List;

public class IdRemover
{

	public List<Integer> removeId(int index, List<Integer> list, int proverbId)
	{

			if(list.get(index) == proverbId)
				list.remove(index);
			else
				System.out.println("proverb ID mismatch");

		return list;
	}
}
