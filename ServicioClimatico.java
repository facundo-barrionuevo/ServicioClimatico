
package servicioclimatico;

import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ServicioClimatico extends JFrame{
    
    Medicion temperatura;
    Medicion presion;
    Medicion humedadad;
    Medicion viento;
    JLabel lbltemp;
    JLabel lblpre;
    JLabel lblhum;
    JLabel lblvie;
    
    public ServicioClimatico() throws IOException{
        
        super("Servidor Climatico");
        
        lbltemp=new JLabel();
        lblpre=new JLabel();
        lblhum=new JLabel();
        lblvie=new JLabel();
        
        int puertoBase=(int)Math.floor(Math.random()*(20000-10000)+10000);
        
        temperatura=new Medicion(puertoBase,5000, 0, 40, lbltemp,"Temperatura");
        presion=new Medicion(puertoBase+1,5000, 900, 1000, lblpre,"Presion");
        humedadad=new Medicion(puertoBase+2,5000, 1, 100, lblhum, "Humedadad");
        viento=new Medicion(puertoBase+3,5000, 2, 80, lblvie,"Viento");
                
       
        this.setLayout(new GridLayout(4,1));
        this.add(lbltemp);
        this.add(lblpre);
        this.add(lblhum);
        this.add(lblvie);
        
        this.setSize(450,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        temperatura.start();
        presion.start();
        humedadad.start();
        viento.start();
    }
    
    public static void main(String[] args) throws IOException {
        new ServicioClimatico();
    }
}