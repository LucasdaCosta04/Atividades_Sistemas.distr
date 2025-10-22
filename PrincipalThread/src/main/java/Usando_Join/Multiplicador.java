/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usando_Join;

/**
 *
 * @author legen
 */
public class Multiplicador implements Runnable {

    private int[] numeros;
    private int resultado;

    public Multiplicador(int[] numeros) {
        this.numeros = numeros;
    }

    public int getResultado() {
        return resultado;
    }

    public void run() {
        resultado = 1;
        for (int i = 0; i < numeros.length; i++) {
            resultado = resultado * numeros[i];
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
