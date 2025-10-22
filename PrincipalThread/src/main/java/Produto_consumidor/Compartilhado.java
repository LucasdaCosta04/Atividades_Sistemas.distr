/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Produto_consumidor;

/**
 *
 * @author legen
 */
/**
 * Classe que contém o buffer a ser compartilhado entre o produto e o
 * consumidor.
 */
public class Compartilhado {
    private int buffer;
    private int tamanhoBuffer;

    public Compartilhado() {
        this.buffer = 0;
        this.tamanhoBuffer = 5;
    }

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public int getTamanhoBuffer() {
        return tamanhoBuffer;
    }

    public void setTamanhoBuffer(int tamanhoBuffer) {
        this.tamanhoBuffer = tamanhoBuffer;
    }

    // Método que consome um item do buffer.
    public synchronized void consumir() {
        // Se o buffer estiver vazio, a thread espera.
        while (buffer == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Decrementa o buffer e notifica todas as outras threads.
        setBuffer(getBuffer() - 1);
        System.out.println("Consumidor consumiu. Itens no buffer: " + getBuffer());
        notifyAll();
    }

    // Método que produz um item no buffer.
    public synchronized void produzir() {
        // Se o buffer estiver cheio, a thread espera.
        while (buffer == tamanhoBuffer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Incrementa o buffer e notifica todas as outras threads.
        setBuffer(getBuffer() + 1);
        System.out.println("Produtor produziu. Itens no buffer: " + getBuffer());
        notifyAll();
    }
}