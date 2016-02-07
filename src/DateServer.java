
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trevoralbrethsen
 */
public class DateServer {
    
    ServerSocket server;
    Socket c1;
    ObjectOutputStream out;
    ObjectInputStream in;
    public DateServer()
    {
        try
        {
            server = new ServerSocket(8808);
            while(true)
            {
                c1 = server.accept();
                out = new ObjectOutputStream(c1.getOutputStream());
                in = new ObjectInputStream(c1.getInputStream());
                String x = (String) in.readObject();
                if(x.equalsIgnoreCase("time"))
                {
                    out.writeObject(new Date());
                }
                else
                {
                    out.writeObject("wrong request");
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new DateServer();
    }
    
}
