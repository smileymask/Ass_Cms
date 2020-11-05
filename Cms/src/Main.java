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
public class Main{
 public static void main (String[] args) throws IOException{
   ContestantMethod a= new ContestantMethod();
   boolean check=a.login();
   // Make a test
    Contest b= new Contest();
    b=b.GenerateContest(a.getNameInfo());
    b.display();
   //------------------------------------------
}

}