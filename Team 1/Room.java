//a class to represent a classroom
//each room has an id, building name, room number, capacity,
public class Room
{
	private int id; //unique id
	private String bldg; //name of building
	private int number; //room number
	private int capacity; //number of seats
	private TimeSlots slots; //representation of time slots of every room
	/*
		represents the classes associated with the time slots
		for example if slots[1] = MWF@9-9:50/AM and classes[1] = 14607
		Then the course of CRN 14607 is in this room every MWF at 9 AM till 9:50 AM
		
	*/
	private ArrayList<Integer> classes; 
	public Room()
	{
		slots = new TimeSlots();
		classes = new ArrayList<Integer>();
	}
	//check if a slot is available
	public boolean isSlotAvailable(String s)
	{
		return slots.isAvailable(s);
	}
	//add a class in a certain time slot
	public void addClass(int crn,String slot)
	{
		//first check if the slot is available
		if(!(slots.isAvailable(slot)))
		{
			System.out.println("Error: this slot is already occupied");
		}
		else
		{
			classes.add(crn);
			slots.addSlot(s);
		}
	}
	//return the id
	public int getId() 
	{
		return this.id;
	}
	//return room number
	public int getNumber()
	{
		return this.number;
	}
	//return number of seats
	public int getCapacity()
	{
		return this.capacity;
	}
	//return name of bldg
	public String getBldg()
	{
		return this.bldg;
	}

	//set room id
	public void setId(int i)
	{
		this.id=i;
	}
	//set bldg name
	public void setBldg(String b)
	{
		this.bldg=b;
	}
	//set room number
	public void setNumber(int n)
	{
		this.number=n;
	}
	//set room capacity
	public void setCapacity(int c)
	{
		this.capacity=c;
	}
}