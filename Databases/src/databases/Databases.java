package databases;
import java.io.*;
import java.sql.*;

public class Databases {
    public static void main(String[] args) {
        Connection conn = null;
        try{
            //Make sure to add the following to the cheat-sheet:
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://172.16.11.22/cs3913";
            //End of absolutely necessary for cheat-sheet.
            String dbuser = "cs3913";
            String password = "abc123";
            conn = DriverManager.getConnection(url, dbuser, password);
            Statement s = conn.createStatement();
            //s.execute("INSERT INTO studentmottos (id, name, motto) VALUES ('542492669', 'Keaton Smith', 'A spectre is haunting Europe — the spectre of communism. All the powers of old Europe have entered into a holy alliance to exorcise this spectre: Pope and Tsar, Metternich and Guizot, French Radicals and German police-spies. Where is the party in opposition that has not been decried as communistic by its opponents in power? Where is the opposition that has not hurled back the branding reproach of communism, against the more advanced opposition parties, as well as against its reactionary adversaries?');");
            s.executeQuery("select * from studentmottos;");
            ResultSet rs = s.getResultSet();
            while(rs.next()){
                int id = rs.getInt("id");
                //int id = rs.getInt(1);
                String name = rs.getString("name");
                String motto = rs.getString("motto");
                System.out.println(id+" "+name+" "+motto);
            }
            s.close();
            conn.close();
        }catch (Exception e){
            System.out.println("Error: Something BAD Happened: "+e.toString());
        }
    }
}
