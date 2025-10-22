/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface_Runnable;

/**
 *
 * @author legen
 */
public class Principal {
    public static void main(String args[]){
        ImplementandoRunnable r1 = new ImplementandoRunnable();
        Thread t1 = new Thread(r1);
        t1.start();
    }
}

