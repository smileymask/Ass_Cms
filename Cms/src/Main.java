
import QuestionBank.*;
import java.io.IOException;
import java.util.*;
import java.util.*;
import Cms.*;
//he151274	0983569165
//hs153019	0881730654a
//he150883	0389621169
//he153125	0326484853
//ha153020	

//Anh|he151274|0983569165|acbd|1234|1
//Phuc Ha|hs153019|0881730654a|phucha|1234|1
//Tien|he153125|0326484853|quetien|1234|1
//Van|ha153020|0392843701|thaovan|1234|1
//Manh|he150883|0389621169|ducmanh|1234|1
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ContestantMethod a = new ContestantMethod();
        ListProblems LP= new ListProblems();
        LP.loadFile();
       while(true){ 
        boolean check=a.login();
        if(check) break;
        else{
            System.out.println("Please Check your ID or Password !");
        }
       }
    Contest b= new Contest();
    b=b.GenerateContest(a.getNameInfo());
    
        //------------------------------------------
        while (true) {
            System.out.println("1.Show information of Contestant");
            System.out.println("2.Change profile information of Contestant include change password.");
            System.out.println("3.Add a new problem to the Question Bank (QB) ");
            System.out.println("4.Update full information for a particular problem by Problem ID");
            System.out.println("5.A list of all available problems in the QB");
            System.out.println("6.Generate a new Contest");
            System.out.println("7.Print information of a Contest by ContestID (mã đề)");
            System.out.println("8.Sort all problems by Category as ascending order ");
            System.out.println("9.Save, load, and export information functions from QBs.dat file or other specific files" + "\n" + "When system start running, load default QBs.dat file into memory to use.");
            System.out.println("10.Log Out");
            System.out.println("0.Exits");
            int choice=0;
            while(true){
                try {
                System.out.print("Your choice: ");
                choice = Integer.parseInt(input.nextLine());
                break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter number !");
                }
            }
            switch(choice){
                case 1:{
                    break;
                }
                case 2:{
                    break;
                }
                case 3:{
                    LP.add();
                    break;
                }
                case 4:{
                    LP.update();
                    break;
                }
                case 5:{
                    LP.display();
                    break;
                }
                case 6:{
                    b.display();
                    break;
                }case 7:{
                    break;
                }
                case 8:{
                    break;
                }
                case 9:{
                    LP.loadFile();
                    break;
                }
                case 10:{
                    break;
                }
                case 0:{
                    return;
                }
            }
        }
    }
}
