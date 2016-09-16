package danmashiRPG;
// Klasse, die allen Charakteren und Monstern zugrundeliegt

public class LivingThing
{

	
	// Attribute
	private String Name; 		// Name
	private int Strength;		// Stärke Attribut
	private int Agility;		// Agilitäts Attribut
	private int HitPoints;		// Lebenspunkte
	private int BaseDamage;		// Standartschaden
	
	
	// Constructor
	public LivingThing(String name, int str, int agi, int hp, int bd)
	{
		Name = name;
		Strength = str;
		Agility = agi;
		HitPoints = hp;
		BaseDamage = bd;
	}
	
	// Methoden
	public int useAttribute(int index)
	{
		int result = UsefullStuff.throwDice(100, 1);
		int successRate = 0;
		int attribute;
		switch(index)
		{
		case 1:
			attribute = Strength;
			break;
		default:
			attribute = Agility;
			break;
		}
		if (attribute > 100)
		{
			successRate = (attribute-100)/10;
			attribute = 100;
		}
		if (result > attribute || result > 95)
		{
			return -1;
		}
		if (result < 6)
		{
			successRate++;
		}
		successRate += (attribute-result)/10;
		return successRate;	
	}
	
	
	
	
	
	
	
	
	
	
	
	// set Methoden mit Kontrolle
	public void setStrength( int str)
	{
		if(str > 0 && str < 1000)
			Strength = str;
	}
	
	public void setAgility( int agi)
	{
		if(agi > 0 && agi < 1000)
			Agility = agi;
	}
	
	public void setHitPoints( int hp)
	{
		if(hp > 0 && hp < 1000)
			HitPoints = hp;
	}
	
	public void setBaseDamage( int bd)
	{
		if(bd > 0 && bd < 1000)
			BaseDamage = bd;
	}

	
	// get methoden
	public int getStrength()
	{
		return Strength;
	}
	
	public int getAgility()
	{
		return Agility;
	}
	
	public int getHitPoints()
	{
		return HitPoints;
	}
	
	public int getBaseDamage()
	{
		return BaseDamage;
	}
	
}
