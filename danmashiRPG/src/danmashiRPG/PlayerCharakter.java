package danmashiRPG;

public class PlayerCharakter extends LivingThing
{
	// Charakter bestimmend
	private String Race;
	private String Skill;
	private String Spells;
	private String FamiliaName;
	private Familia Familia;
	
	// Level
	private int Level;
	
	// Attribute
	private int Magic;
	private int Endurance;
	private int Dexterety;
	
	// Vermögen | Loot
	private int Valis;
	private int ShadowGems;
	private String Equipment;
	
	// Abegeleitete Werte
	private int ExhaustionMax;
	private int Exhaustion;
	private int AttackSpeed;
	
	
	// Default-Construktor
	public PlayerCharakter()
	{
		super(); 	//default construktor aufruf
		super.setName("Bell Cranel ");
		Race = "Mensch";
		Skill = "Realis Phrase ";
		Level = 2;
		Magic = 0;
		Endurance = 0;
		Dexterety = 0;
		Valis = 0;
		ShadowGems = 0;
		Equipment = "Hestia Knife";
		Exhaustion = 0;
		ExhaustionMax = 0;
		AttackSpeed = 0;
		Spells = "Firebolt";
		Familia = new Familia();
		FamiliaName = Familia.getName();
	}
	
	// Construktor
	public PlayerCharakter(String name, String race, int str, int dex, int end, int agi, int mag, String equip, int valis, int sg, int bd , String spell, String nameF, String  god, int members, int property, int maintenance, boolean dailyUpdate  )
	{
		
		super(name, str, agi, 0 , bd);	// aufruf construktor livingthing
		// berechnung von HP:
		super.setHitPointsMax(15+end/5);
		super.setHitPoints(15+end/5);
		
		// berechnung erschöpfung
		Exhaustion = 10 + (mag/10) + (end/10);
		ExhaustionMax = Exhaustion;
		
		Race = race;
		Skill = " - ";
		Level = 1;
		Magic = mag;
		Endurance = end;
		Dexterety = dex;
		Valis = valis;
		ShadowGems = sg;
		Equipment = equip;
		Spells = spell;
		
		// attackspeed berechnen
		AttackSpeed = 1 + super.getAgility()/100;
		
		//Familia
		Familia = new Familia( nameF,  god,  members,  property,  maintenance,  dailyUpdate);
		FamiliaName = Familia.getName();
	}

	
	
	 /**
	  * 
	    * Standart Attributs tests
	    * @param index benutzt für die auswahl des Attributs
	    * @param index Reihenfolge: 1 = str, 2 = dex, 3 = end, 4 = magic, 5 = agi
	    * @return anzahl der erfolgsgrade, -1 -> fehlschlag
	    */
	public int useAttribute(int index) 	// methoden.rtf enthält reihenfolge
	{
		
		int result = UsefullStuff.throwDice(100, 1);
		int successRate = 0;
		int attribute;
		switch(index)
		{
		case 1:
			attribute = super.getStrength();
			break;
		case 2:
			attribute = Dexterety;
			break;
		case 3: 
			attribute = Endurance;
			break;
		case 4:
			attribute = Magic;
		default:
			attribute = super.getAgility();
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


	@Override
	public void showStats() 
	{
		System.out.println(" Name: " + super.getName() + "    Rasse: " + Race + "    " + FamiliaName);
		System.out.println(" Lebenskraft: " + Integer.toString(super.getHitPoints()) + " / " + Integer.toString(super.getHitPointsMax()));
		System.out.println(" Erschöpfung: " + Integer.toString(Exhaustion) + " / " + Integer.toString(ExhaustionMax));
		System.out.println(" Grundschaden: " + Integer.toString(super.getBaseDamage()));
		System.out.println(" Str: " + Integer.toString(super.getStrength()) + "    Agi: " + Integer.toString(super.getAgility()) + "    Dex: "+ Integer.toString(Dexterety)+ "    Aus: "+ Integer.toString(Endurance) + "    Mag: " + Integer.toString(Magic));
		System.out.println();
		System.out.println("Skill: " + Skill);
		System.out.println("Zauber: " + Spells);
		System.out.println("Equipment: " + Equipment);
		System.out.println();
		System.out.println("Valis: " + Valis + "    Schattenjuwelen: " + ShadowGems);
		System.out.println();
	}

	@Override
	public void healthBar()
	{
		System.out.println(" Name: " + super.getName());
		System.out.println(" Lebenskraft: " + Integer.toString(super.getHitPoints()) + " / " + Integer.toString(super.getHitPointsMax()));
		System.out.println(" Erschöpfung: " + Integer.toString(Exhaustion) + " / " + Integer.toString(ExhaustionMax));
		System.out.println();
	}
	
	/**
	 * Gibt Valis vom Charakter an seine Familia weiter
	 * @param val
	 */
	public void payFamilia(int val)
	{
		if(Valis > val)
		{
			Familia.income(val);
			Valis -= val;
		}else
			System.out.println("Der Charakter besitzt nicht so viel");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// getter und setter
	
	

	public String getRace() 
	{
		return Race;
	}

	public void setRace(String race) 
	{
		Race = race;
	}

	public String getSkill() 
	{
		return Skill;
	}

	public void setSkill(String skill) 
	{
		Skill = skill;
	}

	public int getLevel() 
	{
		return Level;
	}

	public void setLevel(int level) 
	{
		if(level > 0)
			Level = level;
		else
			Level = 1;
	}

	public int getMagic() 
	{
		return Magic;
	}

	public void setMagic(int magic) 
	{
		if(magic > 0 && magic < 1000)
			Magic = magic;
	}

	public int getEndurance() 
	{
		return Endurance;
	}

	public void setEndurance(int endurance) 	// normalerweise nicht verwendet, da berechneter wert
	{
		Endurance = endurance;
	}

	public int getDexterety() 
	{
		return Dexterety;
	}

	public void setDexterety(int dexterety) 
	{
		if(dexterety > 0 && dexterety < 1000)
		Dexterety = dexterety;
	}

	public int getValis() 
	{
		return Valis;
	}

	public void setValis(int valis) 
	{
		Valis = valis;
	}

	public int getShadowGems() 
	{
		return ShadowGems;
	}

	public void setShadowGems(int shadowGems) 
	{
		ShadowGems = shadowGems;
	}

	public String getEquipment() 
	{
		return Equipment;
	}

	public void setEquipment(String equipment) 
	{
		Equipment = equipment;
	}

	public int getExhaustionMax() 
	{
		return ExhaustionMax;
	}

	public void setExhaustionMax(int exhaustionMax) 
	{
		ExhaustionMax = exhaustionMax;
	}

	public int getExhaustion() 
	{
		return Exhaustion;
	}

	public void setExhaustion(int exhaustion) 
	{
		Exhaustion = exhaustion;
	}

	public int getAttackSpeed() 
	{
		return AttackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) 
	{
		AttackSpeed = attackSpeed;
	}
	
	
	
	
	
	
	
}
