/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subclasse_Threads;

/**
 *
 * @author legen
 */
public class Principal {
    public static void main(String args[]) {
        // 1. Cria uma instância da sua subclasse de Thread
        SubclasseDeThread t1 = new SubclasseDeThread();

        // 2. Inicia a execução da thread
        t1.start();
        
        // A thread principal (main) continua a sua execução
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando na thread principal: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
