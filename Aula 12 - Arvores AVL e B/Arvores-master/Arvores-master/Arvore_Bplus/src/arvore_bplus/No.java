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
public class No {

    private int[] vInfo;
    private int[] vPos;
    private No[] vLig;
    public static int N = 5;
    private int tl;
    private No ant;
    private No prox;

    public No() {
        vInfo = new int[N];
        vPos = new int[N];
        vLig = new No[N + 1];
        ant = prox = null;
        tl = 0;
    }

    public No(int info) {
        vInfo = new int[N];
        vPos = new int[N];
        vLig = new No[N + 1];
        ant = prox = null;

        vInfo[0] = info;
        tl = 1;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public int getVInfo(int pos) {
        return vInfo[pos];
    }

    public void setVInfo(int pos, int info) {
        vInfo[pos] = info;
    }

    public int getVPos(int pos) {
        return vPos[pos];
    }

    public void setVPos(int pos, int info) {
        vPos[pos] = info;
    }

    public No getVLig(int pos) {
        return vLig[pos];
    }

    public void setVLig(int pos, No no) {
        vLig[pos] = no;
    }

    public int getTl() {
        return tl;
    }

    public void remaneja(int pos) {
        vLig[tl + 1] = vLig[tl];
        for (int i = tl; i > pos; i--) {
            vInfo[i] = vInfo[i - 1];
            vPos[i] = vPos[i - 1];
            vLig[i] = vLig[i - 1];
        }
    }

    public void setTl(int tl) {
        this.tl = tl;
    }

    public int buscaPos(int info) {
        int i = 0;
        while (i < tl && info > vInfo[i]) {
            i++;
        }
        return i;
    }

}
