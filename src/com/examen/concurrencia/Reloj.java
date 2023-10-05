/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.examen.concurrencia;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author felip
 */
public class Reloj extends JFrame {

    private JLabel labelHora;

    public Reloj() {

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        labelHora = new JLabel();
        labelHora.setHorizontalAlignment(SwingConstants.CENTER);
        labelHora.setFont(new Font("Century", Font.PLAIN, 25));

        getContentPane().add(labelHora);

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    actualizarHora();

                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        System.out.println("Interrumpir hilo");
                    }
                }
            }
        }) {

        };
        hilo.start();
    }

    private void actualizarHora() {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String clock = format.format(new Date());
        labelHora.setText(clock);

    }

    public static void main(String[] args) {

        new Reloj().setVisible(true);

    }

}

//    Calendar horaEspecifica = Calendar.getInstance();
//    horaEspecifica.set(Calendar.HOUR_OF_DAY, 12); 
//    horaEspecifica.set(Calendar.MINUTE, 30);  
//    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//    String clock = format.format(horaEspecifica.getTime());
//
//    labelHora.setText(clock);
