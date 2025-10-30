package codFonte;

public class NoFila<T> {

    private T info;
    private NoFila prox;

    public NoFila(T info, NoFila prox) {
        this.info = info;
        this.prox = prox;
    }

    public NoFila(T info) {
        this(info, null);
    }

    public NoFila() {
        this(null, null);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoFila getProx() {
        return prox;
    }

    public void setProx(NoFila prox) {
        this.prox = prox;
    }
}
