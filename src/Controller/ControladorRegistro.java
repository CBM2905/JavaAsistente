/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Modelo;
import View.registro;
import View.primera;
import View.instruccion;
import View.necesidad;
import java.applet.AudioClip;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author User
 */
public class ControladorRegistro {

    public ControladorRegistro(Modelo model1, primera primeraVista1, necesidad necesidadVista, instruccion instruccionVista) {
        System.out.println("here is");
        this.model = model1;
        this.primeraVista = primeraVista1;
        this.primeraVista.show(false);
        this.mostrarVista();
    }

    Modelo model;
    registro registroVista = new registro();
    primera primeraVista;
    necesidad necesidadVista;
    instruccion instruccionVista;

    public void ControladorRegistro(Modelo modelo1, primera primeraVista1, necesidad necesidadVista, instruccion instruccionVista) {
        System.out.println("here is");
        this.model = modelo1;
        this.primeraVista = primeraVista1;
        this.necesidadVista = necesidadVista;
        this.instruccionVista = instruccionVista;
        this.primeraVista.show(false);
        this.mostrarVista();
    }

    public void mostrarVista() {
        this.registroVista.show(true);
        registroVista.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroVista.show(false);
                primeraVista.show();
            }
        });
        registroVista.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.insertOnSesion(new Date());
                System.exit(0);
            }
        });
        registroVista.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AudioClip SoundRegistro;
                SoundRegistro = java.applet.Applet.newAudioClip(getClass().getResource("/audio/audio_registro.wav"));
                SoundRegistro.play();
            }
        });
        registroVista.jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nam = (String) registroVista.jTextField3.getText();
                    System.out.println(nam + ": ");
                    int ced = Integer.parseInt(registroVista.jTextField1.getText());
                    System.out.println(ced + " : " + nam);
                    if (model.InsertOnUser(ced, nam) == 0) {
                        // Llamar vista para mostrar lo que se debe realizar
                        registroVista.mostrarAlerta("Error en datos");
                    } else {
                        model.setSesion(fechaAhora());
                        model.setCedula(ced);
                        //iniciarinstruccion("Hola " + nam + " ya estas mas cerca de aprender a usar tu computadora");
                        if (instruccionVista == null) {
                            registroVista.show(false);
                            new ControladorInstruccion(model, registroVista, null, "Hola " + nam + " ya estas mas cerca de aprender a usar tu computadora");
                        } else {
                            registroVista.show(false);
                            instruccionVista.show(true);
                        }

                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Datos Dañados");
                    registroVista.mostrarAlerta("Error en datos");
                }
            }
        });
        registroVista.jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String nam = (String) registroVista.jTextField2.getText();
                int ced = Integer.parseInt(registroVista.jTextField4.getText());
                model.setSesion(fechaAhora());
                model.setCedula(ced);
                int des = model.buscarUsuario(ced, nam);
                if (des == 1) {
                    if (necesidadVista == null) {
                        registroVista.show(false);
                        new ControladorNecesidad(model, registroVista);
                        System.out.println("la vista esta aqui");
                    } 
                    else {
                        registroVista.show(false);
                        necesidadVista.show(true);
                    }
                } else {
                    registroVista.mostrarAlerta("Error en datos");
                    // llamar vista
                }
                }
                catch(NumberFormatException nfe){
                   registroVista.mostrarAlerta("Error en datos"); 
                }
            }
        });
    }

    public Date fechaAhora() {
        return new Date();
    }
}
