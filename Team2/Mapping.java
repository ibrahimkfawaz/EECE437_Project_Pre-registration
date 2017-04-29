import java.util.ArrayList;

//Mapping inherits from room/current course database(contains course/professor/timing/and number of students/course)
//
public class Mapping {
	

	
        
         
         int roomdatabasesize=50;
      
         Room[] allRooms = new Room[roomdatabasesize];  //empty array of all rooms
         												//allRooms, of all available rooms in database , but for now filling it with dummy variables since database not available yet
         
         //Room[] roomscapacity20= new Room[10];
         ArrayList<Room> RoomCapacity20 = new ArrayList<Room>();
         ArrayList<Room> RoomCapacity30 = new ArrayList<Room>();
         ArrayList<Room> RoomCapacity40 = new ArrayList<Room>();
         ArrayList<Room> RoomCapacity50 = new ArrayList<Room>();
        

         
         for (int j=0; j<roomdatabasesize; j++){ 
        	 allRooms[j]=new Room();
        	 }
         
        
         
         
        for (int i=0; i<roomdatabasesize; i++){
        	if (allRooms[i].getCapacity()==20){
        		RoomCapacity20.add(allRooms[i]);
        	}
        	
        	else if (allRooms[i].getCapacity()==30){
        		RoomCapacity30.add(allRooms[i]);
        		}
        	
        	else if (allRooms[i].getCapacity()==40){
        		RoomCapacity40.add(allRooms[i]);
        	}
        	
        	else if (allRooms[i].getCapacity()==50){
        		RoomCapacity50.add(allRooms[i]);
        	}
        	
        	
   }
        
        //going through all courses in currentcoursedatabase...made a temporary array to use instead of database
        int coursedatabasesize=50;
        
        CurrentCourse[] allcourses = new CurrentCourse[coursedatabasesize];
        for (int m=0; m<coursedatabasesize; m++){ 
        	allcourses[m]=new CurrentCourse();
       	 }
        
        
        for (int n=0; n<coursedatabasesize; n++)
        	if (allcourses[n].getnumofstudents()<=20)  
        	{
        		int x;
			for (int i=0; i<RoomCapacity20.size(); i++){
        		if (RoomCapacity20.get(i).getId()>0)//assuming there is a function that goes through time slot and returns first empty available time; if none empty returns negative number
        		{
        			x=RoomCapacity20.get(i).getId();
        			allcourses[n].settime(x);	
        			allcourses[n].setroom(RoomCapacity20.get(i));
        		}
			}
        		
        	
        		else if (allcourses[n].getnumofstudents()<=30)  
        	{ int x1;
        	for (int i=0; i<RoomCapacity30.size(); i++){
    
            		 if (RoomCapacity30.get(i).getId()>0)//assuming there is a function that goes through time slot and returns first empty available time; if none empty returns negative number
            		{
            			x1=RoomCapacity30.get(i).getId();
            			allcourses[n].settime(x1);	
            			allcourses[n].setroom(RoomCapacity30.get(i));
            		}
            		else if (RoomCapacity40.get(i).getId()>0)//assuming there is a function that goes through time slot and returns first empty available time; if none empty returns negative number
            		{
            			x1=RoomCapacity40.get(i).getId();
            			allcourses[n].settime(x1);	
            			allcourses[n].setroom(RoomCapacity40.get(i));
            		}
            		else if (RoomCapacity50.get(i).getId()>0)//assuming there is a function that goes through time slot and returns first empty available time; if none empty returns negative number
            		{
            			x1=RoomCapacity50.get(i).getId();
            			allcourses[n].settime(x1);	
            			allcourses[n].setroom(RoomCapacity50.get(i));
            		}
        	}
        	}
			
        		else if (allcourses[n].getnumofstudents()<=40)  {
        			int x1;
        			for (int i=0; i<RoomCapacity40.size(); i++){
        		if (RoomCapacity40.get(i).getId()>0)//assuming there is a function that goes through time slot and returns first empty available time; if none empty returns negative number
        		{
        			x1=RoomCapacity40.get(i).getId();
        			allcourses[n].settime(x1);	
        			allcourses[n].setroom(RoomCapacity40.get(i));
        		}
        		else if (RoomCapacity50.get(i).getId()>0)//assuming there is a function that goes through time slot and returns first empty available time; if none empty returns negative number
        		{
        			x1=RoomCapacity50.get(i).getId();
        			allcourses[n].settime(x1);	
        			allcourses[n].setroom(RoomCapacity30.get(i));
        		}
     
  
        	
        		}
        		}
        
        		else if (allcourses[n].getnumofstudents()<=50){
        		int x;
			for (int i=0; i<RoomCapacity50.size(); i++){
        		if (RoomCapacity50.get(i).getId()>0)//assuming there is a function that goes through time slot and returns first empty available time; if none empty returns negative number
        		{
        			x=RoomCapacity50.get(i).getId();
        			allcourses[n].settime(x);	
        			allcourses[n].setroom(RoomCapacity50.get(i));
        		}
        	
  
        	}
        	}
        
       
         
       	
	

}
}
}


