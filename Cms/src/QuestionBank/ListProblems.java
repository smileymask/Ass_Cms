    package QuestionBank;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.*;
import java.util.*;

public class ListProblems {

    private static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphaUpperCase = alpha.toUpperCase();
    public static String[] CategoryList = {"analysis", "figure", "Greedy algorithm", "Dynamic programming", "graph"};
    private static final String digits = "0123456789";
    private static  String name[] = new String[]{"Mạnh", "Minh", "Việt Anh", "Tiến", "Dương", "Anh", "Giang", "Thương", "Nam", "My", "Đạt", "Huyền", "Phúc", "Hiệp", "Thành", "Hà"};
    private static  String Fname[] = new String[]{"Nguyễn", "Phan", "Cao", "Uchiha", "Phạm", "Bá", "Đào"};
    private static  String Mname[] = new String[]{"Đức", "Thu", "Mạnh", "Lê", "Huyền", "Nguyệt", "Dương"};
    private static String linkL[] = new String[]{"CodeSource.com","Mathematics_for_new.com","https://www.geeksforgeeks.org","http://w3school.com"};
    private static final String ALPHA_NUMERIC = alphaUpperCase + digits;

    public final String fname = "Qbs.txt";
    public ArrayList<Problem> list = new ArrayList<>();
    public final Random generator = new Random();

