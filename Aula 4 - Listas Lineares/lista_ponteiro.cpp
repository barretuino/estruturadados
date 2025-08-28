#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define MAX 5

struct lista
{
       int valor[MAX];
       int tamanho;
       int inicio;
}; 

void inicia(struct lista *umaLista)
{
     umaLista->inicio = umaLista->tamanho = 0;
}

void insere_final(struct lista *l, int x)
{
   if(l->tamanho == MAX)
   {
      printf("\nLista cheia!");
      exit(1);
   }
   else
   {
       l->valor[l->tamanho] = x;
       l->tamanho++;
       printf("Elemento %i inserido com sucesso!",x);
    }
    getch();
}

int remove_final(struct lista *l)
{
   if(l->tamanho == 0)
   {
      printf("\nLista Vazia!");
      exit(1);
   }
   l->tamanho--;
   printf("Elemento %i removido com sucesso!",l->valor[l->tamanho]);
   return l->valor[l->tamanho];
   getche();
}       

void imprime_lista(struct lista *l)
{
   int v;
   int i;
   i = l->inicio;
   while(i != l->tamanho)
   {
      v = l->valor[i];
      printf("\nElemento %i da lista eh: %i",i,v);
      i++;
    }
   getch();
}

void busca(struct lista *l)
{
     int encontrou;
     int valor_procurado;
     int v;
     int i;
     i = l->inicio;
     printf("Entre com o valor que deseja buscar: ");
     scanf("%i",&valor_procurado);
     
     while(i != l->tamanho)        
     {
        v = l->valor[i];
        if(v == valor_procurado)
        {
           printf("Elemento %i encontrado na posicao %i",l->valor[i],i);
           encontrou = 1;
        }
        i++;
      }
      if(encontrou != 1)
        printf("Elemento %i nao encontrado",valor_procurado);
      getche();
}

int main()
{
    
    int op;
    int valor, retorno;
    struct lista umaLista;
    inicia(&umaLista);
   
    while(op != 5)
    {
      system("cls");
      printf("Manipulacao de Lista Estatica");
      printf("\nDigite 1 para Insercao no Final");
      printf("\nDigite 2 para Imprimir a Lista");
      printf("\nDigite 3 para Remover do Final");
      printf("\nDigite 4 para Buscar Elemento");
      printf("\nDigite 5 para Sair");
      printf("\nDigite a opcao desejada: ");
      scanf("%i",&op);
    
      switch(op)
      {
         case 1: 
              printf("Digite um valor para lista: ");
              scanf("%i",&valor);
              insere_final(&umaLista,valor);  
              break;
         case 2: 
              imprime_lista(&umaLista); 
              break;
         case 3: 
              retorno = remove_final(&umaLista);  
              break;
         case 4: 
              busca(&umaLista);         
              break;
         case 5: exit(1);
         default: printf("\nEntre com uma opcao valida!");
       }
     }
}


     
       
