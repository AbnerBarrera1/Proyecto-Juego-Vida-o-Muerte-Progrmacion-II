/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FRM_AreaJuego;


/**
 *
 * @author caleb
 */
public class HiloJuego2 extends Thread{
    
    FRM_AreaJuego frmAreaJuego;
    public boolean gameOver=false;
    
    public HiloJuego2(FRM_AreaJuego frmAreaJuego){
        this.frmAreaJuego = frmAreaJuego;
    }
    public void run(){
        try{
            while(!gameOver){
                frmAreaJuego.moverPersonaje();
                frmAreaJuego.moverAtaque();
                frmAreaJuego.gameOver();
                sleep(100);
            }
        }catch(Exception e){
            e.getMessage();
        }
    }
}
