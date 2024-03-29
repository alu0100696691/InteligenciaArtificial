
package cortacesped;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.util.Random;
import javax.swing.JTextField;  
import java.awt.event.ActionListener;  
import java.awt.event.ActionEvent;  
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.lang.*; 
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 * @Sandro @tony 
 */

/*-----------------------------------------------------------------------------
/                                                                                       
/                               Clase Corta Cesped
/
/----------------------------------------------------------------------------*/


public class CortaCesped extends javax.swing.JFrame  {

    /**
     * Creates new form CortaCesped
     * 
     */
    Crobot robot;  //objeto robot
    Label [][] array;  //array bidimencional de jlabel que usamos como tablero de juego
    int velocidad; //velocidad del robot
    Thread hilo;  //llamamos al robot.iniciar, el robot empieza a moverse
    Thread crono;  //cronometro
    
    public CortaCesped() {
        initComponents();  
        velocidad = 500;
        nfilas.setText("11");
        ncolumnas.setText("27");
        jCheckBox1.setSelected(true);  //por defecto posicionar robot habilitado
        
        //maximizar la ventana por defecto
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Asocio los radio buttons a un solo grupo        
        rbGroup.add(rbPorCiento); 
        
        //Imagen de la esquina
       String path = "/cortacesped/img/img.png";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        lbImg.setIcon(icon);
        nfilas.requestFocus();
    }
    
    
    
    //------------------------------------------------------------------------//
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    /*-----------------------------------------------------------------------------
/                                                                                       
/                        Codigo gráfico
/
/----------------------------------------------------------------------------*/
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nfilas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ncolumnas = new javax.swing.JTextField();
        btnCrearMapa = new javax.swing.JButton();
        rbPorCiento = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        inicio = new javax.swing.JButton();
        prueba = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        velo = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        metodo = new javax.swing.JComboBox();
        jCheckBox_Bordes = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lbImg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Corta Cesped Automata");
        setResizable(false);

