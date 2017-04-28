package sample;

/**
 * Created by Hasan Fakih on 4/16/2017.
 */
public class ProfessorPageController {
    Professor localprofessor= new Professor();
    private Main main;

    public void setMain(Main main,Professor prof){
        this.main= main;
        this.localprofessor = prof;
    }
}
