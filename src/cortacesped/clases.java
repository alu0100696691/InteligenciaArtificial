/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cortacesped;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author tony @sandro 
 */


/*-----------------------------------------------------------------------------
/                                                                                       
/               Clase Jlabel para cada celda del mapa bidimensional 
/
/----------------------------------------------------------------------------*/


public class clases { }



class Label extends JLabel  {  //clase tablero del juego de Jlabel
    
    private int tipo;  //tipo de objeto en el label, 0 cesped alto, 1 obstaculo, 2 cesped cortado, 3 robot
    private int visitado; //la celda ha sido visitada por el robot? visitado = 1
    private int coste;  //coste manhattan para algoritmo escalada
    private int camino;  //pertenece o no al camino optimo
        //Constructor con parametros para posicionar a las celdas
        public Label( int pos_x, int pos_y, int ancho, int alto, int tip,int vi ){ 
            //Se coloca el boton en un lugar y se le da un tamaño
            setBounds(new Rectangle(pos_x, pos_y, ancho, alto)); 
            tipo = tip;
            visitado = vi;
                   
        }
       //public Crobot robot;  
       public void settipo(int t)
       {
           tipo = t;
       }
       public int gettipo()
       {
           return tipo;
       }
       public void setvisitado(int v){
           visitado = v;
       }
       public int getvisitado(){
           return visitado;
       }
       public void setcoste(int c){
           coste = c;
       }
       public int getcoste(){
           return coste;
       }
       public void setcamino(int c){
           camino = c;
       }
       public int getcamino(){
           return camino;
       }
       
           
    }

/*-----------------------------------------------------------------------------
/                                                                                       
/               Clase para los eventos click en el tablero
/
/----------------------------------------------------------------------------*/


class Mouse extends MouseAdapter {  //clase para los eventos click en el tablero
                Label reflabel;
                JCheckBox ponerRobot;
                JComboBox metodo;
                JCheckBox bordes;
                
                
                Mouse(Label label, JCheckBox botonRobot, JComboBox met,JCheckBox jCheckBox_Bordes) {
                reflabel = label;   
                ponerRobot = botonRobot;
                metodo = met;
                bordes = jCheckBox_Bordes;
                    
                } 
                
                @Override
                public void mouseClicked(MouseEvent e){
                    
                    if( ponerRobot.isSelected() && ponerRobot.isEnabled() ) 
                    {
                        String path = "/cortacesped/img/robot.png";
                        URL url = this.getClass().getResource(path);  
                        ImageIcon icon = new ImageIcon(url);  
                        reflabel.setIcon(icon);   
                        reflabel.settipo(3);  //ahora es un robot
                        ponerRobot.setEnabled(false);
                                       
                    }
                    
                    else if(metodo.getSelectedIndex() == 1 && bordes.isEnabled()) {  //metodo heuristico seleccionado
                        String path = "/cortacesped/img/bandera.jpg";
                        URL url = this.getClass().getResource(path);  
                        ImageIcon icon = new ImageIcon(url);  
                        reflabel.setIcon(icon);   
                        reflabel.settipo(4);  //ahora es una meta
                        bordes.setEnabled(false);                     
                    }
                    
                    if(reflabel.gettipo() == 1) {
                        String path = "/cortacesped/img/cesped.jpg";
                        URL url = this.getClass().getResource(path);  
                        ImageIcon icon = new ImageIcon(url);  
                        reflabel.setIcon(icon); 
                        reflabel.settipo(0);  //ahora es cesped alto                        
                    }
                    else if (reflabel.gettipo() == 0){
                        String path = "/cortacesped/img/flor.png";
                        URL url = this.getClass().getResource(path);  
                        ImageIcon icon = new ImageIcon(url);  
                        reflabel.setIcon(icon); 
                        reflabel.settipo(1);  //ahora es un obstaculo
                    }
                    
                    
                }
                
 }               
                
               
 
