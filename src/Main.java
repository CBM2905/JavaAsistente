// import static org.junit.jupiter.api.Assertions.assertEquals;
import java.sql.Connection;
import java.sql.DriverManager;
import Controller.ControladorPrimera;
import Model.Modelo;
import View.primera;
import View.registro;
import Controller.ControladorRegistro;
import javax.swing.JOptionPane;
// import org.junit.jupiter.api.Test;

public class Main {

    public static void main(String[] args) {
        /*       try{
    Class.forName("my.sql.jdbc.Driver");
    System.out.println("here");
    Connection con = DriverManager.getConnection("JDBC:mysql://45.238.182.247/test" + "user=root2&password=root2");
    System.out.println("Hello world!");
      System.out.println(con.getClientInfo());
      System.out.println("Hello your connected");
    }|
    catch(Exception e){
      System.out.println(e);
    }*/
        
        Modelo model = new Modelo();
        primera primeraVista = new primera();
        ControladorPrimera conprimera = new ControladorPrimera(model,primeraVista ,null);
        conprimera.mostrarVista();

    }
}


//
