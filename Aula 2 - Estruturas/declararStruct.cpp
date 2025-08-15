#include <stdio.h>
#include <stdlib.h>

/**
  Aula 2 - Estruturas de Dados
  Prof. Paulo Barreto
  Data: 14/08/2025  **/

//Declaracao de uma Estrutura
struct Data{
	int dia, mes, ano;
};
struct Aluno{
	int ra;
	struct Data dataNascimento;
	char nome[50];
	float notas[5];
}; 

main(){
	struct Aluno voce;
	
	//Entrada de Dados
	printf("Informe o ra do aluno ");
	scanf("%i", &voce.ra);
	printf("Informe o nome do aluno ");
	scanf("%s", &voce.nome);
	printf("Informe a data de nascimento (dd/mm/yyyy) ");
	scanf("%i %i %i", &voce.dataNascimento.dia,
					  &voce.dataNascimento.mes,
					  &voce.dataNascimento.ano);
	
	for(int i=0; i<5; i++){
		printf("Informe a nota %i do aluno ", i+1);
		scanf("%f", &voce.notas[i]);
	}
	
	//Saida dos dados
	printf("O Aluno e %s \n", voce.nome);
	printf("O RA do aluno e %i \n", voce.ra);
	printf("Sua data de nascimento e %i/%i/%i\n",
						voce.dataNascimento.dia,
						voce.dataNascimento.mes,
						voce.dataNascimento.ano);
	float media = 0;
	for(int i=0; i<5; i++){
		printf("A nota %i do aluno e %.2f\n", i+1, voce.notas[i]);
	    media += voce.notas[i];
	}
	printf("A media obtida pelo aluno e %.2f \n", media/5);
}
