#include <stdio.h>
#include <stdlib.h>

#define escreve(texto) printf("%s", &texto);

/**
   Definição de Estruturas em C
   Prof. Ms. Paulo Barreto
   Data 14/08/2025
**/
typedef struct Data{
	int dia, mes, ano;
};
typedef struct Aluno{
	int ra;
	char nome[50];
	float nota;
	Data dataNascimento;
};

main(){
	Aluno sala[10];
	Aluno voce;
	Aluno ele;
	
	voce.ra = 687532;
	ele.ra = 753951;
	
	voce.dataNascimento.dia = 10;
	voce.dataNascimento.mes = 7;
	voce.dataNascimento.ano = 2002;
	
	escreve("Seja Bem Vindo");
}
