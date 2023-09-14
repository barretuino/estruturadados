public class Pilha {
    private int maxSize;        // Tamanho máximo da pilha
    private int[] stackArray;   // Um array para armazenar os elementos da pilha
    private int top;            // Índice do topo da pilha

    // Construtor da classe Pilha, inicializa a pilha com um tamanho máximo
    public Pilha(int size) {
        maxSize = size;
        stackArray = new int[maxSize];  // Inicializa o array com o tamanho máximo
        top = -1;                       // Inicializa o topo como -1 (pilha vazia)
    }

    // Método para empilhar um elemento na pilha
    public void push(int value) {
        if (top < maxSize - 1) {   // Verifica se a pilha não está cheia
            stackArray[++top] = value;  // Incrementa o topo e insere o valor
        }
    }

    // Método para desempilhar um elemento da pilha
    public int pop() {
        if (top >= 0) {  // Verifica se a pilha não está vazia
            return stackArray[top--];  // Retorna o valor no topo e decrementa o topo
        } else {
            return -1;  // Retorna -1 para indicar que a pilha está vazia
        }
    }

    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return top == -1;  // A pilha está vazia se o topo for igual a -1
    }
}