        panel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));

        jLabel1.setText("M FILAS");

        nfilas.setPreferredSize(new java.awt.Dimension(50, 22));
        nfilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nfilasActionPerformed(evt);
            }
        });
        nfilas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                nfilasPropertyChange(evt);
            }
        });
        nfilas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nfilasKeyTyped(evt);
            }
        });

        jLabel2.setText("N COLUMNAS");

        ncolumnas.setPreferredSize(new java.awt.Dimension(50, 22));
        ncolumnas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncolumnasActionPerformed(evt);
            }
        });
        ncolumnas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ncolumnasKeyTyped(evt);
            }
        });

        btnCrearMapa.setText("CREAR");
        btnCrearMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMapaActionPerformed(evt);
            }
        });

        rbPorCiento.setText("BLOQUEOS ALEATORIOS");
        rbPorCiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPorCientoActionPerformed(evt);
            }
        });
        rbPorCiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbPorCientoKeyPressed(evt);
            }
        });

        jLabel4.setText("DIMENSIONES");

        jCheckBox1.setText("Posicionar Corta Cesped");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jCheckBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCheckBox1KeyPressed(evt);
            }
        });

        inicio.setText("INICIO");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        prueba.setText("AYUDA");
        prueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaActionPerformed(evt);
            }
        });

        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        velo.setMaximum(1000);
        velo.setMinimum(100);
        velo.setValue(500);
        velo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                veloStateChanged(evt);
            }
        });

        jLabel5.setText("+VELOCIDAD-");

        metodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PROFUNDIDAD", "HEURISTICO", "RAMDOM", " " }));

        jCheckBox_Bordes.setText("Marcar Bordes");

        jLabel6.setText("ALGORITMO:");

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("0:0:0:0");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nfilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ncolumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metodo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(velo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(rbPorCiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox_Bordes))
                        .addGap(43, 43, 43)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox_Bordes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(velo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nfilas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ncolumnas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(rbPorCiento))
                .addGap(25, 25, 25)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lblTime))
                .addGap(9, 9, 9))
        );

        panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel1.setMinimumSize(new java.awt.Dimension(3000, 3000));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2996, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2996, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    private void rbPorCientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPorCientoActionPerformed
        // TODO add your handling code here:
        jCheckBox1.requestFocus();
    }//GEN-LAST:event_rbPorCientoActionPerformed

  /*-----------------------------------------------------------------------------
/                                                                                       
/                           Botton Crear Mapa
/
/----------------------------------------------------------------------------*/  
    
    
    private void btnCrearMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMapaActionPerformed

        //Se comprueba si han sido rellenado y marcado los datos correspondientes para generar el mapa
        if(nfilas.getText().equals("") || ncolumnas.getText().equals("")){
            panel1.removeAll();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(this, "El rango de dimensiones no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }else if(Integer.parseInt(nfilas.getText()) > 100 || Integer.parseInt(ncolumnas.getText()) > 100 || Integer.parseInt(nfilas.getText()) < 2 || Integer.parseInt(ncolumnas.getText()) < 2 ){
            panel1.removeAll();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(this, "El rango de dimensiones no debe ser mayor de 100x100. Ni inferior a dos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            CrearJardin();
            
        }
        panel1.updateUI();
        inicio.requestFocus();
    }//GEN-LAST:event_btnCrearMapaActionPerformed

    /*-----------------------------------------------------------------------------
/                                                                                       
/    Inicio del Thread, Comprobación de metodo, Localizacion de propiedades
/    Cronometro....
/
/----------------------------------------------------------------------------*/
    
    
    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        // TODO add your handling code here:
        
        
        int posxRobot,posyRobot,posxbandera,posybandera;
        posxRobot=posyRobot=posxbandera=posybandera=0;
        
        
        if(jCheckBox1.isSelected()){
            
            int columnas = Integer.parseInt(ncolumnas.getText());
            int filas = Integer.parseInt(nfilas.getText());
            panel1.updateUI();
            
            for( int i = 0 ; i < filas ; i++ ){    //buscamos donde se pincho el robot      
             for( int j = 0 ; j < columnas ; j++ ){
                
                if (array[i][j].gettipo() == 3) //encontramos que se ha pinchado el robot
                {
                    posxRobot = i;
                    posyRobot = j;
                }
                if (array[i][j].gettipo() == 4) //encontramos que se ha pinchado la bandera
                {
                    posxbandera = i;
                    posybandera = j;
                }
                
              }
             }
            
            
        if(metodo.getSelectedIndex() == 1){    //si es metodo heuristico pintamos robot y bandera    
                   String path = "/cortacesped/img/robot.png";
                   URL url = this.getClass().getResource(path);
                   ImageIcon icon = new ImageIcon(url);
                   array[posxRobot][posyRobot].setIcon(icon);
                   array[posxRobot][posyRobot].setHorizontalAlignment(SwingConstants.CENTER);
                   array[posxRobot][posyRobot].setVerticalAlignment(SwingConstants.CENTER);
                   String path2 = "/cortacesped/img/bandera.jpg";
                   URL url2 = this.getClass().getResource(path2);
                   ImageIcon icon2 = new ImageIcon(url2);
                   array[posxRobot][posyRobot].setIcon(icon2);
                   array[posxRobot][posyRobot].setHorizontalAlignment(SwingConstants.CENTER);
                   array[posxRobot][posyRobot].setVerticalAlignment(SwingConstants.CENTER);
                   //creamos objeto robot con la posX,posY, y tipo de algoritmo 0 es profundidad,referencia a array, tamaño tablero,panel, velocidad
                   robot = new Crobot(posxRobot,posyRobot,metodo.getSelectedIndex(),array,filas,columnas,panel1,500,posxbandera,posybandera);                   
                   panel1.updateUI();  
        }
        else{  //sino solo pintamos robot
                   String path = "/cortacesped/img/robot.png";
                   URL url = this.getClass().getResource(path);
                   ImageIcon icon = new ImageIcon(url);
                   array[posxRobot][posyRobot].setIcon(icon);
                   array[posxRobot][posyRobot].setHorizontalAlignment(SwingConstants.CENTER);
                   array[posxRobot][posyRobot].setVerticalAlignment(SwingConstants.CENTER);
                   //creamos objeto robot con la posX,posY, y tipo de algoritmo 0 es profundidad,referencia a array, tamaño tablero,panel, velocidad
                   robot = new Crobot(posxRobot,posyRobot,metodo.getSelectedIndex(),array,filas,columnas,panel1,500,0,0);                   
                   panel1.updateUI();  
            
        }

                                    

                
           
            
        
           Runnable unRunnable = new Runnable(){
            @Override
            public void run() {
                int hora = 0, min = 0, seg = 0, ds = 0;//unidades de medida
                while(jCheckBox1.isSelected()){ 
                    if(robot.getfin() == 1){
                    crono.stop();
                    hilo.stop();

                    }
                    else
                    robot.iniciar(); //el robot empieza a moverse
                    }
            }
        };
          
        hilo = new Thread (unRunnable);
        hilo.start();  
        
        
    
        Runnable cronoRunnable = new Runnable(){
        @Override
        public void run() {
            int hora = 0, min = 0, seg = 0, ds = 0;//unidades de medida
            try {
                while (true) {//ciclo infinito
                    if (ds == 99) {//si los decisegundos son iguales a 99
                        ds = 0;//decisegundo vuelve a empezar en cero
                        seg++;//y aumenta un segundo
                    }
                    if (seg == 59) {//si los segundos son iguales a 59
                        seg = 0;//segundo vuelve a empezar en cero
                        min++;//y aumenta un minuto
                    }
                    if (min == 59) {//si los minutos son iguales a 59
                        min = 0;//minuto vuelve a empezar en cero
                        hora++;//y aumenta una hora
                    }
                    ds++;//aumentan las decimas de segundo

                    lblTime.setText(hora + ":" + min + ":" + seg + ":" + ds);//se muestra en el jlabel

                    crono.sleep(10);//que duerma una decima de segundo
                }
            } catch (java.lang.InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    };
    crono = new Thread(cronoRunnable);//declaramos el hilo    
    crono.start();  //comienza el cronometro 
    
    }  
        
    salir.requestFocus();   
    }//GEN-LAST:event_inicioActionPerformed

    
    /*-----------------------------------------------------------------------------
/                                                                                       
/                          Comprobaciones de Caracteres de entrada
/
/----------------------------------------------------------------------------*/
    
    
    private void nfilasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nfilasKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();  //con esto cada vez que introduce un caracter comprobamos que sea un numero en los jtextfield
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_nfilasKeyTyped

    private void ncolumnasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ncolumnasKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();  //con esto cada vez que introduce un caracter comprobamos que sea un numero en los jtextfield
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_ncolumnasKeyTyped

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_salirActionPerformed

    private void veloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_veloStateChanged
        // TODO add your handling code here:
        if(jCheckBox1.isSelected() && jCheckBox1.isEnabled() == false ){
            robot.setvelocidad(velo.getValue());
        }    
       
        
    }//GEN-LAST:event_veloStateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void nfilasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_nfilasPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nfilasPropertyChange

    private void nfilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nfilasActionPerformed
        // TODO add your handling code here:
        ncolumnas.requestFocus();
    }//GEN-LAST:event_nfilasActionPerformed

    private void ncolumnasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncolumnasActionPerformed
        // TODO add your handling code here:
        rbPorCiento.requestFocus();
    }//GEN-LAST:event_ncolumnasActionPerformed

    private void rbPorCientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbPorCientoKeyPressed
        // TODO add your handling code here:
        char car = evt.getKeyChar();  //con esto cada vez que introduce un caracter comprobamos que sea un numero en los jtextfield
        if(car == '\n') {
            rbPorCiento.setSelected(true);
            jCheckBox1.requestFocus();
        }
        
    }//GEN-LAST:event_rbPorCientoKeyPressed

    private void jCheckBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox1KeyPressed
        // TODO add your handling code here:
        char car = evt.getKeyChar();  //con esto cada vez que introduce un caracter comprobamos que sea un numero en los jtextfield
        if(car == '\n') {
            jCheckBox1.setSelected(true);
            btnCrearMapa.requestFocus();
        }
    }//GEN-LAST:event_jCheckBox1KeyPressed

    private void pruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaActionPerformed
        // TODO add your handling code here:
        
        //abrimos archivo pdf que contiene la ayuda del programa
        try {
            File path = new File (getClass().getResource("/cortacesped/ayuda.pdf").toURI());
            Desktop.getDesktop().open(path);
        }catch (IOException ex) {
            ex.printStackTrace();
        } catch (URISyntaxException ex) {
            Logger.getLogger(CortaCesped.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pruebaActionPerformed

    
    public void actionPerformed(ActionEvent e) {   System.exit(1);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
    }
    //------------------------------------------------------------------------//
    
    //------------------------------------------------------------------------//
    /*-----------------------------------------------------------------------------
/                                                                                       
/                   Matriz, comprobaciones de opciones
/
/----------------------------------------------------------------------------*/
    
    
    public void CrearJardin(){
        
        ncolumnas.setFont(new java.awt.Font("Tahoma", 1, 14));
        nfilas.setFont(new java.awt.Font("Tahoma", 1, 14));
        panel1.removeAll();
        int columnas = Integer.parseInt(ncolumnas.getText());
        int filas = Integer.parseInt(nfilas.getText());
        
        

        //Se crea el array 2D con la entrada de filas y columnas
        array = new Label [filas][columnas];
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        


        //Recorre filas
        for( int fila = 0 ; fila < filas ; fila++ ){
            //Recorre columnas
            for( int columna = 0 ; columna < columnas ; columna++ ){
             
                //Se crean las celdas
                array[fila][columna] = new Label(columna*50,fila*50,50,50, 0,0);
                if(jCheckBox_Bordes.isSelected()){
                    array[fila][columna].setBorder(border);
                }
                String path = "/cortacesped/img/cesped.jpg";
                URL url = this.getClass().getResource(path);
                ImageIcon icon = new ImageIcon(url);
                array[fila][columna].setIcon(icon);
                array[fila][columna].setHorizontalAlignment(SwingConstants.CENTER);
                array[fila][columna].setVerticalAlignment(SwingConstants.CENTER);                
                //Agrega las celdas al panel1
                panel1.add(array[fila][columna]);
                                
                Mouse raton = new Mouse(array[fila][columna],jCheckBox1,metodo,jCheckBox_Bordes);
                array[fila][columna].addMouseListener(raton);
                            
                panel1.updateUI();
            }
            
        }
        
       //Compruebo checkbox de Obstaculos Random      
       if(rbPorCiento.isSelected()){   
            
           int PorCiento = Integer.parseInt(JOptionPane.showInputDialog("Introdusca el % de bloqueos que desea que aparescan","10"));
           int TotalBloqueos = ((filas*columnas)*PorCiento)/100;
       
           if (TotalBloqueos > (filas*columnas)){
               JOptionPane jop = new JOptionPane();
               jop.showMessageDialog(this, "Numero de bloqueos superior al campo de cesped.", "Error", JOptionPane.ERROR_MESSAGE);
           }           
           else{
           
               
               for( int cont = 0 ; cont < TotalBloqueos ; cont++ ){
               
                   int RandomF =(int) (Math.random()*(filas));
                   int RandomC =(int) (Math.random()*(columnas));           
                   String path = "/cortacesped/img/flor.png";
                   URL url = this.getClass().getResource(path);
                   ImageIcon icon = new ImageIcon(url);
                   array[RandomF][RandomC].setIcon(icon);  
                   array[RandomF][RandomC].setHorizontalAlignment(SwingConstants.CENTER);
                    array[RandomF][RandomC].setVerticalAlignment(SwingConstants.CENTER);
                   array[RandomF][RandomC].settipo(1);  //ponemos en el label que es un obstaculo
                   panel1.add(array[RandomF][RandomC]);
                   panel1.updateUI();
               }
                            
           }
       
       }
       if(jCheckBox1.isSelected()){
            JOptionPane info = new JOptionPane();
            info.showMessageDialog(this, "Click en la zona del cesped para la posicion del robot y bandera.","ROBOT",JOptionPane.INFORMATION_MESSAGE);  
       }     
       //Compruebo checkbox de insercion del Corta Cesped
       
       //Actualizo el panel para que se muestren los nuevos cambios
       panel1.updateUI();
    }
    
  
 
    //------------------------------------------------------------------------//   
   
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CortaCesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CortaCesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CortaCesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CortaCesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CortaCesped().setVisible(true);
                
                   
            }
        });
    }
    //------------------------------------------------------------------------//
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMapa;
    private javax.swing.JButton inicio;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox_Bordes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImg;
    private javax.swing.JLabel lblTime;
    private javax.swing.JComboBox metodo;
    private javax.swing.JTextField ncolumnas;
    private javax.swing.JTextField nfilas;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JButton prueba;
    private javax.swing.ButtonGroup rbGroup;
    private javax.swing.JRadioButton rbPorCiento;
    private javax.swing.JButton salir;
    private javax.swing.JSlider velo;
    // End of variables declaration//GEN-END:variables
}



