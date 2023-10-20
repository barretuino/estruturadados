#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<cstdlib>

struct no
{
  int item;
  struct no* esq;
  struct no* dir;
};
struct no* raiz;

void insere(struct no* &raiz, struct no *novo)
{ 
  //  printf("Valor da raiz: %i",raiz);
    if(raiz == (struct no*) NULL)
      raiz = novo;
    else
    {
      if(novo->item <= raiz->item)
        insere(raiz->esq, novo);
      else
        insere(raiz->dir, novo);
    }
  //  printf("Valor de novo: %i",novo);
    system("pause");
}
/* Impressão em Pré-Ordem (Visita a Raiz, Sub-Árvore da Esquerda e Sub-Árvore da Direita)*/
void preordem(struct no *raiz)
{
  if(raiz != (struct no*)NULL)
  {
    printf("%d - ", raiz->item);
    preordem(raiz->esq);
    preordem(raiz->dir);
  }
}
/* Impressão em Pós-Ordem (Visita Sub-Árvore da Esquerda, Raiz e Sub-Árvore da Direita)*/
void emordem(struct no *raiz)
{
   if(raiz != (struct no*) NULL)
   {
     emordem(raiz->esq);
     printf("%d - ",raiz->item);
     emordem(raiz->dir);
   }
}
/* Impressão em Em Ordem (Visita Sub-Árvore da Esquerda, Sub-Árvore da Direita e Raiz)*/
void posordem(struct no *raiz)
{
  if(raiz != (struct no*) NULL)
  {
    posordem(raiz->esq);
    posordem(raiz->dir);
    printf("%d - ",raiz->item);
  }
}

main()
{
  int op, num;
  struct no *novo;
  struct no *raiz = NULL;
  
  while(op != 5)
  {
    system("cls");
    printf("\nManipulacao de Arvores Binarias");
    printf("\nDigite 1 para Insercao");
    printf("\nDigite 2 para Caminhamento em Pre-Ordem(RED)");
    printf("\nDigite 3 para Caminhamento em Em Ordem(ERD)");
    printf("\nDigite 4 para Caminhamento em Pos-Ordem(EDR)");
    printf("\nDigite 5 para Sair");
    printf("\nEntre com a opcao desejada: ");
    scanf("%i",&op);
    
    switch(op)
    {
      case 1:
         novo =(struct no*)malloc(sizeof(struct no));
         printf("Entre com um numero inteiro: ");
         scanf("%i",&num);
         novo->item = num;
         novo->esq=NULL;
         novo->dir=NULL;
         insere(raiz, novo);
         break;
      case 2:
         preordem(raiz);
         getche();
         break;
      case 3:
         emordem(raiz);  
         getche();
         break;
      case 4:
         posordem(raiz);        
         getche();
         break;
    }  
  }
}
