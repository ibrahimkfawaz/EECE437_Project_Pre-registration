package sample;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Hasan Fakih on 4/9/2017.
 * represents a student that mainly has an arraylist of his pre-registered courses
 */
public class Student extends User implements Serializable {
    private ArrayList<Course> pre_reg = new ArrayList<>();

    public void addPre_reg(Course c) {
       pre_reg.add(c);
    }



    public void setPre_reg(ArrayList<Course> pre_reg) {
        this.pre_reg = pre_reg;
    }


    //TODO: fix the directory of the serialization
    public void SaveCourses(){
        try{
            FileOutputStream fos= new FileOutputStream(this.username);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(pre_reg);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public ArrayList<Course> getPre_reg() {

        try
        {
            FileInputStream fis = new FileInputStream(this.username);
            ObjectInputStream ois = new ObjectInputStream(fis);
            pre_reg = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
          //  ioe.printStackTrace();
            return pre_reg;
        }catch(ClassNotFoundException c){
          //  c.printStackTrace();
            return pre_reg;
        }
        return pre_reg;
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
