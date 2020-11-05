package QuestionBank;
import java.util.ArrayList;
public class Contest{
public String id,nameMake;
public ArrayList<Problem> QuestionList= new ArrayList<Problem>();
public String date=java.time.LocalDate.now().toString();
public ListProblems a= new ListProblems();
public Contest() {
        this.id = "";
        this.nameMake = "";
        
    }
    public Contest(String id,  String nameMake,ArrayList<Problem> QuestionList) {
        this.id = id;
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

   public Contest GenerateContest(){
       String idX=a.GenerateCode();
       ArrayList<Problem> Lproblem=a.GenerateProblemList();
       Contest a = new Contest(idX, "Mask", Lproblem);
       return a;
   }
public void display(){
    
}

   



}