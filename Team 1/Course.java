package sample;

import java.util.ArrayList;

/**
 * Created by Hasan Fakih on 4/29/2017.
 */
public class Course {
    private String courseCode; //TODO: make int
    private String courseDesc;
    private String courseName;
    private Boolean offered;
    private ArrayList<Student> pre_registered = new ArrayList<>(); //TODO: store only ids hashed with students
    private Room assigned_Room;
    private TimeSlot assigned_slot;
    private String time_slot;
    //FIXME: time slot used should be the one implemented in a class not the string.
    private Professor instructor;
    //private Admin dept;
    private String dept;
    private int crn; //to be set automatically.

    public Course(String courseCode, String courseDesc, Boolean offered, ArrayList<Student> pre_registered, Room assigned_Room, TimeSlot assigned_slot, Professor instructor, String dept) {
        this.courseCode = courseCode;
        this.courseDesc = courseDesc;
        this.offered = offered;
        this.pre_registered = pre_registered;
        this.assigned_Room = assigned_Room;
        this.assigned_slot = assigned_slot;
        this.instructor = instructor;
        this.dept = dept;
    }

    public Course() {
    }

    public Course(String courseCode, String courseDesc,String time_slot) {
        this.courseCode = courseCode;
        this.courseDesc = courseDesc;
        this.time_slot =time_slot;
    }

    public int getCrn() {
        return crn;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public Boolean getOffered() {
        return offered;
    }

    public ArrayList<Student> getPre_registered() {
        return pre_registered;
    }

    public Room getAssigned_Room() {
        return assigned_Room;
    }

    public TimeSlot getAssigned_slot() {
        return assigned_slot;
    }


    public Professor getInstructor() {
        return instructor;
    }

    public String getDept() {
        return dept;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setOffered(Boolean offered) {
        this.offered = offered;
    }

    public void setPre_registered(ArrayList<Student> pre_registered) {
        this.pre_registered = pre_registered;
    }

    public void setAssigned_Room(Room assigned_Room) {
        this.assigned_Room = assigned_Room;
    }

    public void setAssigned_slot(TimeSlot assigned_slot) {
        this.assigned_slot = assigned_slot;
    }

    public void setInstructor(Professor instructor) {
        this.instructor = instructor;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTime_slot(){
        return  this.time_slot;
    }

    public void setTime_slot(String time_slot) {
        this.time_slot = time_slot;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public void addpre_reg(Student s)
    {
        pre_registered.add(s);
    }
    public int getcap(){
        return pre_registered.size();
    }


}
