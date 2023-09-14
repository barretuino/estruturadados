/*
	Disciplina de Estrutura de Dados
	Professor Paulo Barreto
	Pilhas
*/

#include<stdio.h>
#include<stdlib.h>

#define MAX_ELEMENTOS 100

struct pilha {
	char elementos[MAX_ELEMENTOS];
	int topo;
};

struct pilha *criar() {
	struct pilha *p;
	p = malloc(sizeof(struct pilha));
	if (!p)
		exit(1); // Erro ao alocar memoria
	p->topo = 0;

	return p;
}

void empilhar(struct pilha *p, char c) {
	p->elementos[p->topo] = c; // Insere caractere no topo
	p->topo++; // Incrementa topo
}

char desempilhar(struct pilha *p) {
	p->topo--; // Decrementa topo
	return p->elementos[p->topo];
}

int tamanho_pilha(struct pilha *p) {
	return p->topo;
}

void destruir(struct pilha *p) {
	free(p);
}

int main() {
	struct pilha *minha_pilha;
	int tamanho;

	minha_pilha = criar();
	empilhar(minha_pilha, 'a');
	empilhar(minha_pilha, 'b');
	empilhar(minha_pilha, 'c');
	tamanho = tamanho_pilha(minha_pilha);
	printf("Desempilhando elementos \n");
	for (int i = 0; i < tamanho; i++) {
		printf("%c \n", desempilhar(minha_pilha));
	}
	destruir(minha_pilha);

	return 0;
}
