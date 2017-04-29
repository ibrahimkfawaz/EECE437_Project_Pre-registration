//a current course is a course chosen by the professor.
//it has the course name,name of professor giving the course, #of students
public class CurrentCourse {
	
	private String name; //Course name
	private String prof; //name of professor giving the course
	private int numofstudents; //number of students interested in taking the course
	private int time;
	private Room room;

	public CurrentCourse()
	{
	
	}
	
	//set name of course
	public void setname(String n)
	{
		this.name=n;
	}
	
	//set professor name
	public void setprof(String p)
	{
		this.prof=p;
	}
	
	//set number of students
	public void setnumofstudents(int s)
	{
		this.numofstudents=s;
	}
	
	//set time 
	public void settime(int t)
	{
		this.time=t;
	}
	//set room
	public void setroom(Room r)
	{
		this.room=r;
	}
	
	
	//return professor name giving the course 
	public String getprofessor() 
	{
		return this.prof;
	}
	
	//return name of course 
	public String getname() 
	{
		return this.name;
	}
	
	//return number of students in this course
	public int getnumofstudents() 
	{
		return this.numofstudents;
	}
	
	//return time 
	public int gettime(int t)
	{
		return this.time;
	}
	

}
