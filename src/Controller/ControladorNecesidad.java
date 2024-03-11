/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Modelo;
import View.registro;
import View.instruccion;
import View.necesidad;
import View.office;
import View.navegacion;
import View.herramientas;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author User
 */
public class ControladorNecesidad {

    public ControladorNecesidad(Modelo model1, registro registroVista1) {
        this.model = model1;
        this.registroVista = registroVista1;
        this.mostrarVista();
    }
    public ControladorNecesidad(Modelo model, herramientas herramientasVista){
        this.model = model;
        this.herramientasVista = herramientasVista;
        this.mostrarVista();
    }
    public ControladorNecesidad(Modelo model, office officeVista){
        this.model = model;
        this.officeVista = officeVista;
        this.mostrarVista();
    }
    public ControladorNecesidad(Modelo model, navegacion navegacionVista){
        this.model = model;
        this.navegacionVista = navegacionVista;
        this.mostrarVista();
    }

    
    Modelo model;
    registro registroVista;
    herramientas herramientasVista = null;
    office officeVista = null;
    navegacion navegacionVista = null;
    necesidad necesidadVista = new necesidad();
    AudioClip Sound;
    public void ControladorNecesidad(Modelo model1,registro registroVista1){
        this.model = model1;
        this.registroVista = registroVista1;
        this.mostrarVista();
    }
    public void mostrarVista(){
        necesidadVista.show();
        necesidadVista.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                necesidadVista.show(false);
                registroVista.show(true);
                if (Sound != null) {
                    Sound.stop();
                }
            }
        });
        necesidadVista.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.insertOnSesion(new Date());
                System.exit(0);
            }
        });
        necesidadVista.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/audio_necesidad.wav"));
                Sound.play();
            }
        });
        necesidadVista.jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(officeVista == null){
                    necesidadVista.show(false);
                    new ControladorOffice(model,necesidadVista);
                }
                else{
                    necesidadVista.show(false);
                    officeVista.show(true);
                }
                //necesidad.dispose();
                //iniciaroffice();
                if (Sound != null) {
                    Sound.stop();
                }
            }
        });
        necesidadVista.jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(navegacionVista == null){
                    necesidadVista.show(false);
                    new ControladorOffice(model,necesidadVista);
                }
                else{
                     necesidadVista.show(false);
                    navegacionVista.show(true);
                }
                //necesidad.dispose();
                //iniciarnavegacion();
                if (Sound != null) {
                    Sound.stop();
                }
            }
        });
        necesidadVista.jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(herramientasVista == null){
                    necesidadVista.show(false);
                    new ControladorHerramientas(model,necesidadVista);
                }
                else{
                     necesidadVista.show(false);
                    herramientasVista.show(true);
                }
                //necesidad.dispose();
                //iniciarherramientas();
                if (Sound != null) {
                    Sound.stop();
                }
            }
        });
    }
}
