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
public class No {

    private static int m = 2;

    private int vInfo[];
    private int vPos[];
    private No vLig[];
    private int tl;

    public No() {
        vInfo = new int[2 * m + 1];
        vPos = new int[2 * m + 1];
        vLig = new No[2 * m + 2];
    }

    public No(int info, int posArq) {
        vInfo = new int[2 * m + 1];
        vPos = new int[2 * m + 1];
        vLig = new No[2 * m + 2];

        vInfo[0] = info;
        vPos[0] = posArq;
        tl = 1;
    }

    public int getVinfo(int p) {
        return vInfo[p];
    }

    public void setVinfo(int p, int info) {
        vInfo[p] = info;
    }

    public int getVPos(int p) {
        return vPos[p];
    }

    public void setVPos(int p, int posArq) {
        vPos[p] = posArq;
    }

    public No getVlig(int p) {
        return vLig[p];
    }

    public void setVlig(int p, No n) {
        vLig[p] = n;
    }

    public int getTL() {
        return tl;
    }

    public void setTL(int tl) {
        this.tl = tl;
    }

    public int procurarPosicao(int info) {
        //busca a melhor posicao para insercao dentro do vetor
        int i = 0;
        while (i < tl && info > vInfo[i]) {
            i++;
        }
        return i;
    }

    public int getPos(int info) {
        for (int i = 0; i < this.tl; i++) {
            if (this.vInfo[i] == info) {
                return this.vPos[i];
            }
        }

        return -1;
    }

    public void remanejar(int pos) {
        vLig[tl + 1] = vLig[tl];
        for (int i = tl; i > pos; i--) {
            vInfo[i] = vInfo[i - 1];
            vPos[i] = vPos[i - 1];
            vLig[i] = vLig[i - 1];
        }
    }

    public void remanejarExclusao(int pos) {
//        if(pos==tl)
//        {
//            this.vLig[tl-1]=null;    
//        }
//        else

        for (int i = pos; i < tl - 1; i++) //-1?
        {
            vInfo[i] = vInfo[i + 1];
            vPos[i] = vPos[i + 1];
            vLig[i] = vLig[i + 1];
        }
        //vLig[tl-1]=vLig[tl];

    }

    public void desmaneja(int pos) {
        //Lig[tl+1]= Lig[tl];
        for (int i = pos; i < tl; i++) {
            vInfo[i] = vInfo[i + 1];
            vPos[i] = vPos[i + 1];
            vLig[i] = vLig[i + 1];

        }
    }
}
