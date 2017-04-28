//a class that represents time slots for a room
public class TimeSlots
{
	/*
	 an arraylist of strings to represent slots
	slots are inserted through a constant format
	for example:
		#MWF@9AM/50 represents a class every Monday, Wednesday, Friday that starts at 9 AM and is 50 minutes long 
	*/
	private ArrayList<String> slots;
	/*
		an arraylist to represent the actual duration of each class
		each arraylist element represents a 10 minute duration
		the list starts at 8 am and ends at 8 pm which means 720 minutes
		A 1 represents an occupied duration
		A 0 represents an empty duration
		A 2 represents a "half" occupied duration 
		For example:
		if time[0] is 1, then 8:00 AM -> 8:10 AM is occupied
		if time[1] is 0, then 8:10 AM -> 8:20 AM is empty and available
		if time[2] is 2, then 8:20 AM -> 8:25 AM is occupied while 8:25 AM -> 8:30 AM is empty and available
	*/
	private ArrayList<Integer> time; //note represent more than 1 day

	public TimeSlots()
	{
		this.slots = new ArrayList<String>();
		this.time = new ArrayList<Integer>();
	}
	public void addSlot(String s)
	{

	}
	public void addTime(String s)
	{

	}
	public boolean isAvailable(String s)
	{

	}



}