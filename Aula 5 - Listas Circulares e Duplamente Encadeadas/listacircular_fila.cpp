/* Lista Circular utilizando Fila*/

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct no{
  int info;
  struct no *prox;
};

struct no* insere(struct no **fila, int x){
  struct no *novo;
  novo = (struct no*)malloc(sizeof(struct no));
  novo->info = x;
  if(*fila == NULL)
    *fila = novo;
  else
    novo->prox = (*fila)->prox;
  (*fila)->prox = novo;
  *fila = novo;
}

int remove(struct no **fila)
{
  int x;
  struct no *aux;
  if(*fila == NULL)
  {
    printf("Fila Vazia\n");
    return (-1);
  } 
  else
  {
    aux = (*fila)->prox;
    x = aux->info;
    if(aux == *fila)
      //somente um nó da fila
      *fila = NULL;
    else
      (*fila)->prox = aux->prox;
    free(aux);
    return(x);
  }
}

int main()
{
  int x, op, retorno;
  struct no *fila;
  fila = NULL;
  
  while(op!=3)
  {
    system("cls");
    printf("\nManipulação de Lista Circular usando Fila");
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
           insere(&fila, x);
           break;
           retorno = remove(&fila);
           if(retorno != -1)
      case 2:
             printf("\nO valor de retorno foi: %d",retorno);
           else
             printf("\nTentou remover de uma Fila vazia");
           getch();
           break;
      case 3:
           exit(1); 
     }
   }
}
