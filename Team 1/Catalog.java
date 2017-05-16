package sample;
import java.util.ArrayList;

public class Catalog
{
	private static Catalog cat;
	public ArrayList<String> names; //names of courses, "EECS 201 - Introduction to Programming" for example
	public ArrayList<String> descs; //brief description of each course


	static public Catalog getinstance(){
		if(cat==null)
		{
			cat= new Catalog();
		}
		return cat;

	}

	//constructor
	private Catalog()
	{
		names = new ArrayList<String>();
		descs = new ArrayList<String>();
			
	}
	//add a course
	public void addCourse(String n, String d)
	{
		names.add(n);
		descs.add(d);
	}

}