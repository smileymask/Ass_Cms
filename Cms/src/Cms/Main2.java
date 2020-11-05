/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cms;

import java.io.IOException;

/**
 *
 * @author DELL
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        ContestantMethod m = new ContestantMethod();
        String s = "Test2.txt";
        m.LoadFile(s);
        m.savefile(s);
        m.changeData(s);
        
    }
}
