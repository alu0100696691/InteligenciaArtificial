/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cortacesped;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


/**
 *
 * @author tony
 * 
 * 
 */

    
public class cesped extends javax.swing.JFrame {

    /**
     * variables 
     */
    int filas = Integer.parseInt(principal.filas.getText());
    int columnas = Integer.parseInt(principal.columnas.getText());
    int obstaculos = Integer.parseInt(principal.obstaculos.getText());
    int celdas = filas*columnas;  //numero total de celdas
    
    JLabel[][] label = new JLabel[filas][columnas];    //Declaración del array de etiquetas
    public cesped() {
        initComponents();
       
       
      
       
       Border border = BorderFactory.createLineBorder(Color.black, 1);  //borde de los label
       
       for(int i = 0; i < label.length; i++) 
       {
           for(int j = 0; j < columnas; j++)
           {    
            label[i][j] = new JLabel();    //Llenamos el array de etiquetas
           }
       }
       
       //creamos los obstáculos si ramdom no esta activo
       int[][] pos_obstaculos = new int[filas][columnas];  //donde guardamos posiciones obtaculos
       
       if(principal.ramdom.isSelected() == false)  //si no esta clicleado pues ramdom obstaculos
       {
           Random r;            
           r=new Random();
           r.setSeed(new Date().getTime());  //semilla del ramdom segun hora
           //creamos posiciones de obstaculos
          for(int i = 0;i <obstaculos;i++)
           {
                
                int fil = r.nextInt(filas); 
                int col = r.nextInt(columnas); 
                pos_obstaculos[fil][col] = 1;  //posicion de un obstaculo
                                                  
           }   
       }
       else
       {
            
       }
       
       // pintamos el campo de cesped, con robot, obstaculos y la hierva 
       for(int i = 0; i < filas; i++)
       {  
           for(int j = 0; j < columnas; j++)
           {    
                label[i][j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                
                //pintar();    
                
                    

                    
                }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                
                 
                label[i][j].setBounds(new Rectangle((j+1)*60, (i+1)*25, 60, 25));
                label[i][j].setBorder(border);
                label[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                if(i==0 && j == 0)   //pintamos robot
                {
                    String path = "/cortacesped/robot.gif";
                    URL url = this.getClass().getResource(path);  
                    ImageIcon icon = new ImageIcon(url); 
                    label[i][j].setIcon(icon);
                    this.add(label[i][j], null);                
                    
                }  
                else if( pos_obstaculos[i][j] == 1)  //pintamos obstaculo
                {
                    String path = "/cortacesped/macetas.jpeg";
                    URL url = this.getClass().getResource(path);  
                    ImageIcon icon = new ImageIcon(url); 
                    label[i][j].setIcon(icon);
                    this.add(label[i][j], null);  
                    
                }
                else  //pintamos cesped
                {
                    String path = "/cortacesped/cesped.jpg";
                    URL url = this.getClass().getResource(path);  
                    ImageIcon icon = new ImageIcon(url); 
                    label[i][j].setIcon(icon);
                    this.add(label[i][j], null); 
                    
                }
                
           }      
        
       }    
        
 
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        volver.setText("VOLVER");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(volver)
                .addContainerGap(515, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(428, Short.MAX_VALUE)
                .addComponent(volver)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        dispose();  //cierra la ventana cesped
        new principal().setVisible(true);  //muestra la ventana principal
    }//GEN-LAST:event_volverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static  void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
  
        
        
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cesped().setVisible(true);                
            }
        });
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
