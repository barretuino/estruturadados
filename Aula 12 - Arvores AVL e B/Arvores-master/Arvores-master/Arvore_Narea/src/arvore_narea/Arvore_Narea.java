/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore_narea;

/**
 *
 * @author Alexandre
 */
public class Arvore_Narea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    //        TESTES DE INSERÇÃO CONFORME A VIDEO AULA
        NArea arve= new NArea();
        arve.inserir(80);
        arve.inserir(100);
        arve.inserir(70);
        arve.inserir(150);  
        arve.inserir(75); 
        
        arve.exibe();
        
        
        

        
 
//        
//        arve.print(0);
//        No test = arve.getRaiz().getVLig(0);
//        test.mostrainfo(0);
       
        
        
        
        
        
        
        
    }
    
}
