package Cms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ContestantMethod {

    public HashMap<String, String> c = new HashMap<String, String>();
    public ArrayList<Contestant> c1 = new ArrayList<>();
    public String s = "User data\\constestants.txt";
    public String nameInfo;

    public void LoadFile(String file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        c.clear();
        c1.removeAll(c1);
        String s;
        String s1[];
        String id, name, email, mobilephone;
        String password;
        int rank;
        while (true) {
            try {
                s = br.readLine();

                if (s == null) {
                    break;
                }
                if (s.compareToIgnoreCase("") == 0) {
                    break;
                }
                s1 = s.split("\\|");
                name = s1[0];
                id = s1[1];
                password = s1[2];
                email = s1[3];
                mobilephone = s1[4];
                rank = Integer.parseInt(String.valueOf(s1[5]));
                c.put(id, password);
                Contestant e = new Contestant(name, id, password, email, mobilephone, rank);
                c1.add(e);
            } catch (Exception e) {
            }

        }
        fr.close();
        br.close();
    }

    public void savefile(String file) throws IOException {
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(file);
        Contestant m;
        for (int i = 0; i < c1.size(); i++) {
            m = c1.get(i);
            pw.print(c1.get(i).getName() + "|" + c1.get(i).getId() + "|" + c1.get(i).getPassword()
                    + "|" + c1.get(i).getEmail() + "|" + c1.get(i).getMobilephone() + "|" + c1.get(i).getRank() + "\n");
        }
        fw.close();
        pw.close();
    }

    public boolean check(String mess) {
        Scanner input = new Scanner(System.in);
        String choice;
        while (true) {
            System.out.print(mess);
            choice = input.nextLine().toUpperCase().trim();
            if (choice.compareTo("Y") == 0 || choice.compareTo("1") == 0) {
                return true;
            } else if (choice.compareTo("N") == 0 || choice.compareTo("0") == 0) {
                return false;
            } else {
                System.out.println("Please enter again !");
            }
        }

    }

    public void showTable(Contestant chane) {
        StringBuilder sb = new StringBuilder(chane.getPassword());
        for (int i = 2; i < sb.length() - 2; i++) {
            sb.setCharAt(i, '*');
        }
        System.out.printf("%15s|%15s|%30s|%15s|%4s|%15s\n", "ID", "Name", "Email", "Phone number", "Rank", "Password");
        System.out.printf("%15s|%15s|%30s|%15s|%4s|%15s\n", chane.getId(), chane.getName(), chane.getEmail(), chane.getMobilephone(), chane.getRank(), sb.toString());
    }

    public void changeData(String id) throws IOException {
        Scanner input = new Scanner(System.in);
        FileReader fr = new FileReader(s);
        BufferedReader br = new BufferedReader(fr);
        int index = -1;
        for (int i = 0; i < c1.size(); i++) {
            if (id.equals(c1.get(i).getId())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Please check your Contestant's Id");
        } else {
            while (true) {
                showTable(c1.get(index));
                System.out.println("Change profile of Contestant ");
                System.out.println("1. Change Contestant's name: ");
                System.out.println("2. Change Contestant's email: ");
                System.out.println("3. Change Contestant's mobilephone: ");
                System.out.println("4. Change Contestant's rank");
                System.out.println("5. Change Contestant's password");
                System.out.println("6. Change all ");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter your name: ");
                        String rename = input.nextLine().trim();
                        c1.get(index).setName(rename);
                        System.out.println(c1.get(index).getName());
                        savefile(s);
                        break;
                    case 3:
                        while (true) {
                            System.out.print("Enter new Phone number: ");
                            String NewNum = input.nextLine();
                            try {
                                int x = Integer.parseInt(NewNum);
                                c1.get(index).setMobilephone(NewNum);
                                showTable(c1.get(index));
                                break;
                            } catch (Exception e) {
                                System.out.println("Phone Number is not Valid, please enter again !");
                            }
                        }
                        savefile(s);
                        break;
                    case 2:
                        while (true) {
                            System.out.print("Enter new Email: ");
                            String Nemail = input.nextLine();
                            if (Nemail.contains("@")) {
                                c1.get(index).setEmail(Nemail);
                                showTable(c1.get(index));
                                break;
                            }
                            System.out.println("Email is not valid , please enter again !");
                        }
                        savefile(s);
                        break;
                    case 4:
                        System.out.println("Enter your rank: ");
                        int rerank = Integer.parseInt(input.nextLine().trim());
                        c1.get(index).setRank(rerank);
                        System.out.println(c1.get(index).getRank());
                        savefile(s);
                        break;
                    case 5:
                        System.out.println("Reenter your password: ");
                        String password = input.nextLine().trim();
                        while (password.equals(c.get(id)) == false) {
                            System.out.println("Your old password is incorrect");
                            System.out.println("Please reenter your old password: ");
                            password = input.nextLine().trim();

                        }
                        if (password.equals(c.get(id))) {
                            System.out.println("Success!!! ");
                            System.out.println("Enter your new password: ");
                            String repass = "";
                            while (true) {
                                repass = input.nextLine().trim();
                                if (repass.length() <= 15) {
                                    break;
                                }
                                System.out.println("length of pass must less than 15 ,please enter again!");
                            }
                            c1.get(index).setPassword(repass);
                            savefile(s);
                            LoadFile(s);
                            break;
                        }
//                    case 6:{
//                        System.out.print("Enter new name: ");
//                        String name=input.nextLine();
//                        c1.get(index).setName(name);
//                        showTable(c1.get(index));
//                        if(!check("Do you want to continue ?(Y/N): ")){
//                            break;
//                        }
//                        while(true){
//                        System.out.print("Enter new Email: ");
//                        String Nemail=input.nextLine();
//                        if(Nemail.contains("@")){
//                            c1.get(index).setEmail(Nemail);
//                            showTable(c1.get(index));
//                            break;
//                        }
//                            System.out.println("Email is not valid , please enter again !");
//                        }
//                        if(!check("Do you want to continue ?(Y/N): ")){
//                            break;
//                        }
//                        while(true){
//                        System.out.print("Enter new Phone number: ");
//                        String NewNum=input.nextLine();
//                            try {
//                                int x= Integer.parseInt(NewNum);
//                                c1.get(index).setMobilephone(NewNum);
//                                showTable(c1.get(index));
//                                break;
//                            } catch (Exception e) {
//                                System.out.println("Phone Number is not Valid, please enter again !");
//                            }
//                        }
//                            if(!check("Do you want to continue ?(Y/N): ")){
//                            break;
//                        }
//                             while(true){
//                        System.out.print("Enter new Rank: ");
//                        String NewNum=input.nextLine();
//                            try {
//                                int x= Integer.parseInt(NewNum);
//                                c1.get(index).setRank(x);
//                                showTable(c1.get(index));
//                                break;
//                            } catch (Exception e) {
//                                System.out.println("Rank is not Valid, please enter again !");
//                            }
//                        }
//                            if(!check("Do you want to continue ?(Y/N): ")){
//                            break;
//                        }
//                     System.out.print("Reenter your password: ");
//                        String pass = input.nextLine().trim();
//                        while (pass.equals(c.get(id)) == false) {
//                            System.out.println("Your old password is incorrect");
//                            System.out.print("Please reenter your old password: ");
//                            pass = input.nextLine().trim();
//                            
//                        }
//                        if(pass.equals(c.get(id)) ){
//                            System.out.println("Success!!! ");
//                            System.out.print("Enter your new password: ");
//                            String repass="";
//                            while(true){
//                          repass = input.nextLine().trim();
//                            if(repass.length() <=15 ) break;
//                                System.out.println("length of pass must less than 15 ,please enter again!");
//                            }
//                            c1.get(index).setPassword(repass); 
//                             savefile(s);
//                            LoadFile(s);
//                          break;
//                       
//                    }
                    case 6: {
                        showTable(c1.get(index));
                        System.out.println("Change all the Contestant's information");
                        System.out.println("Old Contestant's Id: " + c1.get(index).getId());
                        if (check("Do you want to change Id ?(Y/N): ")) {
                            System.out.print("Enter new ID: ");
                            String ID = input.nextLine().toLowerCase();
                            c1.get(index).setId(ID);
                            savefile(s);
                            LoadFile(s);
                            showTable(c1.get(index));
                        }

                        if (!check("Do you want to continue ?(Y/N): ")) {
                            break;
                        }
                        System.out.println("Old contestant's Name: "+c1.get(index).getName());
                        System.out.print("Enter new Name: ");
                        String name = input.nextLine();
                        c1.get(index).setName(name);
                        savefile(s);
                        LoadFile(s);
                        showTable(c1.get(index));
                        if (!check("Do you want to continue ?(Y/N): ")) {
                            break;
                        }
                        System.out.println("Old Contestant's Email: " + c1.get(index).getEmail());
                        if (check("Do you want to change Email ?(Y/N): ")) {
                            while (true) {
                                System.out.print("Enter new Email: ");
                                String Nemail = input.nextLine();
                                if (Nemail.contains("@")) {
                                    c1.get(index).setEmail(Nemail);
                                    savefile(s);
                                    LoadFile(s);
                                    showTable(c1.get(index));
                                    break;
                                }
                                System.out.println("Email is not valid , please enter again !");
                            }
                        }
                        if (!check("Do you want to continue ?(Y/N): ")) {
                            break;
                        }
                        System.out.println("Old Contestant's Phone number: " + c1.get(index).getMobilephone());
                        if (check("Do you want to change Phone number ?(Y/N): ")) {
                            while (true) {
                                System.out.print("Enter new Phone number: ");
                                String NewNum = input.nextLine();
                                try {
                                    int x = Integer.parseInt(NewNum);
                                    c1.get(index).setMobilephone(NewNum);
                                    savefile(s);
                                    LoadFile(s);
                                    showTable(c1.get(index));
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Phone Number is not Valid, please enter again !");
                                }
                            }
                        }
                        if (!check("Do you want to continue ?(Y/N): ")) {
                            break;
                        }
                        System.out.println("Old Contestant's rank: " + c1.get(index).getRank());
                        if (check("Do you want to change Contestant's Rank ?(Y/N): ")) {
                            while (true) {
                                System.out.print("Enter new Rank: ");
                                String NewNum = input.nextLine();
                                try {
                                    int x = Integer.parseInt(NewNum);
                                    c1.get(index).setRank(x);
                                    savefile(s);
                                    LoadFile(s);
                                    showTable(c1.get(index));
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Rank is not Valid, please enter again !");
                                }
                            }
                        }
                        if (!check("Do you want to continue ?(Y/N): ")) {
                            break;
                        }
                        if (check("Do you want to change Password ?(Y/N): ")) {
                            System.out.print("Reenter your password: ");
                            String pass = input.nextLine().trim();
                            while (pass.equals(c.get(id)) == false) {
                                System.out.println("Your old password is incorrect");
                                System.out.print("Please reenter your old password: ");
                                pass = input.nextLine().trim();

                            }
                            if (pass.equals(c.get(id))) {
                                System.out.println("Success!!! ");
                                System.out.print("Enter your new password: ");
                                String repass = "";
                                while (true) {
                                    repass = input.nextLine().trim();
                                    if (repass.length() <= 15) {
                                        break;
                                    }
                                    System.out.println("length of pass must less than 15 ,please enter again!");
                                }
                                c1.get(index).setPassword(repass);
                                savefile(s);
                                LoadFile(s);
                                showTable(c1.get(index));
                            }
                        }
                        if (!check("Do you want to continue ?(Y/N): ")) {
                            break;
                        }
                    }
                    case 0:
                        return;
                }
            }

        }
    }

    public boolean login(String id, String pw) throws IOException {
        LoadFile(s);
        if (c.containsKey(id)) {
            if (pw.equals(c.get(id))) {
                for (Contestant i : c1) {
                    if (i.getId().compareTo(id) == 0) {
                        setNameInfo(i.getName());
                    }
                }
                return true;
            }
        }
        return false;

    }

    public void setNameInfo(String nameInfo) {
        this.nameInfo = nameInfo;
    }

    public String getNameInfo() {
        return nameInfo;
    }

    public void print() {
        for (String i : c.keySet()) {
            System.out.println(i + "\t" + c.get(i));
        }
    }

    public void print2() {
        for (int i = 0; i < c1.size(); i++) {
            System.out.println(c1.get(i));
        }
    }

    public void showInfor(String id) {
        int index = 0;
        for (int i = 0; i < c1.size(); i++) {
            if (id.equals(c1.get(i).getId())) {
                index = i;
                System.out.println("==========Contestant's Informations==========");
                System.out.println(c1.get(i).toString());
                System.out.println("==============================================");
                break;
            }
        }
    }
}
