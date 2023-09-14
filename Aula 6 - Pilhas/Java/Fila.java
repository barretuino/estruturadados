public class Fila {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int itemCount;

    public Fila(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        itemCount = 0;
    }

    public void insert(int value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = value;
        itemCount++;
    }

    public int remove() {
        int temp = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        itemCount--;
        return temp;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }
}
