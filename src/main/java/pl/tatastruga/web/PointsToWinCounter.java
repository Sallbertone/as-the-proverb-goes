package pl.tatastruga.web;

public class PointsToWinCounter
{

	public int countCurrentPointsToWin(int pointsToWin, boolean isLetterValid)
	{
		if(pointsToWin != 15)
		{
			if (isLetterValid)
			{

			}
			else
			{
				pointsToWin--;
			}
		}
		else
		{
			if (isLetterValid)
			{
				pointsToWin = pointsToWin - 5; 
			}
			else 
			{
				pointsToWin = (pointsToWin - 5) - 1; 
			}
		}
		
		
		return pointsToWin;
	}

}
