/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Thread;

/**
 *
 * @author legen
 */
public class PrincipalThread {

    public static void main(String[] args) {
        System.out.println("Numero de threads:"
                + Thread.activeCount());
        System.out.println(Thread.currentThread());
    }
}
