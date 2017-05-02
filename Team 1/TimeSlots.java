package sample;
import java.util.ArrayList;

//a class that represents time slots for a room
public class TimeSlots
{
	/*
	 an arraylist of strings to represent slots
	slots are inserted through a constant format
	for example:
		MWF@9-9:50/AM represents a class every Monday, Wednesday, Friday that starts at 9 AM and is 50 minutes long 
	*/
	private ArrayList<String> slots;
	/*
		to extend later:
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
	//private ArrayList<Integer> time; //note represent more than 1 day

	//constructor
	public TimeSlots()
	{
		this.slots = new ArrayList<String>();
	}
	//add a slot
	public void addSlot(String s) 
	{
		slots.add(s);
	}
	//check if a slot is available
	public boolean isAvailable(String s)
	{
		return !(slots.contains(s));
	}

	//remove a slot: first find its index in the list then remove it, "remove" returns a String
	public String removeSlot(String s)
	{
		int i = slots.indexOf(s);
		slots.remove(i);
		return s;
	}


}