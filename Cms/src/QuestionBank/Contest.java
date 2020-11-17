package QuestionBank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Contest {

    public String id, nameMake;
    public int totalMark;
    public String timeStamp = java.time.LocalTime.now().toString();
    public ArrayList<Problem> QuestionList = new ArrayList<Problem>();
    public String date = reverseDate(java.time.LocalDate.now().toString());
    public ListProblems a = new ListProblems();
    public ArrayList<Contest> testBank = new ArrayList<>();
    public final String f_e = "File Export";

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

    public Contest(String id, String nameMake, ArrayList<Problem> QuestionList) {
        this.id = id.trim();
        this.nameMake = trim(nameMake);
        this.QuestionList = QuestionList;
    }

    public String trim(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken() + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String reverseDate(String date) {
        String list[] = date.split("-");
        StringBuilder s = new StringBuilder();
        for (int i = (list.length - 1); i >= 0; i--) {
            if (i == 0) {
                s.append(list[i]);
                break;
            }
            s.append(list[i] + "-");
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

    public Contest GenerateContest(String name) throws IOException {
        a.loadFile();
        int r = 0;
        String idX = a.GenerateCode();
        ArrayList<Problem> Lproblem = a.GenerateProblemList();
        for (Problem i : Lproblem) {
            r += i.getMark();
        }
        Contest a = new Contest(idX, name, Lproblem);
        a.setTotalMark(r);
        return a;
    }

    public void displayString(String s) {
        String list[] = s.split(" ");
        int cout = 0;
        System.out.println("\t");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
            cout++;
            if (cout == 10) {
                System.out.println("");
                System.out.print("\t");
                cout = 0;
            }
        }
        System.out.println("");
    }

    public void display() {
        int cout = 1;
        System.out.println("--------------------TEST-----------------------------");
        System.out.println("ID: " + getId());
        System.out.println("Date: " + getDate());
        System.out.println("Maker name: " + getNameMake());
        System.out.println("");
        int r = 0;
        for (Problem i : QuestionList) {
            System.out.println("------------");
            System.out.println("|Question " + cout + "| " + i.getName().toUpperCase());
            System.out.println("------------");
            System.out.print("\tDescription: ");
            displayString(i.getShortDes());
            System.out.println("");
            System.out.println("\t\t\t\t|Mark:" + i.getMark());
            cout++;
            r += i.getMark();
        }
        System.out.println("Total: " + r);
        System.out.println("----------------------------------------------");
    }
// --------------------Test Bank -------------------------
//|Time Stamp| ID Test | Date  | Total Mark |  Maker Name  

    public void addContest(Contest a) throws IOException {
        FileWriter fw = new FileWriter("testBank.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.printf("%15s | %4s | %10s | %4d |%15s|%10s|%10s|%10s|%10s|%10s\n", timeStamp, a.getId(), a.getDate(), a.getTotalMark(), a.getNameMake(), a.getQuestionList().get(0).getId(), a.getQuestionList().get(1).getId(), a.getQuestionList().get(2).getId(), a.getQuestionList().get(3).getId(), a.getQuestionList().get(4).getId());
        pw.close();
    }

    public void displayList() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("testBank.txt");
        BufferedReader br = new BufferedReader(fr);
        System.out.println("----------------------------------------------------------Test Bank ---------------------------------------------------------------------------------");
        System.out.printf("%15s | %4s | %10s | %4s |%15s|%10s|%10s|%10s|%10s|%10s\n", "Time Stamp", "ID", "Date", "Mark", "NAME", "Question1", "Question2", "Question3", "Question4", "Question5");
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            System.out.println(s);
        }

    }

    public Contest getContest(ListProblems a) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        Contest newCon = new Contest();
        System.out.print("Enter the ID Contest: ");
        String ID = input.nextLine();
        FileReader fr = new FileReader("testBank.txt");
        BufferedReader br = new BufferedReader(fr);
        String nextt = br.readLine();
        while (true) {
            try {
                String s = br.readLine();
                if (s == null) {
                    break;
                }
                String spe[] = s.split("[|]");
                if (spe[1].trim().compareToIgnoreCase(ID) == 0) {
                    ArrayList<Problem> List = new ArrayList<>();
                    String ID1 = spe[5].trim();
                    List.add(a.getProblem(ID1));
                    String ID2 = spe[6].trim();
                    List.add(a.getProblem(ID2));
                    String ID3 = spe[7].trim();
                    List.add(a.getProblem(ID3));
                    String ID4 = spe[8].trim();
                    List.add(a.getProblem(ID4));
                    String ID5 = spe[9].trim();
                    List.add(a.getProblem(ID5));
                    newCon = new Contest(ID, spe[4], List);
                }
            } catch (Exception e) {
            }
        }
        return newCon;
    }

    public void export() throws IOException {
        Scanner input = new Scanner(System.in);
        String name = new String();
        File file = null;
        boolean isCreat = false;
        try {
            System.out.println("Enter file name: ");
            name = input.nextLine();
            file = new File("File Export" + "\\" + name + ".txt");
            isCreat = file.createNewFile();
            if (isCreat) {
                try (FileWriter fw = new FileWriter(file)) {
                    PrintWriter pw = new PrintWriter(fw);
                    int cout = 1;
                    pw.println("--------------------TEST-----------------------------");
                    pw.println("ID: " + getId());
                    pw.println("Date: " + getDate());
                    pw.println("Maker name: " + getNameMake());
                    pw.println("");
                    int r = 0;
                    for (Problem i : QuestionList) {
                        pw.println("------------");
                        pw.println("|Question " + cout + "| " + i.getName().toUpperCase());
                        pw.println("------------");
                        pw.print("\tDescription: ");
                        String list[] = i.getShortDes().split(" ");
                        int cout2 = 0;
                        for (int j = 0; j < list.length; j++) {
                            pw.print(list[j] + " ");
                            cout2++;
                            if (cout2 == 10) {
                                pw.println("");
                                pw.print("\t");
                                cout = 0;
                            }

                        }

                        pw.println("");
                        pw.println("\t\t\t\t|Mark:" + i.getMark());
                        cout++;
                        r += i.getMark();
                    }
                    pw.println("Total: " + r);
                    pw.println("----------------------------------------------");
                    pw.close();
                }
                String dir= System.getProperty("user.dir");
                System.out.println("||Save File Succsess !||");
                System.out.println("File has been saved at: " +dir+ "\\File Export" + "\\" + name + ".txt");
                System.out.println("");
            } else {
                System.out.println("File has exits !");
            }

        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
