package danmashiRPG;

public class mainClass 
{
	public static void main(String args[]) 
	{
		System.out.println("Willkommen zum danmachi RPG");
		
		// erstes testobject
		LivingThing t1 = new LivingThing("Ding", 25, 65, 20, 3);
		
		t1.showStats();
		
		t1.changeHealth(5, 2);
		t1.changeHealth(-6, 0);
		
		if(t1.dodge(1, 5))
			System.out.println(" Ausgewichen ");
		
		
	}

}
