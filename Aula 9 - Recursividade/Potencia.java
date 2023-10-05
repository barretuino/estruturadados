package edu.senac.aula05;

public class Potencia {

	public static void main(String[] args) {
		System.out.println("Valor da potência:" + potencia(5, 3));
	}

	public static int potencia(int base, int expoente) {
		if (expoente == 0)
			return 1;
		else {
			int valor = base * potencia(base, expoente - 1);
			System.out.println(valor);
			return valor;
		}
	}

}
