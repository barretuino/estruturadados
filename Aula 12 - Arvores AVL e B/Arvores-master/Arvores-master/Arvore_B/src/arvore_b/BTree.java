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
public class BTree {

    private int m = 2;

    private No raiz;

    public BTree() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public No findNo(int info) {
        No aux = raiz;
        int pos = aux.procurarPosicao(info);

        while (info != aux.getVinfo(pos) && aux.getVlig(0) != null) {
            for (int i = 0; i < aux.getTL(); i++) {
                if (aux.getVinfo(pos) < info) {
                    pos++;
                }
            }
            aux = aux.getVlig(pos);
        }
        return aux;
    }

    public void inOrdem(No no) {
        if (no != null) {
            for (int i = 0; i < no.getTL(); i++) {
                inOrdem(no.getVlig(i));
                System.out.print(no.getVinfo(i) + " ");
            }
            inOrdem(no.getVlig(no.getTL()));
        }
    }

    public void split(No folha, No pai) {
        No cx1 = new No();
        No cx2 = new No();

        for (int i = 0; i < m; i++) {
            cx1.setVinfo(i, folha.getVinfo(i));
            cx1.setVPos(i, folha.getVPos(i));
            cx1.setVlig(i, folha.getVlig(i));
        }
        cx1.setVlig(m, folha.getVlig(m));
        cx1.setTL(m);
        for (int i = m + 1; i < 2 * m + 1; i++) {
            cx2.setVinfo(i - m - 1, folha.getVinfo(i));
            cx2.setVPos(i - m - 1, folha.getVPos(i));
            cx2.setVlig(i - m - 1, folha.getVlig(i));
        }
        cx2.setVlig(m, folha.getVlig(2 * m + 1));
        cx2.setTL(m);
        if (folha == pai) {
            folha.setVinfo(0, folha.getVinfo(m));
            folha.setVPos(0, folha.getVPos(m));
            folha.setVlig(0, cx1);
            folha.setVlig(1, cx2);
            folha.setTL(1);
        } else {
            int pos = pai.procurarPosicao(folha.getVinfo(m));
            pai.remanejar(pos);
            pai.setVinfo(pos, folha.getVinfo(m));
            pai.setVPos(pos, folha.getVPos(m));
            pai.setVlig(pos, cx1);
            pai.setVlig(pos + 1, cx2);
            pai.setTL(pai.getTL() + 1);
            if (pai.getTL() > 2 * m) {
                folha = pai;
                pai = findPai(folha, pai.getVinfo(0));
                split(folha, pai);
            }
        }
    }

    public void insere(int info, int posArq) {
        if (raiz == null) {
            raiz = new No(info, posArq);
        } else {
            No folha, pai;
            int pos;

            folha = findFolha(info);

            pos = folha.procurarPosicao(info);

            folha.remanejar(pos);

            folha.setVinfo(pos, info);
            folha.setVPos(pos, posArq);
            folha.setTL(folha.getTL() + 1);

            if (folha.getTL() > 2 * m) {
                pai = findPai(folha, info);
                split(folha, pai);
            }
        }
    }

    public No findFolha(int info) {
        No ax = raiz;
        int i = 0;
        
        while (ax.getVlig(0) != null) {
            i = 0;
            while (i < ax.getTL() && info > ax.getVinfo(i)) {
                i++;
            }
            ax = ax.getVlig(i);
        }
        return ax;
    }

    public No findFolhaExclusao(int info) {
        int i;
        No aux = raiz;
        
        while (aux.getVlig(0) != null) {
            i = 0;
            while (i < aux.getTL() && info > aux.getVinfo(i)) {
                i++;
            }
            if (info == aux.getVinfo(i)) {
                return aux;
            } else {
                aux = aux.getVlig(i);
            }
        }
        return aux;
    }

    public No findSubE(No no) {
        No esq = no.getVlig(0);
        while (esq.getVlig(esq.getTL()) != null) {
            esq = esq.getVlig(esq.getTL());
        }

        return esq;
    }

    public No findSubD(No no) {
        No dir = no.getVlig(no.getTL());
        while (dir.getVlig(0) != null) {
            no = no.getVlig(0);
        }

        return dir;
    }

