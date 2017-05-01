package sample;

import java.util.ArrayList;

/**
 * Created by Hasan Fakih on 4/9/2017.
 */
public class Professor extends User {
        private ArrayList<Course> proposedcourses = new ArrayList<>();
        private String dept;

    public Professor(ArrayList<Course> proposedcourses) {
        this.proposedcourses = proposedcourses;
    }

    public Professor() {
    }

    public ArrayList<Course> getProposedcourses() {
        return proposedcourses;
    }

    public void setProposedcourses(ArrayList<Course> proposedcourses) {
        this.proposedcourses = proposedcourses;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
