/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import java.awt.AWTException;
 import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
/**
 *
 * @author fgfdg
 */
public class key1 {
     static int keyInput[] = { KeyEvent.VK_G, KeyEvent.VK_O, KeyEvent.VK_L,
      KeyEvent.VK_U, KeyEvent.VK_SPACE };
    public static void main(String[] args) throws IOException, AWTException {




    Runtime.getRuntime().exec("notepad");

    Robot robot = new Robot();
    for (int i = 0; i < keyInput.length; i++) {
      robot.keyPress(keyInput[i]);
      robot.delay(100);
    }
  }
    }