    private void fusao(No no, No pai, int pos) {
        No vizinho;
        No caixa = new No();
        if (pos == 0) {
            vizinho = pai.getVlig(pos + 1);
            int i;
            for (i = 0; i < no.getTL(); i++) {
                caixa.setVinfo(i, no.getVinfo(i));
                caixa.setVPos(i, no.getVPos(i));
                caixa.setVlig(i, no.getVlig(i));
                caixa.setTL(caixa.getTL() + 1);
            }
            caixa.setVlig(i, no.getVlig(i));

            caixa.setVinfo(i, pai.getVinfo(pos));
            no.setVPos(no.getTL(), pai.getVPos(pos));
            pai.remanejarExclusao(pos);
            pai.setTL(pai.getTL() - 1);
            caixa.setTL(caixa.getTL() + 1);
            i++;

            int j;
            for (j = 0; j < vizinho.getTL(); j++) {
                caixa.setVinfo(i, vizinho.getVinfo(j));
                caixa.setVPos(i, caixa.getVPos(j));
                caixa.setVlig(i, vizinho.getVlig(j));
                caixa.setTL(caixa.getTL() + 1);
                i++;
            }
            caixa.setVlig(i, vizinho.getVlig(j));
        } else {
            vizinho = pai.getVlig(pos - 1);
            int i = 0;
            for (i = 0; i < vizinho.getTL(); i++) {
                caixa.setVinfo(i, vizinho.getVinfo(i));
                caixa.setVPos(i, caixa.getVPos(i));
                caixa.setVlig(i, vizinho.getVlig(i));
                caixa.setTL(caixa.getTL() + 1);
            }
            caixa.setVlig(i, no.getVlig(i));
            caixa.setVinfo(i, pai.getVinfo(pos - 1));
            no.setVPos(no.getTL(), pai.getVPos(pos - 1));
            caixa.setTL(caixa.getTL() + 1);
            pai.remanejarExclusao(pos - 1);
            pai.setTL(pai.getTL() - 1);
            i++;

            int j;
            for (j = 0; j < no.getTL(); j++) {
                caixa.setVinfo(i, no.getVinfo(j));
                caixa.setVPos(i, no.getVPos(j));
                caixa.setVlig(i, no.getVlig(j));
                caixa.setTL(caixa.getTL() + 1);
                i++;
            }
            caixa.setVlig(i, no.getVlig(j));
        }

        if (pai.getTL() < m) {
            if (pai == raiz && pai.getTL() == 0) {
                pai = raiz = caixa;
            } else if (pai == raiz && pai.getTL() > 0) {
                pai.setVlig(pos, caixa);
            } else {
                pai.setVlig(pos, caixa);
                no = findFolhaExclusao(pai.getVinfo(0));
                pai = findPai(no, no.getVinfo(0));
                pos = pai.procurarPosicao(no.getVinfo(0));
                fusao(no, pai, pos);
            }
        } else {
            pai.setVlig(pos, caixa);
        }
    }

    private boolean redistribui(No no, No pai, int pos) {
        No vizinho;

        if (pos == 0) {
            vizinho = pai.getVlig(pos + 1);
            if (vizinho.getTL() > m) {
                no.setVinfo(no.getTL(), pai.getVinfo(pos));
                no.setVPos(no.getTL(), pai.getVPos(pos));
                no.setTL(no.getTL() + 1);

                pai.setVinfo(pos, vizinho.getVinfo(0));
                pai.setVPos(pos, vizinho.getVPos(0));

                vizinho.remanejarExclusao(0);
                vizinho.setTL(vizinho.getTL() - 1);
                return true;
            }
        } else {
            vizinho = pai.getVlig(pos - 1);
            if (vizinho.getTL() > m) {
                no.remanejar(0);
                no.setVinfo(0, pai.getVinfo(pos - 1));
                no.setVPos(0, pai.getVPos(pos - 1));
                no.setTL(no.getTL() + 1);

                pai.setVinfo(pos - 1, vizinho.getVinfo(vizinho.getTL() - 1));
                pai.setVPos(pos - 1, vizinho.getVPos(vizinho.getTL() - 1));

                vizinho.setTL(vizinho.getTL() - 1);
                return true;
            } else if (pos + 1 < pai.getTL() + 1) {
                vizinho = pai.getVlig(pos + 1);
                if (vizinho.getTL() > m) {
                    no.setVinfo(no.getTL(), pai.getVinfo(pos));
                    no.setVPos(no.getTL(), pai.getVPos(pos));
                    no.setTL(no.getTL() + 1);

                    pai.setVinfo(pos, vizinho.getVinfo(0));
                    pai.setVPos(pos, vizinho.getVPos(0));

                    vizinho.remanejarExclusao(0);
                    vizinho.setTL(vizinho.getTL() - 1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exclui(int info) {
        No no, pai;
        int i, pos;
        No subdir, subesq;
        if (raiz == null) {
            return false;
        } else {
            no = findFolhaExclusao(info);
            pos = no.procurarPosicao(info);
            if (no.getVinfo(pos) == info) {
                if (no.getVlig(0) != null) {
                    subdir = findSubD(no);
                    subesq = findSubE(no);

                    if (subesq.getTL() > m || subdir.getTL() <= m) {
                        no.setVinfo(pos, subesq.getVinfo(subesq.getTL() - 1));

                        no = subesq;
                        pos = subesq.getTL() + 1;
                    } else {
                        no.setVinfo(pos, subdir.getVinfo(0));

                        no = subdir;
                        pos = 0;
                    }
                }

                no.remanejarExclusao(pos);
                no.setTL(no.getTL() - 1);
                if (no.getTL() < m && no != raiz) {
                    pai = findPai(no, no.getVinfo(0));
                    pos = pai.procurarPosicao(no.getVinfo(0));
                    if (!redistribui(no, pai, pos)) {
                        fusao(no, pai, pos);
                    }
                }
                return true;
            }
            return false;
        }
    }

    public No findPai(No folha, int info) {
        No aux, pai;
        int i;
        aux = raiz;
        pai = aux;
        while (aux != folha) {
            i = 0;
            while (i < aux.getTL() && info > aux.getVinfo(i)) {
                i++;
            }
            pai = aux;
            aux = aux.getVlig(i);
        }
        return pai;
    }
}
