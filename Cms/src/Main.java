import QuestionBank.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
public class Main{
 public static void main (String[] args){
    ListProblems a= new ListProblems();
     try {
         a.loadFile();
        ArrayList<Problem> k= new ArrayList<>();
        k=a.GenerateProblemList();
        for(Problem s: k){
            System.out.println(s);
        }
     } catch (IOException ex) {
     }
}
}