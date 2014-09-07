/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cortacesped;

import java.awt.Component;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author tony
 */
class Crobot {   //clase robot
     
 private int posX,posY; //posicion del robot
 private int metaX,metaY;
 private int metodo;  //algoritmos de movimiento profundidad,heuristicos, etc..
 private Label [][] refarray; //referencia a array de Jlabels 
 private int filas,columnas; 
 private int posXpadre,posYpadre;  //celda padre de la celda de donde se encuentra el robot
 private int posXinicio,posYinicio;
 private javax.swing.JPanel panel1;  
 private int velocidad;
 private int finalizado; //para saber si el robot a terminado 0 no 1 si
 private int contvisitados; //contador de celdas visitadas
 private int contobstaculos;
 private Date inicio;   //control del tiempo de ejecucion del algoritmo para muestra de resultados
 private DateFormat hourinicio;
 private Date fin;      //control del tiempo de ejecucion del algoritmo para muestra de resultados
 private DateFormat hourfin;
 private int mov = 1;  //contador de movimientos
 
    Crobot(int filaCortaCesped, int columnaCortaCesped, int i, Label[][] array,int fil,int col,javax.swing.JPanel panel,int vel,int mx,int my) {        
        posX = filaCortaCesped;
        posY = columnaCortaCesped;
        posXinicio = posX;
        posYinicio = posY;
        metodo = i;
        refarray = array; 
        filas = fil;
        columnas = col;        
        posXpadre = 0;
        posYpadre = 0;
        panel1 = panel;
        velocidad = vel;
        finalizado = 0;
        contvisitados = 0;
        contobstaculos = 0;
        inicio = new Date();  //para informe final de resultados 
        hourinicio = new SimpleDateFormat("HH:mm:ss");
        metaX = mx;
        metaY =my;
    }
 
 public int getposX() {
     return posX;
 } 
 public int getposY() {
     return posY;
 }
 public void setposX(int x) {
     posX = x;
 }
 public void setposY(int y) {
     posY = y;
 }
 public int getmetodo() {
     return metodo;
 }
 public void setmetodo(int met) {
     metodo = met;
 } 
 public void setvelocidad(int vel){
     velocidad = vel;
 }
 
 /*-----------------------------------------------------------------------------
/                                                                                       
/                     Sensores de obstaculos
/
/----------------------------------------------------------------------------*/
 
