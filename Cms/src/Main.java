import QuestionBank.*;
import java.io.IOException;
import java.util.*;
import java.util.*;
public class Main{
 public static void main (String[] args){
    ListProblems a= new ListProblems();
     try {
         a.FormatData();
        ArrayList<Problem> k= new ArrayList<>();
//        k=a.GenerateProblemList();
//        for(Problem s: k){
//            System.out.println(s);
//        }
a.display();

     } catch (IOException ex) {
     }
}
}