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
public class No {

    private int vInfo[];
    private No vLig[];
    private int tl;

    public No(int info) {
        //quando não há mais espaço no vetor de elementos, um novo nó já é criado 
        //e este já contem a informação a ser inserida

        vInfo = new int[3 - 1];
        vLig = new No[3];
        tl = 1;
        vInfo[0] = info;
    }

    public void setTL(int tl) {
        this.tl = tl;
    }

    public int getTL() {
        return tl;
    }

    public int buscarPos(int info) {
        //busca a melhor posicao para insercao
        int i = 0;
        while (i < tl  && info > vInfo[i]) {
            i++;
        }

        return i;
    }

    public void remanejar(int pos) {
        //libera a pos indicada
        for (int i = tl - 1; i >= pos; i--) {
            vInfo[i + 1] = vInfo[i];
        }
    }

    public void setInfo(int pos, int info) {
        vInfo[pos] = info;
    }
    
    public int getInfo(int pos) {
        return vInfo[pos];
    }

    public No getVLig(int pos) {
        return vLig[pos];
    }

    public void setVlig(int pos, No no) {
        vLig[pos] = no;
    }
    
    
    
    
    public void mostrainfo(int pos)
    {
        System.out.println(vInfo[pos]);
    }

}
