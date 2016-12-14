/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioclimatico;
import java.io.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class Medicion extends Thread{
    
    ServerSocket serverSocket;
    Socket sk;
    long timeMax;
    int inf;
    int sup;
    int puerto;
    String servicio; 
    JLabel lblsrv;
    
    public Medicion(int puerto,long timeMax, int inf, int sup, JLabel lblsrv,String servicio) throws IOException{
        serverSocket = new ServerSocket(puerto);
        this.inf=inf;
        this.sup=sup;
        this.puerto=puerto;
        this.timeMax=timeMax;
        this.servicio=servicio;
        this.lblsrv=lblsrv;
    }
    
    @Override
    public void run(){
     
	try{
            lblsrv.setText("Esperando Conexion servidor de "+servicio+" Puerto: "+puerto);
            sk=serverSocket.accept();
            ObjectOutputStream oos=new ObjectOutputStream(sk.getOutputStream());
            int num;       
            
            while(!sk.isClosed()){
                //oos=new ObjectOutputStream(sk.getOutputStream());
                num=(int)Math.floor(Math.random()*(sup-inf)+inf);
                oos.writeObject(num);
               
                lblsrv.setText("Ultima medicion de "+servicio+" enviada: "+num);
                
                 Thread.yield();
                
                try {
                    Thread.sleep((int)Math.floor(Math.random()*(timeMax-1000)+1000));
                } catch (InterruptedException ex) {}                              
                    
            }
            oos.close();
            sk.close();
            serverSocket.close();
            lblsrv.setText("Cerrando Conexion :"+servicio+"...");
        }catch(IOException ioe){
            try {
                ioe.printStackTrace();
                sk.close();
                serverSocket.close();
                lblsrv.setText("Cerrando Conexion :"+servicio+"...");
            } catch (IOException ex) { }
        }
        
    }
    
}