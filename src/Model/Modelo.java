/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author User
 */
public class Modelo {   
    String strcon = "jdbc:mysql://localhost:3306/test";
    Date start = new Date();
    int cedula = 122;
   
    
    public Modelo(){
        System.out.println("Model Created ...");
    }
    public Connection connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Upload");
            Connection con = DriverManager.getConnection(strcon,"root","root");
            System.out.println("Connected to db");
            return con;
        }
        catch(Exception e){
            // Mostrar
            System.out.println("No connected");
        }
        return null;
    }
    
    public void closeConnection(Connection con){
        try{
            con.close();
        }
        catch(SQLException e){
            //
        }
    }
    
    public int InsertOnUser(int cedula, String nombre){
        try {
            Connection con = this.connection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO USER VALUES (?,?)");
            stm.setInt(1,cedula);
            stm.setString(2, nombre);
            stm.execute();
            this.closeConnection(con);
            System.out.println("Register Insert");
            return 1;
        }
        catch(Exception e){
            System.out.println("no se pudo conectar");
            return 0;
        }
    }
    
    public void setSesion(Date sesionStart){
        this.start = sesionStart;
    }
    public void setCedula(int cedula){
        this.cedula = cedula;
    }
    
    public double time(Date incio, Date termina){
        double totalHours;
        int first = incio.getDate();
        int last = termina.getDate();
        if(true){
            System.out.println("el mismo dia del mes");
            double horas = termina.getHours() - incio.getHours();
            double mins = termina.getMinutes() - incio.getMinutes();
            double sec = termina.getSeconds() - incio.getSeconds();
            totalHours = horas + ((mins)/60) + ((sec)/3600);
        }
        else{
             totalHours = (24 - incio.getHours()) + ((59 - incio.getMinutes())/60);
             for(int i = 0;i < (termina.getDate() - incio.getDate());i = i + 1){
                if(i == (termina.getDate() - incio.getDate())){
                    totalHours = totalHours + termina.getHours() + (termina.getHours())/60;
                }
                totalHours = totalHours + 23 + 59/60;
             }
        }
        return totalHours;
    }
    
    public int insertOnSesion(Date endSesion){
        try{
        Connection con = this.connection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO SESION (TIEMPO,FECHA,CEDULA_USER,FECHA_FIN) VALUES (?,?,?,?)");
        System.out.println("her ");
        stm.setDouble(1,this.time(this.start,endSesion));
        System.out.println("heree ");
        System.out.println(" tiempo: " + this.time(this.start, endSesion) + " primer ->" + this.start.getYear() + "Segundo ->" + endSesion );
        stm.setString(2,this.start.getYear()+1900 + "-" + this.start.getMonth() + "-" + this.start.getDate());
        stm.setInt(3,this.cedula);
        stm.setString(4,endSesion.getYear() + 1900 + "-" + endSesion.getMonth() + "-" + endSesion.getDate());
        stm.execute();
        this.closeConnection(con);
        return 1;
        }
        catch(Exception e){
            System.out.println("no se pudo entrega ingresar en sesion" + e.getMessage());
            return 0;
        }
    }
    
    public int buscarUsuario(int cedula,String nombre){
        try{
        Connection con = this.connection();
        PreparedStatement stm = con.prepareStatement("SELECT * FROM USER WHERE CEDULA = ?");
        System.out.println("·here ");
        stm.setInt(1, cedula);
        System.out.println(" hereee");
        ResultSet res = stm.executeQuery();
        System.out.println("aqui esto");
        if(res.next()){
            return 1;
        }
        return 0;
        }
       
        catch(Exception e){
           //s
                System.out.println(e);
                return 0;
        }
    }
}