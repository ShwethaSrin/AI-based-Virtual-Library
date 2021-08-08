/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
    import java.awt.Robot;
import java.awt.event.KeyEvent;
/**
 *
 * @author fgfdg
 */
public class keyboard_test {
    public static void main(String[] args) {
    
try{
Robot r = new Robot();
int keyCode = KeyEvent.VK_A; // the A key
r.keyPress(keyCode);

// later...
r.keyRelease(keyCode);
    }
    catch(Exception e)
    {
    e.printStackTrace();
    
    }
    }
}
