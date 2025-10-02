public class FatorialRecursiva {

	public static void main(String[] args) {
		int fatorial;
		fatorial = fatorial(5);
		System.out.println("Fatorial: "+ fatorial);
		
	}
	
	public static int fatorial(int fat) {
		if(fat <= 1) return 1;
		else return fat * fatorial(--fat);
	}
}
