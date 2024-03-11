/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.necesidad;
import View.herramientas;
import Model.Modelo;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
/**
 *
 * @author User
 */
public class ControladorHerramientas {
    Modelo model;
    herramientas herramientasVista = new herramientas();
    necesidad necesidadVista;
    AudioClip Sound;
    public ControladorHerramientas(Modelo model, necesidad necesidadVista){
        this.model = model;
        this.necesidadVista = necesidadVista;
        this.mostrarVista();
    }
    public void mostrarVista(){
        this.herramientasVista.show(true);
         herramientasVista.jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                herramientasVista.show(false);
                new ControladorNecesidad(model, herramientasVista);
                if (Sound != null) {
                    Sound.stop();
                }
            }
        });
         herramientasVista.jButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.insertOnSesion(new Date());
                System.exit(0);
            }
        });
        herramientasVista.jButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/audio_herramientas.wav"));
                Sound.play();
            }
        });
    }
}
