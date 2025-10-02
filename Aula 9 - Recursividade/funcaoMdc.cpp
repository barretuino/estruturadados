#include <stdio.h>
#include <stdlib.h>
/**
	Exemplo de função recursiva
	Função mdc
	Prof. Paulo Barreto
	Data 05/10/2023
**/
int mdc (int p, int q) {
	if (q == 0) {
		return p; //caso base
	}else {
		return mdc(q, p % q); //passo de redução
	}
}

int main(){
	int valorP, valorQ;
	
	printf("Informe o valor de P ");
	scanf("%i", &valorP);
	printf("Informe o valor de Q ");
	scanf("%i", &valorQ);
	
	int resultado = mdc(valorP, valorQ);
	printf("O MDC de %i e %i e' %i\n", valorP, valorQ, resultado);
	system("PAUSE");
}

