//This code is mine.
//Keaton Smith

package chat.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    static int portNum = 5190;
    public static void main(String[] args) {
        ServerSocket ss = null;
        try{
            ss = new ServerSocket(portNum);
            while (true){
                Socket client = ss.accept();
                new ProcessConnection(client).start();
            }
        }catch (IOException ex){
            System.out.println("Could not get the socket!");
        }
    }
}

class ProcessConnection extends Thread{
    static ArrayList<ProcessConnection> users = new ArrayList<ProcessConnection>();
    Socket client;
    String id;
    ProcessConnection(Socket news){
        client = news;
    }
    public void run(){
        try{
            Scanner sin = new Scanner(client.getInputStream());
            String line = "";
            id = sin.nextLine();
            users.add(this);
            while (!line.equals("DONE")){
                line = sin.nextLine();
                for(ProcessConnection p : users){
                    p.send(line, id);
                }
            }
            client.close();
        }catch (IOException ex){
            
        }
    }
    public void send(String s, String u){
        try{
            PrintStream sout = new PrintStream(client.getOutputStream());
            sout.println(u+": "+s);
        } catch (IOException e){
            
        }
    }
}