    int randomNum(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

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
            if (s == null|| s.compareTo("")==0) {
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

    public void FormatData() throws IOException {
        list.clear();
        for(String x: CategoryList){
          
        FileReader fr = new FileReader(x+".txt");
        BufferedReader br = new BufferedReader(fr);
        String desX;
        int o=1;
        while (true) {
            desX = br.readLine();
            if(desX == null) break;
            if(desX.compareTo("")==0) break;
            Problem a= new Problem();
            String codeX=GenerateCode();
            String dateX=GenerateDay();
            String tach[]=x.split(" ");
            String nameX= tach[0]+ " Problem"+o;
            o++;
            String authorX=GenerateName();
            String linkX=GenerateLink();
            int typeX=0;
            int markX=GenerateMark();
            for(int i=0;i<CategoryList.length;i++){
                if (CategoryList[i].compareToIgnoreCase(x)==0){
                 typeX=i+1;   
                }
            }
            a = new Problem(codeX, dateX, nameX, desX, linkX, authorX, markX, typeX);
            list.add(a);
        }
        
        fr.close();
        br.close();
        }
        saveFile();
        
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
            int x = FindId(xId);
            while (true) {
                System.out.println("----------------------------------------------");
                System.out.printf("Chose data you want to change:\n");
                System.out.printf("1.Id\n2.Date\n3.Name\n4.Short Description\n5.Link\n6.Author\n7.Mark\n");
                System.out.printf("8.Category\n0.Exits\n");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(input.nextLine());
                if (choice == 0) {
                    saveFile();
                    break;
                }

                switch (choice) {
                    case 1: {

                        String yId = new String();
                        while (true) {
                            System.out.print("Enter new Id: ");
                            yId = input.nextLine();
                            if (checkId(yId) || (yId.compareToIgnoreCase(xId) == 0)) {
                                list.get(x).setId(yId);
                                System.out.println("-------------------");
                                System.out.println("  Update success !");
                                System.out.println("-------------------");
                                break;
                            }
                            System.out.println("Id had valid please try again !");
                        }
                        saveFile();
                        break;
                    }
                    case 2: {
                        System.out.print("Enter new Date: ");
                        xDate = input.nextLine();
                        list.get(x).setDate(xDate);
                        System.out.println("-------------------");
                        System.out.println("  Update success !");
                        System.out.println("-------------------");
                        break;
                    }
                    case 3: {
                        System.out.print("Enter new Name: ");
                        xName = input.nextLine();
                        list.get(x).setName(xName);
                        System.out.println("-------------------");
                        System.out.println("  Update success !");
                        System.out.println("-------------------");
                        break;

                    }
                    case 4: {
                        System.out.print("Enter new Short Description: ");
                        xShortDes = input.nextLine();
                        list.get(x).setShortDes(xShortDes);
                        System.out.println("-------------------");
                        System.out.println("  Update success !");
                        System.out.println("-------------------");
                        break;
                    }
                    case 5: {
                        System.out.print("Enter new Link: ");
                        xLink = input.nextLine();
                        list.get(x).setLink(xLink);
                        System.out.println("-------------------");
                        System.out.println("  Update success !");
                        System.out.println("-------------------");
                        break;
                    }
                    case 6: {
                        System.out.print("Enter new Author: ");
                        xAuthor = input.nextLine();
                        list.get(x).setAuthor(xAuthor);
                        System.out.println("-------------------");
                        System.out.println("  Update success !");
                        System.out.println("-------------------");
                        break;
                    }

                }
            }
        } else {
            System.out.println("Id not Found !");
        }

    }
    public Problem getProblem(String s){
        for(Problem i : list){
            if(i.getId().compareTo(s)==0){
                return i;
            }
        }
        System.out.println("Not found !");
        return list.get(0);
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
        System.out.println("------------------------------------------------------Question Bank--------------------------------------------------");
        System.out.printf("%5s|%10s|%20s|%25s|%5s|%20s|%s\n", "ID", "Date", "Name", "Author", "Mark", "Category", "link");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
    
    

   
/// Generate Data 
    public  String GenerateCode() {
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        int num = randomNum(0, alphaUpperCase.length() - 1);
            char b = alphaUpperCase.charAt(num);
            s.append(b);
        for (int i = 0; i < 2; i++) {
            num= randomNum(0, digits.length()-1);
            b=digits.charAt(num);
            s.append(b);
        }
        return s.toString();
    }
    public String GenerateDay(){
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        int num=randomNum(1, 30);
        s.append(num+"-");
        num=randomNum(1, 10);
        s.append(num+"-");
        s.append("2020");
        return s.toString();
    }
  public String GenerateName() {
        int a = randomNum(0, (name.length - 1));
        int b = randomNum(0, (Fname.length - 1));
        int c = randomNum(0, (Mname.length - 1));
        StringBuilder s = new StringBuilder();
        s.append(Fname[b] + " " + Mname[c] + " " + name[a]);
        return s.toString();
    }
  public String GenerateLink(){
      StringBuilder s = new StringBuilder();
        Random random = new Random();
        int num=randomNum(0, linkL.length-1);
        s.append(linkL[num]);
        return s.toString();
  }
  public int GenerateMark(){
      Random random= new  Random();
      return randomNum(1, 5)
      ;
  }
  // Hàm lấy ra ngẫu nhiễn 5 problem:
  public ArrayList<Problem> GenerateProblemList() {
        ArrayList<Problem> a = new ArrayList<>();
        ArrayList<Problem> anaList = new ArrayList<>();
        ArrayList<Problem> fiList = new ArrayList<>();
        ArrayList<Problem> greList = new ArrayList<>();
        ArrayList<Problem> dyList = new ArrayList<>();
        ArrayList<Problem> graList = new ArrayList<>();
        for (Problem i : list) {
            if (i.getCategory().compareToIgnoreCase("analysis") == 0) {
                anaList.add(i);
            } else if (i.getCategory().compareToIgnoreCase("figure") == 0) {
                fiList.add(i);
            } else if (i.getCategory().compareToIgnoreCase("Greedy algorithm") == 0) {
                greList.add(i);
            } else if (i.getCategory().compareToIgnoreCase("Dynamic programming") == 0) {
                dyList.add(i);
            } else if (i.getCategory().compareToIgnoreCase("graph") == 0) {
                graList.add(i);
            }
        }
            int num=0;
            if(anaList.size() != 0){
                num = randomNum(0, (anaList.size() - 1));
                a.add(anaList.get(num));
            }
            if(fiList.size() != 0){
            num = randomNum(0, (fiList.size() - 1));
            a.add(fiList.get(num));
            }
            if(greList.size() !=0){
            num = randomNum(0, (greList.size() - 1));
            a.add(greList.get(num));
            }
            if(dyList.size() !=0){
            num = randomNum(0, (dyList.size() - 1));
            a.add(dyList.get(num));
            }
            if(graList.size()!=0){
            num = randomNum(0, (graList.size() - 1));
            a.add(graList.get(num));
            }
        
        return a;
    }
  
}
