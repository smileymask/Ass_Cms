package QuestionBank;
import java.io.IOException;
import java.util.ArrayList;
public class Contest{
public String id,nameMake;
public ArrayList<Problem> QuestionList= new ArrayList<Problem>();
public String date=reverseDate(java.time.LocalDate.now().toString());
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
    public String reverseDate(String date){
        String list[]=date.split("-");
        StringBuilder s= new StringBuilder();
        for(int i=(list.length-1);i>=0;i--){
            s.append(list[i]+" ");
        }
        return s.toString();
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

   public Contest GenerateContest(String name) throws IOException{
       a.loadFile();
       String idX=a.GenerateCode();
       ArrayList<Problem> Lproblem=a.GenerateProblemList();
      
       Contest a = new Contest(idX, name, Lproblem);
       return a;
   }
public void displayString(String s){
    String list[] =s.split(" ");
    int cout=0;
    for(int i=0;i<list.length;i++){
        System.out.print(list[i]+" ");
        cout++;
        if(cout ==10){
            System.out.println("");
            System.out.print("\t");
            cout =0;
        }
    }
}
public void display(){
    int cout=1;
    System.out.println("--------------------TEST-----------------------------");
    System.out.println("ID: "+getId());
    System.out.println("Date: "+ getDate());
    System.out.println("Maker name: "+getNameMake());
    System.out.println("");
    int r=0;
    for(Problem i : QuestionList){
        System.out.println("------------");
        System.out.println("|Question "+cout+"| "+i.getName().toUpperCase());
        System.out.println("------------");
        System.out.print("\tDescription: ");
        displayString(i.getShortDes());
        System.out.println("");
        System.out.println("\t\t\t\t|Mark:"+i.getMark());
        cout++;
        r+= i.getMark();
    }
        System.out.println("Total: "+r);
        System.out.println("----------------------------------------------");
             
}

   



}