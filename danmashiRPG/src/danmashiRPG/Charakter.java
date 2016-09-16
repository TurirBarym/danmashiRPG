package danmashiRPG;
// Klasse, die allen Charakteren und Monstern zugrundeliegt

import java.util.Random;

public class Charakter 
{
	Random randomGenerator = new Random();
	
	// Attribute
	private int Strength;		// Stärke Attribut
	private int Agility;		// Agilitäts Attribut
	private int HitPoints;		// Lebenspunkte
	private int BaseDamage;		// Standartschaden
	
	
	// Constructor
	public Charakter(int str, int agi, int hp, int bd)
	{
		Strength = str;
		Agility = agi;
		HitPoints = hp;
		BaseDamage = bd;
	}
	
	// Methoden
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
	
	
	// kampfmethoden
	public int attack()
	{
		int diceRoll = randomGenerator.nextInt(99)+1;
		int erfolgsGrad;
		
		if(diceRoll < Strength)
		{
			erfolgsGrad = (Strength - diceRoll)/10;
			return BaseDamage + erfolgsGrad;
		}else
		return 0;
		
	}
	
	public boolean dodge(int gt) 			// returnwert von 0 -> nicht ausgewichen
	{
		int diceRoll = randomGenerator.nextInt(99)+1;
		int erfolgsGrad;
		
		if(diceRoll < Agility)
		{
			erfolgsGrad = (Agility - diceRoll)/10 ;
			if(erfolgsGrad >= gt)
			{
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}

	public boolean reduceHP(int damage)		// returnwert von false -> tot
	{
		HitPoints -= damage;
		return (HitPoints > 0);
	}
	
	
}
