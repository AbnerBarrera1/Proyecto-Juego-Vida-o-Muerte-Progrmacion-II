/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author caleb
 */
public class RegistroJugador {
    private ArrayList<Jugador> arregloJugador;
    private Jugador [] vectorTemporal;
    private Jugador [] vectorAux;
    private String mensaje="";
    private String nombreArchivo;
    LectorJugador lectorJugador;
    EscritorJugador escritorJugador;
    Jugador jugadorActual;
    
//-----------------------------------------------------------------------------------------------------------------------
   public RegistroJugador(){
       this.arregloJugador= new ArrayList<>();
       this.mensaje="";
       this.nombreArchivo="registroJugador.csv";
       this.lectorJugador = new LectorJugador(nombreArchivo);
       this.escritorJugador = new EscritorJugador(nombreArchivo);
       
   }//Fin del constructor
  
   
//-------------------------------------------------------------------------
   public String agregarJugador(Jugador jugador) {
       
       if(jugador!=null){
           if(buscarIndice(jugador.getApodo())==-1){
              arregloJugador.add(jugador);
              escritorJugador.escribir(arregloJugador);
              mensaje="Jugador registrado correctamente";
           }else{
               mensaje = "Ya se encuentra registrado un Jugador con ese apodo";
           }
       }else{
           mensaje="error al agregar el jugador";
       }
       return mensaje;
   }
//----------------------------------------------
   public int buscarIndice(String apodo) {
        arregloJugador = new ArrayList<>();
       arregloJugador = lectorJugador.leer();
       for (int i = 0; i < arregloJugador.size(); i++) {
           if(arregloJugador.get(i) !=null){
              if(arregloJugador.get(i).getApodo().equals(apodo)){
                  return i;
               }
           }
       }
       return -1;
   }
   
//--------------------------------------------------------------------------
   
   public Jugador buscarJugador(String apodo){
       int posicion = buscarIndice(apodo);
       if(posicion != -1){//verifica que la posisicon sea valida
           return arregloJugador.get(posicion);
       }
       return null;
   }
   
//----------------------------------------------------------------------------------------------
   
   public String eliminarAlumno(String carnet){
        int posicion = buscarIndice(carnet);
       if(posicion != -1){
          arregloJugador.remove(posicion);
          escritorJugador.escribir(arregloJugador);
          mensaje = "El alumno fue eliminado";
       }else{
           mensaje="El alumno que desea eliminar no esta registrado";
       }
       return mensaje;
   }
 //-----------------------------------------------------------------------------
   
   public String modificarAlumno(Jugador jugador){
        int posicion = buscarIndice(jugador.getApodo());
       if(posicion != -1){
          arregloJugador.get(posicion).setPuntaje(jugador.getPuntaje());
          escritorJugador.escribir(arregloJugador);
          mensaje = "La informacion del alumno fue modificada";
       }else{
           mensaje="El alumno que desea modificar no esta registrado";
       }
       return mensaje;
   }
   
    public void clasificarJugadores(){
       this.arregloJugador= new ArrayList<>();
       arregloJugador = lectorJugador.leer();
       vectorTemporal = new Jugador[arregloJugador.size()];
       vectorAux = new Jugador[arregloJugador.size()];
       
       jugadorActual= arregloJugador.get(0);
       
        for(int i =0; i < arregloJugador.size(); i++){
            if(arregloJugador.get(i)!=null){
               vectorTemporal[i]=arregloJugador.get(i);
            }
        }
       
       int e = arregloJugador.size()-1;
       for (int a = 0; a < arregloJugador.size(); a++) {
           if (jugadorActual.getPuntaje() < vectorTemporal[a].getPuntaje()) {
               vectorAux[e] = vectorTemporal[a];
           }else{
               vectorAux[e] = vectorTemporal[a];
           }
           e--;
       }
       
       
        
        for(int o =0; o < arregloJugador.size(); o++){
                arregloJugador.add(vectorAux[o]);
        }
       
   }
   
   public String [][] getDataMatriz() {
       // clasificarJugadores();
        arregloJugador= new ArrayList<>();
        arregloJugador = lectorJugador.leer();
        
        String [][] matrizData = new String [arregloJugador.size()][Jugador.TBL_ETIQUETAS.length];
        
        if(10>arregloJugador.size()){
            for(int i =0; i <arregloJugador.size(); i++){
            matrizData[i][0] = arregloJugador.get(i).getApodo();
            matrizData[i][1] = ""+arregloJugador.get(i).getPuntaje();
            matrizData[i][2] = arregloJugador.get(i).getFecha();
           }
        }else{
            for(int i =0; i <10; i++){
            matrizData[i][0] = arregloJugador.get(i).getApodo();
            matrizData[i][1] = ""+arregloJugador.get(i).getPuntaje();
            matrizData[i][2] = arregloJugador.get(i).getFecha();
           }
        }
        
       
       return matrizData;
   }
    Calendar fecha = new GregorianCalendar();
    String year = Integer.toString(fecha.get(Calendar.YEAR));
    String mes = Integer.toString(fecha.get(Calendar.MONTH));
    String dia = Integer.toString(fecha.get(Calendar.DATE));

    public String fechaRecord = dia + "-" + mes + "-" + year;
}
