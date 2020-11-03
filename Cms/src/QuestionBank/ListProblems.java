package QuestionBank;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.*;
import java.util.*;

public class ListProblems {

    public final String fname = "Qbs.txt";
    public ArrayList<Problem> list = new ArrayList<>();

    public void loadFile() throws IOException {
        list.clear();
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        String xId, xDate, xName, xShortDes, xLink, xAuthor;
        double xMark;
        int xCategory = 0;
        String Cate;
        Problem x = new Problem();
        while (true) {
            s = br.readLine();
            if (s == null) {
                break;
            }
            a = s.split("[|]");
            xId = a[0].trim();
            xDate = a[1].trim();
            xName = a[2].trim();
            xShortDes = a[3].trim();
            xLink = a[4].trim();
            xAuthor = a[5].trim();
            xMark = Double.parseDouble(a[6].trim());
            Cate = a[7].trim();
            for (int i = 0; i < x.CategoryList.length; i++) {
                if (Cate.compareToIgnoreCase(x.CategoryList[i]) == 0) {
                    xCategory = i + 1;
                }
            }
            x = new Problem(xId, xDate, xName, xShortDes, xAuthor, xLink, xMark, xCategory);
            list.add(x);
        }
        fr.close();
        br.close();
    }

    public void saveFile() throws IOException {
        FileWriter fw = new FileWriter(fname, false);
        PrintWriter pw = new PrintWriter(fw);
        Problem x;
        for (int i = 0; i < list.size(); i++) {
            x = list.get(i);
            pw.printf("%5s | %10s | %10s | %10s |%10s|%10s|%.1f | %s\n", x.getId(), x.getDate(), x.getName(), x.getShortDes(), x.getAuthor(), x.getLink(), x.getMark(), x.getCategory());
        }
        fw.close();
        pw.close();
    }

    Boolean checkId(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.compareTo(list.get(i).getId()) == 0) {
                return false;
            }
        }
        return true;
    }

    int FindId(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.compareTo(list.get(i).getId()) == 0) {
                return i;
            }
        }
        return 0;
    }

    public void update() throws IOException {
        String xId, xDate, xName, xShortDes, xLink, xAuthor;
        double xMark;
        int xCategory;
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Id: ");
        xId = input.nextLine();
        if (!checkId(xId)) {
            while (true) {
                System.out.printf("Chose data you want to change:\n");
                System.out.printf("1.Id\n2.Date\n3.Name\n4.Short Description\n5.Link\n6.Author\n7.Mark\n");
                System.out.printf("8.Category\n0.Exits\n");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(input.nextLine());
                if(choice ==0) break;
                switch (choice) {
                    case 1: {
                        int x=FindId(xId);
                        String yId= new String();
                        while(true){
                        System.out.print("Enter new Id: ");
                        yId = input.nextLine();
                        if(checkId(yId)|| (yId.compareToIgnoreCase(xId)==0) ){
                            list.get(x).setId(yId);
                            System.out.println("-------------------");
                            System.out.println("|Update success !|");
                            System.out.println("-------------------");
                            break;
                        }
                            System.out.println("Id had valid please try again !");
                        }
                        saveFile();
                        break;
                    }
                }
            }
        } else {
            System.out.println("Id not Found !");
        }
       
    }

    public void add() throws IOException { // 3.Add a new problem to the Question Bank (QB) 
        Scanner input = new Scanner(System.in);
        String xId, xDate, xName, xShortDes, xLink, xAuthor;
        double xMark;
        int xCategory;
        System.out.print("Enter problem Id: ");
        xId = input.nextLine();
        if (checkId(xId)) {
            System.out.print("Enter problem Date: ");
            xDate = input.nextLine();
            System.out.print("Enter problem Name: ");
            xName = input.nextLine();
            System.out.print("Enter problem Short Description: ");
            xShortDes = input.nextLine();
            System.out.print("Enter problem Author : ");
            xLink = input.nextLine();
            System.out.print("Enter problem Link: ");
            xAuthor = input.nextLine();
            System.out.print("Enter problem Mark weight: ");
            xMark = Double.parseDouble(input.nextLine());
            System.out.println("(1.analysis,2.figure,3.Greedy algorithm,4.Dynamic programming,5.graph");
            System.out.print("Enter problem Category: ");
            xCategory = Integer.parseInt(input.nextLine());
            Problem x = new Problem(xId, xDate, xName, xShortDes, xAuthor, xLink, xMark, xCategory);
            list.add(x);
            saveFile();
        } else {
            System.out.println("");
            System.err.println("WARNING:Id problems had exits please enter another Id!");
            System.out.println("");
        }
    }

    public void display() {
        System.out.println("---------------------------------------Question Bank----------------------");
        System.out.printf("%5s|%10s|%15s|%15s|%10s|%10s|%4s|%s\n", "ID", "Date", "Name", "Description", "Author", "Link", "Mark", "Category");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

}
