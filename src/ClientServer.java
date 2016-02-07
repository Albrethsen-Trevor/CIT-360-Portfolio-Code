
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trevoralbrethsen
 */
public class ClientServer {
    Socket server;
    ObjectOutputStream out;
    ObjectInputStream in;
    public ClientServer()
    {
        try
        {
        server = new Socket("localhost", 8808);
            Scanner key = new Scanner(System.in);
            out = new ObjectOutputStream(server.getOutputStream());
            in = new ObjectInputStream(server.getInputStream());
            System.out.print("Enter your request:");
            String req = key.next();
            out.writeObject(req);
            Object o = in.readObject();
            if(o instanceof Date)
            {
                Date x = (Date)o;
                System.out.print(x);
            }
            else
            {
                String x = (String)o;
                System.out.println(x.toUpperCase());
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new ClientServer();
    }
            
}
