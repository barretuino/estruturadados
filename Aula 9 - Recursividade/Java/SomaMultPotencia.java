public class SomaMultPotencia {
	public static int somar(int a, int b) {
		if (b == 0)return a;
		else return somar(++a, --b);
	}
	
	public static int mult(int a, int b) {
		if(b==0) return 0;
		if(b==1) return a;
		else return somar(a, mult(a, --b));
		
	}
	
	public static int potencia(int a, int pot) {
		if(pot==0) return 1;
		if(pot == 1) return a;
		else return mult(a, potencia(a, --pot));
	}
	public static void main(String[] args) {

		int s = somar(7, 2);
		int m = mult(7, 2);
		int p = potencia(7,2);
		System.out.println("Soma: " + s);
		System.out.println("Multiplicação: " + m);
		System.out.println("Potenciação: " + p);
	}
}
