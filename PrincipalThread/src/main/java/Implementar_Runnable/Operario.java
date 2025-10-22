/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementar_Runnable;

/**
 *
 * @author legen
 */
public class Operario implements Runnable {

    private String produto;
    private int tempo;

    public Operario(String produto, int tempo) {
        this.produto = produto;
        this.tempo = tempo;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " " + produto);
            try {
                Thread.sleep((long) (Math.random() * tempo));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Terminei " + produto);
    }
}
