/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FRM_AreaJuego;

/**
 *
 * @author Estudiante
 */
public class HiloJuego extends Thread{
    FRM_AreaJuego frmAreaJuego;
    public boolean gameOver = false;
    public boolean salir=false;
    
    public HiloJuego(FRM_AreaJuego frmAreaJuego){
        this.frmAreaJuego = frmAreaJuego;
    }
  public void run(){
        try{
            while(!gameOver){
                frmAreaJuego.moverFondo();
             //   frmAreaJuego.moverPersonaje();
                frmAreaJuego.moverEnemigos();
                frmAreaJuego.detectarAtaque();
                frmAreaJuego.detectarColision();
                frmAreaJuego.moverAtaquesEnemigos();
             //   frmAreaJuego.moverAtaque();
                frmAreaJuego.gameOver();
                sleep(100);
            }
            //frmAreaJuego.mensaje("JuegoTerminado");
            frmAreaJuego.dispose();
            frmAreaJuego.detenerSonido();

        }catch(Exception e){
            e.getMessage();
        }
    }
}