 public int sensorNorte() {  //devuelve cero si no hay obstaculo 1
     if(posX != 0 && refarray[posX-1][posY].gettipo() != 1 ) {
         return 0;
     }
     else
         return 1;
     
 }
 public int sensorSur() {//devuelve cero si no hay obstaculo 1
     if(posX != (filas-1) && refarray[posX+1][posY].gettipo() != 1  ) {
         return 0;
     }
     else
         return 1;
     
 }
 public int sensorEste() {//devuelve cero si no hay obstaculo 1
     if(posY != (columnas-1) && refarray[posX][posY+1].gettipo() != 1  ) {
         return 0;
     }
     else
         return 1;
     
 }
 public int sensorOeste() {//devuelve cero si no hay obstaculo 1
     if(posY != 0 && refarray[posX][posY-1].gettipo() != 1  ) {
         return 0;
     }
     else
         return 1;
     
 }
  /*-----------------------------------------------------------------------------
/                                                                                       
/   Tipo de objeto en el label => 0 cesped alto, 1 obstaculo, 2 cesped cortado, 3 robot
/
/----------------------------------------------------------------------------*/
 public int cortarcesped() {
     if(refarray[posX][posY].gettipo() == 0) {
         return 0;
     }
     else
         return 1;
 }
 /*-----------------------------------------------------------------------------
/                                                                                       
/                 Esta visitado? visitado = 1 Si, visitado = 0 No
/
/----------------------------------------------------------------------------*/
 public int visitado() {
     if(refarray[posX][posY].getvisitado() == 0) {
         return 0;
     }
     else
         return 1;
 }
 public int visitadoTodos() {
     if(      (sensorEste() == 1 || refarray[posX][posY+1].getvisitado() == 1 ) &&  //mirar este
              (sensorSur() == 1 || refarray[posX+1][posY].getvisitado() == 1 ) &&  //mirar sur
              (sensorOeste() == 1 || refarray[posX][posY-1].getvisitado() == 1 ) &&  //mirar oeste
              (sensorNorte() == 1 || refarray[posX-1][posY].getvisitado() == 1 ))  //mirar norte
         return 0;   //cero = todo visitado
     else
         return 1;
                 
 }
 public void contador(){  //contar celdas visitadas y obstaculos
     contvisitados=contobstaculos=0;
     for(int i = 0;i < filas;i++){
            for( int j = 0 ; j < columnas ; j++ ){
                if(refarray[i][j].getvisitado()==1)
                    contvisitados++;
                if(refarray[i][j].gettipo() == 1)
                    contobstaculos++;
             
            }
     }
 contvisitados++;  //sumamos posicion del robot   
 }
 public void marcar(){
     if(cortarcesped() == 0 ) {  //cesped alto tenemos que cortarlo
            refarray[posX][posY].settipo(2); 
            refarray[posX][posY].setvisitado(1);
            
     } 
 }
 public void setfin(int f){   //para saber si el robot a terminado
     finalizado = f;
 }
 public int getfin(){
     return finalizado;
 }

 
 
 
 public void iniciar() {  //empieza a moverse el robot a recorrer el jardin
     switch(metodo) {  //metodo es el algoritmo de movimiento del robot
         case 0:
             profundidad();//seguimos el algoritmo de produndidad para el movimiento del robot
             break; 
         case 1:
             heuristico(); //algoritmo heuristico             
             break;  
         case 2:
             ramdom();   //el robot se mueve a lo loco, sin seguir patron alguno
             break;
                            
         default:
             
             
     }
 }
 /*-----------------------------------------------------------------------------
/                                                                                       
/                          Recorrido Aleatorio 
/
/----------------------------------------------------------------------------*/
 private void ramdom() {    
     int RandomCamino;
     Random r;            
     r=new Random();
     r.setSeed(new Date().getTime());  //semilla del ramdom segun hora
     
     if(cortarcesped() == 0) {  //cesped alto tenemos que cortarlo
         refarray[posX][posY].settipo(2);
     }
     
     RandomCamino =r.nextInt(4);
     refarray[posX][posY].setvisitado(1);  //marcamos como visitado
     
     
     switch(RandomCamino) {
         case 0: //norte
             if(sensorNorte() == 0) {
                 setposX(posX-1); //movemos al norte el robot
             }
             break;
         case 1:     
             if(sensorSur() == 0) {
                 setposX(posX+1); //movemos al sur el robot
             }
             break;
         case 2:     
             if(sensorEste() == 0) {
                 setposY(posY+1); //movemos al este el robot
             }
             break;
         case 3:     
             if(sensorOeste() == 0) {
                 setposY(posY-1); //movemos al oeste el robot
             }
             break;   
            
      
     }
  pintarJardin(); 
  ralentiza();
  if(getposX() == posXinicio && getposY() == posYinicio && visitadoTodos() == 0){
      setfin(1);
  }
  else
    ramdom();
     
 }
 
 public void ralentiza() {
     try {
           Thread.sleep(velocidad);
         } catch (InterruptedException ex) {
           Thread.currentThread().interrupt();
           }
 }
 
