public class ValorMaximo {
	
	public static void main(String[] args) {
		int vetor[] = { 2, 1, 10, 6, 1, 9, 1, 15, 0, 3 };
		System.out.println(maximoVetor(vetor, 10));
	}
	
	public static int maximoVetor(int v[], int n) {
		if (n == 1)
			return v[0];
		else {
			int x;
			x = maximoVetor(v, n-1);
			if (x > v[n-1])
				return x;
			else
				return v[n-1];
		}
	}

}
