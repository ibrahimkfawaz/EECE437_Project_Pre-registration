//a class to represent a classroom
//each room has an id, building name, room number, capacity,
public class Room
{
	private int id; //unique id
	private String bldg; //name of building
	private int number; //room number
	private int capacity; //number of seats
	private TimeSlots slots; //representation of time slots of every room

	public Room()
	{
		this.slots = new TimeSlots();
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