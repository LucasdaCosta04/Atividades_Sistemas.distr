/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deadlock;

/**
 *
 * @author legen
 */
public class Cliente implements Runnable {

    private final String nome;
    private final Caixa caixa;
    private final int operacao;
    private final double valor;
    private final Object objetoCliente;

    public Cliente(String nome, Caixa caixa, int operacao, double valor) {
        this.nome = nome;
        this.caixa = caixa;
        this.operacao = operacao;
        this.valor = valor;
        this.objetoCliente = new Object();
    }

    @Override
    public void run() {
        System.out.println(nome + " chegou ao caixa.");
        try {
            // A operacao atender usa o objeto interno para identificacao.
            caixa.atender(objetoCliente, operacao, valor);
            System.out.println(nome + " terminou a operação.");
        } catch (InterruptedException e) {
            System.out.println(nome + " foi interrompido.");
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}