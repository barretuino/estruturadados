public class MaiorValor {

	public static void main(String[] args) {
		int vetor[] = { 3, 7, 8, 5, 10, 22, 7, 21, 14, 20, 31, 2, 1, 12 };
		System.out.println("Maior valor: " + max(vetor, 0, vetor.length));
	}

	static int maior = 0;

	public static int max(int vetor[], int i, int tamanho) {
		if (tamanho == i)
			return maior;
		else {
			if (vetor[i] > maior) {
				maior = vetor[i];
			}
			return max(vetor, ++i, tamanho);
		}
	}
}
