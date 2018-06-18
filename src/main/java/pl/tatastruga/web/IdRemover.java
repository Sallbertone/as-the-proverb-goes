package pl.tatastruga.web;

import java.util.LinkedList;
import java.util.List;

public class IdRemover
{

	public List<Integer> removeId(int index, List<Integer> list, int proverbId)
	{
		try  
		{
			if(list.get(index) == proverbId)
				list.remove(index);
		}
		catch (Exception e) 
		{
			System.out.println("get index and proverbId mismatch");
		}

		return list;
	}
}
