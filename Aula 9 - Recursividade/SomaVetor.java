public class SomaVetor {

	public static void main(String[] args) {
		int somaVetor[] = { 8, 0, 1, 3, 5};
		System.out.println(soma(somaVetor, 5));
	}

	public static int soma(int v[], int n) {
		if (n == 0)
			return 0;
		else {
			int s = soma(v, n - 1);
			if (v[n - 1] > 0)
				s += v[n - 1];
			return s;
		}
	}

}
