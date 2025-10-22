/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deadlock;

/**
 *
 * @author legen
 */
public class Principal {

    public static void main(String[] args) throws InterruptedException {
        // Cenário 1: Sem deadlock
        System.out.println("--- Executando Cenário 1 (sem deadlock) ---");
        simularCenario1();

        // Aguarda para separar os cenários
        Thread.sleep(2000); 

        // Cenário 2: Com deadlock
        System.out.println("\n--- Executando Cenário 2 (com deadlock) ---");
        simularCenario2();
    }

    private static void simularCenario1() throws InterruptedException {
        Caixa caixa = new Caixa();
        System.out.printf("Saldo inicial do caixa: R$ %.2f\n", caixa.saldoCaixa);

        // Cliente 1: deposita R$100,00
        Thread cliente1Thread = new Thread(new Cliente("Cliente 1", caixa, 1, 100.00));
        cliente1Thread.start();
        cliente1Thread.join(); // Espera o cliente 1 terminar

        // Cliente 2: saca R$50,00
        Thread cliente2Thread = new Thread(new Cliente("Cliente 2", caixa, -1, 50.00));
        cliente2Thread.start();
        cliente2Thread.join(); // Espera o cliente 2 terminar

        System.out.printf("Saldo final do Cenário 1: R$ %.2f\n", caixa.saldoCaixa);
    }

    private static void simularCenario2() {
        Caixa caixa = new Caixa();
        System.out.printf("Saldo inicial do caixa: R$ %.2f\n", caixa.saldoCaixa);

        // Cliente 2 chega e inicia primeiro para tentar sacar (sem saldo)
        Thread cliente2Thread = new Thread(new Cliente("Cliente 2", caixa, -1, 50.00));
        // Cliente 1 chega logo em seguida para depositar
        Thread cliente1Thread = new Thread(new Cliente("Cliente 1", caixa, 1, 100.00));
        
        // Inicia as threads. A ordem de execução pode variar.
        cliente2Thread.start();
        cliente1Thread.start();
        
        try {
            // Espera um tempo para demonstrar o deadlock.
            Thread.sleep(5000); 
            System.out.println("\n(Após 5 segundos, o programa não avança devido ao deadlock)");
            System.out.println("Saldo final (DEADLOCK): R$ " + caixa.saldoCaixa);
            
            System.out.println("Execução interrompida para demonstrar o impasse.");
            // Interrompe as threads para parar o programa.
            cliente1Thread.interrupt();
            cliente2Thread.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}