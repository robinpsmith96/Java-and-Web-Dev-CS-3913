package networking;

import java.util.*;
import java.net.*;
import java.io.*;
import static networking.Networking.portNum;

public class Networking {
    static int portNum = 1234;
    public static void main(String[] args) {
        try{
            Socket s = new Socket("172.16.13.46", 1234);
            if(s.isConnected()){
                Scanner sin = new Scanner(s.getInputStream());
                PrintStream sout = new PrintStream(s.getOutputStream());
                String line = sin.nextLine();
                System.out.println(line);
                line = line.substring(4);
                int x = Integer.parseInt(line);
                x += 4367;
                sout.print(x+" 10342349");
                System.out.println(x);
            }
            else{
                System.out.println("Socket connection failed!");
            }
        }catch (IOException ex){
            
        }
        /*ServerSocket ss = null;
        try{
            ss = new ServerSocket(portNum);
            while (true){
                System.out.println("Waiting for a connection on port "+portNum);
                Socket client  = ss.accept();
                System.out.println("Connection from: "+client.getInetAddress().toString());
                Scanner sin = new Scanner(client.getInputStream());
                PrintStream sout = new PrintStream(client.getOutputStream());
                
                String line = "";
                while(!line.equals("DONE")){
                    line = sin.nextLine();
                    System.out.println("Client said: "+line);
                    sout.println(line);
                }
            }
        }catch (IOException ex){
            System.out.println("COuld not get the socket.");
        }*/
    }
}

/*class ProcessConnection extends Thread{
    Socket client;
    ProcessConnection (Socket news){
        client = news;
    }
    public void run(){
        try{
            ss = new ServerSocket(portNum);
            while (true){
                System.out.println("Waiting for a connection on port "+portNum);
                Socket client  = ss.accept();
                System.out.println("Connection from: "+client.getInetAddress().toString());
                Scanner sin = new Scanner(client.getInputStream());
                PrintStream sout = new PrintStream(client.getOutputStream());
                sout.println("Welcome to my Echo server.");
                String line = "";
                while(!line.equals("DONE")){
                    line = sin.nextLine();
                    System.out.println("Client said: "+line);
                    sout.println(line);
                }
            }
        }catch (IOException ex){
            System.out.println("COuld not get the socket.");
        }
    }
}
*/