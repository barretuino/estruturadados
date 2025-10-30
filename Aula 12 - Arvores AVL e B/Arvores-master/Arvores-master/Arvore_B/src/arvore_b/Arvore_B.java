/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore_b;

/**
 *
 * @author Alexandre
 */
public class Arvore_B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BTree a = new BTree();

        a.insere(43, 0);
        a.insere(31, 0);
        a.insere(37, 0);
        a.insere(47, 0);
        a.insere(61, 0);
        a.insere(20, 0);
        a.insere(30, 0);
        a.insere(32, 0);
        a.insere(33, 0);
        a.insere(40, 0);
        a.insere(41, 0);
        a.insere(42, 0);
        a.insere(44, 0);
        a.insere(45, 0);
        a.insere(50, 0);
        a.insere(60, 0);
        a.insere(62, 0);
        a.insere(63, 0);
        a.insere(64, 0);

        a.exclui(42);
        a.inOrdem(a.getRaiz());

    }
}
