public class Catalog
{
	private ArrayList<String> names; //names of courses, "EECS 201 - Introduction to Programming" for example
	private ArrayList<String> descs; //brief description of each course


	//constructor
	public Catalog()
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