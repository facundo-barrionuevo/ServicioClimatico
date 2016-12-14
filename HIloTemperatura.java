package servicioclimatico;

import java.io.* ;
import java.net.* ;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HIloTemperatura extends Thread {
    FormCliente form;
    String id;
    Socket sock;
    ObjectInputStream lugarreceptor;
    InputStream receptor;
    cliente cliente;
    
    public HIloTemperatura(FormCliente frm, cliente a) throws IOException{
        form = frm;
        this.cliente = a;
        this.lugarreceptor = a.ois;
        this.receptor = a.is;
    }
    
    public void run(){
            int aux;
    int msj = 1;
    try{
        while(this.cliente.abierto){  
                    this.receptor = this.cliente.skCliente.getInputStream();
                    lugarreceptor = new ObjectInputStream(receptor);
                    aux = this.lugarreceptor.read();
                    form.lbltemperatura.setText(String.valueOf(aux));
                    System.out.println(aux);
                    this.yield();
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
