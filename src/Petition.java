package sample;

/**
 * Created by Hasan Fakih on 5/16/2017.
 * represents the petition
 * a petition will have a type-petitioner-department-details and the status wether it is accepted or not
 */
public class Petition {
    String type;
    String petitioner;
    String dept;
    String details;
    boolean accpeted;
    String status;
    public Petition(){
    }

    public Petition(String details, String type, String petitioner, String dept) {
        this.details = details;
        this.type = type;
        this.petitioner = petitioner;
        this.dept = dept;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPetitioner(String petitioner) {
        this.petitioner = petitioner;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setAccpeted(boolean accpeted) {
        this.accpeted = accpeted;
    }

    public String getType() {
        return type;
    }

    public String getPetitioner() {
        return petitioner;
    }

    public String getDept() {
        return dept;
    }

    public String getDetails() {
        return details;
    }

    public boolean isAccpeted() {
        return accpeted;
    }
}
