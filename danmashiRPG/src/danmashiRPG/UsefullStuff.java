package danmashiRPG;
import java.util.Random;


public class UsefullStuff {
	static Random rand = new Random();
	
	public static int throwDice(int sides, int number)
	{
		int result = 0;
		for (int i = 0; i < number ; i++)
		{
			result += rand.nextInt(sides-1)+1;
		}
		return result;
	}

}
