package Logic;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class MouseMover {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;

    
    
    
    
    public static void main(String... args) throws Exception {
        int oz=0,nz=0,diffx=0;
        int ox=0,nx=0,diffy=0;
        int oy=0,ny=0,diffz=0;
        boolean flag=false;
        Robot robot = new Robot();
      ///  Random random = new Random();
        while (true) {
            String st="",data="";
               File file = new File("D:/screen.txt"); 
                    
                    BufferedReader br = new BufferedReader(new FileReader(file)); 
  
                   
                   while ((st = br.readLine()) != null) 
                   {
                   System.out.println(st);
                   data=st;
                   }
            String a[]=data.split(":");
            if(a.length>1)
            {
                
            nx=Integer.parseInt(a[0]);
             diffx=Math.abs(nx-ox);
            System.out.println("diffx="+diffx);
            ox=nx;
            
             ny=Integer.parseInt(a[1]);
             diffy=Math.abs(ny-oy);
            System.out.println("diffy="+diffy);
            oy=ny;    
                
                
            nz=Integer.parseInt(a[2]);
             diffz=Math.abs(nz-oz);
            System.out.println("diffz="+diffz);
            oz=nz;
            if(diffz>3)
            {
            flag=true;
            System.out.println("flag="+flag);
            
            }
            
            }
            if(diffx>1 && diffy>1)
            {
           // robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            robot.mouseMove(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
            }
            if(flag)
            {
             robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            flag=false;
            
            
            }
           
            Thread.sleep(1000);
        }
    }
}