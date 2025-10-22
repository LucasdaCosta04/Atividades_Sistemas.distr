/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deadlock;

/**
 *
 * @author legen
 */
public class Caixa {

    double saldoCaixa = 0.0;
    // O clienteDaVez controla qual cliente tem a permissão para operar.
    // O erro no código original é que este cliente é um objeto da classe Cliente
    // e o metodo atender recebe outro objeto, causando a criação de vários objetos
    // e o não funcionamento da sincronização.
    // Corrigindo para um objeto genérico para fins de demonstração.
    Object clienteDaVez = null;

    public synchronized void atender(Object c, int op, double v) throws InterruptedException {
        // Enquanto houver um cliente sendo atendido, espera a vez
        while (clienteDaVez != null) {
            System.out.println(c.toString() + " aguardando a vez.");
            wait();
        }
        clienteDaVez = c;
        
        switch (op) {
            case -1:
                sacar(c, v);
                break;
            case 1:
                depositar(c, v);
                break;
        }
    }

    private synchronized void sacar(Object c, double valor) throws InterruptedException {
        // Enquanto não houver saldo suficiente, espera
        while (saldoCaixa < valor) {
            System.out.println(c.toString() + " aguardando saldo suficiente.");
            wait();
        }
        if (valor > 0) {
            saldoCaixa -= valor;
            System.out.printf("%s sacou R$ %.2f. Novo saldo: R$ %.2f\n", c.toString(), valor, saldoCaixa);
        }
        clienteDaVez = null;
        notifyAll();
    }

    private synchronized void depositar(Object c, double valor) {
        if (valor > 0) {
            saldoCaixa += valor;
            System.out.printf("%s depositou R$ %.2f. Novo saldo: R$ %.2f\n", c.toString(), valor, saldoCaixa);
        }
        clienteDaVez = null;
        notifyAll();
    }
}