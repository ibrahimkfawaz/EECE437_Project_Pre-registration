package sample;

import java.util.ArrayList;

/**
 * Created by Hasan Fakih on 4/9/2017.
 * represents the professor
 * a professor will has a username password and an arraylist of proposedcourses
 */
public class Professor extends User {
    private ArrayList<Course> proposedcourses = new ArrayList<>();


    public Professor(ArrayList<Course> proposedcourses) {
        this.proposedcourses = proposedcourses;
    }

    public Professor(String username) {
        this.username = username;
    }

    public Professor() {
    }

    public ArrayList<Course> getProposedcourses() {
        return proposedcourses;
    }

    public void setProposedcourses(ArrayList<Course> proposedcourses) {
        this.proposedcourses = proposedcourses;
    }


}
