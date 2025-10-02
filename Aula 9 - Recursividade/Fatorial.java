public class Fatorial {

	public static void main(String[] args) {
		System.out.println("Valor do fatorial:" + fatorial(6));
	}

	public static int fatorial(int valor) {
		if (valor == 0)
			return 1;
		else {
			valor = (valor * fatorial(valor - 1));	
			System.out.println(valor);
			return valor;
		}		
	}

}
