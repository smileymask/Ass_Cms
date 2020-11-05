import QuestionBank.*;
import java.io.IOException;
import java.util.*;
import java.util.*;
public class Main{
 public static void main (String[] args) throws IOException{
    ListProblems a= new ListProblems();
        a.loadFile();
        ArrayList<Problem> k= new ArrayList<>();
        k=a.GenerateProblemList();
        for(Problem s: k){
            System.out.print(s);
        }
     
//        String dayy=java.time.LocalDate.now().toString();
//        System.out.println(dayy);

}
}