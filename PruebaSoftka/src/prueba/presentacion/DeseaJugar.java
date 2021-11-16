package prueba.presentacion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import prueba.logica.Fabrica;
import prueba.logica.entidades.Categoria;
import prueba.persistencia.ConexionBD;

public class DeseaJugar extends javax.swing.JFrame {

    ConexionBD cn = new ConexionBD();
    Connection con = cn.getConexion();
    Fabrica fabrica = new Fabrica();

    List<Categoria> categorias;

    public DeseaJugar() throws SQLException {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btJugar = new javax.swing.JButton();
        NomUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 2, 48)); // NOI18N
        jLabel1.setText("Estas preparado para responder preguntas?");

        btJugar.setText("Jugar Ahora");
        btJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJugarActionPerformed(evt);
            }
        });

        NomUsuario.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
        NomUsuario.setText("NomUsuario");
        NomUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(403, 403, 403))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(518, 518, 518))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(NomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(btJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJugarActionPerformed

        PreguntasJuego preguntas = new PreguntasJuego();
        preguntas.setVisible(true);
        dispose();


    }//GEN-LAST:event_btJugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel NomUsuario;
    public javax.swing.JButton btJugar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
