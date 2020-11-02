import QuestionBank.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main{
 public static void main (String[] args){
    ListProblems a= new ListProblems();
     try {
         a.loadFile();
         System.out.println(a.list);
     } catch (IOException ex) {
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
     }
}
}