/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Modelo;
import View.registro;
import View.instruccion;
import View.necesidad;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
/**
 *
 * @author User
 */
public class ControladorInstruccion {
    Modelo model;
    registro registroVista;
    instruccion instruccionVista = new instruccion( );
    necesidad necesidadVista;
    String name;
    AudioClip Sound;
    public ControladorInstruccion(Modelo model, registro registroVista,necesidad necesidadVista, String name){
        this.model = model;
        this.registroVista = registroVista;
        this.instruccionVista = instruccionVista;
        this.necesidadVista = necesidadVista;
        this.name = name;
        this.mostrarVista();
    }
    public void mostrarVista(){
        this.instruccionVista.show(true);
        this.instruccionVista.setJlabel1(this.name);
        instruccionVista.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                instruccionVista.show(false);
                registroVista.show(true);
                 
                if (Sound != null) {
                    Sound.stop();
                }
            }
        });
        instruccionVista.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.insertOnSesion(fechaAhora());
                System.exit(0);
            }
        });
        instruccionVista.jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instruccionVista.show(false);
                new ControladorNecesidad(model, registroVista);
                if (Sound != null) {
                    Sound.stop();
                }
            }
        });
    }
    public Date fechaAhora(){
        return new Date();
    }
}
