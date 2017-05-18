package sample;

import java.util.ArrayList;

/**
 * Created by Hasan Fakih on 4/17/2017.
 * model class for the admin user it holds an ArrayList of the courses (the proposed courses of the department)
 * and an ArrayList of the petitions for the department.
 */
public class Admin extends User {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Petition> petitions = new ArrayList<>();

    public Admin(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Admin(String username) {
        this.username = username;
    }

    public Admin() {
    }


    public ArrayList<Petition> getPetitions() {
        return petitions;
    }

    public void setPetitions(ArrayList<Petition> petitions) {
        this.petitions = petitions;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
