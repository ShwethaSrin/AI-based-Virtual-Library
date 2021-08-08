package Logic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Receiver {
    
 public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(8000);
        try{
            while(true){
                Socket socket = listener.accept();
                socket.setKeepAlive(true);
                System.out.println("Client Connected");
                try{
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String status=in.readLine();
                    System.out.println("Client response: " + status);

                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                   
                   
               //    File file1 = new File("C:/Users/Asus/Downloads/TS/data.txt"); 
                   File file1 = new File("C:/Users/Asus/Desktop/mouse_keyboard/input.txt"); 
                   FileOutputStream fout1=new FileOutputStream(file1);
                  // System.out.println("sending: " + status);
                   fout1.write(status.getBytes());
                   fout1.close();
                 
                  

                   
                    out.flush();
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }

}
