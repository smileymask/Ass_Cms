/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cms;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String s = "Test2.txt";
        ContestantMethod mynk1 = new ContestantMethod();
        Scanner sc = new Scanner(System.in);
        mynk1.LoadFile(s);
        while (true) {
            System.out.println(" 1.Login ");
            System.out.println(" 2.List the hashmap");
            System.out.println(" 3.List the ArrayList");
            System.out.println(" 0.Exit");
            System.out.print(" Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    if (mynk1.login() == true) {
                        System.out.println("Success");
                        System.out.println("Do you want to change Contestant informations Y/N ");
                        String ch = sc.nextLine();
                        if (ch.equals("Y")) {
                            while (true) {
                                System.out.println("1. Change data");
                                System.out.println("2. Exit");
                                int choice2 = Integer.parseInt(sc.nextLine());
                                switch (choice2) {
                                    case 1:
                                        mynk1.changeData(s);
                                        break;
                                    case 2:
                                        return;
                                }
                            }
                        } else {
                            break;
                        }

                    } else {
                        System.out.println("Please check your Id and Pasword ");
                    }
                    break;
                case 2:
                    mynk1.print();
                    break;
                case 3:
                    mynk1.print2();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
