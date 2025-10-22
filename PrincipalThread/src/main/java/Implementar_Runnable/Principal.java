/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementar_Runnable;

/**
 *
 * @author legen
 */
public class Principal {

    public static void main(String args[]) {
        Runnable biu = new Operario("chinelo", 100);
        Runnable rai = new Operario("sandalia", 500);
        Thread t1 = new Thread(biu);
        Thread t2 = new Thread(rai);
        t1.start();
        t2.start();
    }
}

//Outra forma de declarar e instanciar a thread.//
/*
Thread t1 = new Thread(new Operario("chinelo", 100));
Thread t2 = new Thread(new Operario("sandalia", 500));
*/