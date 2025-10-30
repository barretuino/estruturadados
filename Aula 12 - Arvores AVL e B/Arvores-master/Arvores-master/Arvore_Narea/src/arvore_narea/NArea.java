package arvore_narea;

public class NArea {

    private No raiz;

    public NArea() {
        raiz = null;
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void inserir(int info) {
        if (raiz == null) {
            raiz = new No(info);
        } else {
            No aux = raiz;
            No ant = raiz;
            boolean inseriu = false;
            int pos = 0;

            while (aux != null && !inseriu) {
                pos = aux.buscarPos(info);

                if (aux.getTL() < (3 - 1)) { //tem espaço?
                    aux.remanejar(pos);
                    aux.setInfo(pos, info);
                    aux.setTL(aux.getTL() + 1);
                    inseriu = true;
                } else {
                    ant = aux;
                    aux = aux.getVLig(pos);
                }
            }
            if (!inseriu) {
                ant.setVlig(pos, new No(info));
            }
        }
    }
    
    
    public void exibeCall(No no)
    {
        if(no != null)
        {
            for (int i = 0; i < no.getTL(); i++) 
            {
                exibeCall(no.getVLig(i));
                System.out.println(no.getInfo(i));
            }
            exibeCall(no.getVLig(no.getTL()));
        }
    }
    
    public void exibe()
    {
        exibeCall(raiz);
    }  
    
    
    public void print(int pos)
    {
        raiz.mostrainfo(pos);
    }
}
