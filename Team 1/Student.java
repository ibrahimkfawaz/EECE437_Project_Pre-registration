package sample;

import java.util.ArrayList;

/**
 * Created by Hasan Fakih on 4/9/2017.
 */
public class Student extends User {
    private ArrayList<Course> pre_reg = new ArrayList<>();

    public void addPre_reg(Course c) {
       pre_reg.add(c);
    }

    public ArrayList<Course> getPre_reg() {
        return pre_reg;
    }

    public void setPre_reg(ArrayList<Course> pre_reg) {
        this.pre_reg = pre_reg;
    }

    public Student(String u) {
        this.username= u;
    }

    public Student(ArrayList<Course> pre_reg) {
        this.pre_reg = pre_reg;
    }

    public Student() {
    }
}
