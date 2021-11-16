package prueba.presentacion;

import java.util.List;
import javax.swing.JOptionPane;
import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.PruebaModelException;
import prueba.logica.Fabrica;
import prueba.logica.entidades.Categoria;
import prueba.logica.entidades.Pregunta;
import prueba.logica.entidades.Respuesta;

public class PreguntasJuego extends javax.swing.JFrame {

    Fabrica fabrica = new Fabrica();
    Pregunta preguntaMomento;
    List<Respuesta> respuestaCorrecta;
    Categoria categoriaSiguiente;
    boolean valor;
    public Integer premio = 0;

    public int nivel = 1;

    public PreguntasJuego() {
        initComponents();

        try {
            cargarPreguntasYRespuestas();
        } catch (BaseDeDatosException ex) {
            throw new PruebaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        respuesta1 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        LabelPregunta = new javax.swing.JLabel();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        LabelPuntos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.black);

        LabelPregunta.setFont(new java.awt.Font("DialogInput", 2, 18)); // NOI18N
        LabelPregunta.setForeground(new java.awt.Color(51, 51, 51));
        LabelPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelPregunta.setText("Pregunta");
        LabelPregunta.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 0)));

        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });

        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });

        LabelPuntos.setFont(new java.awt.Font("Curlz MT", 2, 48)); // NOI18N
        LabelPuntos.setText("jLabel1");
        LabelPuntos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LabelPuntos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(LabelPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 170, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(455, 455, 455))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LabelPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(LabelPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        valor = respuestaCorrecta.get(0).getTipo();
        verificarRespuesta(valor);

    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        valor = respuestaCorrecta.get(1).getTipo();
        verificarRespuesta(valor);
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        valor = respuestaCorrecta.get(2).getTipo();
        verificarRespuesta(valor);
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        valor = respuestaCorrecta.get(3).getTipo();
        verificarRespuesta(valor);
    }//GEN-LAST:event_boton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LabelPregunta;
    public javax.swing.JLabel LabelPuntos;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup respuesta1;
    // End of variables declaration//GEN-END:variables

    private void cargarPreguntasYRespuestas() {

        LabelPuntos.setText(premio.toString());

        Categoria categoria = fabrica.getCategoriaControlador().getCategoriaAleatoria();

        preguntaMomento = fabrica.getPreguntaControlador().getPreguntaPorIdCategoria(categoria.getIdCategoria(), nivel);
        LabelPregunta.setText(preguntaMomento.getContenido());

        Long idPregunta = preguntaMomento.getIdPregunta(); //Obtenemos la pregunta
        respuestaCorrecta = (List<Respuesta>) fabrica.getRespuestaControlador().getRespuestaPorIdPreguntaAleatoria(idPregunta);

        this.boton1.setText(respuestaCorrecta.get(0).getContenido());
        this.boton2.setText(respuestaCorrecta.get(1).getContenido());
        this.boton3.setText(respuestaCorrecta.get(2).getContenido());
        this.boton4.setText(respuestaCorrecta.get(3).getContenido());
    }

    private void verificarRespuesta(Boolean val) {

        if (val == true) {
            if (nivel < 5) {
                nivel++; //Aumento un nivel  
                premio = nivel * 200;
            }

            cargarPreguntasYRespuestas();

        } else {
            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
            dispose();
            
            

        }
    }

}
