/* Lista Circular utilizando Pilha */

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct no
{
  int info;
  struct no *prox;
};

struct no* push(struct no **pilha, int x)
{
  struct no *novo;
  novo = (struct no*)malloc(sizeof(struct no));
  novo->info = x;
  if(*pilha == NULL)
    *pilha = novo;
  else
    novo->prox = (*pilha)->prox;
  (*pilha)->prox = novo;
}

int pop(struct no **pilha)
{
  int x;
  struct no *aux;
  if(*pilha == NULL)
  {
    printf("Underflow da pilha\n");
    return (-1);
  }
  else
  { 
     aux = (*pilha)->prox;
     x = aux->info;
     if(aux == *pilha)
       //somente um nó na pilha
       *pilha = NULL;
     else
       (*pilha)->prox = aux->prox;
     free(aux);
     return(x);
  }
}

main()
{
  int x, op, retorno;
  struct no *pilha;
  pilha = NULL;
  
  while(op!=3)
  {
    system("cls");
    printf("\nManipulação de Lista Circular usando Pilha");
    printf("\nDigite 1 para inserir");
    printf("\nDigite 2 para excluir");
    printf("\nDigite 3 para sair");
    printf("\nEntre com uma opcao: ");
    scanf("%i",&op);
    
    switch(op)
    {
      case 1:
           printf("Entre com um valor inteiro: ");
           scanf("%i",&x);
           push(&pilha, x);
           break;
      case 2:
           retorno = pop(&pilha);
           if(retorno != -1)
             printf("\nO elemento removido foi %d",retorno);
           else
             printf("\nTentou remover de uma pilha vazia");
           getche();
           break;
      case 3:
           exit(1); 
     }
   }
}
