/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface_Runnable;

/**
 *
 * @author legen
 */

public class ImplementandoRunnable implements Runnable {
    @Override
    public void run() {
        // Coloque aqui o código que a thread vai executar.
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando em Runnable: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
