/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Produto_consumidor;

/**
 *
 * @author legen
 */
public class Produtor implements Runnable {
    private Compartilhado x;
    private int tempo;

    public Produtor(Compartilhado x) {
        this.x = x;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Simula um tempo de espera aleatório.
                Thread.sleep((int) (Math.random() * getTempo()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Chama o método para produzir.
            x.produzir();
        }
    }
}

