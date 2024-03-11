/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Modelo;
import View.primera;
import View.registro;
import java.applet.AudioClip;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class ControladorPrimera {
    
    Modelo model;
    primera primeraVista;
    registro registroVista;
    AudioClip Sound;
    public ControladorPrimera(Modelo model, primera primeraVista, registro registroVista) {
        this.model = model;
        this.primeraVista = primeraVista;
        this.registroVista = registroVista;
    }

    public void mostrarVista() {
        primeraVista.show(true);
        primeraVista.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("mostrar");
                if(registroVista == null){
                       ControladorRegistro con =  new ControladorRegistro(model,primeraVista,null,null);
                       System.out.println(" fir null ");
                }
                else{
                    primeraVista.show(false);
                    registroVista.show();
                }
            }
        });
        primeraVista.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Sound != null) {
                    Sound.stop();
                }
                Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/audio_primera.wav"));
                Sound.play();
            }
        });
        primeraVista.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
}
