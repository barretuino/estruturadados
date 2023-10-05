public class BuscaBinaria {
	public static void main(String[] args) {
		int lista[] = { 1, 3, 5, 7, 8, 10, 11, 13, 15, 18, 20, 23, 25, 32, 34, 38 };
		int pos = buscaBinaria(lista, 0, lista.length - 1, 11);
		System.out.println("Posiçao: "+ pos);
	}

	public static int buscaBinaria(int[] lista, int inicio, int fim, int elemento) {
		int meio = (inicio + fim) / 2;
		
		if (inicio >= fim) return -1;
		if (elemento == lista[meio]) return meio;
		else if (elemento < lista[meio]) {
			fim = meio;
			return buscaBinaria(lista, inicio - 1, fim, elemento);
		}
		else {
			inicio = meio;
			return buscaBinaria(lista, inicio + 1, fim, elemento);
		}
	}
}
