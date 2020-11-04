package Cms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class ContestantMethod {

    public HashMap<String, String> c = new HashMap<String, String>();

    public void LoadFile(String file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String s1[];
        String id;
        String password;
        while (true) {
            s = br.readLine();
            if (s == null) {
                break;
            }
                s1 = s.split("|");
                id = s1[1];
                password = s1[2];
                c.put(id, password);
            }
         fr.close();
         br.close();
        }
    public void add(String file) throws IOException{
      FileWriter fw = new FileWriter(file);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(fw);
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of Contestants you want to add: ");
      int nu = input.nextInt();
      for(int i = 0; i < nu; i++){
          System.out.println("Enter the information of Contestants: ");
          System.out.print("Enter Name: ");
          String name = input.next();
          System.out.print("Enter Contestant's Id: ");
          String id = input.next();
          System.out.print("Enter Password: ");
          String password = input.next();
          System.out.print("Enter Email: ");
          String email = input.next();
          System.out.println("Enter Phonenumber: ");
          String phonenumber = input.next();
          System.out.println("Enter rank: ");
          int rank = input.nextInt();
          Contestant m = new Contestant(name, id, password, email, phonenumber, rank);
          pw.println(m);
      }     
          LoadFile(file);
          bw.close();
      
    }
    public boolean login(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your id: ");
        String uid = input.next();
        System.out.print("Enter your password: ");
        String upw = input.next();
        if (c.containsKey(uid)) {
            if(upw == c.get(uid)){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }      
    }
    
    public void print() {
        for (String i : c.keySet()) {
            System.out.println(i + ": " + c.get(i));
        }
    }
    }

   
