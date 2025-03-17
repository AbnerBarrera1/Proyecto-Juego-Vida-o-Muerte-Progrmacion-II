/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caleb
 */
public class EscritorJugador {
    private String nombreArchivo;
    
    
    public EscritorJugador(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }
    
    public List procesarJugador(ArrayList<Jugador> arregloJugador){
        List<String[]> arregloVectores = new ArrayList<>();
       
        for(Jugador jugador: arregloJugador){
            arregloVectores.add(new String []{jugador.getNombre(),jugador.getApellido(),jugador.getApodo(),jugador.getFecha(),""+jugador.getPuntaje()});
        }
        return arregloVectores;
    }
    
    
    public void escribir(ArrayList<Jugador> arregloJugador){
        try{
            CSVWriter csvOutPut = new CSVWriter(new FileWriter(nombreArchivo,false));
            csvOutPut.writeAll(procesarJugador(arregloJugador));
            csvOutPut.close();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
