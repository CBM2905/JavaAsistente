/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.necesidad;
import View.navegacion;
import Model.Modelo;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
/**
 *
 * @author User
 */
public class ControladorNavegacion {
    Modelo model;
    navegacion navegacionVista = new navegacion();
    necesidad necesidadVista;
    AudioClip Sound;
    public ControladorNavegacion(Modelo model, navegacion navegacionVista, necesidad necesidadVista){
        this.model = model;
        this.navegacionVista = navegacionVista;
        this.mostrarVista();
    }
    public void mostrarVista(){
        this.navegacionVista.show(true);
         navegacionVista.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegacionVista.show(false);
                new ControladorNecesidad(model,navegacionVista);
                if (Sound != null) {
                    Sound.stop();
                }
            }
        });
         navegacionVista.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.insertOnSesion(new Date());
                System.exit(0);
            }
        });
        navegacionVista.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/audio_herramientas.wav"));
                Sound.play();
            }
        });
    }
}
