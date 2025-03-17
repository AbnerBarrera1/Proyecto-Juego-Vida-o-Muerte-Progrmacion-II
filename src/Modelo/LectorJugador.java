/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caleb
 */
public class LectorJugador {
     private String nombreArchivo;
    ArrayList<Jugador> arregloJugador;
    
    public LectorJugador(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }
    
    public ArrayList<Jugador> leer(){
        try{
            CSVReader csvReader;
            List<String[]> arregloVectores =null;
            arregloJugador = new ArrayList<>();
            
            csvReader = new CSVReader(new FileReader(nombreArchivo));
            arregloVectores = csvReader.readAll();
            
            for(String [] linea: arregloVectores){
                 Jugador jugador = new Jugador(linea[0],linea[1],linea[2],linea[3],Integer.parseInt(linea[4]));
                 arregloJugador.add(jugador);
            }
                
        }catch(FileNotFoundException e){
           
        }catch(IOException io){
            io.printStackTrace();
        }catch(CsvException cs){
            cs.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            
        }
        return arregloJugador;
    }
}
