package servicioclimatico;
import java.io.*;

public class Main {
ServicioClimatico Servidor;
cliente cliente;
HIloTemperatura temp;


    public Main() throws IOException{
        Servidor = new ServicioClimatico();
        cliente = new cliente(Servidor.temperatura.puerto);
        temp = new HIloTemperatura(cliente.form, cliente);
        
    }
    
    public static void main(String[] args) throws IOException {
        Main a = new Main();
        a.temp.start();
    }
    
}
