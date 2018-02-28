//Keaton Smith kps325

package homes;

import java.util.*;

class Home{
    ArrayList<Room> r;
    double numberOfBathrooms(){
        double count = 0.0;
        for(Room rm : r){
            if(rm.type.equals("Bath")){
                count++;
            }
        }
        return count;
    }
    int numberOfBedrooms(){
        int count = 0;
        for(Room rm : r){
            if(rm.type.equals("Bed")){
                count++;
            }
        }
        return count;
    }
    int squareFootage(){
        int inArea = 0;
        for(Room rm : r){
            if(!(rm.type.equals("Out") || rm.type.equals("Other"))){
                inArea += (rm.length * rm.width);
            }
        }
        return inArea;
    }
    int squareFootageTotal(){
        int area = 0;
        for(Room rm : r){
            area += (rm.length * rm.width);
        }
        return area;
    }
}

class Room extends Home{
    int length, width;
    String type;
}

class Bedroom extends Room implements Sleepable{
    Bedroom(int l, int w){
        length = l;
        width = w;
        type = "Bed";
    }
    @Override
    public void Sleep(){
        System.out.println("ZZZzzzzZZZ");
    }
}

class Bathroom extends Room{
    double hOrF;
    Bathroom(int l, int w, double t){
        length = l;
        width = w;
        hOrF = t;
        type = "Bath";
    }
}

class Common extends Room{}

class Living extends Common implements Sleepable{
    Living(int l, int w){
        length = l;
        width = w;
        type = "Live";
    }
    @Override
    public void Sleep(){
        System.out.println("zzzZZZZzzz");
    }
}

class Dining extends Common{
    Dining(int l, int w){
        length = l;
        width = w;
        type = "Dine";
    }
}

class Family extends Common{
    Family(int l, int w){
        length = l;
        width = w;
        type = "Fam is Lit";
    }
}

class Outdoor extends Room{
    Outdoor(int l, int w){
        length = l;
        width = w;
        type = "Out";
    }
}

class Other extends Room{
    Other(int l, int w){
        length = l;
        width = w;
        type = "Other";
    }
}

interface Sleepable{
    void Sleep();
}

public class Homes {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
