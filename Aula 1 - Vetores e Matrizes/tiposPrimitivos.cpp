#include <stdio.h>
#include <stdlib.h>

//Declaracao de variavel global
double cotacao = 1.44;

main(){
	//Declaraçao de variável local
	int valor;
	float preco;
	char opcao;
	
	//Declaração com inicialização
	float venda = 2 * cotacao;
	float *ponteiro = &venda;
	
	printf("Valor de venda %.2f\n", venda);
	printf("Endereço da Variavel venda %d\n", &venda);
	printf("Utilizando o ponteiro %.2f\n", *ponteiro);
	printf("Endereço da Variavel ponteiro %d\n", &ponteiro);
	printf("Valor da Variavel ponteiro %d\n", ponteiro);
	
	system("PAUSE");
}
