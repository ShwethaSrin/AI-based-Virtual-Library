/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.key1.keyInput;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fgfdg
 */
public class test {
    static int keyInput[] = { KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_W,
      KeyEvent.VK_X };
    public static void main(String[] args) {
        while(true)
        {
             
        try {
            Robot robot = new Robot();
            BufferedReader br1 = null;
            File file1 = new File("E:/test.txt");
            br1 = new BufferedReader(new FileReader(file1));
            String st1="",fdata1="";
            
                while ((st1 = br1.readLine()) != null)
                {
                    System.out.println(st1);    
                    fdata1=st1;
                }
                if(fdata1.equalsIgnoreCase("r"))
                {
                    robot.keyPress(keyInput[0]);
                    robot.delay(100);
                }
                else if(fdata1.equalsIgnoreCase("l"))
                {
                    robot.keyPress(keyInput[1]);
                    robot.delay(100);
                }
                else if(fdata1.equalsIgnoreCase("f"))
                {
                    robot.keyPress(keyInput[2]);
                    robot.delay(100);
                }
                else if(fdata1.equalsIgnoreCase("b"))
                {
                    robot.keyPress(keyInput[3]);
                    robot.delay(100);
                }
                FileWriter fw=new FileWriter(file1);
                fw.write("");
                fw.close();
                br1.close();
            } catch (Exception ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
}
