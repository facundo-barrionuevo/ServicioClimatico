package servicioclimatico;

import java.io.* ;
import java.net.* ;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

public class cliente {
    HIloTemperatura temp;
    int puerto;
    Socket skCliente;
    FormCliente form;
    ObjectInputStream ois;
    InputStream is;
    static final String HOST = "localhost";
    boolean abierto;
    
    public cliente(int puert) throws IOException {
        this.form = new FormCliente();
        this.form.setVisible(true);
        this.puerto = puert;
        this.skCliente = new Socket( HOST , this.puerto );
        this.abierto = true;
        /*this.is = this.skCliente.getInputStream();
        this.ois = new ObjectInputStream(this.is);*/
        
    }
    
}
