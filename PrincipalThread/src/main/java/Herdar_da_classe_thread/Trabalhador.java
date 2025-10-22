/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herdar_da_classe_thread;

/**
 *
 * @author legen
 */
public class Trabalhador extends Thread {

    private String produto;
    private int tempo;

    public Trabalhador(String produto, int tempo) {
        this.produto = produto;
        this.tempo = tempo;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " " + produto);
            try {
                sleep((long) (Math.random() * tempo));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Terminei " + produto);
    }
}
