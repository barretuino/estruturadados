package codFonte;

public class Patricia {

    private final NO raiz = new NO(false);
    private final char valChar;

    public Patricia() {
        valChar = 'a';
    }

    public void inserir(String palavra) {
        NO no = raiz;
        int i = 0;
        boolean flag = false;

        while (flag == false && i < palavra.length() && no.palavras[palavra.charAt(i) - valChar] != null) {
            int pos = palavra.charAt(i) - valChar, j = 0;
            StringBuilder rotulo = no.palavras[pos];

            while (j < rotulo.length() && i < palavra.length() && rotulo.charAt(j) == palavra.charAt(i)) {
                ++i;
                ++j;
            }

            if (j == rotulo.length()) {
                no = no.filhos[pos];
            } else 
            {
                if (i == palavra.length()) {  
                    NO filho = no.filhos[pos];
                    NO novoFilho = new NO(true);
                    StringBuilder sufixoRotulo = copiaString(rotulo, j);

                    rotulo.setLength(j);     
                    no.filhos[pos] = novoFilho;    
                    novoFilho.filhos[sufixoRotulo.charAt(0) - valChar] = filho;
                    novoFilho.palavras[sufixoRotulo.charAt(0) - valChar] = sufixoRotulo;
                } else {     
                    StringBuilder sufixoRotulo = copiaString(rotulo, j);
                    NO novoFilho = new NO(false);
                    StringBuilder sufixoPalavra = copiaString(palavra, i);
                    NO temp = no.filhos[pos];

                    rotulo.setLength(j);
                    no.filhos[pos] = novoFilho;
                    novoFilho.palavras[sufixoRotulo.charAt(0) - valChar] = sufixoRotulo;
                    novoFilho.filhos[sufixoRotulo.charAt(0) - valChar] = temp;
                    novoFilho.palavras[sufixoPalavra.charAt(0) - valChar] = sufixoPalavra;
                    novoFilho.filhos[sufixoPalavra.charAt(0) - valChar] = new NO(true);
                }
                flag = true;
            }
        }
        if(flag == false)
        {
            if (i < palavra.length()) {   
                no.palavras[palavra.charAt(i) - valChar] = copiaString(palavra, i);
                no.filhos[palavra.charAt(i) - valChar] = new NO(true);
            } else {    
                no.finalPalavra = true;
            }
        }
    }
    
    private StringBuilder copiaString(CharSequence str, int pos) {
        StringBuilder strFinal = new StringBuilder(100);

        while (pos != str.length()) {
            strFinal.append(str.charAt(pos++));
        }

        return strFinal;
    }

    public void exibir() {
        print(raiz, new StringBuilder());
    }

    private void print(NO no, StringBuilder s) {
        if (no.finalPalavra) {
            System.out.println(s);
        }

        for (int i = 0; i < no.palavras.length; ++i) {
            if (no.palavras[i] != null) {
                int length = s.length();

                s = s.append(no.palavras[i]);
                print(no.filhos[i], s);
                s = s.delete(length, s.length());
            }
        }
    }

    public void exibeNiveis() {
        Fila<NO> f = new Fila<>();
        NO aux = raiz;

        f.enfileira(aux); 
        while (!f.isEmpty()) {
            aux = f.retira();
            
            for (int i = 0; i < aux.palavras.length; i++) {
                if (aux.palavras[i] != null) {
                    System.out.print(" "+aux.palavras[i]);                    
                }                
            }       
            
             for (int i = 0; i < aux.filhos.length; i++) {
                if (aux.filhos[i] != null) {
                    f.enfileira(aux.filhos[i]);
                    
                }
            }  
        }
    }
}
