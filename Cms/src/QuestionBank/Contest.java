package QuestionBank;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
public class Contest{
public String id,nameMake;
public int totalMark;
public String timeStamp=java.time.LocalTime.now().toString();
public ArrayList<Problem> QuestionList= new ArrayList<Problem>();
public String date=reverseDate(java.time.LocalDate.now().toString());
public ListProblems a= new ListProblems();
public ArrayList<Contest> testBank = new ArrayList<>();
public Contest() {
        this.id = "";
        this.nameMake = "";
        
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
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
            if(i==0){
                s.append(list[i]);
                break;
            }
            s.append(list[i]+"-");
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
       int r=0;
       String idX=a.GenerateCode();
       ArrayList<Problem> Lproblem=a.GenerateProblemList();
       for(Problem i: Lproblem){
           r+= i.getMark();
       }
       Contest a = new Contest(idX, name, Lproblem);
       a.setTotalMark(r);
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
// --------------------Test Bank -------------------------
//|Time Stamp| ID Test | Date  | Total Mark |  Maker Name  
public void addContest(Contest a) throws  IOException{
FileWriter fw = new FileWriter("testBank.txt", true);
 PrintWriter pw = new PrintWriter(fw);
 pw.printf("%10s | %4s | %10s | %4d |%s|%s|%s|%s|%s|%s\n",timeStamp,a.getId(),a.getDate(),a.getTotalMark(),a.getNameMake(),a.getQuestionList().get(0).getId(),a.getQuestionList().get(1).getId(),a.getQuestionList().get(2).getId(),a.getQuestionList().get(3).getId(),a.getQuestionList().get(4).getId());
 pw.close();
}


public Contest getContest(ListProblems a) throws FileNotFoundException, IOException{
    Scanner input= new Scanner(System.in);
    Contest newCon= new Contest();
    System.out.print("Enter the ID Contest: ");
    String ID=input.nextLine();
    FileReader fr = new FileReader("testBank.txt");
    BufferedReader br= new BufferedReader(fr);
    String nextt=br.readLine();
    while(true){
        String s= br.readLine();
        if(s==null ) break;
        String spe[]=s.split("[|]");
        if(spe[1].trim().compareToIgnoreCase(ID)==0){
            ArrayList<Problem> List = new ArrayList<>();
            String ID1=spe[5].trim();List.add(a.getProblem(ID1));
            String ID2=spe[6].trim();List.add(a.getProblem(ID2));
            String ID3=spe[7].trim();List.add(a.getProblem(ID3));
            String ID4=spe[8].trim();List.add(a.getProblem(ID4));
            String ID5=spe[9].trim();List.add(a.getProblem(ID5));
            newCon= new Contest(ID, spe[4], List);
           
        }
    }
    return newCon;
}
   



}