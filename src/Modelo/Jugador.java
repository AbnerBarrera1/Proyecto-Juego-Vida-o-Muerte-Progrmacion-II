/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author caleb
 */
public class Jugador {
    private String nombre,apellido, apodo, fecha;
    private int puntaje;
    public static final String [] TBL_ETIQUETAS={"Apodo","Puntaje","Fecha"};

    public Jugador(String nombre, String apellido, String apodo, String fecha, int puntaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.apodo = apodo;
        this.fecha = fecha;
        this.puntaje = puntaje;
    }
    
    public Jugador() {
        this.nombre = "";
        this.apellido = "";
        this.apodo = "";
        this.fecha ="";
        this.puntaje = 0;
    }

    //********************************************************************************************************
    //Métodos Se

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    
    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApodo() {
        return apodo;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Nickname : "+apodo + " Puntaje: "+ puntaje+" Fecha :"+fecha;
    }
    
}
