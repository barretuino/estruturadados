/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore_bplus;

/**
 *
 * @author Alexandre
 */
public class Arvore_Bplus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Bplus a = new Bplus();        
         
        a.insere(43);
        a.insere(31);
        a.insere(37);
        a.insere(47);
        a.insere(61);
        a.insere(20);
        a.insere(30);
        a.insere(32);
        a.insere(33);
        a.insere(40);
        a.insere(41);
        a.insere(42);
        a.insere(44);
        a.insere(45);
        a.insere(50);
        a.insere(60);
        a.insere(62);
        a.insere(63);
        a.insere(64);
        
        a.exibe();
        
    }
    
}
