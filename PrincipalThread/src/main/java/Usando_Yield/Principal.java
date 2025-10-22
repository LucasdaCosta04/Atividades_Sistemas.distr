/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usando_Yield;

/**
 *
 * @author legen
 */
public class Principal {

    public static void main(String args[]) {
        ThreadYield primeiro = new ThreadYield("Primeiro");
        ThreadYield segundo = new ThreadYield("Segundo");
        primeiro.start();
        segundo.start();
    }
}
