package danmashiRPG;

public class mainClass 
{
	public static void main(String args[]) 
	{
		System.out.println("Willkommen zum danmachi RPG");
		
		// erstes testobject
//		LivingThing t1 = new LivingThing("Ding", 25, 65, 20, 3);
//		
//		t1.showStats();
//		
//		t1.changeHealth(5, 2);
//		t1.changeHealth(-6, 0);
//		
//		if(t1.dodge(1, 5))
//			System.out.println(" Ausgewichen ");
		
		
		PlayerCharakter p1 = new PlayerCharakter("Testsubjekt" , "Elf",25,34,14,53,0,"stab",30,0,5,"-","Landos Clan", "Lando", 3, 430, 120,false);
		p1.showStats();
		
		System.out.println("dex check: " + Integer.toString(p1.useAttribute(2)));
		
				
		
		
	}

}
