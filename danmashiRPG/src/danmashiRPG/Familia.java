package danmashiRPG;

public class Familia 
{
	// Attribute
	private String Name;
	private String God;
	
	private int Members;
	private int Property;
	private int Maintenance;
	
	private boolean DailyUpdate;

	// Construktor
	public Familia(String name, String god, int members, int property, int maintenance, boolean dailyUpdate)
	{
		Name = name;
		God = god;
		Members = members;
		Property = property;
		Maintenance = maintenance;
		DailyUpdate = dailyUpdate;
	}
	
	// default Construktor
	public Familia()
	{
		Name = "Familia Hestia";
		God = "Hestia";
		Members = 1;
		Property = 200;
		Maintenance = 210;
		DailyUpdate = true;
	}

	
	public void payMaintenance()
	{
		Property -= Maintenance;
		
		if(Property < 0)
		{
			System.out.println("Das Geld Reicht nicht, um deine Familia mit 3 Mahlzeiten am Tag zu versorgen T_T");
			System.out.println(God + " musste " + Property + " Valis Schulden aufnehmen um euch zu versorgen");
		}
	}
	
	
	public void income(int val)
	{
		Property += val;
	}
	
	// andere Mitglieder der Familia verdienen auch Geld
	public void generateIncome()
	{
		int income = 0;
		for(int i = 0; i < (Members-1) ; i++)
		{
			income += UsefullStuff.throwDice(6, UsefullStuff.throwDice(6, 1)) * 10;
		}
		
		income(income);
	}
	
	
	
	
	//getter
	public String getName() 
	{
		return Name;
	}

	public String getGod() 
	{
		return God;
	}

	public int getMembers() 
	{
		return Members;
	}

	public int getProperty() 
	{
		return Property;
	}

	public int getMaintenance() 
	{
		return Maintenance;
	}

	public boolean isDailyUpdate()
	{
		return DailyUpdate;
	}

	
	// setter
	public void setName(String name)
	{
		Name = name;
	}

	public void setGod(String god) 
	{
		God = god;
	}

	public void setMembers(int members) 
	{
		Members = members;
	}

	public void setProperty(int property)
	{
		Property = property;
	}

	public void setMaintenance(int maintenance) 
	{
		Maintenance = maintenance;
	}

	public void setDailyUpdate(boolean dailyUpdate) 
	{
		DailyUpdate = dailyUpdate;
	}
	
	
	
}
