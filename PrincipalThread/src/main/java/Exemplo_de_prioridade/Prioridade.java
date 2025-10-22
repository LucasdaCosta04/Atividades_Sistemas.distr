/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exemplo_de_prioridade;

/**
 *
 * @author legen
 */
public class Prioridade extends Thread {

    private String nome;

    public Prioridade(String nome) {
        this.nome = nome;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + nome);
        }
        System.out.println("Terminei " + nome);
    }
}
