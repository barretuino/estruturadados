package codFonte;

public class Fila<E> {

    private NoFila ini;

    public Fila() {
        ini = null;
    }

    public void enfileira(E info) {
        NoFila novo = new NoFila<>(info);
        if (isEmpty()) {
            ini = novo;
        } else {
            NoFila aux = ini;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novo);
        }
    }

    public E retira() {
        if (isEmpty()) {
            return null;
        }
        NoFila aux = ini;
        ini = ini.getProx();
        return (E) aux.getInfo();
    }

    public boolean isEmpty() {
        return ini == null;
    }
}
