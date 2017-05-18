package sample;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

//a class to represent a classroom
//each room has an id, building name, room number, capacity,
public class Room
{
    private String name;
	private int capacity; //number of seats
	private ArrayList<TimeSlot> slots=new ArrayList<>(); //representation of time slots of every room
	private String time_slot;

    public boolean addtoRoom(Course c) {
        slots = getRoomSlots();
        for (int i = 0; i < slots.size(); i++) {
            String s = c.getAssigned_slot().getStart();
            String e = c.getAssigned_slot().getEnd();
            String d = c.getAssigned_slot().getDay();
            int start = Integer.parseInt(s);
            int end = Integer.parseInt(e);

            if ((Integer.parseInt(slots.get(i).getStart()) == start ||
                    Integer.parseInt(slots.get(i).getEnd()) == end) && (slots.get(i).getDay().contains(d)))
                return false;
        }
        slots.add(c.getAssigned_slot());
        SaveRoomSlots();
        return true;
    }


    public void SaveRoomSlots(){
        try{
            FileOutputStream fos= new FileOutputStream(this.name);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(slots);
            oos.close();
            fos.close();
        }catch(IOException ioe){
          //  ioe.printStackTrace();
        }
    }

    public ArrayList<TimeSlot> getRoomSlots() {
        try
        {
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            slots = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
          //    ioe.printStackTrace();
            return slots;
        }catch(ClassNotFoundException c){
            // c.printStackTrace();
            return slots;
        }
        return slots;
    }



	public Room() {
	}

	public Room(int capacity, ArrayList<TimeSlot> slots, String time_slot) {
		this.capacity = capacity;
		this.slots = slots;
		this.time_slot = time_slot;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public ArrayList<TimeSlot> getSlots() {
		return slots;
	}

	public String getTime_slot() {
		return time_slot;
	}

	public void setSlots(ArrayList<TimeSlot> slots) {
		this.slots = slots;
	}

	public void setTime_slot(String time_slot) {
		this.time_slot = time_slot;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}