 /*-----------------------------------------------------------------------------
/                                                                                       
/                         Actualizar Jardin
/
/----------------------------------------------------------------------------*/
 public void pintarJardin() {
     
             
        for(int i = 0;i < filas;i++){
            for( int j = 0 ; j < columnas ; j++ ){
                if(refarray[i][j].gettipo() == 0) { //pintamos cesped alto
                    String path = "/cortacesped/img/cesped.jpg";
                    URL url = this.getClass().getResource(path);
                    ImageIcon icon = new ImageIcon(url);
                    refarray[i][j].setIcon(icon);
                    refarray[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                    refarray[i][j].setVerticalAlignment(SwingConstants.CENTER);
                    
                }
                if(refarray[i][j].gettipo() == 1) { //pintamos obstaculo
                    String path = "/cortacesped/img/flor.png";
                    URL url = this.getClass().getResource(path);
                    ImageIcon icon = new ImageIcon(url);
                    refarray[i][j].setIcon(icon);
                    refarray[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                    refarray[i][j].setVerticalAlignment(SwingConstants.CENTER);
                    
                }
                if(refarray[i][j].gettipo() == 2 || refarray[i][j].gettipo() == 3) { //pintamos cesped corto
                    String path = "/cortacesped/img/cesped2.jpg";
                    URL url = this.getClass().getResource(path);
                    ImageIcon icon = new ImageIcon(url);
                    refarray[i][j].setIcon(icon);
                    refarray[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                    refarray[i][j].setVerticalAlignment(SwingConstants.CENTER);                  
                   
                }
                            
           
            }
            
        }
        String path = "/cortacesped/img/robot.png";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        refarray[posX][posY].setIcon(icon);
        refarray[posX][posY].setHorizontalAlignment(SwingConstants.CENTER);
        refarray[posX][posY].setVerticalAlignment(SwingConstants.CENTER);
        
        
        panel1.updateUI();
        
        
        
    }
 
 
 /*-----------------------------------------------------------------------------
/                                                                                       
/                   Visualizar trayectoria del recorrido optimo 
/
/----------------------------------------------------------------------------*/
 
 public void pintarOptimo(){
     
     for(int i = 0;i < filas;i++){
            for( int j = 0 ; j < columnas ; j++ ){
                
                if(refarray[i][j].getcamino() == 1) { //pintamos camino optimo
                    String path = "/cortacesped/img/robot2.png";
                    URL url = this.getClass().getResource(path);
                    ImageIcon icon = new ImageIcon(url);
                    refarray[i][j].setIcon(icon);
                    refarray[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                    refarray[i][j].setVerticalAlignment(SwingConstants.CENTER); 
                    panel1.updateUI();
                }
                            
           
            }
            
        }
        
        
        
        panel1.updateUI();
 }
 
 /*-----------------------------------------------------------------------------
/                                                                                       
/                     Depth First Search recursivo
/
/----------------------------------------------------------------------------*/
 void dfs() {
     pintarJardin();
     ralentiza();     
     marcar();
     
     int posXpadre,posYpadre;
     posXpadre = posX;
     posYpadre = posY;
      //miramos cuatro cardinales de la celda
         if(sensorEste() == 0 && refarray[posX][posY+1].gettipo() == 0 ){ 
             posY++;
             Movimientos(1);
             marcar();        //al este no hay obstaculos y no ha sido visitado
             dfs();             
             
         }
         else if(sensorSur() == 0 && refarray[posX+1][posY].gettipo() == 0 ){
             posX++;
             Movimientos(1);
             marcar();      //al sur no hay obstaculos y no ha sido visitado
             dfs();      
         }
         else if(sensorOeste() == 0 && refarray[posX][posY-1].gettipo() == 0){
             posY--;
             Movimientos(1);
             marcar();      //al oeste no hay obstaculos y no ha sido visitado
             dfs();      
         }
         else if(sensorNorte() == 0 && refarray[posX-1][posY].gettipo() == 0){
             posX--;
             Movimientos(1);
             marcar();      //al norte no hay obstaculos y no ha sido visitado
             dfs();      
         }
          
       //   en caso que este en visitados, pues retrocedemos
         if(sensorEste() == 0 && visitado() == 1 && posY+1 == posYpadre){ 
             posY++;
             Movimientos(1);
             marcar();
             dfs();  
             
         }
         else if(sensorSur() == 0 && visitado() == 1 && posX+1 == posXpadre){
             posX++;
             Movimientos(1);
             marcar();
             dfs();      
         }
         else if(sensorOeste() == 0 && visitado() == 1 && posY-1 == posYpadre){
             posY--;
             Movimientos(1);
             marcar();
             dfs(); 
             
         }
         else if(sensorNorte() == 0 && visitado() == 1 && posX-1 == posXpadre){
             posX--;
             Movimientos(1);
             marcar();
             dfs();      
         }
         
         //termina cuando este en inicio y todos visitados
         
         
               
     }

 /*-----------------------------------------------------------------------------
/                                                                                       
/   Busqueda sin Informacion ; Llamada dfs mientras no solucion y ventana de informe
/
/----------------------------------------------------------------------------*/
 
 public void profundidad()   
 {    
          
     dfs();  //funcion recursiva con algoritmo en profundidad
        
     if(posX == posXinicio && posY == posYinicio && visitadoTodos() == 0){ //posicion de inicio y todo visitado, termina el proceso
        setfin(1);  //terminamos        
     }
     
     //PANTALLA PARA MOSTRAR RESULTADOS
     pintarOptimo();
     fin = new Date();
     int numeroCeldas;
     int sinvisitar;
     String nombreMetodo;
     hourfin = new SimpleDateFormat("HH:mm:ss");
     contador();  //contar visitados y obstaculos
     long segundos = inicio.getSeconds()-fin.getSeconds();
     long minutos = inicio.getMinutes()-fin.getMinutes();
     numeroCeldas=filas*columnas;
     sinvisitar=(filas*columnas)-(contvisitados+contobstaculos);
     if(metodo == 0)
         nombreMetodo = "PROFUNDIDAD";
     else if(metodo == 1)
         nombreMetodo = "HEURISTICO";
     else
         nombreMetodo = "RAMDOM";
         
     JOptionPane info = new JOptionPane();  //mostramos resumen de el proceso
     info.showMessageDialog(null,"                                                                               "+
             "\nALGORITMO: "+nombreMetodo+ 
             "\nHora de inicio: "+hourinicio.format(inicio)+
             "\nHora de fin: "+hourfin.format(fin)+
             "\nTIEMPO TRANSCURRIDO: "+minutos+" minutos,"+segundos+" segundos"+
             "\nTOTAL CELDAS CREADAS: "+numeroCeldas+
             "\nNUMERO DE OBSTACULOS: "+contobstaculos+
             "\nCELDAS VISITADAS: "+contvisitados+
             "\nCELDAS SIN VISITAR: "+sinvisitar+
             "\n NUMERO DE MOVIMIENTOS: "+ mov, "RESULTADOS", JOptionPane.INFORMATION_MESSAGE); 
 }
 
 /*-----------------------------------------------------------------------------
/                                                                                       
/  Coste de Manhattan  Posicion actual - Posicion Meta para creciente o viceversa decreciente
/
/----------------------------------------------------------------------------*/
 
 public void coste_manhattan(){  //coste de las celdas hijos de la celda actual
     int coste,costeX,costeY; //variables para los costes en diferencia con pos actual y pos meta
     //miramos los hijos de la celda actual
     
     if( sensorEste() == 0 && refarray[posX][posY+1].getvisitado() == 0){
         if (metaY >= (posY+1))         
            costeY= metaY-(posY+1);
         else
             costeY = (posY+1) - metaY;
         if (metaX >= posX)         
            costeX= metaX-posX;
         else
             costeX = posX - metaX;
         coste = costeX+costeY;
         refarray[posX][posY+1].setcoste(coste);  //asignamos coste a celda
     }     
     if( sensorSur() == 0 && refarray[posX+1][posY].getvisitado() == 0){
         if (metaY >= (posY))         
            costeY= metaY-posY;
         else
             costeY = (posY) - metaY;
         if (metaX >= (posX+1))         
            costeX= metaX-(posX+1);
         else
             costeX = (posX+1) - metaX;
         coste = costeX+costeY;
         refarray[posX+1][posY].setcoste(coste);  //asignamos coste a celda
     } 
     if( sensorOeste() == 0 && refarray[posX][posY-1].getvisitado() == 0){
         if (metaY >= (posY-1))         
            costeY= metaY-(posY-1);
         else
             costeY = (posY-1) - metaY;
         if (metaX >= posX)         
            costeX= metaX-posX;
         else
             costeX = posX - metaX;
         coste = costeX+costeY;
         refarray[posX][posY-1].setcoste(coste);  //asignamos coste a celda
     }     
     if( sensorNorte() == 0 && refarray[posX-1][posY].getvisitado() == 0){
         if (metaY >= (posY))         
            costeY= metaY-posY;
         else
             costeY = (posY) - metaY;
         if (metaX >= (posX-1))         
            costeX= metaX-(posX-1);
         else
             costeX = (posX-1) - metaX;
         coste = costeX+costeY;
         refarray[posX-1][posY].setcoste(coste);  //asignamos coste a celda
     }     
     
     //JOptionPane info3 = new JOptionPane();  //mostramos resumen de el proceso
     //info3.showMessageDialog(null,"mejor","recursivo",JOptionPane.INFORMATION_MESSAGE); 
     
     
 }
 
 /*-----------------------------------------------------------------------------
/                                                                                       
/          Buscamos el camino mejor, encontramos metemos informe
/
/----------------------------------------------------------------------------*/
 
 public int mejor(){         
     int hijo,menor;
     menor = 0;
     hijo = 22;
     //miramos cual es el mejor camino a seguir
     if(posX == metaX && posY == metaY){  //si llegamos a la meta mandamos -1 para que pare
         
                //PANTALLA PARA MOSTRAR RESULTADOS 
                pintarOptimo();
                fin = new Date();
                int numeroCeldas;
                int sinvisitar;
                String nombreMetodo;
                hourfin = new SimpleDateFormat("HH:mm:ss");
                contador();  //contar visitados y obstaculos
                long segundos = inicio.getSeconds()-fin.getSeconds();
                long minutos = inicio.getMinutes()-fin.getMinutes();
                numeroCeldas=filas*columnas;
                sinvisitar=(filas*columnas)-(contvisitados+contobstaculos);
                if(metodo == 0)
                    nombreMetodo = "PROFUNDIDAD";
                else if(metodo == 1)
                    nombreMetodo = "HEURISTICO";
                else
                    nombreMetodo = "RAMDOM";

                JOptionPane info = new JOptionPane();  //mostramos resumen de el proceso
                info.showMessageDialog(null,"                                                                               "+
                        "\nALGORITMO: "+nombreMetodo+ 
                        "\nHora de inicio: "+hourinicio.format(inicio)+
                        "\nHora de fin: "+hourfin.format(fin)+
                        "\nTIEMPO TRANSCURRIDO: "+minutos+" minutos,"+segundos+" segundos"+
                        "\nTOTAL CELDAS CREADAS: "+numeroCeldas+
                        "\nNUMERO DE OBSTACULOS: "+contobstaculos+
                        "\nCELDAS VISITADAS: "+contvisitados+
                        "\nCELDAS SIN VISITAR: "+sinvisitar+
                        "\n NUMERO DE MOVIMIENTOS: "+ mov, "RESULTADOS", JOptionPane.INFORMATION_MESSAGE);
                 
             
     return -1;
     } 
     if(posX == posXinicio && posY == posYinicio && visitadoTodos() == 0){  //si el robot no puede llegar a la bandera paramos
         JOptionPane info = new JOptionPane();  //mostramos resumen de el proceso
         info.showMessageDialog(null,"NO PUEDO LLEGAR A LA BANDERA", "RESULTADOS", JOptionPane.INFORMATION_MESSAGE);
         return -1;
         
     }
     menor = 10000;
     //ahora buscamos el verdadero menor
     if(sensorEste() == 0 && refarray[posX][posY+1].getcoste() < menor && refarray[posX][posY+1].getvisitado() == 0 ){  //sur
     
         menor = refarray[posX][posY+1].getcoste();
         hijo = 0;
         
     }
     if(sensorSur() == 0 && refarray[posX+1][posY].getcoste() < menor && refarray[posX+1][posY].getvisitado() == 0 ){  //sur         
     
         menor = refarray[posX+1][posY].getcoste();
         hijo = 1;
         
     }
     if(sensorOeste() == 0 &&refarray[posX][posY-1].getcoste() < menor && refarray[posX][posY-1].getvisitado() == 0 ){  //oeste        
         menor = refarray[posX][posY-1].getcoste();
         hijo = 2;
         
     }
     if(sensorNorte() == 0 && refarray[posX-1][posY].getcoste() < menor && refarray[posX-1][posY].getvisitado() == 0 ){  //norte
         menor = refarray[posX-1][posY].getcoste();
         hijo = 3;         
     } 
     
     if(hijo != 22)  //si hemos encontrado un hijo
         return hijo;  
     else
         return -2;  //backtracking
     
         
     
 }
 /*-----------------------------------------------------------------------------
/                                                                                       
/           Busqueda con informacion => Heuristica Escalada
/
/----------------------------------------------------------------------------*/
  

 public void heuristico() {  //algoritmo heuristico en escalada "Hill Climbing"
     int hijo;     
     int posXpadre,posYpadre;     
     posXpadre=posX;
     posYpadre=posY;
     pintarJardin();
     ralentiza();     
     marcar();
     refarray[posX][posY].setcamino(1);  //marcamos como camino optimo
     
     coste_manhattan();  //calculamos los costes de los nodos hijos
     hijo = mejor();    //ordenar y eliminar peores hijos
     
     switch(hijo){
         case 0:             
             posY++;
             Movimientos(1);
             heuristico();             
             refarray[posX][posY].setcamino(0);  //quitamos de camino optimo             
             posX=posXpadre;
             posY=posYpadre;
             if(finalizado==0)
                heuristico();
             break;
         case 1:
             posX++;
             Movimientos(1);
             heuristico();
             refarray[posX][posY].setcamino(0);  //quitamos de camino optimo             
             posX=posXpadre;
             posY=posYpadre;             
             if(finalizado==0)
                heuristico();
             break;
         case 2:
             posY--;
             Movimientos(1);
             heuristico();
             refarray[posX][posY].setcamino(0);  //quitamos de camino optimo             
             posX=posXpadre;
             posY=posYpadre;
             if(finalizado==0)
                heuristico();
             break;
         case 3:
             posX--;
             Movimientos(1);
             heuristico();
             refarray[posX][posY].setcamino(0);  //quitamos de camino optimo             
             posX=posXpadre;
             posY=posYpadre;
             if(finalizado==0)
                heuristico();
             break;  
         case -1:
             setfin(1);
             finalizado=1;
             break;
         
            
     }
     
     
 }
 
 public void escalada(){
     
    
     heuristico();  //funcion recursiva con algoritmo escalada con coste manhattan
     
 }
 
 public void Movimientos(int movi){  //contador de movimientos
     if(movi == 1){ 
         mov++;   
      }
 }
 
}
 
   
     