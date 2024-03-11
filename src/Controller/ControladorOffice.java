/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.necesidad;
import View.office;
import Model.Modelo;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
/**
 *
 * @author User
 */
public class ControladorOffice {
    Modelo model;
    office officeVista = new office();
    necesidad necesidadVista;
    AudioClip Sound;
    public ControladorOffice(Modelo model,necesidad necesidadVista){
        this.model = model;
        this.necesidadVista = necesidadVista;
        this.mostrarVista();
    }
    public void mostrarVista(){
        this.officeVista.show(true);
            officeVista.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                officeVista.show(false);
                new ControladorNecesidad(model, officeVista);
                if (Sound != null) {
                    Sound.stop();
                }
            }
        });
         officeVista.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.insertOnSesion(new Date());
                System.exit(0);
            }
        });
        officeVista.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/audio_herramientas.wav"));
                Sound.play();
            }
        });
    }
}
