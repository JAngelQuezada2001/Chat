/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package chat;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author TenmaAlonso0712
 */
public class Interfaz1 extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form Interfaz1
     */
    public Interfaz1() {
        initComponents();
        this.getRootPane().setDefaultButton(this.enviar);
        Servidor s = new Servidor(6300);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        textoEnviar = new javax.swing.JFormattedTextField();
        enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 510, 340));
        getContentPane().add(textoEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 350, 30));

        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        getContentPane().add(enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 120, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        String mensaje = "1: " + this.textoEnviar.getText() + "\n";
        
        this.texto.append(mensaje);
        
        Cliente c = new Cliente(5400, mensaje);
        Thread t = new Thread(c);
        t.start();

    }//GEN-LAST:event_enviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    private javax.swing.JFormattedTextField textoEnviar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        this.texto.append((String) arg);
    }
}
