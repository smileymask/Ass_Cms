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
        a.display();
        for(Problem s: k){
            System.out.println(s);
        }
     } catch (IOException ex) {
     }
//        String dayy=java.time.LocalDate.now().toString();
//        System.out.println(dayy);

}
}