package QuestionBank;
import java.util.ArrayList;
public class Contest{
public String id,date,nameMake;
public ArrayList<Problem> QuestionList= new ArrayList<Problem>();

public Contest() {
        this.id = "";
        this.date = "";
        this.nameMake = "";
        
    }
    public Contest(String id, String date, String nameMake,ArrayList<Problem> QuestionList) {
        this.id = id;
        this.date = date;
        this.nameMake = nameMake;
        this.QuestionList=QuestionList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameMake() {
        return nameMake;
    }

    public void setNameMake(String nameMake) {
        this.nameMake = nameMake;
    }

    public ArrayList<Problem> getQuestionList() {
        return QuestionList;
    }

    public void setQuestionList(ArrayList<Problem> QuestionList) {
        this.QuestionList = QuestionList;
    }

   public void GenerateContest(){
       
   }
    

   



}