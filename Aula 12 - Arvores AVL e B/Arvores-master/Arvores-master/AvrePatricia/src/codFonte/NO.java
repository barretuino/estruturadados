package codFonte;

public class NO {

    private final static int letras = 26;
    NO[] filhos = new NO[letras];
    StringBuilder[] palavras = new StringBuilder[letras];
    boolean finalPalavra;

    public NO(boolean finalPalvra) {
        this.finalPalavra = finalPalvra;
    }
}
